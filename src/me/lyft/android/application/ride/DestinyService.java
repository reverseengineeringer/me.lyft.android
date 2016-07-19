package me.lyft.android.application.ride;

import com.lyft.android.api.dto.DriverDestinationRequestDTO;
import com.lyft.android.api.dto.UpdateUserRequestBuilder;
import com.lyft.android.api.dto.UpdateUserRequestDTO;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.User;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.LocationMapper;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;

public class DestinyService
  implements IDestinyService
{
  private final ILyftApi lyftApi;
  private final IUserProvider userProvider;
  
  public DestinyService(IUserProvider paramIUserProvider, ILyftApi paramILyftApi)
  {
    userProvider = paramIUserProvider;
    lyftApi = paramILyftApi;
  }
  
  public Observable<Unit> exitDestiny()
  {
    return lyftApi.deleteDestinyLocation(userProvider.getUser().getId()).map(Unit.func1());
  }
  
  public Observable<Unit> exitSetDestiny()
  {
    UpdateUserRequestDTO localUpdateUserRequestDTO = new UpdateUserRequestBuilder().withMode("driver").build();
    return lyftApi.updateUser(userProvider.getUser().getId(), localUpdateUserRequestDTO).map(Unit.func1());
  }
  
  public Observable<Unit> setDestiny(Location paramLocation)
  {
    paramLocation = new DriverDestinationRequestDTO(LocationMapper.toDeprecatedPlaceDTO(paramLocation), null);
    return lyftApi.updateDestinyLocation(userProvider.getUser().getId(), paramLocation).map(Unit.func1());
  }
  
  public Observable<Unit> switchToDestiny()
  {
    UpdateUserRequestDTO localUpdateUserRequestDTO = new UpdateUserRequestBuilder().withMode("passenger").build();
    return lyftApi.updateUser(userProvider.getUser().getId(), localUpdateUserRequestDTO).map(Unit.func1());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.DestinyService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */