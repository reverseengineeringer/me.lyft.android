package bo.app;

import com.appboy.models.IPutIntoJson;
import java.util.UUID;

public final class db
  implements IPutIntoJson<String>
{
  final UUID a;
  
  private db(UUID paramUUID)
  {
    a = paramUUID;
  }
  
  public static db a()
  {
    return new db(UUID.randomUUID());
  }
  
  public static db a(String paramString)
  {
    return new db(UUID.fromString(paramString));
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (db)paramObject;
    return a.equals(a);
  }
  
  public final int hashCode()
  {
    return a.hashCode();
  }
  
  public final String toString()
  {
    return a.toString();
  }
}

/* Location:
 * Qualified Name:     bo.app.db
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */