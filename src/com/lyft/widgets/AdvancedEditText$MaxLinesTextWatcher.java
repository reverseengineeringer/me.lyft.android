package com.lyft.widgets;

import android.text.Editable;

public class AdvancedEditText$MaxLinesTextWatcher
  extends SimpleTextWatcher
{
  private int beforeCursorPosition = 0;
  private String text;
  
  public AdvancedEditText$MaxLinesTextWatcher(AdvancedEditText paramAdvancedEditText) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    this$0.removeTextChangedListener(this);
    if (this$0.getLineCount() > AdvancedEditText.access$000(this$0))
    {
      this$0.setText(text);
      this$0.setSelection(beforeCursorPosition);
    }
    this$0.addTextChangedListener(this);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    text = paramCharSequence.toString();
    beforeCursorPosition = paramInt1;
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.AdvancedEditText.MaxLinesTextWatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */