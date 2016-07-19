package com.makeramen.roundedimageview;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.widget.ImageView.ScaleType;

public class RoundedDrawable
  extends Drawable
{
  private final Bitmap mBitmap;
  private final int mBitmapHeight;
  private final Paint mBitmapPaint;
  private final RectF mBitmapRect = new RectF();
  private BitmapShader mBitmapShader;
  private final int mBitmapWidth;
  private ColorStateList mBorderColor = ColorStateList.valueOf(-16777216);
  private final Paint mBorderPaint;
  private final RectF mBorderRect = new RectF();
  private float mBorderWidth = 0.0F;
  private final RectF mBounds = new RectF();
  private float mCornerRadius = 0.0F;
  private final RectF mDrawableRect = new RectF();
  private boolean mOval = false;
  private boolean mRebuildShader = true;
  private ImageView.ScaleType mScaleType = ImageView.ScaleType.FIT_CENTER;
  private final Matrix mShaderMatrix = new Matrix();
  private Shader.TileMode mTileModeX = Shader.TileMode.CLAMP;
  private Shader.TileMode mTileModeY = Shader.TileMode.CLAMP;
  
  public RoundedDrawable(Bitmap paramBitmap)
  {
    mBitmap = paramBitmap;
    mBitmapWidth = paramBitmap.getWidth();
    mBitmapHeight = paramBitmap.getHeight();
    mBitmapRect.set(0.0F, 0.0F, mBitmapWidth, mBitmapHeight);
    mBitmapPaint = new Paint();
    mBitmapPaint.setStyle(Paint.Style.FILL);
    mBitmapPaint.setAntiAlias(true);
    mBorderPaint = new Paint();
    mBorderPaint.setStyle(Paint.Style.STROKE);
    mBorderPaint.setAntiAlias(true);
    mBorderPaint.setColor(mBorderColor.getColorForState(getState(), -16777216));
    mBorderPaint.setStrokeWidth(mBorderWidth);
  }
  
  public static Bitmap drawableToBitmap(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    int i = Math.max(paramDrawable.getIntrinsicWidth(), 2);
    int j = Math.max(paramDrawable.getIntrinsicHeight(), 2);
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localBitmap;
    }
    catch (Exception paramDrawable)
    {
      paramDrawable.printStackTrace();
      Log.w("RoundedDrawable", "Failed to create bitmap from drawable!");
    }
    return null;
  }
  
  public static RoundedDrawable fromBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      return new RoundedDrawable(paramBitmap);
    }
    return null;
  }
  
  public static Drawable fromDrawable(Drawable paramDrawable)
  {
    if ((paramDrawable == null) || ((paramDrawable instanceof RoundedDrawable))) {}
    Object localObject;
    do
    {
      return paramDrawable;
      if ((paramDrawable instanceof LayerDrawable))
      {
        paramDrawable = (LayerDrawable)paramDrawable;
        int j = paramDrawable.getNumberOfLayers();
        int i = 0;
        while (i < j)
        {
          localObject = paramDrawable.getDrawable(i);
          paramDrawable.setDrawableByLayerId(paramDrawable.getId(i), fromDrawable((Drawable)localObject));
          i += 1;
        }
        return paramDrawable;
      }
      localObject = drawableToBitmap(paramDrawable);
    } while (localObject == null);
    return new RoundedDrawable((Bitmap)localObject);
  }
  
  private void updateShaderMatrix()
  {
    switch (mScaleType)
    {
    case ???: 
    default: 
      mBorderRect.set(mBitmapRect);
      mShaderMatrix.setRectToRect(mBitmapRect, mBounds, Matrix.ScaleToFit.CENTER);
      mShaderMatrix.mapRect(mBorderRect);
      mBorderRect.inset(mBorderWidth / 2.0F, mBorderWidth / 2.0F);
      mShaderMatrix.setRectToRect(mBitmapRect, mBorderRect, Matrix.ScaleToFit.FILL);
    }
    for (;;)
    {
      mDrawableRect.set(mBorderRect);
      return;
      mBorderRect.set(mBounds);
      mBorderRect.inset(mBorderWidth / 2.0F, mBorderWidth / 2.0F);
      mShaderMatrix.reset();
      mShaderMatrix.setTranslate((int)((mBorderRect.width() - mBitmapWidth) * 0.5F + 0.5F), (int)((mBorderRect.height() - mBitmapHeight) * 0.5F + 0.5F));
      continue;
      mBorderRect.set(mBounds);
      mBorderRect.inset(mBorderWidth / 2.0F, mBorderWidth / 2.0F);
      mShaderMatrix.reset();
      float f1 = 0.0F;
      float f2 = 0.0F;
      float f3;
      if (mBitmapWidth * mBorderRect.height() > mBorderRect.width() * mBitmapHeight)
      {
        f3 = mBorderRect.height() / mBitmapHeight;
        f1 = (mBorderRect.width() - mBitmapWidth * f3) * 0.5F;
      }
      for (;;)
      {
        mShaderMatrix.setScale(f3, f3);
        mShaderMatrix.postTranslate((int)(f1 + 0.5F) + mBorderWidth, (int)(f2 + 0.5F) + mBorderWidth);
        break;
        f3 = mBorderRect.width() / mBitmapWidth;
        f2 = (mBorderRect.height() - mBitmapHeight * f3) * 0.5F;
      }
      mShaderMatrix.reset();
      if ((mBitmapWidth <= mBounds.width()) && (mBitmapHeight <= mBounds.height())) {}
      for (f1 = 1.0F;; f1 = Math.min(mBounds.width() / mBitmapWidth, mBounds.height() / mBitmapHeight))
      {
        f2 = (int)((mBounds.width() - mBitmapWidth * f1) * 0.5F + 0.5F);
        f3 = (int)((mBounds.height() - mBitmapHeight * f1) * 0.5F + 0.5F);
        mShaderMatrix.setScale(f1, f1);
        mShaderMatrix.postTranslate(f2, f3);
        mBorderRect.set(mBitmapRect);
        mShaderMatrix.mapRect(mBorderRect);
        mBorderRect.inset(mBorderWidth / 2.0F, mBorderWidth / 2.0F);
        mShaderMatrix.setRectToRect(mBitmapRect, mBorderRect, Matrix.ScaleToFit.FILL);
        break;
      }
      mBorderRect.set(mBitmapRect);
      mShaderMatrix.setRectToRect(mBitmapRect, mBounds, Matrix.ScaleToFit.END);
      mShaderMatrix.mapRect(mBorderRect);
      mBorderRect.inset(mBorderWidth / 2.0F, mBorderWidth / 2.0F);
      mShaderMatrix.setRectToRect(mBitmapRect, mBorderRect, Matrix.ScaleToFit.FILL);
      continue;
      mBorderRect.set(mBitmapRect);
      mShaderMatrix.setRectToRect(mBitmapRect, mBounds, Matrix.ScaleToFit.START);
      mShaderMatrix.mapRect(mBorderRect);
      mBorderRect.inset(mBorderWidth / 2.0F, mBorderWidth / 2.0F);
      mShaderMatrix.setRectToRect(mBitmapRect, mBorderRect, Matrix.ScaleToFit.FILL);
      continue;
      mBorderRect.set(mBounds);
      mBorderRect.inset(mBorderWidth / 2.0F, mBorderWidth / 2.0F);
      mShaderMatrix.reset();
      mShaderMatrix.setRectToRect(mBitmapRect, mBorderRect, Matrix.ScaleToFit.FILL);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (mRebuildShader)
    {
      mBitmapShader = new BitmapShader(mBitmap, mTileModeX, mTileModeY);
      if ((mTileModeX == Shader.TileMode.CLAMP) && (mTileModeY == Shader.TileMode.CLAMP)) {
        mBitmapShader.setLocalMatrix(mShaderMatrix);
      }
      mBitmapPaint.setShader(mBitmapShader);
      mRebuildShader = false;
    }
    if (mOval)
    {
      if (mBorderWidth > 0.0F)
      {
        paramCanvas.drawOval(mDrawableRect, mBitmapPaint);
        paramCanvas.drawOval(mBorderRect, mBorderPaint);
        return;
      }
      paramCanvas.drawOval(mDrawableRect, mBitmapPaint);
      return;
    }
    if (mBorderWidth > 0.0F)
    {
      paramCanvas.drawRoundRect(mDrawableRect, Math.max(mCornerRadius, 0.0F), Math.max(mCornerRadius, 0.0F), mBitmapPaint);
      paramCanvas.drawRoundRect(mBorderRect, mCornerRadius, mCornerRadius, mBorderPaint);
      return;
    }
    paramCanvas.drawRoundRect(mDrawableRect, mCornerRadius, mCornerRadius, mBitmapPaint);
  }
  
  public int getAlpha()
  {
    return mBitmapPaint.getAlpha();
  }
  
  public ColorFilter getColorFilter()
  {
    return mBitmapPaint.getColorFilter();
  }
  
  public int getIntrinsicHeight()
  {
    return mBitmapHeight;
  }
  
  public int getIntrinsicWidth()
  {
    return mBitmapWidth;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isStateful()
  {
    return mBorderColor.isStateful();
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    mBounds.set(paramRect);
    updateShaderMatrix();
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    int i = mBorderColor.getColorForState(paramArrayOfInt, 0);
    if (mBorderPaint.getColor() != i)
    {
      mBorderPaint.setColor(i);
      return true;
    }
    return super.onStateChange(paramArrayOfInt);
  }
  
  public void setAlpha(int paramInt)
  {
    mBitmapPaint.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public RoundedDrawable setBorderColor(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null) {}
    for (;;)
    {
      mBorderColor = paramColorStateList;
      mBorderPaint.setColor(mBorderColor.getColorForState(getState(), -16777216));
      return this;
      paramColorStateList = ColorStateList.valueOf(0);
    }
  }
  
  public RoundedDrawable setBorderWidth(float paramFloat)
  {
    mBorderWidth = paramFloat;
    mBorderPaint.setStrokeWidth(mBorderWidth);
    return this;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    mBitmapPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public RoundedDrawable setCornerRadius(float paramFloat)
  {
    mCornerRadius = paramFloat;
    return this;
  }
  
  public void setDither(boolean paramBoolean)
  {
    mBitmapPaint.setDither(paramBoolean);
    invalidateSelf();
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    mBitmapPaint.setFilterBitmap(paramBoolean);
    invalidateSelf();
  }
  
  public RoundedDrawable setOval(boolean paramBoolean)
  {
    mOval = paramBoolean;
    return this;
  }
  
  public RoundedDrawable setScaleType(ImageView.ScaleType paramScaleType)
  {
    ImageView.ScaleType localScaleType = paramScaleType;
    if (paramScaleType == null) {
      localScaleType = ImageView.ScaleType.FIT_CENTER;
    }
    if (mScaleType != localScaleType)
    {
      mScaleType = localScaleType;
      updateShaderMatrix();
    }
    return this;
  }
  
  public RoundedDrawable setTileModeX(Shader.TileMode paramTileMode)
  {
    if (mTileModeX != paramTileMode)
    {
      mTileModeX = paramTileMode;
      mRebuildShader = true;
      invalidateSelf();
    }
    return this;
  }
  
  public RoundedDrawable setTileModeY(Shader.TileMode paramTileMode)
  {
    if (mTileModeY != paramTileMode)
    {
      mTileModeY = paramTileMode;
      mRebuildShader = true;
      invalidateSelf();
    }
    return this;
  }
}

/* Location:
 * Qualified Name:     com.makeramen.roundedimageview.RoundedDrawable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */