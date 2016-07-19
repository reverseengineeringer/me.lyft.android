package com.leanplum.messagetemplates;

import android.view.View;
import android.view.View.OnClickListener;

final class i
  implements View.OnClickListener
{
  i(BaseMessageDialog paramBaseMessageDialog) {}
  
  public final void onClick(View paramView)
  {
    if (!BaseMessageDialog.b(a))
    {
      a.options.accept();
      a.cancel();
    }
  }
}

/* Location:
 * Qualified Name:     com.leanplum.messagetemplates.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */