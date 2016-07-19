package me.lyft.android.ui.passenger.v2.request.pickup;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.infrastructure.assets.IAssetLoadingService;
import me.lyft.android.rx.Binder;
import me.lyft.android.utils.MetricsUtils;

public class RideTypeSelectionItemView
  extends LinearLayout
{
  private static final int HEIGHT_IN_DP = 50;
  @Inject
  IAssetLoadingService assetLoadingService;
  Binder binder = new Binder();
  View etaContainerView;
  TextView etaTextView;
  TextView labelView;
  ImageView logoImageView;
  View newItemHint;
  TextView subLabelView;
  
  public RideTypeSelectionItemView(Context paramContext)
  {
    super(paramContext);
    DaggerInjector.fromView(this).inject(this);
    Scoop.fromView(this).inflater(paramContext).inflate(2130903437, this);
    paramContext = new LinearLayout.LayoutParams(-1, MetricsUtils.fromView(this).dpToPixels(50.0F));
    setGravity(17);
    setLayoutParams(paramContext);
    setBackgroundDrawable(getResources().getDrawable(2130838505));
    ButterKnife.bind(this);
  }
  
  private void applyIconFilter(ImageView paramImageView)
  {
    if (isSelected())
    {
      paramImageView.setColorFilter(getResources().getColor(2131493043), PorterDuff.Mode.SRC_ATOP);
      return;
    }
    paramImageView.clearColorFilter();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    binder.detach();
  }
  
  public void setEta(Long paramLong)
  {
    if (paramLong == null)
    {
      etaContainerView.setVisibility(8);
      return;
    }
    paramLong = String.valueOf(paramLong);
    etaTextView.setText(paramLong);
    etaContainerView.setVisibility(0);
  }
  
  public void setGravity(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 17: 
      setBackgroundDrawable(getResources().getDrawable(2130838508));
      return;
    case 48: 
      setBackgroundDrawable(getResources().getDrawable(2130838509));
      return;
    }
    setBackgroundDrawable(getResources().getDrawable(2130838507));
  }
  
  public void setHasPrimeTime(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Drawable localDrawable = getResources().getDrawable(2130838492);
      labelView.setCompoundDrawablesWithIntrinsicBounds(null, null, localDrawable, null);
      return;
    }
    labelView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
  }
  
  public void setIcon(String paramString)
  {
    binder.bind(assetLoadingService.loadMarkerBitmap(paramString), new RideTypeSelectionItemView.1(this));
  }
  
  public void setIsNewItem(boolean paramBoolean)
  {
    View localView = newItemHint;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void setLabel(String paramString)
  {
    labelView.setText(paramString);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    super.setSelected(paramBoolean);
    applyIconFilter(logoImageView);
  }
  
  public void setSubLabel(String paramString)
  {
    subLabelView.setText(paramString);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.request.pickup.RideTypeSelectionItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */