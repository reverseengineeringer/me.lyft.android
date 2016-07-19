package me.lyft.android.application.profile;

import com.lyft.android.api.dto.PresignedPhotoUrlDTO;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;
import me.lyft.android.common.Unit;
import me.lyft.android.infrastructure.environment.IS3Api;
import rx.Observable;
import rx.functions.Func1;

class ProfileService$4
  implements Func1<PresignedPhotoUrlDTO, Observable<? extends Unit>>
{
  ProfileService$4(ProfileService paramProfileService, AtomicReference paramAtomicReference, File paramFile) {}
  
  public Observable<? extends Unit> call(PresignedPhotoUrlDTO paramPresignedPhotoUrlDTO)
  {
    val$image.set(paramPresignedPhotoUrlDTO);
    return this$0.IS3Api.uploadFile(uploadUrl, val$file);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.profile.ProfileService.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */