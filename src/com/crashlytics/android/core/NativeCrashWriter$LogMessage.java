package com.crashlytics.android.core;

import java.io.IOException;

final class NativeCrashWriter$LogMessage
  extends NativeCrashWriter.ProtobufMessage
{
  ByteString logBytes;
  
  public NativeCrashWriter$LogMessage(ByteString paramByteString)
  {
    super(6, new NativeCrashWriter.ProtobufMessage[0]);
    logBytes = paramByteString;
  }
  
  public int getPropertiesSize()
  {
    return CodedOutputStream.computeBytesSize(1, logBytes);
  }
  
  public void writeProperties(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    paramCodedOutputStream.writeBytes(1, logBytes);
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.NativeCrashWriter.LogMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */