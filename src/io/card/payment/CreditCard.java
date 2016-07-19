package io.card.payment;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.UUID;

public class CreditCard
  implements Parcelable
{
  public static final Parcelable.Creator<CreditCard> CREATOR = new Parcelable.Creator()
  {
    public CreditCard createFromParcel(Parcel paramAnonymousParcel)
    {
      return new CreditCard(paramAnonymousParcel, null);
    }
    
    public CreditCard[] newArray(int paramAnonymousInt)
    {
      return new CreditCard[paramAnonymousInt];
    }
  };
  public static final int EXPIRY_MAX_FUTURE_YEARS = 15;
  private static final String TAG = CreditCard.class.getSimpleName();
  public String cardNumber;
  public String cvv;
  public int expiryMonth = 0;
  public int expiryYear = 0;
  boolean flipped = false;
  public String postalCode;
  String scanId;
  int[] xoff;
  int yoff;
  
  public CreditCard()
  {
    xoff = new int[16];
    scanId = UUID.randomUUID().toString();
  }
  
  private CreditCard(Parcel paramParcel)
  {
    cardNumber = paramParcel.readString();
    expiryMonth = paramParcel.readInt();
    expiryYear = paramParcel.readInt();
    cvv = paramParcel.readString();
    postalCode = paramParcel.readString();
    scanId = paramParcel.readString();
    yoff = paramParcel.readInt();
    xoff = paramParcel.createIntArray();
  }
  
  public CreditCard(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    cardNumber = paramString1;
    expiryMonth = paramInt1;
    expiryYear = paramInt2;
    cvv = paramString2;
    postalCode = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public CardType getCardType()
  {
    return CardType.fromCardNumber(cardNumber);
  }
  
  public String getFormattedCardNumber()
  {
    return CreditCardNumber.formatString(cardNumber);
  }
  
  public String getLastFourDigitsOfCardNumber()
  {
    if (cardNumber != null)
    {
      int i = Math.min(4, cardNumber.length());
      return cardNumber.substring(cardNumber.length() - i);
    }
    return "";
  }
  
  public String getRedactedCardNumber()
  {
    if (cardNumber != null)
    {
      String str = "";
      if (cardNumber.length() > 4) {
        str = "" + String.format(new StringBuilder().append("%").append(cardNumber.length() - 4).append("s").toString(), new Object[] { "" }).replace(' ', '•');
      }
      return CreditCardNumber.formatString(str + getLastFourDigitsOfCardNumber(), false, CardType.fromCardNumber(cardNumber));
    }
    return "";
  }
  
  public boolean isExpiryValid()
  {
    return CreditCardNumber.isDateValid(expiryMonth, expiryYear);
  }
  
  public String toString()
  {
    Object localObject2 = "{" + getCardType() + ": " + getRedactedCardNumber();
    if (expiryMonth <= 0)
    {
      localObject1 = localObject2;
      if (expiryYear <= 0) {}
    }
    else
    {
      localObject1 = (String)localObject2 + "  expiry:" + expiryMonth + "/" + expiryYear;
    }
    localObject2 = localObject1;
    if (postalCode != null) {
      localObject2 = (String)localObject1 + "  postalCode:" + postalCode;
    }
    Object localObject1 = localObject2;
    if (cvv != null)
    {
      localObject1 = new StringBuilder().append((String)localObject2).append("  cvvLength:");
      if (cvv == null) {
        break label196;
      }
    }
    label196:
    for (int i = cvv.length();; i = 0)
    {
      localObject1 = i;
      return (String)localObject1 + "}";
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(cardNumber);
    paramParcel.writeInt(expiryMonth);
    paramParcel.writeInt(expiryYear);
    paramParcel.writeString(cvv);
    paramParcel.writeString(postalCode);
    paramParcel.writeString(scanId);
    paramParcel.writeInt(yoff);
    paramParcel.writeIntArray(xoff);
  }
}

/* Location:
 * Qualified Name:     io.card.payment.CreditCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */