package me.lyft.android.ui.enterprise;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.application.enterprise.IEnterpriseService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.enterprise.Organization;
import me.lyft.android.domain.enterprise.UserOrganization;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;

public class EnterpriseMainView
  extends LinearLayout
{
  @Inject
  AppFlow appFlow;
  Binder binder;
  @Inject
  IEnterpriseService enterpriseService;
  EnterpriseScreens.EnterpriseMainScreen params;
  @Inject
  IProgressController progressController;
  UserOrganization userOrganization;
  @Inject
  IViewErrorHandler viewErrorHandler;
  
  public EnterpriseMainView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    params = ((EnterpriseScreens.EnterpriseMainScreen)Screen.fromView(this));
  }
  
  private void enterpriseScreenChooser()
  {
    Object localObject = userOrganization.getOrganization();
    String str = ((Organization)localObject).getEmail();
    localObject = ((Organization)localObject).getStatus();
    if (Strings.isNullOrEmpty((String)localObject))
    {
      appFlow.replaceWith(new EnterpriseScreens.EnterpriseEnterEmailScreen(str, userOrganization));
      return;
    }
    if ("unverified".equalsIgnoreCase((String)localObject))
    {
      appFlow.replaceWith(new EnterpriseScreens.EnterpriseVerifyEmailSelectScreen(str, userOrganization));
      return;
    }
    if ("unapproved".equalsIgnoreCase((String)localObject))
    {
      appFlow.replaceWith(new EnterpriseScreens.EnterpriseInviteCoworkersSelectScreen(str, userOrganization));
      return;
    }
    if ("approved".equalsIgnoreCase((String)localObject))
    {
      localObject = params.getOrganizationCreditLabel();
      if (Strings.isNullOrEmpty((String)localObject))
      {
        appFlow.replaceWith(new EnterpriseScreens.EnterpriseInviteCoworkersSelectScreen(str, userOrganization));
        return;
      }
      appFlow.replaceWith(new EnterpriseScreens.EnterpriseInviteCoworkersScreen(str, userOrganization, (String)localObject));
      return;
    }
    appFlow.replaceWith(new EnterpriseScreens.EnterpriseEnterEmailScreen(str, userOrganization));
  }
  
  private void getUserOrganization()
  {
    progressController.disableUI();
    progressController.showProgress();
    binder.bind(enterpriseService.getUserOrganization(), new EnterpriseMainView.1(this));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder = Binder.attach(this);
    getUserOrganization();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.enterprise.EnterpriseMainView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */