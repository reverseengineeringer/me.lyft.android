package me.lyft.android.ui.driver.achievements;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.User;
import me.lyft.android.domain.driver.DriverActivities;
import me.lyft.android.domain.driver.DriverActivities.Type;
import me.lyft.android.ui.driver.DriverActivitiesView;
import me.lyft.android.ui.driver.ViewPagerTabLayout;

public class DriverEarningsRecentActivitiesWidget
  extends LinearLayout
{
  @Inject
  IConstantsProvider constantsProvider;
  TextView dailyTabButton;
  TextView statsDisclaimer;
  ViewPager statsPager;
  private StatsPagerAdapter statsPagerAdapter;
  ViewPagerTabLayout tabsLayout;
  @Inject
  IUserProvider userProvider;
  TextView weeklyTabButton;
  
  public DriverEarningsRecentActivitiesWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    setOrientation(1);
    Scoop.fromView(this).inflater(paramContext).inflate(2130903170, this, true);
  }
  
  public DriverActivitiesView getStatsView(DriverActivities.Type paramType)
  {
    return statsPagerAdapter.getStatsView(paramType);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
    statsPagerAdapter = new StatsPagerAdapter(getContext());
    statsPager.setAdapter(statsPagerAdapter);
    tabsLayout.setViewPager(statsPager);
    tabsLayout.selectTab(0);
    TextView localTextView = statsDisclaimer;
    if (userProvider.getUser().isApprovedDriver()) {}
    for (CharSequence localCharSequence = (CharSequence)constantsProvider.get(Constants.DRIVER_STATS_DISCLAIMER);; localCharSequence = getResources().getText(2131165594))
    {
      localTextView.setText(localCharSequence);
      return;
    }
  }
  
  public void setTabTitle(DriverActivities paramDriverActivities)
  {
    if (!Strings.isNullOrEmpty(paramDriverActivities.getTitle())) {}
    switch (DriverEarningsRecentActivitiesWidget.1.$SwitchMap$me$lyft$android$domain$driver$DriverActivities$Type[paramDriverActivities.getType().ordinal()])
    {
    default: 
      return;
    case 1: 
      dailyTabButton.setText(paramDriverActivities.getTitle());
      return;
    }
    weeklyTabButton.setText(paramDriverActivities.getTitle());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.achievements.DriverEarningsRecentActivitiesWidget
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */