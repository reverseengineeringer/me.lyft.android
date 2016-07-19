package dagger.internal;

import java.util.List;

public abstract interface Linker$ErrorHandler
{
  public static final ErrorHandler NULL = new ErrorHandler()
  {
    public void handleErrors(List<String> paramAnonymousList) {}
  };
  
  public abstract void handleErrors(List<String> paramList);
}

/* Location:
 * Qualified Name:     dagger.internal.Linker.ErrorHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */