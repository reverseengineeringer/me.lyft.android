package com.crashlytics.android.core.internal;

import com.crashlytics.android.core.internal.models.SessionEventData;

public abstract interface CrashEventDataProvider
{
  public abstract SessionEventData getCrashEventData();
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.internal.CrashEventDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */