package com.crashlytics.android.core;

import com.crashlytics.android.core.internal.models.ThreadData.FrameData;
import java.io.IOException;

final class NativeCrashWriter$FrameMessage
  extends NativeCrashWriter.ProtobufMessage
{
  private final long address;
  private final String file;
  private final int importance;
  private final long offset;
  private final String symbol;
  
  public NativeCrashWriter$FrameMessage(ThreadData.FrameData paramFrameData)
  {
    super(3, new NativeCrashWriter.ProtobufMessage[0]);
    address = address;
    symbol = symbol;
    file = file;
    offset = offset;
    importance = importance;
  }
  
  public int getPropertiesSize()
  {
    return CodedOutputStream.computeUInt64Size(1, address) + CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(symbol)) + CodedOutputStream.computeBytesSize(3, ByteString.copyFromUtf8(file)) + CodedOutputStream.computeUInt64Size(4, offset) + CodedOutputStream.computeUInt32Size(5, importance);
  }
  
  public void writeProperties(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    paramCodedOutputStream.writeUInt64(1, address);
    paramCodedOutputStream.writeBytes(2, ByteString.copyFromUtf8(symbol));
    paramCodedOutputStream.writeBytes(3, ByteString.copyFromUtf8(file));
    paramCodedOutputStream.writeUInt64(4, offset);
    paramCodedOutputStream.writeUInt32(5, importance);
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.NativeCrashWriter.FrameMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */