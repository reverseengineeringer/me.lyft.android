package me.lyft.android.domain.cost;

import me.lyft.android.domain.payment.NullMoney;

public class NullCostEstimate
  extends CostEstimate
{
  private static final CostEstimate INSTANCE = new NullCostEstimate();
  
  private NullCostEstimate()
  {
    super(0, NullMoney.getInstance(), NullMoney.getInstance(), 0, "", null, NullMoney.getInstance());
  }
  
  public static CostEstimate getInstance()
  {
    return INSTANCE;
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.cost.NullCostEstimate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */