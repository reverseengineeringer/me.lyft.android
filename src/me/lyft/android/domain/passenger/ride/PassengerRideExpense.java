package me.lyft.android.domain.passenger.ride;

import me.lyft.android.common.INullable;
import me.lyft.android.common.Strings;

public class PassengerRideExpense
  implements INullable
{
  private boolean concurEnabled;
  private String expenseCode;
  private String expenseNote;
  private boolean isBusinessProfileEnabled;
  
  public PassengerRideExpense(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2)
  {
    concurEnabled = paramBoolean1;
    expenseNote = Strings.nullToEmpty(paramString1);
    expenseCode = Strings.nullToEmpty(paramString2);
    isBusinessProfileEnabled = paramBoolean2;
  }
  
  public static PassengerRideExpense empty()
  {
    return NullPassengerRideExpense.instance;
  }
  
  public String getExpenseCode()
  {
    return expenseCode;
  }
  
  public String getExpenseNote()
  {
    return expenseNote;
  }
  
  public boolean isBusinessProfileEnabled()
  {
    return isBusinessProfileEnabled;
  }
  
  public boolean isConcurEnabled()
  {
    return concurEnabled;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public static class NullPassengerRideExpense
    extends PassengerRideExpense
  {
    private static final PassengerRideExpense instance = new NullPassengerRideExpense();
    
    public NullPassengerRideExpense()
    {
      super("", "", false);
    }
    
    public boolean isNull()
    {
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ride.PassengerRideExpense
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */