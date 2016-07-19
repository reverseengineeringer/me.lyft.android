package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzm
  implements Parcelable.Creator<MaskedWalletRequest>
{
  static void zza(MaskedWalletRequest paramMaskedWalletRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, paramMaskedWalletRequest.getVersionCode());
    zzb.zza(paramParcel, 2, aGk, false);
    zzb.zza(paramParcel, 3, aHg);
    zzb.zza(paramParcel, 4, aHh);
    zzb.zza(paramParcel, 5, aHi);
    zzb.zza(paramParcel, 6, aHj, false);
    zzb.zza(paramParcel, 7, aGd, false);
    zzb.zza(paramParcel, 8, aHk, false);
    zzb.zza(paramParcel, 9, aGu, paramInt, false);
    zzb.zza(paramParcel, 10, aHl);
    zzb.zza(paramParcel, 11, aHm);
    zzb.zza(paramParcel, 12, aHn, paramInt, false);
    zzb.zza(paramParcel, 13, aHo);
    zzb.zza(paramParcel, 14, aHp);
    zzb.zzc(paramParcel, 15, aHq, false);
    zzb.zza(paramParcel, 16, aHr, paramInt, false);
    zzb.zza(paramParcel, 17, aHs, false);
    zzb.zzaj(paramParcel, i);
  }
  
  public MaskedWalletRequest[] zzaac(int paramInt)
  {
    return new MaskedWalletRequest[paramInt];
  }
  
  public MaskedWalletRequest zzsb(Parcel paramParcel)
  {
    int j = zza.zzcl(paramParcel);
    int i = 0;
    String str4 = null;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    String str3 = null;
    String str2 = null;
    String str1 = null;
    Cart localCart = null;
    boolean bool4 = false;
    boolean bool3 = false;
    CountrySpecification[] arrayOfCountrySpecification = null;
    boolean bool2 = true;
    boolean bool1 = true;
    ArrayList localArrayList2 = null;
    PaymentMethodTokenizationParameters localPaymentMethodTokenizationParameters = null;
    ArrayList localArrayList1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzck(paramParcel);
      switch (zza.zzgi(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        str4 = zza.zzq(paramParcel, k);
        break;
      case 3: 
        bool7 = zza.zzc(paramParcel, k);
        break;
      case 4: 
        bool6 = zza.zzc(paramParcel, k);
        break;
      case 5: 
        bool5 = zza.zzc(paramParcel, k);
        break;
      case 6: 
        str3 = zza.zzq(paramParcel, k);
        break;
      case 7: 
        str2 = zza.zzq(paramParcel, k);
        break;
      case 8: 
        str1 = zza.zzq(paramParcel, k);
        break;
      case 9: 
        localCart = (Cart)zza.zza(paramParcel, k, Cart.CREATOR);
        break;
      case 10: 
        bool4 = zza.zzc(paramParcel, k);
        break;
      case 11: 
        bool3 = zza.zzc(paramParcel, k);
        break;
      case 12: 
        arrayOfCountrySpecification = (CountrySpecification[])zza.zzb(paramParcel, k, CountrySpecification.CREATOR);
        break;
      case 13: 
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 14: 
        bool1 = zza.zzc(paramParcel, k);
        break;
      case 15: 
        localArrayList2 = zza.zzc(paramParcel, k, com.google.android.gms.identity.intents.model.CountrySpecification.CREATOR);
        break;
      case 16: 
        localPaymentMethodTokenizationParameters = (PaymentMethodTokenizationParameters)zza.zza(paramParcel, k, PaymentMethodTokenizationParameters.CREATOR);
        break;
      case 17: 
        localArrayList1 = zza.zzad(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new MaskedWalletRequest(i, str4, bool7, bool6, bool5, str3, str2, str1, localCart, bool4, bool3, arrayOfCountrySpecification, bool2, bool1, localArrayList2, localPaymentMethodTokenizationParameters, localArrayList1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.zzm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */