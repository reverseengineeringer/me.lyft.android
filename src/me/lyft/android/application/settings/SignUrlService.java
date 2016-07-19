package me.lyft.android.application.settings;

import com.lyft.android.api.dto.SignedUrlDTO;
import com.lyft.android.api.dto.SignedUrlRequestDTO;
import me.lyft.android.analytics.core.CallAnalytics;
import me.lyft.android.analytics.core.SpanningAnalytics;
import me.lyft.android.analytics.core.events.CallEvent.Call;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class SignUrlService
  implements ISignUrlService
{
  private ILyftApi lyftApi;
  
  public SignUrlService(ILyftApi paramILyftApi)
  {
    lyftApi = paramILyftApi;
  }
  
  public Observable<String> getSignedUrl(String paramString)
  {
    final CallAnalytics localCallAnalytics = (CallAnalytics)new CallAnalytics(CallEvent.Call.GENERATE_SIGNED_URL).setParameter(paramString).trackInitiation();
    lyftApi.generateSignedUrl(new SignedUrlRequestDTO(paramString, Integer.valueOf(3600))).flatMap(new Func1()
    {
      public Observable<String> call(SignedUrlDTO paramAnonymousSignedUrlDTO)
      {
        return Observable.just(signedUrl);
      }
    }).doOnNext(new Action1()
    {
      public void call(String paramAnonymousString)
      {
        localCallAnalytics.trackSuccess();
      }
    }).doOnError(new Action1()
    {
      public void call(Throwable paramAnonymousThrowable)
      {
        localCallAnalytics.trackFailure(paramAnonymousThrowable);
      }
    });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.settings.SignUrlService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */