package com.google.android.gms.internal;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.zzf;
import java.util.Map;
import java.util.Set;

@zzir
public class zzhe
  extends zzhj
{
  static final Set<String> zzbqi = zzf.zzc(new String[] { "top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center" });
  private int zzaie = -1;
  private int zzaif = -1;
  private final Object zzail = new Object();
  private AdSizeParcel zzang;
  private final zzll zzbgj;
  private final Activity zzbpy;
  private String zzbqj = "top-right";
  private boolean zzbqk = true;
  private int zzbql = 0;
  private int zzbqm = 0;
  private int zzbqn = 0;
  private int zzbqo = 0;
  private ImageView zzbqp;
  private LinearLayout zzbqq;
  private zzhk zzbqr;
  private PopupWindow zzbqs;
  private RelativeLayout zzbqt;
  private ViewGroup zzbqu;
  
  public zzhe(zzll paramzzll, zzhk paramzzhk)
  {
    super(paramzzll, "resize");
    zzbgj = paramzzll;
    zzbpy = paramzzll.zzuf();
    zzbqr = paramzzhk;
  }
  
  private void zzi(Map<String, String> paramMap)
  {
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("width"))) {
      zzaie = zzu.zzfq().zzcq((String)paramMap.get("width"));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("height"))) {
      zzaif = zzu.zzfq().zzcq((String)paramMap.get("height"));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("offsetX"))) {
      zzbqn = zzu.zzfq().zzcq((String)paramMap.get("offsetX"));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("offsetY"))) {
      zzbqo = zzu.zzfq().zzcq((String)paramMap.get("offsetY"));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("allowOffscreen"))) {
      zzbqk = Boolean.parseBoolean((String)paramMap.get("allowOffscreen"));
    }
    paramMap = (String)paramMap.get("customClosePosition");
    if (!TextUtils.isEmpty(paramMap)) {
      zzbqj = paramMap;
    }
  }
  
  private int[] zzmx()
  {
    if (!zzmz()) {
      return null;
    }
    if (zzbqk) {
      return new int[] { zzbql + zzbqn, zzbqm + zzbqo };
    }
    int[] arrayOfInt1 = zzu.zzfq().zzi(zzbpy);
    int[] arrayOfInt2 = zzu.zzfq().zzk(zzbpy);
    int m = arrayOfInt1[0];
    int j = zzbql + zzbqn;
    int k = zzbqm + zzbqo;
    int i;
    if (j < 0)
    {
      i = 0;
      if (k >= arrayOfInt2[0]) {
        break label149;
      }
      j = arrayOfInt2[0];
    }
    for (;;)
    {
      return new int[] { i, j };
      i = j;
      if (zzaie + j <= m) {
        break;
      }
      i = m - zzaie;
      break;
      label149:
      j = k;
      if (zzaif + k > arrayOfInt2[1]) {
        j = arrayOfInt2[1] - zzaif;
      }
    }
  }
  
  public void execute(Map<String, String> paramMap)
  {
    synchronized (zzail)
    {
      if (zzbpy == null)
      {
        zzbu("Not an activity context. Cannot resize.");
        return;
      }
      if (zzbgj.zzdo() == null)
      {
        zzbu("Webview is not yet available, size is not set.");
        return;
      }
    }
    if (zzbgj.zzdo().zzauq)
    {
      zzbu("Is interstitial. Cannot resize an interstitial.");
      return;
    }
    if (zzbgj.zzuo())
    {
      zzbu("Cannot resize an expanded banner.");
      return;
    }
    zzi(paramMap);
    if (!zzmw())
    {
      zzbu("Invalid width and height options. Cannot resize.");
      return;
    }
    paramMap = zzbpy.getWindow();
    if ((paramMap == null) || (paramMap.getDecorView() == null))
    {
      zzbu("Activity context is not ready, cannot get window or decor view.");
      return;
    }
    int[] arrayOfInt = zzmx();
    if (arrayOfInt == null)
    {
      zzbu("Resize location out of screen or close button is not visible.");
      return;
    }
    int i = zzm.zziw().zza(zzbpy, zzaie);
    int j = zzm.zziw().zza(zzbpy, zzaif);
    Object localObject2 = zzbgj.getView().getParent();
    if ((localObject2 != null) && ((localObject2 instanceof ViewGroup)))
    {
      ((ViewGroup)localObject2).removeView(zzbgj.getView());
      if (zzbqs == null)
      {
        zzbqu = ((ViewGroup)localObject2);
        localObject2 = zzu.zzfq().zzk(zzbgj.getView());
        zzbqp = new ImageView(zzbpy);
        zzbqp.setImageBitmap((Bitmap)localObject2);
        zzang = zzbgj.zzdo();
        zzbqu.addView(zzbqp);
        zzbqt = new RelativeLayout(zzbpy);
        zzbqt.setBackgroundColor(0);
        zzbqt.setLayoutParams(new ViewGroup.LayoutParams(i, j));
        zzbqs = zzu.zzfq().zza(zzbqt, i, j, false);
        zzbqs.setOutsideTouchable(true);
        zzbqs.setTouchable(true);
        localObject2 = zzbqs;
        if (zzbqk) {
          break label1083;
        }
      }
    }
    label1024:
    label1038:
    label1040:
    label1083:
    for (boolean bool = true;; bool = false)
    {
      ((PopupWindow)localObject2).setClippingEnabled(bool);
      zzbqt.addView(zzbgj.getView(), -1, -1);
      zzbqq = new LinearLayout(zzbpy);
      localObject2 = new RelativeLayout.LayoutParams(zzm.zziw().zza(zzbpy, 50), zzm.zziw().zza(zzbpy, 50));
      String str = zzbqj;
      switch (str.hashCode())
      {
      }
      for (;;)
      {
        ((RelativeLayout.LayoutParams)localObject2).addRule(10);
        ((RelativeLayout.LayoutParams)localObject2).addRule(11);
        for (;;)
        {
          zzbqq.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              zzs(true);
            }
          });
          zzbqq.setContentDescription("Close button");
          zzbqt.addView(zzbqq, (ViewGroup.LayoutParams)localObject2);
          try
          {
            zzbqs.showAtLocation(paramMap.getDecorView(), 0, zzm.zziw().zza(zzbpy, arrayOfInt[0]), zzm.zziw().zza(zzbpy, arrayOfInt[1]));
            zzb(arrayOfInt[0], arrayOfInt[1]);
            zzbgj.zza(new AdSizeParcel(zzbpy, new AdSize(zzaie, zzaif)));
            zzc(arrayOfInt[0], arrayOfInt[1]);
            zzbw("resized");
            return;
          }
          catch (RuntimeException paramMap)
          {
            paramMap = String.valueOf(paramMap.getMessage());
            if (paramMap.length() == 0) {
              break label1024;
            }
            for (paramMap = "Cannot show popup window: ".concat(paramMap);; paramMap = new String("Cannot show popup window: "))
            {
              zzbu(paramMap);
              zzbqt.removeView(zzbgj.getView());
              if (zzbqu != null)
              {
                zzbqu.removeView(zzbqp);
                zzbqu.addView(zzbgj.getView());
                zzbgj.zza(zzang);
              }
              return;
            }
            i = -1;
            switch (i)
            {
            }
          }
          zzbqs.dismiss();
          break;
          zzbu("Webview is detached, probably in the middle of a resize or expand.");
          return;
          if (!str.equals("top-left")) {
            break label1038;
          }
          i = 0;
          break label1040;
          if (!str.equals("top-center")) {
            break label1038;
          }
          i = 1;
          break label1040;
          if (!str.equals("center")) {
            break label1038;
          }
          i = 2;
          break label1040;
          if (!str.equals("bottom-left")) {
            break label1038;
          }
          i = 3;
          break label1040;
          if (!str.equals("bottom-center")) {
            break label1038;
          }
          i = 4;
          break label1040;
          if (!str.equals("bottom-right")) {
            break label1038;
          }
          i = 5;
          break label1040;
          ((RelativeLayout.LayoutParams)localObject2).addRule(10);
          ((RelativeLayout.LayoutParams)localObject2).addRule(9);
          continue;
          ((RelativeLayout.LayoutParams)localObject2).addRule(10);
          ((RelativeLayout.LayoutParams)localObject2).addRule(14);
          continue;
          ((RelativeLayout.LayoutParams)localObject2).addRule(13);
          continue;
          ((RelativeLayout.LayoutParams)localObject2).addRule(12);
          ((RelativeLayout.LayoutParams)localObject2).addRule(9);
          continue;
          ((RelativeLayout.LayoutParams)localObject2).addRule(12);
          ((RelativeLayout.LayoutParams)localObject2).addRule(14);
          continue;
          ((RelativeLayout.LayoutParams)localObject2).addRule(12);
          ((RelativeLayout.LayoutParams)localObject2).addRule(11);
        }
      }
    }
  }
  
  public void zza(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    synchronized (zzail)
    {
      zzbql = paramInt1;
      zzbqm = paramInt2;
      if ((zzbqs != null) && (paramBoolean))
      {
        int[] arrayOfInt = zzmx();
        if (arrayOfInt != null)
        {
          zzbqs.update(zzm.zziw().zza(zzbpy, arrayOfInt[0]), zzm.zziw().zza(zzbpy, arrayOfInt[1]), zzbqs.getWidth(), zzbqs.getHeight());
          zzc(arrayOfInt[0], arrayOfInt[1]);
        }
      }
      else
      {
        return;
      }
      zzs(true);
    }
  }
  
  void zzb(int paramInt1, int paramInt2)
  {
    if (zzbqr != null) {
      zzbqr.zza(paramInt1, paramInt2, zzaie, zzaif);
    }
  }
  
  void zzc(int paramInt1, int paramInt2)
  {
    zzb(paramInt1, paramInt2 - zzu.zzfq().zzk(zzbpy)[0], zzaie, zzaif);
  }
  
  public void zzd(int paramInt1, int paramInt2)
  {
    zzbql = paramInt1;
    zzbqm = paramInt2;
  }
  
  boolean zzmw()
  {
    return (zzaie > -1) && (zzaif > -1);
  }
  
  public boolean zzmy()
  {
    for (;;)
    {
      synchronized (zzail)
      {
        if (zzbqs != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  boolean zzmz()
  {
    Object localObject = zzu.zzfq().zzi(zzbpy);
    int[] arrayOfInt = zzu.zzfq().zzk(zzbpy);
    int k = localObject[0];
    int i = localObject[1];
    if ((zzaie < 50) || (zzaie > k))
    {
      zzkh.zzcy("Width is too small or too large.");
      return false;
    }
    if ((zzaif < 50) || (zzaif > i))
    {
      zzkh.zzcy("Height is too small or too large.");
      return false;
    }
    if ((zzaif == i) && (zzaie == k))
    {
      zzkh.zzcy("Cannot resize to a full-screen ad.");
      return false;
    }
    label188:
    int j;
    if (zzbqk)
    {
      localObject = zzbqj;
      i = -1;
      switch (((String)localObject).hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          j = zzbql + zzbqn + zzaie - 50;
          i = zzbqm + zzbqo;
        }
        break;
      }
    }
    while ((j >= 0) && (j + 50 <= k) && (i >= arrayOfInt[0]) && (i + 50 <= arrayOfInt[1]))
    {
      return true;
      if (!((String)localObject).equals("top-left")) {
        break label188;
      }
      i = 0;
      break label188;
      if (!((String)localObject).equals("top-center")) {
        break label188;
      }
      i = 1;
      break label188;
      if (!((String)localObject).equals("center")) {
        break label188;
      }
      i = 2;
      break label188;
      if (!((String)localObject).equals("bottom-left")) {
        break label188;
      }
      i = 3;
      break label188;
      if (!((String)localObject).equals("bottom-center")) {
        break label188;
      }
      i = 4;
      break label188;
      if (!((String)localObject).equals("bottom-right")) {
        break label188;
      }
      i = 5;
      break label188;
      i = zzbql;
      j = zzbqn + i;
      i = zzbqm + zzbqo;
      continue;
      j = zzbql + zzbqn + zzaie / 2 - 25;
      i = zzbqm + zzbqo;
      continue;
      j = zzbql + zzbqn + zzaie / 2 - 25;
      i = zzbqm + zzbqo + zzaif / 2 - 25;
      continue;
      i = zzbql;
      j = zzbqn + i;
      i = zzbqm + zzbqo + zzaif - 50;
      continue;
      j = zzbql + zzbqn + zzaie / 2 - 25;
      i = zzbqm + zzbqo + zzaif - 50;
      continue;
      j = zzbql + zzbqn + zzaie - 50;
      i = zzbqm + zzbqo + zzaif - 50;
    }
  }
  
  public void zzs(boolean paramBoolean)
  {
    synchronized (zzail)
    {
      if (zzbqs != null)
      {
        zzbqs.dismiss();
        zzbqt.removeView(zzbgj.getView());
        if (zzbqu != null)
        {
          zzbqu.removeView(zzbqp);
          zzbqu.addView(zzbgj.getView());
          zzbgj.zza(zzang);
        }
        if (paramBoolean)
        {
          zzbw("default");
          if (zzbqr != null) {
            zzbqr.zzek();
          }
        }
        zzbqs = null;
        zzbqt = null;
        zzbqu = null;
        zzbqq = null;
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzhe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */