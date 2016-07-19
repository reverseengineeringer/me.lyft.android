package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzir;

@zzir
public final class AdLauncherIntentInfoParcel
  extends AbstractSafeParcelable
{
  public static final zzb CREATOR = new zzb();
  public final Intent intent;
  public final String mimeType;
  public final String packageName;
  public final String url;
  public final int versionCode;
  public final String zzbrr;
  public final String zzbrs;
  public final String zzbrt;
  public final String zzbru;
  
  public AdLauncherIntentInfoParcel(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Intent paramIntent)
  {
    versionCode = paramInt;
    zzbrr = paramString1;
    url = paramString2;
    mimeType = paramString3;
    packageName = paramString4;
    zzbrs = paramString5;
    zzbrt = paramString6;
    zzbru = paramString7;
    intent = paramIntent;
  }
  
  public AdLauncherIntentInfoParcel(Intent paramIntent)
  {
    this(2, null, null, null, null, null, null, null, paramIntent);
  }
  
  public AdLauncherIntentInfoParcel(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this(2, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, null);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */