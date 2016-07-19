package me.lyft.android.ui.terms;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.terms.ITermsService;
import me.lyft.android.application.terms.TermsService;
import me.lyft.android.infrastructure.lyft.ILyftApi;

@Module(complete=false, library=true)
public class TermsModule
{
  @Provides
  @Singleton
  public ITermsService provideTermsService(ILyftApi paramILyftApi, IUserProvider paramIUserProvider)
  {
    return new TermsService(paramILyftApi, paramIUserProvider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.terms.TermsModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */