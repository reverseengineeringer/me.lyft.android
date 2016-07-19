package bolts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class Task<TResult>
{
  public static final ExecutorService BACKGROUND_EXECUTOR = ;
  private static final Executor IMMEDIATE_EXECUTOR = BoltsExecutors.immediate();
  private static Task<?> TASK_CANCELLED = new Task(true);
  private static Task<Boolean> TASK_FALSE;
  private static Task<?> TASK_NULL;
  private static Task<Boolean> TASK_TRUE;
  public static final Executor UI_THREAD_EXECUTOR = AndroidExecutors.uiThread();
  private static volatile UnobservedExceptionHandler unobservedExceptionHandler;
  private boolean cancelled;
  private boolean complete;
  private List<Continuation<TResult, Void>> continuations = new ArrayList();
  private Exception error;
  private boolean errorHasBeenObserved;
  private final Object lock = new Object();
  private TResult result;
  private UnobservedErrorNotifier unobservedErrorNotifier;
  
  static
  {
    TASK_NULL = new Task(null);
    TASK_TRUE = new Task(Boolean.valueOf(true));
    TASK_FALSE = new Task(Boolean.valueOf(false));
  }
  
  Task() {}
  
  private Task(TResult paramTResult)
  {
    trySetResult(paramTResult);
  }
  
  private Task(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      trySetCancelled();
      return;
    }
    trySetResult(null);
  }
  
  public static <TResult> Task<TResult> cancelled()
  {
    return TASK_CANCELLED;
  }
  
  private static <TContinuationResult, TResult> void completeAfterTask(final TaskCompletionSource<TContinuationResult> paramTaskCompletionSource, final Continuation<TResult, Task<TContinuationResult>> paramContinuation, final Task<TResult> paramTask, Executor paramExecutor, CancellationToken paramCancellationToken)
  {
    try
    {
      paramExecutor.execute(new Runnable()
      {
        public void run()
        {
          if ((val$ct != null) && (val$ct.isCancellationRequested()))
          {
            paramTaskCompletionSource.setCancelled();
            return;
          }
          try
          {
            Task localTask = (Task)paramContinuation.then(paramTask);
            if (localTask == null)
            {
              paramTaskCompletionSource.setResult(null);
              return;
            }
          }
          catch (CancellationException localCancellationException)
          {
            paramTaskCompletionSource.setCancelled();
            return;
            localCancellationException.continueWith(new Continuation()
            {
              public Void then(Task<TContinuationResult> paramAnonymous2Task)
              {
                if ((val$ct != null) && (val$ct.isCancellationRequested()))
                {
                  val$tcs.setCancelled();
                  return null;
                }
                if (paramAnonymous2Task.isCancelled())
                {
                  val$tcs.setCancelled();
                  return null;
                }
                if (paramAnonymous2Task.isFaulted())
                {
                  val$tcs.setError(paramAnonymous2Task.getError());
                  return null;
                }
                val$tcs.setResult(paramAnonymous2Task.getResult());
                return null;
              }
            });
            return;
          }
          catch (Exception localException)
          {
            paramTaskCompletionSource.setError(localException);
          }
        }
      });
      return;
    }
    catch (Exception paramContinuation)
    {
      paramTaskCompletionSource.setError(new ExecutorException(paramContinuation));
    }
  }
  
  private static <TContinuationResult, TResult> void completeImmediately(final TaskCompletionSource<TContinuationResult> paramTaskCompletionSource, final Continuation<TResult, TContinuationResult> paramContinuation, final Task<TResult> paramTask, Executor paramExecutor, CancellationToken paramCancellationToken)
  {
    try
    {
      paramExecutor.execute(new Runnable()
      {
        public void run()
        {
          if ((val$ct != null) && (val$ct.isCancellationRequested()))
          {
            paramTaskCompletionSource.setCancelled();
            return;
          }
          try
          {
            Object localObject = paramContinuation.then(paramTask);
            paramTaskCompletionSource.setResult(localObject);
            return;
          }
          catch (CancellationException localCancellationException)
          {
            paramTaskCompletionSource.setCancelled();
            return;
          }
          catch (Exception localException)
          {
            paramTaskCompletionSource.setError(localException);
          }
        }
      });
      return;
    }
    catch (Exception paramContinuation)
    {
      paramTaskCompletionSource.setError(new ExecutorException(paramContinuation));
    }
  }
  
  public static <TResult> Task<TResult>.TaskCompletionSource create()
  {
    Task localTask = new Task();
    localTask.getClass();
    return new TaskCompletionSource();
  }
  
  public static <TResult> Task<TResult> forError(Exception paramException)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    localTaskCompletionSource.setError(paramException);
    return localTaskCompletionSource.getTask();
  }
  
  public static <TResult> Task<TResult> forResult(TResult paramTResult)
  {
    if (paramTResult == null) {
      return TASK_NULL;
    }
    if ((paramTResult instanceof Boolean))
    {
      if (((Boolean)paramTResult).booleanValue()) {
        return TASK_TRUE;
      }
      return TASK_FALSE;
    }
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    localTaskCompletionSource.setResult(paramTResult);
    return localTaskCompletionSource.getTask();
  }
  
  public static UnobservedExceptionHandler getUnobservedExceptionHandler()
  {
    return unobservedExceptionHandler;
  }
  
  private void runContinuations()
  {
    for (;;)
    {
      Continuation localContinuation;
      synchronized (lock)
      {
        Iterator localIterator = continuations.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localContinuation = (Continuation)localIterator.next();
      }
      try
      {
        localContinuation.then(this);
      }
      catch (RuntimeException localRuntimeException)
      {
        throw localRuntimeException;
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
    }
    continuations = null;
  }
  
  public <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> paramContinuation)
  {
    return continueWith(paramContinuation, IMMEDIATE_EXECUTOR, null);
  }
  
  public <TContinuationResult> Task<TContinuationResult> continueWith(final Continuation<TResult, TContinuationResult> paramContinuation, final Executor paramExecutor, final CancellationToken paramCancellationToken)
  {
    final TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    synchronized (lock)
    {
      boolean bool = isCompleted();
      if (!bool) {
        continuations.add(new Continuation()
        {
          public Void then(Task<TResult> paramAnonymousTask)
          {
            Task.completeImmediately(localTaskCompletionSource, paramContinuation, paramAnonymousTask, paramExecutor, paramCancellationToken);
            return null;
          }
        });
      }
      if (bool) {
        completeImmediately(localTaskCompletionSource, paramContinuation, this, paramExecutor, paramCancellationToken);
      }
      return localTaskCompletionSource.getTask();
    }
  }
  
  public <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> paramContinuation, Executor paramExecutor)
  {
    return continueWithTask(paramContinuation, paramExecutor, null);
  }
  
  public <TContinuationResult> Task<TContinuationResult> continueWithTask(final Continuation<TResult, Task<TContinuationResult>> paramContinuation, final Executor paramExecutor, final CancellationToken paramCancellationToken)
  {
    final TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    synchronized (lock)
    {
      boolean bool = isCompleted();
      if (!bool) {
        continuations.add(new Continuation()
        {
          public Void then(Task<TResult> paramAnonymousTask)
          {
            Task.completeAfterTask(localTaskCompletionSource, paramContinuation, paramAnonymousTask, paramExecutor, paramCancellationToken);
            return null;
          }
        });
      }
      if (bool) {
        completeAfterTask(localTaskCompletionSource, paramContinuation, this, paramExecutor, paramCancellationToken);
      }
      return localTaskCompletionSource.getTask();
    }
  }
  
  public Exception getError()
  {
    synchronized (lock)
    {
      if (error != null)
      {
        errorHasBeenObserved = true;
        if (unobservedErrorNotifier != null)
        {
          unobservedErrorNotifier.setObserved();
          unobservedErrorNotifier = null;
        }
      }
      Exception localException = error;
      return localException;
    }
  }
  
  public TResult getResult()
  {
    synchronized (lock)
    {
      Object localObject2 = result;
      return (TResult)localObject2;
    }
  }
  
  public boolean isCancelled()
  {
    synchronized (lock)
    {
      boolean bool = cancelled;
      return bool;
    }
  }
  
  public boolean isCompleted()
  {
    synchronized (lock)
    {
      boolean bool = complete;
      return bool;
    }
  }
  
  public boolean isFaulted()
  {
    for (;;)
    {
      synchronized (lock)
      {
        if (getError() != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public <TContinuationResult> Task<TContinuationResult> onSuccess(Continuation<TResult, TContinuationResult> paramContinuation)
  {
    return onSuccess(paramContinuation, IMMEDIATE_EXECUTOR, null);
  }
  
  public <TContinuationResult> Task<TContinuationResult> onSuccess(final Continuation<TResult, TContinuationResult> paramContinuation, Executor paramExecutor, final CancellationToken paramCancellationToken)
  {
    continueWithTask(new Continuation()
    {
      public Task<TContinuationResult> then(Task<TResult> paramAnonymousTask)
      {
        if ((paramCancellationToken != null) && (paramCancellationToken.isCancellationRequested())) {
          return Task.cancelled();
        }
        if (paramAnonymousTask.isFaulted()) {
          return Task.forError(paramAnonymousTask.getError());
        }
        if (paramAnonymousTask.isCancelled()) {
          return Task.cancelled();
        }
        return paramAnonymousTask.continueWith(paramContinuation);
      }
    }, paramExecutor);
  }
  
  boolean trySetCancelled()
  {
    synchronized (lock)
    {
      if (complete) {
        return false;
      }
      complete = true;
      cancelled = true;
      lock.notifyAll();
      runContinuations();
      return true;
    }
  }
  
  boolean trySetError(Exception paramException)
  {
    synchronized (lock)
    {
      if (complete) {
        return false;
      }
      complete = true;
      error = paramException;
      errorHasBeenObserved = false;
      lock.notifyAll();
      runContinuations();
      if ((!errorHasBeenObserved) && (getUnobservedExceptionHandler() != null)) {
        unobservedErrorNotifier = new UnobservedErrorNotifier(this);
      }
      return true;
    }
  }
  
  boolean trySetResult(TResult paramTResult)
  {
    synchronized (lock)
    {
      if (complete) {
        return false;
      }
      complete = true;
      result = paramTResult;
      lock.notifyAll();
      runContinuations();
      return true;
    }
  }
  
  public class TaskCompletionSource
    extends TaskCompletionSource<TResult>
  {
    TaskCompletionSource() {}
  }
  
  public static abstract interface UnobservedExceptionHandler
  {
    public abstract void unobservedException(Task<?> paramTask, UnobservedTaskException paramUnobservedTaskException);
  }
}

/* Location:
 * Qualified Name:     bolts.Task
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */