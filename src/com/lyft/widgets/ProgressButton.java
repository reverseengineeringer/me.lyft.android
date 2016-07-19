package com.lyft.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressButton
  extends FrameLayout
  implements IProgressView
{
  private int buttonTextColorId;
  private String nextButtonString;
  ProgressBar progressBar;
  TextView progressText;
  
  public ProgressButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    extractAttributes(paramContext, paramAttributeSet);
    if (isInEditMode()) {}
    do
    {
      return;
      LayoutInflater.from(getContext()).inflate(R.layout.progress_button, this, true);
      progressText = ((TextView)findViewById(R.id.progress_button));
      progressBar = ((ProgressBar)findViewById(R.id.button_progressbar));
      progressText.setText(nextButtonString);
    } while (buttonTextColorId == -1);
    progressText.setTextColor(getResources().getColorStateList(buttonTextColorId));
  }
  
  private void extractAttributes(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.Android);
    try
    {
      nextButtonString = paramContext.getString(R.styleable.Android_android_text);
      buttonTextColorId = paramContext.getResourceId(R.styleable.Android_android_textColor, -1);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  public void hideProgress()
  {
    progressBar.setVisibility(8);
    progressText.setVisibility(0);
    setEnabled(true);
  }
  
  public void showProgress()
  {
    progressText.setVisibility(8);
    progressBar.setVisibility(0);
    setEnabled(false);
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.ProgressButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */