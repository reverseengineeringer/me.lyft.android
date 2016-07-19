package me.lyft.android.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.rx.ReactiveUI;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import com.squareup.picasso.RequestCreator;
import java.io.File;
import javax.inject.Inject;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.profile.IProfileService;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.domain.passenger.ride.PassengerRidePassenger;
import me.lyft.android.flows.ProfileFlow;
import me.lyft.android.infrastructure.photo.IPhotoPickerService;
import me.lyft.android.infrastructure.profile.IProfilePhotoLoader;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.camera.CameraScreens.CaptureUserPhotoScreen;
import me.lyft.android.ui.gallery.GalleryScreens.CropScreen;
import me.lyft.android.ui.photo.PhotoPickerDialog;
import me.lyft.android.utils.FileUtils;
import rx.Observable;
import rx.functions.Action1;

public class PassengerMyPhotoView
  extends PassengerPhotoView
{
  TextView addPhotoText;
  Binder binder;
  @Inject
  DialogFlow dialogFlow;
  private final View.OnClickListener onClickListener = new PassengerMyPhotoView.4(this);
  private final Action1<Unit> onImageCaptured = new PassengerMyPhotoView.1(this);
  private final Action1<Unit> onNoImageSelected = new PassengerMyPhotoView.2(this);
  @Inject
  IPassengerRideProvider passengerRideProvider;
  @Inject
  IPhotoPickerService photoPickerService;
  @Inject
  ProfileFlow profileFlow;
  @Inject
  IProfilePhotoLoader profilePhotoLoader;
  @Inject
  IProfileService profileService;
  ProgressBar progress;
  ImageView userImageView;
  View userNeedsPhotoContainer;
  
  public PassengerMyPhotoView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public PassengerMyPhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public PassengerMyPhotoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  @TargetApi(21)
  public PassengerMyPhotoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    init();
  }
  
  private File getTemporaryUserPhotoFile()
  {
    return FileUtils.getTemporaryFile(getContext(), "profile_photo.jpg");
  }
  
  private boolean hasProfileImage()
  {
    return (!Strings.isNullOrEmpty(passengerRideProvider.getPassengerRide().getSelf().getPhotoUrl())) || (profilePhotoLoader.hasCacheFile());
  }
  
  private void init()
  {
    setOnClickListener(onClickListener);
    setPassengerName(getResources().getString(2131166281));
    DaggerInjector.fromView(this).inject(this);
    addView(Scoop.fromView(this).inflater(getContext()).inflate(2130903492, this, false), 0);
    ButterKnife.bind(this);
  }
  
  private void setLoading(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      progress.setVisibility(0);
      addPhotoText.setVisibility(4);
      return;
    }
    progress.setVisibility(4);
    addPhotoText.setVisibility(0);
  }
  
  private void setPhotoNeeded(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      userNeedsPhotoContainer.setVisibility(0);
      passengerPhotoImageView.setVisibility(8);
      return;
    }
    if (userNeedsPhotoContainer != null) {
      userNeedsPhotoContainer.setVisibility(8);
    }
    passengerPhotoImageView.setVisibility(0);
  }
  
  private void showPhotoPickerDialog()
  {
    PhotoPickerDialog localPhotoPickerDialog = new PhotoPickerDialog(getResources().getString(2131166249), new CameraScreens.CaptureUserPhotoScreen(), Screen.fromView(this), new GalleryScreens.CropScreen(), getTemporaryUserPhotoFile());
    dialogFlow.show(localPhotoPickerDialog);
  }
  
  private void updatePreview(File paramFile)
  {
    profilePhotoLoader.usePhotoFilePreview(paramFile);
    updateProfileImage();
  }
  
  private void updateProfileImage()
  {
    profilePhotoLoader.load().fit().centerInside().into(userImageView);
    if (!hasProfileImage()) {}
    for (boolean bool = true;; bool = false)
    {
      setPhotoNeeded(bool);
      return;
    }
  }
  
  private void uploadProfilePicture(File paramFile)
  {
    setLoading(true);
    binder.bind(profileService.uploadProfilePicture(paramFile), new PassengerMyPhotoView.3(this));
  }
  
  protected void loadPhoto(String paramString)
  {
    updatePreview(null);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    setPartySize(Integer.valueOf(passengerRideProvider.getPassengerRide().getSelf().getPartySize()));
    binder = Binder.attach(this);
    Observable localObservable = photoPickerService.observePhotoPickerResult();
    binder.bind(localObservable, onImageCaptured);
    binder.bind(ReactiveUI.isTrue(localObservable.isEmpty()), onNoImageSelected);
  }
  
  protected void setPassengerName(String paramString)
  {
    super.setPassengerName(getResources().getString(2131166281));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.PassengerMyPhotoView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */