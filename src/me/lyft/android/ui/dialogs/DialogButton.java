package me.lyft.android.ui.dialogs;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.common.DialogFlow;

public class DialogButton
  extends Button
{
  @Inject
  DialogFlow dialogFlow;
  
  public DialogButton(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public DialogButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public DialogButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    if (isInEditMode()) {
      return;
    }
    DaggerInjector.fromView(this).inject(this);
  }
  
  public boolean performClick()
  {
    dialogFlow.dismiss();
    return super.performClick();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.dialogs.DialogButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */