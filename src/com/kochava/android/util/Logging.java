package com.kochava.android.util;

import android.util.Log;
import com.kochava.android.tracker.Global;
import java.util.regex.Pattern;

public class Logging
{
  static Pattern p = Pattern.compile("(?<!\\.)koch(ava)?_?(?!\\.com)( (?=generated)|%20)?", 2);
  
  public static void Log(String paramString)
  {
    if (Global.DEBUG) {
      Log.i("KochavaTracker", paramString);
    }
  }
  
  public static void LogError(String paramString)
  {
    if (Global.DEBUGERROR) {
      Log.e("KochavaTracker", paramString);
    }
  }
  
  public static void LogRequirementsError(String paramString)
  {
    if (Global.DEBUGERROR) {
      Log.e("KochavaRequirements", paramString);
    }
  }
}

/* Location:
 * Qualified Name:     com.kochava.android.util.Logging
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */