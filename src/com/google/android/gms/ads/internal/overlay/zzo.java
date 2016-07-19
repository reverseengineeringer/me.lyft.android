package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.internal.zzir;

@zzir
public class zzo
  extends FrameLayout
  implements View.OnClickListener
{
  private final ImageButton zzbuk;
  private final zzu zzbul;
  
  public zzo(Context paramContext, int paramInt, zzu paramzzu)
  {
    super(paramContext);
    zzbul = paramzzu;
    setOnClickListener(this);
    zzbuk = new ImageButton(paramContext);
    zzbuk.setImageResource(17301527);
    zzbuk.setBackgroundColor(0);
    zzbuk.setOnClickListener(this);
    zzbuk.setPadding(0, 0, 0, 0);
    zzbuk.setContentDescription("Interstitial close button");
    paramInt = zzm.zziw().zza(paramContext, paramInt);
    addView(zzbuk, new FrameLayout.LayoutParams(paramInt, paramInt, 17));
  }
  
  public void onClick(View paramView)
  {
    if (zzbul != null) {
      zzbul.zznx();
    }
  }
  
  public void zza(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      if (paramBoolean1)
      {
        zzbuk.setVisibility(4);
        return;
      }
      zzbuk.setVisibility(8);
      return;
    }
    zzbuk.setVisibility(0);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */