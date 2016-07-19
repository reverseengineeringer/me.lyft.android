package bolts;

public class ExecutorException
  extends RuntimeException
{
  public ExecutorException(Exception paramException)
  {
    super("An exception was thrown by an Executor", paramException);
  }
}

/* Location:
 * Qualified Name:     bolts.ExecutorException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */