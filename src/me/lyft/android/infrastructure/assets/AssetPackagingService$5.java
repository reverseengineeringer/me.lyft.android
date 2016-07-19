package me.lyft.android.infrastructure.assets;

import java.io.File;
import rx.Observable.OnSubscribe;

class AssetPackagingService$5
  implements Observable.OnSubscribe<File>
{
  AssetPackagingService$5(AssetPackagingService paramAssetPackagingService, String paramString, File paramFile) {}
  
  /* Error */
  public void call(rx.Subscriber<? super File> paramSubscriber)
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
    //   0	127	1	paramSubscriber	rx.Subscriber<? super File>
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
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.assets.AssetPackagingService.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */