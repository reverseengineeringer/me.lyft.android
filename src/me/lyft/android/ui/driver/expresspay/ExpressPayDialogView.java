package me.lyft.android.ui.driver.expresspay;

import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.application.settings.ISignUrlService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Strings;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.dialogs.DialogContainerView;
import me.lyft.android.utils.WebBrowser;

public class ExpressPayDialogView
  extends DialogContainerView
{
  @Inject
  AppFlow appFlow;
  private Binder binder;
  Button buttonTxt;
  ImageView closeButton;
  @Inject
  DialogFlow dialogFlow;
  ImageView dialogIconImageView;
  ImageView dialogTitleImageView;
  TextView dialogTitleTextView;
  View listDivider;
  TextView messageTxt;
  private ExpressPayDialogs.ExpressPayDialog params;
  @Inject
  ISignUrlService signUrlService;
  TextView textUrlView;
  LinearLayout titleContainer;
  @Inject
  WebBrowser webBrowser;
  
  public ExpressPayDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    params = ((ExpressPayDialogs.ExpressPayDialog)Screen.fromView(this));
  }
  
  private void openWebPage(String paramString)
  {
    binder.bind(signUrlService.getSignedUrl(paramString), new ExpressPayDialogView.4(this, paramString));
  }
  
  private void updateViews()
  {
    if (params.getIcon() != null)
    {
      dialogIconImageView.setVisibility(0);
      dialogIconImageView.setImageResource(params.getIcon().intValue());
    }
    if (params.getTitleIcon() != null)
    {
      titleContainer.setVisibility(0);
      dialogTitleImageView.setVisibility(0);
      dialogTitleImageView.setImageResource(params.getTitleIcon().intValue());
    }
    if (params.getTitle() != null)
    {
      titleContainer.setVisibility(0);
      dialogTitleTextView.setVisibility(0);
      dialogTitleTextView.setText(params.getTitle());
    }
    messageTxt.setText(Html.fromHtml(params.getMessage()));
    if ((!Strings.isNullOrEmpty(params.getTextUrlLabel())) && (!Strings.isNullOrEmpty(params.getTextUrl())))
    {
      textUrlView.setVisibility(0);
      textUrlView.setText(params.getTextUrlLabel());
      textUrlView.setPaintFlags(8);
      textUrlView.setOnClickListener(new ExpressPayDialogView.1(this));
    }
    if (params.getButtonText() != null)
    {
      Screen localScreen = params.getTargetScreen();
      listDivider.setVisibility(0);
      buttonTxt.setVisibility(0);
      buttonTxt.setText(params.getButtonText());
      buttonTxt.setOnClickListener(new ExpressPayDialogView.2(this, localScreen));
    }
    if (params.showCloseButton())
    {
      closeButton.setOnClickListener(new ExpressPayDialogView.3(this));
      return;
    }
    closeButton.setVisibility(8);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder = Binder.attach(this);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
    updateViews();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.expresspay.ExpressPayDialogView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */