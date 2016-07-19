package me.lyft.android.controls;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.ButterKnife;

public class RideTypeSwitcher
  extends MultiSwitcher<RideTypeViewModel>
{
  public RideTypeSwitcher(Context paramContext)
  {
    super(paramContext);
  }
  
  public RideTypeSwitcher(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RideTypeSwitcher(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void bindSwitcherItem(View paramView, RideTypeViewModel paramRideTypeViewModel)
  {
    ((TextView)ButterKnife.findById(paramView, 2131558937)).setText(paramRideTypeViewModel.getLabel());
    paramView = ButterKnife.findById(paramView, 2131559692);
    if (paramRideTypeViewModel.hasPrimeTime()) {}
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      return;
    }
  }
  
  protected View createMultiSwitcherView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(2130903438, paramViewGroup, true);
  }
  
  protected View createSwitcherItem(LayoutInflater paramLayoutInflater, RideTypeViewModel paramRideTypeViewModel)
  {
    return paramLayoutInflater.inflate(2130903439, null);
  }
  
  protected View createThumb(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(2130903440, paramViewGroup, true);
  }
  
  protected void updateThumbViewToIndex(RideTypeViewModel paramRideTypeViewModel, ViewGroup paramViewGroup)
  {
    ((TextView)ButterKnife.findById(paramViewGroup, 2131559693)).setText(paramRideTypeViewModel.getLabel());
    paramViewGroup = ButterKnife.findById(paramViewGroup, 2131559694);
    if (paramRideTypeViewModel.hasPrimeTime()) {}
    for (int i = 0;; i = 8)
    {
      paramViewGroup.setVisibility(i);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.RideTypeSwitcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */