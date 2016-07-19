package bolts;

import java.util.Locale;

public class CancellationToken
{
  private final CancellationTokenSource tokenSource;
  
  public boolean isCancellationRequested()
  {
    return tokenSource.isCancellationRequested();
  }
  
  public String toString()
  {
    return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[] { getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(tokenSource.isCancellationRequested()) });
  }
}

/* Location:
 * Qualified Name:     bolts.CancellationToken
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */