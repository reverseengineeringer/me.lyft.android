package me.lyft.android.ui.business.profile;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.application.checkout.ICheckoutSession;
import me.lyft.android.application.enterprise.IEnterpriseService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.persistence.payment.IChargeAccountsProvider;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IProgressController;

public class BusinessProfileView
  extends LinearLayout
{
  @Inject
  AppFlow appFlow;
  @Inject
  IChargeAccountsProvider chargeAccountsProvider;
  @Inject
  ICheckoutSession checkoutSession;
  private String email;
  ImageView emailImageView;
  View emailListItem;
  TextView emailSubtitleView;
  TextView emailTitleView;
  @Inject
  IEnterpriseService enterpriseService;
  View paymentListItem;
  TextView paymentSubtitleView;
  TextView paymentTitleView;
  @Inject
  IProgressController progressController;
  Toolbar toolbar;
  
  public BusinessProfileView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Binder localBinder = Binder.attach(this);
    progressController.showProgress();
    localBinder.bind(enterpriseService.getUserOrganization(), new BusinessProfileView.1(this));
    localBinder.bind(chargeAccountsProvider.observeDefaultBusinessChargeAccount(), new BusinessProfileView.2(this));
    paymentListItem.setOnClickListener(new BusinessProfileView.3(this));
    emailListItem.setOnClickListener(new BusinessProfileView.4(this));
    emailImageView.setImageResource(2130838212);
    emailTitleView.setText(getResources().getString(2131165347));
    paymentTitleView.setText(getResources().getString(2131165350));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
    toolbar.showTitle().setTitle(getContext().getString(2131165348));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.business.profile.BusinessProfileView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */