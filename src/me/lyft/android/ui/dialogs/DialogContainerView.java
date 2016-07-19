package me.lyft.android.ui.dialogs;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.lyft.scoop.HandleBack;

@Deprecated
public class DialogContainerView
  extends FrameLayout
  implements HandleBack
{
  public DialogContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setClickable(true);
    setOnClickListener(new DialogContainerView.1(this));
  }
  
  public boolean onBack()
  {
    onCancel();
    return false;
  }
  
  protected void onCancel() {}
  
  protected void onClickOutside() {}
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.dialogs.DialogContainerView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */