package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class zzau
{
  private static Cipher zzagb = null;
  private static final Object zzagc = new Object();
  private static final Object zzagd = new Object();
  private final SecureRandom zzaga;
  
  public zzau(SecureRandom paramSecureRandom)
  {
    zzaga = paramSecureRandom;
  }
  
  private Cipher getCipher()
    throws NoSuchAlgorithmException, NoSuchPaddingException
  {
    synchronized (zzagd)
    {
      if (zzagb == null) {
        zzagb = Cipher.getInstance("AES/CBC/PKCS5Padding");
      }
      Cipher localCipher = zzagb;
      return localCipher;
    }
  }
  
  static void zzh(byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ 0x44));
      i += 1;
    }
  }
  
  public byte[] zzc(byte[] arg1, String paramString)
    throws zzau.zza
  {
    if (???.length != 16) {
      throw new zza();
    }
    try
    {
      arrayOfByte = zzaj.zza(paramString, false);
      if (arrayOfByte.length <= 16) {
        throw new zza();
      }
    }
    catch (NoSuchAlgorithmException ???)
    {
      throw new zza(???);
      Object localObject = ByteBuffer.allocate(arrayOfByte.length);
      ((ByteBuffer)localObject).put(arrayOfByte);
      ((ByteBuffer)localObject).flip();
      paramString = new byte[16];
      byte[] arrayOfByte = new byte[arrayOfByte.length - 16];
      ((ByteBuffer)localObject).get(paramString);
      ((ByteBuffer)localObject).get(arrayOfByte);
      localObject = new SecretKeySpec(???, "AES");
      synchronized (zzagc)
      {
        getCipher().init(2, (Key)localObject, new IvParameterSpec(paramString));
        paramString = getCipher().doFinal(arrayOfByte);
        return paramString;
      }
    }
    catch (InvalidKeyException ???)
    {
      throw new zza(???);
    }
    catch (IllegalBlockSizeException ???)
    {
      throw new zza(???);
    }
    catch (NoSuchPaddingException ???)
    {
      throw new zza(???);
    }
    catch (BadPaddingException ???)
    {
      throw new zza(???);
    }
    catch (InvalidAlgorithmParameterException ???)
    {
      throw new zza(???);
    }
    catch (IllegalArgumentException ???)
    {
      throw new zza(???);
    }
  }
  
  /* Error */
  public String zzd(byte[] arg1, byte[] paramArrayOfByte2)
    throws zzau.zza
  {
    // Byte code:
    //   0: aload_1
    //   1: arraylength
    //   2: bipush 16
    //   4: if_icmpeq +12 -> 16
    //   7: new 6	com/google/android/gms/internal/zzau$zza
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 61	com/google/android/gms/internal/zzau$zza:<init>	(Lcom/google/android/gms/internal/zzau;)V
    //   15: athrow
    //   16: new 88	javax/crypto/spec/SecretKeySpec
    //   19: dup
    //   20: aload_1
    //   21: ldc 90
    //   23: invokespecial 93	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   26: astore 4
    //   28: getstatic 23	com/google/android/gms/internal/zzau:zzagc	Ljava/lang/Object;
    //   31: astore_1
    //   32: aload_1
    //   33: monitorenter
    //   34: aload_0
    //   35: invokespecial 95	com/google/android/gms/internal/zzau:getCipher	()Ljavax/crypto/Cipher;
    //   38: iconst_1
    //   39: aload 4
    //   41: aload_0
    //   42: getfield 29	com/google/android/gms/internal/zzau:zzaga	Ljava/security/SecureRandom;
    //   45: invokevirtual 112	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/SecureRandom;)V
    //   48: aload_0
    //   49: invokespecial 95	com/google/android/gms/internal/zzau:getCipher	()Ljavax/crypto/Cipher;
    //   52: aload_2
    //   53: invokevirtual 107	javax/crypto/Cipher:doFinal	([B)[B
    //   56: astore_2
    //   57: aload_0
    //   58: invokespecial 95	com/google/android/gms/internal/zzau:getCipher	()Ljavax/crypto/Cipher;
    //   61: invokevirtual 116	javax/crypto/Cipher:getIV	()[B
    //   64: astore 4
    //   66: aload_1
    //   67: monitorexit
    //   68: aload_2
    //   69: arraylength
    //   70: aload 4
    //   72: arraylength
    //   73: iadd
    //   74: istore_3
    //   75: iload_3
    //   76: invokestatic 75	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   79: astore_1
    //   80: aload_1
    //   81: aload 4
    //   83: invokevirtual 79	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   86: aload_2
    //   87: invokevirtual 79	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   90: pop
    //   91: aload_1
    //   92: invokevirtual 83	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   95: pop
    //   96: iload_3
    //   97: newarray <illegal type>
    //   99: astore_2
    //   100: aload_1
    //   101: aload_2
    //   102: invokevirtual 86	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   105: pop
    //   106: aload_2
    //   107: iconst_0
    //   108: invokestatic 119	com/google/android/gms/internal/zzaj:zza	([BZ)Ljava/lang/String;
    //   111: astore_1
    //   112: aload_1
    //   113: areturn
    //   114: astore_2
    //   115: aload_1
    //   116: monitorexit
    //   117: aload_2
    //   118: athrow
    //   119: astore_1
    //   120: new 6	com/google/android/gms/internal/zzau$zza
    //   123: dup
    //   124: aload_0
    //   125: aload_1
    //   126: invokespecial 69	com/google/android/gms/internal/zzau$zza:<init>	(Lcom/google/android/gms/internal/zzau;Ljava/lang/Throwable;)V
    //   129: athrow
    //   130: astore_1
    //   131: new 6	com/google/android/gms/internal/zzau$zza
    //   134: dup
    //   135: aload_0
    //   136: aload_1
    //   137: invokespecial 69	com/google/android/gms/internal/zzau$zza:<init>	(Lcom/google/android/gms/internal/zzau;Ljava/lang/Throwable;)V
    //   140: athrow
    //   141: astore_1
    //   142: new 6	com/google/android/gms/internal/zzau$zza
    //   145: dup
    //   146: aload_0
    //   147: aload_1
    //   148: invokespecial 69	com/google/android/gms/internal/zzau$zza:<init>	(Lcom/google/android/gms/internal/zzau;Ljava/lang/Throwable;)V
    //   151: athrow
    //   152: astore_1
    //   153: new 6	com/google/android/gms/internal/zzau$zza
    //   156: dup
    //   157: aload_0
    //   158: aload_1
    //   159: invokespecial 69	com/google/android/gms/internal/zzau$zza:<init>	(Lcom/google/android/gms/internal/zzau;Ljava/lang/Throwable;)V
    //   162: athrow
    //   163: astore_1
    //   164: new 6	com/google/android/gms/internal/zzau$zza
    //   167: dup
    //   168: aload_0
    //   169: aload_1
    //   170: invokespecial 69	com/google/android/gms/internal/zzau$zza:<init>	(Lcom/google/android/gms/internal/zzau;Ljava/lang/Throwable;)V
    //   173: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	zzau
    //   0	174	2	paramArrayOfByte2	byte[]
    //   74	23	3	i	int
    //   26	56	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   34	68	114	finally
    //   115	117	114	finally
    //   16	34	119	java/security/NoSuchAlgorithmException
    //   68	112	119	java/security/NoSuchAlgorithmException
    //   117	119	119	java/security/NoSuchAlgorithmException
    //   16	34	130	java/security/InvalidKeyException
    //   68	112	130	java/security/InvalidKeyException
    //   117	119	130	java/security/InvalidKeyException
    //   16	34	141	javax/crypto/IllegalBlockSizeException
    //   68	112	141	javax/crypto/IllegalBlockSizeException
    //   117	119	141	javax/crypto/IllegalBlockSizeException
    //   16	34	152	javax/crypto/NoSuchPaddingException
    //   68	112	152	javax/crypto/NoSuchPaddingException
    //   117	119	152	javax/crypto/NoSuchPaddingException
    //   16	34	163	javax/crypto/BadPaddingException
    //   68	112	163	javax/crypto/BadPaddingException
    //   117	119	163	javax/crypto/BadPaddingException
  }
  
  public byte[] zzl(String paramString)
    throws zzau.zza
  {
    try
    {
      paramString = zzaj.zza(paramString, false);
      if (paramString.length != 32) {
        throw new zza();
      }
    }
    catch (IllegalArgumentException paramString)
    {
      throw new zza(paramString);
    }
    paramString = ByteBuffer.wrap(paramString, 4, 16);
    byte[] arrayOfByte = new byte[16];
    paramString.get(arrayOfByte);
    zzh(arrayOfByte);
    return arrayOfByte;
  }
  
  public class zza
    extends Exception
  {
    public zza() {}
    
    public zza(Throwable paramThrowable)
    {
      super();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzau
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */