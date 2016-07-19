package me.lyft.android.application.settings;

import com.lyft.android.api.dto.UniversalDTO;
import com.lyft.android.api.dto.UpdateUserRequestBuilder;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.User;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Func1;

public class NavigationSettingsService
  implements INavigationSettingsService
{
  private ILyftApi lyftApi;
  private IUserProvider userProvider;
  
  public NavigationSettingsService(ILyftApi paramILyftApi, IUserProvider paramIUserProvider)
  {
    lyftApi = paramILyftApi;
    userProvider = paramIUserProvider;
  }
  
  public Observable<Unit> setDefaultNavigation(String paramString)
  {
    paramString = new UpdateUserRequestBuilder().withDefaultNavApp(paramString).withNavAppReroutable(Boolean.valueOf(true)).build();
    String str = userProvider.getUser().getId();
    lyftApi.updateUser(str, paramString).flatMap(new Func1()
    {
      public Observable<Unit> call(UniversalDTO paramAnonymousUniversalDTO)
      {
        return Unit.just();
      }
    });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.settings.NavigationSettingsService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */