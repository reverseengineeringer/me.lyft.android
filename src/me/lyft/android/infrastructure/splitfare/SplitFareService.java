package me.lyft.android.infrastructure.splitfare;

import android.content.res.Resources;
import com.lyft.android.api.dto.ContributorDTO;
import com.lyft.android.api.dto.ContributorUpdateRequestDTO;
import com.lyft.android.api.dto.FareSplitInviteRequestDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import me.lyft.android.analytics.studies.SplitFareAnalytics;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.infrastructure.lyft.LyftApiException;
import me.lyft.android.providers.ContactPhone;
import me.lyft.android.providers.ContactsProvider;
import me.lyft.android.providers.ContactsProvider.PhoneNumberFilter;
import me.lyft.android.providers.ISplitFareProvider;
import me.lyft.android.providers.UserContact;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class SplitFareService
  implements ISplitFareService
{
  private static final int MAX_RECENT_CONTACTS = 3;
  private final ContactsProvider contactsProvider;
  private final ILyftApi lyftApi;
  private final Resources resources;
  private final IPassengerRideProvider rideProvider;
  private final SplitFareAnalytics splitFareAnalytics;
  private final ISplitFareProvider splitFareProvider;
  private final Set<String> unknownPhoneNumbers = new HashSet();
  
  public SplitFareService(ILyftApi paramILyftApi, ISplitFareProvider paramISplitFareProvider, ContactsProvider paramContactsProvider, Resources paramResources, IPassengerRideProvider paramIPassengerRideProvider, SplitFareAnalytics paramSplitFareAnalytics)
  {
    lyftApi = paramILyftApi;
    splitFareProvider = paramISplitFareProvider;
    contactsProvider = paramContactsProvider;
    resources = paramResources;
    rideProvider = paramIPassengerRideProvider;
    splitFareAnalytics = paramSplitFareAnalytics;
  }
  
  static List<ContributorDTO> asDTO(List<UserContact> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      UserContact localUserContact = (UserContact)paramList.next();
      localArrayList.add(new ContributorDTO(localUserContact.getPhoneNumber().getPhoneNumber(), localUserContact.getName(), null));
    }
    return localArrayList;
  }
  
  private List<UserContact> getUnknownContacts()
  {
    ArrayList localArrayList = new ArrayList(unknownPhoneNumbers.size());
    Iterator localIterator = unknownPhoneNumbers.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new UserContact("").setContactPhone(new ContactPhone(str)).setCategory("#"));
    }
    return localArrayList;
  }
  
  public Observable<Unit> acceptDeclineRequest(String paramString, boolean paramBoolean)
  {
    splitFareAnalytics.trackSplitRequestResponse(paramBoolean);
    ILyftApi localILyftApi = lyftApi;
    if (paramBoolean) {}
    for (String str = "accepted";; str = "rejected") {
      localILyftApi.acceptDeclineFareSplitRequest(paramString, new ContributorUpdateRequestDTO(str)).onErrorResumeNext(new Func1()
      {
        public Observable<Unit> call(Throwable paramAnonymousThrowable)
        {
          splitFareAnalytics.trackSplitResponseFailure(paramAnonymousThrowable);
          Object localObject = paramAnonymousThrowable;
          if ((paramAnonymousThrowable instanceof LyftApiException))
          {
            localObject = paramAnonymousThrowable;
            if (((LyftApiException)paramAnonymousThrowable).getStatusCode() == 422) {
              localObject = new SplitFareServiceException("splitfare_request_lapsed");
            }
          }
          return Observable.error((Throwable)localObject);
        }
      }).doOnNext(new Action1()
      {
        public void call(Unit paramAnonymousUnit)
        {
          splitFareAnalytics.trackSplitResponseSuccess();
        }
      });
    }
  }
  
  public void addUnknownPhoneNumber(String paramString)
  {
    if (Strings.isNullOrEmpty(paramString)) {
      return;
    }
    unknownPhoneNumbers.add(paramString);
  }
  
  public Observable<List<UserContact>> observeSplitFareContacts()
  {
    final String str = resources.getString(2131166334);
    Observable.concat(splitFareProvider.observeTopSplitFareContacts().limit(3).doOnNext(new Action1()
    {
      public void call(UserContact paramAnonymousUserContact)
      {
        paramAnonymousUserContact.setCategory(str);
      }
    }), contactsProvider.getPhonesObservable().startWith(getUnknownContacts())).filter(new ContactsProvider.PhoneNumberFilter()).toList();
  }
  
  public Observable<Unit> sendInvites(final List<UserContact> paramList)
  {
    if (paramList.isEmpty()) {
      return Observable.just(Unit.create());
    }
    splitFareAnalytics.trackSendSplitRequest(paramList.size());
    FareSplitInviteRequestDTO localFareSplitInviteRequestDTO = new FareSplitInviteRequestDTO(rideProvider.getPassengerRide().getId(), asDTO(paramList));
    lyftApi.sendFareSplitInvites(localFareSplitInviteRequestDTO).onErrorResumeNext(new Func1()
    {
      public Observable<? extends Unit> call(Throwable paramAnonymousThrowable)
      {
        splitFareAnalytics.trackSendSplitRequestFailure(paramAnonymousThrowable);
        return Observable.error(paramAnonymousThrowable);
      }
    }).doOnNext(new Action1()
    {
      public void call(Unit paramAnonymousUnit)
      {
        splitFareAnalytics.trackSendSplitRequestSuccess();
        splitFareProvider.incrementSplitFareCount(paramList);
      }
    });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.splitfare.SplitFareService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */