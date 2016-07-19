package me.lyft.android.ui.splitfare;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.rx.MessageBus;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.adapters.ContactsAdapter;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.requestridetypes.IRideTypeMetaService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Strings;
import me.lyft.android.controls.SearchToolbarView;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.domain.ride.RideType;
import me.lyft.android.providers.ContactPhone;
import me.lyft.android.providers.UserContact;
import me.lyft.android.rx.Binder;
import rx.Observable;
import rx.functions.Action1;

public class ContactsSearchDialogView
  extends LinearLayout
{
  final ContactsAdapter adapter;
  @Inject
  AppFlow appFlow;
  Binder binder;
  @Inject
  MessageBus bus;
  final List<UserContact> contacts;
  final Action1<ContactsSearchDialogView.SearchResult> contactsFilteredAction = new ContactsSearchDialogView.6(this);
  @Inject
  DialogFlow dialogFlow;
  TextView emptyView;
  ListView listView;
  final int maximumContributors;
  @Inject
  IPassengerRideProvider passengerRideProvider;
  @Inject
  IRideTypeMetaService rideTypeMetaService;
  SearchToolbarView searchToolbarView;
  
  public ContactsSearchDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    maximumContributors = rideTypeMetaService.getMaximumContributorsForRideType(passengerRideProvider.getPassengerRide().getRideType().getType());
    paramAttributeSet = (SplitFareDialogs.ContactsSearchDialog)Screen.fromView(this);
    contacts = paramAttributeSet.getContacts();
    adapter = new ContactsAdapter(Scoop.fromContext(paramContext).inflater(paramContext)).disableCategories();
    adapter.swapData(contacts);
    paramContext = paramAttributeSet.getCheckedContacts();
    paramAttributeSet = paramAttributeSet.getDisabledContacts();
    if (paramContext.size() >= maximumContributors) {}
    for (boolean bool = true;; bool = false)
    {
      int i = 0;
      while (i < contacts.size())
      {
        UserContact localUserContact = (UserContact)contacts.get(i);
        if (paramContext.contains(localUserContact)) {
          adapter.toggleChecked(i);
        }
        if (paramAttributeSet.contains(localUserContact)) {
          adapter.setItemDisabled(i);
        }
        i += 1;
      }
    }
    adapter.setHasMaxInvitesBeenHit(bool);
  }
  
  private List<UserContact> getAddableContacts(ContactsSearchDialogView.SearchResult paramSearchResult)
  {
    if (contactList.isEmpty())
    {
      String str = matchAsPhone(query);
      if (!Strings.isNullOrEmpty(str))
      {
        paramSearchResult = new ArrayList(1);
        paramSearchResult.add(new UserContact("").setContactPhone(new ContactPhone(str)).setCategory("#"));
        return paramSearchResult;
      }
      listView.setVisibility(8);
      setEmptyViewText(query);
      return null;
    }
    paramSearchResult = contactList;
    listView.setVisibility(0);
    emptyView.setVisibility(8);
    return paramSearchResult;
  }
  
  private boolean isPossibleMatch(UserContact paramUserContact, String paramString1, String paramString2)
  {
    String str1;
    String str2;
    if (paramUserContact.getPhoneNumber() != null)
    {
      str1 = paramUserContact.getPhoneNumber().getPhoneNumber();
      str2 = paramUserContact.getName().toLowerCase();
      paramUserContact = paramUserContact.getEmail();
      if (!Strings.isNullOrEmpty(paramString1)) {
        break label45;
      }
    }
    label45:
    do
    {
      return false;
      str1 = null;
      break;
      if (str2.contains(paramString1)) {
        return true;
      }
      if ((paramUserContact != null) && (paramUserContact.toLowerCase().contains(paramString1))) {
        return true;
      }
    } while ((paramString2 == null) || (str1 == null) || (!SearchHelper.isPhoneNumber(str1)) || (!SearchHelper.normalizeNumber(str1).contains(paramString2)));
    return true;
  }
  
  private String matchAsPhone(String paramString)
  {
    if (SearchHelper.isPhoneNumber(paramString)) {
      return SearchHelper.normalizeNumber(paramString);
    }
    return null;
  }
  
  private void setEmptyViewText(String paramString)
  {
    if (!Strings.isNullOrEmpty(paramString))
    {
      emptyView.setText(getResources().getString(2131165474, new Object[] { paramString }));
      emptyView.setVisibility(0);
      return;
    }
    emptyView.setVisibility(8);
  }
  
  void dismiss()
  {
    searchToolbarView.hideKeyboard();
    dialogFlow.dismiss();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    searchToolbarView.focusFieldAndShowKeyboard();
    binder = Binder.attach(this);
    binder.bind(searchToolbarView.observeTextChange(), new ContactsSearchDialogView.1(this));
    binder.bind(searchToolbarView.observeHomeClicked(), new ContactsSearchDialogView.2(this));
    binder.bind(appFlow.observeRouteChange().skip(1), new ContactsSearchDialogView.3(this));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
    listView.setDivider(getResources().getDrawable(2130838418));
    listView.setAdapter(adapter);
  }
  
  void onItemClicked(int paramInt)
  {
    if ((adapter.isItemDisabled(paramInt)) || ((adapter.getCheckedItemCount() >= maximumContributors) && (!adapter.isItemChecked(paramInt)))) {
      return;
    }
    adapter.toggleChecked(paramInt);
    bus.post(ContactsSearchDialogView.ContactSelectedEvent.class, adapter.getItem(paramInt));
    dismiss();
  }
  
  void search(CharSequence paramCharSequence)
  {
    paramCharSequence = paramCharSequence.toString().toLowerCase();
    String str = matchAsPhone(paramCharSequence);
    binder.bind(Observable.from(contacts).filter(new ContactsSearchDialogView.5(this, paramCharSequence, str)).toList().map(new ContactsSearchDialogView.4(this, paramCharSequence)), contactsFilteredAction);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.splitfare.ContactsSearchDialogView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */