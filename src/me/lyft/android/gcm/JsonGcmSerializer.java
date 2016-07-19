package me.lyft.android.gcm;

import java.util.Map;
import me.lyft.android.common.Strings;
import me.lyft.android.infrastructure.json.IJsonSerializer;

public class JsonGcmSerializer
  implements IGcmSerializer
{
  private final IJsonSerializer jsonSerializer;
  
  public JsonGcmSerializer(IJsonSerializer paramIJsonSerializer)
  {
    jsonSerializer = paramIJsonSerializer;
  }
  
  public <T> T deserialize(Map<String, String> paramMap, String paramString, Class<T> paramClass, T paramT)
  {
    paramMap = (String)paramMap.get(paramString);
    if (!Strings.isNullOrEmpty(paramMap))
    {
      paramMap = jsonSerializer.fromJson(paramMap, paramClass);
      if (paramMap != null) {
        return paramMap;
      }
    }
    return paramT;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.gcm.JsonGcmSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */