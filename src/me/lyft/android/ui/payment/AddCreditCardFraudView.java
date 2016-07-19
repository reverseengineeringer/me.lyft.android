package me.lyft.android.ui.payment;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.common.AppFlow;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.payment.ICard;
import me.lyft.android.infrastructure.cardscan.ICardScanService;
import me.lyft.android.rx.Binder;
import rx.functions.Action1;

public class AddCreditCardFraudView
  extends LinearLayout
{
  @Inject
  AppFlow appFlow;
  private Binder binder;
  @Inject
  ICardScanService cardScanService;
  private Action1<ICard> onCreditCardScanned = new AddCreditCardFraudView.1(this);
  LinearLayout scanCardButton;
  private PaymentScreens.AddCreditCardFraudScreen screen;
  Toolbar toolbar;
  
  public AddCreditCardFraudView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    screen = ((PaymentScreens.AddCreditCardFraudScreen)Screen.fromView(this));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder = Binder.attach(this);
    binder.bind(cardScanService.observeScannedCard(), onCreditCardScanned);
    toolbar.setTitle(getResources().getString(2131166023));
    cardScanService.start();
    scanCardButton.setOnClickListener(new AddCreditCardFraudView.2(this));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    cardScanService.stop();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.AddCreditCardFraudView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */