package me.lyft.android.infrastructure.assets;

import java.io.InputStream;
import me.lyft.android.common.Unit;
import rx.Observable.OnSubscribe;

class AssetPackagingService$4
  implements Observable.OnSubscribe<Unit>
{
  AssetPackagingService$4(AssetPackagingService paramAssetPackagingService, InputStream paramInputStream, String paramString) {}
  
  /* Error */
  public void call(rx.Subscriber<? super Unit> paramSubscriber)
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
    //   0	218	1	paramSubscriber	rx.Subscriber<? super Unit>
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
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.assets.AssetPackagingService.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */