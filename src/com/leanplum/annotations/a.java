package com.leanplum.annotations;

import android.util.Log;
import com.leanplum.Var;
import com.leanplum.callbacks.VariableCallback;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

final class a
  extends VariableCallback<T>
{
  a(WeakReference paramWeakReference, boolean paramBoolean, Field paramField, Var paramVar) {}
  
  public final void handle(Var<T> paramVar)
  {
    paramVar = a.get();
    if (((b) && (paramVar == null)) || (c == null)) {
      d.removeValueChangedHandler(this);
    }
    for (;;)
    {
      return;
      try
      {
        boolean bool = c.isAccessible();
        if (!bool) {
          c.setAccessible(true);
        }
        c.set(paramVar, d.value());
        if (!bool)
        {
          c.setAccessible(false);
          return;
        }
      }
      catch (IllegalArgumentException paramVar)
      {
        Log.e("Leanplum", "Invalid value " + d.value() + " for field " + d.name(), paramVar);
        return;
      }
      catch (IllegalAccessException paramVar)
      {
        Log.e("Leanplum", "Error setting value for field " + d.name(), paramVar);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.leanplum.annotations.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */