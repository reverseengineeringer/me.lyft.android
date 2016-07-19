package me.lyft.android.analytics.studies;

import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.core.SpanningAnalytics;
import me.lyft.android.analytics.core.events.ActionEvent.Action;
import me.lyft.android.analytics.definitions.Category;

public final class PaymentAnalytics
{
  public static final String ANDROID_PAY = "android_pay";
  public static final String ANDROID_PAY_FROM_DIALOG = "android_pay_from_dialog";
  public static final String COUPON = "coupon";
  public static final String CREDIT_CARD = "credit_card";
  public static final String CREDIT_CARD_EXPIRATION_DATE = "expiration_date";
  public static final String CREDIT_CARD_NUMBER = "number";
  public static final String CREDIT_CARD_SECURITY_CODE = "security_code";
  public static final String CREDIT_CARD_ZIP_CODE = "zip_code";
  public static final String DEBIT_CARD = "debit_card";
  public static final String DIALOG_PAYMENT = "dialog_payment";
  public static final String FACEBOOK = "facebook";
  public static final String PAYPAL = "paypal";
  public static final String PAYPAL_FROM_DIALOG = "paypal_from_dialog";
  
  public static ActionAnalytics trackAddPaymentMethod(String paramString)
  {
    return (ActionAnalytics)new ActionAnalytics(ActionEvent.Action.ADD_PAYMENT_METHOD).setTag(Category.PAYMENT.toString()).setParameter(paramString).trackInitiation();
  }
  
  public static ActionAnalytics trackEditCard(String paramString)
  {
    return (ActionAnalytics)new ActionAnalytics(ActionEvent.Action.EDIT_PAYMENT_METHOD).setTag(Category.PAYMENT.toString()).setParameter(paramString).trackInitiation();
  }
  
  public static void trackEditFacebookCard()
  {
    new ActionAnalytics(ActionEvent.Action.EDIT_PAYMENT_METHOD).setTag(Category.PAYMENT.toString()).setParameter("facebook").trackInitiation();
  }
  
  public static ActionAnalytics trackInputCreditCardField(String paramString)
  {
    return (ActionAnalytics)new ActionAnalytics(ActionEvent.Action.INPUT_CREDIT_CARD_FIELD).setTag(Category.PAYMENT.toString()).setParameter(paramString).trackInitiation();
  }
  
  public static void trackOpenAddCardItem(String paramString)
  {
    new ActionAnalytics(ActionEvent.Action.OPEN_ADD_PAYMENT_ITEM).setTag(Category.PAYMENT.toString()).setParameter(paramString).trackInitiation().trackSuccess();
  }
  
  public static void trackOpenEditCardItem(String paramString)
  {
    new ActionAnalytics(ActionEvent.Action.OPEN_EDIT_PAYMENT_ITEM).setTag(Category.PAYMENT.toString()).setParameter(paramString).trackInitiation().trackSuccess();
  }
  
  public static ActionAnalytics trackOpenFacebookMessenger()
  {
    return (ActionAnalytics)new ActionAnalytics(ActionEvent.Action.OPEN_FACEBOOK_MESSENGER).setTag(Category.PAYMENT.toString()).trackInitiation();
  }
  
  public static ActionAnalytics trackRemovePaymentMethod(String paramString)
  {
    return (ActionAnalytics)new ActionAnalytics(ActionEvent.Action.REMOVE_PAYMENT_METHOD).setTag(Category.PAYMENT.toString()).setParameter(paramString).trackInitiation();
  }
  
  public static ActionAnalytics trackScanCard()
  {
    return (ActionAnalytics)new ActionAnalytics(ActionEvent.Action.SCAN_CARD).setTag(Category.PAYMENT.toString()).trackInitiation();
  }
  
  public static ActionAnalytics trackSelectPayment(String paramString)
  {
    return (ActionAnalytics)new ActionAnalytics(ActionEvent.Action.SELECT_PAYMENT_METHOD).setTag(Category.PAYMENT.toString()).setParameter(paramString).trackInitiation();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.studies.PaymentAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */