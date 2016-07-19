package me.lyft.android.infrastructure.googleplaces;

import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;
import rx.Observable.OnSubscribe;

class GooglePlaceService$4
  implements Observable.OnSubscribe<List<GooglePlacePrediction>>
{
  GooglePlaceService$4(GooglePlaceService paramGooglePlaceService, String paramString, LatLngBounds paramLatLngBounds, AutocompleteFilter paramAutocompleteFilter) {}
  
  /* Error */
  public void call(rx.Subscriber<? super List<GooglePlacePrediction>> paramSubscriber)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: getstatic 49	com/google/android/gms/location/places/Places:GeoDataApi	Lcom/google/android/gms/location/places/GeoDataApi;
    //   7: aload_0
    //   8: getfield 24	me/lyft/android/infrastructure/googleplaces/GooglePlaceService$4:this$0	Lme/lyft/android/infrastructure/googleplaces/GooglePlaceService;
    //   11: invokestatic 53	me/lyft/android/infrastructure/googleplaces/GooglePlaceService:access$000	(Lme/lyft/android/infrastructure/googleplaces/GooglePlaceService;)Lme/lyft/android/infrastructure/googleplay/IGoogleApiProvider;
    //   14: invokeinterface 59 1 0
    //   19: aload_0
    //   20: getfield 26	me/lyft/android/infrastructure/googleplaces/GooglePlaceService$4:val$query	Ljava/lang/String;
    //   23: aload_0
    //   24: getfield 28	me/lyft/android/infrastructure/googleplaces/GooglePlaceService$4:val$bounds	Lcom/google/android/gms/maps/model/LatLngBounds;
    //   27: aload_0
    //   28: getfield 30	me/lyft/android/infrastructure/googleplaces/GooglePlaceService$4:val$options	Lcom/google/android/gms/location/places/AutocompleteFilter;
    //   31: invokeinterface 65 5 0
    //   36: invokevirtual 71	com/google/android/gms/common/api/PendingResult:await	()Lcom/google/android/gms/common/api/Result;
    //   39: checkcast 73	com/google/android/gms/location/places/AutocompletePredictionBuffer
    //   42: astore 4
    //   44: aload 4
    //   46: astore_2
    //   47: aload 4
    //   49: astore_3
    //   50: aload 4
    //   52: invokevirtual 77	com/google/android/gms/location/places/AutocompletePredictionBuffer:getStatus	()Lcom/google/android/gms/common/api/Status;
    //   55: invokevirtual 83	com/google/android/gms/common/api/Status:isSuccess	()Z
    //   58: ifeq +134 -> 192
    //   61: aload 4
    //   63: astore_2
    //   64: aload 4
    //   66: astore_3
    //   67: new 85	java/util/ArrayList
    //   70: dup
    //   71: aload 4
    //   73: invokevirtual 89	com/google/android/gms/location/places/AutocompletePredictionBuffer:getCount	()I
    //   76: invokespecial 92	java/util/ArrayList:<init>	(I)V
    //   79: astore 5
    //   81: aload 4
    //   83: astore_2
    //   84: aload 4
    //   86: astore_3
    //   87: aload 4
    //   89: invokevirtual 96	com/google/android/gms/location/places/AutocompletePredictionBuffer:iterator	()Ljava/util/Iterator;
    //   92: astore 6
    //   94: aload 4
    //   96: astore_2
    //   97: aload 4
    //   99: astore_3
    //   100: aload 6
    //   102: invokeinterface 101 1 0
    //   107: ifeq +52 -> 159
    //   110: aload 4
    //   112: astore_2
    //   113: aload 4
    //   115: astore_3
    //   116: aload 5
    //   118: aload 6
    //   120: invokeinterface 105 1 0
    //   125: checkcast 107	com/google/android/gms/location/places/AutocompletePrediction
    //   128: invokestatic 113	me/lyft/android/infrastructure/googleplaces/GooglePlaceMapper:fromGooglePlayAutocomplete	(Lcom/google/android/gms/location/places/AutocompletePrediction;)Lme/lyft/android/infrastructure/googleplaces/GooglePlacePrediction;
    //   131: invokeinterface 119 2 0
    //   136: pop
    //   137: goto -43 -> 94
    //   140: astore 4
    //   142: aload_2
    //   143: astore_3
    //   144: aload_1
    //   145: aload 4
    //   147: invokevirtual 123	rx/Subscriber:onError	(Ljava/lang/Throwable;)V
    //   150: aload_2
    //   151: ifnull +7 -> 158
    //   154: aload_2
    //   155: invokevirtual 126	com/google/android/gms/location/places/AutocompletePredictionBuffer:release	()V
    //   158: return
    //   159: aload 4
    //   161: astore_2
    //   162: aload 4
    //   164: astore_3
    //   165: aload_1
    //   166: aload 5
    //   168: invokevirtual 129	rx/Subscriber:onNext	(Ljava/lang/Object;)V
    //   171: aload 4
    //   173: astore_2
    //   174: aload 4
    //   176: astore_3
    //   177: aload_1
    //   178: invokevirtual 132	rx/Subscriber:onCompleted	()V
    //   181: aload 4
    //   183: ifnull -25 -> 158
    //   186: aload 4
    //   188: invokevirtual 126	com/google/android/gms/location/places/AutocompletePredictionBuffer:release	()V
    //   191: return
    //   192: aload 4
    //   194: astore_2
    //   195: aload 4
    //   197: astore_3
    //   198: new 134	me/lyft/android/infrastructure/googleplaces/GooglePlaceException
    //   201: dup
    //   202: new 136	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   209: ldc -117
    //   211: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload 4
    //   216: invokevirtual 77	com/google/android/gms/location/places/AutocompletePredictionBuffer:getStatus	()Lcom/google/android/gms/common/api/Status;
    //   219: invokevirtual 147	com/google/android/gms/common/api/Status:getStatusMessage	()Ljava/lang/String;
    //   222: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokespecial 153	me/lyft/android/infrastructure/googleplaces/GooglePlaceException:<init>	(Ljava/lang/String;)V
    //   231: athrow
    //   232: astore_1
    //   233: aload_3
    //   234: ifnull +7 -> 241
    //   237: aload_3
    //   238: invokevirtual 126	com/google/android/gms/location/places/AutocompletePredictionBuffer:release	()V
    //   241: aload_1
    //   242: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	4
    //   0	243	1	paramSubscriber	rx.Subscriber<? super List<GooglePlacePrediction>>
    //   3	192	2	localObject1	Object
    //   1	237	3	localObject2	Object
    //   42	72	4	localAutocompletePredictionBuffer	com.google.android.gms.location.places.AutocompletePredictionBuffer
    //   140	75	4	localThrowable	Throwable
    //   79	88	5	localArrayList	java.util.ArrayList
    //   92	27	6	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   4	44	140	java/lang/Throwable
    //   50	61	140	java/lang/Throwable
    //   67	81	140	java/lang/Throwable
    //   87	94	140	java/lang/Throwable
    //   100	110	140	java/lang/Throwable
    //   116	137	140	java/lang/Throwable
    //   165	171	140	java/lang/Throwable
    //   177	181	140	java/lang/Throwable
    //   198	232	140	java/lang/Throwable
    //   4	44	232	finally
    //   50	61	232	finally
    //   67	81	232	finally
    //   87	94	232	finally
    //   100	110	232	finally
    //   116	137	232	finally
    //   144	150	232	finally
    //   165	171	232	finally
    //   177	181	232	finally
    //   198	232	232	finally
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.googleplaces.GooglePlaceService.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */