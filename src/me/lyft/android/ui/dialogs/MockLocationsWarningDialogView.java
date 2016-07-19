package me.lyft.android.ui.dialogs;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.common.ActivityController;
import me.lyft.android.common.DialogFlow;

public class MockLocationsWarningDialogView
  extends DialogContainerView
{
  public static final String ACTION_DEVELOPMENT_SETTINGS_1 = "com.android.settings.APPLICATION_DEVELOPMENT_SETTINGS";
  public static final String ACTION_DEVELOPMENT_SETTINGS_2 = "android.settings.APPLICATION_DEVELOPMENT_SETTINGS";
  @Inject
  ActivityController activityController;
  @Inject
  DialogFlow dialogFlow;
  
  public MockLocationsWarningDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  public boolean onBack()
  {
    activityController.finish();
    return true;
  }
  
  public void onClick_goToDevelopmentSettings(View paramView)
  {
    try
    {
      getContext().startActivity(new Intent("com.android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
      dialogFlow.dismiss();
      return;
    }
    catch (ActivityNotFoundException paramView)
    {
      for (;;)
      {
        try
        {
          getContext().startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
        }
        catch (ActivityNotFoundException paramView)
        {
          activityController.finish();
        }
      }
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.dialogs.MockLocationsWarningDialogView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */