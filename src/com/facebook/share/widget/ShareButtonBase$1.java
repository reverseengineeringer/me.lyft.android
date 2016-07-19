package com.facebook.share.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.internal.FacebookDialogBase;

class ShareButtonBase$1
  implements View.OnClickListener
{
  ShareButtonBase$1(ShareButtonBase paramShareButtonBase) {}
  
  public void onClick(View paramView)
  {
    ShareButtonBase.access$000(this$0, paramView);
    this$0.getDialog().show(this$0.getShareContent());
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.widget.ShareButtonBase.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */