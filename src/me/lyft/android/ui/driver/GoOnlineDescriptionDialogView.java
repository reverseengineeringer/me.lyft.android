package me.lyft.android.ui.driver;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.ui.dialogs.DialogContainerView;

public class GoOnlineDescriptionDialogView
  extends DialogContainerView
{
  @Inject
  DialogFlow dialogFlow;
  Button okButton;
  @Inject
  ILyftPreferences preferences;
  
  public GoOnlineDescriptionDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    okButton.setOnClickListener(new GoOnlineDescriptionDialogView.1(this));
  }
  
  public boolean onBack()
  {
    preferences.setGoOnlineDialogShown();
    return super.onBack();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.GoOnlineDescriptionDialogView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */