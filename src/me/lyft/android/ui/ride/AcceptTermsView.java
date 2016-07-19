package me.lyft.android.ui.ride;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.HandleBack;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.terms.ITermsService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.User;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.MainScreens.AcceptTermsScreen;
import me.lyft.android.ui.MainScreensRouter;
import me.lyft.android.ui.WebBrowserView;

public class AcceptTermsView
  extends LinearLayout
  implements HandleBack
{
  Button acceptButton;
  @Inject
  AppFlow appFlow;
  @Inject
  DialogFlow dialogFlow;
  @Inject
  IViewErrorHandler errorHandler;
  boolean isToDriverFlow;
  @Inject
  MainScreensRouter mainScreensRouter;
  final MainScreens.AcceptTermsScreen params;
  @Inject
  IProgressController progressController;
  @Inject
  ITermsService termsService;
  Toolbar toolbar;
  TextView tosBannerView;
  @Inject
  IUserProvider userProvider;
  WebBrowserView webBrowserView;
  
  public AcceptTermsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    params = ((MainScreens.AcceptTermsScreen)Screen.fromView(this));
    isToDriverFlow = params.isToDriverFlow();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Binder localBinder = Binder.attach(this);
    localBinder.bind(toolbar.observeHomeClick(), new AcceptTermsView.1(this));
    tosBannerView.setVisibility(0);
    acceptButton.setVisibility(0);
    acceptButton.setOnClickListener(new AcceptTermsView.2(this, localBinder));
  }
  
  public boolean onBack()
  {
    return false;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
    toolbar.setTitle(getResources().getString(2131166366));
    toolbar.setHomeButtonEnabled(true);
    toolbar.setHomeIconVisible(true);
    toolbar.setHomeIcon(2130837507);
    webBrowserView.setTargetUrl(userProvider.getUser().getTermsUrl());
    if (isToDriverFlow) {
      acceptButton.setBackgroundResource(2130837588);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.ride.AcceptTermsView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */