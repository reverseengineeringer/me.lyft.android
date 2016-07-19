package me.lyft.android.ui.onboarding;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import java.io.File;
import javax.inject.Inject;
import me.lyft.android.analytics.definitions.Category;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.profile.IProfileService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Unit;
import me.lyft.android.infrastructure.photo.IPhotoPickerService;
import me.lyft.android.rx.AsyncCall;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.camera.CameraScreens.CaptureUserPhotoScreen;
import me.lyft.android.ui.gallery.GalleryScreens.CropScreen;
import me.lyft.android.ui.photo.PhotoPickerDialog;
import me.lyft.android.utils.FileUtils;
import rx.functions.Action1;

public class AddProfilePhotoView
  extends LinearLayout
{
  Button addProfilePhotoButton;
  TextView addProfilePhotoMessage;
  TextView addProfilePhotoTitle;
  @Inject
  AppFlow appFlow;
  private Binder binder;
  @Inject
  IConstantsProvider constantsProvider;
  @Inject
  DialogFlow dialogFlow;
  private final Action1<Unit> onPhotoSelected = new AddProfilePhotoView.2(this);
  private final AsyncCall<Unit> onSaveProfile = new AddProfilePhotoView.3(this);
  @Inject
  IPhotoPickerService photoPickerService;
  @Inject
  IProfileService profileService;
  @Inject
  IProgressController progressController;
  @Inject
  IViewErrorHandler viewErrorHandler;
  
  public AddProfilePhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private File getTemporaryUserPhotoFile()
  {
    return FileUtils.getTemporaryFile(getContext(), "profile_photo.jpg");
  }
  
  private void goToNextScreen()
  {
    appFlow.goTo(new OnboardingScreens.EnableLocation());
  }
  
  private void showPhotoPickerDialog()
  {
    dialogFlow.show(new PhotoPickerDialog(getResources().getString(2131166191), new CameraScreens.CaptureUserPhotoScreen(), Screen.fromView(this), new GalleryScreens.CropScreen(), getTemporaryUserPhotoFile(), Category.EDIT_PROFILE));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    binder = Binder.attach(this);
    binder.bind(photoPickerService.observePhotoPickerResult(), onPhotoSelected);
    String str1 = getResources().getString(2131165400);
    String str2 = getResources().getString(2131165399);
    addProfilePhotoTitle.setText((CharSequence)constantsProvider.get(Constants.CARPOOL_DRIVER_ONBOARDING_PROFILE_PHOTO_TITLE, str1));
    addProfilePhotoMessage.setText((CharSequence)constantsProvider.get(Constants.CARPOOL_DRIVER_ONBOARDING_PROFILE_PHOTO_BODY, str2));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
    addProfilePhotoButton.setOnClickListener(new AddProfilePhotoView.1(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.onboarding.AddProfilePhotoView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */