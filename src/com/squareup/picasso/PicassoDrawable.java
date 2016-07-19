package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.widget.ImageView;

final class PicassoDrawable
  extends BitmapDrawable
{
  private static final Paint DEBUG_PAINT = new Paint();
  private static final float FADE_DURATION = 200.0F;
  int alpha = 255;
  boolean animating;
  private final boolean debugging;
  private final float density;
  private final Picasso.LoadedFrom loadedFrom;
  Drawable placeholder;
  long startTimeMillis;
  
  PicassoDrawable(Context paramContext, Bitmap paramBitmap, Drawable paramDrawable, Picasso.LoadedFrom paramLoadedFrom, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext.getResources(), paramBitmap);
    debugging = paramBoolean2;
    density = getResourcesgetDisplayMetricsdensity;
    loadedFrom = paramLoadedFrom;
    if ((paramLoadedFrom != Picasso.LoadedFrom.MEMORY) && (!paramBoolean1)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        placeholder = paramDrawable;
        animating = true;
        startTimeMillis = SystemClock.uptimeMillis();
      }
      return;
    }
  }
  
  private void drawDebugIndicator(Canvas paramCanvas)
  {
    DEBUG_PAINT.setColor(-1);
    paramCanvas.drawPath(getTrianglePath(new Point(0, 0), (int)(16.0F * density)), DEBUG_PAINT);
    DEBUG_PAINT.setColor(loadedFrom.debugColor);
    paramCanvas.drawPath(getTrianglePath(new Point(0, 0), (int)(15.0F * density)), DEBUG_PAINT);
  }
  
  private static Path getTrianglePath(Point paramPoint, int paramInt)
  {
    Point localPoint1 = new Point(x + paramInt, y);
    Point localPoint2 = new Point(x, y + paramInt);
    Path localPath = new Path();
    localPath.moveTo(x, y);
    localPath.lineTo(x, y);
    localPath.lineTo(x, y);
    return localPath;
  }
  
  static void setBitmap(ImageView paramImageView, Context paramContext, Bitmap paramBitmap, Picasso.LoadedFrom paramLoadedFrom, boolean paramBoolean1, boolean paramBoolean2)
  {
    Drawable localDrawable = paramImageView.getDrawable();
    if ((localDrawable instanceof AnimationDrawable)) {
      ((AnimationDrawable)localDrawable).stop();
    }
    paramImageView.setImageDrawable(new PicassoDrawable(paramContext, paramBitmap, localDrawable, paramLoadedFrom, paramBoolean1, paramBoolean2));
  }
  
  static void setPlaceholder(ImageView paramImageView, Drawable paramDrawable)
  {
    paramImageView.setImageDrawable(paramDrawable);
    if ((paramImageView.getDrawable() instanceof AnimationDrawable)) {
      ((AnimationDrawable)paramImageView.getDrawable()).start();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (!animating) {
      super.draw(paramCanvas);
    }
    for (;;)
    {
      if (debugging) {
        drawDebugIndicator(paramCanvas);
      }
      return;
      float f = (float)(SystemClock.uptimeMillis() - startTimeMillis) / 200.0F;
      if (f >= 1.0F)
      {
        animating = false;
        placeholder = null;
        super.draw(paramCanvas);
      }
      else
      {
        if (placeholder != null) {
          placeholder.draw(paramCanvas);
        }
        super.setAlpha((int)(alpha * f));
        super.draw(paramCanvas);
        super.setAlpha(alpha);
        if (Build.VERSION.SDK_INT <= 10) {
          invalidateSelf();
        }
      }
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if (placeholder != null) {
      placeholder.setBounds(paramRect);
    }
    super.onBoundsChange(paramRect);
  }
  
  public void setAlpha(int paramInt)
  {
    alpha = paramInt;
    if (placeholder != null) {
      placeholder.setAlpha(paramInt);
    }
    super.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (placeholder != null) {
      placeholder.setColorFilter(paramColorFilter);
    }
    super.setColorFilter(paramColorFilter);
  }
}

/* Location:
 * Qualified Name:     com.squareup.picasso.PicassoDrawable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */