package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public abstract class StatsEvent
  extends AbstractSafeParcelable
{
  public abstract int getEventType();
  
  public abstract long getTimeMillis();
  
  public String toString()
  {
    long l1 = getTimeMillis();
    String str1 = String.valueOf("\t");
    int i = getEventType();
    String str2 = String.valueOf("\t");
    long l2 = zzaup();
    String str3 = String.valueOf(zzaus());
    return String.valueOf(str1).length() + 51 + String.valueOf(str2).length() + String.valueOf(str3).length() + l1 + str1 + i + str2 + l2 + str3;
  }
  
  public abstract long zzaup();
  
  public abstract String zzaus();
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.stats.StatsEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */