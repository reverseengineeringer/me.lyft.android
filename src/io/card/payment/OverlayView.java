package io.card.payment;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import io.card.payment.i18n.LocalizedStrings;
import io.card.payment.i18n.StringKey;
import java.lang.ref.WeakReference;

class OverlayView
  extends View
{
  private static final GradientDrawable.Orientation[] GRADIENT_ORIENTATIONS = { GradientDrawable.Orientation.TOP_BOTTOM, GradientDrawable.Orientation.LEFT_RIGHT, GradientDrawable.Orientation.BOTTOM_TOP, GradientDrawable.Orientation.RIGHT_LEFT };
  private static final String TAG = OverlayView.class.getSimpleName();
  private int guideColor;
  private boolean hideCardIOLogo = false;
  private Bitmap mBitmap;
  private Rect mCameraPreviewRect;
  private DetectionInfo mDInfo;
  private CreditCard mDetectedCard;
  private GradientDrawable mGradientDrawable;
  private Rect mGuide;
  private final Paint mGuidePaint;
  private final Paint mLockedBackgroundPaint;
  private Path mLockedBackgroundPath;
  private final Logo mLogo;
  private Rect mLogoRect;
  private int mRotation;
  private int mRotationFlip;
  private float mScale = 1.0F;
  private final WeakReference<CardIOActivity> mScanActivityRef;
  private final boolean mShowTorch;
  private int mState;
  private final Torch mTorch;
  private Rect mTorchRect;
  private String scanInstructions;
  
  public OverlayView(CardIOActivity paramCardIOActivity, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    super(paramCardIOActivity, paramAttributeSet);
    mShowTorch = paramBoolean;
    mScanActivityRef = new WeakReference(paramCardIOActivity);
    mRotationFlip = 1;
    mScale = (getResourcesgetDisplayMetricsdensity / 1.5F);
    mTorch = new Torch(70.0F * mScale, 50.0F * mScale);
    mLogo = new Logo(paramCardIOActivity);
    mGuidePaint = new Paint(1);
    mLockedBackgroundPaint = new Paint(1);
    mLockedBackgroundPaint.clearShadowLayer();
    mLockedBackgroundPaint.setStyle(Paint.Style.FILL);
    mLockedBackgroundPaint.setColor(-1157627904);
    scanInstructions = LocalizedStrings.getString(StringKey.SCAN_GUIDE);
  }
  
  private void decorateBitmap()
  {
    Object localObject = new RectF(2.0F, 2.0F, mBitmap.getWidth() - 2, mBitmap.getHeight() - 2);
    float f = mBitmap.getHeight() * 0.06666667F;
    Bitmap localBitmap = Bitmap.createBitmap(mBitmap.getWidth(), mBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawColor(0);
    Paint localPaint = new Paint(1);
    localPaint.setColor(-16777216);
    localPaint.setStyle(Paint.Style.FILL);
    localCanvas.drawRoundRect((RectF)localObject, f, f, localPaint);
    localObject = new Paint();
    ((Paint)localObject).setFilterBitmap(false);
    localCanvas = new Canvas(mBitmap);
    ((Paint)localObject).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    localCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, (Paint)localObject);
    ((Paint)localObject).setXfermode(null);
    localBitmap.recycle();
  }
  
  private Rect guideStrokeRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = (int)(8.0F * mScale);
    Rect localRect = new Rect();
    left = (Math.min(paramInt1, paramInt3) - i);
    right = (Math.max(paramInt1, paramInt3) + i);
    top = (Math.min(paramInt2, paramInt4) - i);
    bottom = (Math.max(paramInt2, paramInt4) + i);
    return localRect;
  }
  
  public Bitmap getBitmap()
  {
    return mBitmap;
  }
  
  public Bitmap getCardImage()
  {
    if ((mBitmap != null) && (!mBitmap.isRecycled())) {
      return Bitmap.createBitmap(mBitmap, 0, 0, mBitmap.getWidth(), mBitmap.getHeight());
    }
    return null;
  }
  
  public Rect getTorchRect()
  {
    return mTorchRect;
  }
  
  public boolean isAnimating()
  {
    return mState != 0;
  }
  
  public void markupCard()
  {
    if (mBitmap == null) {}
    for (;;)
    {
      return;
      if (mDetectedCard.flipped)
      {
        localObject = new Matrix();
        ((Matrix)localObject).setRotate(180.0F, mBitmap.getWidth() / 2, mBitmap.getHeight() / 2);
        mBitmap = Bitmap.createBitmap(mBitmap, 0, 0, mBitmap.getWidth(), mBitmap.getHeight(), (Matrix)localObject, false);
      }
      Object localObject = new Canvas(mBitmap);
      Paint localPaint = new Paint();
      Util.setupTextPaintStyle(localPaint);
      localPaint.setTextSize(28.0F * mScale);
      int j = mDetectedCard.cardNumber.length();
      float f = mBitmap.getWidth() / 428.0F;
      int k = (int)(mDetectedCard.yoff * f - 6.0F);
      int i = 0;
      while (i < j)
      {
        int m = (int)(mDetectedCard.xoff[i] * f);
        ((Canvas)localObject).drawText("" + mDetectedCard.cardNumber.charAt(i), m, k, localPaint);
        i += 1;
      }
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if ((mGuide == null) || (mCameraPreviewRect == null)) {}
    do
    {
      return;
      paramCanvas.save();
      mGradientDrawable.draw(paramCanvas);
      if ((mRotation == 0) || (mRotation == 180)) {}
      for (int i = (mGuide.bottom - mGuide.top) / 4;; i = (mGuide.right - mGuide.left) / 4)
      {
        if ((mDInfo != null) && (mDInfo.numVisibleEdges() == 4)) {
          paramCanvas.drawPath(mLockedBackgroundPath, mLockedBackgroundPaint);
        }
        mGuidePaint.clearShadowLayer();
        mGuidePaint.setStyle(Paint.Style.FILL);
        mGuidePaint.setColor(guideColor);
        paramCanvas.drawRect(guideStrokeRect(mGuide.left, mGuide.top, mGuide.left + i, mGuide.top), mGuidePaint);
        paramCanvas.drawRect(guideStrokeRect(mGuide.left, mGuide.top, mGuide.left, mGuide.top + i), mGuidePaint);
        paramCanvas.drawRect(guideStrokeRect(mGuide.right, mGuide.top, mGuide.right - i, mGuide.top), mGuidePaint);
        paramCanvas.drawRect(guideStrokeRect(mGuide.right, mGuide.top, mGuide.right, mGuide.top + i), mGuidePaint);
        paramCanvas.drawRect(guideStrokeRect(mGuide.left, mGuide.bottom, mGuide.left + i, mGuide.bottom), mGuidePaint);
        paramCanvas.drawRect(guideStrokeRect(mGuide.left, mGuide.bottom, mGuide.left, mGuide.bottom - i), mGuidePaint);
        paramCanvas.drawRect(guideStrokeRect(mGuide.right, mGuide.bottom, mGuide.right - i, mGuide.bottom), mGuidePaint);
        paramCanvas.drawRect(guideStrokeRect(mGuide.right, mGuide.bottom, mGuide.right, mGuide.bottom - i), mGuidePaint);
        if (mDInfo == null) {
          break;
        }
        if (mDInfo.topEdge) {
          paramCanvas.drawRect(guideStrokeRect(mGuide.left, mGuide.top, mGuide.right, mGuide.top), mGuidePaint);
        }
        if (mDInfo.bottomEdge) {
          paramCanvas.drawRect(guideStrokeRect(mGuide.left, mGuide.bottom, mGuide.right, mGuide.bottom), mGuidePaint);
        }
        if (mDInfo.leftEdge) {
          paramCanvas.drawRect(guideStrokeRect(mGuide.left, mGuide.top, mGuide.left, mGuide.bottom), mGuidePaint);
        }
        if (mDInfo.rightEdge) {
          paramCanvas.drawRect(guideStrokeRect(mGuide.right, mGuide.top, mGuide.right, mGuide.bottom), mGuidePaint);
        }
        if (mDInfo.numVisibleEdges() >= 3) {
          break;
        }
        float f2 = 34.0F * mScale;
        float f1 = 26.0F * mScale;
        Util.setupTextPaintStyle(mGuidePaint);
        mGuidePaint.setTextAlign(Paint.Align.CENTER);
        mGuidePaint.setTextSize(f1);
        paramCanvas.translate(mGuide.left + mGuide.width() / 2, mGuide.top + mGuide.height() / 2);
        paramCanvas.rotate(mRotationFlip * mRotation);
        if ((scanInstructions == null) || (scanInstructions == "")) {
          break;
        }
        String[] arrayOfString = scanInstructions.split("\n");
        f1 = -(((arrayOfString.length - 1) * f2 - f1) / 2.0F) - 3.0F;
        i = 0;
        while (i < arrayOfString.length)
        {
          paramCanvas.drawText(arrayOfString[i], 0.0F, f1, mGuidePaint);
          f1 += f2;
          i += 1;
        }
      }
      paramCanvas.restore();
      if (!hideCardIOLogo)
      {
        paramCanvas.save();
        paramCanvas.translate(mLogoRect.exactCenterX(), mLogoRect.exactCenterY());
        paramCanvas.rotate(mRotationFlip * mRotation);
        mLogo.draw(paramCanvas, 100.0F * mScale, 50.0F * mScale);
        paramCanvas.restore();
      }
    } while (!mShowTorch);
    paramCanvas.save();
    paramCanvas.translate(mTorchRect.exactCenterX(), mTorchRect.exactCenterY());
    paramCanvas.rotate(mRotationFlip * mRotation);
    mTorch.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      if ((paramMotionEvent.getAction() & 0xFF) != 0) {
        break label174;
      }
      paramMotionEvent = new Point((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      Rect localRect = Util.rectGivenCenter(paramMotionEvent, 20, 20);
      Log.d(TAG, "onTouchEvent: " + paramMotionEvent);
      if ((mShowTorch) && (mTorchRect != null) && (Rect.intersects(mTorchRect, localRect)))
      {
        Log.d(TAG, "torch touched");
        ((CardIOActivity)mScanActivityRef.get()).toggleFlash();
      }
      else if ((mLogoRect != null) && (Rect.intersects(mLogoRect, localRect)))
      {
        Log.d(TAG, "logo touched");
      }
    }
    catch (NullPointerException paramMotionEvent)
    {
      Log.d(TAG, "NullPointerException caught in onTouchEvent method");
    }
    ((CardIOActivity)mScanActivityRef.get()).triggerAutoFocus();
    label174:
    return false;
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    if (mBitmap != null) {
      mBitmap.recycle();
    }
    mBitmap = paramBitmap;
    if (mBitmap != null) {
      decorateBitmap();
    }
  }
  
  public void setCameraPreviewRect(Rect paramRect)
  {
    mCameraPreviewRect = paramRect;
  }
  
  public void setDetectedCard(CreditCard paramCreditCard)
  {
    mDetectedCard = paramCreditCard;
  }
  
  public void setDetectionInfo(DetectionInfo paramDetectionInfo)
  {
    if ((mDInfo != null) && (!mDInfo.sameEdgesAs(paramDetectionInfo))) {
      invalidate();
    }
    mDInfo = paramDetectionInfo;
  }
  
  public void setGuideAndRotation(Rect paramRect, int paramInt)
  {
    Log.d(TAG, "setGuideAndRotation: " + paramRect + ", " + paramInt);
    mRotation = paramInt;
    mGuide = paramRect;
    invalidate();
    if (mRotation % 180 != 0) {
      paramRect = new Point((int)(mScale * 40.0F), (int)(mScale * 60.0F));
    }
    for (mRotationFlip = -1;; mRotationFlip = 1)
    {
      if (mCameraPreviewRect != null)
      {
        Log.d(TAG, "" + mCameraPreviewRect + ", " + paramRect + ", " + mCameraPreviewRect + ", " + paramRect);
        mTorchRect = Util.rectGivenCenter(new Point(mCameraPreviewRect.left + x, mCameraPreviewRect.top + y), (int)(70.0F * mScale), (int)(mScale * 50.0F));
        mLogoRect = Util.rectGivenCenter(new Point(mCameraPreviewRect.right - x, mCameraPreviewRect.top + y), (int)(100.0F * mScale), (int)(mScale * 50.0F));
        mGradientDrawable = new GradientDrawable(GRADIENT_ORIENTATIONS[(mRotation / 90 % 4)], new int[] { -1, -16777216 });
        mGradientDrawable.setGradientType(0);
        mGradientDrawable.setBounds(mGuide);
        mGradientDrawable.setAlpha(50);
        mLockedBackgroundPath = new Path();
        mLockedBackgroundPath.addRect(new RectF(mCameraPreviewRect), Path.Direction.CW);
        mLockedBackgroundPath.addRect(new RectF(mGuide), Path.Direction.CCW);
      }
      return;
      paramRect = new Point((int)(mScale * 60.0F), (int)(mScale * 40.0F));
    }
  }
  
  public void setGuideColor(int paramInt)
  {
    guideColor = paramInt;
  }
  
  public void setHideCardIOLogo(boolean paramBoolean)
  {
    hideCardIOLogo = paramBoolean;
  }
  
  public void setScanInstructions(String paramString)
  {
    scanInstructions = paramString;
  }
  
  public void setTorchOn(boolean paramBoolean)
  {
    mTorch.setOn(paramBoolean);
    invalidate();
  }
  
  public void setUseCardIOLogo(boolean paramBoolean)
  {
    mLogo.loadLogo(paramBoolean);
  }
}

/* Location:
 * Qualified Name:     io.card.payment.OverlayView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */