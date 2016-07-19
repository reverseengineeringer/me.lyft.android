package com.stripe.model;

public class FraudDetails
  extends StripeObject
{
  public static final String USER_REPORT = "user_report";
  protected String stripeReport;
  protected String userReport;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (FraudDetails)paramObject;
      if (stripeReport != null)
      {
        if (stripeReport.equals(stripeReport)) {}
      }
      else {
        while (stripeReport != null) {
          return false;
        }
      }
      if (userReport == null) {
        break;
      }
    } while (userReport.equals(userReport));
    for (;;)
    {
      return false;
      if (userReport == null) {
        break;
      }
    }
  }
  
  public String getStripeReport()
  {
    return stripeReport;
  }
  
  public String getUserReport()
  {
    return userReport;
  }
  
  public int hashCode()
  {
    int j = 0;
    if (userReport != null) {}
    for (int i = userReport.hashCode();; i = 0)
    {
      if (stripeReport != null) {
        j = stripeReport.hashCode();
      }
      return i * 31 + j;
    }
  }
  
  public void setStripeReport(String paramString)
  {
    stripeReport = paramString;
  }
  
  public void setUserReport(String paramString)
  {
    userReport = paramString;
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.FraudDetails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */