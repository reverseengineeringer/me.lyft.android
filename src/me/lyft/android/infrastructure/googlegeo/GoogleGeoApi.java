package me.lyft.android.infrastructure.googlegeo;

import com.squareup.okhttp.Request.Builder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import me.lyft.android.common.Strings;
import me.lyft.android.infrastructure.api.IHttpExecutor;
import me.lyft.android.infrastructure.api.UrlBuilder;
import me.lyft.android.infrastructure.googlegeo.model.DistanceMatrixElementDTO;
import me.lyft.android.infrastructure.googlegeo.model.DistanceMatrixResponseDTO;
import me.lyft.android.infrastructure.googlegeo.model.DistanceMatrixRowDTO;
import me.lyft.android.infrastructure.googlegeo.model.GoogleDirectionsResponseDTO;
import me.lyft.android.infrastructure.googlegeo.model.GoogleDurationDTO;
import me.lyft.android.infrastructure.googlegeo.model.GoogleGeoResponseDTO;
import me.lyft.android.infrastructure.googlegeo.model.GoogleGeocodeResponseDTO;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.functions.Func1;

public class GoogleGeoApi
  implements IGoogleGeoApi
{
  private static final String ROOT = "https://maps.googleapis.com/maps/api/";
  private IHttpExecutor httpExecutor;
  
  public GoogleGeoApi(IHttpExecutor paramIHttpExecutor)
  {
    httpExecutor = paramIHttpExecutor;
  }
  
  private Observable<DistanceMatrixResponseDTO> distancematrix(String paramString1, String paramString2)
  {
    paramString1 = new UrlBuilder("https://maps.googleapis.com/maps/api/distancematrix/json").addQueryParam("sensor", Boolean.TRUE.toString()).addQueryParam("mode", "driving").addQueryParam("origins", paramString1).addQueryParam("destinations", paramString2).build();
    return executeGoogleRequest(createRequest().url(paramString1).get(), DistanceMatrixResponseDTO.class);
  }
  
  private <T extends GoogleGeoResponseDTO> Observable<T> executeGoogleRequest(Request.Builder paramBuilder, Class<T> paramClass)
  {
    httpExecutor.executeAsync(paramBuilder, paramClass).flatMap(new Func1()
    {
      public Observable<T> call(T paramAnonymousT)
      {
        if (paramAnonymousT.isOK()) {
          return Observable.just(paramAnonymousT);
        }
        return Observable.error(new GoogleGeoApiException(paramAnonymousT.getStatus()));
      }
    });
  }
  
  private static Observable<Long> getTotalETA(DistanceMatrixResponseDTO paramDistanceMatrixResponseDTO)
  {
    Observable.create(new Observable.OnSubscribe()
    {
      public void call(Subscriber<? super Long> paramAnonymousSubscriber)
      {
        try
        {
          paramAnonymousSubscriber.onNext(GoogleGeoApi.getTotalEtaSync(val$response));
          paramAnonymousSubscriber.onCompleted();
          return;
        }
        catch (Throwable localThrowable)
        {
          paramAnonymousSubscriber.onError(localThrowable);
        }
      }
    });
  }
  
  private static Long getTotalEtaSync(DistanceMatrixResponseDTO paramDistanceMatrixResponseDTO)
    throws GoogleGeoApiException
  {
    long l2 = Long.MAX_VALUE;
    Object localObject = "NONE";
    Iterator localIterator1 = rows.iterator();
    for (paramDistanceMatrixResponseDTO = (DistanceMatrixResponseDTO)localObject; localIterator1.hasNext(); paramDistanceMatrixResponseDTO = (DistanceMatrixResponseDTO)localObject)
    {
      localObject = (DistanceMatrixRowDTO)localIterator1.next();
      long l1 = 0L;
      Iterator localIterator2 = elements.iterator();
      for (;;)
      {
        localObject = paramDistanceMatrixResponseDTO;
        l3 = l1;
        if (!localIterator2.hasNext()) {
          break label119;
        }
        localObject = (DistanceMatrixElementDTO)localIterator2.next();
        if (!((DistanceMatrixElementDTO)localObject).isOk()) {
          break;
        }
        l1 += duration.value.longValue();
      }
      localObject = status;
      long l3 = Long.MAX_VALUE;
      label119:
      l2 = Math.min(l3, l2);
    }
    if (l2 != Long.MAX_VALUE) {
      return Long.valueOf(l2);
    }
    throw new GoogleGeoApiException(paramDistanceMatrixResponseDTO);
  }
  
  public Observable<GoogleGeocodeResponseDTO> addressLookupFromZip(String paramString1, String paramString2)
  {
    paramString1 = new UrlBuilder("https://maps.googleapis.com/maps/api/geocode/json").addQueryParam("sensor", "true").addQueryParam("address", paramString1).addQueryParam("components", "country:" + paramString2).build();
    return executeGoogleRequest(createRequest().url(paramString1).get(), GoogleGeocodeResponseDTO.class);
  }
  
  protected Request.Builder createRequest()
  {
    return new Request.Builder();
  }
  
  public Observable<GoogleDirectionsResponseDTO> directions(String paramString1, String paramString2, List<String> paramList)
  {
    paramList = Strings.joinWithDelimiter("|", (String[])paramList.toArray(new String[paramList.size()]));
    paramString1 = new UrlBuilder("https://maps.googleapis.com/maps/api/directions/json").addQueryParam("sensor", Boolean.TRUE.toString()).addQueryParam("language", Locale.getDefault().toString()).addQueryParam("mode", "driving").addQueryParam("origin", paramString1).addQueryParam("destination", paramString2).addQueryParam("waypoints", paramList).build();
    executeGoogleRequest(createRequest().url(paramString1).get(), GoogleDirectionsResponseDTO.class).flatMap(new Func1()
    {
      public Observable<GoogleDirectionsResponseDTO> call(GoogleDirectionsResponseDTO paramAnonymousGoogleDirectionsResponseDTO)
      {
        if (paramAnonymousGoogleDirectionsResponseDTO.getRoutes().size() > 0) {
          return Observable.just(paramAnonymousGoogleDirectionsResponseDTO);
        }
        return Observable.error(new GoogleGeoApiException(paramAnonymousGoogleDirectionsResponseDTO.getStatus()));
      }
    });
  }
  
  public DistanceMatrixResponseDTO distancematrixSync(String paramString1, String paramString2)
    throws IOException
  {
    paramString1 = new UrlBuilder("https://maps.googleapis.com/maps/api/distancematrix/json").addQueryParam("sensor", Boolean.TRUE.toString()).addQueryParam("mode", "driving").addQueryParam("origins", paramString1).addQueryParam("destinations", paramString2).build();
    paramString1 = createRequest().url(paramString1).get();
    return (DistanceMatrixResponseDTO)httpExecutor.execute(paramString1, DistanceMatrixResponseDTO.class);
  }
  
  public Observable<Long> getTotalEta(String paramString, List<String> paramList)
  {
    distancematrix(paramString, Strings.joinWithDelimiter("|", paramList)).flatMap(new Func1()
    {
      public Observable<Long> call(DistanceMatrixResponseDTO paramAnonymousDistanceMatrixResponseDTO)
      {
        return GoogleGeoApi.getTotalETA(paramAnonymousDistanceMatrixResponseDTO);
      }
    });
  }
  
  public Observable<GoogleGeocodeResponseDTO> reverseGeocode(String paramString)
  {
    paramString = new UrlBuilder("https://maps.googleapis.com/maps/api/geocode/json").addQueryParam("sensor", Boolean.TRUE.toString()).addQueryParam("language", Locale.US.toString()).addQueryParam("latlng", paramString).build();
    return executeGoogleRequest(createRequest().url(paramString).get(), GoogleGeocodeResponseDTO.class);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.googlegeo.GoogleGeoApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */