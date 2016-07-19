package com.paypal.android.sdk;

import android.os.Build;
import java.io.File;

public final class af
{
  private static Y a = new Y();
  
  public static boolean a()
  {
    boolean bool = false;
    if ((Build.TAGS != null) && (Build.TAGS.contains("test-keys")))
    {
      i = 1;
      if (i == 0)
      {
        if (!new File(a.a("suFileName")).exists()) {
          break label88;
        }
        i = 1;
        label48:
        if (i == 0) {
          if (!new File(a.a("superUserApk")).exists()) {
            break label93;
          }
        }
      }
    }
    label88:
    label93:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        bool = true;
      }
      return bool;
      i = 0;
      break;
      i = 0;
      break label48;
    }
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.af
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */