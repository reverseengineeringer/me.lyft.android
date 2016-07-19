package me.lyft.android.ui.settings;

import android.content.res.Resources;
import android.widget.CheckedTextView;
import javax.inject.Inject;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.settings.IAccessibilitySettingsService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.RxViewController;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.User;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;

public class AccessibilitySettingsController
  extends RxViewController
{
  public static final int SERVICE_ACCESS = 1;
  public static final int SERVICE_NONE = 0;
  @Inject
  IAccessibilitySettingsService accessibilitySettingsService;
  @Inject
  AppFlow appFlow;
  @Inject
  IProgressController progressController;
  CheckedTextView servicesOptionAccess;
  CheckedTextView servicesOptionNone;
  Toolbar toolbar;
  @Inject
  IUserProvider userProvider;
  @Inject
  IViewErrorHandler viewErrorHandler;
  
  private boolean isServiceChanged(int paramInt)
  {
    if (paramInt == 1) {}
    for (int i = 1; i != userProvider.getUser().isWheelchairNeeded(); i = 0) {
      return true;
    }
    return false;
  }
  
  private void setSelectedService(int paramInt)
  {
    boolean bool = true;
    if (!isServiceChanged(paramInt))
    {
      appFlow.goBack();
      return;
    }
    progressController.showProgress();
    RxUIBinder localRxUIBinder = binder;
    IAccessibilitySettingsService localIAccessibilitySettingsService = accessibilitySettingsService;
    if (paramInt == 1) {}
    for (;;)
    {
      localRxUIBinder.bindAsyncCall(localIAccessibilitySettingsService.setAccessibilityEnabled(bool), new AccessibilitySettingsController.3(this));
      return;
      bool = false;
    }
  }
  
  protected int layoutId()
  {
    return 2130903406;
  }
  
  public void onAttach()
  {
    super.onAttach();
    toolbar.setTitle(getResources().getString(2131166188));
    servicesOptionNone.setOnClickListener(new AccessibilitySettingsController.1(this));
    servicesOptionAccess.setOnClickListener(new AccessibilitySettingsController.2(this));
    if (userProvider.getUser().isWheelchairNeeded())
    {
      servicesOptionAccess.setChecked(true);
      return;
    }
    servicesOptionNone.setChecked(true);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.settings.AccessibilitySettingsController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */