package com.google.android.gms.internal;

import android.os.Parcel;
import android.util.Base64;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.zzg;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@zzir
class zzfs
{
  final String zzall;
  final AdRequestParcel zzana;
  final int zzbkx;
  
  zzfs(AdRequestParcel paramAdRequestParcel, String paramString, int paramInt)
  {
    zzana = paramAdRequestParcel;
    zzall = paramString;
    zzbkx = paramInt;
  }
  
  zzfs(zzfq paramzzfq)
  {
    this(paramzzfq.zzls(), paramzzfq.getAdUnitId(), paramzzfq.getNetworkType());
  }
  
  zzfs(String paramString)
    throws IOException
  {
    Object localObject1 = paramString.split("\000");
    if (localObject1.length != 3) {
      throw new IOException("Incorrect field count for QueueSeed.");
    }
    paramString = Parcel.obtain();
    try
    {
      zzall = new String(Base64.decode(localObject1[0], 0), "UTF-8");
      zzbkx = Integer.parseInt(localObject1[1]);
      localObject1 = Base64.decode(localObject1[2], 0);
      paramString.unmarshall((byte[])localObject1, 0, localObject1.length);
      paramString.setDataPosition(0);
      zzana = ((AdRequestParcel)AdRequestParcel.CREATOR.createFromParcel(paramString));
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new IOException("Malformed QueueSeed encoding.");
    }
    finally
    {
      paramString.recycle();
    }
  }
  
  String zzlz()
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      String str1 = Base64.encodeToString(zzall.getBytes("UTF-8"), 0);
      String str2 = Integer.toString(zzbkx);
      zzana.writeToParcel(localParcel, 0);
      String str3 = Base64.encodeToString(localParcel.marshall(), 0);
      str1 = String.valueOf(str1).length() + 2 + String.valueOf(str2).length() + String.valueOf(str3).length() + str1 + "\000" + str2 + "\000" + str3;
      return str1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      zzkh.e("QueueSeed encode failed because UTF-8 is not available.");
      return "";
    }
    finally
    {
      localParcel.recycle();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */