package com.firebase.jobdispatcher;

import android.text.TextUtils;
import java.util.List;

public final class ValidationEnforcer$ValidationException
  extends RuntimeException
{
  private final List<String> mErrors;
  
  public ValidationEnforcer$ValidationException(String paramString, List<String> paramList)
  {
    super(paramString + ": " + TextUtils.join("\n  - ", paramList));
    mErrors = paramList;
  }
}

/* Location:
 * Qualified Name:     com.firebase.jobdispatcher.ValidationEnforcer.ValidationException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */