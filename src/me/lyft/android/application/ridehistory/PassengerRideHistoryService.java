package me.lyft.android.application.ridehistory;

import com.lyft.android.api.dto.RideHistoryDTO;
import com.lyft.android.api.dto.RideHistoryItemDetailedDTO;
import java.util.List;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.common.Iterables;
import me.lyft.android.domain.ridehistory.IPassengerRideHistoryMapper;
import me.lyft.android.domain.ridehistory.PassengerRideHistory;
import me.lyft.android.domain.ridehistory.PassengerRideHistoryDetails;
import me.lyft.android.domain.ridehistory.PassengerRideHistoryItem;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class PassengerRideHistoryService
  implements IPassengerRideHistoryService
{
  public static final int RIDE_HISTORY_ITEMS_LIMIT = 10;
  private PassengerRideHistory cachedHistory = PassengerRideHistory.createEmptyPassengerRideHistory();
  private final ILyftApi lyftApi;
  private final IPassengerRideHistoryMapper mapper;
  private final IUserProvider userProvider;
  
  public PassengerRideHistoryService(ILyftApi paramILyftApi, IUserProvider paramIUserProvider, IPassengerRideHistoryMapper paramIPassengerRideHistoryMapper)
  {
    lyftApi = paramILyftApi;
    userProvider = paramIUserProvider;
    mapper = paramIPassengerRideHistoryMapper;
  }
  
  public void clearCachedRideHistory()
  {
    cachedHistory = PassengerRideHistory.createEmptyPassengerRideHistory();
  }
  
  public PassengerRideHistory getCachedRideHistory()
  {
    return cachedHistory;
  }
  
  public Observable<PassengerRideHistory> getPassengerHistory(int paramInt)
  {
    return getPassengerHistory(paramInt, PassengerRideHistoryType.ALL);
  }
  
  public Observable<PassengerRideHistory> getPassengerHistory(int paramInt, PassengerRideHistoryType paramPassengerRideHistoryType)
  {
    if ((paramInt == 0) || (paramInt != cachedHistory.getRideHistory().size())) {
      clearCachedRideHistory();
    }
    lyftApi.getPassengerHistory(paramInt, 10, paramPassengerRideHistoryType).map(new Func1()
    {
      public PassengerRideHistory call(RideHistoryDTO paramAnonymousRideHistoryDTO)
      {
        return mapper.fromDTO(paramAnonymousRideHistoryDTO);
      }
    }).doOnNext(new Action1()
    {
      public void call(PassengerRideHistory paramAnonymousPassengerRideHistory)
      {
        cachedHistory.getRideHistory().addAll(paramAnonymousPassengerRideHistory.getRideHistory());
        cachedHistory.setHasMore(paramAnonymousPassengerRideHistory.hasMore());
        cachedHistory.setLimit(paramAnonymousPassengerRideHistory.getLimit());
        cachedHistory.setOffset(paramAnonymousPassengerRideHistory.getOffset());
      }
    });
  }
  
  public Observable<PassengerRideHistoryDetails> getPassengerHistoryDetails(String paramString)
  {
    lyftApi.getPassengerRideHistoryDetails(paramString).map(new Func1()
    {
      public PassengerRideHistoryDetails call(RideHistoryItemDetailedDTO paramAnonymousRideHistoryItemDetailedDTO)
      {
        return mapper.fromDTO(paramAnonymousRideHistoryItemDetailedDTO);
      }
    });
  }
  
  public Observable<PassengerRideHistoryItem> getRecentRideHistoryItem()
  {
    lyftApi.getPassengerHistory(0, 1, PassengerRideHistoryType.ALL).map(new Func1()
    {
      public PassengerRideHistoryItem call(RideHistoryDTO paramAnonymousRideHistoryDTO)
      {
        return (PassengerRideHistoryItem)Iterables.firstOrDefault(mapper.fromDTO(paramAnonymousRideHistoryDTO).getRideHistory(), PassengerRideHistoryItem.empty());
      }
    });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ridehistory.PassengerRideHistoryService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */