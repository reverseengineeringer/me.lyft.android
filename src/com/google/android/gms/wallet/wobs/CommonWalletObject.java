package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.util.zzb;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

@KeepName
public class CommonWalletObject
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<CommonWalletObject> CREATOR = new zza();
  String aGL;
  String aGN;
  String aGO;
  String aGP;
  String aGQ;
  String aGR;
  ArrayList<WalletObjectMessage> aGS;
  TimeInterval aGT;
  ArrayList<LatLng> aGU;
  String aGV;
  String aGW;
  ArrayList<LabelValueRow> aGX;
  boolean aGY;
  ArrayList<UriData> aGZ;
  ArrayList<TextModuleData> aHa;
  ArrayList<UriData> aHb;
  String id;
  private final int mVersionCode;
  String name;
  int state;
  
  CommonWalletObject()
  {
    mVersionCode = 1;
    aGS = zzb.zzavf();
    aGU = zzb.zzavf();
    aGX = zzb.zzavf();
    aGZ = zzb.zzavf();
    aHa = zzb.zzavf();
    aHb = zzb.zzavf();
  }
  
  CommonWalletObject(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, ArrayList<WalletObjectMessage> paramArrayList, TimeInterval paramTimeInterval, ArrayList<LatLng> paramArrayList1, String paramString9, String paramString10, ArrayList<LabelValueRow> paramArrayList2, boolean paramBoolean, ArrayList<UriData> paramArrayList3, ArrayList<TextModuleData> paramArrayList4, ArrayList<UriData> paramArrayList5)
  {
    mVersionCode = paramInt1;
    id = paramString1;
    aGR = paramString2;
    name = paramString3;
    aGL = paramString4;
    aGN = paramString5;
    aGO = paramString6;
    aGP = paramString7;
    aGQ = paramString8;
    state = paramInt2;
    aGS = paramArrayList;
    aGT = paramTimeInterval;
    aGU = paramArrayList1;
    aGV = paramString9;
    aGW = paramString10;
    aGX = paramArrayList2;
    aGY = paramBoolean;
    aGZ = paramArrayList3;
    aHa = paramArrayList4;
    aHb = paramArrayList5;
  }
  
  public static zza zzcig()
  {
    CommonWalletObject localCommonWalletObject = new CommonWalletObject();
    localCommonWalletObject.getClass();
    return new zza(null);
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public final class zza
  {
    private zza() {}
    
    public CommonWalletObject zzcih()
    {
      return CommonWalletObject.this;
    }
    
    public zza zzqh(String paramString)
    {
      id = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.wobs.CommonWalletObject
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */