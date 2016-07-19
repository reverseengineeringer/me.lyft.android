package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkm;
import java.util.Iterator;
import java.util.List;

@zzir
class zzb
  extends RelativeLayout
{
  private static final float[] zzbff = { 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F };
  private final RelativeLayout zzbfg;
  private AnimationDrawable zzbfh;
  
  public zzb(Context paramContext, zza paramzza)
  {
    super(paramContext);
    zzab.zzaa(paramzza);
    Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    switch (paramzza.zzkt())
    {
    case 1: 
    default: 
      ((RelativeLayout.LayoutParams)localObject1).addRule(10);
      ((RelativeLayout.LayoutParams)localObject1).addRule(11);
    }
    for (;;)
    {
      Object localObject2 = new ShapeDrawable(new RoundRectShape(zzbff, null, null));
      ((ShapeDrawable)localObject2).getPaint().setColor(paramzza.getBackgroundColor());
      zzbfg = new RelativeLayout(paramContext);
      zzbfg.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      zzu.zzfs().zza(zzbfg, (Drawable)localObject2);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      if (!TextUtils.isEmpty(paramzza.getText()))
      {
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        TextView localTextView = new TextView(paramContext);
        localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localTextView.setId(1195835393);
        localTextView.setTypeface(Typeface.DEFAULT);
        localTextView.setText(paramzza.getText());
        localTextView.setTextColor(paramzza.getTextColor());
        localTextView.setTextSize(paramzza.getTextSize());
        localTextView.setPadding(zzm.zziw().zza(paramContext, 4), 0, zzm.zziw().zza(paramContext, 4), 0);
        zzbfg.addView(localTextView);
        ((RelativeLayout.LayoutParams)localObject1).addRule(1, localTextView.getId());
      }
      paramContext = new ImageView(paramContext);
      paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramContext.setId(1195835394);
      localObject1 = paramzza.zzkr();
      if (((List)localObject1).size() <= 1) {
        break label432;
      }
      zzbfh = new AnimationDrawable();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Drawable)((Iterator)localObject1).next();
        zzbfh.addFrame((Drawable)localObject2, paramzza.zzks());
      }
      ((RelativeLayout.LayoutParams)localObject1).addRule(10);
      ((RelativeLayout.LayoutParams)localObject1).addRule(9);
      continue;
      ((RelativeLayout.LayoutParams)localObject1).addRule(12);
      ((RelativeLayout.LayoutParams)localObject1).addRule(9);
      continue;
      ((RelativeLayout.LayoutParams)localObject1).addRule(12);
      ((RelativeLayout.LayoutParams)localObject1).addRule(11);
    }
    zzu.zzfs().zza(paramContext, zzbfh);
    for (;;)
    {
      zzbfg.addView(paramContext);
      addView(zzbfg);
      return;
      label432:
      if (((List)localObject1).size() == 1) {
        paramContext.setImageDrawable((Drawable)((List)localObject1).get(0));
      }
    }
  }
  
  public void onAttachedToWindow()
  {
    if (zzbfh != null) {
      zzbfh.start();
    }
    super.onAttachedToWindow();
  }
  
  public ViewGroup zzku()
  {
    return zzbfg;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.formats.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */