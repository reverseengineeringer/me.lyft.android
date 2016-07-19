package me.lyft.android.controls;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

public class FourDigitsInput
  extends FrameLayout
{
  KeyboardlessEditText codeEditText;
  TextView[] textViewArray = new TextView[4];
  final TextWatcher textWatcher = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable) {}
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      char[] arrayOfChar = paramAnonymousCharSequence.toString().toCharArray();
      paramAnonymousInt1 = 0;
      if (paramAnonymousInt1 < textViewArray.length)
      {
        TextView localTextView = textViewArray[paramAnonymousInt1];
        if (paramAnonymousInt1 < arrayOfChar.length) {}
        for (paramAnonymousCharSequence = String.valueOf(arrayOfChar[paramAnonymousInt1]);; paramAnonymousCharSequence = "")
        {
          localTextView.setText(paramAnonymousCharSequence);
          paramAnonymousInt1 += 1;
          break;
        }
      }
    }
  };
  
  public FourDigitsInput(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode()) {
      return;
    }
    LayoutInflater.from(getContext()).inflate(2130903235, this, true);
    codeEditText = ((KeyboardlessEditText)findViewById(2131559169));
    textViewArray[0] = ((TextView)findViewById(2131559171));
    textViewArray[1] = ((TextView)findViewById(2131559172));
    textViewArray[2] = ((TextView)findViewById(2131559173));
    textViewArray[3] = ((TextView)findViewById(2131559174));
  }
  
  public NumericKeyboard.KeyPressListener getKeyPressedListener()
  {
    return codeEditText;
  }
  
  public String getText()
  {
    return codeEditText.getText().toString();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    codeEditText.addTextChangedListener(textWatcher);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    codeEditText.removeTextChangedListener(textWatcher);
  }
  
  public void removeOnTextChangeListener(TextWatcher paramTextWatcher)
  {
    codeEditText.removeTextChangedListener(paramTextWatcher);
  }
  
  public boolean requestInputFocus()
  {
    return codeEditText.requestFocus();
  }
  
  public void setOnTextChangeListener(TextWatcher paramTextWatcher)
  {
    codeEditText.addTextChangedListener(paramTextWatcher);
  }
  
  public void setText(String paramString)
  {
    codeEditText.setText(paramString);
  }
  
  public void setTextAndMoveCursor(String paramString)
  {
    codeEditText.setTextAndMoveCursor(paramString);
  }
  
  public void setValidationMessageView(TextView paramTextView)
  {
    codeEditText.setValidationMessageView(paramTextView);
  }
  
  public void showInvalidCodeError()
  {
    codeEditText.setValidationErrorId(Integer.valueOf(2131165793));
    codeEditText.showValidationMessage();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.FourDigitsInput
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */