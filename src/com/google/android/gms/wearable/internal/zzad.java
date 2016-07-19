package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzad
  implements DataItem
{
  private byte[] YX;
  private Map<String, DataItemAsset> aKB;
  private Uri mUri;
  
  public zzad(DataItem paramDataItem)
  {
    mUri = paramDataItem.getUri();
    YX = paramDataItem.getData();
    HashMap localHashMap = new HashMap();
    paramDataItem = paramDataItem.getAssets().entrySet().iterator();
    while (paramDataItem.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramDataItem.next();
      if (localEntry.getKey() != null) {
        localHashMap.put((String)localEntry.getKey(), (DataItemAsset)((DataItemAsset)localEntry.getValue()).freeze());
      }
    }
    aKB = Collections.unmodifiableMap(localHashMap);
  }
  
  public Map<String, DataItemAsset> getAssets()
  {
    return aKB;
  }
  
  public byte[] getData()
  {
    return YX;
  }
  
  public Uri getUri()
  {
    return mUri;
  }
  
  public String toString()
  {
    return toString(Log.isLoggable("DataItem", 3));
  }
  
  public String toString(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("DataItemEntity{ ");
    Object localObject1 = String.valueOf(mUri);
    localStringBuilder.append(String.valueOf(localObject1).length() + 4 + "uri=" + (String)localObject1);
    if (YX == null) {}
    for (localObject1 = "null";; localObject1 = Integer.valueOf(YX.length))
    {
      localObject1 = String.valueOf(localObject1);
      localStringBuilder.append(String.valueOf(localObject1).length() + 9 + ", dataSz=" + (String)localObject1);
      int i = aKB.size();
      localStringBuilder.append(23 + ", numAssets=" + i);
      if ((!paramBoolean) || (aKB.isEmpty())) {
        break label325;
      }
      localStringBuilder.append(", assets=[");
      Iterator localIterator = aKB.entrySet().iterator();
      for (localObject1 = ""; localIterator.hasNext(); localObject1 = ", ")
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject2).getKey();
        localObject2 = String.valueOf(((DataItemAsset)((Map.Entry)localObject2).getValue()).getId());
        localStringBuilder.append(String.valueOf(localObject1).length() + 2 + String.valueOf(str).length() + String.valueOf(localObject2).length() + (String)localObject1 + str + ": " + (String)localObject2);
      }
    }
    localStringBuilder.append("]");
    label325:
    localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }
  
  public DataItem zzcjb()
  {
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.zzad
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */