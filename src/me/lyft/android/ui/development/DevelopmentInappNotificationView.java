package me.lyft.android.ui.development;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import com.lyft.android.api.dto.NotificationDTO;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Strings;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.Dialogs.InAppNotificationDialog;
import rx.subjects.BehaviorSubject;

public class DevelopmentInappNotificationView
  extends LinearLayout
{
  private Binder binder;
  EditText developmentInappNotificationEditText;
  Button developmentInappNotificationShowButton;
  @Inject
  DialogFlow dialogFlow;
  Toolbar toolbar;
  BehaviorSubject<Boolean> uiEnabled = BehaviorSubject.create();
  
  public DevelopmentInappNotificationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private void openInappNotification(NotificationDTO paramNotificationDTO)
  {
    dialogFlow.show(new Dialogs.InAppNotificationDialog(sourceUrl));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder = Binder.attach(this);
    binder.bind(uiEnabled, new DevelopmentInappNotificationView.1(this));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
    toolbar.setTitle(getContext().getString(2131166367));
  }
  
  public void showInAppNotificationOnClick(View paramView)
  {
    paramView = developmentInappNotificationEditText.getText().toString();
    NotificationDTO localNotificationDTO = new NotificationDTO(null, paramView, null, null);
    if (!Strings.isNullOrEmpty(paramView)) {
      openInappNotification(localNotificationDTO);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.development.DevelopmentInappNotificationView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */