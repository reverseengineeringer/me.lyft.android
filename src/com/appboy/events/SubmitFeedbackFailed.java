package com.appboy.events;

import com.appboy.models.ResponseError;
import com.appboy.models.outgoing.Feedback;

public final class SubmitFeedbackFailed
{
  private final Feedback a;
  private final ResponseError b;
  
  public SubmitFeedbackFailed(Feedback paramFeedback, ResponseError paramResponseError)
  {
    a = paramFeedback;
    b = paramResponseError;
  }
  
  public final ResponseError getError()
  {
    return b;
  }
  
  public final Feedback getFeedback()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     com.appboy.events.SubmitFeedbackFailed
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */