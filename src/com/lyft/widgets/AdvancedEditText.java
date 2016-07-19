package com.lyft.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.Editable;
import android.text.Html;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;

public class AdvancedEditText
  extends CrashLessEditText
  implements ViewWithErrorState
{
  private static final int DEFAULT_MAX_INPUT_LINES = 0;
  private static final int[] STATE_ERROR = { R.attr.state_error };
  private final Context context;
  private int maxInputLines;
  private int originalHintTextColor;
  private int originalValidationViewColor;
  private String originalValidationViewMessage;
  private MaxLinesTextWatcher textWatcher;
  private CharSequence validationErrorMessage;
  private TextView validationMessageView;
  
  public AdvancedEditText(Context paramContext)
  {
    super(paramContext);
    context = paramContext;
  }
  
  public AdvancedEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    context = paramContext;
    init(paramAttributeSet);
  }
  
  public AdvancedEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    context = paramContext;
  }
  
  private void init(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.EditText);
    if (paramAttributeSet != null)
    {
      int j = paramAttributeSet.getIndexCount();
      int i = 0;
      while (i < j)
      {
        if (paramAttributeSet.getIndex(i) == R.styleable.EditText_max_input_lines) {
          maxInputLines = paramAttributeSet.getInt(R.styleable.EditText_max_input_lines, 0);
        }
        i += 1;
      }
    }
    paramAttributeSet.recycle();
  }
  
  private void setValidationErrorMessage(CharSequence paramCharSequence)
  {
    validationErrorMessage = paramCharSequence;
    if (hasFocus()) {
      showValidationMessage();
    }
    refreshDrawableState();
  }
  
  public boolean hasValidationError()
  {
    return validationErrorMessage != null;
  }
  
  public boolean isCursorAtStart()
  {
    return (getSelectionStart() == 0) && (getSelectionEnd() == 0);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (maxInputLines > 0)
    {
      textWatcher = new MaxLinesTextWatcher();
      addTextChangedListener(textWatcher);
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (hasValidationError()) {
      mergeDrawableStates(arrayOfInt, STATE_ERROR);
    }
    return arrayOfInt;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    paramEditorInfo = super.onCreateInputConnection(paramEditorInfo);
    if (paramEditorInfo == null) {
      return null;
    }
    return new CustomInputConnectionWrapper(paramEditorInfo, true);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (textWatcher != null) {
      removeTextChangedListener(textWatcher);
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (paramBoolean) {
      showValidationMessage();
    }
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    resetValidationError();
  }
  
  public void requestFocusAndMoveCursor()
  {
    requestFocus();
    setSelection(getText().length());
  }
  
  public void resetValidationError()
  {
    validationErrorMessage = null;
    showValidationMessage();
    refreshDrawableState();
  }
  
  public void setTextAndMoveCursor(String paramString)
  {
    EditTextUtils.setTextAndMoveCursor(this, paramString);
  }
  
  public void setValidationErrorId(Integer paramInteger)
  {
    if (paramInteger == null)
    {
      setValidationErrorMessage("");
      return;
    }
    setValidationErrorMessage(context.getText(paramInteger.intValue()));
  }
  
  public void setValidationMessageView(TextView paramTextView)
  {
    validationMessageView = paramTextView;
    originalValidationViewMessage = paramTextView.getText().toString();
    originalValidationViewColor = paramTextView.getCurrentTextColor();
    originalHintTextColor = getCurrentHintTextColor();
  }
  
  public void showValidationMessage()
  {
    if (validationMessageView != null)
    {
      if (validationErrorMessage != null)
      {
        int i = getResources().getColor(R.color.red_1);
        setHintTextColor(i);
        validationMessageView.setText(Html.fromHtml(validationErrorMessage.toString()));
        validationMessageView.setTextColor(i);
      }
    }
    else {
      return;
    }
    setHintTextColor(originalHintTextColor);
    validationMessageView.setText(originalValidationViewMessage);
    validationMessageView.setTextColor(originalValidationViewColor);
  }
  
  private class CustomInputConnectionWrapper
    extends InputConnectionWrapper
  {
    public CustomInputConnectionWrapper(InputConnection paramInputConnection, boolean paramBoolean)
    {
      super(paramBoolean);
    }
    
    public boolean deleteSurroundingText(int paramInt1, int paramInt2)
    {
      boolean bool = super.deleteSurroundingText(paramInt1, paramInt2);
      if ((bool) && (isCursorAtStart())) {
        sendKeyEvent(new KeyEvent(0, 67));
      }
      return bool;
    }
  }
  
  public class MaxLinesTextWatcher
    extends SimpleTextWatcher
  {
    private int beforeCursorPosition = 0;
    private String text;
    
    public MaxLinesTextWatcher() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      removeTextChangedListener(this);
      if (getLineCount() > maxInputLines)
      {
        setText(text);
        setSelection(beforeCursorPosition);
      }
      addTextChangedListener(this);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      text = paramCharSequence.toString();
      beforeCursorPosition = paramInt1;
    }
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.AdvancedEditText
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */