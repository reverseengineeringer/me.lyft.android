package com.crashlytics.android.core;

import com.crashlytics.android.core.internal.models.BinaryImageData;
import com.crashlytics.android.core.internal.models.CustomAttributeData;
import com.crashlytics.android.core.internal.models.DeviceData;
import com.crashlytics.android.core.internal.models.SessionEventData;
import com.crashlytics.android.core.internal.models.SignalData;
import com.crashlytics.android.core.internal.models.ThreadData;
import com.crashlytics.android.core.internal.models.ThreadData.FrameData;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

class NativeCrashWriter
{
  private static final SignalData DEFAULT_SIGNAL = new SignalData("", "", 0L);
  private static final BinaryImageMessage[] EMPTY_BINARY_IMAGE_MESSAGES = new BinaryImageMessage[0];
  private static final ProtobufMessage[] EMPTY_CHILDREN = new ProtobufMessage[0];
  private static final CustomAttributeMessage[] EMPTY_CUSTOM_ATTRIBUTE_MESSAGES = new CustomAttributeMessage[0];
  private static final FrameMessage[] EMPTY_FRAME_MESSAGES;
  private static final ThreadMessage[] EMPTY_THREAD_MESSAGES = new ThreadMessage[0];
  
  static
  {
    EMPTY_FRAME_MESSAGES = new FrameMessage[0];
  }
  
  private static RepeatedMessage createBinaryImagesMessage(BinaryImageData[] paramArrayOfBinaryImageData)
  {
    if (paramArrayOfBinaryImageData != null) {}
    for (BinaryImageMessage[] arrayOfBinaryImageMessage = new BinaryImageMessage[paramArrayOfBinaryImageData.length];; arrayOfBinaryImageMessage = EMPTY_BINARY_IMAGE_MESSAGES)
    {
      int i = 0;
      while (i < arrayOfBinaryImageMessage.length)
      {
        arrayOfBinaryImageMessage[i] = new BinaryImageMessage(paramArrayOfBinaryImageData[i]);
        i += 1;
      }
    }
    return new RepeatedMessage(arrayOfBinaryImageMessage);
  }
  
  private static RepeatedMessage createCustomAttributesMessage(CustomAttributeData[] paramArrayOfCustomAttributeData)
  {
    if (paramArrayOfCustomAttributeData != null) {}
    for (CustomAttributeMessage[] arrayOfCustomAttributeMessage = new CustomAttributeMessage[paramArrayOfCustomAttributeData.length];; arrayOfCustomAttributeMessage = EMPTY_CUSTOM_ATTRIBUTE_MESSAGES)
    {
      int i = 0;
      while (i < arrayOfCustomAttributeMessage.length)
      {
        arrayOfCustomAttributeMessage[i] = new CustomAttributeMessage(paramArrayOfCustomAttributeData[i]);
        i += 1;
      }
    }
    return new RepeatedMessage(arrayOfCustomAttributeMessage);
  }
  
  private static DeviceMessage createDeviceMessage(DeviceData paramDeviceData)
  {
    return new DeviceMessage(batteryCapacity / 100.0F, batteryVelocity, proximity, orientation, totalPhysicalMemory - availablePhysicalMemory, totalInternalStorage - availableInternalStorage);
  }
  
  private static EventMessage createEventMessage(SessionEventData paramSessionEventData, LogFileManager paramLogFileManager, Map<String, String> paramMap)
    throws IOException
  {
    Object localObject;
    ByteString localByteString;
    if (signal != null)
    {
      localObject = signal;
      paramMap = new ApplicationMessage(new ExecutionMessage(new SignalMessage((SignalData)localObject), createThreadsMessage(threads), createBinaryImagesMessage(binaryImages)), createCustomAttributesMessage(mergeCustomAttributes(customAttributes, paramMap)));
      localObject = createDeviceMessage(deviceData);
      localByteString = paramLogFileManager.getByteStringForLog();
      if (localByteString == null) {
        Fabric.getLogger().d("CrashlyticsCore", "No log data to include with this event.");
      }
      paramLogFileManager.clearLog();
      if (localByteString == null) {
        break label147;
      }
    }
    label147:
    for (paramLogFileManager = new LogMessage(localByteString);; paramLogFileManager = new NullMessage())
    {
      return new EventMessage(timestamp, "ndk-crash", new ProtobufMessage[] { paramMap, localObject, paramLogFileManager });
      localObject = DEFAULT_SIGNAL;
      break;
    }
  }
  
  private static RepeatedMessage createFramesMessage(ThreadData.FrameData[] paramArrayOfFrameData)
  {
    if (paramArrayOfFrameData != null) {}
    for (FrameMessage[] arrayOfFrameMessage = new FrameMessage[paramArrayOfFrameData.length];; arrayOfFrameMessage = EMPTY_FRAME_MESSAGES)
    {
      int i = 0;
      while (i < arrayOfFrameMessage.length)
      {
        arrayOfFrameMessage[i] = new FrameMessage(paramArrayOfFrameData[i]);
        i += 1;
      }
    }
    return new RepeatedMessage(arrayOfFrameMessage);
  }
  
  private static RepeatedMessage createThreadsMessage(ThreadData[] paramArrayOfThreadData)
  {
    if (paramArrayOfThreadData != null) {}
    for (ThreadMessage[] arrayOfThreadMessage = new ThreadMessage[paramArrayOfThreadData.length];; arrayOfThreadMessage = EMPTY_THREAD_MESSAGES)
    {
      int i = 0;
      while (i < arrayOfThreadMessage.length)
      {
        ThreadData localThreadData = paramArrayOfThreadData[i];
        arrayOfThreadMessage[i] = new ThreadMessage(localThreadData, createFramesMessage(frames));
        i += 1;
      }
    }
    return new RepeatedMessage(arrayOfThreadMessage);
  }
  
  private static CustomAttributeData[] mergeCustomAttributes(CustomAttributeData[] paramArrayOfCustomAttributeData, Map<String, String> paramMap)
  {
    paramMap = new TreeMap(paramMap);
    if (paramArrayOfCustomAttributeData != null)
    {
      int j = paramArrayOfCustomAttributeData.length;
      i = 0;
      while (i < j)
      {
        CustomAttributeData localCustomAttributeData = paramArrayOfCustomAttributeData[i];
        paramMap.put(key, value);
        i += 1;
      }
    }
    paramArrayOfCustomAttributeData = (Map.Entry[])paramMap.entrySet().toArray(new Map.Entry[paramMap.size()]);
    paramMap = new CustomAttributeData[paramArrayOfCustomAttributeData.length];
    int i = 0;
    while (i < paramMap.length)
    {
      paramMap[i] = new CustomAttributeData((String)paramArrayOfCustomAttributeData[i].getKey(), (String)paramArrayOfCustomAttributeData[i].getValue());
      i += 1;
    }
    return paramMap;
  }
  
  public static void writeNativeCrash(SessionEventData paramSessionEventData, LogFileManager paramLogFileManager, Map<String, String> paramMap, CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    createEventMessage(paramSessionEventData, paramLogFileManager, paramMap).write(paramCodedOutputStream);
  }
  
  private static final class ApplicationMessage
    extends NativeCrashWriter.ProtobufMessage
  {
    public ApplicationMessage(NativeCrashWriter.ExecutionMessage paramExecutionMessage, NativeCrashWriter.RepeatedMessage paramRepeatedMessage)
    {
      super(new NativeCrashWriter.ProtobufMessage[] { paramExecutionMessage, paramRepeatedMessage });
    }
  }
  
  private static final class BinaryImageMessage
    extends NativeCrashWriter.ProtobufMessage
  {
    private final long baseAddr;
    private final String filePath;
    private final long imageSize;
    private final String uuid;
    
    public BinaryImageMessage(BinaryImageData paramBinaryImageData)
    {
      super(new NativeCrashWriter.ProtobufMessage[0]);
      baseAddr = baseAddress;
      imageSize = size;
      filePath = path;
      uuid = id;
    }
    
    public int getPropertiesSize()
    {
      int i = CodedOutputStream.computeUInt64Size(1, baseAddr);
      int j = CodedOutputStream.computeUInt64Size(2, imageSize);
      return CodedOutputStream.computeBytesSize(3, ByteString.copyFromUtf8(filePath)) + i + j + CodedOutputStream.computeBytesSize(4, ByteString.copyFromUtf8(uuid));
    }
    
    public void writeProperties(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      paramCodedOutputStream.writeUInt64(1, baseAddr);
      paramCodedOutputStream.writeUInt64(2, imageSize);
      paramCodedOutputStream.writeBytes(3, ByteString.copyFromUtf8(filePath));
      paramCodedOutputStream.writeBytes(4, ByteString.copyFromUtf8(uuid));
    }
  }
  
  private static final class CustomAttributeMessage
    extends NativeCrashWriter.ProtobufMessage
  {
    private final String key;
    private final String value;
    
    public CustomAttributeMessage(CustomAttributeData paramCustomAttributeData)
    {
      super(new NativeCrashWriter.ProtobufMessage[0]);
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
  
  private static final class DeviceMessage
    extends NativeCrashWriter.ProtobufMessage
  {
    private final float batteryLevel;
    private final int batteryVelocity;
    private final long diskUsed;
    private final int orientation;
    private final boolean proximityOn;
    private final long ramUsed;
    
    public DeviceMessage(float paramFloat, int paramInt1, boolean paramBoolean, int paramInt2, long paramLong1, long paramLong2)
    {
      super(new NativeCrashWriter.ProtobufMessage[0]);
      batteryLevel = paramFloat;
      batteryVelocity = paramInt1;
      proximityOn = paramBoolean;
      orientation = paramInt2;
      ramUsed = paramLong1;
      diskUsed = paramLong2;
    }
    
    public int getPropertiesSize()
    {
      return 0 + CodedOutputStream.computeFloatSize(1, batteryLevel) + CodedOutputStream.computeSInt32Size(2, batteryVelocity) + CodedOutputStream.computeBoolSize(3, proximityOn) + CodedOutputStream.computeUInt32Size(4, orientation) + CodedOutputStream.computeUInt64Size(5, ramUsed) + CodedOutputStream.computeUInt64Size(6, diskUsed);
    }
    
    public void writeProperties(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      paramCodedOutputStream.writeFloat(1, batteryLevel);
      paramCodedOutputStream.writeSInt32(2, batteryVelocity);
      paramCodedOutputStream.writeBool(3, proximityOn);
      paramCodedOutputStream.writeUInt32(4, orientation);
      paramCodedOutputStream.writeUInt64(5, ramUsed);
      paramCodedOutputStream.writeUInt64(6, diskUsed);
    }
  }
  
  private static final class EventMessage
    extends NativeCrashWriter.ProtobufMessage
  {
    private final String crashType;
    private final long time;
    
    public EventMessage(long paramLong, String paramString, NativeCrashWriter.ProtobufMessage... paramVarArgs)
    {
      super(paramVarArgs);
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
  
  private static final class ExecutionMessage
    extends NativeCrashWriter.ProtobufMessage
  {
    public ExecutionMessage(NativeCrashWriter.SignalMessage paramSignalMessage, NativeCrashWriter.RepeatedMessage paramRepeatedMessage1, NativeCrashWriter.RepeatedMessage paramRepeatedMessage2)
    {
      super(new NativeCrashWriter.ProtobufMessage[] { paramRepeatedMessage1, paramSignalMessage, paramRepeatedMessage2 });
    }
  }
  
  private static final class FrameMessage
    extends NativeCrashWriter.ProtobufMessage
  {
    private final long address;
    private final String file;
    private final int importance;
    private final long offset;
    private final String symbol;
    
    public FrameMessage(ThreadData.FrameData paramFrameData)
    {
      super(new NativeCrashWriter.ProtobufMessage[0]);
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
  
  private static final class LogMessage
    extends NativeCrashWriter.ProtobufMessage
  {
    ByteString logBytes;
    
    public LogMessage(ByteString paramByteString)
    {
      super(new NativeCrashWriter.ProtobufMessage[0]);
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
  
  private static final class NullMessage
    extends NativeCrashWriter.ProtobufMessage
  {
    public NullMessage()
    {
      super(new NativeCrashWriter.ProtobufMessage[0]);
    }
    
    public void write(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {}
  }
  
  private static abstract class ProtobufMessage
  {
    private final ProtobufMessage[] children;
    private final int tag;
    
    public ProtobufMessage(int paramInt, ProtobufMessage... paramVarArgs)
    {
      tag = paramInt;
      if (paramVarArgs != null) {}
      for (;;)
      {
        children = paramVarArgs;
        return;
        paramVarArgs = NativeCrashWriter.EMPTY_CHILDREN;
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
  
  private static final class RepeatedMessage
    extends NativeCrashWriter.ProtobufMessage
  {
    private final NativeCrashWriter.ProtobufMessage[] messages;
    
    public RepeatedMessage(NativeCrashWriter.ProtobufMessage... paramVarArgs)
    {
      super(new NativeCrashWriter.ProtobufMessage[0]);
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
  
  private static final class SignalMessage
    extends NativeCrashWriter.ProtobufMessage
  {
    private final long sigAddr;
    private final String sigCode;
    private final String sigName;
    
    public SignalMessage(SignalData paramSignalData)
    {
      super(new NativeCrashWriter.ProtobufMessage[0]);
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
  
  private static final class ThreadMessage
    extends NativeCrashWriter.ProtobufMessage
  {
    private final int importance;
    private final String name;
    
    public ThreadMessage(ThreadData paramThreadData, NativeCrashWriter.RepeatedMessage paramRepeatedMessage)
    {
      super(new NativeCrashWriter.ProtobufMessage[] { paramRepeatedMessage });
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
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.NativeCrashWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */