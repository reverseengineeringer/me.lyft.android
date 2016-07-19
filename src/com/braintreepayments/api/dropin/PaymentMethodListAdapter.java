package com.braintreepayments.api.dropin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.braintreepayments.api.dropin.view.PaymentMethodView;
import com.braintreepayments.api.models.PaymentMethod;
import java.util.List;

public class PaymentMethodListAdapter
  extends BaseAdapter
  implements DialogInterface.OnClickListener
{
  private Context mContext;
  private List<PaymentMethod> mPaymentMethods;
  private SelectPaymentMethodViewController mViewController;
  
  public PaymentMethodListAdapter(Context paramContext, SelectPaymentMethodViewController paramSelectPaymentMethodViewController, List<PaymentMethod> paramList)
  {
    mContext = paramContext;
    mViewController = paramSelectPaymentMethodViewController;
    mPaymentMethods = paramList;
  }
  
  public int getCount()
  {
    return mPaymentMethods.size();
  }
  
  public Object getItem(int paramInt)
  {
    return mPaymentMethods.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = new PaymentMethodView(mContext);
    paramView.setPaymentMethodDetails((PaymentMethod)mPaymentMethods.get(paramInt));
    return paramView;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    mViewController.onPaymentMethodSelected(paramInt);
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.dropin.PaymentMethodListAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */