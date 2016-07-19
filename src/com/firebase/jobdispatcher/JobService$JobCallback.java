package com.firebase.jobdispatcher;

import android.os.Message;

final class JobService$JobCallback
{
  public final JobParameters jobParameters;
  public final Message message;
  
  private JobService$JobCallback(JobParameters paramJobParameters, Message paramMessage)
  {
    jobParameters = paramJobParameters;
    message = paramMessage;
  }
  
  void sendResult(int paramInt)
  {
    message.arg1 = paramInt;
    message.sendToTarget();
  }
}

/* Location:
 * Qualified Name:     com.firebase.jobdispatcher.JobService.JobCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */