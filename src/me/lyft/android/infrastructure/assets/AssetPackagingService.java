package me.lyft.android.infrastructure.assets;

import android.content.Context;
import android.content.res.Resources;
import com.squareup.okhttp.OkHttpClient;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.logging.L;
import me.lyft.android.rx.SimpleSubscriber;
import me.lyft.android.utils.FileUtils;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class AssetPackagingService
  implements IAssetPackagingService
{
  final Context context;
  final ILyftPreferences lyftPreferences;
  final OkHttpClient okHttpClient;
  
  public AssetPackagingService(Context paramContext, ILyftPreferences paramILyftPreferences, OkHttpClient paramOkHttpClient)
  {
    context = paramContext;
    lyftPreferences = paramILyftPreferences;
    okHttpClient = paramOkHttpClient;
  }
  
  private Observable<File> downloadAssetsPackage(final String paramString, final File paramFile)
  {
    Observable.create(new Observable.OnSubscribe()
    {
      /* Error */
      public void call(rx.Subscriber<? super File> paramAnonymousSubscriber)
      {
        // Byte code:
        //   0: new 41	com/squareup/okhttp/Request$Builder
        //   3: dup
        //   4: invokespecial 42	com/squareup/okhttp/Request$Builder:<init>	()V
        //   7: aload_0
        //   8: getfield 24	me/lyft/android/infrastructure/assets/AssetPackagingService$5:val$url	Ljava/lang/String;
        //   11: invokevirtual 46	com/squareup/okhttp/Request$Builder:url	(Ljava/lang/String;)Lcom/squareup/okhttp/Request$Builder;
        //   14: invokevirtual 50	com/squareup/okhttp/Request$Builder:get	()Lcom/squareup/okhttp/Request$Builder;
        //   17: invokevirtual 54	com/squareup/okhttp/Request$Builder:build	()Lcom/squareup/okhttp/Request;
        //   20: astore 5
        //   22: aconst_null
        //   23: astore_3
        //   24: aconst_null
        //   25: astore 4
        //   27: aload_3
        //   28: astore_2
        //   29: aload_0
        //   30: getfield 22	me/lyft/android/infrastructure/assets/AssetPackagingService$5:this$0	Lme/lyft/android/infrastructure/assets/AssetPackagingService;
        //   33: getfield 58	me/lyft/android/infrastructure/assets/AssetPackagingService:okHttpClient	Lcom/squareup/okhttp/OkHttpClient;
        //   36: aload 5
        //   38: invokevirtual 64	com/squareup/okhttp/OkHttpClient:newCall	(Lcom/squareup/okhttp/Request;)Lcom/squareup/okhttp/Call;
        //   41: invokevirtual 70	com/squareup/okhttp/Call:execute	()Lcom/squareup/okhttp/Response;
        //   44: astore 5
        //   46: aload_3
        //   47: astore_2
        //   48: new 72	java/io/FileOutputStream
        //   51: dup
        //   52: aload_0
        //   53: getfield 26	me/lyft/android/infrastructure/assets/AssetPackagingService$5:val$file	Ljava/io/File;
        //   56: invokespecial 75	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   59: astore_3
        //   60: aload_3
        //   61: aload 5
        //   63: invokevirtual 81	com/squareup/okhttp/Response:body	()Lcom/squareup/okhttp/ResponseBody;
        //   66: invokevirtual 87	com/squareup/okhttp/ResponseBody:bytes	()[B
        //   69: invokevirtual 93	java/io/OutputStream:write	([B)V
        //   72: aload_1
        //   73: aload_0
        //   74: getfield 26	me/lyft/android/infrastructure/assets/AssetPackagingService$5:val$file	Ljava/io/File;
        //   77: invokevirtual 96	rx/Subscriber:onNext	(Ljava/lang/Object;)V
        //   80: aload_1
        //   81: invokevirtual 99	rx/Subscriber:onCompleted	()V
        //   84: aload_3
        //   85: invokestatic 105	me/lyft/android/common/Closeables:closeQuietly	(Ljava/io/Closeable;)V
        //   88: return
        //   89: astore_2
        //   90: aload 4
        //   92: astore_3
        //   93: aload_2
        //   94: astore 4
        //   96: aload_3
        //   97: astore_2
        //   98: aload_1
        //   99: aload 4
        //   101: invokevirtual 109	rx/Subscriber:onError	(Ljava/lang/Throwable;)V
        //   104: aload_3
        //   105: invokestatic 105	me/lyft/android/common/Closeables:closeQuietly	(Ljava/io/Closeable;)V
        //   108: return
        //   109: astore_1
        //   110: aload_2
        //   111: invokestatic 105	me/lyft/android/common/Closeables:closeQuietly	(Ljava/io/Closeable;)V
        //   114: aload_1
        //   115: athrow
        //   116: astore_1
        //   117: aload_3
        //   118: astore_2
        //   119: goto -9 -> 110
        //   122: astore 4
        //   124: goto -28 -> 96
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	127	0	this	5
        //   0	127	1	paramAnonymousSubscriber	rx.Subscriber<? super File>
        //   28	20	2	localObject1	Object
        //   89	5	2	localThrowable1	Throwable
        //   97	22	2	localObject2	Object
        //   23	95	3	localObject3	Object
        //   25	75	4	localObject4	Object
        //   122	1	4	localThrowable2	Throwable
        //   20	42	5	localObject5	Object
        // Exception table:
        //   from	to	target	type
        //   29	46	89	java/lang/Throwable
        //   48	60	89	java/lang/Throwable
        //   29	46	109	finally
        //   48	60	109	finally
        //   98	104	109	finally
        //   60	84	116	finally
        //   60	84	122	java/lang/Throwable
      }
    });
  }
  
  private void ensureAssetDirectoryCreatedAndClean()
  {
    Object localObject = new File(getAssetsFolderPath());
    ((File)localObject).mkdirs();
    localObject = ((File)localObject).listFiles();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localObject[i].delete();
      i += 1;
    }
  }
  
  private File getAssetFile(String paramString)
  {
    return new File(getAssetsFolderPath(), paramString);
  }
  
  private String getAssetsFolderPath()
  {
    return AssetsPath.get(context);
  }
  
  private File getDownloadedAssetsFile(String paramString)
  {
    return new File(FileUtils.getTempDirectoryPath(context), paramString);
  }
  
  private static String getFileNameWithoutExtensions(String paramString)
  {
    paramString = paramString.substring(paramString.lastIndexOf('/') + 1, paramString.length());
    return paramString.substring(0, paramString.lastIndexOf('.'));
  }
  
  static boolean isUpgrade(String paramString1, String paramString2)
  {
    return paramString2.compareTo(paramString1) > 0;
  }
  
  private Observable<Unit> unpackInputStream(final String paramString, final InputStream paramInputStream)
  {
    Observable.create(new Observable.OnSubscribe()
    {
      /* Error */
      public void call(rx.Subscriber<? super Unit> paramAnonymousSubscriber)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: aconst_null
        //   3: astore 6
        //   5: new 41	java/util/zip/ZipInputStream
        //   8: dup
        //   9: new 43	java/io/BufferedInputStream
        //   12: dup
        //   13: aload_0
        //   14: getfield 24	me/lyft/android/infrastructure/assets/AssetPackagingService$4:val$is	Ljava/io/InputStream;
        //   17: invokespecial 46	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
        //   20: invokespecial 47	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
        //   23: astore 4
        //   25: aload_0
        //   26: getfield 22	me/lyft/android/infrastructure/assets/AssetPackagingService$4:this$0	Lme/lyft/android/infrastructure/assets/AssetPackagingService;
        //   29: invokestatic 51	me/lyft/android/infrastructure/assets/AssetPackagingService:access$100	(Lme/lyft/android/infrastructure/assets/AssetPackagingService;)V
        //   32: aload 4
        //   34: invokevirtual 55	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
        //   37: astore 5
        //   39: aload 5
        //   41: ifnull +124 -> 165
        //   44: aload_1
        //   45: invokevirtual 59	rx/Subscriber:isUnsubscribed	()Z
        //   48: ifeq +7 -> 55
        //   51: aload_1
        //   52: invokevirtual 62	rx/Subscriber:onCompleted	()V
        //   55: new 64	java/io/ByteArrayOutputStream
        //   58: dup
        //   59: invokespecial 65	java/io/ByteArrayOutputStream:<init>	()V
        //   62: astore_3
        //   63: sipush 1024
        //   66: newarray <illegal type>
        //   68: astore 6
        //   70: aload 4
        //   72: aload 6
        //   74: invokevirtual 69	java/util/zip/ZipInputStream:read	([B)I
        //   77: istore_2
        //   78: iload_2
        //   79: iconst_m1
        //   80: if_icmpeq +38 -> 118
        //   83: aload_3
        //   84: aload 6
        //   86: iconst_0
        //   87: iload_2
        //   88: invokevirtual 73	java/io/ByteArrayOutputStream:write	([BII)V
        //   91: goto -21 -> 70
        //   94: astore 5
        //   96: aload 4
        //   98: astore_3
        //   99: aload_1
        //   100: aload 5
        //   102: invokevirtual 77	rx/Subscriber:onError	(Ljava/lang/Throwable;)V
        //   105: aload_0
        //   106: getfield 24	me/lyft/android/infrastructure/assets/AssetPackagingService$4:val$is	Ljava/io/InputStream;
        //   109: invokestatic 83	me/lyft/android/common/Closeables:closeQuietly	(Ljava/io/Closeable;)V
        //   112: aload 4
        //   114: invokestatic 83	me/lyft/android/common/Closeables:closeQuietly	(Ljava/io/Closeable;)V
        //   117: return
        //   118: aload 5
        //   120: invokevirtual 89	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
        //   123: astore 5
        //   125: aload_3
        //   126: invokevirtual 93	java/io/ByteArrayOutputStream:toByteArray	()[B
        //   129: aload_0
        //   130: getfield 22	me/lyft/android/infrastructure/assets/AssetPackagingService$4:this$0	Lme/lyft/android/infrastructure/assets/AssetPackagingService;
        //   133: aload 5
        //   135: invokestatic 97	me/lyft/android/infrastructure/assets/AssetPackagingService:access$200	(Lme/lyft/android/infrastructure/assets/AssetPackagingService;Ljava/lang/String;)Ljava/io/File;
        //   138: invokestatic 102	me/lyft/android/utils/Files:write	([BLjava/io/File;)V
        //   141: aload_3
        //   142: invokestatic 83	me/lyft/android/common/Closeables:closeQuietly	(Ljava/io/Closeable;)V
        //   145: goto -113 -> 32
        //   148: astore_1
        //   149: aload 4
        //   151: astore_3
        //   152: aload_0
        //   153: getfield 24	me/lyft/android/infrastructure/assets/AssetPackagingService$4:val$is	Ljava/io/InputStream;
        //   156: invokestatic 83	me/lyft/android/common/Closeables:closeQuietly	(Ljava/io/Closeable;)V
        //   159: aload_3
        //   160: invokestatic 83	me/lyft/android/common/Closeables:closeQuietly	(Ljava/io/Closeable;)V
        //   163: aload_1
        //   164: athrow
        //   165: aload_0
        //   166: getfield 22	me/lyft/android/infrastructure/assets/AssetPackagingService$4:this$0	Lme/lyft/android/infrastructure/assets/AssetPackagingService;
        //   169: getfield 106	me/lyft/android/infrastructure/assets/AssetPackagingService:lyftPreferences	Lme/lyft/android/ILyftPreferences;
        //   172: aload_0
        //   173: getfield 26	me/lyft/android/infrastructure/assets/AssetPackagingService$4:val$packageName	Ljava/lang/String;
        //   176: invokeinterface 112 2 0
        //   181: aload_1
        //   182: invokestatic 118	me/lyft/android/common/Unit:create	()Lme/lyft/android/common/Unit;
        //   185: invokevirtual 121	rx/Subscriber:onNext	(Ljava/lang/Object;)V
        //   188: aload_1
        //   189: invokevirtual 62	rx/Subscriber:onCompleted	()V
        //   192: aload_0
        //   193: getfield 24	me/lyft/android/infrastructure/assets/AssetPackagingService$4:val$is	Ljava/io/InputStream;
        //   196: invokestatic 83	me/lyft/android/common/Closeables:closeQuietly	(Ljava/io/Closeable;)V
        //   199: aload 4
        //   201: invokestatic 83	me/lyft/android/common/Closeables:closeQuietly	(Ljava/io/Closeable;)V
        //   204: return
        //   205: astore_1
        //   206: goto -54 -> 152
        //   209: astore 5
        //   211: aload 6
        //   213: astore 4
        //   215: goto -119 -> 96
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	218	0	this	4
        //   0	218	1	paramAnonymousSubscriber	rx.Subscriber<? super Unit>
        //   77	11	2	i	int
        //   1	159	3	localObject1	Object
        //   23	191	4	localObject2	Object
        //   37	3	5	localZipEntry	java.util.zip.ZipEntry
        //   94	25	5	localThrowable1	Throwable
        //   123	11	5	str	String
        //   209	1	5	localThrowable2	Throwable
        //   3	209	6	arrayOfByte	byte[]
        // Exception table:
        //   from	to	target	type
        //   25	32	94	java/lang/Throwable
        //   32	39	94	java/lang/Throwable
        //   44	55	94	java/lang/Throwable
        //   55	70	94	java/lang/Throwable
        //   70	78	94	java/lang/Throwable
        //   83	91	94	java/lang/Throwable
        //   118	145	94	java/lang/Throwable
        //   165	192	94	java/lang/Throwable
        //   25	32	148	finally
        //   32	39	148	finally
        //   44	55	148	finally
        //   55	70	148	finally
        //   70	78	148	finally
        //   83	91	148	finally
        //   118	145	148	finally
        //   165	192	148	finally
        //   5	25	205	finally
        //   99	105	205	finally
        //   5	25	209	java/lang/Throwable
      }
    });
  }
  
  public void downloadAssetsIfChanged(String paramString)
  {
    final String str = getFileNameWithoutExtensions(paramString);
    final File localFile = getDownloadedAssetsFile(str);
    boolean bool = isUpgrade(lyftPreferences.getLastUnpackedAssetsPackageName(), str);
    if ((!Strings.isNullOrEmpty(paramString)) && (bool)) {
      downloadAssetsPackage(paramString, localFile).flatMap(new Func1()
      {
        public Observable<? extends Unit> call(File paramAnonymousFile)
        {
          try
          {
            paramAnonymousFile = new FileInputStream(paramAnonymousFile);
            paramAnonymousFile = AssetPackagingService.this.unpackInputStream(str, paramAnonymousFile);
            return paramAnonymousFile;
          }
          catch (Throwable paramAnonymousFile) {}
          return Observable.error(paramAnonymousFile);
        }
      }).doOnNext(new Action1()
      {
        public void call(Unit paramAnonymousUnit)
        {
          localFile.delete();
        }
      }).subscribeOn(Schedulers.newThread()).subscribe(new SimpleSubscriber()
      {
        public void onError(Throwable paramAnonymousThrowable)
        {
          super.onError(paramAnonymousThrowable);
          L.w(paramAnonymousThrowable, "updateAssets", new Object[0]);
        }
      });
    }
  }
  
  public Observable<Unit> unpackEmbededZipResources()
  {
    Resources localResources = context.getResources();
    String str = localResources.getResourceEntryName(2131099649);
    if (!isUpgrade(lyftPreferences.getLastUnpackedAssetsPackageName(), str)) {
      return Unit.just();
    }
    return unpackInputStream(str, localResources.openRawResource(2131099649)).subscribeOn(Schedulers.newThread());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.assets.AssetPackagingService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */