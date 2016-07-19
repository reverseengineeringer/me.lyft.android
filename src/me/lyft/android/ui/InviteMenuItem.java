package me.lyft.android.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioButton;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.common.Strings;

public class InviteMenuItem
  extends RadioButton
{
  @Inject
  IConstantsProvider constantsProvider;
  
  public InviteMenuItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private void adjustText()
  {
    String str = (String)constantsProvider.get(Constants.INVITE_MENU_TEXT);
    if (!Strings.isNullOrEmpty(str)) {
      setText(str);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    adjustText();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.InviteMenuItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */