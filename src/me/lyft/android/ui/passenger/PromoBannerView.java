package me.lyft.android.ui.passenger;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.analytics.studies.RideAnalytics;
import me.lyft.android.application.requestridetypes.IRideTypeMetaService;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.deeplinks.DeepLink;
import me.lyft.android.deeplinks.DeepLinkManager;
import me.lyft.android.domain.passenger.ridetypes.RideTypeBanner;
import me.lyft.android.rx.IRxBinder;
import me.lyft.android.rx.ReactiveProperty;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.Dialogs.InAppNotificationDialog;
import me.lyft.android.utils.Colors;
import rx.Observable;
import rx.functions.Action1;

public class PromoBannerView
  extends FrameLayout
{
  private ReactiveProperty<String> actionDeepLinkSubject = ReactiveProperty.create("");
  private ReactiveProperty<String> bannerTextSubject = ReactiveProperty.create("");
  TextView bannerTextView;
  private Observable<Boolean> canClickBanner = Observable.combineLatest(notificationUrlSubject, actionDeepLinkSubject, new PromoBannerView.1(this));
  @Inject
  DeepLinkManager deepLinkManager;
  @Inject
  DialogFlow dialogFlow;
  private ReactiveProperty<String> notificationUrlSubject = ReactiveProperty.create("");
  private final Action1<Boolean> onClickBehaviorChange = new PromoBannerView.4(this);
  private final Action1<String> onPromoBannerTextChange = new PromoBannerView.3(this);
  private final Action1<Unit> onUpdateBanner = new PromoBannerView.2(this);
  @Inject
  IRideRequestSession rideRequestSession;
  @Inject
  IRideTypeMetaService rideTypeMetaService;
  final IRxBinder rxBinder = new RxUIBinder();
  
  public PromoBannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    Scoop.fromView(this).inflater(getContext()).inflate(2130903420, this, true);
  }
  
  private void applyStyles(RideTypeBanner paramRideTypeBanner)
  {
    setBackgroundColor(Colors.parseColor(paramRideTypeBanner.getBannerColor(), getResources().getColor(2131493083)));
    bannerTextView.setTextColor(Colors.parseColor(paramRideTypeBanner.getTextColor(), getResources().getColor(2131493061)));
  }
  
  private void openNotificationUrl(String paramString)
  {
    paramString = new Dialogs.InAppNotificationDialog(paramString);
    if (!dialogFlow.hasActiveDialog()) {
      dialogFlow.show(paramString);
    }
  }
  
  private void performDeepLink(String paramString)
  {
    deepLinkManager.tryHandleDeepLink(new DeepLink(paramString));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    rxBinder.attach();
    rxBinder.bindAction(rideTypeMetaService.observeBannersChanged(), onUpdateBanner);
    rxBinder.bindAction(rideRequestSession.observeCurrentRideType().map(Unit.func1()), onUpdateBanner);
    rxBinder.bindAction(bannerTextSubject, onPromoBannerTextChange);
    rxBinder.bindAction(canClickBanner, onClickBehaviorChange);
  }
  
  protected void onDetachedFromWindow()
  {
    rxBinder.detach();
    super.onDetachedFromWindow();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
  }
  
  public boolean performClick()
  {
    String str1 = (String)actionDeepLinkSubject.get();
    String str2 = (String)notificationUrlSubject.get();
    if (!Strings.isNullOrEmpty(str1))
    {
      RideAnalytics.trackPromoBannerTapped(str1);
      performDeepLink(str1);
    }
    for (;;)
    {
      return true;
      if (!Strings.isNullOrEmpty(str2))
      {
        RideAnalytics.trackPromoBannerTapped(str2);
        openNotificationUrl(str2);
      }
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.PromoBannerView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */