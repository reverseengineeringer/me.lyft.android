package me.lyft.android.common;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import me.lyft.android.LyftApplication;
import me.lyft.android.application.ILogoutService;
import me.lyft.android.errorhandling.DefaultErrorHandler;
import me.lyft.android.errorhandling.IDefaultErrorHandler;

@Module(complete=false, library=true)
public class CommonModule
{
  @Provides
  @Singleton
  public ActivityController provideActivityController()
  {
    return new ActivityController();
  }
  
  @Provides
  @Singleton
  public AppFlow provideAppFlow()
  {
    return new AppFlow(false);
  }
  
  @Provides
  @Singleton
  public IAppStore provideAppStore(LyftApplication paramLyftApplication)
  {
    return new AppStore(paramLyftApplication);
  }
  
  @Provides
  public IDefaultErrorHandler provideDefaultErrorHandler(AppFlow paramAppFlow, DialogFlow paramDialogFlow, ILogoutService paramILogoutService)
  {
    return new DefaultErrorHandler(paramAppFlow, paramDialogFlow, paramILogoutService);
  }
  
  @Provides
  @Singleton
  public DialogFlow provideDialogFlow()
  {
    return new DialogFlow(new AppFlow(true));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.CommonModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */