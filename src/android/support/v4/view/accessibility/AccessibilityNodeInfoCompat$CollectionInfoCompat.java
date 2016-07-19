package android.support.v4.view.accessibility;

public class AccessibilityNodeInfoCompat$CollectionInfoCompat
{
  final Object mInfo;
  
  private AccessibilityNodeInfoCompat$CollectionInfoCompat(Object paramObject)
  {
    mInfo = paramObject;
  }
  
  public static CollectionInfoCompat obtain(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    return new CollectionInfoCompat(AccessibilityNodeInfoCompat.access$000().obtainCollectionInfo(paramInt1, paramInt2, paramBoolean, paramInt3));
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */