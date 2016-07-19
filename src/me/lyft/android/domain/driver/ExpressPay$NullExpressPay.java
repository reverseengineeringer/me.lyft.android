package me.lyft.android.domain.driver;

import java.util.Collections;

public class ExpressPay$NullExpressPay
  extends ExpressPay
{
  private static final ExpressPay INSTANCE = new NullExpressPay();
  
  private ExpressPay$NullExpressPay()
  {
    super(Collections.emptyList(), "");
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.ExpressPay.NullExpressPay
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */