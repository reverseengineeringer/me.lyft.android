package me.lyft.android.domain.ridehistory.charge;

import me.lyft.android.common.INullable;
import me.lyft.android.domain.ridehistory.PaymentBreakdown.ReceiptItem;

public class AccountInfoItem
  extends PaymentBreakdown.ReceiptItem
  implements INullable
{
  public static final String METHOD_CARD = "card";
  public static final String METHOD_COUPON = "coupon";
  public static final String METHOD_CREDITLINE = "creditLine";
  public static final String METHOD_GOOGLE_WALLET = "googleWallet";
  public static final String METHOD_PAYPAL = "paypal";
  private String clientChargeMethod;
  private String type;
  
  public AccountInfoItem(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramString1, paramString2);
    clientChargeMethod = paramString3;
    type = paramString4;
  }
  
  public String getClientChargeMethod()
  {
    return clientChargeMethod;
  }
  
  public String getType()
  {
    return type;
  }
  
  public boolean isCoupon()
  {
    return this instanceof CouponAccountInfoItem;
  }
  
  public boolean isCreditCard()
  {
    return this instanceof CreditCardAccountInfoItem;
  }
  
  public boolean isCreditLine()
  {
    return this instanceof CreditLineAccountInfoItem;
  }
  
  public boolean isGoogleWallet()
  {
    return this instanceof GoogleWalletAccountInfoItem;
  }
  
  public boolean isNull()
  {
    return this instanceof NullAccountInfoItem;
  }
  
  public boolean isPayPal()
  {
    return this instanceof PayPalAccountInfoItem;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.ridehistory.charge.AccountInfoItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */