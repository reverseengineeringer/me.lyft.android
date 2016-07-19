package me.lyft.android.application.invite;

import com.lyft.android.api.dto.InviteDTO;
import com.lyft.android.api.dto.InviteRequestDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.contacts.UserContact;
import me.lyft.android.domain.contacts.UserContactMapper;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;

public class InviteService
{
  private ILyftApi lyftApi;
  
  public InviteService(ILyftApi paramILyftApi)
  {
    lyftApi = paramILyftApi;
  }
  
  public Observable<Unit> sendInvites(List<UserContact> paramList1, List<UserContact> paramList2, String paramString)
  {
    paramString = new ArrayList();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      InviteDTO localInviteDTO = UserContactMapper.emailInviteDTOfromUserContact((UserContact)paramList1.next());
      if (localInviteDTO != null) {
        paramString.add(localInviteDTO);
      }
    }
    paramList1 = paramList2.iterator();
    while (paramList1.hasNext())
    {
      paramList2 = UserContactMapper.phoneInviteDTOfromUserContact((UserContact)paramList1.next());
      if (paramList2 != null) {
        paramString.add(paramList2);
      }
    }
    return lyftApi.sendInvites(new InviteRequestDTO(null, paramString));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.invite.InviteService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */