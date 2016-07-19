package me.lyft.android.ui.driver;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import com.lyft.scoop.Screen;
import javax.inject.Inject;
import me.lyft.android.analytics.studies.DriverConsoleAnalytics;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.domain.ats.DriverApplication;
import me.lyft.android.ui.dialogs.StandardDialogController;
import me.lyft.android.ui.driver.achievements.dials.DriverApplicationDialView;
import me.lyft.android.utils.DrawableUtils;

public class DriverApplicationDialogController
  extends StandardDialogController
{
  private static final String BUTTON_COLOR = "#FFFFFF";
  private static final String BUTTON_COLOR_PRESSED = "#F3F3F5";
  private final AppFlow appFlow;
  private final DriverConsoleAnalytics driverConsoleAnalytics;
  
  @Inject
  public DriverApplicationDialogController(DialogFlow paramDialogFlow, AppFlow paramAppFlow, DriverConsoleAnalytics paramDriverConsoleAnalytics)
  {
    super(paramDialogFlow);
    appFlow = paramAppFlow;
    driverConsoleAnalytics = paramDriverConsoleAnalytics;
  }
  
  private void initButtons()
  {
    Button localButton = addPositiveButton(2130903157, getResources().getString(2131165327), new DriverApplicationDialogController.1(this));
    localButton.setTextColor(getResources().getColor(2131493043));
    localButton.setTypeface(Typeface.DEFAULT_BOLD);
    localButton.setBackgroundDrawable(DrawableUtils.getButtonDrawableForHexColors(getView().getContext(), "#FFFFFF", "#F3F3F5", 0.0F));
    showCloseButton();
  }
  
  private void initText(DriverApplication paramDriverApplication)
  {
    int i = paramDriverApplication.getWebOnboardingCompleteness().intValue();
    String str = getResources().getString(2131165316, new Object[] { Integer.valueOf(i) });
    ((DriverApplicationDialView)addHeaderLayout(2130903163)).setProgress(paramDriverApplication.getWebOnboardingCompleteness());
    setContentTitle(str);
    setContentMessage(getResources().getString(2131165317));
  }
  
  public void onAttach()
  {
    super.onAttach();
    initText(((DriverDialogs.DriverApplicationDialog)Screen.fromController(this)).getDriverApplication());
    initButtons();
  }
  
  public int viewId()
  {
    return 2131558420;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.DriverApplicationDialogController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */