package com.google.android.gms.internal;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.zzu;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@zzir
public class zzko
{
  private final Context mContext;
  private int mState = 0;
  private final float zzbri;
  private String zzclp;
  private float zzclq;
  private float zzclr;
  private float zzcls;
  
  public zzko(Context paramContext)
  {
    mContext = paramContext;
    zzbri = getResourcesgetDisplayMetricsdensity;
  }
  
  public zzko(Context paramContext, String paramString)
  {
    this(paramContext);
    zzclp = paramString;
  }
  
  private void showDialog()
  {
    if (!(mContext instanceof Activity))
    {
      zzkh.zzcx("Can not create dialog without Activity Context");
      return;
    }
    final String str = zzcu(zzclp);
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(mContext);
    localBuilder.setMessage(str);
    localBuilder.setTitle("Ad Information");
    localBuilder.setPositiveButton("Share", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        zzu.zzfq().zzb(zzko.zza(zzko.this), Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str), "Share via"));
      }
    });
    localBuilder.setNegativeButton("Close", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    localBuilder.create().show();
  }
  
  static String zzcu(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "No debug information";
    }
    Object localObject;
    do
    {
      return paramString;
      paramString = paramString.replaceAll("\\+", "%20");
      localObject = new Uri.Builder().encodedQuery(paramString).build();
      paramString = new StringBuilder();
      localObject = zzu.zzfq().zzf((Uri)localObject);
      Iterator localIterator = ((Map)localObject).keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramString.append(str).append(" = ").append((String)((Map)localObject).get(str)).append("\n\n");
      }
      localObject = paramString.toString().trim();
      paramString = (String)localObject;
    } while (!TextUtils.isEmpty((CharSequence)localObject));
    return "No debug information";
  }
  
  void zza(int paramInt, float paramFloat1, float paramFloat2)
  {
    if (paramInt == 0)
    {
      mState = 0;
      zzclq = paramFloat1;
      zzclr = paramFloat2;
      zzcls = paramFloat2;
    }
    label24:
    label224:
    do
    {
      do
      {
        break label24;
        do
        {
          return;
        } while (mState == -1);
        if (paramInt != 2) {
          break;
        }
        if (paramFloat2 > zzclr) {
          zzclr = paramFloat2;
        }
        while (zzclr - zzcls > 30.0F * zzbri)
        {
          mState = -1;
          return;
          if (paramFloat2 < zzcls) {
            zzcls = paramFloat2;
          }
        }
        if ((mState == 0) || (mState == 2)) {
          if (paramFloat1 - zzclq >= 50.0F * zzbri) {
            zzclq = paramFloat1;
          }
        }
        for (mState += 1;; mState += 1)
        {
          do
          {
            if ((mState != 1) && (mState != 3)) {
              break label224;
            }
            if (paramFloat1 <= zzclq) {
              break;
            }
            zzclq = paramFloat1;
            return;
          } while (((mState != 1) && (mState != 3)) || (paramFloat1 - zzclq > -50.0F * zzbri));
          zzclq = paramFloat1;
        }
      } while ((mState != 2) || (paramFloat1 >= zzclq));
      zzclq = paramFloat1;
      return;
    } while ((paramInt != 1) || (mState != 4));
    showDialog();
  }
  
  public void zzct(String paramString)
  {
    zzclp = paramString;
  }
  
  public void zze(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getHistorySize();
    int i = 0;
    while (i < j)
    {
      zza(paramMotionEvent.getActionMasked(), paramMotionEvent.getHistoricalX(0, i), paramMotionEvent.getHistoricalY(0, i));
      i += 1;
    }
    zza(paramMotionEvent.getActionMasked(), paramMotionEvent.getX(), paramMotionEvent.getY());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzko
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */