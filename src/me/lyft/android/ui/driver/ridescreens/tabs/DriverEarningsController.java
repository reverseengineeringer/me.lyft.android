package me.lyft.android.ui.driver.ridescreens.tabs;

import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.analytics.core.ExperimentAnalytics;
import me.lyft.android.analytics.core.definitions.Experiment;
import me.lyft.android.analytics.studies.DriverAnalytics;
import me.lyft.android.analytics.studies.DriverStatsAnalytics;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.driver.IDriverStatsProvider;
import me.lyft.android.common.RxViewController;
import me.lyft.android.common.Strings;
import me.lyft.android.controls.DriverBottomNavigationView;
import me.lyft.android.controls.DriverBottomNavigationView.DriverTab;
import me.lyft.android.controls.DriverToolbar;
import me.lyft.android.controls.HorizontalCarouselView;
import me.lyft.android.domain.User;
import me.lyft.android.domain.driver.Card;
import me.lyft.android.domain.driver.DriverAchievements;
import me.lyft.android.domain.driver.DriverActivities;
import me.lyft.android.errorhandling.IDefaultErrorHandler;
import me.lyft.android.infrastructure.appboy.IAppboyService;
import me.lyft.android.infrastructure.device.IDevice;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.driver.DriverActivitiesView;
import me.lyft.android.ui.driver.ViewPagerTabLayout;
import me.lyft.android.ui.driver.achievements.StatsPagerAdapter;
import me.lyft.android.ui.driver.achievements.card.AchievementCardFactory;

public class DriverEarningsController
  extends RxViewController
{
  HorizontalCarouselView achievementCardCarouselView;
  private final AchievementCardFactory achievementCardFactory;
  private final IAppboyService appboyService;
  private final IConstantsProvider constantsProvider;
  TextView dailyTabButton;
  private final IDefaultErrorHandler defaultErrorHandler;
  private final IDevice device;
  private String disclaimer;
  DriverBottomNavigationView driverBottomNavigationView;
  private final IDriverStatsProvider driverStatsProvider;
  private List<String> footers = new ArrayList();
  private final IProgressController progressController;
  TextView statsDisclaimer;
  ViewPager statsPager;
  private StatsPagerAdapter statsPagerAdapter;
  TextView statsUnavailableBanner;
  ViewPagerTabLayout tabsLayout;
  DriverToolbar toolbar;
  private final IUserProvider userProvider;
  TextView weeklyTabButton;
  
  @Inject
  public DriverEarningsController(AchievementCardFactory paramAchievementCardFactory, IDefaultErrorHandler paramIDefaultErrorHandler, IConstantsProvider paramIConstantsProvider, IUserProvider paramIUserProvider, IDriverStatsProvider paramIDriverStatsProvider, IDevice paramIDevice, IAppboyService paramIAppboyService, IProgressController paramIProgressController)
  {
    achievementCardFactory = paramAchievementCardFactory;
    defaultErrorHandler = paramIDefaultErrorHandler;
    constantsProvider = paramIConstantsProvider;
    userProvider = paramIUserProvider;
    driverStatsProvider = paramIDriverStatsProvider;
    device = paramIDevice;
    appboyService = paramIAppboyService;
    progressController = paramIProgressController;
  }
  
  private void addFooter(String paramString)
  {
    footers.add(paramString);
    TextView localTextView;
    if ((footers.size() == 1) && (statsDisclaimer != null))
    {
      localTextView = statsDisclaimer;
      if (!Strings.isNullOrEmpty(paramString)) {
        break label60;
      }
    }
    label60:
    for (int i = 8;; i = 0)
    {
      localTextView.setVisibility(i);
      statsDisclaimer.setText(paramString);
      return;
    }
  }
  
  private void loadDriverStats()
  {
    progressController.showProgress();
    binder.bindAsyncCall(driverStatsProvider.getDriverAchievements(userProvider.getUser().getId()), new DriverEarningsController.2(this));
  }
  
  private void onDriverStatsLoaded(DriverAchievements paramDriverAchievements)
  {
    Object localObject1 = paramDriverAchievements.getActivities().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (DriverActivities)((Iterator)localObject1).next();
      DriverActivitiesView localDriverActivitiesView = statsPagerAdapter.getStatsView(((DriverActivities)localObject2).getType());
      if (localDriverActivitiesView != null)
      {
        localDriverActivitiesView.displayStats((DriverActivities)localObject2);
        setTabTitle((DriverActivities)localObject2);
      }
    }
    paramDriverAchievements = paramDriverAchievements.getCards();
    if (paramDriverAchievements.isEmpty()) {
      achievementCardCarouselView.setVisibility(8);
    }
    paramDriverAchievements = paramDriverAchievements.iterator();
    while (paramDriverAchievements.hasNext())
    {
      localObject1 = (Card)paramDriverAchievements.next();
      localObject2 = achievementCardFactory.create((Card)localObject1, getView().getContext());
      if (localObject2 != null)
      {
        ((View)localObject2).setLayoutParams(new ViewGroup.LayoutParams(device.getScreenWidth().intValue() - getResources().getDimensionPixelSize(2131230866), -2));
        achievementCardCarouselView.addItem((View)localObject2);
        addFooter(((Card)localObject1).getFooter());
      }
    }
  }
  
  private void setTabTitle(DriverActivities paramDriverActivities)
  {
    if (!Strings.isNullOrEmpty(paramDriverActivities.getTitle())) {}
    switch (DriverEarningsController.3.$SwitchMap$me$lyft$android$domain$driver$DriverActivities$Type[paramDriverActivities.getType().ordinal()])
    {
    default: 
      return;
    case 1: 
      dailyTabButton.setText(paramDriverActivities.getTitle());
      return;
    }
    weeklyTabButton.setText(paramDriverActivities.getTitle());
  }
  
  protected int layoutId()
  {
    return 2130903171;
  }
  
  public void onAttach()
  {
    super.onAttach();
    statsPagerAdapter = new StatsPagerAdapter(getView().getContext());
    DriverAnalytics.trackDriverStatsShown();
    DriverStatsAnalytics.trackBonusExperiments();
    ExperimentAnalytics.trackExposure(Experiment.PY_DRIVER_EARNINGS);
    statsPagerAdapter = new StatsPagerAdapter(getView().getContext());
    statsPager.setAdapter(statsPagerAdapter);
    tabsLayout.setViewPager(statsPager);
    tabsLayout.selectTab(0);
    TextView localTextView;
    if (userProvider.getUser().isApprovedDriver())
    {
      loadDriverStats();
      binder.bindAction(achievementCardCarouselView.observeOnCarouselScrollToIndex(), new DriverEarningsController.1(this));
      disclaimer = ((String)constantsProvider.get(Constants.DRIVER_STATS_DISCLAIMER));
      localTextView = statsDisclaimer;
      if (!Strings.isNullOrEmpty(disclaimer)) {
        break label210;
      }
    }
    label210:
    for (int i = 8;; i = 0)
    {
      localTextView.setVisibility(i);
      statsDisclaimer.setText(disclaimer);
      DriverStatsAnalytics.displayDriverStatsView();
      driverBottomNavigationView.setCurrentTab(DriverBottomNavigationView.DriverTab.EARNINGS);
      appboyService.enableInappNoteDisplay();
      return;
      onDriverStatsLoaded(DriverAchievements.empty());
      break;
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    DriverAnalytics.trackDriverStatsDismiss();
    footers.clear();
    appboyService.disableInappNoteDisplay();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.ridescreens.tabs.DriverEarningsController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */