package com.waze.sdk;

import android.util.Base64;
import java.security.NoSuchAlgorithmException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Utils
{
  static byte[] ivBytes = { 105, -35, -88, 69, 92, 125, -44, 37, 75, -13, 83, -73, 115, 48, 78, -20 };
  
  /* Error */
  public static String DecryptData(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: new 43	javax/crypto/spec/IvParameterSpec
    //   3: dup
    //   4: getstatic 26	com/waze/sdk/Utils:ivBytes	[B
    //   7: invokespecial 47	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   10: astore_3
    //   11: ldc 49
    //   13: invokestatic 55	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   16: astore_2
    //   17: new 57	javax/crypto/spec/SecretKeySpec
    //   20: dup
    //   21: aload_1
    //   22: iconst_0
    //   23: invokestatic 63	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   26: ldc 65
    //   28: invokespecial 68	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   31: astore_1
    //   32: aload_2
    //   33: iconst_2
    //   34: aload_1
    //   35: aload_3
    //   36: invokevirtual 72	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   39: aload_2
    //   40: aload_0
    //   41: invokevirtual 76	javax/crypto/Cipher:doFinal	([B)[B
    //   44: astore_0
    //   45: new 78	java/lang/String
    //   48: dup
    //   49: aload_0
    //   50: invokespecial 79	java/lang/String:<init>	([B)V
    //   53: areturn
    //   54: astore_0
    //   55: aconst_null
    //   56: areturn
    //   57: astore_0
    //   58: aconst_null
    //   59: areturn
    //   60: astore_0
    //   61: aconst_null
    //   62: areturn
    //   63: astore_0
    //   64: aconst_null
    //   65: areturn
    //   66: astore_0
    //   67: aconst_null
    //   68: areturn
    //   69: astore_1
    //   70: goto -31 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	paramArrayOfByte	byte[]
    //   0	73	1	paramString	String
    //   16	24	2	localCipher	javax.crypto.Cipher
    //   10	26	3	localIvParameterSpec	javax.crypto.spec.IvParameterSpec
    // Exception table:
    //   from	to	target	type
    //   11	17	54	java/security/NoSuchAlgorithmException
    //   11	17	57	javax/crypto/NoSuchPaddingException
    //   32	39	60	java/security/InvalidKeyException
    //   39	45	63	javax/crypto/IllegalBlockSizeException
    //   39	45	66	javax/crypto/BadPaddingException
    //   32	39	69	java/security/InvalidAlgorithmParameterException
  }
  
  public static String createAESKey()
  {
    try
    {
      KeyGenerator localKeyGenerator = KeyGenerator.getInstance("AES");
      localKeyGenerator.init(128);
      return Base64.encodeToString(localKeyGenerator.generateKey().getEncoded(), 0);
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
    return null;
  }
}

/* Location:
 * Qualified Name:     com.waze.sdk.Utils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */