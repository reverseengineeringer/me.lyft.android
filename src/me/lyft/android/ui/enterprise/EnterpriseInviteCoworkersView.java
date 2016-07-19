package me.lyft.android.ui.enterprise;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.enterprise.Organization;
import me.lyft.android.domain.enterprise.OrganizationBenefitDetails;
import me.lyft.android.domain.enterprise.OrganizationBenefitStatus;
import me.lyft.android.domain.enterprise.OrganizationPromotionDetails;
import me.lyft.android.domain.enterprise.OrganizationPromotionStatus;
import me.lyft.android.domain.enterprise.UserOrganization;
import me.lyft.android.domain.invite.InviteText;
import me.lyft.android.infrastructure.share.IShareService;
import me.lyft.android.rx.Binder;
import me.lyft.android.utils.WebBrowser;
import rx.functions.Action1;

public class EnterpriseInviteCoworkersView
  extends LinearLayout
{
  private static final String INVITE_COWORKERS_BUTTON = "Invite coworkers";
  @Inject
  AppFlow appFlow;
  Binder binder;
  String company;
  TextView coworkersNeededTextView;
  TextView coworkersRegisteredTextView;
  String email;
  TextView emailOrOrganizationTextView;
  Button inviteCoworkersButton;
  TextView inviteCoworkersDescriptionTextView;
  TextView inviteCoworkersHeaderTextView;
  InviteText inviteText;
  Boolean noBenefit = Boolean.valueOf(false);
  private Action1<Integer> onToolbarItemClicked = new EnterpriseInviteCoworkersView.2(this);
  Organization organization;
  private final EnterpriseScreens.EnterpriseScreen params;
  FrameLayout progressBarFrameLayout;
  View progressBarView;
  TextView remainBalanceTextView;
  @Inject
  IShareService smsService;
  UserOrganization userOrganization;
  @Inject
  WebBrowser webBrowser;
  
  public EnterpriseInviteCoworkersView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    params = ((EnterpriseScreens.EnterpriseScreen)Screen.fromView(this));
  }
  
  private String getMailBody()
  {
    return inviteText.getEmailBody();
  }
  
  private String getMailSubject()
  {
    return inviteText.getEmailSubject();
  }
  
  private int getPercent(Integer paramInteger1, Integer paramInteger2)
  {
    int j = (int)(paramInteger1.intValue() * 100.0D) / paramInteger2.intValue();
    int i;
    if (j < 0) {
      i = 0;
    }
    do
    {
      return i;
      i = j;
    } while (j < 100);
    return 100;
  }
  
  private int getProgressBarFrameLayoutWidth()
  {
    return (int)(progressBarFrameLayout.getLayoutParams().width / getResourcesgetDisplayMetricsdensity);
  }
  
  private void onInviteCoworkersButtonClicked()
  {
    if (noBenefit.booleanValue())
    {
      webBrowser.open(inviteText.getBenefitsUrl());
      return;
    }
    startSendTextIntent();
  }
  
  private void setApprovedBenefitLayouts()
  {
    if (Strings.isNullOrEmpty(organization.getBenefitDetails().getBenefitCredit()))
    {
      if (organization.getBenefitStatus() != null)
      {
        setDirectBillingLayout();
        return;
      }
      setPromotionLayout();
      return;
    }
    setBenefitDetailsLayouts();
  }
  
  private void setBenefitDetailsLayouts()
  {
    inviteCoworkersHeaderTextView.setText(organization.getBenefitDetails().getBenefitDescription());
    inviteCoworkersDescriptionTextView.setText(organization.getBenefitDetails().getBenefitRestriction());
    inviteCoworkersDescriptionTextView.setTextAppearance(getContext().getApplicationContext(), 2131296491);
    inviteCoworkersDescriptionTextView.setTypeface(null, 2);
    remainBalanceTextView.setText(organization.getBenefitDetails().getBenefitCredit());
    remainBalanceTextView.setVisibility(0);
  }
  
  private void setContentViewProperties()
  {
    userOrganization = params.getUserOrganization();
    organization = userOrganization.getOrganization();
    inviteText = userOrganization.getInviteText();
    company = organization.getName();
    boolean bool;
    String str;
    label107:
    Object localObject2;
    if (("unapproved".equalsIgnoreCase(organization.getStatus())) && (Strings.isNullOrEmpty(organization.getPromotionStatus().getPromotionHeader())))
    {
      bool = true;
      noBenefit = Boolean.valueOf(bool);
      if (!noBenefit.booleanValue()) {
        break label221;
      }
      str = getContext().getString(2131165879);
      localObject2 = params.getEmail();
      localObject1 = localObject2;
      if (Strings.isNullOrEmpty((String)localObject2)) {
        localObject1 = organization.getEmail();
      }
      email = ((String)localObject1);
      localObject2 = emailOrOrganizationTextView;
      if (!Strings.isNullOrEmpty(company)) {
        break label235;
      }
    }
    label221:
    label235:
    for (Object localObject1 = email;; localObject1 = company)
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      inviteCoworkersButton.setText(str);
      remainBalanceTextView.setVisibility(8);
      coworkersRegisteredTextView.setVisibility(8);
      progressBarFrameLayout.setVisibility(8);
      coworkersNeededTextView.setVisibility(8);
      setOrganizationLayouts();
      return;
      bool = false;
      break;
      str = getContext().getString(2131165685);
      break label107;
    }
  }
  
  private void setDirectBillingLayout()
  {
    inviteCoworkersHeaderTextView.setText((CharSequence)Objects.firstNonNull(organization.getBenefitStatus().getBenefitHeader(), ""));
    inviteCoworkersDescriptionTextView.setText((CharSequence)Objects.firstNonNull(organization.getBenefitStatus().getBenefitDescription(), ""));
  }
  
  private void setNoBenefitLayouts()
  {
    if (Boolean.valueOf(Strings.isNullOrEmpty(organization.getBenefitStatus().getBenefitHeader())).booleanValue())
    {
      inviteCoworkersHeaderTextView.setText(getContext().getString(2131165681));
      inviteCoworkersDescriptionTextView.setText(getContext().getString(2131165680, new Object[] { company }));
      return;
    }
    inviteCoworkersHeaderTextView.setText(organization.getBenefitStatus().getBenefitHeader());
    inviteCoworkersDescriptionTextView.setText(organization.getBenefitStatus().getBenefitDescription());
  }
  
  private void setOrganizationLayouts()
  {
    if ("approved".equalsIgnoreCase(organization.getStatus()))
    {
      setApprovedBenefitLayouts();
      return;
    }
    if ("unapproved".equalsIgnoreCase(organization.getStatus()))
    {
      setUnapprovedBenefitLayouts();
      return;
    }
    setNoBenefitLayouts();
  }
  
  private void setProgressLayouts()
  {
    Integer localInteger1 = Integer.valueOf(organization.getPromotionStatus().getRegistered());
    Integer localInteger2 = Integer.valueOf(organization.getPromotionStatus().getNeeded());
    if (localInteger1.intValue() < localInteger2.intValue())
    {
      updateProgress(getPercent(localInteger1, localInteger2));
      int i = localInteger2.intValue();
      int j = localInteger1.intValue();
      coworkersNeededTextView.setText(getContext().getString(2131165807, new Object[] { Integer.valueOf(i - j).toString() }));
      coworkersNeededTextView.setTextColor(-16777216);
      coworkersRegisteredTextView.setText(getContext().getString(2131165808, new Object[] { localInteger1.toString(), "" }));
      return;
    }
    updateProgress(getPercent(localInteger1, localInteger2));
    coworkersRegisteredTextView.setGravity(17);
    coworkersNeededTextView.setText(organization.getPromotionStatus().getPendingApprovalText());
    coworkersNeededTextView.setGravity(17);
    coworkersNeededTextView.setTextColor(-16777216);
    coworkersRegisteredTextView.setText(getContext().getString(2131165808, new Object[] { localInteger1.toString(), "!" }));
  }
  
  private void setPromotionLayout()
  {
    inviteCoworkersHeaderTextView.setText(organization.getPromotionDetails().getPromotionHeader());
    inviteCoworkersDescriptionTextView.setText(organization.getPromotionDetails().getPromotionDescription());
  }
  
  private void setPromotionStatusLayouts()
  {
    inviteCoworkersHeaderTextView.setText(organization.getPromotionStatus().getPromotionHeader());
    inviteCoworkersDescriptionTextView.setText(organization.getPromotionStatus().getPromotionDescription());
    setProgressLayouts();
    coworkersRegisteredTextView.setVisibility(0);
    progressBarFrameLayout.setVisibility(0);
    coworkersNeededTextView.setVisibility(0);
  }
  
  private void setUnapprovedBenefitLayouts()
  {
    if (Strings.isNullOrEmpty(organization.getPromotionStatus().getPromotionHeader()))
    {
      setNoBenefitLayouts();
      return;
    }
    setPromotionStatusLayouts();
  }
  
  private void startSendTextIntent()
  {
    smsService.sharePlainText(getContext().getString(2131166324), getMailBody(), getMailSubject());
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Toolbar localToolbar = (Toolbar)((ViewGroup)getParent()).findViewById(2131558464);
    localToolbar.clearItems().addItem(2131558439, 2130838113);
    binder = Binder.attach(this);
    binder.bind(localToolbar.observeItemClick(), onToolbarItemClicked);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
    setContentViewProperties();
    inviteCoworkersButton.setOnClickListener(new EnterpriseInviteCoworkersView.1(this));
  }
  
  public void updateProgress(int paramInt)
  {
    int i = getProgressBarFrameLayoutWidth();
    float f = (float)(i / 100.0D);
    int j = (int)(paramInt * f);
    if (j > i) {
      paramInt = i;
    }
    for (;;)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams((int)TypedValue.applyDimension(1, paramInt, getResources().getDisplayMetrics()), -1);
      progressBarView.setLayoutParams(localLayoutParams);
      return;
      paramInt = j;
      if (j < 0) {
        paramInt = 0;
      }
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.enterprise.EnterpriseInviteCoworkersView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */