package me.lyft.android.ui.driver.expresspay;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.driver.expresspay.IExpressPayService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.driver.Dial;
import me.lyft.android.rx.IRxBinder;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.driver.achievements.dials.DialView;
import me.lyft.android.utils.WebBrowser;

public class DriverEarningsExpressPayWidget
  extends LinearLayout
{
  @Inject
  AppFlow appFlow;
  private IRxBinder binder = new RxUIBinder();
  LinearLayout dialsLayoutView;
  TextView expressPayAmountView;
  TextView expressPayDisclaimer;
  @Inject
  IExpressPayErrorHandler expressPayErrorHandler;
  @Inject
  IExpressPayService expressPayService;
  TextView expressPayTitleView;
  Button getPaidButton;
  private String infoUrl;
  @Inject
  IProgressController progressController;
  TextView subtitleView;
  @Inject
  WebBrowser webBrowser;
  
  public DriverEarningsExpressPayWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    setOrientation(1);
    Scoop.fromView(this).inflater(paramContext).inflate(2130903169, this, true);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
    expressPayTitleView.setOnClickListener(new DriverEarningsExpressPayWidget.1(this));
    binder.attach();
    getPaidButton.setOnClickListener(new DriverEarningsExpressPayWidget.2(this));
  }
  
  public void setDials(List<Dial> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DialView localDialView = DialView.create((Dial)paramList.next(), getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1, 1.0F);
      gravity = 1;
      localDialView.setLayoutParams(localLayoutParams);
      dialsLayoutView.addView(localDialView);
    }
  }
  
  public void setExpressPayAmount(String paramString)
  {
    expressPayAmountView.setText(paramString);
  }
  
  public void setFooter(String paramString)
  {
    if (!Strings.isNullOrEmpty(paramString))
    {
      expressPayDisclaimer.setText(paramString);
      expressPayDisclaimer.setVisibility(0);
    }
  }
  
  public void setInfoUrl(String paramString)
  {
    infoUrl = paramString;
  }
  
  public void setSubtitle(String paramString)
  {
    if (!Strings.isNullOrEmpty(paramString))
    {
      subtitleView.setText(paramString);
      subtitleView.setVisibility(0);
    }
  }
  
  public void showGetPaid(boolean paramBoolean)
  {
    Button localButton = getPaidButton;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localButton.setVisibility(i);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.expresspay.DriverEarningsExpressPayWidget
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */