package me.lyft.android.infrastructure.androidpay;

public class AndroidPayStripeToken
{
  private String label;
  private String token;
  
  public AndroidPayStripeToken(String paramString1, String paramString2)
  {
    token = paramString1;
    label = paramString2;
  }
  
  public String getLabel()
  {
    return label;
  }
  
  public String getToken()
  {
    return token;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.androidpay.AndroidPayStripeToken
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */