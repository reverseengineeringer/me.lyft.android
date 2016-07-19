package dagger.internal;

final class Binding$1
  extends Binding<Object>
{
  Binding$1(String paramString1, String paramString2, boolean paramBoolean, Object paramObject)
  {
    super(paramString1, paramString2, paramBoolean, paramObject);
  }
  
  public Object get()
  {
    throw new AssertionError("Unresolved binding should never be called to inject.");
  }
  
  public void injectMembers(Object paramObject)
  {
    throw new AssertionError("Unresolved binding should never be called to inject.");
  }
}

/* Location:
 * Qualified Name:     dagger.internal.Binding.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */