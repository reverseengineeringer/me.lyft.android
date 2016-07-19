package me.lyft.android.ui.payment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.Strings;
import me.lyft.android.controls.Toolbar;

public class LyftCreditView
  extends LinearLayout
{
  @Inject
  AppFlow appFlow;
  TextView creditHeader;
  LinearLayout creditRestrictions;
  final PaymentScreens.LyftCreditScreen params;
  Toolbar toolbar;
  
  public LyftCreditView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    params = ((PaymentScreens.LyftCreditScreen)Screen.fromView(this));
  }
  
  private void addCreditRestrictions(List<String> paramList)
  {
    creditRestrictions.removeAllViews();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (!Strings.isNullOrEmpty(str)) {
          creditRestrictions.addView(new CreditListItemView(getContext()).setCreditListItemText(str));
        }
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    creditHeader.setText(params.getCreditHeader());
    addCreditRestrictions(params.getCreditRestrictions());
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
    toolbar.showTitle().setTitle(getContext().getString(2131165908));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.LyftCreditView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */