package com.threatmetrix.TrustDefenderMobile;

import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import java.lang.reflect.Method;

class DisplayWrapper
  extends WrapperHelper
{
  private static final String TAG = StringUtils.getLogTag(DisplayWrapper.class);
  private static final Method m_getHeight = getMethod(Display.class, "getHeight", new Class[0]);
  private static final Method m_getSize = getMethod(Display.class, "getSize", new Class[] { Point.class });
  private static final Method m_getWidth = getMethod(Display.class, "getWidth", new Class[0]);
  private final Display m_display;
  
  public DisplayWrapper(Display paramDisplay)
  {
    m_display = paramDisplay;
  }
  
  public int getHeight()
  {
    Object localObject;
    if (m_getSize != null)
    {
      localObject = new Point();
      invoke(m_display, m_getSize, new Object[] { localObject });
      return y;
    }
    if (m_getHeight != null)
    {
      localObject = (Integer)invoke(m_display, m_getHeight, new Object[0]);
      if (localObject != null) {
        return ((Integer)localObject).intValue();
      }
    }
    Log.w(TAG, "unable to get display height");
    return 0;
  }
  
  public int getWidth()
  {
    Object localObject;
    if (m_getSize != null)
    {
      localObject = new Point();
      invoke(m_display, m_getSize, new Object[] { localObject });
      return x;
    }
    if (m_getWidth != null)
    {
      localObject = (Integer)invoke(m_display, m_getWidth, new Object[0]);
      if (localObject != null) {
        return ((Integer)localObject).intValue();
      }
    }
    Log.w(TAG, "unable to get display width");
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.DisplayWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */