package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class zzg
  extends zzaa
{
  private long ajT;
  private String ajU;
  private Boolean ajV;
  
  zzg(zzx paramzzx)
  {
    super(paramzzx);
  }
  
  public String zzbtk()
  {
    zzzg();
    return Build.VERSION.RELEASE;
  }
  
  public long zzbtl()
  {
    zzzg();
    return ajT;
  }
  
  public String zzbtm()
  {
    zzzg();
    return ajU;
  }
  
  public boolean zzdn(Context paramContext)
  {
    if (ajV == null)
    {
      if (!zzbtb().zzabc()) {
        break label33;
      }
      ajV = Boolean.valueOf(true);
    }
    for (;;)
    {
      return ajV.booleanValue();
      label33:
      ajV = Boolean.valueOf(false);
      try
      {
        paramContext = paramContext.getPackageManager();
        if (paramContext != null)
        {
          paramContext.getPackageInfo("com.google.android.gms", 128);
          ajV = Boolean.valueOf(true);
        }
      }
      catch (PackageManager.NameNotFoundException paramContext) {}
    }
  }
  
  public String zzth()
  {
    zzzg();
    return Build.MODEL;
  }
  
  protected void zzwv()
  {
    Object localObject1 = Calendar.getInstance();
    Object localObject2 = TimeUnit.MINUTES;
    int i = ((Calendar)localObject1).get(15);
    ajT = ((TimeUnit)localObject2).convert(((Calendar)localObject1).get(16) + i, TimeUnit.MILLISECONDS);
    localObject2 = Locale.getDefault();
    localObject1 = String.valueOf(((Locale)localObject2).getLanguage().toLowerCase(Locale.ENGLISH));
    localObject2 = String.valueOf(((Locale)localObject2).getCountry().toLowerCase(Locale.ENGLISH));
    ajU = (String.valueOf(localObject1).length() + 1 + String.valueOf(localObject2).length() + (String)localObject1 + "-" + (String)localObject2);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */