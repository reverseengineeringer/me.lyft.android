package me.lyft.android.ui.payment;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.settings.ISignUrlService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.domain.User;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.utils.WebBrowser;

public class ConcurView
  extends LinearLayout
{
  @Inject
  AppFlow appFlow;
  private Binder binder;
  @Inject
  ILyftPreferences lyftPreferences;
  @Inject
  IProgressController progressController;
  TextView sendToConcur;
  @Inject
  ISignUrlService signUrlService;
  @Inject
  IUserProvider userProvider;
  @Inject
  IViewErrorHandler viewErrorHandler;
  @Inject
  WebBrowser webBrowser;
  
  public ConcurView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    setOrientation(1);
    Scoop.fromView(this).inflater(paramContext).inflate(2130903126, this, true);
    ButterKnife.bind(this);
  }
  
  private boolean isConcurLinked()
  {
    return userProvider.getUser().isConcurLinked();
  }
  
  private void linkConcur()
  {
    String str = lyftPreferences.getLyftWebRoot() + "/concur/login";
    progressController.showProgress();
    binder.bind(signUrlService.getSignedUrl(str), new ConcurView.2(this));
  }
  
  private boolean sendConcurRideReceipts()
  {
    return userProvider.getUser().sendConcurRideReceipts();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    binder = Binder.attach(this);
    TextView localTextView;
    Resources localResources;
    if (isConcurLinked())
    {
      localTextView = sendToConcur;
      localResources = getResources();
      if (!sendConcurRideReceipts()) {
        break label69;
      }
    }
    label69:
    for (int i = 2131165940;; i = 2131165938)
    {
      localTextView.setText(localResources.getString(i));
      setOnClickListener(new ConcurView.1(this));
      return;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.ConcurView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */