package com.crashlytics.android.core;

import java.io.IOException;

final class NativeCrashWriter$EventMessage
  extends NativeCrashWriter.ProtobufMessage
{
  private final String crashType;
  private final long time;
  
  public NativeCrashWriter$EventMessage(long paramLong, String paramString, NativeCrashWriter.ProtobufMessage... paramVarArgs)
  {
    super(10, paramVarArgs);
    time = paramLong;
    crashType = paramString;
  }
  
  public int getPropertiesSize()
  {
    return CodedOutputStream.computeUInt64Size(1, time) + CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(crashType));
  }
  
  public void writeProperties(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    paramCodedOutputStream.writeUInt64(1, time);
    paramCodedOutputStream.writeBytes(2, ByteString.copyFromUtf8(crashType));
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.NativeCrashWriter.EventMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */