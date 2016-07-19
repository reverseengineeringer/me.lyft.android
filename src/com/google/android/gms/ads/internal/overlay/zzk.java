package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzll;
import java.util.HashMap;

@zzir
public class zzk
  extends FrameLayout
  implements zzh
{
  private final zzll zzbgj;
  private String zzbjg;
  private final FrameLayout zzbua;
  private final zzy zzbub;
  private zzi zzbuc;
  private boolean zzbud;
  private boolean zzbue;
  private TextView zzbuf;
  private long zzbug;
  private long zzbuh;
  private String zzbui;
  
  public zzk(Context paramContext, zzll paramzzll, int paramInt, boolean paramBoolean, zzdk paramzzdk, zzdi paramzzdi)
  {
    super(paramContext);
    zzbgj = paramzzll;
    zzbua = new FrameLayout(paramContext);
    addView(zzbua, new FrameLayout.LayoutParams(-1, -1));
    zzb.zzw(paramzzll.zzuh());
    zzbuc = zzuhzzakk.zza(paramContext, paramzzll, paramInt, paramBoolean, paramzzdk, paramzzdi);
    if (zzbuc != null) {
      zzbua.addView(zzbuc, new FrameLayout.LayoutParams(-1, -1, 17));
    }
    zzbuf = new TextView(paramContext);
    zzbuf.setBackgroundColor(-16777216);
    zzor();
    zzbub = new zzy(this);
    zzbub.zzpm();
    if (zzbuc != null) {
      zzbuc.zza(this);
    }
    if (zzbuc == null) {
      zzl("AdVideoUnderlay Error", "Allocating player failed.");
    }
  }
  
  private void zza(String paramString, String... paramVarArgs)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", paramString);
    int j = paramVarArgs.length;
    int i = 0;
    paramString = null;
    if (i < j)
    {
      String str = paramVarArgs[i];
      if (paramString == null) {}
      for (paramString = str;; paramString = null)
      {
        i += 1;
        break;
        localHashMap.put(paramString, str);
      }
    }
    zzbgj.zza("onVideoEvent", localHashMap);
  }
  
  public static void zzi(zzll paramzzll)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", "no_video_view");
    paramzzll.zza("onVideoEvent", localHashMap);
  }
  
  private void zzor()
  {
    if (!zzot())
    {
      zzbua.addView(zzbuf, new FrameLayout.LayoutParams(-1, -1));
      zzbua.bringChildToFront(zzbuf);
    }
  }
  
  private void zzos()
  {
    if (zzot()) {
      zzbua.removeView(zzbuf);
    }
  }
  
  private boolean zzot()
  {
    return zzbuf.getParent() != null;
  }
  
  private void zzou()
  {
    if (zzbgj.zzuf() == null) {
      break label12;
    }
    label12:
    while (zzbud) {
      return;
    }
    if ((zzbgj.zzuf().getWindow().getAttributes().flags & 0x80) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      zzbue = bool;
      if (zzbue) {
        break;
      }
      zzbgj.zzuf().getWindow().addFlags(128);
      zzbud = true;
      return;
    }
  }
  
  private void zzov()
  {
    if (zzbgj.zzuf() == null) {}
    while ((!zzbud) || (zzbue)) {
      return;
    }
    zzbgj.zzuf().getWindow().clearFlags(128);
    zzbud = false;
  }
  
  public void destroy()
  {
    zzbub.cancel();
    if (zzbuc != null) {
      zzbuc.stop();
    }
    zzov();
  }
  
  public void onPaused()
  {
    zza("pause", new String[0]);
    zzov();
  }
  
  public void pause()
  {
    if (zzbuc == null) {
      return;
    }
    zzbuc.pause();
  }
  
  public void play()
  {
    if (zzbuc == null) {
      return;
    }
    zzbuc.play();
  }
  
  public void seekTo(int paramInt)
  {
    if (zzbuc == null) {
      return;
    }
    zzbuc.seekTo(paramInt);
  }
  
  public void setMimeType(String paramString)
  {
    zzbui = paramString;
  }
  
  public void zza(float paramFloat)
  {
    if (zzbuc == null) {
      return;
    }
    zzbuc.zza(paramFloat);
  }
  
  public void zza(float paramFloat1, float paramFloat2)
  {
    if (zzbuc != null) {
      zzbuc.zza(paramFloat1, paramFloat2);
    }
  }
  
  public void zzbx(String paramString)
  {
    zzbjg = paramString;
  }
  
  public void zzd(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt3 == 0) || (paramInt4 == 0)) {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramInt3 + 2, paramInt4 + 2);
    localLayoutParams.setMargins(paramInt1 - 1, paramInt2 - 1, 0, 0);
    zzbua.setLayoutParams(localLayoutParams);
    requestLayout();
  }
  
  public void zzd(MotionEvent paramMotionEvent)
  {
    if (zzbuc == null) {
      return;
    }
    zzbuc.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void zzl(String paramString1, String paramString2)
  {
    zza("error", new String[] { "what", paramString1, "extra", paramString2 });
  }
  
  public void zzlx()
  {
    if (zzbuc == null) {
      return;
    }
    if (!TextUtils.isEmpty(zzbjg))
    {
      zzbuc.setMimeType(zzbui);
      zzbuc.setVideoPath(zzbjg);
      return;
    }
    zza("no_src", new String[0]);
  }
  
  public void zznq()
  {
    if (zzbuc == null) {
      return;
    }
    zzbuc.zznq();
  }
  
  public void zznr()
  {
    if (zzbuc == null) {
      return;
    }
    zzbuc.zznr();
  }
  
  public void zzok()
  {
    zzkl.zzclg.post(new Runnable()
    {
      public void run()
      {
        zzk.zza(zzk.this, "surfaceCreated", new String[0]);
      }
    });
  }
  
  public void zzol()
  {
    if (zzbuc == null) {}
    while (zzbuh != 0L) {
      return;
    }
    zza("canplaythrough", new String[] { "duration", String.valueOf(zzbuc.getDuration() / 1000.0F), "videoWidth", String.valueOf(zzbuc.getVideoWidth()), "videoHeight", String.valueOf(zzbuc.getVideoHeight()) });
  }
  
  public void zzom()
  {
    zzou();
  }
  
  public void zzon()
  {
    zza("ended", new String[0]);
    zzov();
  }
  
  public void zzoo()
  {
    zzor();
    zzbuh = zzbug;
    zzkl.zzclg.post(new Runnable()
    {
      public void run()
      {
        zzk.zza(zzk.this, "surfaceDestroyed", new String[0]);
      }
    });
  }
  
  public void zzop()
  {
    if (zzbuc == null) {
      return;
    }
    TextView localTextView = new TextView(zzbuc.getContext());
    String str = String.valueOf(zzbuc.zznk());
    if (str.length() != 0) {}
    for (str = "AdMob - ".concat(str);; str = new String("AdMob - "))
    {
      localTextView.setText(str);
      localTextView.setTextColor(-65536);
      localTextView.setBackgroundColor(65280);
      zzbua.addView(localTextView, new FrameLayout.LayoutParams(-2, -2, 17));
      zzbua.bringChildToFront(localTextView);
      return;
    }
  }
  
  void zzoq()
  {
    if (zzbuc == null) {}
    long l;
    do
    {
      return;
      l = zzbuc.getCurrentPosition();
    } while ((zzbug == l) || (l <= 0L));
    zzos();
    zza("timeupdate", new String[] { "time", String.valueOf((float)l / 1000.0F) });
    zzbug = l;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */