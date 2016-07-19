package com.crashlytics.android.answers;

import java.util.HashSet;

final class SamplingEventFilter$1
  extends HashSet<SessionEvent.Type>
{
  SamplingEventFilter$1()
  {
    add(SessionEvent.Type.START);
    add(SessionEvent.Type.RESUME);
    add(SessionEvent.Type.PAUSE);
    add(SessionEvent.Type.STOP);
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.SamplingEventFilter.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */