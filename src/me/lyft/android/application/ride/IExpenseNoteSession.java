package me.lyft.android.application.ride;

public abstract interface IExpenseNoteSession
{
  public abstract String getExpenseCode();
  
  public abstract String getExpenseNote();
  
  public abstract String getRideId();
  
  public abstract boolean isConcurEnabled();
  
  public abstract boolean isConcurEnabledForNonBusinessProfileUser();
  
  public abstract void reset();
  
  public abstract void setConcurEnabled(boolean paramBoolean);
  
  public abstract void setExpenseCode(String paramString);
  
  public abstract void setExpenseNote(String paramString);
  
  public abstract void setRideId(String paramString);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.IExpenseNoteSession
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */