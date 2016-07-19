package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.zzaep;
import com.google.android.gms.internal.zzaep.zza;
import com.google.android.gms.internal.zzaeq;
import com.google.android.gms.internal.zzapb;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataMapItem
{
  private final DataMap aJc;
  private final Uri mUri;
  
  private DataMapItem(DataItem paramDataItem)
  {
    mUri = paramDataItem.getUri();
    aJc = zza((DataItem)paramDataItem.freeze());
  }
  
  public static DataMapItem fromDataItem(DataItem paramDataItem)
  {
    if (paramDataItem == null) {
      throw new IllegalStateException("provided dataItem is null");
    }
    return new DataMapItem(paramDataItem);
  }
  
  private DataMap zza(DataItem paramDataItem)
  {
    if ((paramDataItem.getData() == null) && (paramDataItem.getAssets().size() > 0)) {
      throw new IllegalArgumentException("Cannot create DataMapItem from a DataItem  that wasn't made with DataMapItem.");
    }
    if (paramDataItem.getData() == null) {
      return new DataMap();
    }
    try
    {
      localObject1 = new ArrayList();
      j = paramDataItem.getAssets().size();
      i = 0;
    }
    catch (zzapb localzzapb)
    {
      for (;;)
      {
        Object localObject1;
        int j;
        int i;
        Object localObject2 = String.valueOf(paramDataItem.getUri());
        String str = String.valueOf(Base64.encodeToString(paramDataItem.getData(), 0));
        Log.w("DataItem", String.valueOf(localObject2).length() + 50 + String.valueOf(str).length() + "Unable to parse datamap from dataItem. uri=" + (String)localObject2 + ", data=" + str);
        paramDataItem = String.valueOf(paramDataItem.getUri());
        throw new IllegalStateException(String.valueOf(paramDataItem).length() + 44 + "Unable to parse datamap from dataItem.  uri=" + paramDataItem, localzzapb);
        localzzapb.add(Asset.createFromRef(((DataItemAsset)localObject2).getId()));
        i += 1;
      }
      DataMap localDataMap = zzaep.zza(new zzaep.zza(zzaeq.zzar(paramDataItem.getData()), localzzapb));
      return localDataMap;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;) {}
    }
    if (i < j)
    {
      localObject2 = (DataItemAsset)paramDataItem.getAssets().get(Integer.toString(i));
      if (localObject2 == null)
      {
        localObject1 = String.valueOf(paramDataItem);
        throw new IllegalStateException(String.valueOf(localObject1).length() + 64 + "Cannot find DataItemAsset referenced in data at " + i + " for " + (String)localObject1);
      }
    }
  }
  
  public DataMap getDataMap()
  {
    return aJc;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.DataMapItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */