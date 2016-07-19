package com.crashlytics.android.core;

import java.io.IOException;

final class NativeCrashWriter$NullMessage
  extends NativeCrashWriter.ProtobufMessage
{
  public NativeCrashWriter$NullMessage()
  {
    super(0, new NativeCrashWriter.ProtobufMessage[0]);
  }
  
  public void write(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {}
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.NativeCrashWriter.NullMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */