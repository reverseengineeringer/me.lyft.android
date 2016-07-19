package com.crashlytics.android.answers;

class KeepAllEventFilter
  implements EventFilter
{
  public boolean skipEvent(SessionEvent paramSessionEvent)
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.KeepAllEventFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */