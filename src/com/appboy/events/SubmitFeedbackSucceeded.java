package com.appboy.events;

import com.appboy.models.outgoing.Feedback;

public final class SubmitFeedbackSucceeded
{
  private final Feedback a;
  
  public SubmitFeedbackSucceeded(Feedback paramFeedback)
  {
    a = paramFeedback;
  }
  
  public final Feedback getFeedback()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     com.appboy.events.SubmitFeedbackSucceeded
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */