package me.lyft.android.jobs;

public abstract interface Job
{
  public abstract void execute()
    throws Throwable;
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.Job
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */