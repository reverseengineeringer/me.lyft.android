package me.lyft.android.ui.enterprise;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.android.api.dto.InviteDTO;
import com.lyft.android.api.dto.InviteRequestDTO;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.inject.Inject;
import me.lyft.android.adapters.SeparatedListAdapter;
import me.lyft.android.application.enterprise.IEnterpriseService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.enterprise.Organization;
import me.lyft.android.domain.enterprise.UserOrganization;
import me.lyft.android.domain.invite.InviteText;
import me.lyft.android.infrastructure.share.IShareService;
import me.lyft.android.providers.ContactPhone;
import me.lyft.android.providers.ContactsProvider;
import me.lyft.android.providers.ContactsProvider.Builder;
import me.lyft.android.providers.UserContact;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import rx.functions.Action1;

public class EnterpriseInviteCoworkersViaContactsView
  extends LinearLayout
{
  private static final String CONTACTS_SECTION_HEADER = "Contacts";
  private static final String COWORKERS_SECTION_HEADER = "Coworkers";
  private static final String ENTERPRISE = "enterprise";
  private static final String SKIP_TOOLBAR_ITEM = "SKIP";
  private final int SMS_BODY_LENGTH_LIMIT = 160;
  @Inject
  AppFlow appFlow;
  Binder binder;
  SparseBooleanArray checked;
  Map<String, String> companyContacts = new HashMap();
  Map<String, UserContact> companyEmailContacts = new HashMap();
  @Inject
  ContactsProvider contactsProvider;
  Integer coworkerContactSize;
  List<UserContact> coworkerContacts;
  EnterpriseContactsAdapter coworkerContactsAdapter;
  int datasetPosition;
  @Inject
  IEnterpriseService enterpriseService;
  TextView inviteCoworkersHeaderTextView;
  LinearLayout inviteCoworkersView;
  InviteText inviteText;
  List<InviteDTO> invitesToSend;
  ListView listView;
  int listviewPosition;
  Map<String, UserContact> mobilePhoneContacts = new HashMap();
  Map<String, UserContact> noneCompanyEmailContacts = new HashMap();
  Map<String, UserContact> noneMobilePhoneContacts = new HashMap();
  private Integer numberOfSections = Integer.valueOf(2);
  private Action1<Integer> onToolbarItemClicked = new EnterpriseInviteCoworkersViaContactsView.6(this);
  List<UserContact> otherContacts;
  EnterpriseContactsAdapter otherContactsAdapter;
  private final EnterpriseScreens.EnterpriseInviteCoworkersViaContactsScreen params;
  @Inject
  IProgressController progressController;
  TextView sendInvitesButton;
  @Inject
  IShareService sendSmsService;
  private String senderCompany;
  private String senderEmail;
  SeparatedListAdapter separatedListAdapter;
  Map<String, String> smsToSend = new HashMap();
  Toolbar toolbar;
  Map<String, UserContact> uniqueCoworkerContacts = new TreeMap();
  Map<String, UserContact> uniqueOtherContacts = new TreeMap();
  List<UserContact> userContacts;
  UserOrganization userOrganization;
  @Inject
  IViewErrorHandler viewErrorHandler;
  
  public EnterpriseInviteCoworkersViaContactsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    params = ((EnterpriseScreens.EnterpriseInviteCoworkersViaContactsScreen)Screen.fromView(this));
  }
  
  private void addPhoneNumbersToCoworkersSection()
  {
    Iterator localIterator = noneCompanyEmailContacts.values().iterator();
    UserContact localUserContact;
    String str2;
    String str1;
    while (localIterator.hasNext())
    {
      localUserContact = (UserContact)localIterator.next();
      str2 = localUserContact.getName();
      if (Strings.isNullOrEmpty(str2)) {}
      for (str1 = localUserContact.getEmail().toLowerCase();; str1 = str2.toLowerCase())
      {
        if ((companyEmailContacts.containsKey(str2 + localUserContact.getEmail())) || (uniqueCoworkerContacts.containsKey(str1 + "email")) || (!companyContacts.containsKey(str2)) || (!((String)companyContacts.get(str2)).equalsIgnoreCase(senderCompany))) {
          break label201;
        }
        uniqueCoworkerContacts.put(str1 + "email", localUserContact);
        break;
      }
      label201:
      uniqueOtherContacts.put(str2 + localUserContact.getEmail(), localUserContact);
    }
    localIterator = mobilePhoneContacts.values().iterator();
    while (localIterator.hasNext())
    {
      localUserContact = (UserContact)localIterator.next();
      str2 = localUserContact.getName();
      if (Strings.isNullOrEmpty(str2)) {}
      for (str1 = localUserContact.getEmail().toLowerCase();; str1 = str2.toLowerCase())
      {
        if ((companyEmailContacts.containsKey(str2 + localUserContact.getEmail())) || (!companyContacts.containsKey(str2)) || (!((String)companyContacts.get(str2)).equalsIgnoreCase(senderCompany))) {
          break label407;
        }
        uniqueCoworkerContacts.put(str1 + "phone", localUserContact);
        break;
      }
      label407:
      uniqueOtherContacts.put(str2 + localUserContact.getPhoneNumber(), localUserContact);
    }
    localIterator = noneMobilePhoneContacts.values().iterator();
    while (localIterator.hasNext())
    {
      localUserContact = (UserContact)localIterator.next();
      str2 = localUserContact.getName();
      if (Strings.isNullOrEmpty(str2)) {}
      for (str1 = localUserContact.getEmail().toLowerCase();; str1 = str2.toLowerCase())
      {
        if ((companyEmailContacts.containsKey(str2 + localUserContact.getEmail())) || (!companyContacts.containsKey(str2)) || (!((String)companyContacts.get(str2)).equalsIgnoreCase(senderCompany)) || (mobilePhoneContacts.containsKey(str2))) {
          break label609;
        }
        uniqueCoworkerContacts.put(str1, localUserContact);
        break;
      }
      label609:
      uniqueOtherContacts.put(str2 + localUserContact.getPhoneNumber(), localUserContact);
    }
  }
  
  private void filterContacts()
  {
    if (userContacts.size() > 0)
    {
      Iterator localIterator = userContacts.iterator();
      while (localIterator.hasNext())
      {
        UserContact localUserContact = (UserContact)localIterator.next();
        boolean bool = Strings.isNullOrEmpty(localUserContact.getEmail());
        int i;
        label65:
        label83:
        int j;
        if (localUserContact.getPhoneNumber() != null)
        {
          i = 1;
          if ((i == 0) || (localUserContact.getPhoneNumber().getPhoneType() != 2)) {
            break label193;
          }
          i = 1;
          if ((bool) || (!senderEmail.equalsIgnoreCase(localUserContact.getEmail()))) {
            break label198;
          }
          j = 1;
          label105:
          if ((bool) || (!senderCompany.equalsIgnoreCase(getCompanyFromEmail(localUserContact.getEmail())))) {
            break label203;
          }
        }
        String str;
        label193:
        label198:
        label203:
        for (int k = 1;; k = 0)
        {
          str = localUserContact.getName();
          if (!bool) {
            break label266;
          }
          if (!Strings.isNullOrEmpty(localUserContact.getCompany())) {
            break label246;
          }
          if ((i == 0) || (mobilePhoneContacts.containsKey(str))) {
            break label208;
          }
          mobilePhoneContacts.put(str, localUserContact);
          break;
          i = 0;
          break label65;
          i = 0;
          break label83;
          j = 0;
          break label105;
        }
        label208:
        noneMobilePhoneContacts.put(str + localUserContact.getPhoneNumber(), localUserContact);
        continue;
        label246:
        companyContacts.put(str, localUserContact.getCompany());
        continue;
        label266:
        if (j == 0) {
          if (k != 0) {
            companyEmailContacts.put(str + localUserContact.getEmail(), localUserContact);
          } else {
            noneCompanyEmailContacts.put(str + localUserContact.getEmail(), localUserContact);
          }
        }
      }
    }
  }
  
  private static String getCompanyFromEmail(String paramString)
  {
    paramString = paramString.split("@");
    if (paramString.length > 1)
    {
      paramString = paramString[1].split("\\.");
      if (paramString.length > 1) {
        return paramString[0].toString();
      }
    }
    return "";
  }
  
  private void getInvitesToSend(ListView paramListView)
  {
    checked = paramListView.getCheckedItemPositions();
    coworkerContactSize = Integer.valueOf(coworkerContacts.size());
    int i = 0;
    if (i < checked.size())
    {
      listviewPosition = checked.keyAt(i);
      if (checked.get(listviewPosition))
      {
        if (listviewPosition > coworkerContactSize.intValue()) {
          break label173;
        }
        datasetPosition = (listviewPosition - 1);
        paramListView = (UserContact)coworkerContacts.get(datasetPosition);
        label104:
        if (!Strings.isNullOrEmpty(paramListView.getEmail()))
        {
          InviteDTO localInviteDTO = paramListView.createEmailInvite();
          invitesToSend.add(localInviteDTO);
        }
        if (paramListView.getPhoneNumber() != null) {
          break label217;
        }
      }
      label173:
      label217:
      for (int j = 1;; j = 0)
      {
        if (j == 0) {
          smsToSend.put(paramListView.getName(), paramListView.getPhoneNumber().getPhoneNumber());
        }
        i += 1;
        break;
        datasetPosition = (listviewPosition - numberOfSections.intValue() - coworkerContactSize.intValue());
        paramListView = (UserContact)otherContacts.get(datasetPosition);
        break label104;
      }
    }
  }
  
  private void initData()
  {
    userOrganization = params.getUserOrganization();
    inviteText = userOrganization.getInviteText();
    senderEmail = params.getEmail();
    senderCompany = getCompanyFromEmail(senderEmail);
  }
  
  private void onSendInvitesButtonClicked()
  {
    sendInvitesButton.setEnabled(false);
    sendInvites();
    if (smsToSend.size() > 0) {
      sendSms();
    }
    updateListview();
    appFlow.replaceWith(new EnterpriseScreens.EnterpriseVerifyEmailScreen(senderEmail, userOrganization));
  }
  
  private void populateSeparatedSectionList()
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(getContext());
    coworkerContactsAdapter = new EnterpriseContactsAdapter(localLayoutInflater);
    otherContactsAdapter = new EnterpriseContactsAdapter(localLayoutInflater);
    separatedListAdapter = new SeparatedListAdapter(getContext());
    coworkerContacts = new ArrayList();
    otherContacts = new ArrayList();
    listView.setAdapter(separatedListAdapter);
    filterContacts();
    setUniqueContactGroups();
    coworkerContacts.addAll(uniqueCoworkerContacts.values());
    otherContacts.addAll(uniqueOtherContacts.values());
    if (coworkerContacts.size() > 0)
    {
      coworkerContactsAdapter.swapData(coworkerContacts);
      if (coworkerContactsAdapter != null) {
        separatedListAdapter.addSection("Coworkers", coworkerContactsAdapter);
      }
    }
    for (;;)
    {
      otherContactsAdapter.swapData(otherContacts);
      if (otherContactsAdapter != null) {
        separatedListAdapter.addSection("Contacts", otherContactsAdapter);
      }
      listView.setAdapter(separatedListAdapter);
      separatedListAdapter.notifyDataSetChanged();
      return;
      numberOfSections = Integer.valueOf(1);
    }
  }
  
  private void sendInvites()
  {
    invitesToSend = new ArrayList();
    getInvitesToSend(listView);
    progressController.disableUI();
    progressController.showProgress();
    binder.bind(enterpriseService.sendEnterpriseInvites(new InviteRequestDTO("enterprise", invitesToSend)), new EnterpriseInviteCoworkersViaContactsView.5(this));
  }
  
  private void sendSms()
  {
    String str1 = (String)Objects.firstNonNull(inviteText.getSmsBody(), "");
    Iterator localIterator = smsToSend.values().iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if ((str1.length() <= 160) && (!str1.isEmpty())) {
        sendSmsService.sendSms(str2, str1);
      }
    }
  }
  
  private void setInviteCoworkersHeader()
  {
    String str = Strings.nullOrEmptyToDefault(userOrganization.getOrganization().getName(), getResources().getString(2131165540));
    inviteCoworkersHeaderTextView.setText(getResources().getString(2131165806, new Object[] { str }));
  }
  
  private void setSendInvitesButtonVisibility()
  {
    if (listView.getCheckedItemCount() > 0)
    {
      sendInvitesButton.setVisibility(0);
      return;
    }
    sendInvitesButton.setVisibility(8);
  }
  
  private void setSendInvitesButtonVisibility(int paramInt)
  {
    if (listView.getCheckedItemCount() > 0)
    {
      sendInvitesButton.setVisibility(0);
      int i = listView.getLastVisiblePosition();
      if ((listView.isItemChecked(paramInt)) && (paramInt >= i - 1)) {
        listView.post(new EnterpriseInviteCoworkersViaContactsView.4(this));
      }
      return;
    }
    sendInvitesButton.setVisibility(8);
  }
  
  private void setUniqueContactGroups()
  {
    Iterator localIterator = companyEmailContacts.values().iterator();
    while (localIterator.hasNext())
    {
      UserContact localUserContact = (UserContact)localIterator.next();
      if (Strings.isNullOrEmpty(localUserContact.getName())) {}
      for (String str = localUserContact.getEmail().toLowerCase();; str = localUserContact.getName().toLowerCase())
      {
        if (uniqueCoworkerContacts.containsKey(str)) {
          break label91;
        }
        uniqueCoworkerContacts.put(str, localUserContact);
        break;
      }
      label91:
      uniqueOtherContacts.put(localUserContact.getName() + localUserContact.getEmail(), localUserContact);
    }
    addPhoneNumbersToCoworkersSection();
  }
  
  private void updateContactListVisibility()
  {
    if (userContacts.size() > 0)
    {
      inviteCoworkersView.setVisibility(0);
      return;
    }
    appFlow.replaceWith(new EnterpriseScreens.EnterpriseVerifyEmailScreen(senderEmail, userOrganization));
  }
  
  private void updateListview()
  {
    listView.clearChoices();
    smsToSend.clear();
    if (coworkerContacts.size() > 0) {
      coworkerContactsAdapter.notifyDataSetChanged();
    }
    if (otherContacts.size() > 0) {
      otherContactsAdapter.notifyDataSetChanged();
    }
    if (userContacts.size() > 0) {
      separatedListAdapter.notifyDataSetChanged();
    }
    updateContactListVisibility();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder = Binder.attach(this);
    binder.bind(toolbar.observeItemClick(), onToolbarItemClicked);
    listView.setOnItemClickListener(new EnterpriseInviteCoworkersViaContactsView.3(this));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
    toolbar.setTitle(getContext().getString(2131165805)).clearItems().addItem(2131558439, "SKIP");
    initData();
    setInviteCoworkersHeader();
    sendInvitesButton.setOnClickListener(new EnterpriseInviteCoworkersViaContactsView.1(this));
    binder.bind(contactsProvider.create().emails().phones().companies().observe(), new EnterpriseInviteCoworkersViaContactsView.2(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.enterprise.EnterpriseInviteCoworkersViaContactsView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */