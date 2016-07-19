package me.lyft.android.ui.passenger.v2.request.destination;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.common.Unit;
import me.lyft.android.ui.HeightObservableLayout;
import rx.Observable;
import rx.subjects.PublishSubject;

public class SetDestinationView
  extends RelativeLayout
  implements SetDestinationPresenter.SetDestinationView
{
  ImageButton backButton;
  final PublishSubject<Unit> backButtonClickSubject = PublishSubject.create();
  ProgressBar buttonProgressBar;
  ImageButton centerToCurrentLocationButton;
  final PublishSubject<Unit> centerToCurrentLocationClickSubject = PublishSubject.create();
  HeightObservableLayout containerBottom;
  HeightObservableLayout containerTop;
  final PublishSubject<Unit> destinationAddressClickSubject = PublishSubject.create();
  TextView destinationAddressView;
  TextView pickupAddressField;
  final PublishSubject<Unit> pickupAddressFieldClickSubject = PublishSubject.create();
  View pickupAddressFieldTapArea;
  Button setDestinationButton;
  final PublishSubject<Unit> setDestinationButtonClickSubject = PublishSubject.create();
  @Inject
  SetDestinationPresenter setDestinationPresenter;
  
  public SetDestinationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  public Observable<Unit> observeBackButtonClick()
  {
    return backButtonClickSubject.asObservable();
  }
  
  public Observable<Integer> observeBottomContainerHeight()
  {
    return containerBottom.observeHeightChange();
  }
  
  public Observable<Unit> observeCenterToCurrentLocationClick()
  {
    return centerToCurrentLocationClickSubject.asObservable();
  }
  
  public Observable<Unit> observeDestinationAddressClick()
  {
    return destinationAddressClickSubject.asObservable();
  }
  
  public Observable<Unit> observePickUpAddressFieldClick()
  {
    return pickupAddressFieldClickSubject.asObservable();
  }
  
  public Observable<Unit> observeSetDestinationButtonClick()
  {
    return setDestinationButtonClickSubject.asObservable();
  }
  
  public Observable<Integer> observeTopContainerHeight()
  {
    return containerTop.observeHeightChange();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    setDestinationPresenter.attachView(this);
  }
  
  protected void onDetachedFromWindow()
  {
    setDestinationPresenter.detachView(this);
    super.onDetachedFromWindow();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
    pickupAddressFieldTapArea.setOnClickListener(new SetDestinationView.1(this));
    setDestinationButton.setOnClickListener(new SetDestinationView.2(this));
    centerToCurrentLocationButton.setOnClickListener(new SetDestinationView.3(this));
    destinationAddressView.setOnClickListener(new SetDestinationView.4(this));
    backButton.setOnClickListener(new SetDestinationView.5(this));
  }
  
  public void setDestinationAddress(String paramString)
  {
    destinationAddressView.setText(paramString);
  }
  
  public void setDestinationAddressLoading()
  {
    destinationAddressView.setText(getResources().getString(2131166019));
  }
  
  public void setDestinationAddressUnavailable()
  {
    destinationAddressView.setText(getResources().getString(2131165292));
  }
  
  public void setPickupAddress(String paramString)
  {
    pickupAddressField.setText(paramString);
  }
  
  public void setPickupAddressLoading()
  {
    pickupAddressField.setText(getResources().getString(2131166019));
  }
  
  public void setPickupAddressUnavailable()
  {
    pickupAddressField.setText(getResources().getString(2131165292));
  }
  
  public void showButtonProgressBar(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setDestinationButton.setText("");
      buttonProgressBar.setVisibility(0);
      return;
    }
    setDestinationButton.setText(2131166301);
    buttonProgressBar.setVisibility(8);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.request.destination.SetDestinationView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */