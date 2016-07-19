package android.support.v4.view.accessibility;

import android.os.Build.VERSION;

public class AccessibilityRecordCompat
{
  private static final AccessibilityRecordImpl IMPL = new AccessibilityRecordStubImpl();
  private final Object mRecord;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      IMPL = new AccessibilityRecordJellyBeanImpl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 15)
    {
      IMPL = new AccessibilityRecordIcsMr1Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      IMPL = new AccessibilityRecordIcsImpl();
      return;
    }
  }
  
  public AccessibilityRecordCompat(Object paramObject)
  {
    mRecord = paramObject;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (AccessibilityRecordCompat)paramObject;
        if (mRecord != null) {
          break;
        }
      } while (mRecord == null);
      return false;
    } while (mRecord.equals(mRecord));
    return false;
  }
  
  public int hashCode()
  {
    if (mRecord == null) {
      return 0;
    }
    return mRecord.hashCode();
  }
  
  public void setFromIndex(int paramInt)
  {
    IMPL.setFromIndex(mRecord, paramInt);
  }
  
  public void setItemCount(int paramInt)
  {
    IMPL.setItemCount(mRecord, paramInt);
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    IMPL.setScrollable(mRecord, paramBoolean);
  }
  
  public void setToIndex(int paramInt)
  {
    IMPL.setToIndex(mRecord, paramInt);
  }
  
  static class AccessibilityRecordIcsImpl
    extends AccessibilityRecordCompat.AccessibilityRecordStubImpl
  {
    public void setFromIndex(Object paramObject, int paramInt)
    {
      AccessibilityRecordCompatIcs.setFromIndex(paramObject, paramInt);
    }
    
    public void setItemCount(Object paramObject, int paramInt)
    {
      AccessibilityRecordCompatIcs.setItemCount(paramObject, paramInt);
    }
    
    public void setScrollable(Object paramObject, boolean paramBoolean)
    {
      AccessibilityRecordCompatIcs.setScrollable(paramObject, paramBoolean);
    }
    
    public void setToIndex(Object paramObject, int paramInt)
    {
      AccessibilityRecordCompatIcs.setToIndex(paramObject, paramInt);
    }
  }
  
  static class AccessibilityRecordIcsMr1Impl
    extends AccessibilityRecordCompat.AccessibilityRecordIcsImpl
  {}
  
  static abstract interface AccessibilityRecordImpl
  {
    public abstract void setFromIndex(Object paramObject, int paramInt);
    
    public abstract void setItemCount(Object paramObject, int paramInt);
    
    public abstract void setScrollable(Object paramObject, boolean paramBoolean);
    
    public abstract void setToIndex(Object paramObject, int paramInt);
  }
  
  static class AccessibilityRecordJellyBeanImpl
    extends AccessibilityRecordCompat.AccessibilityRecordIcsMr1Impl
  {}
  
  static class AccessibilityRecordStubImpl
    implements AccessibilityRecordCompat.AccessibilityRecordImpl
  {
    public void setFromIndex(Object paramObject, int paramInt) {}
    
    public void setItemCount(Object paramObject, int paramInt) {}
    
    public void setScrollable(Object paramObject, boolean paramBoolean) {}
    
    public void setToIndex(Object paramObject, int paramInt) {}
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityRecordCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */