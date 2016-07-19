package me.lyft.android.ui.ridehistory;

import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import com.lyft.scoop.HandleBack;
import com.lyft.scoop.Scoop;
import com.lyft.widgets.recyclerview.HorizontalDividerDecoration;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.ridehistory.IPassengerRideHistoryService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.RxViewController;
import me.lyft.android.common.Unit;
import me.lyft.android.controls.BackButtonToolbar;
import me.lyft.android.domain.ridehistory.PassengerRideHistory;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.SlideMenuController;
import rx.functions.Action1;

public class PassengerRideHistoryListView
  extends RxViewController
  implements HandleBack
{
  @Inject
  AppFlow appFlow;
  View emptyListContainer;
  private final Action1<Unit> goBackAction = new PassengerRideHistoryListView.4(this);
  private LinearLayoutManager layoutManager;
  private boolean loading = false;
  @Inject
  IPassengerRideHistoryService passengerHistoryService;
  private PassengerRideHistoryAdapter passengerRideHistoryAdapter = null;
  @Inject
  IProgressController progressController;
  Button retryButton;
  View retryViewContainer;
  RecyclerView rideHistoryRecyclerView;
  @Inject
  SlideMenuController slideMenuController;
  BackButtonToolbar toolbar;
  @Inject
  IViewErrorHandler viewErrorHandler;
  
  private void initRecyclerView()
  {
    rideHistoryRecyclerView.setHasFixedSize(true);
    rideHistoryRecyclerView.addItemDecoration(new HorizontalDividerDecoration(getResources().getDrawable(2130838417)));
    layoutManager = new LinearLayoutManager(getView().getContext());
    rideHistoryRecyclerView.setLayoutManager(layoutManager);
    passengerRideHistoryAdapter = new PassengerRideHistoryAdapter(getScoop().inflater(getView().getContext()));
    rideHistoryRecyclerView.setAdapter(passengerRideHistoryAdapter);
    rideHistoryRecyclerView.addOnScrollListener(new PassengerRideHistoryListView.7(this));
  }
  
  private void loadMore()
  {
    if (loading) {
      return;
    }
    loading = true;
    passengerRideHistoryAdapter.setHasError(false);
    binder.bindAsyncCall(passengerHistoryService.getPassengerHistory(passengerRideHistoryAdapter.getData().size()), new PassengerRideHistoryListView.6(this));
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
    binder.bindAsyncCall(passengerHistoryService.getPassengerHistory(0), new PassengerRideHistoryListView.5(this));
  }
  
  protected int layoutId()
  {
    return 2130903353;
  }
  
  void loadItemsFromCache()
  {
    PassengerRideHistory localPassengerRideHistory = passengerHistoryService.getCachedRideHistory();
    passengerRideHistoryAdapter.setItems(localPassengerRideHistory.getRideHistory());
    passengerRideHistoryAdapter.setHasMore(localPassengerRideHistory.hasMore());
  }
  
  public void onAttach()
  {
    super.onAttach();
    initRecyclerView();
    binder.bindAction(passengerRideHistoryAdapter.observeItemClicks(), new PassengerRideHistoryListView.1(this));
    binder.bindAction(passengerRideHistoryAdapter.observeRetryClicks(), new PassengerRideHistoryListView.2(this));
    binder.bindAction(toolbar.observeHomeClick(), goBackAction);
    retryButton.setOnClickListener(new PassengerRideHistoryListView.3(this));
    toolbar.setTitle(getResources().getString(2131166272));
    loadItemsFromCache();
    if (passengerRideHistoryAdapter.getItemCount() <= 0) {
      loadRideHistory();
    }
    for (;;)
    {
      slideMenuController.enableMenu();
      return;
      rideHistoryRecyclerView.setVisibility(0);
      emptyListContainer.setVisibility(8);
    }
  }
  
  public boolean onBack()
  {
    goBackAction.call(Unit.create());
    return appFlow.goBack();
  }
  
  public void onDetach()
  {
    super.onDetach();
    slideMenuController.disableMenu();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.ridehistory.PassengerRideHistoryListView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */