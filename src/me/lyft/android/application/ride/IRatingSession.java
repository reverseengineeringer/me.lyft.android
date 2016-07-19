package me.lyft.android.application.ride;

import java.util.Set;

public abstract interface IRatingSession
{
  public abstract void addImprovement(String paramString);
  
  public abstract String getFeedback();
  
  public abstract Set<String> getImprovementAreas();
  
  public abstract int getRating();
  
  public abstract String getRideId();
  
  public abstract void removeImprovement(String paramString);
  
  public abstract void reset();
  
  public abstract void setFeedback(String paramString);
  
  public abstract void setImprovementAreas(Set<String> paramSet);
  
  public abstract void setRating(int paramInt);
  
  public abstract void setRideId(String paramString);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.IRatingSession
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */