package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

class CardViewEclairMr1$1
  implements RoundRectDrawableWithShadow.RoundRectHelper
{
  CardViewEclairMr1$1(CardViewEclairMr1 paramCardViewEclairMr1) {}
  
  public void drawRoundRect(Canvas paramCanvas, RectF paramRectF, float paramFloat, Paint paramPaint)
  {
    float f1 = paramFloat * 2.0F;
    float f2 = paramRectF.width() - f1 - 1.0F;
    float f3 = paramRectF.height();
    if (paramFloat >= 1.0F)
    {
      float f4 = paramFloat + 0.5F;
      this$0.sCornerRect.set(-f4, -f4, f4, f4);
      int i = paramCanvas.save();
      paramCanvas.translate(left + f4, top + f4);
      paramCanvas.drawArc(this$0.sCornerRect, 180.0F, 90.0F, true, paramPaint);
      paramCanvas.translate(f2, 0.0F);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawArc(this$0.sCornerRect, 180.0F, 90.0F, true, paramPaint);
      paramCanvas.translate(f3 - f1 - 1.0F, 0.0F);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawArc(this$0.sCornerRect, 180.0F, 90.0F, true, paramPaint);
      paramCanvas.translate(f2, 0.0F);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawArc(this$0.sCornerRect, 180.0F, 90.0F, true, paramPaint);
      paramCanvas.restoreToCount(i);
      paramCanvas.drawRect(left + f4 - 1.0F, top, 1.0F + (right - f4), top + f4, paramPaint);
      paramCanvas.drawRect(left + f4 - 1.0F, 1.0F + (bottom - f4), 1.0F + (right - f4), bottom, paramPaint);
    }
    f1 = left;
    f2 = top;
    paramCanvas.drawRect(f1, Math.max(0.0F, paramFloat - 1.0F) + f2, right, 1.0F + (bottom - paramFloat), paramPaint);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.CardViewEclairMr1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */