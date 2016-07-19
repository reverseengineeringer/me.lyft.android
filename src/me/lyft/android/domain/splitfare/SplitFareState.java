package me.lyft.android.domain.splitfare;

import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;

public class SplitFareState
{
  private static final SplitFareState EMPTY = new SplitFareState(0, Collections.emptyList());
  @SerializedName("acceptedContributorsCount")
  private final int acceptedContributorsCount;
  @SerializedName("invitedPhones")
  private final List<String> invitedPhones;
  
  public SplitFareState(int paramInt, List<String> paramList)
  {
    acceptedContributorsCount = paramInt;
    invitedPhones = paramList;
  }
  
  public static SplitFareState empty()
  {
    return EMPTY;
  }
  
  private List<String> getInvitedPhones()
  {
    return (List)Objects.firstNonNull(invitedPhones, Collections.emptyList());
  }
  
  public int getAcceptedContributorsCount()
  {
    return acceptedContributorsCount;
  }
  
  public int getInvitedContributorsCount()
  {
    return getInvitedPhones().size();
  }
  
  public int getTotalContributorsCount()
  {
    return acceptedContributorsCount + 1;
  }
  
  public boolean hasPhoneNumberBeenInvited(String paramString)
  {
    if (Strings.isNullOrEmpty(paramString)) {}
    String str;
    do
    {
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        return false;
        localIterator = getInvitedPhones().iterator();
      }
      str = (String)localIterator.next();
    } while ((!str.contains(paramString)) && (!paramString.contains(str)));
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.splitfare.SplitFareState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */