package dagger.internal;

import java.util.Iterator;
import java.util.List;

public final class ThrowingErrorHandler
  implements Linker.ErrorHandler
{
  public void handleErrors(List<String> paramList)
  {
    if (paramList.isEmpty()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Errors creating object graph:");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      localStringBuilder.append("\n  ").append(str);
    }
    throw new IllegalStateException(localStringBuilder.toString());
  }
}

/* Location:
 * Qualified Name:     dagger.internal.ThrowingErrorHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */