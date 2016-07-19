package me.lyft.android.domain.cost;

import me.lyft.android.common.INullable;
import me.lyft.android.common.Preconditions;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.payment.Money;
import me.lyft.android.domain.payment.NullMoney;

public class CostEstimate
  implements INullable
{
  private Money comparisonAmount;
  private String costToken;
  private String errorMessage;
  private Money estimatedCostMax;
  private Money estimatedCostMin;
  private int primeTime;
  private int seats;
  
  CostEstimate(int paramInt1, Money paramMoney1, Money paramMoney2, int paramInt2, String paramString1, String paramString2, Money paramMoney3)
  {
    Preconditions.checkNotNull(paramMoney1);
    Preconditions.checkNotNull(paramMoney2);
    Preconditions.checkNotNull(paramMoney3);
    Preconditions.checkNotNull(paramString1);
    primeTime = paramInt1;
    costToken = paramString2;
    estimatedCostMin = paramMoney1;
    estimatedCostMax = paramMoney2;
    seats = paramInt2;
    comparisonAmount = paramMoney3;
    errorMessage = paramString1;
  }
  
  public static CostEstimate createFromError(String paramString)
  {
    return new CostEstimate(0, NullMoney.getInstance(), NullMoney.getInstance(), 1, paramString, null, NullMoney.getInstance());
  }
  
  public static CostEstimate createFromPrimeTime(int paramInt)
  {
    return new CostEstimate(paramInt, NullMoney.getInstance(), NullMoney.getInstance(), 1, "", null, NullMoney.getInstance());
  }
  
  public static CostEstimate createFromPrimeTimeAndCostToken(String paramString, int paramInt)
  {
    Preconditions.checkNotNull(paramString);
    return new CostEstimate(paramInt, NullMoney.getInstance(), NullMoney.getInstance(), 1, "", paramString, NullMoney.getInstance());
  }
  
  public static CostEstimate createWithCostToken(int paramInt1, Money paramMoney1, Money paramMoney2, int paramInt2, String paramString, Money paramMoney3)
  {
    return new CostEstimate(paramInt1, paramMoney1, paramMoney2, paramInt2, "", paramString, paramMoney3);
  }
  
  public static CostEstimate createWithPrimeTimeAndEstimate(int paramInt, Money paramMoney1, Money paramMoney2)
  {
    return new CostEstimate(paramInt, paramMoney1, paramMoney2, 1, "", null, NullMoney.getInstance());
  }
  
  public static CostEstimate empty()
  {
    return NullCostEstimate.getInstance();
  }
  
  public Money getComparisonAmount()
  {
    return comparisonAmount;
  }
  
  public String getCostToken()
  {
    return costToken;
  }
  
  public String getErrorMessage()
  {
    return errorMessage;
  }
  
  public Money getEstimatedCostMax()
  {
    return estimatedCostMax;
  }
  
  public Money getEstimatedCostMin()
  {
    return estimatedCostMin;
  }
  
  public int getPrimeTime()
  {
    return primeTime;
  }
  
  public int getSeats()
  {
    return seats;
  }
  
  public boolean hasPrice()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!estimatedCostMin.isNull())
    {
      bool1 = bool2;
      if (!Integer.valueOf(0).equals(estimatedCostMin.getAmount()))
      {
        bool1 = bool2;
        if (!estimatedCostMax.isNull())
        {
          bool1 = bool2;
          if (!Integer.valueOf(0).equals(estimatedCostMax.getAmount()))
          {
            bool1 = bool2;
            if (Strings.isNullOrEmpty(errorMessage)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public boolean isPrimeTime()
  {
    return primeTime > 0;
  }
  
  public boolean isRouteValid()
  {
    return Strings.isNullOrEmpty(errorMessage);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.cost.CostEstimate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */