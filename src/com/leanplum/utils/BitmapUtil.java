package com.leanplum.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build.VERSION;
import android.view.View;

public class BitmapUtil
{
  private static Drawable getBackground(int paramInt1, int paramInt2)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    int i = SizeUtil.dp10;
    RoundRectShape localRoundRectShape = new RoundRectShape(new float[] { i, i, i, i, i, i, i, i }, null, null);
    ShapeDrawable localShapeDrawable = new ShapeDrawable();
    localShapeDrawable.setShape(localRoundRectShape);
    localShapeDrawable.getPaint().setColor(paramInt2);
    localStateListDrawable.addState(new int[] { 16842919, 16842908 }, localShapeDrawable);
    localStateListDrawable.addState(new int[] { -16842919, 16842908 }, localShapeDrawable);
    localStateListDrawable.addState(new int[] { 16842919, -16842908 }, localShapeDrawable);
    localShapeDrawable = new ShapeDrawable();
    localShapeDrawable.setShape(localRoundRectShape);
    localShapeDrawable.getPaint().setColor(paramInt1);
    localStateListDrawable.addState(new int[] { -16842919, -16842908 }, localShapeDrawable);
    return localStateListDrawable;
  }
  
  public static int getDarker(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 0)
    {
      i = paramInt2;
      if (paramInt2 <= 100) {}
    }
    else
    {
      i = 0;
    }
    double d = (100 - i) / 100.0D;
    paramInt2 = (int)((paramInt1 >> 16 & 0xFF) * d);
    int i = (int)((paramInt1 >> 8 & 0xFF) * d);
    return (int)(d * (paramInt1 & 0xFF)) & 0xFF | paramInt1 >>> 24 << 24 | (paramInt2 & 0xFF) << 16 | (i & 0xFF) << 8;
  }
  
  public static Bitmap getRoundedCornerBitmap(Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap == null) {
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    RectF localRectF = new RectF(localRect);
    float f = paramInt;
    localPaint.setAntiAlias(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localPaint.setColor(-16777216);
    localCanvas.drawRoundRect(localRectF, f, f, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
    return localBitmap;
  }
  
  public static void stateBackground(View paramView, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.setBackground(getBackground(paramInt1, paramInt2));
      return;
    }
    paramView.setBackgroundColor(paramInt1);
  }
  
  public static void stateBackgroundDarkerByPercentage(View paramView, int paramInt1, int paramInt2)
  {
    stateBackground(paramView, paramInt1, getDarker(paramInt1, paramInt2));
  }
}

/* Location:
 * Qualified Name:     com.leanplum.utils.BitmapUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */