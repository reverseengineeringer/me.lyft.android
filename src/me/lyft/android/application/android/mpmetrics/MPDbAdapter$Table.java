package me.lyft.android.application.android.mpmetrics;

public enum MPDbAdapter$Table
{
  EVENTS("events");
  
  private final String mTableName;
  
  private MPDbAdapter$Table(String paramString)
  {
    mTableName = paramString;
  }
  
  public String getName()
  {
    return mTableName;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.android.mpmetrics.MPDbAdapter.Table
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */