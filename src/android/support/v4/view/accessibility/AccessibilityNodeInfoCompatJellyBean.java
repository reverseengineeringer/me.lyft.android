package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;

class AccessibilityNodeInfoCompatJellyBean
{
  public static boolean isAccessibilityFocused(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isAccessibilityFocused();
  }
  
  public static boolean isVisibleToUser(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isVisibleToUser();
  }
  
  public static void setAccesibilityFocused(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setAccessibilityFocused(paramBoolean);
  }
  
  public static void setVisibleToUser(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setVisibleToUser(paramBoolean);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeInfoCompatJellyBean
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */