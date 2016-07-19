package me.lyft.android.infrastructure.instabug;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module(complete=false, library=true)
public class InstabugModule
{
  @Provides
  @Singleton
  IInstabugService provideIInstabugService()
  {
    return new NoOpInstabugService();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.instabug.InstabugModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */