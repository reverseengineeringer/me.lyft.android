package bo.app;

public final class ff
{
  public static <Source, Target> Target a(Source paramSource, Class<Target> paramClass)
  {
    if (paramClass.isAssignableFrom(paramSource.getClass())) {
      return (Target)paramClass.cast(paramSource);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     bo.app.ff
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */