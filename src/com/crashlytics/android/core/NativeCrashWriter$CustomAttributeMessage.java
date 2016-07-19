package com.crashlytics.android.core;

import com.crashlytics.android.core.internal.models.CustomAttributeData;
import java.io.IOException;

final class NativeCrashWriter$CustomAttributeMessage
  extends NativeCrashWriter.ProtobufMessage
{
  private final String key;
  private final String value;
  
  public NativeCrashWriter$CustomAttributeMessage(CustomAttributeData paramCustomAttributeData)
  {
    super(2, new NativeCrashWriter.ProtobufMessage[0]);
    key = key;
    value = value;
  }
  
  public int getPropertiesSize()
  {
    int i = CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(key));
    if (value == null) {}
    for (String str = "";; str = value) {
      return i + CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(str));
    }
  }
  
  public void writeProperties(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    paramCodedOutputStream.writeBytes(1, ByteString.copyFromUtf8(key));
    if (value == null) {}
    for (String str = "";; str = value)
    {
      paramCodedOutputStream.writeBytes(2, ByteString.copyFromUtf8(str));
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.NativeCrashWriter.CustomAttributeMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */