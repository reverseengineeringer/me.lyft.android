package me.lyft.android.ui.webview;

import dagger.Module;
import dagger.Provides;
import me.lyft.android.ui.IProgressController;

@Module(complete=false, library=true)
public class WebviewModule
{
  @Provides
  WebviewInitializer provideWebviewInitializer(IProgressController paramIProgressController)
  {
    return new WebviewInitializer(paramIProgressController);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.webview.WebviewModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */