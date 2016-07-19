package me.lyft.android.domain.ridehistory;

import java.util.ArrayList;
import java.util.List;
import me.lyft.android.domain.ridehistory.charge.AccountInfoItem;

public class PaymentBreakdown
{
  private List<AccountInfoItem> charges;
  private List<AccountInfoItem> coupons;
  private List<ReceiptItem> receiptItems = new ArrayList(3);
  private SplitPayment splitPayment;
  private String title;
  private ReceiptItem totalReceiptItem;
  
  public PaymentBreakdown(String paramString, List<ReceiptItem> paramList, ReceiptItem paramReceiptItem, SplitPayment paramSplitPayment, List<AccountInfoItem> paramList1, List<AccountInfoItem> paramList2)
  {
    title = paramString;
    receiptItems = paramList;
    totalReceiptItem = paramReceiptItem;
    splitPayment = paramSplitPayment;
    coupons = paramList1;
    charges = paramList2;
  }
  
  public List<AccountInfoItem> getCharges()
  {
    return charges;
  }
  
  public List<AccountInfoItem> getCoupons()
  {
    return coupons;
  }
  
  public List<ReceiptItem> getReceiptItems()
  {
    return receiptItems;
  }
  
  public SplitPayment getSplitPayment()
  {
    return splitPayment;
  }
  
  public String getTitle()
  {
    return title;
  }
  
  public ReceiptItem getTotalReceiptItem()
  {
    return totalReceiptItem;
  }
  
  public static class ReceiptItem
  {
    private String title;
    private String value;
    
    public ReceiptItem(String paramString1, String paramString2)
    {
      title = paramString1;
      value = paramString2;
    }
    
    public String getTitle()
    {
      return title;
    }
    
    public String getValue()
    {
      return value;
    }
  }
  
  public static class SplitPayment
  {
    private List<String> contributorPhotoUrls;
    private PaymentBreakdown.ReceiptItem splitPayment;
    private PaymentBreakdown.ReceiptItem subtotalReceiptItem;
    
    public SplitPayment(PaymentBreakdown.ReceiptItem paramReceiptItem1, PaymentBreakdown.ReceiptItem paramReceiptItem2, List<String> paramList)
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
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.ridehistory.PaymentBreakdown
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */