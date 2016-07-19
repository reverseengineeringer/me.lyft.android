package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;

public final class zzi
{
  private static Boolean AL;
  private static Boolean AM;
  private static Boolean AN;
  private static Boolean AO;
  
  public static boolean zzb(Resources paramResources)
  {
    boolean bool = false;
    if (paramResources == null) {
      return false;
    }
    if (AL == null) {
      if ((getConfigurationscreenLayout & 0xF) <= 3) {
        break label63;
      }
    }
    label63:
    for (int i = 1;; i = 0)
    {
      if (((zzs.zzavj()) && (i != 0)) || (zzc(paramResources))) {
        bool = true;
      }
      AL = Boolean.valueOf(bool);
      return AL.booleanValue();
    }
  }
  
  @TargetApi(13)
  private static boolean zzc(Resources paramResources)
  {
    if (AM == null)
    {
      paramResources = paramResources.getConfiguration();
      if ((!zzs.zzavl()) || ((screenLayout & 0xF) > 3) || (smallestScreenWidthDp < 600)) {
        break label54;
      }
    }
    label54:
    for (boolean bool = true;; bool = false)
    {
      AM = Boolean.valueOf(bool);
      return AM.booleanValue();
    }
  }
  
  @TargetApi(20)
  public static boolean zzck(Context paramContext)
  {
    if (AN == null) {
      if ((!zzs.zzavr()) || (!paramContext.getPackageManager().hasSystemFeature("android.hardware.type.watch"))) {
        break label40;
      }
    }
    label40:
    for (boolean bool = true;; bool = false)
    {
      AN = Boolean.valueOf(bool);
      return AN.booleanValue();
    }
  }
  
  @TargetApi(21)
  public static boolean zzcl(Context paramContext)
  {
    if (AO == null) {
      if ((!zzs.zzavs()) || (!paramContext.getPackageManager().hasSystemFeature("cn.google"))) {
        break label40;
      }
    }
    label40:
    for (boolean bool = true;; bool = false)
    {
      AO = Boolean.valueOf(bool);
      return AO.booleanValue();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.util.zzi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */