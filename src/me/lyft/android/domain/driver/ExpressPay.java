package me.lyft.android.domain.driver;

import java.util.Collections;
import java.util.List;
import me.lyft.android.common.INullable;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.payment.LineItem;

public class ExpressPay
  implements INullable
{
  private final List<LineItem> lineItems;
  private final String payoutInfoText;
  
  public ExpressPay(List<LineItem> paramList, String paramString)
  {
    lineItems = paramList;
    payoutInfoText = Strings.nullToEmpty(paramString);
  }
  
  public static ExpressPay empty()
  {
    return NullExpressPay.INSTANCE;
  }
  
  public List<LineItem> getLineItems()
  {
    return lineItems;
  }
  
  public String getPayoutInfoText()
  {
    return payoutInfoText;
  }
  
  public boolean isLastItem(int paramInt)
  {
    return lineItems.size() == paramInt;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public static class NullExpressPay
    extends ExpressPay
  {
    private static final ExpressPay INSTANCE = new NullExpressPay();
    
    private NullExpressPay()
    {
      super("");
    }
    
    public boolean isNull()
    {
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.ExpressPay
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */