package me.lyft.android.infrastructure.paypal;

public class PayPalChargeData
{
  private final String deviceData;
  private final String nonce;
  
  public PayPalChargeData(String paramString1, String paramString2)
  {
    nonce = paramString1;
    deviceData = paramString2;
  }
  
  public String getDeviceData()
  {
    return deviceData;
  }
  
  public String getNonce()
  {
    return nonce;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.paypal.PayPalChargeData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */