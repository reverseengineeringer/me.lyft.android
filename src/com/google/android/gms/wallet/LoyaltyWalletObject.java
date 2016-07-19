package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.util.zzb;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.LabelValueRow;
import com.google.android.gms.wallet.wobs.LoyaltyPoints;
import com.google.android.gms.wallet.wobs.TextModuleData;
import com.google.android.gms.wallet.wobs.TimeInterval;
import com.google.android.gms.wallet.wobs.UriData;
import com.google.android.gms.wallet.wobs.WalletObjectMessage;
import java.util.ArrayList;

public final class LoyaltyWalletObject
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<LoyaltyWalletObject> CREATOR = new zzk();
  String DP;
  String aGK;
  String aGL;
  String aGM;
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
  LoyaltyPoints aHc;
  String id;
  private final int mVersionCode;
  int state;
  
  LoyaltyWalletObject()
  {
    mVersionCode = 4;
    aGS = zzb.zzavf();
    aGU = zzb.zzavf();
    aGX = zzb.zzavf();
    aGZ = zzb.zzavf();
    aHa = zzb.zzavf();
    aHb = zzb.zzavf();
  }
  
  LoyaltyWalletObject(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, int paramInt2, ArrayList<WalletObjectMessage> paramArrayList, TimeInterval paramTimeInterval, ArrayList<LatLng> paramArrayList1, String paramString11, String paramString12, ArrayList<LabelValueRow> paramArrayList2, boolean paramBoolean, ArrayList<UriData> paramArrayList3, ArrayList<TextModuleData> paramArrayList4, ArrayList<UriData> paramArrayList5, LoyaltyPoints paramLoyaltyPoints)
  {
    mVersionCode = paramInt1;
    id = paramString1;
    aGK = paramString2;
    aGL = paramString3;
    aGM = paramString4;
    DP = paramString5;
    aGN = paramString6;
    aGO = paramString7;
    aGP = paramString8;
    aGQ = paramString9;
    aGR = paramString10;
    state = paramInt2;
    aGS = paramArrayList;
    aGT = paramTimeInterval;
    aGU = paramArrayList1;
    aGV = paramString11;
    aGW = paramString12;
    aGX = paramArrayList2;
    aGY = paramBoolean;
    aGZ = paramArrayList3;
    aHa = paramArrayList4;
    aHb = paramArrayList5;
    aHc = paramLoyaltyPoints;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.LoyaltyWalletObject
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */