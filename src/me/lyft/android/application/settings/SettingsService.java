package me.lyft.android.application.settings;

import com.lyft.android.api.dto.ClientPermissionsRequestBuilder;
import com.lyft.android.api.dto.PhoneDTO;
import com.lyft.android.api.dto.UniversalDTO;
import com.lyft.android.api.dto.UpdateUserRequestBuilder;
import com.lyft.android.api.dto.UpdateUserRequestDTO;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.common.IntegerExtensions;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.User;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Func1;

public class SettingsService
  implements ISettingsService
{
  private ILyftApi lyftApi;
  private IUserProvider userProvider;
  
  public SettingsService(ILyftApi paramILyftApi, IUserProvider paramIUserProvider)
  {
    lyftApi = paramILyftApi;
    userProvider = paramIUserProvider;
  }
  
  public Observable<Unit> agreeToCoarseLocations()
  {
    return lyftApi.updateLocationPermissions(new ClientPermissionsRequestBuilder().withAlwaysOnLocationPermission().build());
  }
  
  public Observable<Unit> enableCarpoolDriverDispatch(boolean paramBoolean)
  {
    UpdateUserRequestDTO localUpdateUserRequestDTO = new UpdateUserRequestBuilder().withCarpoolDriverDispatchEnabled(Boolean.valueOf(paramBoolean)).build();
    lyftApi.updateUser(userProvider.getUser().getId(), localUpdateUserRequestDTO).flatMap(new Func1()
    {
      public Observable<Unit> call(UniversalDTO paramAnonymousUniversalDTO)
      {
        return Unit.just();
      }
    });
  }
  
  public Observable<Unit> requestVerificationCode(String paramString)
  {
    paramString = new PhoneDTO(paramString, null, null, null);
    paramString = new UpdateUserRequestBuilder().withPhone(paramString).build();
    lyftApi.updateUser(userProvider.getUser().getId(), paramString).flatMap(new Func1()
    {
      public Observable<Unit> call(UniversalDTO paramAnonymousUniversalDTO)
      {
        return Unit.just();
      }
    });
  }
  
  public Observable<Unit> updateEmail(String paramString)
  {
    paramString = new UpdateUserRequestBuilder().withEmail(paramString).build();
    lyftApi.updateUser(userProvider.getUser().getId(), paramString).flatMap(new Func1()
    {
      public Observable<Unit> call(UniversalDTO paramAnonymousUniversalDTO)
      {
        return Unit.just();
      }
    });
  }
  
  public Observable<Unit> verifyPhone(String paramString1, String paramString2)
  {
    paramString1 = new PhoneDTO(paramString1, IntegerExtensions.tryParse(paramString2, 0), null, null);
    paramString1 = new UpdateUserRequestBuilder().withPhone(paramString1).build();
    lyftApi.updateUser(userProvider.getUser().getId(), paramString1).flatMap(new Func1()
    {
      public Observable<Unit> call(UniversalDTO paramAnonymousUniversalDTO)
      {
        return Unit.just();
      }
    });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.settings.SettingsService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */