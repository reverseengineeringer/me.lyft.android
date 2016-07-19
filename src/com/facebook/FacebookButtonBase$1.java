package com.facebook;

import android.view.View;
import android.view.View.OnClickListener;

class FacebookButtonBase$1
  implements View.OnClickListener
{
  FacebookButtonBase$1(FacebookButtonBase paramFacebookButtonBase) {}
  
  public void onClick(View paramView)
  {
    FacebookButtonBase.access$000(this$0, this$0.getContext());
    if (FacebookButtonBase.access$100(this$0) != null) {
      FacebookButtonBase.access$100(this$0).onClick(paramView);
    }
    while (FacebookButtonBase.access$200(this$0) == null) {
      return;
    }
    FacebookButtonBase.access$200(this$0).onClick(paramView);
  }
}

/* Location:
 * Qualified Name:     com.facebook.FacebookButtonBase.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */