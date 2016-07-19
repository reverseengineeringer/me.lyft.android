package bo.app;

import com.appboy.models.IPutIntoJson;

public final class dc
  implements IPutIntoJson<String>
{
  private final String a;
  
  public dc(String paramString)
  {
    a = paramString;
  }
  
  public final String toString()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     bo.app.dc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */