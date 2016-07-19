package dagger.internal;

public abstract class ProvidesBinding<T>
  extends Binding<T>
{
  protected final String methodName;
  protected final String moduleClass;
  
  public ProvidesBinding(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    super(paramString1, null, paramBoolean, paramString2 + "." + paramString3 + "()");
    moduleClass = paramString2;
    methodName = paramString3;
  }
  
  public abstract T get();
  
  public String toString()
  {
    return getClass().getName() + "[key=" + provideKey + " method=" + moduleClass + "." + methodName + "()" + "]";
  }
}

/* Location:
 * Qualified Name:     dagger.internal.ProvidesBinding
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */