package me.lyft.android.ui.payment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import com.lyft.widgets.Toggle;
import javax.inject.Inject;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.ride.IExpenseNoteSession;
import me.lyft.android.common.AppFlow;
import me.lyft.android.domain.User;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IProgressController;

public class ConcurRideView
  extends LinearLayout
{
  @Inject
  AppFlow appFlow;
  @Inject
  IExpenseNoteSession expenseNoteSession;
  @Inject
  IProgressController progressController;
  Toggle sendToConcurToggle;
  @Inject
  IUserProvider userProvider;
  
  public ConcurRideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    setOrientation(1);
    Scoop.fromView(this).inflater(paramContext).inflate(2130903124, this, true);
    ButterKnife.bind(this);
  }
  
  private boolean isConcurLinked()
  {
    return userProvider.getUser().isConcurLinked();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    Binder localBinder = Binder.attach(this);
    if (isConcurLinked())
    {
      sendToConcurToggle.setChecked(expenseNoteSession.isConcurEnabled(), false);
      localBinder.bind(sendToConcurToggle.observeChange(), new ConcurRideView.1(this));
      return;
    }
    setVisibility(8);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.ConcurRideView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */