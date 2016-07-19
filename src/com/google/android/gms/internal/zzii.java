package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;

@zzir
@TargetApi(19)
public class zzii
  extends zzih
{
  private Object zzbyn = new Object();
  private PopupWindow zzbyo;
  private boolean zzbyp = false;
  
  zzii(Context paramContext, zzjy.zza paramzza, zzll paramzzll, zzig.zza paramzza1)
  {
    super(paramContext, paramzza, paramzzll, paramzza1);
  }
  
  private void zzqf()
  {
    synchronized (zzbyn)
    {
      zzbyp = true;
      if (((mContext instanceof Activity)) && (((Activity)mContext).isDestroyed())) {
        zzbyo = null;
      }
      if (zzbyo != null)
      {
        if (zzbyo.isShowing()) {
          zzbyo.dismiss();
        }
        zzbyo = null;
      }
      return;
    }
  }
  
  public void cancel()
  {
    zzqf();
    super.cancel();
  }
  
  protected void zzaj(int paramInt)
  {
    zzqf();
    super.zzaj(paramInt);
  }
  
  protected void zzqe()
  {
    if ((mContext instanceof Activity)) {}
    Object localObject2;
    for (Window localWindow = ((Activity)mContext).getWindow();; localObject2 = null)
    {
      if ((localWindow == null) || (localWindow.getDecorView() == null)) {}
      while (((Activity)mContext).isDestroyed()) {
        return;
      }
      FrameLayout localFrameLayout = new FrameLayout(mContext);
      localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      localFrameLayout.addView(zzbgj.getView(), -1, -1);
      synchronized (zzbyn)
      {
        if (zzbyp) {
          return;
        }
      }
      zzbyo = new PopupWindow(localFrameLayout, 1, 1, false);
      zzbyo.setOutsideTouchable(true);
      zzbyo.setClippingEnabled(false);
      zzkh.zzcw("Displaying the 1x1 popup off the screen.");
      try
      {
        zzbyo.showAtLocation(((Window)localObject1).getDecorView(), 0, -1, -1);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          zzbyo = null;
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzii
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */