package com.mobileapptracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class MATUtils
{
  public static String bytesToHex(byte[] paramArrayOfByte)
  {
    Object localObject;
    if (paramArrayOfByte == null) {
      localObject = null;
    }
    int j;
    int i;
    do
    {
      return (String)localObject;
      j = paramArrayOfByte.length;
      str = "";
      i = 0;
      localObject = str;
    } while (i >= j);
    if ((paramArrayOfByte[i] & 0xFF) < 16) {}
    for (String str = str + "0" + Integer.toHexString(paramArrayOfByte[i] & 0xFF);; str = str + Integer.toHexString(paramArrayOfByte[i] & 0xFF))
    {
      i += 1;
      break;
    }
  }
  
  public static String getStringFromSharedPreferences(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("com.mobileapptracking", 0).getString(paramString, "");
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static String readStream(InputStream paramInputStream)
    throws IOException, UnsupportedEncodingException
  {
    if (paramInputStream != null)
    {
      paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream, "UTF-8"));
      StringBuilder localStringBuilder = new StringBuilder();
      for (;;)
      {
        String str = paramInputStream.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str).append("\n");
      }
      paramInputStream.close();
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static void saveToSharedPreferences(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext.getSharedPreferences("com.mobileapptracking", 0).edit().putString(paramString1, paramString2).commit();
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
}

/* Location:
 * Qualified Name:     com.mobileapptracker.MATUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */