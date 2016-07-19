package me.lyft.android.ui.ridehistory;

import android.content.res.Resources;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lyft.scoop.Screen;
import com.squareup.picasso.RequestCreator;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.ridehistory.IPassengerRideHistoryService;
import me.lyft.android.application.settings.ISignUrlService;
import me.lyft.android.common.RxViewController;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.ridehistory.PassengerRideHistoryDetails;
import me.lyft.android.domain.ridehistory.PaymentBreakdown;
import me.lyft.android.domain.ridehistory.RideHistoryFeature;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.utils.WebBrowser;

public class PassengerRideHistoryDetailedView
  extends RxViewController
{
  View contentContainerView;
  private PassengerRideHistoryDetails details;
  ImageView driverPhotoImageView;
  Button findLostItemButton;
  TextView helpCenterTextView;
  @Inject
  ImageLoader imageLoader;
  @Inject
  ILyftPreferences lyftPreferences;
  @Inject
  IPassengerRideHistoryService passengerRideHistoryService;
  LinearLayout paymentBreakdownViewContainer;
  LinearLayout pickupOnly;
  TextView pricingFaqTextView;
  @Inject
  IProgressController progressController;
  Button requestReviewButton;
  Button retryButton;
  View retryView;
  TextView rideCancelChargeTextView;
  TextView rideDropoffAddressTextView;
  TextView rideDropoffTimeTextView;
  private String rideId;
  TextView ridePickupAddressTextView;
  TextView ridePickupOnlyAddressTextView;
  TextView ridePickupOnlyTimeTextView;
  TextView ridePickupTimeTextView;
  TextView rideSummaryTextView;
  TextView rideTotalTextView;
  LinearLayout routeBreakdown;
  ImageView routeMapImageView;
  @Inject
  ISignUrlService signUrlService;
  Button tipDriverButton;
  Toolbar toolbar;
  @Inject
  IViewErrorHandler viewErrorHandler;
  @Inject
  WebBrowser webBrowser;
  
  private void bindDetailsToView(PassengerRideHistoryDetails paramPassengerRideHistoryDetails)
  {
    details = paramPassengerRideHistoryDetails;
    initFeatureView(RideHistoryFeature.TIPS, tipDriverButton);
    initFeatureView(RideHistoryFeature.LOST_AND_FOUND, findLostItemButton);
    initFeatureView(RideHistoryFeature.PRICE_REVIEW, requestReviewButton);
    imageLoader.load(paramPassengerRideHistoryDetails.getDriverPhotoUrl()).centerCrop().fit().into(driverPhotoImageView);
    imageLoader.load(paramPassengerRideHistoryDetails.getMapImageUrl()).into(routeMapImageView);
    if (paramPassengerRideHistoryDetails.getRideFinalState().equals("cancelled"))
    {
      rideTotalTextView.setVisibility(8);
      rideSummaryTextView.setText(getResources().getString(2131165988, new Object[] { paramPassengerRideHistoryDetails.getDriverName() }));
      rideCancelChargeTextView.setText(paramPassengerRideHistoryDetails.getCancelPenaltyReason());
      ridePickupOnlyTimeTextView.setText(paramPassengerRideHistoryDetails.getPickupTime());
      ridePickupOnlyAddressTextView.setText(paramPassengerRideHistoryDetails.getPickupAddress());
      routeBreakdown.setVisibility(8);
      tipDriverButton.setVisibility(8);
      findLostItemButton.setVisibility(8);
    }
    for (;;)
    {
      Iterator localIterator = paramPassengerRideHistoryDetails.getPaymentsBreakdown().iterator();
      while (localIterator.hasNext())
      {
        PaymentBreakdown localPaymentBreakdown = (PaymentBreakdown)localIterator.next();
        paymentBreakdownViewContainer.addView(new PassengerRideHistoryPaymentBreakdownView(getView().getContext(), localPaymentBreakdown, paramPassengerRideHistoryDetails.getRideFinalState(), imageLoader));
      }
      rideTotalTextView.setText(paramPassengerRideHistoryDetails.getRideTotal());
      rideSummaryTextView.setText(getResources().getString(2131166003, new Object[] { paramPassengerRideHistoryDetails.getDriverName() }));
      rideCancelChargeTextView.setVisibility(8);
      pickupOnly.setVisibility(8);
      ridePickupTimeTextView.setText(paramPassengerRideHistoryDetails.getPickupTime());
      ridePickupAddressTextView.setText(paramPassengerRideHistoryDetails.getPickupAddress());
      rideDropoffTimeTextView.setText(paramPassengerRideHistoryDetails.getDropoffTime());
      rideDropoffAddressTextView.setText(paramPassengerRideHistoryDetails.getDropoffAddress());
    }
    toolbar.setTitle(paramPassengerRideHistoryDetails.getPickupDateTime());
  }
  
  private String getPricingFaqUrl()
  {
    return details.getPricingUrl();
  }
  
  private String getRideActionUrl(String paramString)
  {
    return lyftPreferences.getLyftWebRoot() + paramString + "/" + rideId + "?utm=ride_history_android";
  }
  
  private void initFeatureView(RideHistoryFeature paramRideHistoryFeature, View paramView)
  {
    if (details.isFeatureEnabled(paramRideHistoryFeature)) {}
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      return;
    }
  }
  
  private void loadRideDetails()
  {
    progressController.showProgress();
    contentContainerView.setVisibility(8);
    retryView.setVisibility(8);
    binder.bindAsyncCall(passengerRideHistoryService.getPassengerHistoryDetails(rideId), new PassengerRideHistoryDetailedView.8(this));
  }
  
  private void signUrlAndOpenBrowser(String paramString)
  {
    progressController.showProgress();
    binder.bindAsyncCall(signUrlService.getSignedUrl(paramString), new PassengerRideHistoryDetailedView.7(this));
  }
  
  public String getHelpCenterUrl()
  {
    return lyftPreferences.getLyftWebRoot() + "/help";
  }
  
  protected int layoutId()
  {
    return 2130903343;
  }
  
  public void onAttach()
  {
    super.onAttach();
    rideId = ((RideHistoryScreens.PassengerRideHistoryDetailedScreen)Screen.fromView(getView())).getRideId();
    loadRideDetails();
    pricingFaqTextView.setText(Html.fromHtml(getResources().getString(2131166001)));
    helpCenterTextView.setText(Html.fromHtml(getResources().getString(2131165998)));
    tipDriverButton.setOnClickListener(new PassengerRideHistoryDetailedView.1(this));
    findLostItemButton.setOnClickListener(new PassengerRideHistoryDetailedView.2(this));
    requestReviewButton.setOnClickListener(new PassengerRideHistoryDetailedView.3(this));
    pricingFaqTextView.setOnClickListener(new PassengerRideHistoryDetailedView.4(this));
    helpCenterTextView.setOnClickListener(new PassengerRideHistoryDetailedView.5(this));
    retryButton.setOnClickListener(new PassengerRideHistoryDetailedView.6(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.ridehistory.PassengerRideHistoryDetailedView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */