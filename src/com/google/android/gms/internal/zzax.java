package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.clearcut.zzb;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.zzc;
import com.google.android.gms.gass.internal.zza;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzax
{
  private static final String TAG = zzax.class.getSimpleName();
  protected static final Object zzagr = new Object();
  private static zzc zzagt = null;
  private volatile boolean zzafn = false;
  protected Context zzagf;
  private ExecutorService zzagg;
  private DexClassLoader zzagh;
  private zzau zzagi;
  private byte[] zzagj;
  private volatile AdvertisingIdClient zzagk = null;
  private Future zzagl = null;
  private volatile zzae.zza zzagm = null;
  private Future zzagn = null;
  private zzam zzago;
  private GoogleApiClient zzagp = null;
  protected boolean zzagq = false;
  protected boolean zzags = false;
  protected boolean zzagu = false;
  private Map<Pair<String, String>, zzbo> zzagv;
  
  private zzax(Context paramContext)
  {
    zzagf = paramContext;
    zzagv = new HashMap();
  }
  
  public static zzax zza(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramContext = new zzax(paramContext);
    try
    {
      paramBoolean = paramContext.zzc(paramString1, paramString2, paramBoolean);
      if (paramBoolean) {
        return paramContext;
      }
    }
    catch (zzaw paramContext) {}
    return null;
  }
  
  private File zza(String paramString1, File paramFile, String paramString2)
    throws zzau.zza, IOException
  {
    paramFile = new File(String.format("%s/%s.jar", new Object[] { paramFile, paramString2 }));
    if (!paramFile.exists())
    {
      paramString1 = zzagi.zzc(zzagj, paramString1);
      paramFile.createNewFile();
      paramString2 = new FileOutputStream(paramFile);
      paramString2.write(paramString1, 0, paramString1.length);
      paramString2.close();
    }
    return paramFile;
  }
  
  private void zza(File paramFile)
  {
    if (!paramFile.exists())
    {
      Log.d(TAG, String.format("File %s not found. No need for deletion", new Object[] { paramFile.getAbsolutePath() }));
      return;
    }
    paramFile.delete();
  }
  
  /* Error */
  private void zza(File paramFile, String paramString)
  {
    // Byte code:
    //   0: new 104	java/io/File
    //   3: dup
    //   4: ldc -93
    //   6: iconst_2
    //   7: anewarray 4	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: aload_1
    //   13: aastore
    //   14: dup
    //   15: iconst_1
    //   16: aload_2
    //   17: aastore
    //   18: invokestatic 112	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   21: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore 8
    //   26: aload 8
    //   28: invokevirtual 119	java/io/File:exists	()Z
    //   31: ifeq +4 -> 35
    //   34: return
    //   35: new 104	java/io/File
    //   38: dup
    //   39: ldc -91
    //   41: iconst_2
    //   42: anewarray 4	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: aload_1
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: aload_2
    //   52: aastore
    //   53: invokestatic 112	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   56: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   59: astore 7
    //   61: aload 7
    //   63: invokevirtual 119	java/io/File:exists	()Z
    //   66: ifeq -32 -> 34
    //   69: aconst_null
    //   70: astore 6
    //   72: aload 7
    //   74: invokevirtual 169	java/io/File:length	()J
    //   77: lstore 4
    //   79: lload 4
    //   81: lconst_0
    //   82: lcmp
    //   83: ifle -49 -> 34
    //   86: lload 4
    //   88: l2i
    //   89: newarray <illegal type>
    //   91: astore 9
    //   93: new 171	java/io/FileInputStream
    //   96: dup
    //   97: aload 7
    //   99: invokespecial 172	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   102: astore_1
    //   103: aload_1
    //   104: aload 9
    //   106: invokevirtual 176	java/io/FileInputStream:read	([B)I
    //   109: istore_3
    //   110: iload_3
    //   111: ifgt +18 -> 129
    //   114: aload_1
    //   115: ifnull +7 -> 122
    //   118: aload_1
    //   119: invokevirtual 177	java/io/FileInputStream:close	()V
    //   122: aload_0
    //   123: aload 7
    //   125: invokespecial 179	com/google/android/gms/internal/zzax:zza	(Ljava/io/File;)V
    //   128: return
    //   129: new 181	com/google/android/gms/internal/zzae$zzd
    //   132: dup
    //   133: invokespecial 182	com/google/android/gms/internal/zzae$zzd:<init>	()V
    //   136: astore 6
    //   138: aload 6
    //   140: getstatic 187	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   143: invokevirtual 191	java/lang/String:getBytes	()[B
    //   146: putfield 194	com/google/android/gms/internal/zzae$zzd:zzev	[B
    //   149: aload 6
    //   151: aload_2
    //   152: invokevirtual 191	java/lang/String:getBytes	()[B
    //   155: putfield 197	com/google/android/gms/internal/zzae$zzd:zzeu	[B
    //   158: aload_0
    //   159: getfield 121	com/google/android/gms/internal/zzax:zzagi	Lcom/google/android/gms/internal/zzau;
    //   162: aload_0
    //   163: getfield 123	com/google/android/gms/internal/zzax:zzagj	[B
    //   166: aload 9
    //   168: invokevirtual 201	com/google/android/gms/internal/zzau:zzd	([B[B)Ljava/lang/String;
    //   171: invokevirtual 191	java/lang/String:getBytes	()[B
    //   174: astore_2
    //   175: aload 6
    //   177: aload_2
    //   178: putfield 204	com/google/android/gms/internal/zzae$zzd:data	[B
    //   181: aload 6
    //   183: aload_2
    //   184: invokestatic 210	com/google/android/gms/internal/zzak:zzg	([B)[B
    //   187: putfield 213	com/google/android/gms/internal/zzae$zzd:zzet	[B
    //   190: aload 8
    //   192: invokevirtual 131	java/io/File:createNewFile	()Z
    //   195: pop
    //   196: new 133	java/io/FileOutputStream
    //   199: dup
    //   200: aload 8
    //   202: invokespecial 136	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   205: astore_2
    //   206: aload 6
    //   208: invokestatic 219	com/google/android/gms/internal/zzapc:zzf	(Lcom/google/android/gms/internal/zzapc;)[B
    //   211: astore 6
    //   213: aload_2
    //   214: aload 6
    //   216: iconst_0
    //   217: aload 6
    //   219: arraylength
    //   220: invokevirtual 140	java/io/FileOutputStream:write	([BII)V
    //   223: aload_2
    //   224: invokevirtual 143	java/io/FileOutputStream:close	()V
    //   227: aload_1
    //   228: ifnull +7 -> 235
    //   231: aload_1
    //   232: invokevirtual 177	java/io/FileInputStream:close	()V
    //   235: aload_0
    //   236: aload 7
    //   238: invokespecial 179	com/google/android/gms/internal/zzax:zza	(Ljava/io/File;)V
    //   241: return
    //   242: astore_1
    //   243: aconst_null
    //   244: astore_1
    //   245: aload_1
    //   246: ifnull +7 -> 253
    //   249: aload_1
    //   250: invokevirtual 177	java/io/FileInputStream:close	()V
    //   253: aload_0
    //   254: aload 7
    //   256: invokespecial 179	com/google/android/gms/internal/zzax:zza	(Ljava/io/File;)V
    //   259: return
    //   260: astore_1
    //   261: aload 6
    //   263: astore_2
    //   264: aload_2
    //   265: ifnull +7 -> 272
    //   268: aload_2
    //   269: invokevirtual 177	java/io/FileInputStream:close	()V
    //   272: aload_0
    //   273: aload 7
    //   275: invokespecial 179	com/google/android/gms/internal/zzax:zza	(Ljava/io/File;)V
    //   278: aload_1
    //   279: athrow
    //   280: astore_1
    //   281: goto -159 -> 122
    //   284: astore_1
    //   285: goto -50 -> 235
    //   288: astore_1
    //   289: goto -36 -> 253
    //   292: astore_2
    //   293: goto -21 -> 272
    //   296: astore 6
    //   298: aload_1
    //   299: astore_2
    //   300: aload 6
    //   302: astore_1
    //   303: goto -39 -> 264
    //   306: astore_2
    //   307: goto -62 -> 245
    //   310: astore_1
    //   311: aconst_null
    //   312: astore_1
    //   313: goto -68 -> 245
    //   316: astore_2
    //   317: goto -72 -> 245
    //   320: astore_1
    //   321: aconst_null
    //   322: astore_1
    //   323: goto -78 -> 245
    //   326: astore_2
    //   327: goto -82 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	330	0	this	zzax
    //   0	330	1	paramFile	File
    //   0	330	2	paramString	String
    //   109	2	3	i	int
    //   77	10	4	l	long
    //   70	192	6	localObject1	Object
    //   296	5	6	localObject2	Object
    //   59	215	7	localFile1	File
    //   24	177	8	localFile2	File
    //   91	76	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   93	103	242	java/security/NoSuchAlgorithmException
    //   93	103	260	finally
    //   118	122	280	java/io/IOException
    //   231	235	284	java/io/IOException
    //   249	253	288	java/io/IOException
    //   268	272	292	java/io/IOException
    //   103	110	296	finally
    //   129	227	296	finally
    //   103	110	306	java/security/NoSuchAlgorithmException
    //   129	227	306	java/security/NoSuchAlgorithmException
    //   93	103	310	java/io/IOException
    //   103	110	316	java/io/IOException
    //   129	227	316	java/io/IOException
    //   93	103	320	com/google/android/gms/internal/zzau$zza
    //   103	110	326	com/google/android/gms/internal/zzau$zza
    //   129	227	326	com/google/android/gms/internal/zzau$zza
  }
  
  private boolean zzb(File paramFile, String paramString)
  {
    File localFile = new File(String.format("%s/%s.tmp", new Object[] { paramFile, paramString }));
    if (!localFile.exists()) {}
    do
    {
      return false;
      paramFile = new File(String.format("%s/%s.dex", new Object[] { paramFile, paramString }));
    } while (paramFile.exists());
    try
    {
      long l = localFile.length();
      if (l <= 0L)
      {
        zza(localFile);
        return false;
      }
      Object localObject = new byte[(int)l];
      if (new FileInputStream(localFile).read((byte[])localObject) <= 0)
      {
        Log.d(TAG, "Cannot read the cache data.");
        zza(localFile);
        return false;
      }
      localObject = zzae.zzd.zzd((byte[])localObject);
      if ((!paramString.equals(new String(zzeu))) || (!Arrays.equals(zzet, zzak.zzg(data))) || (!Arrays.equals(zzev, Build.VERSION.SDK.getBytes())))
      {
        zza(localFile);
        return false;
      }
      paramString = zzagi.zzc(zzagj, new String(data));
      paramFile.createNewFile();
      paramFile = new FileOutputStream(paramFile);
      paramFile.write(paramString, 0, paramString.length);
      paramFile.close();
      return true;
    }
    catch (IOException paramFile)
    {
      return false;
    }
    catch (NoSuchAlgorithmException paramFile)
    {
      return false;
    }
    catch (zzau.zza paramFile) {}
    return false;
  }
  
  private void zzc(boolean paramBoolean)
  {
    zzafn = paramBoolean;
    if (!paramBoolean) {
      return;
    }
    zzagl = zzagg.submit(new Runnable()
    {
      public void run()
      {
        zzax.zzb(zzax.this);
      }
    });
  }
  
  private boolean zzc(String paramString1, String paramString2, boolean paramBoolean)
    throws zzaw
  {
    zzagg = Executors.newCachedThreadPool();
    zzc(paramBoolean);
    zzcr();
    zzcp();
    zzagi = new zzau(null);
    try
    {
      zzagj = zzagi.zzl(paramString1);
      paramBoolean = zzm(paramString2);
      zzago = new zzam(this);
      return paramBoolean;
    }
    catch (zzau.zza paramString1)
    {
      throw new zzaw(paramString1);
    }
  }
  
  private void zzco()
  {
    try
    {
      if (zzagk == null)
      {
        AdvertisingIdClient localAdvertisingIdClient = new AdvertisingIdClient(zzagf);
        localAdvertisingIdClient.start();
        zzagk = localAdvertisingIdClient;
      }
      return;
    }
    catch (IOException localIOException)
    {
      zzagk = null;
      return;
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
    {
      for (;;) {}
    }
    catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
    {
      for (;;) {}
    }
  }
  
  private void zzcq()
  {
    if (zzags) {}
    try
    {
      PackageInfo localPackageInfo = zzagf.getPackageManager().getPackageInfo(zzagf.getPackageName(), 0);
      zzagm = zza.zzf(zzagf, zzagf.getPackageName(), Integer.toString(versionCode));
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
  }
  
  private void zzcr()
  {
    boolean bool2 = true;
    zzagt = zzc.zzand();
    if (zzagt.zzbn(zzagf) > 0)
    {
      bool1 = true;
      zzagq = bool1;
      if (zzagt.isGooglePlayServicesAvailable(zzagf) != 0) {
        break label95;
      }
    }
    label95:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzags = bool1;
      if (zzagf.getApplicationContext() != null) {
        zzagp = new GoogleApiClient.Builder(zzagf).addApi(zzb.API).build();
      }
      zzdc.initialize(zzagf);
      return;
      bool1 = false;
      break;
    }
  }
  
  /* Error */
  private boolean zzm(String paramString)
    throws zzaw
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 82	com/google/android/gms/internal/zzax:zzagf	Landroid/content/Context;
    //   4: invokevirtual 380	android/content/Context:getCacheDir	()Ljava/io/File;
    //   7: astore_3
    //   8: aload_3
    //   9: astore_2
    //   10: aload_3
    //   11: ifnonnull +39 -> 50
    //   14: aload_0
    //   15: getfield 82	com/google/android/gms/internal/zzax:zzagf	Landroid/content/Context;
    //   18: ldc_w 382
    //   21: iconst_0
    //   22: invokevirtual 386	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   25: astore_3
    //   26: aload_3
    //   27: astore_2
    //   28: aload_3
    //   29: ifnonnull +21 -> 50
    //   32: new 91	com/google/android/gms/internal/zzaw
    //   35: dup
    //   36: invokespecial 387	com/google/android/gms/internal/zzaw:<init>	()V
    //   39: athrow
    //   40: astore_1
    //   41: new 91	com/google/android/gms/internal/zzaw
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 289	com/google/android/gms/internal/zzaw:<init>	(Ljava/lang/Throwable;)V
    //   49: athrow
    //   50: invokestatic 392	com/google/android/gms/internal/zzav:zzay	()Ljava/lang/String;
    //   53: astore_3
    //   54: aload_0
    //   55: aload_1
    //   56: aload_2
    //   57: aload_3
    //   58: invokespecial 394	com/google/android/gms/internal/zzax:zza	(Ljava/lang/String;Ljava/io/File;Ljava/lang/String;)Ljava/io/File;
    //   61: astore_1
    //   62: aload_0
    //   63: aload_2
    //   64: aload_3
    //   65: invokespecial 396	com/google/android/gms/internal/zzax:zzb	(Ljava/io/File;Ljava/lang/String;)Z
    //   68: pop
    //   69: aload_0
    //   70: new 398	dalvik/system/DexClassLoader
    //   73: dup
    //   74: aload_1
    //   75: invokevirtual 149	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   78: aload_2
    //   79: invokevirtual 149	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   82: aconst_null
    //   83: aload_0
    //   84: getfield 82	com/google/android/gms/internal/zzax:zzagf	Landroid/content/Context;
    //   87: invokevirtual 402	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   90: invokespecial 405	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   93: putfield 407	com/google/android/gms/internal/zzax:zzagh	Ldalvik/system/DexClassLoader;
    //   96: aload_0
    //   97: aload_1
    //   98: invokespecial 179	com/google/android/gms/internal/zzax:zza	(Ljava/io/File;)V
    //   101: aload_0
    //   102: aload_2
    //   103: aload_3
    //   104: invokespecial 409	com/google/android/gms/internal/zzax:zza	(Ljava/io/File;Ljava/lang/String;)V
    //   107: aload_0
    //   108: ldc -91
    //   110: iconst_2
    //   111: anewarray 4	java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: aload_2
    //   117: aastore
    //   118: dup
    //   119: iconst_1
    //   120: aload_3
    //   121: aastore
    //   122: invokestatic 112	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   125: invokespecial 412	com/google/android/gms/internal/zzax:zzn	(Ljava/lang/String;)V
    //   128: iconst_1
    //   129: ireturn
    //   130: astore 4
    //   132: aload_0
    //   133: aload_1
    //   134: invokespecial 179	com/google/android/gms/internal/zzax:zza	(Ljava/io/File;)V
    //   137: aload_0
    //   138: aload_2
    //   139: aload_3
    //   140: invokespecial 409	com/google/android/gms/internal/zzax:zza	(Ljava/io/File;Ljava/lang/String;)V
    //   143: aload_0
    //   144: ldc -91
    //   146: iconst_2
    //   147: anewarray 4	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload_2
    //   153: aastore
    //   154: dup
    //   155: iconst_1
    //   156: aload_3
    //   157: aastore
    //   158: invokestatic 112	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   161: invokespecial 412	com/google/android/gms/internal/zzax:zzn	(Ljava/lang/String;)V
    //   164: aload 4
    //   166: athrow
    //   167: astore_1
    //   168: new 91	com/google/android/gms/internal/zzaw
    //   171: dup
    //   172: aload_1
    //   173: invokespecial 289	com/google/android/gms/internal/zzaw:<init>	(Ljava/lang/Throwable;)V
    //   176: athrow
    //   177: astore_1
    //   178: new 91	com/google/android/gms/internal/zzaw
    //   181: dup
    //   182: aload_1
    //   183: invokespecial 289	com/google/android/gms/internal/zzaw:<init>	(Ljava/lang/Throwable;)V
    //   186: athrow
    //   187: astore_1
    //   188: new 91	com/google/android/gms/internal/zzaw
    //   191: dup
    //   192: aload_1
    //   193: invokespecial 289	com/google/android/gms/internal/zzaw:<init>	(Ljava/lang/Throwable;)V
    //   196: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	zzax
    //   0	197	1	paramString	String
    //   9	144	2	localObject1	Object
    //   7	150	3	localObject2	Object
    //   130	35	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   0	8	40	java/io/FileNotFoundException
    //   14	26	40	java/io/FileNotFoundException
    //   32	40	40	java/io/FileNotFoundException
    //   50	69	40	java/io/FileNotFoundException
    //   96	128	40	java/io/FileNotFoundException
    //   132	167	40	java/io/FileNotFoundException
    //   69	96	130	finally
    //   0	8	167	java/io/IOException
    //   14	26	167	java/io/IOException
    //   32	40	167	java/io/IOException
    //   50	69	167	java/io/IOException
    //   96	128	167	java/io/IOException
    //   132	167	167	java/io/IOException
    //   0	8	177	com/google/android/gms/internal/zzau$zza
    //   14	26	177	com/google/android/gms/internal/zzau$zza
    //   32	40	177	com/google/android/gms/internal/zzau$zza
    //   50	69	177	com/google/android/gms/internal/zzau$zza
    //   96	128	177	com/google/android/gms/internal/zzau$zza
    //   132	167	177	com/google/android/gms/internal/zzau$zza
    //   0	8	187	java/lang/NullPointerException
    //   14	26	187	java/lang/NullPointerException
    //   32	40	187	java/lang/NullPointerException
    //   50	69	187	java/lang/NullPointerException
    //   96	128	187	java/lang/NullPointerException
    //   132	167	187	java/lang/NullPointerException
  }
  
  private void zzn(String paramString)
  {
    zza(new File(paramString));
  }
  
  public Context getContext()
  {
    return zzagf;
  }
  
  public boolean zza(String paramString1, String paramString2, List<Class> paramList)
  {
    if (!zzagv.containsKey(new Pair(paramString1, paramString2)))
    {
      zzagv.put(new Pair(paramString1, paramString2), new zzbo(this, paramString1, paramString2, paramList));
      return true;
    }
    return false;
  }
  
  public int zzau()
  {
    int i = Integer.MIN_VALUE;
    zzam localzzam = zzcl();
    if (localzzam != null) {
      i = localzzam.zzau();
    }
    return i;
  }
  
  public Method zzc(String paramString1, String paramString2)
  {
    paramString1 = (zzbo)zzagv.get(new Pair(paramString1, paramString2));
    if (paramString1 == null) {
      return null;
    }
    return paramString1.zzda();
  }
  
  public ExecutorService zzce()
  {
    return zzagg;
  }
  
  public DexClassLoader zzcf()
  {
    return zzagh;
  }
  
  public zzau zzcg()
  {
    return zzagi;
  }
  
  public byte[] zzch()
  {
    return zzagj;
  }
  
  public GoogleApiClient zzci()
  {
    return zzagp;
  }
  
  public boolean zzcj()
  {
    return zzagq;
  }
  
  public boolean zzck()
  {
    return zzagu;
  }
  
  public zzam zzcl()
  {
    return zzago;
  }
  
  public zzae.zza zzcm()
  {
    return zzagm;
  }
  
  public Future zzcn()
  {
    return zzagn;
  }
  
  void zzcp()
  {
    if (!((Boolean)zzdc.zzbbs.get()).booleanValue()) {
      return;
    }
    zzagn = zzagg.submit(new Runnable()
    {
      public void run()
      {
        zzax.zzc(zzax.this);
      }
    });
  }
  
  public AdvertisingIdClient zzcs()
  {
    if (!zzafn) {
      return null;
    }
    if (zzagk != null) {
      return zzagk;
    }
    if (zzagl != null) {}
    try
    {
      zzagl.get(2000L, TimeUnit.MILLISECONDS);
      zzagl = null;
      return zzagk;
    }
    catch (TimeoutException localTimeoutException)
    {
      for (;;)
      {
        zzagl.cancel(true);
      }
    }
    catch (ExecutionException localExecutionException)
    {
      for (;;) {}
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  public void zzct()
  {
    for (;;)
    {
      synchronized (zzagr)
      {
        if (zzagu) {
          return;
        }
        if ((zzags) && (zzagp != null))
        {
          zzagp.connect();
          zzagu = true;
          return;
        }
      }
      zzagu = false;
    }
  }
  
  public void zzcu()
  {
    synchronized (zzagr)
    {
      if ((zzagu) && (zzagp != null))
      {
        zzagp.disconnect();
        zzagu = false;
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzax
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */