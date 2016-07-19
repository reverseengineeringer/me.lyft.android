package me.lyft.android.application.profile;

import com.lyft.android.api.dto.PresignedPhotoUrlDTO;
import com.lyft.android.api.dto.UniversalDTO;
import java.util.concurrent.atomic.AtomicReference;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.User;
import me.lyft.android.domain.profile.Profile;
import me.lyft.android.domain.profile.RideProfileMapper;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Func1;

class ProfileService$7
  implements Func1<Unit, Observable<? extends UniversalDTO>>
{
  ProfileService$7(ProfileService paramProfileService, Profile paramProfile, AtomicReference paramAtomicReference) {}
  
  public Observable<? extends UniversalDTO> call(Unit paramUnit)
  {
    paramUnit = RideProfileMapper.asUserDTOForUpdateProfile(val$profile, (PresignedPhotoUrlDTO)val$image.get());
    return this$0.api.updateUser(this$0.userProvider.getUser().getId(), paramUnit);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.profile.ProfileService.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */