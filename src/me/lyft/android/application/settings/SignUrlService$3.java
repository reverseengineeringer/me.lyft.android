package me.lyft.android.application.settings;

import com.lyft.android.api.dto.SignedUrlDTO;
import rx.Observable;
import rx.functions.Func1;

class SignUrlService$3
  implements Func1<SignedUrlDTO, Observable<String>>
{
  SignUrlService$3(SignUrlService paramSignUrlService) {}
  
  public Observable<String> call(SignedUrlDTO paramSignedUrlDTO)
  {
    return Observable.just(signedUrl);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.settings.SignUrlService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */