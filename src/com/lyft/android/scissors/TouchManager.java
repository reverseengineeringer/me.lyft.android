package com.lyft.android.scissors;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.view.MotionEvent;

class TouchManager
{
  private int bitmapHeight;
  private int bitmapWidth;
  private final CropViewConfig cropViewConfig;
  private int horizontalLimit;
  private Rect imageBounds;
  private final int maxNumberOfTouchPoints;
  private float maximumScale;
  private float minimumScale;
  private final TouchPoint[] points;
  private TouchPoint position = new TouchPoint();
  private final TouchPoint[] previousPoints;
  private float scale = 1.0F;
  private int verticalLimit;
  private int viewportHeight;
  private int viewportWidth;
  
  public TouchManager(int paramInt, CropViewConfig paramCropViewConfig)
  {
    maxNumberOfTouchPoints = paramInt;
    cropViewConfig = paramCropViewConfig;
    points = new TouchPoint[paramInt];
    previousPoints = new TouchPoint[paramInt];
    minimumScale = paramCropViewConfig.getMinScale();
    maximumScale = paramCropViewConfig.getMaxScale();
  }
  
  private static int computeLimit(int paramInt1, int paramInt2)
  {
    return (paramInt1 - paramInt2) / 2;
  }
  
  private int getDownCount()
  {
    int j = 0;
    TouchPoint[] arrayOfTouchPoint = points;
    int m = arrayOfTouchPoint.length;
    int i = 0;
    while (i < m)
    {
      int k = j;
      if (arrayOfTouchPoint[i] != null) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private void handleDragGesture()
  {
    if (getDownCount() != 1) {
      return;
    }
    position.add(moveDelta(0));
  }
  
  @TargetApi(8)
  private void handleDragOutsideViewport(MotionEvent paramMotionEvent)
  {
    if ((imageBounds == null) || (!isUpAction(paramMotionEvent.getActionMasked()))) {
      return;
    }
    float f2 = position.getY();
    int i = imageBounds.bottom;
    float f1;
    float f3;
    if (i - f2 >= verticalLimit)
    {
      f1 = i - verticalLimit;
      f3 = position.getX();
      i = imageBounds.right;
      if (f3 > i - horizontalLimit) {
        break label138;
      }
      f2 = i - horizontalLimit;
    }
    for (;;)
    {
      position.set(f2, f1);
      return;
      f1 = f2;
      if (f2 - i < verticalLimit) {
        break;
      }
      f1 = verticalLimit + i;
      break;
      label138:
      f2 = f3;
      if (f3 > horizontalLimit + i) {
        f2 = horizontalLimit + i;
      }
    }
  }
  
  private void handlePinchGesture()
  {
    if (getDownCount() != 2) {
      return;
    }
    updateScale();
    horizontalLimit = computeLimit((int)(bitmapWidth * scale), viewportWidth);
    verticalLimit = computeLimit((int)(bitmapHeight * scale), viewportHeight);
  }
  
  private boolean isPressed(int paramInt)
  {
    return points[paramInt] != null;
  }
  
  private static boolean isUpAction(int paramInt)
  {
    return (paramInt == 6) || (paramInt == 1);
  }
  
  private TouchPoint moveDelta(int paramInt)
  {
    if (isPressed(paramInt))
    {
      if (previousPoints[paramInt] != null) {}
      for (TouchPoint localTouchPoint = previousPoints[paramInt];; localTouchPoint = points[paramInt]) {
        return TouchPoint.subtract(points[paramInt], localTouchPoint);
      }
    }
    return new TouchPoint();
  }
  
  private TouchPoint previousVector(int paramInt1, int paramInt2)
  {
    if ((previousPoints[paramInt1] == null) || (previousPoints[paramInt2] == null)) {
      return vector(points[paramInt1], points[paramInt2]);
    }
    return vector(previousPoints[paramInt1], previousPoints[paramInt2]);
  }
  
  private void setMinimumScale()
  {
    float f1 = bitmapWidth / bitmapHeight;
    float f2 = viewportWidth / viewportHeight;
    if ((bitmapWidth < viewportWidth) || (bitmapHeight < viewportHeight)) {
      minimumScale = 1.0F;
    }
    for (;;)
    {
      scale = minimumScale;
      return;
      if (f1 > f2) {
        minimumScale = (viewportHeight / bitmapHeight);
      } else {
        minimumScale = (viewportWidth / bitmapWidth);
      }
    }
  }
  
  private void setViewport(int paramInt)
  {
    viewportWidth = paramInt;
    viewportHeight = ((int)(paramInt * cropViewConfig.getViewportHeightRatio()));
  }
  
  private void updateCurrentAndPreviousPoints(MotionEvent paramMotionEvent)
  {
    int i = 0;
    if (i < maxNumberOfTouchPoints)
    {
      float f1;
      float f2;
      if (i < paramMotionEvent.getPointerCount())
      {
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        if (points[i] == null)
        {
          points[i] = new TouchPoint(f1, f2);
          previousPoints[i] = null;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (previousPoints[i] == null) {
          previousPoints[i] = new TouchPoint();
        }
        previousPoints[i].copy(points[i]);
        points[i].set(f1, f2);
        continue;
        previousPoints[i] = null;
        points[i] = null;
      }
    }
  }
  
  private void updateScale()
  {
    TouchPoint localTouchPoint1 = vector(points[0], points[1]);
    TouchPoint localTouchPoint2 = previousVector(0, 1);
    float f3 = localTouchPoint1.getLength();
    float f4 = localTouchPoint2.getLength();
    float f2 = scale;
    float f1 = f2;
    if (f4 != 0.0F) {
      f1 = f2 * (f3 / f4);
    }
    f2 = f1;
    if (f1 < minimumScale) {
      f2 = minimumScale;
    }
    f1 = f2;
    if (f2 > maximumScale) {
      f1 = maximumScale;
    }
    scale = f1;
  }
  
  private static TouchPoint vector(TouchPoint paramTouchPoint1, TouchPoint paramTouchPoint2)
  {
    return TouchPoint.subtract(paramTouchPoint2, paramTouchPoint1);
  }
  
  public void applyPositioningAndScale(Matrix paramMatrix)
  {
    paramMatrix.postTranslate(-bitmapWidth / 2.0F, -bitmapHeight / 2.0F);
    paramMatrix.postScale(scale, scale);
    paramMatrix.postTranslate(position.getX(), position.getY());
  }
  
  public int getViewportHeight()
  {
    return viewportHeight;
  }
  
  public int getViewportWidth()
  {
    return viewportWidth;
  }
  
  @TargetApi(8)
  public void onEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (i >= maxNumberOfTouchPoints) {
      return;
    }
    if (isUpAction(paramMotionEvent.getActionMasked()))
    {
      previousPoints[i] = null;
      points[i] = null;
    }
    for (;;)
    {
      handleDragGesture();
      handlePinchGesture();
      handleDragOutsideViewport(paramMotionEvent);
      return;
      updateCurrentAndPreviousPoints(paramMotionEvent);
    }
  }
  
  public void resetFor(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    position.set(paramInt3 / 2, paramInt4 / 2);
    imageBounds = new Rect(0, 0, paramInt3 / 2, paramInt4 / 2);
    setViewport(paramInt3);
    setMinimumScale();
    bitmapWidth = paramInt1;
    bitmapHeight = paramInt2;
    horizontalLimit = computeLimit(paramInt1, viewportWidth);
    verticalLimit = computeLimit(paramInt2, viewportHeight);
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.scissors.TouchManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */