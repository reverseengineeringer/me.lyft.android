package com.google.android.gms.internal;

import java.security.MessageDigest;

@zzir
public class zzcs
  extends zzcp
{
  private MessageDigest zzatf;
  
  byte[] zza(String[] paramArrayOfString)
  {
    int i = 0;
    Object localObject;
    if (paramArrayOfString.length == 1)
    {
      localObject = zzcr.zzn(zzcr.zzac(paramArrayOfString[0]));
      return (byte[])localObject;
    }
    if (paramArrayOfString.length < 5)
    {
      localObject = new byte[paramArrayOfString.length * 2];
      i = 0;
      while (i < paramArrayOfString.length)
      {
        arrayOfByte = zzq(zzcr.zzac(paramArrayOfString[i]));
        localObject[(i * 2)] = arrayOfByte[0];
        localObject[(i * 2 + 1)] = arrayOfByte[1];
        i += 1;
      }
      return (byte[])localObject;
    }
    byte[] arrayOfByte = new byte[paramArrayOfString.length];
    for (;;)
    {
      localObject = arrayOfByte;
      if (i >= paramArrayOfString.length) {
        break;
      }
      arrayOfByte[i] = zzp(zzcr.zzac(paramArrayOfString[i]));
      i += 1;
    }
  }
  
  public byte[] zzaa(String arg1)
  {
    int i = 4;
    byte[] arrayOfByte1 = zza(???.split(" "));
    zzatf = zzie();
    for (;;)
    {
      synchronized (zzail)
      {
        if (zzatf == null) {
          return new byte[0];
        }
        zzatf.reset();
        zzatf.update(arrayOfByte1);
        arrayOfByte1 = zzatf.digest();
        if (arrayOfByte1.length > 4)
        {
          byte[] arrayOfByte2 = new byte[i];
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte2.length);
          return arrayOfByte2;
        }
      }
      i = localObject.length;
    }
  }
  
  byte zzp(int paramInt)
  {
    return (byte)(paramInt & 0xFF ^ (0xFF00 & paramInt) >> 8 ^ (0xFF0000 & paramInt) >> 16 ^ (0xFF000000 & paramInt) >> 24);
  }
  
  byte[] zzq(int paramInt)
  {
    paramInt = 0xFFFF & paramInt ^ (0xFFFF0000 & paramInt) >> 16;
    return new byte[] { (byte)paramInt, (byte)(paramInt >> 8) };
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzcs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */