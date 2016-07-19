package me.lyft.android.domain.ats;

import java.util.Collections;

public class DriverApplicationData$NullDriverApplicationData
  extends DriverApplicationData
{
  private static final DriverApplicationData INSTANCE = new NullDriverApplicationData();
  
  private DriverApplicationData$NullDriverApplicationData()
  {
    super(Collections.emptyList());
  }
  
  public static DriverApplicationData getInstance()
  {
    return INSTANCE;
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.ats.DriverApplicationData.NullDriverApplicationData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */