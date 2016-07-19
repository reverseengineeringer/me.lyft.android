package me.lyft.android.ui;

import com.lyft.scoop.Controller;
import com.lyft.scoop.Layout;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerModule;
import me.lyft.android.common.Objects;
import me.lyft.android.common.SingleInstance;
import me.lyft.android.domain.User;
import me.lyft.android.ui.driver.carpool.DriverCarpoolRidesModule;
import me.lyft.android.ui.driver.carpool.screens.CarpoolDriverRideController;
import me.lyft.android.ui.driver.ridescreens.DriverRideController;
import me.lyft.android.ui.driver.ridescreens.DriverRideModule;
import me.lyft.android.ui.ride.PassengerRideModule;

public class MainScreens
  extends Screen
{
  @Layout(2130903040)
  public static class AcceptTermsScreen
    extends MainScreens
  {
    private final boolean toDriverFlow;
    
    public AcceptTermsScreen(boolean paramBoolean)
    {
      toDriverFlow = paramBoolean;
    }
    
    public boolean isToDriverFlow()
    {
      return toDriverFlow;
    }
  }
  
  @Controller(CarpoolDriverRideController.class)
  @DaggerModule(DriverCarpoolRidesModule.class)
  @SingleInstance
  public static class CarpoolDriverRideScreen
    extends Screen
  {}
  
  @Controller(DriverRideController.class)
  @DaggerModule(DriverRideModule.class)
  @SingleInstance
  public static class DriverRideScreen
    extends Screen
  {
    private boolean goOffline;
    private boolean goOnline;
    private String webDialogUrl;
    
    public DriverRideScreen enableGoOffline()
    {
      goOffline = true;
      return this;
    }
    
    public DriverRideScreen enableGoOnline()
    {
      goOnline = true;
      return this;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        if (!super.equals(paramObject)) {
          return false;
        }
        paramObject = (DriverRideScreen)paramObject;
      } while ((goOnline == goOnline) && (goOffline == goOffline) && (Objects.equals(webDialogUrl, webDialogUrl)));
      return false;
    }
    
    public String getWebDialogParams()
    {
      return webDialogUrl;
    }
    
    public boolean isGoOffline()
    {
      return goOffline;
    }
    
    public boolean isGoOnline()
    {
      return goOnline;
    }
    
    public void resetSwitchToDriverMode()
    {
      goOnline = false;
    }
    
    public void resetSwitchToPassengerMode()
    {
      goOffline = false;
    }
    
    public void resetWebDialogUrl()
    {
      webDialogUrl = null;
    }
    
    public DriverRideScreen setWebDialogUrl(String paramString)
    {
      webDialogUrl = paramString;
      return this;
    }
  }
  
  @Layout(2130903237)
  public static class FullscreenPhotoScreen
    extends MainScreens
  {
    final String photoUrl;
    final String subtitle;
    final String title;
    
    public FullscreenPhotoScreen(String paramString)
    {
      this(paramString, null, null);
    }
    
    public FullscreenPhotoScreen(String paramString1, String paramString2)
    {
      this(paramString1, paramString2, null);
    }
    
    public FullscreenPhotoScreen(String paramString1, String paramString2, String paramString3)
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
  
  @Controller(GlobalTermsOfServiceDetailController.class)
  public static class GlobalTermsOfServiceDetailScreen
    extends Screen
  {
    public final String termsOfServiceUrl;
    
    public GlobalTermsOfServiceDetailScreen(String paramString)
    {
      termsOfServiceUrl = paramString;
    }
  }
  
  @Controller(GlobalTermsOfServiceController.class)
  public static class GlobalTermsOfServiceScreen
    extends MainScreens
  {
    public final String onboardingUrl;
    public final String termsOfServiceUrl;
    
    public GlobalTermsOfServiceScreen(User paramUser)
    {
      onboardingUrl = paramUser.getOnboardingUrl();
      termsOfServiceUrl = paramUser.getTermsUrl();
    }
  }
  
  @Layout(2130903360)
  @DaggerModule(PassengerRideModule.class)
  @SingleInstance
  public static class PassengerRideScreen
    extends Screen
  {
    private String webDialogUrl;
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        if (!super.equals(paramObject)) {
          return false;
        }
        paramObject = (PassengerRideScreen)paramObject;
      } while (Objects.equals(webDialogUrl, webDialogUrl));
      return false;
    }
    
    public String getWebDialogParams()
    {
      return webDialogUrl;
    }
    
    public void resetWebDialogUrl()
    {
      webDialogUrl = null;
    }
    
    public PassengerRideScreen setWebDialogUrl(String paramString)
    {
      webDialogUrl = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.MainScreens
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */