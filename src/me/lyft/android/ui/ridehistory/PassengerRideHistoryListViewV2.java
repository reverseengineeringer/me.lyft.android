package me.lyft.android.ui.ridehistory;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import com.lyft.widgets.recyclerview.HorizontalDividerDecoration;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.business.BusinessOnboardingAnalytics;
import me.lyft.android.application.enterprise.IEnterpriseService;
import me.lyft.android.application.ridehistory.IPassengerRideHistoryService;
import me.lyft.android.application.ridehistory.PassengerRideHistoryType;
import me.lyft.android.common.AppFlow;
import me.lyft.android.domain.User;
import me.lyft.android.rx.IRxBinder;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;

public class PassengerRideHistoryListViewV2
  extends FrameLayout
{
  @Inject
  AppFlow appFlow;
  private IRxBinder binder = new RxUIBinder();
  @Inject
  BusinessOnboardingAnalytics businessOnboardingAnalytics;
  View createBusinessProfileView;
  View emptyListContainer;
  ImageView emptyListImageView;
  TextView emptyListSubtitleView;
  TextView emptyListTitleView;
  @Inject
  IEnterpriseService enterpriseService;
  Button getStartedButton;
  private final LayoutInflater inflater;
  private LinearLayoutManager layoutManager;
  private boolean loading = false;
  private PassengerRideHistoryAdapter passengerRideHistoryAdapter = null;
  @Inject
  IPassengerRideHistoryService passengerRideHistoryService;
  @Inject
  IProgressController progressController;
  Button retryButton;
  View retryViewContainer;
  RecyclerView rideHistoryRecyclerView;
  @Inject
  IUserProvider userProvider;
  @Inject
  IViewErrorHandler viewErrorHandler;
  private final int viewPosition;
  
  public PassengerRideHistoryListViewV2(Context paramContext, int paramInt)
  {
    super(paramContext);
    viewPosition = paramInt;
    DaggerInjector.fromView(this).inject(this);
    inflater = Scoop.fromView(this).inflater(paramContext);
    ButterKnife.bind(this, inflater.inflate(2130903346, this, true));
  }
  
  private void initRecyclerView()
  {
    rideHistoryRecyclerView.setHasFixedSize(true);
    rideHistoryRecyclerView.addItemDecoration(new HorizontalDividerDecoration(getResources().getDrawable(2130838417)));
    layoutManager = new LinearLayoutManager(getContext());
    rideHistoryRecyclerView.setLayoutManager(layoutManager);
    passengerRideHistoryAdapter = new PassengerRideHistoryAdapter(inflater);
    rideHistoryRecyclerView.setAdapter(passengerRideHistoryAdapter);
    rideHistoryRecyclerView.addOnScrollListener(new PassengerRideHistoryListViewV2.5(this));
  }
  
  private void loadMore()
  {
    if (loading) {
      return;
    }
    loading = true;
    passengerRideHistoryAdapter.setHasError(false);
    binder.bindAsyncCall(passengerRideHistoryService.getPassengerHistory(passengerRideHistoryAdapter.getData().size()), new PassengerRideHistoryListViewV2.8(this));
  }
  
  private void loadRideHistory()
  {
    if (loading) {
      return;
    }
    loading = true;
    progressController.showProgress();
    emptyListContainer.setVisibility(8);
    retryViewContainer.setVisibility(8);
    binder.bindAsyncCall(passengerRideHistoryService.getPassengerHistory(0, PassengerRideHistoryType.get(viewPosition)), new PassengerRideHistoryListViewV2.7(this));
  }
  
  private void onGetStartedButtonClick()
  {
    businessOnboardingAnalytics.initializeGetStarted();
    progressController.showProgress();
    binder.bindAsyncCall(enterpriseService.getUserOrganization(), new PassengerRideHistoryListViewV2.6(this));
  }
  
  private void showEmptyScreen()
  {
    emptyListContainer.setVisibility(0);
    createBusinessProfileView.setVisibility(8);
    if (viewPosition == BUSINESSpagePosition)
    {
      if (userProvider.getUser().hasBusinessProfile())
      {
        emptyListImageView.setImageDrawable(getResources().getDrawable(2130838137));
        emptyListTitleView.setText(getResources().getText(2131165946));
        emptyListSubtitleView.setText(getResources().getText(2131165945));
      }
    }
    else {
      return;
    }
    emptyListContainer.setVisibility(8);
    createBusinessProfileView.setVisibility(0);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    binder.attach();
    initRecyclerView();
    binder.bindAction(passengerRideHistoryAdapter.observeItemClicks(), new PassengerRideHistoryListViewV2.1(this));
    binder.bindAction(passengerRideHistoryAdapter.observeRetryClicks(), new PassengerRideHistoryListViewV2.2(this));
    retryButton.setOnClickListener(new PassengerRideHistoryListViewV2.3(this));
    getStartedButton.setOnClickListener(new PassengerRideHistoryListViewV2.4(this));
    if (passengerRideHistoryAdapter.getItemCount() <= 0)
    {
      loadRideHistory();
      return;
    }
    rideHistoryRecyclerView.setVisibility(0);
    emptyListContainer.setVisibility(8);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    passengerRideHistoryService.clearCachedRideHistory();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.ridehistory.PassengerRideHistoryListViewV2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */