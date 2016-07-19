package com.braintreepayments.cardform.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.text.style.ReplacementSpan;

public class SlashSpan
  extends ReplacementSpan
{
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCanvas.drawText(paramCharSequence.subSequence(paramInt1, paramInt2) + " / ", paramFloat, paramInt4, paramPaint);
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    return (int)(paramPaint.measureText(" ", 0, 1) * 2.0F + paramPaint.measureText("/", 0, 1) + paramPaint.measureText(paramCharSequence, paramInt1, paramInt2));
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.cardform.view.SlashSpan
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */