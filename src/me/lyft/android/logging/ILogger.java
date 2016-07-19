package me.lyft.android.logging;

public abstract interface ILogger
{
  public abstract void d(String paramString, Object... paramVarArgs);
  
  public abstract void d(Throwable paramThrowable, String paramString, Object... paramVarArgs);
  
  public abstract void e(String paramString, Object... paramVarArgs);
  
  public abstract void e(Throwable paramThrowable, String paramString, Object... paramVarArgs);
  
  public abstract void i(String paramString, Object... paramVarArgs);
  
  public abstract void i(Throwable paramThrowable, String paramString, Object... paramVarArgs);
  
  public abstract void v(String paramString, Object... paramVarArgs);
  
  public abstract void v(Throwable paramThrowable, String paramString, Object... paramVarArgs);
  
  public abstract void w(String paramString, Object... paramVarArgs);
  
  public abstract void w(Throwable paramThrowable, String paramString, Object... paramVarArgs);
}

/* Location:
 * Qualified Name:     me.lyft.android.logging.ILogger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */