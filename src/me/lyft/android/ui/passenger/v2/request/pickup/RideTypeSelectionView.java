package me.lyft.android.ui.passenger.v2.request.pickup;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.cost.ICostService;
import me.lyft.android.application.eta.IPickupEtaService;
import me.lyft.android.common.Unit;
import me.lyft.android.controls.recycleview.WrapContentLayoutManager;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType;
import me.lyft.android.rx.IRxBinder;
import me.lyft.android.rx.RxUIBinder;
import rx.Observable;
import rx.functions.Action1;

public class RideTypeSelectionView
  extends RecyclerView
{
  final IRxBinder binder = new RxUIBinder();
  @Inject
  ICostService costService;
  @Inject
  IPickupEtaService pickupEtaService;
  final RideTypeSelectionAdapter selectionAdapter;
  
  public RideTypeSelectionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    selectionAdapter = new RideTypeSelectionAdapter(pickupEtaService, costService);
    setAdapter(selectionAdapter);
    setLayoutManager(new WrapContentLayoutManager(this, 1, false));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder.attach();
    binder.bindAction(pickupEtaService.observeEta().map(Unit.func1()), new RideTypeSelectionView.1(this));
  }
  
  protected void onDetachedFromWindow()
  {
    binder.detach();
    super.onDetachedFromWindow();
  }
  
  public void selectRideType(RequestRideType paramRequestRideType)
  {
    selectionAdapter.selectRideType(paramRequestRideType);
  }
  
  public void setOnSelectionChanged(Action1<RequestRideType> paramAction1)
  {
    selectionAdapter.setOnSelectionChanged(paramAction1);
  }
  
  public void setRideTypes(List<RequestRideType> paramList)
  {
    selectionAdapter.setRideTypes(paramList);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.request.pickup.RideTypeSelectionView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */