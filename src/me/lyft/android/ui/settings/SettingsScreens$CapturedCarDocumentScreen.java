package me.lyft.android.ui.settings;

import com.lyft.scoop.Controller;
import me.lyft.android.common.SingleInstance;
import me.lyft.android.domain.driver.Vehicle;

@Controller(CapturedCarDocumentPreviewController.class)
@SingleInstance
public class SettingsScreens$CapturedCarDocumentScreen
  extends SettingsScreens.CarScreen
{
  private SettingsScreens.CapturedCarDocumentScreen.DocumentType documentType;
  
  public SettingsScreens$CapturedCarDocumentScreen(Vehicle paramVehicle, SettingsScreens.CapturedCarDocumentScreen.DocumentType paramDocumentType)
  {
    super(paramVehicle);
    documentType = paramDocumentType;
  }
  
  public SettingsScreens.CapturedCarDocumentScreen.DocumentType getDocumentType()
  {
    return documentType;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.settings.SettingsScreens.CapturedCarDocumentScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */