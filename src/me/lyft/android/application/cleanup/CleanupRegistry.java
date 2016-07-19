package me.lyft.android.application.cleanup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CleanupRegistry
  implements ICleanupRegistry
{
  private List<ICleanable> cleanables = new ArrayList();
  
  public void add(ICleanable paramICleanable)
  {
    cleanables.add(paramICleanable);
  }
  
  public void clearAll()
  {
    Iterator localIterator = cleanables.iterator();
    while (localIterator.hasNext()) {
      ((ICleanable)localIterator.next()).clear();
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.cleanup.CleanupRegistry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */