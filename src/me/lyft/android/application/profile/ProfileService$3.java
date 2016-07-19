package me.lyft.android.application.profile;

import com.lyft.android.api.dto.PresignedPhotoUrlDTO;
import com.lyft.android.api.dto.UniversalDTO;
import com.lyft.android.api.dto.UpdateUserRequestBuilder;
import java.util.concurrent.atomic.AtomicReference;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.User;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Func1;

class ProfileService$3
  implements Func1<Unit, Observable<? extends UniversalDTO>>
{
  ProfileService$3(ProfileService paramProfileService, AtomicReference paramAtomicReference) {}
  
  public Observable<? extends UniversalDTO> call(Unit paramUnit)
  {
    paramUnit = new UpdateUserRequestBuilder().withImage((PresignedPhotoUrlDTO)val$image.get()).build();
    return this$0.api.updateUser(this$0.userProvider.getUser().getId(), paramUnit);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.profile.ProfileService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */