package me.lyft.android.ui.landing;

import android.text.Html;
import android.view.View;
import android.widget.TextView;
import javax.inject.Inject;
import me.lyft.android.analytics.core.UxAnalytics;
import me.lyft.android.analytics.definitions.Category;
import me.lyft.android.analytics.definitions.UiElement;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.common.RxViewController;

public class SignupPromoBannerController
  extends RxViewController
{
  private final IConstantsProvider constantsProvider;
  TextView defaultTextview;
  View signupPromoLayout;
  TextView signupPromoTextview;
  
  @Inject
  public SignupPromoBannerController(IConstantsProvider paramIConstantsProvider)
  {
    constantsProvider = paramIConstantsProvider;
  }
  
  protected int layoutId()
  {
    return 2130903454;
  }
  
  public void onAttach()
  {
    super.onAttach();
    String str = (String)constantsProvider.get(Constants.SIGNUP_PROMO_BANNER);
    if (str != null)
    {
      UxAnalytics.displayed(UiElement.NUO_BANNER).setTag(Category.REGISTRATION.toString()).setParameter(str).track();
      signupPromoTextview.setText(Html.fromHtml(str));
      defaultTextview.setVisibility(8);
      signupPromoLayout.setVisibility(0);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.landing.SignupPromoBannerController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */