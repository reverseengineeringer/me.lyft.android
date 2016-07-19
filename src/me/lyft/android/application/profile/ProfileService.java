package me.lyft.android.application.profile;

import com.lyft.android.api.dto.PresignedPhotoUrlDTO;
import com.lyft.android.api.dto.PresignedPhotoUrlRequestDTO;
import com.lyft.android.api.dto.UniversalDTO;
import com.lyft.android.api.dto.UpdateUserRequestBuilder;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.User;
import me.lyft.android.domain.profile.Profile;
import me.lyft.android.domain.profile.RideProfileMapper;
import me.lyft.android.infrastructure.environment.IS3Api;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class ProfileService
  implements IProfileService
{
  public static final String PURPOSE_PROFILE_PICTURE = "profilePicture";
  final IS3Api IS3Api;
  final ILyftApi api;
  private Profile myProfile = Profile.empty();
  final IProfilePhotoFileRecipient profilePhotoFileRecipient;
  final IUserProvider userProvider;
  
  public ProfileService(IUserProvider paramIUserProvider, IS3Api paramIS3Api, ILyftApi paramILyftApi, IProfilePhotoFileRecipient paramIProfilePhotoFileRecipient)
  {
    userProvider = paramIUserProvider;
    IS3Api = paramIS3Api;
    api = paramILyftApi;
    profilePhotoFileRecipient = paramIProfilePhotoFileRecipient;
  }
  
  public Profile getMyProfile()
  {
    return myProfile;
  }
  
  public Observable<Unit> refreshFacebookToken(String paramString)
  {
    if (userProvider.getUser().isNull()) {
      return Unit.just();
    }
    if (Strings.isNullOrEmpty(paramString)) {
      return Unit.just();
    }
    return api.refreshFacebookAuthToken(userProvider.getUser().getId(), paramString).map(Unit.func1());
  }
  
  public boolean shouldRequestProfileV1FacebookPermissions()
  {
    return userProvider.getUser().isRequestProfileV1FacebookPermissions();
  }
  
  public void updateMyProfile(Profile paramProfile)
  {
    myProfile = paramProfile;
  }
  
  public Observable<Unit> uploadProfileData(Profile paramProfile)
  {
    paramProfile = RideProfileMapper.asUserDTOForUpdateProfile(paramProfile, null);
    api.updateUser(userProvider.getUser().getId(), paramProfile).onErrorResumeNext(new Func1()
    {
      public Observable<UniversalDTO> call(Throwable paramAnonymousThrowable)
      {
        return Observable.empty();
      }
    }).map(Unit.func1());
  }
  
  public Observable<Unit> uploadProfilePicture(final File paramFile)
  {
    final AtomicReference localAtomicReference = new AtomicReference();
    PresignedPhotoUrlRequestDTO localPresignedPhotoUrlRequestDTO = new PresignedPhotoUrlRequestDTO("profilePicture");
    api.getImageUploadUrl(localPresignedPhotoUrlRequestDTO).flatMap(new Func1()
    {
      public Observable<? extends Unit> call(PresignedPhotoUrlDTO paramAnonymousPresignedPhotoUrlDTO)
      {
        localAtomicReference.set(paramAnonymousPresignedPhotoUrlDTO);
        return IS3Api.uploadFile(uploadUrl, paramFile);
      }
    }).flatMap(new Func1()
    {
      public Observable<? extends UniversalDTO> call(Unit paramAnonymousUnit)
      {
        paramAnonymousUnit = new UpdateUserRequestBuilder().withImage((PresignedPhotoUrlDTO)localAtomicReference.get()).build();
        return api.updateUser(userProvider.getUser().getId(), paramAnonymousUnit);
      }
    }).onErrorResumeNext(new Func1()
    {
      public Observable<UniversalDTO> call(Throwable paramAnonymousThrowable)
      {
        return Observable.empty();
      }
    }).doOnNext(new Action1()
    {
      public void call(UniversalDTO paramAnonymousUniversalDTO)
      {
        profilePhotoFileRecipient.usePhotoFile(paramFile);
      }
    }).map(Unit.func1());
  }
  
  public Observable<Unit> uploadProfilePictureAndData(final File paramFile, final Profile paramProfile)
  {
    final AtomicReference localAtomicReference = new AtomicReference();
    PresignedPhotoUrlRequestDTO localPresignedPhotoUrlRequestDTO = new PresignedPhotoUrlRequestDTO("profilePicture");
    api.getImageUploadUrl(localPresignedPhotoUrlRequestDTO).flatMap(new Func1()
    {
      public Observable<? extends Unit> call(PresignedPhotoUrlDTO paramAnonymousPresignedPhotoUrlDTO)
      {
        localAtomicReference.set(paramAnonymousPresignedPhotoUrlDTO);
        return IS3Api.uploadFile(uploadUrl, paramFile);
      }
    }).flatMap(new Func1()
    {
      public Observable<? extends UniversalDTO> call(Unit paramAnonymousUnit)
      {
        paramAnonymousUnit = RideProfileMapper.asUserDTOForUpdateProfile(paramProfile, (PresignedPhotoUrlDTO)localAtomicReference.get());
        return api.updateUser(userProvider.getUser().getId(), paramAnonymousUnit);
      }
    }).onErrorResumeNext(new Func1()
    {
      public Observable<UniversalDTO> call(Throwable paramAnonymousThrowable)
      {
        return Observable.empty();
      }
    }).doOnNext(new Action1()
    {
      public void call(UniversalDTO paramAnonymousUniversalDTO)
      {
        profilePhotoFileRecipient.usePhotoFile(paramFile);
      }
    }).map(Unit.func1());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.profile.ProfileService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */