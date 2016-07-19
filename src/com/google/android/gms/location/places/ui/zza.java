package com.google.android.gms.location.places.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources.Theme;
import android.util.TypedValue;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.internal.PlaceEntity;

abstract class zza
{
  public static Place getPlace(Context paramContext, Intent paramIntent)
  {
    zzab.zzb(paramIntent, "intent must not be null");
    zzab.zzb(paramContext, "context must not be null");
    return (Place)zzc.zza(paramIntent, "selected_place", PlaceEntity.CREATOR);
  }
  
  public static Status getStatus(Context paramContext, Intent paramIntent)
  {
    zzab.zzb(paramIntent, "intent must not be null");
    zzab.zzb(paramContext, "context must not be null");
    return (Status)zzc.zza(paramIntent, "status", Status.CREATOR);
  }
  
  protected static abstract class zza
  {
    protected final Intent mIntent;
    
    public zza(String paramString)
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.ui.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */