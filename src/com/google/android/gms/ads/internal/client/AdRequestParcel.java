package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzir;
import java.util.List;

@zzir
public final class AdRequestParcel
  extends AbstractSafeParcelable
{
  public static final zzg CREATOR = new zzg();
  public final Bundle extras;
  public final int versionCode;
  public final long zzatk;
  public final int zzatl;
  public final List<String> zzatm;
  public final boolean zzatn;
  public final int zzato;
  public final boolean zzatp;
  public final String zzatq;
  public final SearchAdRequestParcel zzatr;
  public final Location zzats;
  public final String zzatt;
  public final Bundle zzatu;
  public final Bundle zzatv;
  public final List<String> zzatw;
  public final String zzatx;
  public final String zzaty;
  public final boolean zzatz;
  
  public AdRequestParcel(int paramInt1, long paramLong, Bundle paramBundle1, int paramInt2, List<String> paramList1, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, SearchAdRequestParcel paramSearchAdRequestParcel, Location paramLocation, String paramString2, Bundle paramBundle2, Bundle paramBundle3, List<String> paramList2, String paramString3, String paramString4, boolean paramBoolean3)
  {
    versionCode = paramInt1;
    zzatk = paramLong;
    Bundle localBundle = paramBundle1;
    if (paramBundle1 == null) {
      localBundle = new Bundle();
    }
    extras = localBundle;
    zzatl = paramInt2;
    zzatm = paramList1;
    zzatn = paramBoolean1;
    zzato = paramInt3;
    zzatp = paramBoolean2;
    zzatq = paramString1;
    zzatr = paramSearchAdRequestParcel;
    zzats = paramLocation;
    zzatt = paramString2;
    zzatu = paramBundle2;
    zzatv = paramBundle3;
    zzatw = paramList2;
    zzatx = paramString3;
    zzaty = paramString4;
    zzatz = paramBoolean3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AdRequestParcel)) {}
    do
    {
      return false;
      paramObject = (AdRequestParcel)paramObject;
    } while ((versionCode != versionCode) || (zzatk != zzatk) || (!zzaa.equal(extras, extras)) || (zzatl != zzatl) || (!zzaa.equal(zzatm, zzatm)) || (zzatn != zzatn) || (zzato != zzato) || (zzatp != zzatp) || (!zzaa.equal(zzatq, zzatq)) || (!zzaa.equal(zzatr, zzatr)) || (!zzaa.equal(zzats, zzats)) || (!zzaa.equal(zzatt, zzatt)) || (!zzaa.equal(zzatu, zzatu)) || (!zzaa.equal(zzatv, zzatv)) || (!zzaa.equal(zzatw, zzatw)) || (!zzaa.equal(zzatx, zzatx)) || (!zzaa.equal(zzaty, zzaty)) || (zzatz != zzatz));
    return true;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { Integer.valueOf(versionCode), Long.valueOf(zzatk), extras, Integer.valueOf(zzatl), zzatm, Boolean.valueOf(zzatn), Integer.valueOf(zzato), Boolean.valueOf(zzatp), zzatq, zzatr, zzats, zzatt, zzatu, zzatv, zzatw, zzatx, zzaty, Boolean.valueOf(zzatz) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.AdRequestParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */