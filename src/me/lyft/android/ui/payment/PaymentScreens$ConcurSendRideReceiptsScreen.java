package me.lyft.android.ui.payment;

import com.lyft.scoop.Layout;

@Layout(2130903125)
public class PaymentScreens$ConcurSendRideReceiptsScreen
  extends PaymentScreens.PaymentBaseScreen
{
  private final boolean sendConcurRideReceipts;
  
  public PaymentScreens$ConcurSendRideReceiptsScreen()
  {
    this(false);
  }
  
  public PaymentScreens$ConcurSendRideReceiptsScreen(boolean paramBoolean)
  {
    sendConcurRideReceipts = paramBoolean;
  }
  
  public boolean sendConcurRideReceipts()
  {
    return sendConcurRideReceipts;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.PaymentScreens.ConcurSendRideReceiptsScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */