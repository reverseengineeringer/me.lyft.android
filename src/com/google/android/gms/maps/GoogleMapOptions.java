package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.R.styleable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  private Boolean agV;
  private Boolean agW;
  private int agX = -1;
  private CameraPosition agY;
  private Boolean agZ;
  private Boolean aha;
  private Boolean ahb;
  private Boolean ahc;
  private Boolean ahd;
  private Boolean ahe;
  private Boolean ahf;
  private Boolean ahg;
  private Boolean ahh;
  private final int mVersionCode;
  
  public GoogleMapOptions()
  {
    mVersionCode = 1;
  }
  
  GoogleMapOptions(int paramInt1, byte paramByte1, byte paramByte2, int paramInt2, CameraPosition paramCameraPosition, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, byte paramByte7, byte paramByte8, byte paramByte9, byte paramByte10, byte paramByte11)
  {
    mVersionCode = paramInt1;
    agV = com.google.android.gms.maps.internal.zza.zza(paramByte1);
    agW = com.google.android.gms.maps.internal.zza.zza(paramByte2);
    agX = paramInt2;
    agY = paramCameraPosition;
    agZ = com.google.android.gms.maps.internal.zza.zza(paramByte3);
    aha = com.google.android.gms.maps.internal.zza.zza(paramByte4);
    ahb = com.google.android.gms.maps.internal.zza.zza(paramByte5);
    ahc = com.google.android.gms.maps.internal.zza.zza(paramByte6);
    ahd = com.google.android.gms.maps.internal.zza.zza(paramByte7);
    ahe = com.google.android.gms.maps.internal.zza.zza(paramByte8);
    ahf = com.google.android.gms.maps.internal.zza.zza(paramByte9);
    ahg = com.google.android.gms.maps.internal.zza.zza(paramByte10);
    ahh = com.google.android.gms.maps.internal.zza.zza(paramByte11);
  }
  
  public static GoogleMapOptions createFromAttributes(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {
      return null;
    }
    TypedArray localTypedArray = paramContext.getResources().obtainAttributes(paramAttributeSet, R.styleable.MapAttrs);
    GoogleMapOptions localGoogleMapOptions = new GoogleMapOptions();
    if (localTypedArray.hasValue(R.styleable.MapAttrs_mapType)) {
      localGoogleMapOptions.mapType(localTypedArray.getInt(R.styleable.MapAttrs_mapType, -1));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_zOrderOnTop)) {
      localGoogleMapOptions.zOrderOnTop(localTypedArray.getBoolean(R.styleable.MapAttrs_zOrderOnTop, false));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_useViewLifecycle)) {
      localGoogleMapOptions.useViewLifecycleInFragment(localTypedArray.getBoolean(R.styleable.MapAttrs_useViewLifecycle, false));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiCompass)) {
      localGoogleMapOptions.compassEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiCompass, true));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiRotateGestures)) {
      localGoogleMapOptions.rotateGesturesEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiRotateGestures, true));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiScrollGestures)) {
      localGoogleMapOptions.scrollGesturesEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiScrollGestures, true));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiTiltGestures)) {
      localGoogleMapOptions.tiltGesturesEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiTiltGestures, true));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiZoomGestures)) {
      localGoogleMapOptions.zoomGesturesEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiZoomGestures, true));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiZoomControls)) {
      localGoogleMapOptions.zoomControlsEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiZoomControls, true));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_liteMode)) {
      localGoogleMapOptions.liteMode(localTypedArray.getBoolean(R.styleable.MapAttrs_liteMode, false));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiMapToolbar)) {
      localGoogleMapOptions.mapToolbarEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiMapToolbar, true));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_ambientEnabled)) {
      localGoogleMapOptions.ambientEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_ambientEnabled, false));
    }
    localGoogleMapOptions.camera(CameraPosition.createFromAttributes(paramContext, paramAttributeSet));
    localTypedArray.recycle();
    return localGoogleMapOptions;
  }
  
  public GoogleMapOptions ambientEnabled(boolean paramBoolean)
  {
    ahh = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions camera(CameraPosition paramCameraPosition)
  {
    agY = paramCameraPosition;
    return this;
  }
  
  public GoogleMapOptions compassEnabled(boolean paramBoolean)
  {
    aha = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public CameraPosition getCamera()
  {
    return agY;
  }
  
  public int getMapType()
  {
    return agX;
  }
  
  int getVersionCode()
  {
    return mVersionCode;
  }
  
  public GoogleMapOptions liteMode(boolean paramBoolean)
  {
    ahf = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions mapToolbarEnabled(boolean paramBoolean)
  {
    ahg = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions mapType(int paramInt)
  {
    agX = paramInt;
    return this;
  }
  
  public GoogleMapOptions rotateGesturesEnabled(boolean paramBoolean)
  {
    ahe = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions scrollGesturesEnabled(boolean paramBoolean)
  {
    ahb = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions tiltGesturesEnabled(boolean paramBoolean)
  {
    ahd = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions useViewLifecycleInFragment(boolean paramBoolean)
  {
    agW = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public GoogleMapOptions zOrderOnTop(boolean paramBoolean)
  {
    agV = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions zoomControlsEnabled(boolean paramBoolean)
  {
    agZ = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions zoomGesturesEnabled(boolean paramBoolean)
  {
    ahc = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  byte zzbpi()
  {
    return com.google.android.gms.maps.internal.zza.zze(agV);
  }
  
  byte zzbpj()
  {
    return com.google.android.gms.maps.internal.zza.zze(agW);
  }
  
  byte zzbpk()
  {
    return com.google.android.gms.maps.internal.zza.zze(agZ);
  }
  
  byte zzbpl()
  {
    return com.google.android.gms.maps.internal.zza.zze(aha);
  }
  
  byte zzbpm()
  {
    return com.google.android.gms.maps.internal.zza.zze(ahb);
  }
  
  byte zzbpn()
  {
    return com.google.android.gms.maps.internal.zza.zze(ahc);
  }
  
  byte zzbpo()
  {
    return com.google.android.gms.maps.internal.zza.zze(ahd);
  }
  
  byte zzbpp()
  {
    return com.google.android.gms.maps.internal.zza.zze(ahe);
  }
  
  byte zzbpq()
  {
    return com.google.android.gms.maps.internal.zza.zze(ahf);
  }
  
  byte zzbpr()
  {
    return com.google.android.gms.maps.internal.zza.zze(ahg);
  }
  
  byte zzbps()
  {
    return com.google.android.gms.maps.internal.zza.zze(ahh);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.GoogleMapOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */