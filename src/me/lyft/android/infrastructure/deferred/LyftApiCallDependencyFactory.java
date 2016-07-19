package me.lyft.android.infrastructure.deferred;

import java.util.Arrays;
import me.lyft.android.infrastructure.lyft.ILyftApi;

public class LyftApiCallDependencyFactory
  implements ICallDependencyFactory
{
  private final ILyftApi lyftApi;
  
  public LyftApiCallDependencyFactory(ILyftApi paramILyftApi)
  {
    lyftApi = paramILyftApi;
  }
  
  public <T> T get(Class<T> paramClass)
  {
    if (ILyftApi.class.equals(paramClass)) {
      return lyftApi;
    }
    throw new IllegalArgumentException("LyftApiCallDependencyFactory only knows about " + Arrays.toString(lyftApi.getClass().getClasses()) + " but was asked for " + paramClass.getName());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.deferred.LyftApiCallDependencyFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */