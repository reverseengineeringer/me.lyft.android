package me.lyft.android.ui.enterprise;

import android.content.res.Resources;
import dagger.Module;
import dagger.Provides;
import me.lyft.android.ui.IViewErrorHandler;

@Module(complete=false, injects={EnterpriseEditEmailView.class, EnterpriseEnterEmailView.class, EnterpriseInviteCoworkersScreenView.class, EnterpriseInviteCoworkersSelectScreenView.class, EnterpriseInviteCoworkersViaContactsView.class, EnterpriseInviteCoworkersView.class, EnterpriseMainView.class, EnterpriseVerifyEmailScreenView.class, EnterpriseVerifyEmailSelectScreenView.class, EnterpriseVerifyEmailView.class})
public class EnterpriseModule
{
  @Provides
  public IEnterpriseErrorHandler provideEnterpriseErrorHandler(IViewErrorHandler paramIViewErrorHandler, Resources paramResources)
  {
    return new EnterpriseErrorHandler(paramIViewErrorHandler, paramResources);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.enterprise.EnterpriseModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */