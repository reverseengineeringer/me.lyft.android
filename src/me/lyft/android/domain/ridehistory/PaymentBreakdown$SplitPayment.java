package me.lyft.android.domain.ridehistory;

import java.util.List;

public class PaymentBreakdown$SplitPayment
{
  private List<String> contributorPhotoUrls;
  private PaymentBreakdown.ReceiptItem splitPayment;
  private PaymentBreakdown.ReceiptItem subtotalReceiptItem;
  
  public PaymentBreakdown$SplitPayment(PaymentBreakdown.ReceiptItem paramReceiptItem1, PaymentBreakdown.ReceiptItem paramReceiptItem2, List<String> paramList)
  {
    splitPayment = paramReceiptItem1;
    subtotalReceiptItem = paramReceiptItem2;
    contributorPhotoUrls = paramList;
  }
  
  public List<String> getContributorPhotoUrls()
  {
    return contributorPhotoUrls;
  }
  
  public PaymentBreakdown.ReceiptItem getSplitPaymentReceiptItem()
  {
    return splitPayment;
  }
  
  public PaymentBreakdown.ReceiptItem getSubtotalReceiptItem()
  {
    return subtotalReceiptItem;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.ridehistory.PaymentBreakdown.SplitPayment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */