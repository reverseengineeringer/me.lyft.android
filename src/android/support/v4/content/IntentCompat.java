package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;

public final class IntentCompat
{
  private static final IntentCompatImpl IMPL = new IntentCompatImplBase();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 15)
    {
      IMPL = new IntentCompatImplIcsMr1();
      return;
    }
    if (i >= 11)
    {
      IMPL = new IntentCompatImplHC();
      return;
    }
  }
  
  public static Intent makeMainActivity(ComponentName paramComponentName)
  {
    return IMPL.makeMainActivity(paramComponentName);
  }
  
  static abstract interface IntentCompatImpl
  {
    public abstract Intent makeMainActivity(ComponentName paramComponentName);
  }
  
  static class IntentCompatImplBase
    implements IntentCompat.IntentCompatImpl
  {
    public Intent makeMainActivity(ComponentName paramComponentName)
    {
      Intent localIntent = new Intent("android.intent.action.MAIN");
      localIntent.setComponent(paramComponentName);
      localIntent.addCategory("android.intent.category.LAUNCHER");
      return localIntent;
    }
  }
  
  static class IntentCompatImplHC
    extends IntentCompat.IntentCompatImplBase
  {
    public Intent makeMainActivity(ComponentName paramComponentName)
    {
      return IntentCompatHoneycomb.makeMainActivity(paramComponentName);
    }
  }
  
  static class IntentCompatImplIcsMr1
    extends IntentCompat.IntentCompatImplHC
  {}
}

/* Location:
 * Qualified Name:     android.support.v4.content.IntentCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */