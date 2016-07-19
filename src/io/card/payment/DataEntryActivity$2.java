package io.card.payment;

import android.view.View;
import android.view.View.OnClickListener;

class DataEntryActivity$2
  implements View.OnClickListener
{
  DataEntryActivity$2(DataEntryActivity paramDataEntryActivity) {}
  
  public void onClick(View paramView)
  {
    this$0.setResult(CardIOActivity.RESULT_ENTRY_CANCELED);
    this$0.finish();
  }
}

/* Location:
 * Qualified Name:     io.card.payment.DataEntryActivity.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */