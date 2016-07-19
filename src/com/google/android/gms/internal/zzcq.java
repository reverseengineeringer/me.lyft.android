package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

@zzir
public class zzcq
{
  private final int zzasy;
  private final int zzasz;
  private final int zzata;
  private final zzcp zzatb = new zzcs();
  
  public zzcq(int paramInt)
  {
    zzasz = paramInt;
    zzasy = 6;
    zzata = 0;
  }
  
  public String zza(ArrayList<String> paramArrayList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      localStringBuffer.append(((String)paramArrayList.next()).toLowerCase(Locale.US));
      localStringBuffer.append('\n');
    }
    return zzab(localStringBuffer.toString());
  }
  
  String zzab(String paramString)
  {
    Object localObject1 = paramString.split("\n");
    if (localObject1.length == 0) {
      return "";
    }
    paramString = zzif();
    Object localObject2 = new PriorityQueue(zzasz, new Comparator()
    {
      public int zza(zzct.zza paramAnonymouszza1, zzct.zza paramAnonymouszza2)
      {
        int i = zzath - zzath;
        if (i != 0) {
          return i;
        }
        return (int)(value - value);
      }
    });
    int i = 0;
    if (i < localObject1.length)
    {
      String[] arrayOfString = zzcr.zzad(localObject1[i]);
      if (arrayOfString.length == 0) {}
      for (;;)
      {
        i += 1;
        break;
        zzct.zza(arrayOfString, zzasz, zzasy, (PriorityQueue)localObject2);
      }
    }
    localObject1 = ((PriorityQueue)localObject2).iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (zzct.zza)((Iterator)localObject1).next();
        try
        {
          paramString.write(zzatb.zzaa(zzatg));
        }
        catch (IOException localIOException)
        {
          zzkh.zzb("Error while writing hash to byteStream", localIOException);
        }
      }
    }
    return paramString.toString();
  }
  
  zza zzif()
  {
    return new zza();
  }
  
  static class zza
  {
    ByteArrayOutputStream zzatd = new ByteArrayOutputStream(4096);
    Base64OutputStream zzate = new Base64OutputStream(zzatd, 10);
    
    public String toString()
    {
      try
      {
        zzate.close();
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          try
          {
            zzatd.close();
            String str = zzatd.toString();
            return str;
          }
          catch (IOException localIOException2)
          {
            zzkh.zzb("HashManager: Unable to convert to Base64.", localIOException2);
            return "";
          }
          finally
          {
            zzatd = null;
            zzate = null;
          }
          localIOException1 = localIOException1;
          zzkh.zzb("HashManager: Unable to convert to Base64.", localIOException1);
        }
      }
    }
    
    public void write(byte[] paramArrayOfByte)
      throws IOException
    {
      zzate.write(paramArrayOfByte);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzcq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */