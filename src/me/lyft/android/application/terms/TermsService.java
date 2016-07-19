package me.lyft.android.application.terms;

import com.lyft.android.api.dto.UpdateUserRequestBuilder;
import com.lyft.android.api.dto.UpdateUserRequestDTO;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.User;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;

public class TermsService
  implements ITermsService
{
  private final ILyftApi lyftApi;
  private final IUserProvider userProvider;
  
  public TermsService(ILyftApi paramILyftApi, IUserProvider paramIUserProvider)
  {
    lyftApi = paramILyftApi;
    userProvider = paramIUserProvider;
  }
  
  public Observable<Unit> acceptTermsOfService()
  {
    UpdateUserRequestDTO localUpdateUserRequestDTO = new UpdateUserRequestBuilder().withTermsUrl(userProvider.getUser().getTermsUrl()).build();
    return lyftApi.updateUser(userProvider.getUser().getId(), localUpdateUserRequestDTO).map(Unit.func1());
  }
  
  public Observable<Unit> acceptTermsOfService(String paramString)
  {
    paramString = new UpdateUserRequestBuilder().withTermsUrl(paramString).build();
    return lyftApi.updateUser(userProvider.getUser().getId(), paramString).map(Unit.func1());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.terms.TermsService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */