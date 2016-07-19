package io.card.payment;

import android.content.Context;
import android.view.OrientationEventListener;

class CardIOActivity$1
  extends OrientationEventListener
{
  CardIOActivity$1(CardIOActivity paramCardIOActivity, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    CardIOActivity.access$000(this$0, paramInt);
  }
}

/* Location:
 * Qualified Name:     io.card.payment.CardIOActivity.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */