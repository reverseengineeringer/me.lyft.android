package com.firebase.jobdispatcher;

import android.text.TextUtils;
import java.util.List;

public class ValidationEnforcer
  implements JobValidator
{
  private final JobValidator mValidator;
  
  public ValidationEnforcer(JobValidator paramJobValidator)
  {
    mValidator = paramJobValidator;
  }
  
  private void ensureNoErrors(List<String> paramList)
  {
    if (paramList != null) {
      throw new ValidationException("JobParameters is invalid", paramList);
    }
  }
  
  public final void ensureValid(JobParameters paramJobParameters)
  {
    ensureNoErrors(validate(paramJobParameters));
  }
  
  public List<String> validate(JobParameters paramJobParameters)
  {
    return mValidator.validate(paramJobParameters);
  }
  
  public static final class ValidationException
    extends RuntimeException
  {
    private final List<String> mErrors;
    
    public ValidationException(String paramString, List<String> paramList)
    {
      super();
      mErrors = paramList;
    }
  }
}

/* Location:
 * Qualified Name:     com.firebase.jobdispatcher.ValidationEnforcer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */