package me.lyft.android.ui.payment;

import android.content.Context;
import android.content.res.Resources;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.checkout.ICheckoutSession;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.payment.Credit;
import me.lyft.android.persistence.ride.IPassengerRideReceiptService;
import me.lyft.android.ui.Dialogs.AlertDialog;

public abstract class CouponPaymentListItemView
  extends PaymentListItemView
{
  @Inject
  AppFlow appFlow;
  @Inject
  ICheckoutSession checkoutSession;
  Credit credit;
  @Inject
  DialogFlow dialogFlow;
  @Inject
  IPassengerRideReceiptService fareRepository;
  
  public CouponPaymentListItemView(Context paramContext, Credit paramCredit)
  {
    super(paramContext);
    DaggerInjector.fromView(this).inject(this);
    credit = paramCredit;
  }
  
  private String getInvalidCreditMessage()
  {
    List localList = credit.getInvalidRestrictions();
    if (localList.isEmpty()) {
      return getResources().getString(2131166078);
    }
    return listToString(localList);
  }
  
  private String getInvalidCreditTitle()
  {
    String str2 = credit.getInvalidTitle();
    String str1 = str2;
    if (Strings.isNullOrEmpty(str2)) {
      str1 = getResources().getString(2131166076);
    }
    return str1;
  }
  
  private static String listToString(List<String> paramList)
  {
    Object localObject1 = (String)paramList.get(0);
    Object localObject2 = localObject1;
    if (!Strings.isNullOrEmpty((String)localObject1))
    {
      localObject2 = localObject1;
      if (paramList.size() > 1)
      {
        int i = 1;
        for (;;)
        {
          localObject2 = localObject1;
          if (i >= paramList.size()) {
            break;
          }
          localObject2 = localObject1;
          if (!Strings.isNullOrEmpty((String)paramList.get(i))) {
            localObject2 = (String)localObject1 + ". " + (String)paramList.get(i);
          }
          i += 1;
          localObject1 = localObject2;
        }
      }
    }
    return (String)localObject2;
  }
  
  protected int getIcon()
  {
    return 2130837649;
  }
  
  protected String getSubTitle()
  {
    return credit.getDescription();
  }
  
  protected String getTitle()
  {
    return credit.getTitle();
  }
  
  protected boolean isFailed()
  {
    return false;
  }
  
  protected void showInvalidCreditDialog()
  {
    Dialogs.AlertDialog localAlertDialog = new Dialogs.AlertDialog("invalid_credit_dialog").setTitle(getInvalidCreditTitle()).setTitleColorResource(2131493111).setMessage(getInvalidCreditMessage()).addPositiveButton(getResources().getString(2131165939));
    dialogFlow.show(localAlertDialog);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.CouponPaymentListItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */