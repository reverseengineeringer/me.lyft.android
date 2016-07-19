package com.crashlytics.android.core;

import com.crashlytics.android.core.internal.models.SignalData;
import java.io.IOException;

final class NativeCrashWriter$SignalMessage
  extends NativeCrashWriter.ProtobufMessage
{
  private final long sigAddr;
  private final String sigCode;
  private final String sigName;
  
  public NativeCrashWriter$SignalMessage(SignalData paramSignalData)
  {
    super(3, new NativeCrashWriter.ProtobufMessage[0]);
    sigName = name;
    sigCode = code;
    sigAddr = faultAddress;
  }
  
  public int getPropertiesSize()
  {
    return CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(sigName)) + CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(sigCode)) + CodedOutputStream.computeUInt64Size(3, sigAddr);
  }
  
  public void writeProperties(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    paramCodedOutputStream.writeBytes(1, ByteString.copyFromUtf8(sigName));
    paramCodedOutputStream.writeBytes(2, ByteString.copyFromUtf8(sigCode));
    paramCodedOutputStream.writeUInt64(3, sigAddr);
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.NativeCrashWriter.SignalMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */