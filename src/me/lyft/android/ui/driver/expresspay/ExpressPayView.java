package me.lyft.android.ui.driver.expresspay;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import com.lyft.widgets.AdvancedButton;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.driver.expresspay.IExpressPayRepository;
import me.lyft.android.application.driver.expresspay.IExpressPayService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.driver.ExpressPay;
import me.lyft.android.domain.driver.ExpressPayAccount;
import me.lyft.android.domain.payment.LineItem;
import me.lyft.android.domain.payment.Money;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IProgressController;

public class ExpressPayView
  extends LinearLayout
{
  AdvancedButton addOrEditDebitCard;
  @Inject
  AppFlow appFlow;
  private Binder binder;
  @Inject
  DialogFlow dialogFlow;
  @Inject
  IExpressPayErrorHandler expressPayErrorHandler;
  @Inject
  IExpressPayRepository expressPayRepository;
  @Inject
  IExpressPayService expressPayService;
  Button getPaidButton;
  private LayoutInflater inflater;
  TextView inlineErrorTxt;
  LinearLayout itemsContainer;
  @Inject
  IProgressController progressController;
  Toolbar toolbar;
  TextView totalAmount;
  TextView totalLabel;
  
  public ExpressPayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    inflater = Scoop.fromView(this).inflater(paramContext);
  }
  
  private void addLineItems()
  {
    ExpressPay localExpressPay = expressPayRepository.getExpressPay();
    int i = 0;
    Iterator localIterator = localExpressPay.getLineItems().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (LineItem)localIterator.next();
      String str = Money.format(((LineItem)localObject).getAmount().getAmount().intValue());
      localObject = ((LineItem)localObject).getTitle();
      i += 1;
      if (localExpressPay.isLastItem(i))
      {
        totalLabel.setText((CharSequence)localObject);
        totalAmount.setText(str);
      }
      else
      {
        ViewGroup localViewGroup = (ViewGroup)inflater.inflate(2130903228, itemsContainer, false);
        ((TextView)localViewGroup.findViewById(2131559153)).setText((CharSequence)localObject);
        ((TextView)localViewGroup.findViewById(2131559154)).setText(str);
        itemsContainer.addView(localViewGroup);
      }
    }
  }
  
  private void refreshDebitCardButton(ExpressPayAccount paramExpressPayAccount)
  {
    Object localObject;
    if (!paramExpressPayAccount.isNull())
    {
      addOrEditDebitCard.setText(getResources().getString(2131165671, new Object[] { paramExpressPayAccount.getType(), paramExpressPayAccount.getLastFour() }));
      TextView localTextView = inlineErrorTxt;
      if (!paramExpressPayAccount.isFailed()) {
        break label96;
      }
      localObject = paramExpressPayAccount.getFailedMessage();
      localTextView.setText((CharSequence)localObject);
      localObject = inlineErrorTxt;
      if (!paramExpressPayAccount.isFailed()) {
        break label102;
      }
    }
    label96:
    label102:
    for (int i = 0;; i = 8)
    {
      ((TextView)localObject).setVisibility(i);
      addOrEditDebitCard.setValidationMessageView(inlineErrorTxt);
      return;
      localObject = "";
      break;
    }
  }
  
  private void submitPayouts()
  {
    progressController.showProgress();
    binder.bind(expressPayService.submitPayout(), new ExpressPayView.6(this));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder = Binder.attach(this);
    binder.bind(toolbar.observeHomeClick(), new ExpressPayView.1(this));
    binder.bind(expressPayRepository.observeExpressPayAccountChange(), new ExpressPayView.2(this));
    addOrEditDebitCard.setOnClickListener(new ExpressPayView.3(this));
    getPaidButton.setOnClickListener(new ExpressPayView.4(this));
    totalLabel.setOnClickListener(new ExpressPayView.5(this));
    addLineItems();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
    toolbar.setTitle(getResources().getString(2131165703));
    toolbar.setHomeIcon(2130838108);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.expresspay.ExpressPayView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */