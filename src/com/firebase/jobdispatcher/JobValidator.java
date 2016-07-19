package com.firebase.jobdispatcher;

import java.util.List;

public abstract interface JobValidator
{
  public abstract List<String> validate(JobParameters paramJobParameters);
}

/* Location:
 * Qualified Name:     com.firebase.jobdispatcher.JobValidator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */