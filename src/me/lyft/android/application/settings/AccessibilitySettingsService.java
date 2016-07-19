package me.lyft.android.application.settings;

import com.lyft.android.api.dto.UniversalDTO;
import com.lyft.android.api.dto.UpdateUserRequestBuilder;
import com.lyft.android.api.dto.UpdateUserRequestDTO;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.User;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Func1;

public class AccessibilitySettingsService
  implements IAccessibilitySettingsService
{
  private final ILyftApi lyftApi;
  private final IUserProvider userProvider;
  
  public AccessibilitySettingsService(IUserProvider paramIUserProvider, ILyftApi paramILyftApi)
  {
    userProvider = paramIUserProvider;
    lyftApi = paramILyftApi;
  }
  
  public Observable<Unit> setAccessibilityEnabled(boolean paramBoolean)
  {
    UpdateUserRequestDTO localUpdateUserRequestDTO = new UpdateUserRequestBuilder().withWheelchair(Boolean.valueOf(paramBoolean)).build();
    lyftApi.updateUser(userProvider.getUser().getId(), localUpdateUserRequestDTO).flatMap(new Func1()
    {
      public Observable<Unit> call(UniversalDTO paramAnonymousUniversalDTO)
      {
        return Unit.just();
      }
    });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.settings.AccessibilitySettingsService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */