package io.card.payment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.method.DateKeyListener;
import android.text.method.DigitsKeyListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import io.card.payment.i18n.LocalizedStrings;
import io.card.payment.i18n.StringKey;
import io.card.payment.ui.ActivityHelper;
import io.card.payment.ui.Appearance;
import io.card.payment.ui.ViewUtil;

public final class DataEntryActivity
  extends Activity
  implements TextWatcher
{
  private final String TAG = getClass().getName();
  private TextView activityTitleTextView;
  private boolean autoAcceptDone;
  private Button cancelBtn;
  private CreditCard capture;
  private ImageView cardView;
  private EditText cvvEdit;
  private Validator cvvValidator;
  private int defaultTextColor;
  private Button doneBtn;
  private int editTextIdCounter = 100;
  private EditText expiryEdit;
  private Validator expiryValidator;
  private String labelLeftPadding;
  private EditText numberEdit;
  private Validator numberValidator;
  private EditText postalCodeEdit;
  private Validator postalCodeValidator;
  private boolean useApplicationTheme;
  private int viewIdCounter = 1;
  
  private EditText advanceToNextEmptyField()
  {
    int i = 100;
    for (;;)
    {
      EditText localEditText = (EditText)findViewById(i);
      if (localEditText != null)
      {
        if ((localEditText.getText().length() == 0) && (localEditText.requestFocus())) {
          return localEditText;
        }
      }
      else {
        return null;
      }
      i += 1;
    }
  }
  
  private void completed()
  {
    if (capture == null) {
      capture = new CreditCard();
    }
    if (expiryEdit != null)
    {
      capture.expiryMonth = expiryValidator).month;
      capture.expiryYear = expiryValidator).year;
    }
    CreditCard localCreditCard = new CreditCard(numberValidator.getValue(), capture.expiryMonth, capture.expiryYear, cvvValidator.getValue(), postalCodeValidator.getValue());
    Intent localIntent = new Intent();
    localIntent.putExtra("io.card.payment.scanResult", localCreditCard);
    setResult(CardIOActivity.RESULT_CARD_INFO, localIntent);
    finish();
  }
  
  private void setDefaultColor(EditText paramEditText)
  {
    if (useApplicationTheme)
    {
      paramEditText.setTextColor(defaultTextColor);
      return;
    }
    paramEditText.setTextColor(-12303292);
  }
  
  private void validateAndEnableDoneButtonIfValid()
  {
    Button localButton = doneBtn;
    if ((numberValidator.isValid()) && (expiryValidator.isValid()) && (cvvValidator.isValid()) && (postalCodeValidator.isValid())) {}
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      Log.d(TAG, "setting doneBtn.enabled=" + doneBtn.isEnabled());
      if ((autoAcceptDone) && (numberValidator.isValid()) && (expiryValidator.isValid()) && (cvvValidator.isValid()) && (postalCodeValidator.isValid())) {
        completed();
      }
      return;
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((numberEdit != null) && (paramEditable == numberEdit.getText())) {
      if (numberValidator.hasFullLength()) {
        if (!numberValidator.isValid())
        {
          numberEdit.setTextColor(Appearance.TEXT_COLOR_ERROR);
          if (cvvEdit != null)
          {
            paramEditable = CardType.fromCardNumber(numberValidator.getValue().toString());
            Object localObject = (FixedLengthValidator)cvvValidator;
            int i = paramEditable.cvvLength();
            requiredLength = i;
            localObject = cvvEdit;
            if (i != 4) {
              break label143;
            }
            paramEditable = "1234";
            label106:
            ((EditText)localObject).setHint(paramEditable);
          }
        }
      }
    }
    for (;;)
    {
      validateAndEnableDoneButtonIfValid();
      return;
      setDefaultColor(numberEdit);
      advanceToNextEmptyField();
      break;
      setDefaultColor(numberEdit);
      break;
      label143:
      paramEditable = "123";
      break label106;
      if ((expiryEdit != null) && (paramEditable == expiryEdit.getText()))
      {
        if (expiryValidator.hasFullLength())
        {
          if (!expiryValidator.isValid())
          {
            expiryEdit.setTextColor(Appearance.TEXT_COLOR_ERROR);
          }
          else
          {
            setDefaultColor(expiryEdit);
            advanceToNextEmptyField();
          }
        }
        else {
          setDefaultColor(expiryEdit);
        }
      }
      else if ((cvvEdit != null) && (paramEditable == cvvEdit.getText()))
      {
        if (cvvValidator.hasFullLength())
        {
          if (!cvvValidator.isValid())
          {
            cvvEdit.setTextColor(Appearance.TEXT_COLOR_ERROR);
          }
          else
          {
            setDefaultColor(cvvEdit);
            advanceToNextEmptyField();
          }
        }
        else {
          setDefaultColor(cvvEdit);
        }
      }
      else if ((postalCodeEdit != null) && (paramEditable == postalCodeEdit.getText())) {
        if (postalCodeValidator.hasFullLength())
        {
          if (!postalCodeValidator.isValid())
          {
            postalCodeEdit.setTextColor(Appearance.TEXT_COLOR_ERROR);
          }
          else
          {
            setDefaultColor(postalCodeEdit);
            advanceToNextEmptyField();
          }
        }
        else {
          setDefaultColor(postalCodeEdit);
        }
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Log.v(TAG, "onCreate");
    if (getIntent().getExtras() == null)
    {
      onBackPressed();
      return;
    }
    useApplicationTheme = getIntent().getBooleanExtra("io.card.payment.keepApplicationTheme", false);
    ActivityHelper.setActivityTheme(this, useApplicationTheme);
    defaultTextColor = new TextView(this).getTextColors().getDefaultColor();
    int j;
    RelativeLayout localRelativeLayout;
    int i;
    Object localObject2;
    LinearLayout localLinearLayout1;
    LinearLayout localLinearLayout2;
    LinearLayout.LayoutParams localLayoutParams1;
    label358:
    LinearLayout localLinearLayout3;
    LinearLayout.LayoutParams localLayoutParams2;
    boolean bool1;
    Object localObject1;
    if (ActivityHelper.holoSupported())
    {
      paramBundle = "12dip";
      labelLeftPadding = paramBundle;
      LocalizedStrings.setLanguage(getIntent());
      j = ViewUtil.typedDimensionValueToPixelsInt("4dip", this);
      localRelativeLayout = new RelativeLayout(this);
      if (!useApplicationTheme) {
        localRelativeLayout.setBackgroundColor(Appearance.DEFAULT_BACKGROUND_COLOR);
      }
      paramBundle = new ScrollView(this);
      i = viewIdCounter;
      viewIdCounter = (i + 1);
      paramBundle.setId(i);
      localObject2 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(10);
      localRelativeLayout.addView(paramBundle, (ViewGroup.LayoutParams)localObject2);
      localLinearLayout1 = new LinearLayout(this);
      localLinearLayout1.setOrientation(1);
      paramBundle.addView(localLinearLayout1, -1, -1);
      localLinearLayout2 = new LinearLayout(this);
      localLinearLayout2.setOrientation(1);
      localLayoutParams1 = new LinearLayout.LayoutParams(-1, -1);
      capture = ((CreditCard)getIntent().getParcelableExtra("io.card.payment.scanResult"));
      autoAcceptDone = getIntent().getBooleanExtra("debug_autoAcceptResult", false);
      if (capture == null) {
        break label1769;
      }
      numberValidator = new CardNumberValidator(capture.cardNumber);
      cardView = new ImageView(this);
      paramBundle = new LinearLayout.LayoutParams(-1, -2);
      cardView.setPadding(0, 0, 0, j);
      weight = 1.0F;
      cardView.setImageBitmap(CardIOActivity.markedCardImage);
      localLinearLayout2.addView(cardView, paramBundle);
      ViewUtil.setMargins(cardView, null, null, null, "8dip");
      localLinearLayout3 = new LinearLayout(this);
      localLayoutParams2 = new LinearLayout.LayoutParams(-1, -2);
      ViewUtil.setPadding(localLinearLayout3, null, "4dip", null, null);
      localLinearLayout3.setOrientation(0);
      bool1 = getIntent().getBooleanExtra("io.card.payment.requireExpiry", false);
      boolean bool2 = getIntent().getBooleanExtra("io.card.payment.requireCVV", false);
      boolean bool3 = getIntent().getBooleanExtra("io.card.payment.requirePostalCode", false);
      if (!bool1) {
        break label2109;
      }
      localObject1 = new LinearLayout(this);
      paramBundle = new LinearLayout.LayoutParams(0, -1, 1.0F);
      ((LinearLayout)localObject1).setOrientation(1);
      Object localObject3 = new TextView(this);
      if (!useApplicationTheme) {
        ((TextView)localObject3).setTextColor(Appearance.TEXT_COLOR_LABEL);
      }
      ((TextView)localObject3).setText(LocalizedStrings.getString(StringKey.ENTRY_EXPIRES));
      ViewUtil.setPadding((View)localObject3, labelLeftPadding, null, null, null);
      ((LinearLayout)localObject1).addView((View)localObject3, -2, -2);
      expiryEdit = new EditText(this);
      localObject3 = expiryEdit;
      i = editTextIdCounter;
      editTextIdCounter = (i + 1);
      ((EditText)localObject3).setId(i);
      expiryEdit.setMaxLines(1);
      expiryEdit.setImeOptions(6);
      expiryEdit.setTextAppearance(getApplicationContext(), 16842816);
      expiryEdit.setInputType(3);
      expiryEdit.setHint(LocalizedStrings.getString(StringKey.EXPIRES_PLACEHOLDER));
      if (capture == null) {
        break label2090;
      }
      expiryValidator = new ExpiryValidator(capture.expiryMonth, capture.expiryYear);
      label647:
      if (expiryValidator.hasFullLength()) {
        expiryEdit.setText(expiryValidator.getValue());
      }
      expiryEdit.addTextChangedListener(expiryValidator);
      expiryEdit.addTextChangedListener(this);
      expiryEdit.setFilters(new InputFilter[] { new DateKeyListener(), expiryValidator });
      ((LinearLayout)localObject1).addView(expiryEdit, -1, -2);
      localLinearLayout3.addView((View)localObject1, paramBundle);
      if ((!bool2) && (!bool3)) {
        break label2104;
      }
      paramBundle = "4dip";
      label756:
      ViewUtil.setMargins((View)localObject1, null, null, paramBundle, null);
      label765:
      if (!bool2) {
        break label2134;
      }
      localObject3 = new LinearLayout(this);
      paramBundle = new LinearLayout.LayoutParams(0, -1, 1.0F);
      ((LinearLayout)localObject3).setOrientation(1);
      localObject1 = new TextView(this);
      if (!useApplicationTheme) {
        ((TextView)localObject1).setTextColor(Appearance.TEXT_COLOR_LABEL);
      }
      ViewUtil.setPadding((View)localObject1, labelLeftPadding, null, null, null);
      ((TextView)localObject1).setText(LocalizedStrings.getString(StringKey.ENTRY_CVV));
      ((LinearLayout)localObject3).addView((View)localObject1, -2, -2);
      cvvEdit = new EditText(this);
      localObject1 = cvvEdit;
      i = editTextIdCounter;
      editTextIdCounter = (i + 1);
      ((EditText)localObject1).setId(i);
      cvvEdit.setMaxLines(1);
      cvvEdit.setImeOptions(6);
      cvvEdit.setTextAppearance(getApplicationContext(), 16842816);
      cvvEdit.setInputType(3);
      cvvEdit.setHint("123");
      i = 4;
      if (capture != null) {
        i = CardType.fromCardNumber(numberValidator.getValue()).cvvLength();
      }
      cvvValidator = new FixedLengthValidator(i);
      cvvEdit.setFilters(new InputFilter[] { new DigitsKeyListener(), cvvValidator });
      cvvEdit.addTextChangedListener(cvvValidator);
      cvvEdit.addTextChangedListener(this);
      ((LinearLayout)localObject3).addView(cvvEdit, -1, -2);
      localLinearLayout3.addView((View)localObject3, paramBundle);
      if (!bool1) {
        break label2123;
      }
      paramBundle = "4dip";
      label1053:
      if (!bool3) {
        break label2128;
      }
      localObject1 = "4dip";
      label1063:
      ViewUtil.setMargins((View)localObject3, paramBundle, null, (String)localObject1, null);
      label1073:
      if (!bool3) {
        break label2153;
      }
      localObject1 = new LinearLayout(this);
      paramBundle = new LinearLayout.LayoutParams(0, -1, 1.0F);
      ((LinearLayout)localObject1).setOrientation(1);
      localObject3 = new TextView(this);
      if (!useApplicationTheme) {
        ((TextView)localObject3).setTextColor(Appearance.TEXT_COLOR_LABEL);
      }
      ViewUtil.setPadding((View)localObject3, labelLeftPadding, null, null, null);
      ((TextView)localObject3).setText(LocalizedStrings.getString(StringKey.ENTRY_POSTAL_CODE));
      ((LinearLayout)localObject1).addView((View)localObject3, -2, -2);
      postalCodeEdit = new EditText(this);
      localObject3 = postalCodeEdit;
      i = editTextIdCounter;
      editTextIdCounter = (i + 1);
      ((EditText)localObject3).setId(i);
      postalCodeEdit.setMaxLines(1);
      postalCodeEdit.setImeOptions(6);
      postalCodeEdit.setTextAppearance(getApplicationContext(), 16842816);
      postalCodeEdit.setInputType(1);
      postalCodeValidator = new MaxLengthValidator(20);
      postalCodeEdit.addTextChangedListener(postalCodeValidator);
      postalCodeEdit.addTextChangedListener(this);
      ((LinearLayout)localObject1).addView(postalCodeEdit, -1, -2);
      localLinearLayout3.addView((View)localObject1, paramBundle);
      if ((!bool1) && (!bool2)) {
        break label2148;
      }
      paramBundle = "4dip";
      label1305:
      ViewUtil.setMargins((View)localObject1, paramBundle, null, null, null);
    }
    for (;;)
    {
      localLinearLayout2.addView(localLinearLayout3, localLayoutParams2);
      localLinearLayout1.addView(localLinearLayout2, localLayoutParams1);
      ViewUtil.setMargins(localLinearLayout2, "16dip", "20dip", "16dip", "20dip");
      paramBundle = new LinearLayout(this);
      i = viewIdCounter;
      viewIdCounter = (i + 1);
      paramBundle.setId(i);
      localObject1 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(12);
      paramBundle.setPadding(0, j, 0, 0);
      paramBundle.setBackgroundColor(0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(2, paramBundle.getId());
      doneBtn = new Button(this);
      localObject2 = new LinearLayout.LayoutParams(-1, -2, 1.0F);
      doneBtn.setText(LocalizedStrings.getString(StringKey.DONE));
      doneBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          DataEntryActivity.this.completed();
        }
      });
      doneBtn.setEnabled(false);
      paramBundle.addView(doneBtn, (ViewGroup.LayoutParams)localObject2);
      ViewUtil.styleAsButton(doneBtn, true, this);
      ViewUtil.setPadding(doneBtn, "5dip", null, "5dip", null);
      ViewUtil.setMargins(doneBtn, "8dip", "8dip", "4dip", "8dip");
      doneBtn.setTextSize(16.0F);
      cancelBtn = new Button(this);
      localObject2 = new LinearLayout.LayoutParams(-1, -2, 1.0F);
      cancelBtn.setText(LocalizedStrings.getString(StringKey.CANCEL));
      cancelBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          setResult(CardIOActivity.RESULT_ENTRY_CANCELED);
          finish();
        }
      });
      paramBundle.addView(cancelBtn, (ViewGroup.LayoutParams)localObject2);
      ViewUtil.styleAsButton(cancelBtn, false, this);
      ViewUtil.setPadding(cancelBtn, "5dip", null, "5dip", null);
      ViewUtil.setMargins(cancelBtn, "4dip", "8dip", "8dip", "8dip");
      cancelBtn.setTextSize(16.0F);
      localRelativeLayout.addView(paramBundle, (ViewGroup.LayoutParams)localObject1);
      ActivityHelper.addActionBarIfSupported(this);
      setContentView(localRelativeLayout);
      paramBundle = null;
      if (getIntent().getBooleanExtra("io.card.payment.intentSenderIsPayPal", true))
      {
        paramBundle = ViewUtil.base64ToBitmap("iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyRpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNiAoTWFjaW50b3NoKSIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDpCNDMzRTRFQ0M2MjQxMUUzOURBQ0E3QTY0NjU3OUI5QiIgeG1wTU06RG9jdW1lbnRJRD0ieG1wLmRpZDpCNDMzRTRFREM2MjQxMUUzOURBQ0E3QTY0NjU3OUI5QiI+IDx4bXBNTTpEZXJpdmVkRnJvbSBzdFJlZjppbnN0YW5jZUlEPSJ4bXAuaWlkOkI0MzNFNEVBQzYyNDExRTM5REFDQTdBNjQ2NTc5QjlCIiBzdFJlZjpkb2N1bWVudElEPSJ4bXAuZGlkOkI0MzNFNEVCQzYyNDExRTM5REFDQTdBNjQ2NTc5QjlCIi8+IDwvcmRmOkRlc2NyaXB0aW9uPiA8L3JkZjpSREY+IDwveDp4bXBtZXRhPiA8P3hwYWNrZXQgZW5kPSJyIj8+Eyd0MQAABoFJREFUeNrMWl1M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", this, 240);
        paramBundle = new BitmapDrawable(getResources(), paramBundle);
      }
      if ((bool1) && (expiryValidator.isValid())) {
        afterTextChanged(expiryEdit.getEditableText());
      }
      ActivityHelper.setupActionBarIfSupported(this, activityTitleTextView, LocalizedStrings.getString(StringKey.MANUAL_ENTRY_TITLE), "card.io - ", paramBundle);
      return;
      paramBundle = "2dip";
      break;
      label1769:
      activityTitleTextView = new TextView(this);
      activityTitleTextView.setTextSize(24.0F);
      if (!useApplicationTheme) {
        activityTitleTextView.setTextColor(Appearance.PAY_BLUE_COLOR);
      }
      localLinearLayout2.addView(activityTitleTextView);
      ViewUtil.setPadding(activityTitleTextView, null, null, null, "8dip");
      ViewUtil.setDimensions(activityTitleTextView, -2, -2);
      paramBundle = new LinearLayout(this);
      paramBundle.setOrientation(1);
      ViewUtil.setPadding(paramBundle, null, "4dip", null, "4dip");
      localObject1 = new TextView(this);
      ViewUtil.setPadding((View)localObject1, labelLeftPadding, null, null, null);
      ((TextView)localObject1).setText(LocalizedStrings.getString(StringKey.ENTRY_CARD_NUMBER));
      if (!useApplicationTheme) {
        ((TextView)localObject1).setTextColor(Appearance.TEXT_COLOR_LABEL);
      }
      paramBundle.addView((View)localObject1, -2, -2);
      numberEdit = new EditText(this);
      localObject1 = numberEdit;
      i = editTextIdCounter;
      editTextIdCounter = (i + 1);
      ((EditText)localObject1).setId(i);
      numberEdit.setMaxLines(1);
      numberEdit.setImeOptions(6);
      numberEdit.setTextAppearance(getApplicationContext(), 16842816);
      numberEdit.setInputType(3);
      numberEdit.setHint("1234 5678 1234 5678");
      numberValidator = new CardNumberValidator();
      numberEdit.addTextChangedListener(numberValidator);
      numberEdit.addTextChangedListener(this);
      numberEdit.setFilters(new InputFilter[] { new DigitsKeyListener(), numberValidator });
      paramBundle.addView(numberEdit, -1, -2);
      localLinearLayout2.addView(paramBundle, -1, -1);
      break label358;
      label2090:
      expiryValidator = new ExpiryValidator();
      break label647;
      label2104:
      paramBundle = null;
      break label756;
      label2109:
      expiryValidator = new AlwaysValid();
      break label765;
      label2123:
      paramBundle = null;
      break label1053;
      label2128:
      localObject1 = null;
      break label1063;
      label2134:
      cvvValidator = new AlwaysValid();
      break label1073;
      label2148:
      paramBundle = null;
      break label1305;
      label2153:
      postalCodeValidator = new AlwaysValid();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    Log.d(TAG, "onResume()");
    getWindow().setFlags(0, 1024);
    ActivityHelper.setFlagSecure(this);
    validateAndEnableDoneButtonIfValid();
    if ((numberEdit == null) && (expiryEdit != null) && (!expiryValidator.isValid())) {
      expiryEdit.requestFocus();
    }
    for (;;)
    {
      if ((numberEdit != null) || (expiryEdit != null) || (cvvEdit != null) || (postalCodeEdit != null)) {
        getWindow().setSoftInputMode(5);
      }
      Log.i(TAG, "ready for manual entry");
      return;
      advanceToNextEmptyField();
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}

/* Location:
 * Qualified Name:     io.card.payment.DataEntryActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */