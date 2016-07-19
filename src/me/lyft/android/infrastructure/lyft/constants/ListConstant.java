package me.lyft.android.infrastructure.lyft.constants;

import java.util.List;
import me.lyft.android.logging.L;

@Deprecated
public class ListConstant<T>
  extends Constant<List<T>>
{
  public ListConstant(String paramString, List<T> paramList)
  {
    super(paramString, paramList);
  }
  
  public List<T> safeCast(Object paramObject)
  {
    if (paramObject != null) {
      try
      {
        List localList = (List)paramObject;
        return localList;
      }
      catch (ClassCastException localClassCastException)
      {
        L.e(localClassCastException, "Wrong type (" + paramObject.getClass() + ") received for constant (" + getKey() + ")", new Object[0]);
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.lyft.constants.ListConstant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */