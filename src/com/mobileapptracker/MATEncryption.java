package com.mobileapptracker;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class MATEncryption
{
  private Cipher cipher;
  private IvParameterSpec ivspec;
  private SecretKeySpec keyspec;
  
  public MATEncryption(String paramString1, String paramString2)
  {
    ivspec = new IvParameterSpec(paramString2.getBytes());
    keyspec = new SecretKeySpec(paramString1.getBytes(), "AES");
    try
    {
      cipher = Cipher.getInstance("AES/CBC/NoPadding");
      return;
    }
    catch (NoSuchAlgorithmException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (NoSuchPaddingException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private static String padString(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    while (i < 16 - j % 16)
    {
      paramString = paramString + ' ';
      i += 1;
    }
    return paramString;
  }
  
  public byte[] encrypt(String paramString)
    throws Exception
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new Exception("Empty string");
    }
    try
    {
      cipher.init(1, keyspec, ivspec);
      paramString = cipher.doFinal(padString(paramString).getBytes());
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new Exception("[encrypt] " + paramString.getMessage());
    }
  }
}

/* Location:
 * Qualified Name:     com.mobileapptracker.MATEncryption
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */