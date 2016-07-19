package me.lyft.android.ui.passenger.rateandpay;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.checkout.ICheckoutSession;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.ride.IExpenseNoteSession;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.User;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.domain.payment.ChargeAccount;
import me.lyft.android.rx.Binder;

public class PassengerRideExpenseNoteView
  extends LinearLayout
{
  private Binder binder;
  @Inject
  ICheckoutSession checkoutSession;
  EditText expenseCodeText;
  LinearLayout expenseCodeView;
  @Inject
  IExpenseNoteSession expenseNoteSession;
  EditText expenseNoteText;
  TextView expenseNoteTextView;
  @Inject
  IPassengerRideProvider passengerRideProvider;
  PassengerSubmitRatingButton submitDriverRatingButton;
  Toolbar toolbar;
  @Inject
  IUserProvider userProvider;
  
  public PassengerRideExpenseNoteView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private void initView()
  {
    int k = 8;
    boolean bool1 = expenseNoteSession.isConcurEnabled();
    boolean bool2 = checkoutSession.isBusinessProfile();
    Object localObject;
    int j;
    if (((bool1) && (!userProvider.getUser().hasBusinessProfile())) || (bool2))
    {
      i = 1;
      setToolbarTitle(bool1, bool2);
      localObject = expenseCodeView;
      if (i == 0) {
        break label189;
      }
      j = 0;
      label72:
      ((LinearLayout)localObject).setVisibility(j);
      localObject = expenseNoteText;
      if (i == 0) {
        break label195;
      }
      j = 5;
      label90:
      ((EditText)localObject).setImeOptions(j);
      localObject = expenseNoteTextView;
      if (i == 0) {
        break label201;
      }
    }
    label189:
    label195:
    label201:
    for (int i = k;; i = 0)
    {
      ((TextView)localObject).setVisibility(i);
      expenseNoteTextView.setText(String.format(getContext().getString(2131165699), new Object[] { checkoutSession.getSelectedOrDefaultChargeAccount().getLabel() }));
      binder.bind(submitDriverRatingButton.observeOnSubmitPressed(), new PassengerRideExpenseNoteView.1(this, bool1, bool2));
      restoreExpenseNoteData();
      return;
      i = 0;
      break;
      j = 8;
      break label72;
      j = 6;
      break label90;
    }
  }
  
  private boolean isSameRide()
  {
    return expenseNoteSession.getRideId().equals(passengerRideProvider.getPassengerRide().getId());
  }
  
  private void persistExpenseNoteData()
  {
    expenseNoteSession.setRideId(passengerRideProvider.getPassengerRide().getId());
    expenseNoteSession.setExpenseNote(expenseNoteText.getText().toString());
    expenseNoteSession.setExpenseCode(expenseCodeText.getText().toString());
  }
  
  private void restoreExpenseNoteData()
  {
    if (isSameRide())
    {
      expenseNoteText.setText(expenseNoteSession.getExpenseNote());
      expenseCodeText.setText(expenseNoteSession.getExpenseCode());
    }
  }
  
  private void setToolbarTitle(boolean paramBoolean1, boolean paramBoolean2)
  {
    String str2 = getResources().getString(2131165702);
    String str1 = str2;
    if (paramBoolean1)
    {
      str1 = str2;
      if (!userProvider.getUser().hasBusinessProfile()) {
        str1 = getResources().getString(2131166033);
      }
    }
    if (paramBoolean2) {
      str1 = getResources().getString(2131165971);
    }
    toolbar.setTitle(str1);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder = Binder.attach(this);
    initView();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    persistExpenseNoteData();
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
 * Qualified Name:     me.lyft.android.ui.passenger.rateandpay.PassengerRideExpenseNoteView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */