package bo.app;

import com.appboy.models.IPutIntoJson;
import java.util.Locale;

public enum ai
  implements IPutIntoJson<String>
{
  private ai() {}
  
  public final String a()
  {
    return toString().toLowerCase(Locale.US);
  }
}

/* Location:
 * Qualified Name:     bo.app.ai
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */