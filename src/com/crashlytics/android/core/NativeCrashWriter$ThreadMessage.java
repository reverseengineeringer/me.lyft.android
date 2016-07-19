package com.crashlytics.android.core;

import com.crashlytics.android.core.internal.models.ThreadData;
import java.io.IOException;

final class NativeCrashWriter$ThreadMessage
  extends NativeCrashWriter.ProtobufMessage
{
  private final int importance;
  private final String name;
  
  public NativeCrashWriter$ThreadMessage(ThreadData paramThreadData, NativeCrashWriter.RepeatedMessage paramRepeatedMessage)
  {
    super(1, new NativeCrashWriter.ProtobufMessage[] { paramRepeatedMessage });
    name = name;
    importance = importance;
  }
  
  private boolean hasName()
  {
    return (name != null) && (name.length() > 0);
  }
  
  public int getPropertiesSize()
  {
    if (hasName()) {}
    for (int i = CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(name));; i = 0) {
      return CodedOutputStream.computeUInt32Size(2, importance) + i;
    }
  }
  
  public void writeProperties(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    if (hasName()) {
      paramCodedOutputStream.writeBytes(1, ByteString.copyFromUtf8(name));
    }
    paramCodedOutputStream.writeUInt32(2, importance);
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.NativeCrashWriter.ThreadMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */