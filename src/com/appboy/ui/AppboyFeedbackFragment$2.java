package com.appboy.ui;

import android.view.View;
import android.view.View.OnClickListener;

class AppboyFeedbackFragment$2
  implements View.OnClickListener
{
  AppboyFeedbackFragment$2(AppboyFeedbackFragment paramAppboyFeedbackFragment) {}
  
  public void onClick(View paramView)
  {
    AppboyFeedbackFragment.access$200(this$0);
    if (AppboyFeedbackFragment.access$300(this$0) != null) {
      AppboyFeedbackFragment.access$300(this$0).onFeedbackFinished(AppboyFeedbackFragment.FeedbackResult.CANCELLED);
    }
    AppboyFeedbackFragment.access$400(this$0);
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.AppboyFeedbackFragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */