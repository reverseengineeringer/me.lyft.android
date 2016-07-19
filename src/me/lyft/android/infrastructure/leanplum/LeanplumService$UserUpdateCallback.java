package me.lyft.android.infrastructure.leanplum;

import com.leanplum.Leanplum;
import java.util.Map;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.constants.ILeanplumOverrideService;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.User;
import rx.functions.Action1;

final class LeanplumService$UserUpdateCallback
  implements Action1<User>
{
  private final IConstantsProvider constantsProvider;
  private String currentUserId;
  private final ILeanplumOverrideService leanplumOverrideService;
  
  private LeanplumService$UserUpdateCallback(String paramString, ILeanplumOverrideService paramILeanplumOverrideService, IConstantsProvider paramIConstantsProvider)
  {
    currentUserId = paramString;
    leanplumOverrideService = paramILeanplumOverrideService;
    constantsProvider = paramIConstantsProvider;
  }
  
  public void call(User paramUser)
  {
    Object localObject = paramUser.getLyftId();
    int j = 0;
    int i = j;
    if (!Strings.isNullOrEmpty((String)localObject))
    {
      i = j;
      if (!((String)localObject).equals(currentUserId))
      {
        currentUserId = ((String)localObject);
        Leanplum.setUserId((String)localObject);
        i = 1;
      }
    }
    localObject = Boolean.valueOf(paramUser.isApprovedDriver());
    j = i;
    if (localObject != null)
    {
      j = i;
      if (!((Boolean)localObject).equals(LeanplumService.access$1000().get("approvedDriver")))
      {
        LeanplumService.access$1000().put("approvedDriver", localObject);
        Leanplum.setUserAttributes(LeanplumService.access$1000());
        j = 1;
      }
    }
    paramUser = paramUser.getRegion();
    i = j;
    if (!Strings.isNullOrEmpty(paramUser))
    {
      i = j;
      if (!paramUser.equals(LeanplumService.access$1000().get("region")))
      {
        LeanplumService.access$1000().put("region", paramUser);
        Leanplum.setUserAttributes(LeanplumService.access$1000());
        i = 1;
      }
    }
    if (i != 0) {
      LeanplumService.access$800(true, leanplumOverrideService, constantsProvider);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.leanplum.LeanplumService.UserUpdateCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */