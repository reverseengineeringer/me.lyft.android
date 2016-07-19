package android.support.v4.view.accessibility;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

class AccessibilityNodeProviderCompat$AccessibilityNodeProviderJellyBeanImpl$1
  implements AccessibilityNodeProviderCompatJellyBean.AccessibilityNodeInfoBridge
{
  AccessibilityNodeProviderCompat$AccessibilityNodeProviderJellyBeanImpl$1(AccessibilityNodeProviderCompat.AccessibilityNodeProviderJellyBeanImpl paramAccessibilityNodeProviderJellyBeanImpl, AccessibilityNodeProviderCompat paramAccessibilityNodeProviderCompat) {}
  
  public Object createAccessibilityNodeInfo(int paramInt)
  {
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = val$compat.createAccessibilityNodeInfo(paramInt);
    if (localAccessibilityNodeInfoCompat == null) {
      return null;
    }
    return localAccessibilityNodeInfoCompat.getInfo();
  }
  
  public List<Object> findAccessibilityNodeInfosByText(String paramString, int paramInt)
  {
    paramString = val$compat.findAccessibilityNodeInfosByText(paramString, paramInt);
    ArrayList localArrayList = new ArrayList();
    int i = paramString.size();
    paramInt = 0;
    while (paramInt < i)
    {
      localArrayList.add(((AccessibilityNodeInfoCompat)paramString.get(paramInt)).getInfo());
      paramInt += 1;
    }
    return localArrayList;
  }
  
  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return val$compat.performAction(paramInt1, paramInt2, paramBundle);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderJellyBeanImpl.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */