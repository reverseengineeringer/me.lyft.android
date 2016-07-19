package me.lyft.android.controls;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.google.i18n.phonenumbers.AsYouTypeFormatter;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.lyft.rx.MessageBus;
import com.lyft.scoop.dagger.DaggerInjector;
import com.lyft.widgets.InternationalTextWatcher;
import com.lyft.widgets.ViewWithErrorState;
import javax.inject.Inject;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.PhoneUtils;
import me.lyft.android.common.Strings;
import me.lyft.android.development.IDeveloperTools;
import me.lyft.android.domain.system.Country;
import me.lyft.android.infrastructure.device.IDevice;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.landing.CountryPickerController.CountryPickedEvent;
import me.lyft.android.ui.landing.LandingScreens.CountryPickerScreen;
import rx.functions.Action1;

public class PhoneInputView
  extends FrameLayout
  implements ViewWithErrorState, NumericKeyboard.KeyPressListener
{
  private static final int[] STATE_ERROR = { 2130771999 };
  private static final int[] STATE_FOCUSED = { 16842908 };
  @Inject
  AppFlow appFlow;
  private AsYouTypeFormatter asYouTypeFormatter;
  private Binder binder;
  TextView callingCodeTextView;
  private String currentCountryCode;
  @Inject
  IDeveloperTools developerTools;
  @Inject
  IDevice device;
  @Inject
  DialogFlow dialogFlow;
  @Inject
  IFeaturesProvider featuresProvider;
  ImageView flagButton;
  View flagLayout;
  private InternationalTextWatcher internationalTextWatcher = new InternationalTextWatcher(null);
  @Inject
  MessageBus messageBus;
  private final Action1<Country> onCountryPicked = new Action1()
  {
    public void call(Country paramAnonymousCountry)
    {
      phoneEditText.setText("");
      PhoneInputView.access$002(PhoneInputView.this, paramAnonymousCountry.getCountryCode());
      PhoneInputView.this.updateFormatter();
      PhoneInputView.this.updateFlagIconForCountryCode();
      PhoneInputView.this.updateCallingCodeForCountryCode();
      PhoneInputView.this.updateHintForCountryCode();
    }
  };
  KeyboardlessEditText phoneEditText;
  private PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
  
  public PhoneInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode()) {
      return;
    }
    DaggerInjector.fromView(this).inject(this);
    LayoutInflater.from(getContext()).inflate(2130903378, this, true);
    ButterKnife.bind(this);
  }
  
  private void setTextAndMoveCursor(String paramString)
  {
    phoneEditText.setTextAndMoveCursor(paramString);
  }
  
  private void updateCallingCodeForCountryCode()
  {
    callingCodeTextView.setText("+" + phoneUtil.getCountryCodeForRegion(currentCountryCode));
  }
  
  private void updateFlagIconForCountryCode()
  {
    int i = getResources().getIdentifier("country_" + currentCountryCode.toLowerCase(), "drawable", getContext().getPackageName());
    if (i != 0)
    {
      flagButton.setImageResource(i);
      flagButton.setVisibility(0);
      return;
    }
    flagButton.setVisibility(4);
  }
  
  private void updateFormatter()
  {
    asYouTypeFormatter = phoneUtil.getAsYouTypeFormatter(currentCountryCode);
    internationalTextWatcher.updateAsYouTypeFormatter(asYouTypeFormatter);
  }
  
  private void updateHintForCountryCode()
  {
    if (phoneUtil.getExampleNumber(currentCountryCode) == null)
    {
      phoneEditText.setHint(2131165863);
      return;
    }
    phoneEditText.setHint(phoneUtil.format(phoneUtil.getExampleNumber(currentCountryCode), PhoneNumberUtil.PhoneNumberFormat.NATIONAL));
  }
  
  public String getCurrentCountryCode()
  {
    return currentCountryCode;
  }
  
  public String getPhoneNumber()
  {
    return PhoneUtils.formatPhoneNumberToE164(phoneEditText.getText().toString(), currentCountryCode);
  }
  
  public boolean hasValidationError()
  {
    if (isInEditMode()) {
      return false;
    }
    return phoneEditText.hasValidationError();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    if (currentCountryCode == null) {
      if (Strings.isNullOrEmpty(device.getLocaleCountryIso())) {
        break label197;
      }
    }
    label197:
    for (currentCountryCode = device.getLocaleCountryIso().toUpperCase();; currentCountryCode = PhoneUtils.DEFAULT_REGION)
    {
      asYouTypeFormatter = phoneUtil.getAsYouTypeFormatter(currentCountryCode);
      internationalTextWatcher = new InternationalTextWatcher(asYouTypeFormatter);
      binder = Binder.attach(this);
      binder.bind(messageBus.observe(CountryPickerController.CountryPickedEvent.class), onCountryPicked);
      flagLayout.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          appFlow.goTo(new LandingScreens.CountryPickerScreen());
        }
      });
      phoneEditText.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
      });
      if ((developerTools.isDeveloperMode()) && (phoneUtil.getCountryCodeForRegion(currentCountryCode) == 0)) {
        currentCountryCode = PhoneUtils.DEFAULT_REGION;
      }
      updateHintForCountryCode();
      updateCallingCodeForCountryCode();
      updateFlagIconForCountryCode();
      phoneEditText.addTextChangedListener(internationalTextWatcher);
      return;
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    Object localObject;
    if (isInEditMode()) {
      localObject = new int[0];
    }
    int[] arrayOfInt;
    do
    {
      return (int[])localObject;
      arrayOfInt = super.onCreateDrawableState(paramInt + 1);
      if (hasValidationError())
      {
        mergeDrawableStates(arrayOfInt, STATE_ERROR);
        return arrayOfInt;
      }
      localObject = arrayOfInt;
    } while (!phoneEditText.isFocused());
    mergeDrawableStates(arrayOfInt, STATE_FOCUSED);
    return arrayOfInt;
  }
  
  public void onDelLongPressed()
  {
    phoneEditText.onDelLongPressed();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    phoneEditText.removeTextChangedListener(internationalTextWatcher);
  }
  
  public void onKeyPressed(KeyEvent paramKeyEvent)
  {
    phoneEditText.onKeyPressed(paramKeyEvent);
  }
  
  public void requestEditTextFocus()
  {
    phoneEditText.requestFocus();
    refreshDrawableState();
  }
  
  public void selectCountry(String paramString)
  {
    currentCountryCode = paramString;
    updateFormatter();
    updateFlagIconForCountryCode();
    updateCallingCodeForCountryCode();
    updateHintForCountryCode();
  }
  
  public void setPhoneNumber(String paramString)
  {
    setTextAndMoveCursor(PhoneUtils.formatPhoneNumberToNational(paramString, currentCountryCode));
  }
  
  public void setValidationErrorId(Integer paramInteger)
  {
    phoneEditText.setValidationErrorId(paramInteger);
  }
  
  public void setValidationMessageView(TextView paramTextView)
  {
    phoneEditText.setValidationMessageView(paramTextView);
  }
  
  public void showValidationMessage()
  {
    phoneEditText.showValidationMessage();
    refreshDrawableState();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.PhoneInputView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */