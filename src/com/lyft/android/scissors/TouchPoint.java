package com.lyft.android.scissors;

class TouchPoint
{
  private float x;
  private float y;
  
  public TouchPoint() {}
  
  public TouchPoint(float paramFloat1, float paramFloat2)
  {
    x = paramFloat1;
    y = paramFloat2;
  }
  
  public static TouchPoint subtract(TouchPoint paramTouchPoint1, TouchPoint paramTouchPoint2)
  {
    return new TouchPoint(x - x, y - y);
  }
  
  public TouchPoint add(TouchPoint paramTouchPoint)
  {
    x += paramTouchPoint.getX();
    y += paramTouchPoint.getY();
    return this;
  }
  
  public TouchPoint copy(TouchPoint paramTouchPoint)
  {
    x = paramTouchPoint.getX();
    y = paramTouchPoint.getY();
    return this;
  }
  
  public float getLength()
  {
    return (float)Math.sqrt(x * x + y * y);
  }
  
  public float getX()
  {
    return x;
  }
  
  public float getY()
  {
    return y;
  }
  
  public TouchPoint set(float paramFloat1, float paramFloat2)
  {
    x = paramFloat1;
    y = paramFloat2;
    return this;
  }
  
  public String toString()
  {
    return String.format("(%.4f, %.4f)", new Object[] { Float.valueOf(x), Float.valueOf(y) });
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.scissors.TouchPoint
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */