package me.lyft.android.ui;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.domain.User;
import me.lyft.android.infrastructure.device.IDevice;

public class WarningView
  extends TextView
{
  @Inject
  IDevice device;
  protected BroadcastReceiver deviceStateChanged = new WarningView.2(this);
  @Inject
  IUserProvider userProvider;
  TextView warningBanner;
  
  public WarningView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode()) {
      return;
    }
    DaggerInjector.fromView(this).inject(this);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    localIntentFilter.addAction("android.location.PROVIDERS_CHANGED");
    getContext().registerReceiver(deviceStateChanged, localIntentFilter);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    try
    {
      getContext().unregisterReceiver(deviceStateChanged);
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
  }
  
  protected void updateWarningBanner()
  {
    Object localObject = null;
    int i;
    int j;
    if (!device.isGPSEnabled())
    {
      i = 1;
      if (device.getNetworkConnected()) {
        break label138;
      }
      j = 1;
      label30:
      if (!userProvider.getUser().isDispatchable()) {
        break label143;
      }
      if (j != 0) {
        localObject = getResources().getString(2131166422);
      }
      label59:
      if ((localObject != null) || (warningBanner.getVisibility() != 0)) {
        break label187;
      }
      if (device.getSDKVersion() <= 10) {
        break label177;
      }
      localObject = ObjectAnimator.ofFloat(warningBanner, "alpha", new float[] { 1.0F, 0.0F });
      ((ValueAnimator)localObject).addListener(new WarningView.1(this));
      ((ValueAnimator)localObject).setDuration(700L);
      ((ValueAnimator)localObject).start();
    }
    label138:
    label143:
    label177:
    label187:
    do
    {
      do
      {
        return;
        i = 0;
        break;
        j = 0;
        break label30;
        if (j != 0)
        {
          localObject = getResources().getString(2131166423);
          break label59;
        }
        if (i == 0) {
          break label59;
        }
        localObject = getResources().getString(2131166421);
        break label59;
        warningBanner.setVisibility(8);
        return;
      } while (localObject == null);
      warningBanner.setText((CharSequence)localObject);
    } while (warningBanner.getVisibility() == 0);
    warningBanner.setVisibility(0);
    warningBanner.setAlpha(0.0F);
    localObject = ObjectAnimator.ofFloat(warningBanner, "alpha", new float[] { 0.0F, 1.0F });
    ((ValueAnimator)localObject).setDuration(700L);
    ((ValueAnimator)localObject).start();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.WarningView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */