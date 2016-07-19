package me.lyft.android.ui.enterprise;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.enterprise.Organization;
import me.lyft.android.domain.enterprise.OrganizationUnverifiedDetails;
import me.lyft.android.domain.enterprise.UserOrganization;

public class EnterpriseVerifyEmailView
  extends FrameLayout
{
  @Inject
  AppFlow appFlow;
  TextView enterpriseEmailTextView;
  TextView enterpriseVerifyEmailDescription;
  TextView enterpriseVerifyEmailHeader;
  private Organization organization;
  private OrganizationUnverifiedDetails unverifiedDetails;
  private UserOrganization userOrganization;
  private String verifyEmail;
  
  public EnterpriseVerifyEmailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
  }
  
  void onResendButtonClicked()
  {
    appFlow.replaceWith(new EnterpriseScreens.EnterpriseEnterEmailScreen(verifyEmail, userOrganization));
  }
  
  public void setContentViewProperties(String paramString, UserOrganization paramUserOrganization)
  {
    userOrganization = paramUserOrganization;
    organization = paramUserOrganization.getOrganization();
    unverifiedDetails = organization.getUnverifiedDetails();
    enterpriseVerifyEmailHeader.setText(unverifiedDetails.getUnverifiedHeader());
    enterpriseVerifyEmailDescription.setText(unverifiedDetails.getUnverifiedDescription());
    paramUserOrganization = paramString;
    if (Strings.isNullOrEmpty(paramString)) {
      paramUserOrganization = organization.getEmail();
    }
    verifyEmail = paramUserOrganization;
    if (!Strings.isNullOrEmpty(verifyEmail)) {
      enterpriseEmailTextView.setText(verifyEmail);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.enterprise.EnterpriseVerifyEmailView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */