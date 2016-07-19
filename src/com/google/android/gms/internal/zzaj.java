package com.google.android.gms.internal;

import android.util.Base64;

public final class zzaj
{
  public static String zza(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 11;; i = 2) {
      return Base64.encodeToString(paramArrayOfByte, i);
    }
  }
  
  public static byte[] zza(String paramString, boolean paramBoolean)
    throws IllegalArgumentException
  {
    int i;
    byte[] arrayOfByte;
    if (paramBoolean)
    {
      i = 11;
      arrayOfByte = Base64.decode(paramString, i);
      if ((arrayOfByte.length != 0) || (paramString.length() <= 0)) {
        return arrayOfByte;
      }
      paramString = String.valueOf(paramString);
      if (paramString.length() == 0) {
        break label58;
      }
    }
    label58:
    for (paramString = "Unable to decode ".concat(paramString);; paramString = new String("Unable to decode "))
    {
      throw new IllegalArgumentException(paramString);
      i = 2;
      break;
    }
    return arrayOfByte;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzaj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */