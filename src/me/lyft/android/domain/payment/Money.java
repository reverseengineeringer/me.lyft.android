package me.lyft.android.domain.payment;

import me.lyft.android.common.INullable;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Preconditions;

public class Money
  implements INullable
{
  Integer amount;
  String amountCurrency;
  
  private static StringBuilder buildFormat(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramInt;
    paramInt = i;
    if (i < 0)
    {
      localStringBuilder.append('-');
      paramInt = Math.abs(i);
    }
    localStringBuilder.append('$');
    i = paramInt;
    if (paramInt >= 100000)
    {
      localStringBuilder.append(paramInt / 100000);
      localStringBuilder.append(',');
      paramInt %= 100000;
      if (paramInt >= 1000) {
        break label91;
      }
      localStringBuilder.append("00");
      i = paramInt;
    }
    for (;;)
    {
      localStringBuilder.append(i / 100);
      return localStringBuilder;
      label91:
      i = paramInt;
      if (paramInt < 10000)
      {
        localStringBuilder.append('0');
        i = paramInt;
      }
    }
  }
  
  public static Money create(int paramInt, String paramString)
  {
    Preconditions.checkNotNull(paramString, "Money currency cannot be null");
    Money localMoney = new Money();
    amountCurrency = paramString;
    amount = Integer.valueOf(paramInt);
    return localMoney;
  }
  
  public static String format(int paramInt)
  {
    StringBuilder localStringBuilder = buildFormat(paramInt);
    paramInt = Math.abs(paramInt) % 100;
    localStringBuilder.append('.');
    if (paramInt < 10) {
      localStringBuilder.append('0');
    }
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public static String formatIgnorePennies(int paramInt)
  {
    return buildFormat(paramInt).toString();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Money))
    {
      paramObject = (Money)paramObject;
      boolean bool3 = Objects.equals(amount, amount);
      boolean bool4 = Objects.equals(amountCurrency, amountCurrency);
      bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (bool4) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public String format()
  {
    return format(getAmount().intValue());
  }
  
  public String formatIgnorePennies()
  {
    return formatIgnorePennies(getAmount().intValue());
  }
  
  public Integer getAmount()
  {
    return (Integer)Objects.firstNonNull(amount, Integer.valueOf(0));
  }
  
  public String getAmountCurrency()
  {
    return amountCurrency;
  }
  
  public boolean isNull()
  {
    return NullMoney.isNull(this);
  }
  
  public void setAmount(Integer paramInteger)
  {
    amount = paramInteger;
  }
  
  public void setAmountCurrency(String paramString)
  {
    amountCurrency = paramString;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.payment.Money
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */