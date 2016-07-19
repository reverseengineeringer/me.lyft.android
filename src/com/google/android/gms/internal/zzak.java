package com.google.android.gms.internal;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class zzak
{
  static boolean zzxe = false;
  private static MessageDigest zzxf = null;
  private static final Object zzxg = new Object();
  private static final Object zzxh = new Object();
  static CountDownLatch zzxi = new CountDownLatch(1);
  
  private static int zza(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 239;
    }
    return 255;
  }
  
  static String zza(zzae.zza paramzza, String paramString, boolean paramBoolean)
    throws NoSuchAlgorithmException, UnsupportedEncodingException
  {
    return zza(zzapc.zzf(paramzza), paramString, paramBoolean);
  }
  
  static String zza(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString1 = zzb(paramString1, paramString2, paramBoolean);
    if (paramString1 != null) {
      return zzaj.zza(paramString1, true);
    }
    return Integer.toString(7);
  }
  
  static String zza(byte[] paramArrayOfByte, String paramString, boolean paramBoolean)
    throws NoSuchAlgorithmException, UnsupportedEncodingException
  {
    if (paramBoolean) {}
    for (paramArrayOfByte = zzb(paramArrayOfByte, paramString);; paramArrayOfByte = zza(paramArrayOfByte, paramString)) {
      return zzaj.zza(paramArrayOfByte, true);
    }
  }
  
  static Vector<byte[]> zza(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    int k = (paramArrayOfByte.length + paramInt - 1) / paramInt;
    Vector localVector = new Vector();
    int i = 0;
    for (;;)
    {
      int m;
      if (i < k) {
        m = i * paramInt;
      }
      try
      {
        if (paramArrayOfByte.length - m > paramInt) {}
        for (int j = m + paramInt;; j = paramArrayOfByte.length)
        {
          localVector.add(Arrays.copyOfRange(paramArrayOfByte, m, j));
          i += 1;
          break;
        }
        return localVector;
      }
      catch (IndexOutOfBoundsException paramArrayOfByte) {}
    }
    return null;
  }
  
  static void zza(String paramString, byte[] paramArrayOfByte)
    throws UnsupportedEncodingException
  {
    String str = paramString;
    if (paramString.length() > 32) {
      str = paramString.substring(0, 32);
    }
    new zzaot(str.getBytes("UTF-8")).zzay(paramArrayOfByte);
  }
  
  static byte[] zza(byte[] paramArrayOfByte, String paramString)
    throws NoSuchAlgorithmException, UnsupportedEncodingException
  {
    Object localObject = zza(paramArrayOfByte, 255);
    if ((localObject == null) || (((Vector)localObject).size() == 0)) {
      return zzb(zzapc.zzf(zzb(4096L)), paramString);
    }
    zzae.zzf localzzf = new zzae.zzf();
    zzey = new byte[((Vector)localObject).size()][];
    localObject = ((Vector)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      byte[] arrayOfByte = zzb((byte[])((Iterator)localObject).next(), paramString, false);
      zzey[i] = arrayOfByte;
      i += 1;
    }
    zzet = zzg(paramArrayOfByte);
    return zzapc.zzf(localzzf);
  }
  
  static void zzas()
  {
    synchronized (zzxh)
    {
      if (!zzxe)
      {
        zzxe = true;
        new Thread(new zza(null)).start();
      }
      return;
    }
  }
  
  static MessageDigest zzat()
  {
    zzas();
    int i = 0;
    try
    {
      boolean bool = zzxi.await(2L, TimeUnit.SECONDS);
      i = bool;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
    if (i == 0) {}
    while (zzxf == null) {
      return null;
    }
    return zzxf;
  }
  
  static zzae.zza zzb(long paramLong)
  {
    zzae.zza localzza = new zzae.zza();
    zzdl = Long.valueOf(paramLong);
    return localzza;
  }
  
  /* Error */
  static byte[] zzb(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 208	com/google/android/gms/internal/zzae$zzc
    //   3: dup
    //   4: invokespecial 209	com/google/android/gms/internal/zzae$zzc:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: invokevirtual 102	java/lang/String:length	()I
    //   12: iconst_3
    //   13: if_icmpge +44 -> 57
    //   16: aload_0
    //   17: ldc -45
    //   19: invokevirtual 114	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   22: astore_0
    //   23: aload_3
    //   24: aload_0
    //   25: putfield 214	com/google/android/gms/internal/zzae$zzc:zzer	[B
    //   28: iload_2
    //   29: ifeq +46 -> 75
    //   32: aload_1
    //   33: invokevirtual 102	java/lang/String:length	()I
    //   36: iconst_3
    //   37: if_icmpge +29 -> 66
    //   40: aload_1
    //   41: ldc -45
    //   43: invokevirtual 114	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   46: astore_0
    //   47: aload_3
    //   48: aload_0
    //   49: putfield 217	com/google/android/gms/internal/zzae$zzc:zzes	[B
    //   52: aload_3
    //   53: invokestatic 51	com/google/android/gms/internal/zzapc:zzf	(Lcom/google/android/gms/internal/zzapc;)[B
    //   56: areturn
    //   57: aload_0
    //   58: iconst_1
    //   59: invokestatic 220	com/google/android/gms/internal/zzaj:zza	(Ljava/lang/String;Z)[B
    //   62: astore_0
    //   63: goto -40 -> 23
    //   66: aload_1
    //   67: iconst_1
    //   68: invokestatic 220	com/google/android/gms/internal/zzaj:zza	(Ljava/lang/String;Z)[B
    //   71: astore_0
    //   72: goto -25 -> 47
    //   75: aload_1
    //   76: ifnull +10 -> 86
    //   79: aload_1
    //   80: invokevirtual 102	java/lang/String:length	()I
    //   83: ifne +16 -> 99
    //   86: iconst_5
    //   87: invokestatic 71	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   90: ldc -45
    //   92: invokevirtual 114	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   95: astore_0
    //   96: goto -49 -> 47
    //   99: aload_1
    //   100: ldc -45
    //   102: invokevirtual 114	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   105: aconst_null
    //   106: iconst_1
    //   107: invokestatic 54	com/google/android/gms/internal/zzak:zza	([BLjava/lang/String;Z)Ljava/lang/String;
    //   110: iconst_1
    //   111: invokestatic 220	com/google/android/gms/internal/zzaj:zza	(Ljava/lang/String;Z)[B
    //   114: astore_0
    //   115: goto -68 -> 47
    //   118: astore_0
    //   119: aconst_null
    //   120: areturn
    //   121: astore_0
    //   122: goto -3 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	paramString1	String
    //   0	125	1	paramString2	String
    //   0	125	2	paramBoolean	boolean
    //   7	46	3	localzzc	zzae.zzc
    // Exception table:
    //   from	to	target	type
    //   8	23	118	java/security/NoSuchAlgorithmException
    //   23	28	118	java/security/NoSuchAlgorithmException
    //   32	47	118	java/security/NoSuchAlgorithmException
    //   47	57	118	java/security/NoSuchAlgorithmException
    //   57	63	118	java/security/NoSuchAlgorithmException
    //   66	72	118	java/security/NoSuchAlgorithmException
    //   79	86	118	java/security/NoSuchAlgorithmException
    //   86	96	118	java/security/NoSuchAlgorithmException
    //   99	115	118	java/security/NoSuchAlgorithmException
    //   8	23	121	java/io/UnsupportedEncodingException
    //   23	28	121	java/io/UnsupportedEncodingException
    //   32	47	121	java/io/UnsupportedEncodingException
    //   47	57	121	java/io/UnsupportedEncodingException
    //   57	63	121	java/io/UnsupportedEncodingException
    //   66	72	121	java/io/UnsupportedEncodingException
    //   79	86	121	java/io/UnsupportedEncodingException
    //   86	96	121	java/io/UnsupportedEncodingException
    //   99	115	121	java/io/UnsupportedEncodingException
  }
  
  static byte[] zzb(byte[] paramArrayOfByte, String paramString)
    throws NoSuchAlgorithmException, UnsupportedEncodingException
  {
    return zzb(paramArrayOfByte, paramString, true);
  }
  
  private static byte[] zzb(byte[] paramArrayOfByte, String paramString, boolean paramBoolean)
    throws NoSuchAlgorithmException, UnsupportedEncodingException
  {
    int i = zza(paramBoolean);
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte.length > i) {
      arrayOfByte = zzapc.zzf(zzb(4096L));
    }
    if (arrayOfByte.length < i)
    {
      paramArrayOfByte = new byte[i - arrayOfByte.length];
      new SecureRandom().nextBytes(paramArrayOfByte);
    }
    for (paramArrayOfByte = ByteBuffer.allocate(i + 1).put((byte)arrayOfByte.length).put(arrayOfByte).put(paramArrayOfByte).array();; paramArrayOfByte = ByteBuffer.allocate(i + 1).put((byte)arrayOfByte.length).put(arrayOfByte).array())
    {
      arrayOfByte = paramArrayOfByte;
      if (paramBoolean)
      {
        arrayOfByte = zzg(paramArrayOfByte);
        arrayOfByte = ByteBuffer.allocate(256).put(arrayOfByte).put(paramArrayOfByte).array();
      }
      paramArrayOfByte = new byte['Ā'];
      new zzal().zzb(arrayOfByte, paramArrayOfByte);
      if ((paramString != null) && (paramString.length() > 0)) {
        zza(paramString, paramArrayOfByte);
      }
      return paramArrayOfByte;
    }
  }
  
  public static byte[] zzg(byte[] paramArrayOfByte)
    throws NoSuchAlgorithmException
  {
    MessageDigest localMessageDigest;
    synchronized (zzxg)
    {
      localMessageDigest = zzat();
      if (localMessageDigest == null) {
        throw new NoSuchAlgorithmException("Cannot compute hash");
      }
    }
    localMessageDigest.reset();
    localMessageDigest.update(paramArrayOfByte);
    paramArrayOfByte = zzxf.digest();
    return paramArrayOfByte;
  }
  
  private static final class zza
    implements Runnable
  {
    public void run()
    {
      try
      {
        zzak.zza(MessageDigest.getInstance("MD5"));
        zzak.zzxi.countDown();
        return;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        localNoSuchAlgorithmException = localNoSuchAlgorithmException;
        zzak.zzxi.countDown();
        return;
      }
      finally
      {
        localObject = finally;
        zzak.zzxi.countDown();
        throw ((Throwable)localObject);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzak
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */