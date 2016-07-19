package me.lyft.android.application.profile;

import com.lyft.android.api.dto.UniversalDTO;
import java.io.File;
import rx.functions.Action1;

class ProfileService$5
  implements Action1<UniversalDTO>
{
  ProfileService$5(ProfileService paramProfileService, File paramFile) {}
  
  public void call(UniversalDTO paramUniversalDTO)
  {
    this$0.profilePhotoFileRecipient.usePhotoFile(val$file);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.profile.ProfileService.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */