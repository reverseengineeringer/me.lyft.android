package me.lyft.android.ui.payment;

import com.lyft.scoop.Layout;
import java.util.List;

@Layout(2130903280)
public class PaymentScreens$LyftCreditScreen
  extends PaymentScreens
{
  private final String creditHeader;
  private final List<String> creditRestrictions;
  
  public PaymentScreens$LyftCreditScreen(String paramString, List<String> paramList)
  {
    creditHeader = paramString;
    creditRestrictions = paramList;
  }
  
  public String getCreditHeader()
  {
    return creditHeader;
  }
  
  public List<String> getCreditRestrictions()
  {
    return creditRestrictions;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.PaymentScreens.LyftCreditScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */