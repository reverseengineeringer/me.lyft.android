package me.lyft.android.application.profile;

import java.io.File;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.profile.Profile;
import rx.Observable;

public abstract interface IProfileService
{
  public abstract Profile getMyProfile();
  
  public abstract Observable<Unit> refreshFacebookToken(String paramString);
  
  public abstract boolean shouldRequestProfileV1FacebookPermissions();
  
  public abstract void updateMyProfile(Profile paramProfile);
  
  public abstract Observable<Unit> uploadProfileData(Profile paramProfile);
  
  public abstract Observable<Unit> uploadProfilePicture(File paramFile);
  
  public abstract Observable<Unit> uploadProfilePictureAndData(File paramFile, Profile paramProfile);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.profile.IProfileService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */