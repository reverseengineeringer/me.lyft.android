package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzll;

@zzir
public class zzd$zzc
{
  public final int index;
  public final Context zzagf;
  public final ViewGroup.LayoutParams zzbtj;
  public final ViewGroup zzbtk;
  
  public zzd$zzc(zzll paramzzll)
    throws zzd.zza
  {
    zzbtj = paramzzll.getLayoutParams();
    ViewParent localViewParent = paramzzll.getParent();
    zzagf = paramzzll.zzug();
    if ((localViewParent != null) && ((localViewParent instanceof ViewGroup)))
    {
      zzbtk = ((ViewGroup)localViewParent);
      index = zzbtk.indexOfChild(paramzzll.getView());
      zzbtk.removeView(paramzzll.getView());
      paramzzll.zzah(true);
      return;
    }
    throw new zzd.zza("Could not get the parent of the WebView for an overlay.");
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzd.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */