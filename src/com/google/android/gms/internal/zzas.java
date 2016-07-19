package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.view.MotionEvent;

public class zzas
{
  private static final String[] zzafy = { "/aclk", "/pcs/click" };
  private String zzafu = "googleads.g.doubleclick.net";
  private String zzafv = "/pagead/ads";
  private String zzafw = "ad.doubleclick.net";
  private String[] zzafx = { ".doubleclick.net", ".googleadservices.com", ".googlesyndication.com" };
  private zzan zzafz;
  
  public zzas(zzan paramzzan)
  {
    zzafz = paramzzan;
  }
  
  private Uri zza(Uri paramUri, Context paramContext, String paramString, boolean paramBoolean)
    throws zzat
  {
    boolean bool;
    try
    {
      bool = zzb(paramUri);
      if (bool)
      {
        if (!paramUri.toString().contains("dc_ms=")) {
          break label64;
        }
        throw new zzat("Parameter already exists: dc_ms");
      }
    }
    catch (UnsupportedOperationException paramUri)
    {
      throw new zzat("Provided Uri is not in a valid state");
    }
    if (paramUri.getQueryParameter("ms") != null) {
      throw new zzat("Query parameter already exists: ms");
    }
    label64:
    if (paramBoolean) {}
    for (paramContext = zzafz.zzb(paramContext, paramString); bool; paramContext = zzafz.zzb(paramContext)) {
      return zzb(paramUri, "dc_ms", paramContext);
    }
    paramUri = zza(paramUri, "ms", paramContext);
    return paramUri;
  }
  
  private Uri zza(Uri paramUri, String paramString1, String paramString2)
    throws UnsupportedOperationException
  {
    String str = paramUri.toString();
    int j = str.indexOf("&adurl");
    int i = j;
    if (j == -1) {
      i = str.indexOf("?adurl");
    }
    if (i != -1) {
      return Uri.parse(str.substring(0, i + 1) + paramString1 + "=" + paramString2 + "&" + str.substring(i + 1));
    }
    return paramUri.buildUpon().appendQueryParameter(paramString1, paramString2).build();
  }
  
  private Uri zzb(Uri paramUri, String paramString1, String paramString2)
  {
    String str = paramUri.toString();
    int i = str.indexOf(";adurl");
    if (i != -1) {
      return Uri.parse(str.substring(0, i + 1) + paramString1 + "=" + paramString2 + ";" + str.substring(i + 1));
    }
    paramUri = paramUri.getEncodedPath();
    i = str.indexOf(paramUri);
    return Uri.parse(str.substring(0, paramUri.length() + i) + ";" + paramString1 + "=" + paramString2 + ";" + str.substring(paramUri.length() + i));
  }
  
  public Uri zza(Uri paramUri, Context paramContext)
    throws zzat
  {
    return zza(paramUri, paramContext, null, false);
  }
  
  public void zza(MotionEvent paramMotionEvent)
  {
    zzafz.zza(paramMotionEvent);
  }
  
  public boolean zza(Uri paramUri)
  {
    boolean bool2 = false;
    if (paramUri == null) {
      throw new NullPointerException();
    }
    boolean bool1 = bool2;
    try
    {
      if (paramUri.getHost().equals(zzafu))
      {
        boolean bool3 = paramUri.getPath().equals(zzafv);
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (NullPointerException paramUri) {}
    return false;
  }
  
  public zzan zzax()
  {
    return zzafz;
  }
  
  public Uri zzb(Uri paramUri, Context paramContext)
    throws zzat
  {
    try
    {
      paramUri = zza(paramUri, paramContext, paramUri.getQueryParameter("ai"), true);
      return paramUri;
    }
    catch (UnsupportedOperationException paramUri)
    {
      throw new zzat("Provided Uri is not in a valid state");
    }
  }
  
  public void zzb(String paramString1, String paramString2)
  {
    zzafu = paramString1;
    zzafv = paramString2;
  }
  
  public boolean zzb(Uri paramUri)
  {
    if (paramUri == null) {
      throw new NullPointerException();
    }
    try
    {
      boolean bool = paramUri.getHost().equals(zzafw);
      return bool;
    }
    catch (NullPointerException paramUri) {}
    return false;
  }
  
  public boolean zzc(Uri paramUri)
  {
    boolean bool2 = false;
    if (paramUri == null) {
      throw new NullPointerException();
    }
    try
    {
      paramUri = paramUri.getHost();
      String[] arrayOfString = zzafx;
      int j = arrayOfString.length;
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < j)
        {
          bool1 = paramUri.endsWith(arrayOfString[i]);
          if (bool1) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
      return false;
    }
    catch (NullPointerException paramUri) {}
  }
  
  public boolean zzd(Uri paramUri)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    String[] arrayOfString;
    int j;
    int i;
    if (zzc(paramUri))
    {
      arrayOfString = zzafy;
      j = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        String str = arrayOfString[i];
        if (paramUri.getPath().endsWith(str)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public void zzk(String paramString)
  {
    zzafx = paramString.split(",");
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzas
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */