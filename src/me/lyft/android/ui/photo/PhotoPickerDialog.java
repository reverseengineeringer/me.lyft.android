package me.lyft.android.ui.photo;

import com.lyft.scoop.Controller;
import com.lyft.scoop.Screen;
import java.io.File;
import me.lyft.android.analytics.definitions.Category;
import me.lyft.android.common.Objects;
import me.lyft.android.ui.Dialogs;

@Controller(PhotoPickerDialogController.class)
public final class PhotoPickerDialog
  extends Dialogs
{
  private Category analyticsCategory;
  private Screen captureScreen;
  private File outFile;
  private Screen previewScreen;
  private Screen returnScreen;
  private String title;
  
  public PhotoPickerDialog(String paramString, Screen paramScreen1, Screen paramScreen2, Screen paramScreen3, File paramFile)
  {
    captureScreen = paramScreen1;
    returnScreen = paramScreen2;
    outFile = paramFile;
    title = paramString;
    previewScreen = paramScreen3;
  }
  
  public PhotoPickerDialog(String paramString, Screen paramScreen1, Screen paramScreen2, Screen paramScreen3, File paramFile, Category paramCategory)
  {
    captureScreen = paramScreen1;
    returnScreen = paramScreen2;
    outFile = paramFile;
    title = paramString;
    previewScreen = paramScreen3;
    analyticsCategory = paramCategory;
  }
  
  public Category getAnalyticsCategory()
  {
    return (Category)Objects.firstNonNull(analyticsCategory, Category.PHOTO_PICKER_DIALOG);
  }
  
  public Screen getCaptureScreen()
  {
    return captureScreen;
  }
  
  public File getOutFile()
  {
    return outFile;
  }
  
  public Screen getPreviewScreen()
  {
    return previewScreen;
  }
  
  public Screen getReturnScreen()
  {
    return returnScreen;
  }
  
  public String getTitle()
  {
    return title;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.photo.PhotoPickerDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */