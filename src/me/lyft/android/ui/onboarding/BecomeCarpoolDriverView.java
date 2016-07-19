package me.lyft.android.ui.onboarding;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import com.lyft.widgets.PagingIndicator;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.settings.ISignUrlService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.rx.Binder;
import me.lyft.android.utils.WebBrowser;

public class BecomeCarpoolDriverView
  extends LinearLayout
{
  @Inject
  AppFlow appFlow;
  Button becomeCarpoolDriverButton;
  private Binder binder;
  @Inject
  IConstantsProvider constantsProvider;
  @Inject
  ILyftPreferences lyftPreferences;
  private final BecomeCarpoolDriverPagerAdapter pagerAdapter;
  PagingIndicator pagingIndicator;
  @Inject
  ISignUrlService signUrlService;
  Toolbar toolbar;
  ViewPager viewPager;
  @Inject
  WebBrowser webBrowser;
  
  public BecomeCarpoolDriverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    paramContext = (String)constantsProvider.get(Constants.CARPOOL_DRIVER_ONBOARDING_PAGE1_TITLE);
    paramAttributeSet = (String)constantsProvider.get(Constants.CARPOOL_DRIVER_ONBOARDING_PAGE2_TITLE);
    String str1 = (String)constantsProvider.get(Constants.CARPOOL_DRIVER_ONBOARDING_PAGE1_BODY);
    String str2 = (String)constantsProvider.get(Constants.CARPOOL_DRIVER_ONBOARDING_PAGE2_BODY);
    pagerAdapter = new BecomeCarpoolDriverPagerAdapter(new String[] { paramContext, paramAttributeSet }, new String[] { str1, str2 });
  }
  
  private void openWebOnboarding()
  {
    String str = lyftPreferences.getLyftWebRoot() + "/carpool/drive/apply";
    binder.bind(signUrlService.getSignedUrl(str), new BecomeCarpoolDriverView.3(this, str));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    binder = Binder.attach(this);
    becomeCarpoolDriverButton.setOnClickListener(new BecomeCarpoolDriverView.2(this));
    toolbar.setTitle(getResources().getString(2131165404));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
    pagingIndicator.setNumberOfViews(pagerAdapter.getCount());
    pagingIndicator.selectPosition(0);
    viewPager.setAdapter(pagerAdapter);
    viewPager.addOnPageChangeListener(new BecomeCarpoolDriverView.1(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.onboarding.BecomeCarpoolDriverView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */