package io.card.payment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.Window;

class CardIOActivity$2
  implements Runnable
{
  CardIOActivity$2(CardIOActivity paramCardIOActivity) {}
  
  public void run()
  {
    Log.d(CardIOActivity.access$100(), "CardIOActivity.nextActivity().post(Runnable)");
    this$0.getWindow().clearFlags(1024);
    this$0.getWindow().addFlags(512);
    Intent localIntent = new Intent(this$0, DataEntryActivity.class);
    if (CardIOActivity.access$200(this$0) != null)
    {
      CardIOActivity.access$200(this$0).markupCard();
      if ((CardIOActivity.markedCardImage != null) && (!CardIOActivity.markedCardImage.isRecycled())) {
        CardIOActivity.markedCardImage.recycle();
      }
      CardIOActivity.markedCardImage = CardIOActivity.access$200(this$0).getCardImage();
    }
    if (CardIOActivity.access$300(this$0) != null)
    {
      localIntent.putExtra("io.card.payment.scanResult", CardIOActivity.access$300(this$0));
      CardIOActivity.access$302(this$0, null);
    }
    for (;;)
    {
      localIntent.putExtras(this$0.getIntent());
      localIntent.addFlags(1082195968);
      this$0.startActivityForResult(localIntent, CardIOActivity.access$400());
      return;
      localIntent.putExtra("io.card.payment.manualEntryScanResult", true);
    }
  }
}

/* Location:
 * Qualified Name:     io.card.payment.CardIOActivity.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */