package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import com.google.android.gms.R.styleable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class WalletFragmentOptions
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<WalletFragmentOptions> CREATOR = new zzb();
  private int EP;
  private int aHH;
  private WalletFragmentStyle aIs;
  private int mTheme;
  final int mVersionCode;
  
  private WalletFragmentOptions()
  {
    mVersionCode = 1;
    aHH = 3;
    aIs = new WalletFragmentStyle();
  }
  
  WalletFragmentOptions(int paramInt1, int paramInt2, int paramInt3, WalletFragmentStyle paramWalletFragmentStyle, int paramInt4)
  {
    mVersionCode = paramInt1;
    aHH = paramInt2;
    mTheme = paramInt3;
    aIs = paramWalletFragmentStyle;
    EP = paramInt4;
  }
  
  public static WalletFragmentOptions zzb(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.WalletFragmentOptions);
    int i = paramAttributeSet.getInt(R.styleable.WalletFragmentOptions_appTheme, 0);
    int j = paramAttributeSet.getInt(R.styleable.WalletFragmentOptions_environment, 1);
    int k = paramAttributeSet.getResourceId(R.styleable.WalletFragmentOptions_fragmentStyle, 0);
    int m = paramAttributeSet.getInt(R.styleable.WalletFragmentOptions_fragmentMode, 1);
    paramAttributeSet.recycle();
    paramAttributeSet = new WalletFragmentOptions();
    mTheme = i;
    aHH = j;
    aIs = new WalletFragmentStyle().setStyleResourceId(k);
    aIs.zzef(paramContext);
    EP = m;
    return paramAttributeSet;
  }
  
  public int getEnvironment()
  {
    return aHH;
  }
  
  public WalletFragmentStyle getFragmentStyle()
  {
    return aIs;
  }
  
  public int getMode()
  {
    return EP;
  }
  
  public int getTheme()
  {
    return mTheme;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public void zzef(Context paramContext)
  {
    if (aIs != null) {
      aIs.zzef(paramContext);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.fragment.WalletFragmentOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */