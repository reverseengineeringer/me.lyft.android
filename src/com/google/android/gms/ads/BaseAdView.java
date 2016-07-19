package com.google.android.gms.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzae;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;

class BaseAdView
  extends ViewGroup
{
  protected final zzae zzaih;
  
  public BaseAdView(Context paramContext, int paramInt)
  {
    super(paramContext);
    zzaih = new zzae(this, zzg(paramInt));
  }
  
  private static boolean zzg(int paramInt)
  {
    return paramInt == 2;
  }
  
  public void destroy()
  {
    zzaih.destroy();
  }
  
  public AdListener getAdListener()
  {
    return zzaih.getAdListener();
  }
  
  public AdSize getAdSize()
  {
    return zzaih.getAdSize();
  }
  
  public String getAdUnitId()
  {
    return zzaih.getAdUnitId();
  }
  
  public InAppPurchaseListener getInAppPurchaseListener()
  {
    return zzaih.getInAppPurchaseListener();
  }
  
  public String getMediationAdapterClassName()
  {
    return zzaih.getMediationAdapterClassName();
  }
  
  public void loadAd(AdRequest paramAdRequest)
  {
    zzaih.zza(paramAdRequest.zzdd());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = getChildAt(0);
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      int i = localView.getMeasuredWidth();
      int j = localView.getMeasuredHeight();
      paramInt1 = (paramInt3 - paramInt1 - i) / 2;
      paramInt2 = (paramInt4 - paramInt2 - j) / 2;
      localView.layout(paramInt1, paramInt2, i + paramInt1, j + paramInt2);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    Object localObject = getChildAt(0);
    int j;
    if ((localObject != null) && (((View)localObject).getVisibility() != 8))
    {
      measureChild((View)localObject, paramInt1, paramInt2);
      j = ((View)localObject).getMeasuredWidth();
      i = ((View)localObject).getMeasuredHeight();
    }
    for (;;)
    {
      j = Math.max(j, getSuggestedMinimumWidth());
      i = Math.max(i, getSuggestedMinimumHeight());
      setMeasuredDimension(View.resolveSize(j, paramInt1), View.resolveSize(i, paramInt2));
      return;
      localObject = getAdSize();
      if (localObject != null)
      {
        Context localContext = getContext();
        j = ((AdSize)localObject).getWidthInPixels(localContext);
        i = ((AdSize)localObject).getHeightInPixels(localContext);
      }
      else
      {
        j = 0;
      }
    }
  }
  
  public void pause()
  {
    zzaih.pause();
  }
  
  public void resume()
  {
    zzaih.resume();
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    zzaih.setAdListener(paramAdListener);
    if ((paramAdListener != null) && ((paramAdListener instanceof zza))) {
      zzaih.zza((zza)paramAdListener);
    }
    while (paramAdListener != null) {
      return;
    }
    zzaih.zza(null);
  }
  
  public void setAdSize(AdSize paramAdSize)
  {
    zzaih.setAdSizes(new AdSize[] { paramAdSize });
  }
  
  public void setAdUnitId(String paramString)
  {
    zzaih.setAdUnitId(paramString);
  }
  
  public void setInAppPurchaseListener(InAppPurchaseListener paramInAppPurchaseListener)
  {
    zzaih.setInAppPurchaseListener(paramInAppPurchaseListener);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.BaseAdView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */