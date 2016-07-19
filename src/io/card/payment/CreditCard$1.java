package io.card.payment;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class CreditCard$1
  implements Parcelable.Creator<CreditCard>
{
  public CreditCard createFromParcel(Parcel paramParcel)
  {
    return new CreditCard(paramParcel, null);
  }
  
  public CreditCard[] newArray(int paramInt)
  {
    return new CreditCard[paramInt];
  }
}

/* Location:
 * Qualified Name:     io.card.payment.CreditCard.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */