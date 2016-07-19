package com.appboy.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import com.appboy.Appboy;

class AppboyFeedbackFragment$3
  implements View.OnClickListener
{
  AppboyFeedbackFragment$3(AppboyFeedbackFragment paramAppboyFeedbackFragment) {}
  
  public void onClick(View paramView)
  {
    if (AppboyFeedbackFragment.access$100(this$0))
    {
      AppboyFeedbackFragment.access$200(this$0);
      boolean bool = AppboyFeedbackFragment.access$500(this$0).isChecked();
      Object localObject = AppboyFeedbackFragment.access$600(this$0).getText().toString();
      String str = AppboyFeedbackFragment.access$700(this$0).getText().toString();
      paramView = (View)localObject;
      if (AppboyFeedbackFragment.access$300(this$0) != null) {
        paramView = AppboyFeedbackFragment.access$300(this$0).beforeFeedbackSubmitted((String)localObject);
      }
      bool = Appboy.getInstance(this$0.getActivity()).submitFeedback(str, paramView, bool);
      if (AppboyFeedbackFragment.access$300(this$0) != null)
      {
        localObject = AppboyFeedbackFragment.access$300(this$0);
        if (!bool) {
          break label142;
        }
      }
      label142:
      for (paramView = AppboyFeedbackFragment.FeedbackResult.SENT;; paramView = AppboyFeedbackFragment.FeedbackResult.ERROR)
      {
        ((AppboyFeedbackFragment.FeedbackFinishedListener)localObject).onFeedbackFinished(paramView);
        AppboyFeedbackFragment.access$400(this$0);
        return;
      }
    }
    AppboyFeedbackFragment.access$002(this$0, true);
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.AppboyFeedbackFragment.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */