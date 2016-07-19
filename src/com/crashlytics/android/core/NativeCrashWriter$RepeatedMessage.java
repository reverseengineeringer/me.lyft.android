package com.crashlytics.android.core;

import java.io.IOException;

final class NativeCrashWriter$RepeatedMessage
  extends NativeCrashWriter.ProtobufMessage
{
  private final NativeCrashWriter.ProtobufMessage[] messages;
  
  public NativeCrashWriter$RepeatedMessage(NativeCrashWriter.ProtobufMessage... paramVarArgs)
  {
    super(0, new NativeCrashWriter.ProtobufMessage[0]);
    messages = paramVarArgs;
  }
  
  public int getSize()
  {
    int j = 0;
    NativeCrashWriter.ProtobufMessage[] arrayOfProtobufMessage = messages;
    int k = arrayOfProtobufMessage.length;
    int i = 0;
    while (i < k)
    {
      j += arrayOfProtobufMessage[i].getSize();
      i += 1;
    }
    return j;
  }
  
  public void write(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    NativeCrashWriter.ProtobufMessage[] arrayOfProtobufMessage = messages;
    int j = arrayOfProtobufMessage.length;
    int i = 0;
    while (i < j)
    {
      arrayOfProtobufMessage[i].write(paramCodedOutputStream);
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.NativeCrashWriter.RepeatedMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */