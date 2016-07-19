package me.lyft.android.ui;

import com.lyft.scoop.Layout;
import com.lyft.scoop.Screen;
import java.util.ArrayList;
import java.util.List;
import me.lyft.android.common.IHasName;
import me.lyft.android.common.Objects;
import me.lyft.android.common.SingleInstance;
import me.lyft.android.domain.driver.Vehicle;
import me.lyft.android.events.DialogResultEvent;

public class Dialogs
  extends Screen
{
  @Layout(2130903045)
  public static class AlertDialog
    extends Dialogs
    implements IHasName
  {
    private String analyticsName;
    private ArrayList<Dialogs.AlertDialog.DialogButtonMeta> buttons = new ArrayList();
    private int buttonsOrientation;
    private String className;
    private Integer icon;
    private List<String> items;
    private String message;
    private Float messageFontSize;
    private Integer sound;
    private String title;
    private Integer titleColorResource;
    
    public AlertDialog(String paramString)
    {
      analyticsName = paramString;
    }
    
    public AlertDialog addButton(int paramInt1, String paramString, int paramInt2)
    {
      paramString = new Dialogs.AlertDialog.DialogButtonMeta(paramInt1, paramString, paramInt2);
      getButtons().add(paramString);
      return this;
    }
    
    public AlertDialog addNegativeButton(String paramString)
    {
      return addNegativeButton(paramString, 2130903152);
    }
    
    public AlertDialog addNegativeButton(String paramString, int paramInt)
    {
      return addButton(2131558424, paramString, paramInt);
    }
    
    public AlertDialog addNeutralButton(String paramString)
    {
      return addNeutralButton(paramString, 2130903152);
    }
    
    public AlertDialog addNeutralButton(String paramString, int paramInt)
    {
      return addButton(2131558425, paramString, paramInt);
    }
    
    public AlertDialog addPositiveButton(String paramString)
    {
      return addPositiveButton(paramString, 2130903152);
    }
    
    public AlertDialog addPositiveButton(String paramString, int paramInt)
    {
      return addButton(2131558427, paramString, paramInt);
    }
    
    public ArrayList<Dialogs.AlertDialog.DialogButtonMeta> getButtons()
    {
      return buttons;
    }
    
    public int getButtonsOrientation()
    {
      return buttonsOrientation;
    }
    
    public Class<? extends DialogResultEvent> getDialogEventClass()
    {
      try
      {
        Class localClass = Class.forName(className);
        return localClass;
      }
      catch (Exception localException) {}
      return null;
    }
    
    public Integer getIcon()
    {
      return icon;
    }
    
    public List<String> getItems()
    {
      return items;
    }
    
    public String getMessage()
    {
      return message;
    }
    
    public Float getMessageFontSize()
    {
      return messageFontSize;
    }
    
    public String getName()
    {
      return analyticsName;
    }
    
    public Integer getSound()
    {
      return sound;
    }
    
    public String getTitle()
    {
      return title;
    }
    
    public Integer getTitleColorResource()
    {
      return titleColorResource;
    }
    
    public AlertDialog setButtonsOrientation(Integer paramInteger)
    {
      buttonsOrientation = paramInteger.intValue();
      return this;
    }
    
    public AlertDialog setDialogEventClass(Class<? extends DialogResultEvent> paramClass)
    {
      className = paramClass.getName();
      return this;
    }
    
    public AlertDialog setIcon(Integer paramInteger)
    {
      icon = paramInteger;
      return this;
    }
    
    public AlertDialog setItems(List<String> paramList)
    {
      items = paramList;
      return this;
    }
    
    public AlertDialog setMessage(String paramString)
    {
      message = paramString;
      return this;
    }
    
    public AlertDialog setMessageFontSize(float paramFloat)
    {
      messageFontSize = Float.valueOf(paramFloat);
      return this;
    }
    
    public AlertDialog setSound(int paramInt)
    {
      sound = Integer.valueOf(paramInt);
      return this;
    }
    
    public AlertDialog setTitle(String paramString)
    {
      title = paramString;
      return this;
    }
    
    public AlertDialog setTitleColorResource(int paramInt)
    {
      titleColorResource = Integer.valueOf(paramInt);
      return this;
    }
  }
  
  @Layout(2130903143)
  public static class DatePickerDialog
    extends Dialogs
  {
    public int day;
    public boolean disablePastDate;
    public int month;
    public int year;
    
    public DatePickerDialog(int paramInt1, int paramInt2, int paramInt3)
    {
      year = paramInt1;
      month = paramInt2;
      day = paramInt3;
    }
    
    public void setDisablePastDate(boolean paramBoolean)
    {
      disablePastDate = paramBoolean;
    }
  }
  
  @Layout(2130903209)
  public static class EditPickupOnboardingDialog
    extends Dialogs
  {}
  
  @Layout(2130903045)
  public static class ErrorDialog
    extends Dialogs.AlertDialog
  {
    public ErrorDialog(String paramString1, String paramString2, String paramString3)
    {
      super();
      setMessage(paramString1);
      addPositiveButton(paramString2);
    }
    
    public ErrorDialog(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      this(paramString2, paramString3, paramString4);
      setTitle(paramString1);
      setTitleColorResource(2131493111);
    }
  }
  
  @Layout(2130903307)
  public static class InAppNotificationDialog
    extends Dialogs
  {
    String targetUrl;
    
    public InAppNotificationDialog(String paramString)
    {
      targetUrl = paramString;
    }
    
    public String getTargetUrl()
    {
      return targetUrl;
    }
  }
  
  @Layout(2130903252)
  public static class InsuranceExpiringDialog
    extends Dialogs
  {
    private boolean attemptEnterDriverMode;
    private Vehicle vehicle;
    
    public InsuranceExpiringDialog(Vehicle paramVehicle)
    {
      vehicle = paramVehicle;
    }
    
    public boolean getAttemptEnterDriverMode()
    {
      return attemptEnterDriverMode;
    }
    
    public Vehicle getVehicle()
    {
      return (Vehicle)Objects.firstNonNull(vehicle, Vehicle.empty());
    }
    
    public InsuranceExpiringDialog setAttemptEnterDriverMode(boolean paramBoolean)
    {
      attemptEnterDriverMode = paramBoolean;
      return this;
    }
  }
  
  @Layout(2130903292)
  public static class MockLocationsWarningDialog
    extends Dialogs
  {}
  
  @Layout(2130903491)
  @SingleInstance
  public static class UpdateAppDialog
    extends Dialogs
  {
    String message;
    
    public UpdateAppDialog(String paramString)
    {
      message = paramString;
    }
    
    public String getMessage()
    {
      return message;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.Dialogs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */