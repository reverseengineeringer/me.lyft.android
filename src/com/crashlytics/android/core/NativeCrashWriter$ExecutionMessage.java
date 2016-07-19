package com.crashlytics.android.core;

final class NativeCrashWriter$ExecutionMessage
  extends NativeCrashWriter.ProtobufMessage
{
  public NativeCrashWriter$ExecutionMessage(NativeCrashWriter.SignalMessage paramSignalMessage, NativeCrashWriter.RepeatedMessage paramRepeatedMessage1, NativeCrashWriter.RepeatedMessage paramRepeatedMessage2)
  {
    super(1, new NativeCrashWriter.ProtobufMessage[] { paramRepeatedMessage1, paramSignalMessage, paramRepeatedMessage2 });
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.NativeCrashWriter.ExecutionMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */