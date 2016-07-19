package me.lyft.android.application.ride;

import java.util.HashSet;
import java.util.Set;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;
import me.lyft.android.persistence.rating.IRatingStateStorage;

public class RatingSession
  implements IRatingSession
{
  private String feedback;
  private Set<String> improvementAreas;
  private int rating;
  private String rideId;
  private final IRatingStateStorage stateStorage;
  
  public RatingSession(IRatingStateStorage paramIRatingStateStorage)
  {
    stateStorage = paramIRatingStateStorage;
    rideId = ((String)Objects.firstNonNull(paramIRatingStateStorage.getRideId(), ""));
    feedback = ((String)Objects.firstNonNull(paramIRatingStateStorage.getFeedback(), ""));
    rating = paramIRatingStateStorage.getRating();
    improvementAreas = paramIRatingStateStorage.getImprovementAreas();
  }
  
  public void addImprovement(String paramString)
  {
    improvementAreas.add(paramString);
    stateStorage.setImprovementAreas(improvementAreas);
  }
  
  public String getFeedback()
  {
    return feedback;
  }
  
  public Set<String> getImprovementAreas()
  {
    return improvementAreas;
  }
  
  public int getRating()
  {
    return rating;
  }
  
  public String getRideId()
  {
    return rideId;
  }
  
  public void removeImprovement(String paramString)
  {
    improvementAreas.remove(paramString);
    stateStorage.setImprovementAreas(improvementAreas);
  }
  
  public void reset()
  {
    rideId = "";
    feedback = "";
    rating = 0;
    improvementAreas = new HashSet();
    stateStorage.reset();
  }
  
  public void setFeedback(String paramString)
  {
    paramString = Strings.nullToEmpty(paramString);
    feedback = paramString;
    stateStorage.setFeedback(paramString);
  }
  
  public void setImprovementAreas(Set<String> paramSet)
  {
    Object localObject = paramSet;
    if (paramSet == null) {
      localObject = new HashSet();
    }
    improvementAreas = ((Set)localObject);
    stateStorage.setImprovementAreas((Set)localObject);
  }
  
  public void setRating(int paramInt)
  {
    rating = paramInt;
    stateStorage.setRating(paramInt);
  }
  
  public void setRideId(String paramString)
  {
    paramString = Strings.nullToEmpty(paramString);
    rideId = paramString;
    stateStorage.setRideId(paramString);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.RatingSession
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */