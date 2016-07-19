package me.lyft.android.infrastructure.googleplaces;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.AutocompleteFilter.Builder;
import com.google.android.gms.location.places.GeoDataApi;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.PlaceDetectionApi;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.googleplaces.GooglePlace;
import me.lyft.android.domain.location.Location;
import me.lyft.android.infrastructure.googleplay.IGoogleApiProvider;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class GooglePlaceService
  implements IGooglePlaceService
{
  private final IGoogleApiProvider googleApiProvider;
  
  public GooglePlaceService(IGoogleApiProvider paramIGoogleApiProvider)
  {
    googleApiProvider = paramIGoogleApiProvider;
  }
  
  private Observable<List<GooglePlace>> createCurrentPlacesRequest()
  {
    Observable.create(new Observable.OnSubscribe()
    {
      /* Error */
      public void call(Subscriber<? super List<GooglePlace>> paramAnonymousSubscriber)
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
        //   0	237	1	paramAnonymousSubscriber	Subscriber<? super List<GooglePlace>>
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
    }).subscribeOn(Schedulers.io());
  }
  
  private Observable<GooglePlace> createPlaceDetailsRequest(final String paramString)
  {
    Observable.create(new Observable.OnSubscribe()
    {
      public void call(Subscriber<? super GooglePlace> paramAnonymousSubscriber)
      {
        localObject2 = null;
        localObject1 = null;
        try
        {
          localPlaceBuffer = (PlaceBuffer)Places.GeoDataApi.getPlaceById(googleApiProvider.getApi(), new String[] { paramString }).await();
          localObject1 = localPlaceBuffer;
          localObject2 = localPlaceBuffer;
          if (!localPlaceBuffer.getStatus().isSuccess()) {
            break label174;
          }
          localObject1 = localPlaceBuffer;
          localObject2 = localPlaceBuffer;
          if (localPlaceBuffer.getCount() > 0)
          {
            localObject1 = localPlaceBuffer;
            localObject2 = localPlaceBuffer;
            paramAnonymousSubscriber.onNext(GooglePlaceMapper.fromGooglePlayPlace(localPlaceBuffer.get(0)));
            localObject1 = localPlaceBuffer;
            localObject2 = localPlaceBuffer;
            paramAnonymousSubscriber.onCompleted();
            if (localPlaceBuffer != null) {
              localPlaceBuffer.release();
            }
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          PlaceBuffer localPlaceBuffer;
          localObject2 = localObject1;
          paramAnonymousSubscriber.onError(localThrowable);
          return;
          localObject1 = localThrowable;
          localObject2 = localThrowable;
          throw new GooglePlaceException("GeoDataApi.getPlaceById failed with status: " + localThrowable.getStatus().getStatusMessage());
        }
        finally
        {
          if (localObject2 == null) {
            break label223;
          }
          ((PlaceBuffer)localObject2).release();
        }
        localObject1 = localPlaceBuffer;
        localObject2 = localPlaceBuffer;
        throw new GooglePlaceException("Place with id=\"" + paramString + "\" was not found");
      }
    }).subscribeOn(Schedulers.io());
  }
  
  private Observable<List<GooglePlacePrediction>> createQueryPlacesRequest(final String paramString, final Location paramLocation, Integer paramInteger)
  {
    paramLocation = GooglePlaceMapper.calculateBounds(paramLocation);
    AutocompleteFilter.Builder localBuilder = new AutocompleteFilter.Builder();
    if (paramInteger != null) {
      localBuilder.setTypeFilter(paramInteger.intValue());
    }
    Observable.create(new Observable.OnSubscribe()
    {
      /* Error */
      public void call(Subscriber<? super List<GooglePlacePrediction>> paramAnonymousSubscriber)
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
        //   0	243	1	paramAnonymousSubscriber	Subscriber<? super List<GooglePlacePrediction>>
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
    }).subscribeOn(Schedulers.io());
  }
  
  private Observable<Unit> createReportPlaceRequest(final String paramString1, final String paramString2)
  {
    Observable.create(new Observable.OnSubscribe()
    {
      public void call(Subscriber<? super Unit> paramAnonymousSubscriber)
      {
        try
        {
          Object localObject = PlaceReport.create(paramString1, paramString2);
          localObject = (Status)Places.PlaceDetectionApi.reportDeviceAtPlace(googleApiProvider.getApi(), (PlaceReport)localObject).await();
          if (((Status)localObject).isSuccess())
          {
            paramAnonymousSubscriber.onNext(Unit.create());
            paramAnonymousSubscriber.onCompleted();
            return;
          }
          throw new GooglePlaceException("PlaceDetectionApi.reportDeviceAtPlace failed with status: " + ((Status)localObject).getStatus().getStatusMessage());
        }
        catch (Throwable localThrowable)
        {
          paramAnonymousSubscriber.onError(localThrowable);
        }
      }
    }).subscribeOn(Schedulers.io());
  }
  
  public Observable<List<GooglePlace>> getCurrentPlaces()
  {
    return createCurrentPlacesRequest();
  }
  
  public Observable<GooglePlace> getPlaceDetails(String paramString)
  {
    return createPlaceDetailsRequest(paramString);
  }
  
  public Observable<List<GooglePlacePrediction>> queryPlaces(String paramString, Location paramLocation)
  {
    return queryPlaces(paramString, paramLocation, null);
  }
  
  public Observable<List<GooglePlacePrediction>> queryPlaces(String paramString, Location paramLocation, Integer paramInteger)
  {
    return createQueryPlacesRequest(paramString, paramLocation, paramInteger);
  }
  
  public Observable<Unit> reportPlace(String paramString1, String paramString2)
  {
    if (Strings.isNullOrEmpty(paramString1)) {
      return Observable.empty();
    }
    return createReportPlaceRequest(paramString1, paramString2);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.googleplaces.GooglePlaceService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */