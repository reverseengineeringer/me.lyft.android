package me.lyft.android.ui.payment.cardinput;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Html;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.rx.MessageBus;
import com.lyft.scoop.dagger.DaggerInjector;
import com.lyft.widgets.AdvancedEditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import me.lyft.android.adapters.CountryAdapter;
import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.core.ExperimentAnalytics;
import me.lyft.android.analytics.core.definitions.Experiment;
import me.lyft.android.application.features.Features;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.payment.IPaymentService;
import me.lyft.android.application.system.ICountryRepository;
import me.lyft.android.common.IntegerExtensions;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.payment.Card;
import me.lyft.android.domain.payment.ICard;
import me.lyft.android.domain.system.Country;
import me.lyft.android.infrastructure.cardscan.ICardScanService;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.landing.CountryPickerController.CountryPickedEvent;
import me.lyft.android.utils.CardExtensions;
import me.lyft.android.utils.Keyboard;
import me.lyft.android.utils.MetricsUtils;
import rx.Observable;
import rx.functions.Action1;
import rx.subjects.PublishSubject;

public class CreditCardInput
  extends LinearLayout
{
  private static final String INSTANCE_STATE = "instanceState";
  private static final String SELECTED_LOCALE = "selectedLocale";
  private ActionAnalytics actionAnalytics;
  private Binder binder;
  AdvancedEditText cardNumberEditText;
  @Inject
  ICardScanService cardScanService;
  ImageView cardTypeImage;
  @Inject
  ICountryRepository countryRepository;
  Spinner countrySpinner;
  TextView creditCardErrorTextView;
  private EditText currentEditText;
  AdvancedEditText cvcEditText;
  AdvancedEditText expiresEditText;
  @Inject
  IFeaturesProvider featuresProvider;
  ImageView flagButton;
  @Inject
  MessageBus messageBus;
  private final Action1<Country> onCountryPicked = new CreditCardInput.1(this);
  private Action1<ICard> onCreditCardScanned = new CreditCardInput.2(this);
  PublishSubject<Unit> onDonePressedSubject = PublishSubject.create();
  private ArrayList<CreditCardInput.OnInputChangedListener> onInputChangedListeners = new ArrayList();
  @Inject
  IPaymentService paymentService;
  private Resources resources;
  View scanCardButton;
  private String selectedCountryCode;
  private String selectedLocale;
  private boolean useLocaleForZipCountry;
  private ZipCodeTextWatcher zipCodeTextWatcher;
  AdvancedEditText zipEditText;
  
  public CreditCardInput(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
    init(paramContext);
  }
  
  private void actionAnalyticsComplete()
  {
    if (actionAnalytics != null)
    {
      actionAnalytics.trackSuccess();
      actionAnalytics = null;
    }
  }
  
  private void applyZipCodeFormat()
  {
    ZipCodeFormat localZipCodeFormat = ZipCodeFormatRegistry.getZipCodeFormat(selectedLocale);
    InputFilter.LengthFilter localLengthFilter = new InputFilter.LengthFilter(localZipCodeFormat.getMaxLength());
    zipEditText.setFilters(new InputFilter[] { localLengthFilter });
    int i = 4096;
    if (localZipCodeFormat.isDigitsOnly()) {
      i = 2;
    }
    resetZipCodeTextWatcher();
    zipEditText.setInputType(i);
  }
  
  private void checkCardNumber()
  {
    if (getCard().validateNumber())
    {
      setFocus(expiresEditText);
      return;
    }
    playCardNumberErrorAnimation();
  }
  
  private void checkCvc()
  {
    if (getCard().validateCVC()) {
      setFocus(zipEditText);
    }
  }
  
  private void checkExpiry()
  {
    if (getCard().validateExpiryDate()) {
      setFocus(cvcEditText);
    }
  }
  
  private String getDefaultCountryCode()
  {
    Locale localLocale = Locale.getDefault();
    if ((localLocale == Locale.CANADA) || (localLocale == Locale.CANADA_FRENCH)) {
      return Locale.CANADA.getCountry();
    }
    if (useLocaleForZipCountry) {
      return localLocale.getCountry();
    }
    return Locale.US.getCountry();
  }
  
  private EditText getFocusedEditText()
  {
    return (EditText)Objects.firstNonNull(currentEditText, cardNumberEditText);
  }
  
  private String getSafeDefaultLocale()
  {
    Locale localLocale = Locale.getDefault();
    if ((localLocale == Locale.CANADA) || (localLocale == Locale.CANADA_FRENCH)) {
      return Locale.CANADA.toString();
    }
    if (useLocaleForZipCountry) {
      return localLocale.toString();
    }
    return Locale.US.toString();
  }
  
  private void highlightCreditCard(ICard paramICard)
  {
    if (!paramICard.validateZip()) {
      highlightEditTextAndSetFocus(zipEditText);
    }
    if (!paramICard.validateCVC()) {
      highlightEditTextAndSetFocus(cvcEditText);
    }
    if (!paramICard.validateExpiryDate()) {
      highlightEditTextAndSetFocus(expiresEditText);
    }
    if (!paramICard.validateNumber()) {
      highlightEditTextAndSetFocus(cardNumberEditText);
    }
  }
  
  private void highlightEditText(AdvancedEditText paramAdvancedEditText)
  {
    paramAdvancedEditText.setTextColor(getResources().getColor(2131493054));
    paramAdvancedEditText.setHintTextColor(getResources().getColor(2131493054));
    paramAdvancedEditText.setValidationErrorId(Integer.valueOf(2131558886));
    paramAdvancedEditText.showValidationMessage();
  }
  
  private void highlightEditTextAndSetFocus(AdvancedEditText paramAdvancedEditText)
  {
    highlightEditText(paramAdvancedEditText);
    setFocus(paramAdvancedEditText);
  }
  
  private void init(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903138, this, true);
    resources = getResources();
    if (!isInEditMode())
    {
      DaggerInjector.fromView(this).inject(this);
      ButterKnife.bind(this, paramContext);
      zipEditText.setOnKeyListener(new CreditCardInput.5(this));
      cvcEditText.setOnKeyListener(new CreditCardInput.6(this));
      expiresEditText.setOnKeyListener(new CreditCardInput.7(this));
      cardNumberEditText.addTextChangedListener(new CreditCardInput.8(this));
      cardNumberEditText.setOnEditorActionListener(new CreditCardInput.9(this));
      cardNumberEditText.setOnFocusChangeListener(new CreditCardInput.10(this, this));
      expiresEditText.addTextChangedListener(new CreditCardInput.11(this));
      expiresEditText.setOnFocusChangeListener(new CreditCardInput.12(this, this));
      expiresEditText.setOnEditorActionListener(new CreditCardInput.13(this));
      cvcEditText.addTextChangedListener(new CreditCardInput.14(this));
      cvcEditText.setOnFocusChangeListener(new CreditCardInput.15(this, this));
      zipEditText.setOnFocusChangeListener(new CreditCardInput.16(this, this));
      zipEditText.setOnEditorActionListener(new CreditCardInput.17(this));
      scanCardButton.setOnClickListener(new CreditCardInput.18(this));
    }
  }
  
  private void initCountryPicker()
  {
    Object localObject = countryRepository.getSupportedCountries();
    localObject = new CountryAdapter(getContext(), (List)localObject, true);
    countrySpinner.setAdapter((SpinnerAdapter)localObject);
    countrySpinner.setSelection(countryRepository.getPositionForCountry(selectedCountryCode), false);
    countrySpinner.setOnItemSelectedListener(new CreditCardInput.20(this));
  }
  
  private void invokeInputChanged()
  {
    if (onInputChangedListeners.size() > 0)
    {
      Iterator localIterator = onInputChangedListeners.iterator();
      while (localIterator.hasNext()) {
        ((CreditCardInput.OnInputChangedListener)localIterator.next()).onInputChanged();
      }
    }
  }
  
  private void playCardNumberErrorAnimation()
  {
    highlightEditTextAndSetFocus(cardNumberEditText);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(cardNumberEditText, "translationX", new float[] { MetricsUtils.fromView(this).dpToPixels(-20.0F) });
    localObjectAnimator1.setInterpolator(new AccelerateInterpolator());
    localObjectAnimator1.setDuration(150L);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(cardNumberEditText, "translationX", new float[] { 0.0F });
    localObjectAnimator2.setInterpolator(new BounceInterpolator());
    localObjectAnimator2.setDuration(500L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playSequentially(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
    localAnimatorSet.start();
  }
  
  private void resetEditTexts(int paramInt1, int paramInt2)
  {
    AdvancedEditText[] arrayOfAdvancedEditText = new AdvancedEditText[4];
    arrayOfAdvancedEditText[0] = cardNumberEditText;
    arrayOfAdvancedEditText[1] = expiresEditText;
    arrayOfAdvancedEditText[2] = cvcEditText;
    arrayOfAdvancedEditText[3] = zipEditText;
    int i = resources.getColor(paramInt1);
    paramInt2 = resources.getColor(paramInt2);
    int j = arrayOfAdvancedEditText.length;
    paramInt1 = 0;
    while (paramInt1 < j)
    {
      AdvancedEditText localAdvancedEditText = arrayOfAdvancedEditText[paramInt1];
      localAdvancedEditText.setTextColor(i);
      localAdvancedEditText.setHintTextColor(paramInt2);
      localAdvancedEditText.resetValidationError();
      paramInt1 += 1;
    }
  }
  
  private void resetZipCodeTextWatcher()
  {
    zipEditText.removeTextChangedListener(zipCodeTextWatcher);
    zipCodeTextWatcher = new CreditCardInput.19(this, selectedLocale);
    zipEditText.addTextChangedListener(zipCodeTextWatcher);
  }
  
  private void setFocus(AdvancedEditText paramAdvancedEditText)
  {
    currentEditText = paramAdvancedEditText;
    paramAdvancedEditText.requestFocusAndMoveCursor();
  }
  
  private boolean shouldGoBack(View paramView, int paramInt)
  {
    return (((AdvancedEditText)paramView).isCursorAtStart()) && (paramInt == 67);
  }
  
  private void updateCardTypeImage()
  {
    ICard localICard = getCard();
    cardTypeImage.setImageResource(CardExtensions.getCardTypeImageResourceWithOutline(localICard.getType()));
  }
  
  public void addOnInputChangedListener(CreditCardInput.OnInputChangedListener paramOnInputChangedListener)
  {
    onInputChangedListeners.add(paramOnInputChangedListener);
  }
  
  public void clearCardEditTexts()
  {
    AdvancedEditText[] arrayOfAdvancedEditText = new AdvancedEditText[4];
    arrayOfAdvancedEditText[0] = cardNumberEditText;
    arrayOfAdvancedEditText[1] = expiresEditText;
    arrayOfAdvancedEditText[2] = cvcEditText;
    arrayOfAdvancedEditText[3] = zipEditText;
    int j = arrayOfAdvancedEditText.length;
    int i = 0;
    while (i < j)
    {
      arrayOfAdvancedEditText[i].setText("");
      i += 1;
    }
  }
  
  public ICard getCard()
  {
    String str1 = cardNumberEditText.getText().toString();
    String str2 = cvcEditText.getText().toString();
    Object localObject4 = expiresEditText.getText().toString();
    String str3 = zipEditText.getText().toString();
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = localObject3;
    if (!Strings.isNullOrEmpty((String)localObject4))
    {
      String[] arrayOfString = ((String)localObject4).split("/");
      localObject4 = IntegerExtensions.tryParse(arrayOfString[0]);
      localObject1 = localObject4;
      localObject2 = localObject3;
      if (arrayOfString.length > 1)
      {
        localObject2 = IntegerExtensions.tryParse(arrayOfString[1]);
        localObject1 = localObject4;
      }
    }
    return Card.create(str1, (Integer)localObject1, (Integer)localObject2, str2, str3, selectedLocale);
  }
  
  public void highlightCreditCardFields()
  {
    highlightEditText(zipEditText);
    highlightEditText(expiresEditText);
    highlightEditText(cvcEditText);
    highlightEditTextAndSetFocus(cardNumberEditText);
  }
  
  public void highlightErrorFields()
  {
    ICard localICard = getCard();
    if (localICard.isEmpty())
    {
      highlightCreditCardFields();
      return;
    }
    highlightCreditCard(localICard);
  }
  
  public void highlightErrorFields(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        highlightCreditCardFields();
        return;
        if (paramString.equals("incorrect_expiration_date"))
        {
          i = 0;
          continue;
          if (paramString.equals("incorrect_number"))
          {
            i = 1;
            continue;
            if (paramString.equals("incorrect_cvc"))
            {
              i = 2;
              continue;
              if (paramString.equals("incorrect_zip")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    highlightEditTextAndSetFocus(expiresEditText);
    return;
    highlightEditTextAndSetFocus(cardNumberEditText);
    return;
    highlightEditText(cardNumberEditText);
    highlightEditTextAndSetFocus(cvcEditText);
    return;
    highlightEditText(cardNumberEditText);
    highlightEditTextAndSetFocus(zipEditText);
  }
  
  public Observable<Unit> observeOnDonePressed()
  {
    return onDonePressedSubject.asObservable();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    cardScanService.start();
    binder = Binder.attach(this);
    binder.bind(cardScanService.observeScannedCard(), onCreditCardScanned);
    binder.bind(paymentService.observeCreateOrUpdateCreditCard(), new CreditCardInput.3(this));
    binder.bind(messageBus.observe(CountryPickerController.CountryPickedEvent.class), onCountryPicked);
    ExperimentAnalytics.trackExposure(Experiment.PAYMENT_USE_LOCALE_FOR_ZIP_COUNTRY);
    useLocaleForZipCountry = featuresProvider.isEnabled(Features.USE_LOCALE_FOR_ZIP_COUNTRY);
    selectedLocale = getSafeDefaultLocale();
    selectedCountryCode = getDefaultCountryCode();
    updateZipCodeEditTextForCountry(selectedCountryCode);
    addOnInputChangedListener(new CreditCardInput.4(this));
    flagButton.setVisibility(8);
    countrySpinner.setVisibility(0);
    initCountryPicker();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    cardScanService.stop();
  }
  
  protected void onDonePressed()
  {
    onDonePressedSubject.onNext(Unit.create());
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    Parcelable localParcelable = paramParcelable;
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      selectedLocale = paramParcelable.getString("selectedLocale");
      localParcelable = paramParcelable.getParcelable("instanceState");
    }
    super.onRestoreInstanceState(localParcelable);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("instanceState", super.onSaveInstanceState());
    localBundle.putString("selectedLocale", selectedLocale);
    return localBundle;
  }
  
  public void resetHighlight()
  {
    resetEditTexts(2131493107, 2131493065);
  }
  
  public void setExistingCard(String paramString1, String paramString2, boolean paramBoolean)
  {
    cardNumberEditText.setHint(Html.fromHtml(getResources().getString(2131166039, new Object[] { paramString1 })));
    if (paramBoolean) {
      highlightEditTextAndSetFocus(cardNumberEditText);
    }
    paramString1 = getCard().getType();
    cardTypeImage.setImageResource(CardExtensions.getCardTypeImageResourceWithOutline((String)Objects.firstNonNull(paramString1, paramString2)));
  }
  
  public void showCreditCardInlineError(String paramString)
  {
    creditCardErrorTextView.setText(paramString);
    creditCardErrorTextView.setVisibility(0);
  }
  
  public void showSoftwareKeyboard()
  {
    Keyboard.showKeyboard(getFocusedEditText());
  }
  
  public void updateZipCodeEditTextForCountry(String paramString)
  {
    zipEditText.setText("");
    zipEditText.setVisibility(0);
    applyZipCodeFormat();
    int i = getResources().getIdentifier("country_" + paramString.toLowerCase(), "drawable", getContext().getPackageName());
    if ("US".equals(paramString))
    {
      zipEditText.setHint(2131166041);
      selectedLocale = Locale.US.toString();
      selectedCountryCode = paramString;
    }
    for (;;)
    {
      if (i != 0) {
        flagButton.setImageResource(i);
      }
      applyZipCodeFormat();
      return;
      if ("CA".equals(paramString))
      {
        zipEditText.setHint(2131166040);
        selectedLocale = Locale.CANADA.toString();
        selectedCountryCode = paramString;
      }
      else if ("GB".equals(paramString))
      {
        zipEditText.setHint(2131166040);
        selectedLocale = Locale.UK.toString();
        selectedCountryCode = paramString;
      }
      else if ("ZZ".equals(paramString))
      {
        zipEditText.setHint(2131166041);
        selectedLocale = "en_US";
        selectedCountryCode = "US";
      }
      else
      {
        zipEditText.setVisibility(8);
        cvcEditText.setImeOptions(6);
        selectedLocale = "zz_ZZ";
        selectedCountryCode = paramString;
      }
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.cardinput.CreditCardInput
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */