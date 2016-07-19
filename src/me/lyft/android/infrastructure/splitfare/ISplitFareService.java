package me.lyft.android.infrastructure.splitfare;

import java.util.List;
import me.lyft.android.common.Unit;
import me.lyft.android.providers.UserContact;
import rx.Observable;

public abstract interface ISplitFareService
{
  public abstract Observable<Unit> acceptDeclineRequest(String paramString, boolean paramBoolean);
  
  public abstract void addUnknownPhoneNumber(String paramString);
  
  public abstract Observable<List<UserContact>> observeSplitFareContacts();
  
  public abstract Observable<Unit> sendInvites(List<UserContact> paramList);
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.splitfare.ISplitFareService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */