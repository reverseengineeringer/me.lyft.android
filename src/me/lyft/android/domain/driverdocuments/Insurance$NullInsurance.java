package me.lyft.android.domain.driverdocuments;

public class Insurance$NullInsurance
  extends Insurance
{
  private static final NullInsurance INSTANCE = new NullInsurance();
  
  Insurance$NullInsurance()
  {
    super(null, null, DriverDocument.Status.NONE, null, null);
  }
  
  public static NullInsurance getInstance()
  {
    return INSTANCE;
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driverdocuments.Insurance.NullInsurance
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */