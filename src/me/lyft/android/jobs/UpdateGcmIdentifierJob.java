package me.lyft.android.jobs;

import com.lyft.android.api.dto.UpdateUserRequestBuilder;
import com.lyft.android.api.dto.UpdateUserRequestDTO;
import javax.inject.Inject;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.User;
import me.lyft.android.infrastructure.gcm.IGcmIdService;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.rx.SimpleSubscriber;
import rx.Observable;

public class UpdateGcmIdentifierJob
  implements Job
{
  @Inject
  IGcmIdService gcmIdService;
  @Inject
  ILyftApi lyftApi;
  @Inject
  IUserProvider userProvider;
  
  public void execute()
    throws Throwable
  {
    Object localObject1 = userProvider.getUser();
    if (((User)localObject1).isNull()) {}
    label124:
    label127:
    for (;;)
    {
      return;
      Object localObject2 = gcmIdService.getToken();
      String str = ((User)localObject1).getPushToken();
      int i;
      if (!Strings.isNullOrEmpty((String)localObject2))
      {
        i = 1;
        if ((!Strings.isNullOrEmpty(str)) && (Strings.equalsIgnoreCase(str, (String)localObject2))) {
          break label124;
        }
      }
      for (int j = 1;; j = 0)
      {
        if ((i == 0) || (j == 0)) {
          break label127;
        }
        localObject2 = new UpdateUserRequestBuilder().withGooglePushToken((String)localObject2).build();
        localObject1 = ((User)localObject1).getId();
        lyftApi.updateUser((String)localObject1, (UpdateUserRequestDTO)localObject2).subscribe(new SimpleSubscriber());
        return;
        i = 0;
        break;
      }
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.UpdateGcmIdentifierJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */