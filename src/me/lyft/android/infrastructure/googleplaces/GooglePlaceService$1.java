package me.lyft.android.infrastructure.googleplaces;

import java.util.List;
import me.lyft.android.domain.googleplaces.GooglePlace;
import rx.Observable.OnSubscribe;

class GooglePlaceService$1
  implements Observable.OnSubscribe<List<GooglePlace>>
{
  GooglePlaceService$1(GooglePlaceService paramGooglePlaceService) {}
  
  /* Error */
  public void call(rx.Subscriber<? super List<GooglePlace>> paramSubscriber)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: getstatic 37	com/google/android/gms/location/places/Places:PlaceDetectionApi	Lcom/google/android/gms/location/places/PlaceDetectionApi;
    //   7: aload_0
    //   8: getfield 18	me/lyft/android/infrastructure/googleplaces/GooglePlaceService$1:this$0	Lme/lyft/android/infrastructure/googleplaces/GooglePlaceService;
    //   11: invokestatic 41	me/lyft/android/infrastructure/googleplaces/GooglePlaceService:access$000	(Lme/lyft/android/infrastructure/googleplaces/GooglePlaceService;)Lme/lyft/android/infrastructure/googleplay/IGoogleApiProvider;
    //   14: invokeinterface 47 1 0
    //   19: aconst_null
    //   20: invokeinterface 53 3 0
    //   25: invokevirtual 59	com/google/android/gms/common/api/PendingResult:await	()Lcom/google/android/gms/common/api/Result;
    //   28: checkcast 61	com/google/android/gms/location/places/PlaceLikelihoodBuffer
    //   31: astore 4
    //   33: aload 4
    //   35: astore_2
    //   36: aload 4
    //   38: astore_3
    //   39: aload 4
    //   41: invokevirtual 65	com/google/android/gms/location/places/PlaceLikelihoodBuffer:getStatus	()Lcom/google/android/gms/common/api/Status;
    //   44: invokevirtual 71	com/google/android/gms/common/api/Status:isSuccess	()Z
    //   47: ifeq +139 -> 186
    //   50: aload 4
    //   52: astore_2
    //   53: aload 4
    //   55: astore_3
    //   56: new 73	java/util/ArrayList
    //   59: dup
    //   60: aload 4
    //   62: invokevirtual 77	com/google/android/gms/location/places/PlaceLikelihoodBuffer:getCount	()I
    //   65: invokespecial 80	java/util/ArrayList:<init>	(I)V
    //   68: astore 5
    //   70: aload 4
    //   72: astore_2
    //   73: aload 4
    //   75: astore_3
    //   76: aload 4
    //   78: invokevirtual 84	com/google/android/gms/location/places/PlaceLikelihoodBuffer:iterator	()Ljava/util/Iterator;
    //   81: astore 6
    //   83: aload 4
    //   85: astore_2
    //   86: aload 4
    //   88: astore_3
    //   89: aload 6
    //   91: invokeinterface 89 1 0
    //   96: ifeq +57 -> 153
    //   99: aload 4
    //   101: astore_2
    //   102: aload 4
    //   104: astore_3
    //   105: aload 5
    //   107: aload 6
    //   109: invokeinterface 93 1 0
    //   114: checkcast 95	com/google/android/gms/location/places/PlaceLikelihood
    //   117: invokeinterface 99 1 0
    //   122: invokestatic 105	me/lyft/android/infrastructure/googleplaces/GooglePlaceMapper:fromGooglePlayPlace	(Lcom/google/android/gms/location/places/Place;)Lme/lyft/android/domain/googleplaces/GooglePlace;
    //   125: invokeinterface 111 2 0
    //   130: pop
    //   131: goto -48 -> 83
    //   134: astore 4
    //   136: aload_2
    //   137: astore_3
    //   138: aload_1
    //   139: aload 4
    //   141: invokevirtual 115	rx/Subscriber:onError	(Ljava/lang/Throwable;)V
    //   144: aload_2
    //   145: ifnull +7 -> 152
    //   148: aload_2
    //   149: invokevirtual 118	com/google/android/gms/location/places/PlaceLikelihoodBuffer:release	()V
    //   152: return
    //   153: aload 4
    //   155: astore_2
    //   156: aload 4
    //   158: astore_3
    //   159: aload_1
    //   160: aload 5
    //   162: invokevirtual 121	rx/Subscriber:onNext	(Ljava/lang/Object;)V
    //   165: aload 4
    //   167: astore_2
    //   168: aload 4
    //   170: astore_3
    //   171: aload_1
    //   172: invokevirtual 124	rx/Subscriber:onCompleted	()V
    //   175: aload 4
    //   177: ifnull -25 -> 152
    //   180: aload 4
    //   182: invokevirtual 118	com/google/android/gms/location/places/PlaceLikelihoodBuffer:release	()V
    //   185: return
    //   186: aload 4
    //   188: astore_2
    //   189: aload 4
    //   191: astore_3
    //   192: new 126	me/lyft/android/infrastructure/googleplaces/GooglePlaceException
    //   195: dup
    //   196: new 128	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   203: ldc -125
    //   205: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload 4
    //   210: invokevirtual 65	com/google/android/gms/location/places/PlaceLikelihoodBuffer:getStatus	()Lcom/google/android/gms/common/api/Status;
    //   213: invokevirtual 139	com/google/android/gms/common/api/Status:getStatusMessage	()Ljava/lang/String;
    //   216: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokespecial 145	me/lyft/android/infrastructure/googleplaces/GooglePlaceException:<init>	(Ljava/lang/String;)V
    //   225: athrow
    //   226: astore_1
    //   227: aload_3
    //   228: ifnull +7 -> 235
    //   231: aload_3
    //   232: invokevirtual 118	com/google/android/gms/location/places/PlaceLikelihoodBuffer:release	()V
    //   235: aload_1
    //   236: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	1
    //   0	237	1	paramSubscriber	rx.Subscriber<? super List<GooglePlace>>
    //   3	186	2	localObject1	Object
    //   1	231	3	localObject2	Object
    //   31	72	4	localPlaceLikelihoodBuffer	com.google.android.gms.location.places.PlaceLikelihoodBuffer
    //   134	75	4	localThrowable	Throwable
    //   68	93	5	localArrayList	java.util.ArrayList
    //   81	27	6	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   4	33	134	java/lang/Throwable
    //   39	50	134	java/lang/Throwable
    //   56	70	134	java/lang/Throwable
    //   76	83	134	java/lang/Throwable
    //   89	99	134	java/lang/Throwable
    //   105	131	134	java/lang/Throwable
    //   159	165	134	java/lang/Throwable
    //   171	175	134	java/lang/Throwable
    //   192	226	134	java/lang/Throwable
    //   4	33	226	finally
    //   39	50	226	finally
    //   56	70	226	finally
    //   76	83	226	finally
    //   89	99	226	finally
    //   105	131	226	finally
    //   138	144	226	finally
    //   159	165	226	finally
    //   171	175	226	finally
    //   192	226	226	finally
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.googleplaces.GooglePlaceService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */