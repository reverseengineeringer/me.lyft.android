package io.card.payment;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;

class Preview
  extends ViewGroup
{
  private static final String TAG;
  private boolean isSurfaceValid;
  private int mPreviewHeight;
  private int mPreviewWidth;
  SurfaceView mSurfaceView;
  
  static
  {
    if (!Preview.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      TAG = Preview.class.getSimpleName();
      return;
    }
  }
  
  public Preview(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet);
    mPreviewWidth = paramInt2;
    mPreviewHeight = paramInt1;
    mSurfaceView = new SurfaceView(paramContext);
    addView(mSurfaceView);
  }
  
  SurfaceHolder getSurfaceHolder()
  {
    SurfaceHolder localSurfaceHolder = getSurfaceView().getHolder();
    assert (localSurfaceHolder != null);
    return localSurfaceHolder;
  }
  
  public SurfaceView getSurfaceView()
  {
    assert (mSurfaceView != null);
    return mSurfaceView;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    Log.d(TAG, "Preview.onDraw()");
    super.onDraw(paramCanvas);
    paramCanvas.drawARGB(255, 255, 0, 0);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Log.d(TAG, "Preview.onLayout()");
    Log.d(TAG, "- isSurfaceValid: " + isSurfaceValid);
    if ((paramBoolean) && (getChildCount() > 0))
    {
      assert (mSurfaceView != null);
      paramInt1 = paramInt3 - paramInt1;
      paramInt2 = paramInt4 - paramInt2;
      if (mPreviewHeight * paramInt1 > mPreviewWidth * paramInt2)
      {
        paramInt3 = mPreviewWidth * paramInt2 / mPreviewHeight;
        mSurfaceView.layout((paramInt1 - paramInt3) / 2, 0, (paramInt1 + paramInt3) / 2, paramInt2);
      }
    }
    else
    {
      return;
    }
    paramInt3 = mPreviewHeight * paramInt1 / mPreviewWidth;
    mSurfaceView.layout(0, (paramInt2 - paramInt3) / 2, paramInt1, (paramInt2 + paramInt3) / 2);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = resolveSize(getSuggestedMinimumWidth(), paramInt1);
    int j = resolveSize(getSuggestedMinimumHeight(), paramInt2);
    Log.d(TAG, String.format("Preview.onMeasure(w:%d, h:%d) setMeasuredDimension(w:%d, h:%d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(j) }));
    setMeasuredDimension(i, j);
  }
}

/* Location:
 * Qualified Name:     io.card.payment.Preview
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */