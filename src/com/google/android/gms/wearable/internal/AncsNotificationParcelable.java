package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.wearable.zzd;

public final class AncsNotificationParcelable
  extends AbstractSafeParcelable
  implements zzd
{
  public static final Parcelable.Creator<AncsNotificationParcelable> CREATOR = new zzh();
  private final String Fx;
  private final String Si;
  private final String aJK;
  private final byte aJL;
  private final byte aJM;
  private final byte aJN;
  private final byte aJO;
  private final String aQ;
  private final String dH;
  private final String hz;
  private int mId;
  final int mVersionCode;
  private final String zzcjj;
  
  AncsNotificationParcelable(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, String paramString7)
  {
    mId = paramInt2;
    mVersionCode = paramInt1;
    zzcjj = paramString1;
    aJK = paramString2;
    hz = paramString3;
    Fx = paramString4;
    Si = paramString5;
    dH = paramString6;
    aJL = paramByte1;
    aJM = paramByte2;
    aJN = paramByte3;
    aJO = paramByte4;
    aQ = paramString7;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                return bool1;
                                bool1 = bool3;
                              } while (paramObject == null);
                              bool1 = bool3;
                            } while (getClass() != paramObject.getClass());
                            paramObject = (AncsNotificationParcelable)paramObject;
                            bool1 = bool3;
                          } while (mVersionCode != mVersionCode);
                          bool1 = bool3;
                        } while (mId != mId);
                        bool1 = bool3;
                      } while (aJL != aJL);
                      bool1 = bool3;
                    } while (aJM != aJM);
                    bool1 = bool3;
                  } while (aJN != aJN);
                  bool1 = bool3;
                } while (aJO != aJO);
                bool1 = bool3;
              } while (!zzcjj.equals(zzcjj));
              if (aJK == null) {
                break;
              }
              bool1 = bool3;
            } while (!aJK.equals(aJK));
            bool1 = bool3;
          } while (!hz.equals(hz));
          bool1 = bool3;
        } while (!Fx.equals(Fx));
        bool1 = bool3;
      } while (!Si.equals(Si));
      if (dH == null) {
        break label270;
      }
      bool1 = bool3;
    } while (!dH.equals(dH));
    label240:
    if (aQ != null) {
      bool1 = aQ.equals(aQ);
    }
    for (;;)
    {
      return bool1;
      if (aJK == null) {
        break;
      }
      return false;
      label270:
      if (dH == null) {
        break label240;
      }
      return false;
      bool1 = bool2;
      if (aQ != null) {
        bool1 = false;
      }
    }
  }
  
  public String getDisplayName()
  {
    if (dH == null) {
      return zzcjj;
    }
    return dH;
  }
  
  public int getId()
  {
    return mId;
  }
  
  public String getPackageName()
  {
    return aQ;
  }
  
  public String getTitle()
  {
    return Fx;
  }
  
  public int hashCode()
  {
    int k = 0;
    int m = mVersionCode;
    int n = mId;
    int i1 = zzcjj.hashCode();
    int i;
    int i2;
    int i3;
    int i4;
    if (aJK != null)
    {
      i = aJK.hashCode();
      i2 = hz.hashCode();
      i3 = Fx.hashCode();
      i4 = Si.hashCode();
      if (dH == null) {
        break label196;
      }
    }
    label196:
    for (int j = dH.hashCode();; j = 0)
    {
      int i5 = aJL;
      int i6 = aJM;
      int i7 = aJN;
      int i8 = aJO;
      if (aQ != null) {
        k = aQ.hashCode();
      }
      return (((((j + ((((i + ((m * 31 + n) * 31 + i1) * 31) * 31 + i2) * 31 + i3) * 31 + i4) * 31) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public String toString()
  {
    int i = mVersionCode;
    int j = mId;
    String str1 = zzcjj;
    String str2 = aJK;
    String str3 = hz;
    String str4 = Fx;
    String str5 = Si;
    String str6 = dH;
    int k = aJL;
    int m = aJM;
    int n = aJN;
    int i1 = aJO;
    String str7 = aQ;
    return String.valueOf(str1).length() + 234 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + String.valueOf(str6).length() + String.valueOf(str7).length() + "AncsNotificationParcelable{versionCode=" + i + ", id=" + j + ", appId='" + str1 + "'" + ", dateTime='" + str2 + "'" + ", notificationText='" + str3 + "'" + ", title='" + str4 + "'" + ", subtitle='" + str5 + "'" + ", displayName='" + str6 + "'" + ", eventId=" + k + ", eventFlags=" + m + ", categoryId=" + n + ", categoryCount=" + i1 + ", packageName='" + str7 + "'" + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
  
  public String zzbhi()
  {
    return Si;
  }
  
  public String zzciq()
  {
    return aJK;
  }
  
  public String zzcir()
  {
    return hz;
  }
  
  public byte zzcis()
  {
    return aJL;
  }
  
  public byte zzcit()
  {
    return aJM;
  }
  
  public byte zzciu()
  {
    return aJN;
  }
  
  public byte zzciv()
  {
    return aJO;
  }
  
  public String zzsi()
  {
    return zzcjj;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.AncsNotificationParcelable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */