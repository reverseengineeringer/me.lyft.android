package com.appboy.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.appboy.models.cards.BannerImageCard;
import com.appboy.support.AppboyLogger;
import com.appboy.ui.actions.IAction;

class BannerImageCardView$1
  implements View.OnClickListener
{
  BannerImageCardView$1(BannerImageCardView paramBannerImageCardView, BannerImageCard paramBannerImageCard) {}
  
  public void onClick(View paramView)
  {
    if (BannerImageCardView.access$000(this$0) != null)
    {
      AppboyLogger.d(BannerImageCardView.access$100(), String.format("Logged click for card %s", new Object[] { val$card.getId() }));
      val$card.logClick();
      BannerImageCardView.access$000(this$0).execute(this$0.mContext);
    }
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.widget.BannerImageCardView.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */