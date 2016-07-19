package me.lyft.android.ui.driver.achievements;

import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.analytics.core.ExperimentAnalytics;
import me.lyft.android.analytics.core.definitions.Experiment;
import me.lyft.android.analytics.studies.DriverAnalytics;
import me.lyft.android.analytics.studies.DriverStatsAnalytics;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.driver.IDriverStatsProvider;
import me.lyft.android.common.RxViewController;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.User;
import me.lyft.android.domain.driver.Card;
import me.lyft.android.domain.driver.Dial;
import me.lyft.android.domain.driver.DriverAchievements;
import me.lyft.android.domain.driver.DriverActivities;
import me.lyft.android.domain.payment.Money;
import me.lyft.android.errorhandling.IDefaultErrorHandler;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.driver.DriverActivitiesView;
import me.lyft.android.ui.driver.achievements.card.AchievementCardFactory;
import me.lyft.android.ui.driver.expresspay.DriverEarningsExpressPayWidget;

public class DriverSettingsEarningsController
  extends RxViewController
{
  private AchievementCardFactory achievementCardFactory;
  LinearLayout achievementsContainer;
  private IDefaultErrorHandler defaultErrorHandler;
  private IDriverStatsProvider driverStatsProvider;
  DriverEarningsExpressPayWidget expressPay;
  private List<String> footers = new ArrayList();
  DriverEarningsRecentActivitiesWidget recentActivities;
  Toolbar toolbar;
  private IUserProvider userProvider;
  
  @Inject
  public DriverSettingsEarningsController(IDefaultErrorHandler paramIDefaultErrorHandler, IUserProvider paramIUserProvider, IDriverStatsProvider paramIDriverStatsProvider, AchievementCardFactory paramAchievementCardFactory)
  {
    defaultErrorHandler = paramIDefaultErrorHandler;
    userProvider = paramIUserProvider;
    driverStatsProvider = paramIDriverStatsProvider;
    achievementCardFactory = paramAchievementCardFactory;
  }
  
  private void onDriverStatsLoaded(DriverAchievements paramDriverAchievements)
  {
    Object localObject = paramDriverAchievements.getActivities().iterator();
    while (((Iterator)localObject).hasNext())
    {
      DriverActivities localDriverActivities = (DriverActivities)((Iterator)localObject).next();
      DriverActivitiesView localDriverActivitiesView = recentActivities.getStatsView(localDriverActivities.getType());
      if (localDriverActivitiesView != null)
      {
        localDriverActivitiesView.displayStats(localDriverActivities);
        recentActivities.setTabTitle(localDriverActivities);
      }
    }
    paramDriverAchievements = paramDriverAchievements.getCards().iterator();
    while (paramDriverAchievements.hasNext())
    {
      localObject = (Card)paramDriverAchievements.next();
      if (((Card)localObject).isExpressPayCard())
      {
        int i = ((Dial)((Card)localObject).getDials().get(0)).getValue();
        int j = ((Dial)((Card)localObject).getDials().get(0)).getMaxValue();
        expressPay.setVisibility(0);
        expressPay.setExpressPayAmount(Money.format(i));
        expressPay.setInfoUrl(((Card)localObject).getInfoUrl());
        expressPay.setFooter(((Card)localObject).getFooter());
        if (i < j)
        {
          expressPay.setDials(((Card)localObject).getDials());
          expressPay.setSubtitle(((Card)localObject).getSubTitle());
        }
        else
        {
          expressPay.showGetPaid(true);
        }
      }
      else
      {
        localObject = achievementCardFactory.create((Card)localObject, getView().getContext());
        if (localObject != null) {
          achievementsContainer.addView((View)localObject);
        }
      }
    }
  }
  
  protected int layoutId()
  {
    return 2130903196;
  }
  
  public void onAttach()
  {
    super.onAttach();
    DriverAnalytics.trackDriverStatsShown();
    DriverStatsAnalytics.trackBonusExperiments();
    ExperimentAnalytics.trackExposure(Experiment.PY_DRIVER_EARNINGS);
    toolbar.setTitle(getResources().getString(2131165593));
    binder.bindAsyncCall(driverStatsProvider.getDriverAchievements(userProvider.getUser().getId()), new DriverSettingsEarningsController.1(this));
    DriverStatsAnalytics.displayDriverStatsView();
  }
  
  public void onDetach()
  {
    binder.detach();
    DriverAnalytics.trackDriverStatsDismiss();
    footers.clear();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.achievements.DriverSettingsEarningsController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */