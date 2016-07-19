package me.lyft.android.ui.landing;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.CheckBox;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.application.landing.ILandingService;
import me.lyft.android.persistence.landing.ISignUpUserRepository;
import me.lyft.android.persistence.landing.SignupUser;
import me.lyft.android.utils.VersionUtils;

public class TermsOfServiceView
  extends CheckBox
{
  @Inject
  LandingFlow landingFlow;
  @Inject
  ILandingService landingService;
  @Inject
  ISignUpUserRepository signUpUserRepository;
  
  public TermsOfServiceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private Spannable createTermsOfServiceSpan(boolean paramBoolean)
  {
    String str1 = getResources().getString(2131165865);
    String str2 = getResources().getString(2131165864);
    SpannableString localSpannableString = new SpannableString(str2);
    localSpannableString.setSpan(new TermsOfServiceView.2(this, paramBoolean), str2.indexOf(str1), str2.indexOf(str1) + str1.length(), 33);
    return localSpannableString;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {}
    do
    {
      return;
      setChecked(signUpUserRepository.get().hasAgreedToS());
      setText(createTermsOfServiceSpan(false));
      setMovementMethod(LinkMovementMethod.getInstance());
      setOnCheckedChangeListener(new TermsOfServiceView.1(this));
    } while ((!VersionUtils.hasJellyBean()) || (VersionUtils.hasKitKat()));
    float f = getResourcesgetDisplayMetricsdensity;
    setPadding(getPaddingLeft() + (int)(24.0F * f), getPaddingTop(), getPaddingRight(), getPaddingBottom());
  }
  
  public void showTermsOfServiceError(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setButtonDrawable(2130838031);
      setTextColor(getResources().getColor(2131493054));
    }
    for (;;)
    {
      setText(createTermsOfServiceSpan(paramBoolean));
      return;
      setButtonDrawable(2130838030);
      setTextColor(getResources().getColor(2131492865));
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.landing.TermsOfServiceView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */