package me.lyft.android.ui;

import com.lyft.scoop.Layout;

@Layout(2130903237)
public class MainScreens$FullscreenPhotoScreen
  extends MainScreens
{
  final String photoUrl;
  final String subtitle;
  final String title;
  
  public MainScreens$FullscreenPhotoScreen(String paramString)
  {
    this(paramString, null, null);
  }
  
  public MainScreens$FullscreenPhotoScreen(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, null);
  }
  
  public MainScreens$FullscreenPhotoScreen(String paramString1, String paramString2, String paramString3)
  {
    photoUrl = paramString1;
    title = paramString2;
    subtitle = paramString3;
  }
  
  public String getPhotoUrl()
  {
    return photoUrl;
  }
  
  public String getSubtitle()
  {
    return subtitle;
  }
  
  public String getTitle()
  {
    return title;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.MainScreens.FullscreenPhotoScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */