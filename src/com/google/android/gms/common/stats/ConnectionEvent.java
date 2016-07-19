package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ConnectionEvent
  extends StatsEvent
{
  public static final Parcelable.Creator<ConnectionEvent> CREATOR = new zza();
  final int mVersionCode;
  private final long zM;
  private int zN;
  private final String zO;
  private final String zP;
  private final String zQ;
  private final String zR;
  private final String zS;
  private final String zT;
  private final long zU;
  private final long zV;
  private long zW;
  
  ConnectionEvent(int paramInt1, long paramLong1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong2, long paramLong3)
  {
    mVersionCode = paramInt1;
    zM = paramLong1;
    zN = paramInt2;
    zO = paramString1;
    zP = paramString2;
    zQ = paramString3;
    zR = paramString4;
    zW = -1L;
    zS = paramString5;
    zT = paramString6;
    zU = paramLong2;
    zV = paramLong3;
  }
  
  public ConnectionEvent(long paramLong1, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong2, long paramLong3)
  {
    this(1, paramLong1, paramInt, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramLong2, paramLong3);
  }
  
  public int getEventType()
  {
    return zN;
  }
  
  public long getTimeMillis()
  {
    return zM;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public String zzauj()
  {
    return zO;
  }
  
  public String zzauk()
  {
    return zP;
  }
  
  public String zzaul()
  {
    return zQ;
  }
  
  public String zzaum()
  {
    return zR;
  }
  
  public String zzaun()
  {
    return zS;
  }
  
  public String zzauo()
  {
    return zT;
  }
  
  public long zzaup()
  {
    return zW;
  }
  
  public long zzauq()
  {
    return zV;
  }
  
  public long zzaur()
  {
    return zU;
  }
  
  public String zzaus()
  {
    String str2 = String.valueOf("\t");
    String str3 = String.valueOf(zzauj());
    String str4 = String.valueOf(zzauk());
    String str5 = String.valueOf("\t");
    String str6 = String.valueOf(zzaul());
    String str7 = String.valueOf(zzaum());
    String str8 = String.valueOf("\t");
    if (zS == null) {}
    for (String str1 = "";; str1 = zS)
    {
      String str9 = String.valueOf("\t");
      long l = zzauq();
      return String.valueOf(str2).length() + 22 + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + String.valueOf(str6).length() + String.valueOf(str7).length() + String.valueOf(str8).length() + String.valueOf(str1).length() + String.valueOf(str9).length() + str2 + str3 + "/" + str4 + str5 + str6 + "/" + str7 + str8 + str1 + str9 + l;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.stats.ConnectionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */