package me.lyft.android.ui.dialogs;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.common.ActivityController;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.IAppStore;
import me.lyft.android.ui.Dialogs.UpdateAppDialog;

public class UpdateAppDialogView
  extends DialogContainerView
{
  @Inject
  ActivityController activityController;
  @Inject
  IAppStore appStore;
  @Inject
  DialogFlow dialogFlow;
  TextView messageTextView;
  Button okButton;
  private final Dialogs.UpdateAppDialog params;
  
  public UpdateAppDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    params = ((Dialogs.UpdateAppDialog)Screen.fromView(this));
  }
  
  private void goToPlayStore()
  {
    appStore.openInstallingStore();
    dialogFlow.dismiss();
  }
  
  public boolean onBack()
  {
    activityController.finish();
    return true;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
    messageTextView.setText(params.getMessage());
    okButton.setOnClickListener(new UpdateAppDialogView.1(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.dialogs.UpdateAppDialogView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */