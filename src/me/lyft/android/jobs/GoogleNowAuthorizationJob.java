package me.lyft.android.jobs;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.GoogleNowAuthState;
import com.google.android.gms.search.SearchAuth;
import com.google.android.gms.search.SearchAuthApi;
import com.google.android.gms.search.SearchAuthApi.GoogleNowAuthResult;
import com.lyft.android.api.dto.UserDTO;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.LyftApplication;
import me.lyft.android.application.jobs.IGoogleNowService;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.job.GoogleNowAuthCode;
import me.lyft.android.logging.L;
import me.lyft.android.rx.AsyncCall;
import rx.Observable;

public class GoogleNowAuthorizationJob
  implements Job
{
  private static final long AUTH_CODE_EXPIRATION_ERROR_THRESHOLD = TimeUnit.HOURS.toMillis(24L);
  private static final long AUTH_CODE_EXPIRATION_THRESHOLD = TimeUnit.MINUTES.toMillis(5L);
  @Inject
  LyftApplication application;
  @Inject
  IGoogleNowService jobService;
  @Inject
  ILyftPreferences preferences;
  private UserDTO user;
  
  public GoogleNowAuthorizationJob(UserDTO paramUserDTO)
  {
    user = paramUserDTO;
  }
  
  private GoogleNowAuthCode getGoogleNowAuthCode(long paramLong)
  {
    return (GoogleNowAuthCode)Objects.firstNonNull(preferences.getGoogleNowAuthCode(), new GoogleNowAuthCode(null, Long.valueOf(paramLong)));
  }
  
  private SearchAuthApi.GoogleNowAuthResult getGoogleNowAuthResult(SearchAuthApi paramSearchAuthApi, GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.connect();
    try
    {
      paramSearchAuthApi = (SearchAuthApi.GoogleNowAuthResult)paramSearchAuthApi.getGoogleNowAuth(paramGoogleApiClient, application.getString(2131165745)).await();
      return paramSearchAuthApi;
    }
    finally
    {
      paramGoogleApiClient.disconnect();
    }
  }
  
  private void getNewAuthToken(SearchAuthApi paramSearchAuthApi, GoogleApiClient paramGoogleApiClient)
  {
    Object localObject = getGoogleNowAuthCode(System.currentTimeMillis() + AUTH_CODE_EXPIRATION_THRESHOLD);
    SearchAuthApi.GoogleNowAuthResult localGoogleNowAuthResult = getGoogleNowAuthResult(paramSearchAuthApi, paramGoogleApiClient);
    if (localGoogleNowAuthResult.getStatus().isSuccess())
    {
      localObject = localGoogleNowAuthResult.getGoogleNowAuthState();
      if (((GoogleNowAuthState)localObject).getAuthCode() != null) {
        updateGoogleAuthCode(new GoogleNowAuthCode(((GoogleNowAuthState)localObject).getAuthCode(), Long.valueOf(System.currentTimeMillis() + AUTH_CODE_EXPIRATION_THRESHOLD)));
      }
      while (((GoogleNowAuthState)localObject).getAccessToken() == null) {
        return;
      }
      revokeToken(paramSearchAuthApi, paramGoogleApiClient);
      return;
    }
    revokeToken(paramSearchAuthApi, paramGoogleApiClient);
    updateGoogleAuthCodeError((GoogleNowAuthCode)localObject);
  }
  
  private void revokeToken(SearchAuthApi paramSearchAuthApi, GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.connect();
    try
    {
      paramSearchAuthApi.clearToken(paramGoogleApiClient, application.getString(2131165745)).await();
      paramGoogleApiClient.disconnect();
      preferences.setGoogleNowAuthCode(null);
      return;
    }
    finally
    {
      paramGoogleApiClient.disconnect();
    }
  }
  
  private boolean shouldGetNewAuthCode(GoogleNowAuthCode paramGoogleNowAuthCode)
  {
    boolean bool2 = false;
    if (System.currentTimeMillis() - ((Long)Objects.firstNonNull(paramGoogleNowAuthCode.getExpirationTimestamp(), Long.valueOf(0L))).longValue() > 0L) {}
    for (int i = 1;; i = 0)
    {
      boolean bool1;
      if (!Strings.isNullOrEmpty(paramGoogleNowAuthCode.getAuthCode()))
      {
        bool1 = bool2;
        if (!Strings.isNullOrEmpty(user.googleNowRefreshToken)) {}
      }
      else
      {
        bool1 = bool2;
        if (i != 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
  }
  
  private void updateGoogleAuthCode(GoogleNowAuthCode paramGoogleNowAuthCode)
  {
    preferences.setGoogleNowAuthCode(paramGoogleNowAuthCode);
    if (!Strings.isNullOrEmpty(paramGoogleNowAuthCode.getAuthCode())) {
      jobService.updateGoogleAuthToken(user.id, paramGoogleNowAuthCode).subscribe(new AsyncCall()
      {
        public void onFail(Throwable paramAnonymousThrowable)
        {
          super.onFail(paramAnonymousThrowable);
          L.w(paramAnonymousThrowable, paramAnonymousThrowable.getMessage(), new Object[0]);
        }
      });
    }
  }
  
  private void updateGoogleAuthCodeError(GoogleNowAuthCode paramGoogleNowAuthCode)
  {
    updateGoogleAuthCode(updateTtlForError(paramGoogleNowAuthCode));
  }
  
  private GoogleNowAuthCode updateTtlForError(GoogleNowAuthCode paramGoogleNowAuthCode)
  {
    return new GoogleNowAuthCode(paramGoogleNowAuthCode.getAuthCode(), Long.valueOf(System.currentTimeMillis() + AUTH_CODE_EXPIRATION_ERROR_THRESHOLD));
  }
  
  public void execute()
    throws Throwable
  {
    GoogleNowAuthCode localGoogleNowAuthCode = getGoogleNowAuthCode(System.currentTimeMillis());
    GoogleApiClient localGoogleApiClient;
    if (shouldGetNewAuthCode(localGoogleNowAuthCode)) {
      localGoogleApiClient = new GoogleApiClient.Builder(application.getApplicationContext()).addApi(SearchAuth.API).build();
    }
    try
    {
      getNewAuthToken(SearchAuth.SearchAuthApi, localGoogleApiClient);
      return;
    }
    catch (Exception localException)
    {
      L.w(localException, localException.getMessage(), new Object[0]);
      updateGoogleAuthCodeError(localGoogleNowAuthCode);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.GoogleNowAuthorizationJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */