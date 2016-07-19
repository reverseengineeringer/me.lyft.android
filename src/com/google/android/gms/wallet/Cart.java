package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;

public final class Cart
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<Cart> CREATOR = new zzb();
  String aGc;
  String aGd;
  ArrayList<LineItem> aGe;
  private final int mVersionCode;
  
  Cart()
  {
    mVersionCode = 1;
    aGe = new ArrayList();
  }
  
  Cart(int paramInt, String paramString1, String paramString2, ArrayList<LineItem> paramArrayList)
  {
    mVersionCode = paramInt;
    aGc = paramString1;
    aGd = paramString2;
    aGe = paramArrayList;
  }
  
  public static Builder newBuilder()
  {
    Cart localCart = new Cart();
    localCart.getClass();
    return new Builder(null);
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public final class Builder
  {
    private Builder() {}
    
    public Cart build()
    {
      return Cart.this;
    }
    
    public Builder setCurrencyCode(String paramString)
    {
      aGd = paramString;
      return this;
    }
    
    public Builder setTotalPrice(String paramString)
    {
      aGc = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.Cart
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */