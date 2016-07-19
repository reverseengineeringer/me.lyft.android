package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.google.android.gms.R.style;
import com.google.android.gms.R.styleable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class WalletFragmentStyle
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<WalletFragmentStyle> CREATOR = new zzc();
  Bundle aHU;
  int aIu;
  final int mVersionCode;
  
  public WalletFragmentStyle()
  {
    mVersionCode = 1;
    aHU = new Bundle();
    aHU.putInt("buyButtonAppearanceDefault", 4);
    aHU.putInt("maskedWalletDetailsLogoImageTypeDefault", 3);
  }
  
  WalletFragmentStyle(int paramInt1, Bundle paramBundle, int paramInt2)
  {
    mVersionCode = paramInt1;
    aHU = paramBundle;
    aIu = paramInt2;
  }
  
  private static int zza(long paramLong, DisplayMetrics paramDisplayMetrics)
  {
    int i = (int)(paramLong >>> 32);
    int j = (int)paramLong;
    switch (i)
    {
    default: 
      throw new IllegalStateException(36 + "Unexpected unit or type: " + i);
    case 129: 
      return j;
    case 128: 
      return TypedValue.complexToDimensionPixelSize(j, paramDisplayMetrics);
    case 0: 
      i = 0;
    }
    for (;;)
    {
      return Math.round(TypedValue.applyDimension(i, Float.intBitsToFloat(j), paramDisplayMetrics));
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 5;
    }
  }
  
  private static long zza(TypedValue paramTypedValue)
  {
    switch (type)
    {
    default: 
      int i = type;
      throw new IllegalArgumentException(38 + "Unexpected dimension type: " + i);
    case 16: 
      return zzaas(data);
    }
    return zzw(128, data);
  }
  
  private void zza(TypedArray paramTypedArray, int paramInt, String paramString)
  {
    if (aHU.containsKey(paramString)) {}
    do
    {
      return;
      paramTypedArray = paramTypedArray.peekValue(paramInt);
    } while (paramTypedArray == null);
    aHU.putLong(paramString, zza(paramTypedArray));
  }
  
  private void zza(TypedArray paramTypedArray, int paramInt, String paramString1, String paramString2)
  {
    if ((aHU.containsKey(paramString1)) || (aHU.containsKey(paramString2))) {}
    do
    {
      return;
      paramTypedArray = paramTypedArray.peekValue(paramInt);
    } while (paramTypedArray == null);
    if ((type >= 28) && (type <= 31))
    {
      aHU.putInt(paramString1, data);
      return;
    }
    aHU.putInt(paramString2, resourceId);
  }
  
  private static long zzaas(int paramInt)
  {
    if (paramInt < 0)
    {
      if ((paramInt == -1) || (paramInt == -2)) {
        return zzw(129, paramInt);
      }
      throw new IllegalArgumentException(39 + "Unexpected dimension value: " + paramInt);
    }
    return zzb(0, paramInt);
  }
  
  private static long zzb(int paramInt, float paramFloat)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException(30 + "Unrecognized unit: " + paramInt);
    }
    return zzw(paramInt, Float.floatToIntBits(paramFloat));
  }
  
  private void zzb(TypedArray paramTypedArray, int paramInt, String paramString)
  {
    if (aHU.containsKey(paramString)) {}
    do
    {
      return;
      paramTypedArray = paramTypedArray.peekValue(paramInt);
    } while (paramTypedArray == null);
    aHU.putInt(paramString, data);
  }
  
  private static long zzw(int paramInt1, int paramInt2)
  {
    return paramInt1 << 32 | paramInt2 & 0xFFFFFFFF;
  }
  
  public WalletFragmentStyle setStyleResourceId(int paramInt)
  {
    aIu = paramInt;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public int zza(String paramString, DisplayMetrics paramDisplayMetrics, int paramInt)
  {
    if (aHU.containsKey(paramString)) {
      paramInt = zza(aHU.getLong(paramString), paramDisplayMetrics);
    }
    return paramInt;
  }
  
  public void zzef(Context paramContext)
  {
    if (aIu <= 0) {}
    for (int i = R.style.WalletFragmentDefaultStyle;; i = aIu)
    {
      paramContext = paramContext.obtainStyledAttributes(i, R.styleable.WalletFragmentStyle);
      zza(paramContext, R.styleable.WalletFragmentStyle_buyButtonWidth, "buyButtonWidth");
      zza(paramContext, R.styleable.WalletFragmentStyle_buyButtonHeight, "buyButtonHeight");
      zzb(paramContext, R.styleable.WalletFragmentStyle_buyButtonText, "buyButtonText");
      zzb(paramContext, R.styleable.WalletFragmentStyle_buyButtonAppearance, "buyButtonAppearance");
      zzb(paramContext, R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance, "maskedWalletDetailsTextAppearance");
      zzb(paramContext, R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance, "maskedWalletDetailsHeaderTextAppearance");
      zza(paramContext, R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground, "maskedWalletDetailsBackgroundColor", "maskedWalletDetailsBackgroundResource");
      zzb(paramContext, R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance, "maskedWalletDetailsButtonTextAppearance");
      zza(paramContext, R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground, "maskedWalletDetailsButtonBackgroundColor", "maskedWalletDetailsButtonBackgroundResource");
      zzb(paramContext, R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor, "maskedWalletDetailsLogoTextColor");
      zzb(paramContext, R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType, "maskedWalletDetailsLogoImageType");
      paramContext.recycle();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.fragment.WalletFragmentStyle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */