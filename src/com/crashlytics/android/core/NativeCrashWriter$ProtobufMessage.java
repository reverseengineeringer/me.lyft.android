package com.crashlytics.android.core;

import java.io.IOException;

abstract class NativeCrashWriter$ProtobufMessage
{
  private final ProtobufMessage[] children;
  private final int tag;
  
  public NativeCrashWriter$ProtobufMessage(int paramInt, ProtobufMessage... paramVarArgs)
  {
    tag = paramInt;
    if (paramVarArgs != null) {}
    for (;;)
    {
      children = paramVarArgs;
      return;
      paramVarArgs = NativeCrashWriter.access$000();
    }
  }
  
  public int getPropertiesSize()
  {
    return 0;
  }
  
  public int getSize()
  {
    int i = getSizeNoTag();
    return i + CodedOutputStream.computeRawVarint32Size(i) + CodedOutputStream.computeTagSize(tag);
  }
  
  public int getSizeNoTag()
  {
    int j = getPropertiesSize();
    ProtobufMessage[] arrayOfProtobufMessage = children;
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
    paramCodedOutputStream.writeTag(tag, 2);
    paramCodedOutputStream.writeRawVarint32(getSizeNoTag());
    writeProperties(paramCodedOutputStream);
    ProtobufMessage[] arrayOfProtobufMessage = children;
    int j = arrayOfProtobufMessage.length;
    int i = 0;
    while (i < j)
    {
      arrayOfProtobufMessage[i].write(paramCodedOutputStream);
      i += 1;
    }
  }
  
  public void writeProperties(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {}
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */