package com.stripe.exception;

public class CardException
  extends StripeException
{
  private static final long serialVersionUID = 1L;
  private String charge;
  private String code;
  private String declineCode;
  private String param;
  
  public CardException(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Throwable paramThrowable)
  {
    super(paramString1, paramThrowable);
    code = paramString2;
    param = paramString3;
    declineCode = paramString4;
    charge = paramString5;
  }
  
  public String getCharge()
  {
    return charge;
  }
  
  public String getCode()
  {
    return code;
  }
  
  public String getDeclineCode()
  {
    return declineCode;
  }
  
  public String getParam()
  {
    return param;
  }
}

/* Location:
 * Qualified Name:     com.stripe.exception.CardException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */