package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.ViewSwitcher;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzko;
import com.google.android.gms.internal.zzky;
import com.google.android.gms.internal.zzll;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zzv$zza
  extends ViewSwitcher
{
  private final zzko zzaqd;
  private final zzky zzaqe;
  
  public zzv$zza(Context paramContext, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
  {
    super(paramContext);
    zzaqd = new zzko(paramContext);
    if ((paramContext instanceof Activity)) {}
    for (zzaqe = new zzky((Activity)paramContext, this, paramOnGlobalLayoutListener, paramOnScrollChangedListener);; zzaqe = new zzky(null, this, paramOnGlobalLayoutListener, paramOnScrollChangedListener))
    {
      zzaqe.zztt();
      return;
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (zzaqe != null) {
      zzaqe.onAttachedToWindow();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (zzaqe != null) {
      zzaqe.onDetachedFromWindow();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    zzaqd.zze(paramMotionEvent);
    return false;
  }
  
  public void removeAllViews()
  {
    Object localObject = new ArrayList();
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if ((localView != null) && ((localView instanceof zzll))) {
        ((List)localObject).add((zzll)localView);
      }
      i += 1;
    }
    super.removeAllViews();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((zzll)((Iterator)localObject).next()).destroy();
    }
  }
  
  public void zzgr()
  {
    zzkh.v("Disable position monitoring on adFrame.");
    if (zzaqe != null) {
      zzaqe.zztu();
    }
  }
  
  public zzko zzgv()
  {
    return zzaqd;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzv.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */