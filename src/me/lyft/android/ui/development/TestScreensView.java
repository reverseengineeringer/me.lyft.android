package me.lyft.android.ui.development;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import butterknife.ButterKnife;
import com.appboy.enums.inappmessage.ClickAction;
import com.appboy.models.IInAppMessage;
import com.appboy.models.InAppMessageFull;
import com.appboy.models.MessageButton;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import com.squareup.picasso.RequestCreator;
import java.io.File;
import java.util.ArrayList;
import javax.inject.Inject;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.enterprise.UserOrganization;
import me.lyft.android.infrastructure.camera.ICaptureImage;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.ui.AppboyScreens.AppBoyInappDialog;
import me.lyft.android.ui.camera.CameraScreens.CaptureUserPhotoScreen;
import me.lyft.android.ui.dialogs.Toast;
import me.lyft.android.ui.enterprise.EnterpriseScreens.EnterpriseInviteCoworkersViaContactsScreen;
import me.lyft.android.ui.invites.InvitesScreens.InviteScreen;
import me.lyft.android.ui.invites.InvitesScreens.InviteSource;
import me.lyft.android.ui.passenger.PassengerDialogs.PostRideSocialShareDialog;
import me.lyft.android.ui.passenger.PassengerScreens.PassengerRideExpenseNoteScreen;
import me.lyft.android.ui.payment.PaymentScreens.ConcurSendRideReceiptsScreen;
import me.lyft.android.ui.splitfare.SplitScreens.InviteToSplitScreen;
import me.lyft.android.utils.FileUtils;

public class TestScreensView
  extends LinearLayout
{
  private static final String[] CAMERA_ITEMS = { "User Profile", "Car Photo", "Driver License", "Insurance", "Mentee Photo" };
  @Inject
  AppFlow appFlow;
  Spinner cameraItemsSpinner;
  @Inject
  ICaptureImage captureImage;
  @Inject
  DialogFlow dialogFlow;
  @Inject
  ImageLoader imageLoader;
  Toolbar toolbar;
  
  public TestScreensView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private File getTemporaryFile()
  {
    return FileUtils.getTemporaryFile(getContext(), "temp_file.jpg");
  }
  
  private void initCameraSpinner()
  {
    ArrayAdapter localArrayAdapter = new ArrayAdapter(getContext(), 17367049, CAMERA_ITEMS);
    localArrayAdapter.setDropDownViewResource(17367049);
    cameraItemsSpinner.setAdapter(localArrayAdapter);
    cameraItemsSpinner.setSelection(0);
  }
  
  private void showCustomAppboyInAppNote()
  {
    Object localObject = new InAppMessageFull();
    ((InAppMessageFull)localObject).setBackgroundColor(getResources().getColor(2131492875));
    ((InAppMessageFull)localObject).setHeader("Free ice cream today!");
    ((InAppMessageFull)localObject).setHeaderTextColor(getResources().getColor(2131493083));
    ((InAppMessageFull)localObject).setMessage("For a limited time");
    ((InAppMessageFull)localObject).setMessageTextColor(getResources().getColor(2131492875));
    imageLoader.load("https://d13yacurqjgara.cloudfront.net/users/59100/screenshots/1938930/untitled-1.jpg").fetch();
    ((InAppMessageFull)localObject).setImageUrl("https://d13yacurqjgara.cloudfront.net/users/59100/screenshots/1938930/untitled-1.jpg");
    ArrayList localArrayList = new ArrayList();
    MessageButton localMessageButton = new MessageButton();
    localMessageButton.setClickAction(ClickAction.URI, Uri.parse("lyft://profile"));
    localMessageButton.setText("Open your profile");
    localMessageButton.setTextColor(getResources().getColor(2131492875));
    localMessageButton.setBackgroundColor(getResources().getColor(2131493004));
    localArrayList.add(localMessageButton);
    localMessageButton = new MessageButton();
    localMessageButton.setClickAction(ClickAction.URI, Uri.parse("http://www.lyft.com"));
    localMessageButton.setText("Open lyft.net");
    localMessageButton.setTextColor(getResources().getColor(2131492875));
    localArrayList.add(localMessageButton);
    ((InAppMessageFull)localObject).setMessageButtons(localArrayList);
    localObject = new AppboyScreens.AppBoyInappDialog((IInAppMessage)localObject);
    dialogFlow.show((Screen)localObject);
  }
  
  private void startCamera(String paramString)
  {
    Screen localScreen = Screen.fromView(this);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new IllegalArgumentException("Not a valid argument! (" + paramString + ")");
        if (paramString.equals("User Profile")) {
          i = 0;
        }
        break;
      }
    }
    paramString = new CameraScreens.CaptureUserPhotoScreen();
    captureImage.capturePhoto(paramString, localScreen, getTemporaryFile());
  }
  
  public void goToView(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131559785: 
    default: 
      return;
    case 2131559777: 
      appFlow.goTo(new InvitesScreens.InviteScreen(InvitesScreens.InviteSource.DEVELOPMENT));
      return;
    case 2131559778: 
      appFlow.goTo(new SplitScreens.InviteToSplitScreen());
      return;
    case 2131559779: 
      paramView = new UserOrganization(null, null);
      appFlow.goTo(new EnterpriseScreens.EnterpriseInviteCoworkersViaContactsScreen("fake@lyft.com", paramView));
      return;
    case 2131559784: 
      startCamera(cameraItemsSpinner.getSelectedItem().toString());
    case 2131559780: 
      appFlow.goTo(new PassengerScreens.PassengerRideExpenseNoteScreen());
      return;
    case 2131559781: 
      appFlow.goTo(new DevelopmentScreens.ButtonsScreen());
      return;
    case 2131559783: 
      appFlow.goTo(new PaymentScreens.ConcurSendRideReceiptsScreen());
      return;
    case 2131559776: 
      showCustomAppboyInAppNote();
      return;
    case 2131559786: 
      dialogFlow.show(new PassengerDialogs.PostRideSocialShareDialog(false));
      return;
    }
    dialogFlow.show(new Toast("This is a toast."));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
    toolbar.setTitle("Test Views");
    initCameraSpinner();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.development.TestScreensView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */