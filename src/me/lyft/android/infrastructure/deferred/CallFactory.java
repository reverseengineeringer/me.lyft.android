package me.lyft.android.infrastructure.deferred;

import com.squareup.tape.FileObjectQueue.Converter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import me.lyft.android.infrastructure.json.IJsonSerializer;

class CallFactory
  implements FileObjectQueue.Converter<IDeferredCall>
{
  private static final int TARGET_TAG_LENGTH = 42;
  private final IJsonSerializer jsonSerializer;
  private final Map<String, Class<? extends IDeferredCall>> mappings;
  
  CallFactory(Map<String, Class<? extends IDeferredCall>> paramMap, IJsonSerializer paramIJsonSerializer)
  {
    mappings = Collections.unmodifiableMap(paramMap);
    jsonSerializer = paramIJsonSerializer;
  }
  
  private Class<? extends IDeferredCall> getCallClass(String paramString)
  {
    Iterator localIterator = mappings.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((String)localEntry.getKey()).startsWith(paramString)) {
        return (Class)localEntry.getValue();
      }
    }
    return IDeferredCall.class;
  }
  
  private String getTag(IDeferredCall paramIDeferredCall)
  {
    Iterator localIterator = mappings.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((Class)localEntry.getValue()).equals(paramIDeferredCall.getClass())) {
        return (String)localEntry.getKey();
      }
    }
    return "";
  }
  
  static String normalizeTag(String paramString)
  {
    return String.format("%-42s", new Object[] { paramString }).substring(0, 42);
  }
  
  public IDeferredCall from(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new String(paramArrayOfByte);
    Class localClass = getCallClass(paramArrayOfByte.substring(0, 42).trim());
    return (IDeferredCall)jsonSerializer.fromJson(paramArrayOfByte.substring(42), localClass);
  }
  
  public void toStream(IDeferredCall paramIDeferredCall, OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream = new OutputStreamWriter(paramOutputStream);
    paramOutputStream.write(normalizeTag(getTag(paramIDeferredCall)));
    paramOutputStream.write(jsonSerializer.toJson(paramIDeferredCall));
    paramOutputStream.close();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.deferred.CallFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */