package com.crashlytics.android.answers;

abstract interface EventFilter
{
  public abstract boolean skipEvent(SessionEvent paramSessionEvent);
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.EventFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */