package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.List;

public final class WakeLockEvent
  extends StatsEvent
{
  public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zzg();
  private final String AA;
  private final int AB;
  private final List<String> AC;
  private final String AD;
  private int AE;
  private final String AF;
  private final float AG;
  private final String Ay;
  private final String Az;
  private final long mTimeout;
  final int mVersionCode;
  private final long zM;
  private int zN;
  private final long zU;
  private long zW;
  
  WakeLockEvent(int paramInt1, long paramLong1, int paramInt2, String paramString1, int paramInt3, List<String> paramList, String paramString2, long paramLong2, int paramInt4, String paramString3, String paramString4, float paramFloat, long paramLong3, String paramString5)
  {
    mVersionCode = paramInt1;
    zM = paramLong1;
    zN = paramInt2;
    Ay = paramString1;
    Az = paramString3;
    AA = paramString5;
    AB = paramInt3;
    zW = -1L;
    AC = paramList;
    AD = paramString2;
    zU = paramLong2;
    AE = paramInt4;
    AF = paramString4;
    AG = paramFloat;
    mTimeout = paramLong3;
  }
  
  public WakeLockEvent(long paramLong1, int paramInt1, String paramString1, int paramInt2, List<String> paramList, String paramString2, long paramLong2, int paramInt3, String paramString3, String paramString4, float paramFloat, long paramLong3, String paramString5)
  {
    this(2, paramLong1, paramInt1, paramString1, paramInt2, paramList, paramString2, paramLong2, paramInt3, paramString3, paramString4, paramFloat, paramLong3, paramString5);
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
    zzg.zza(this, paramParcel, paramInt);
  }
  
  public String zzauo()
  {
    return AD;
  }
  
  public long zzaup()
  {
    return zW;
  }
  
  public long zzaur()
  {
    return zU;
  }
  
  public String zzaus()
  {
    String str5 = String.valueOf("\t");
    String str6 = String.valueOf(zzauv());
    String str7 = String.valueOf("\t");
    int i = zzauy();
    String str8 = String.valueOf("\t");
    String str1;
    String str9;
    int j;
    String str10;
    String str2;
    label76:
    String str11;
    String str3;
    label94:
    String str12;
    float f;
    String str13;
    if (zzauz() == null)
    {
      str1 = "";
      str9 = String.valueOf("\t");
      j = zzava();
      str10 = String.valueOf("\t");
      if (zzauw() != null) {
        break label345;
      }
      str2 = "";
      str11 = String.valueOf("\t");
      if (zzavb() != null) {
        break label354;
      }
      str3 = "";
      str12 = String.valueOf("\t");
      f = zzavc();
      str13 = String.valueOf("\t");
      if (zzaux() != null) {
        break label363;
      }
    }
    label345:
    label354:
    label363:
    for (String str4 = "";; str4 = zzaux())
    {
      return String.valueOf(str5).length() + 37 + String.valueOf(str6).length() + String.valueOf(str7).length() + String.valueOf(str8).length() + String.valueOf(str1).length() + String.valueOf(str9).length() + String.valueOf(str10).length() + String.valueOf(str2).length() + String.valueOf(str11).length() + String.valueOf(str3).length() + String.valueOf(str12).length() + String.valueOf(str13).length() + String.valueOf(str4).length() + str5 + str6 + str7 + i + str8 + str1 + str9 + j + str10 + str2 + str11 + str3 + str12 + f + str13 + str4;
      str1 = TextUtils.join(",", zzauz());
      break;
      str2 = zzauw();
      break label76;
      str3 = zzavb();
      break label94;
    }
  }
  
  public String zzauv()
  {
    return Ay;
  }
  
  public String zzauw()
  {
    return Az;
  }
  
  public String zzaux()
  {
    return AA;
  }
  
  public int zzauy()
  {
    return AB;
  }
  
  public List<String> zzauz()
  {
    return AC;
  }
  
  public int zzava()
  {
    return AE;
  }
  
  public String zzavb()
  {
    return AF;
  }
  
  public float zzavc()
  {
    return AG;
  }
  
  public long zzavd()
  {
    return mTimeout;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.stats.WakeLockEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */