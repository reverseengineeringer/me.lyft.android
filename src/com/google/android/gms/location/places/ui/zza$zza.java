package com.google.android.gms.location.places.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources.Theme;
import android.util.TypedValue;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;

public abstract class zza$zza
{
  protected final Intent mIntent;
  
  public zza$zza(String paramString)
  {
    mIntent = new Intent(paramString);
    mIntent.setPackage("com.google.android.gms");
  }
  
  protected Intent build(Activity paramActivity)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    Resources.Theme localTheme = paramActivity.getTheme();
    TypedValue localTypedValue1 = new TypedValue();
    TypedValue localTypedValue2 = new TypedValue();
    if ((localTheme.resolveAttribute(16843827, localTypedValue1, true)) && (!mIntent.hasExtra("primary_color"))) {
      mIntent.putExtra("primary_color", data);
    }
    if ((localTheme.resolveAttribute(16843828, localTypedValue2, true)) && (!mIntent.hasExtra("primary_color_dark"))) {
      mIntent.putExtra("primary_color_dark", data);
    }
    GoogleApiAvailability.getInstance().zzbo(paramActivity);
    return mIntent;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.ui.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */