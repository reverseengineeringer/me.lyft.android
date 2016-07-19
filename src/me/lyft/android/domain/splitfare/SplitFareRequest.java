package me.lyft.android.domain.splitfare;

import com.google.gson.annotations.SerializedName;
import me.lyft.android.common.Strings;

public class SplitFareRequest
{
  private static final SplitFareRequest EMPTY = new SplitFareRequest("", "", "", false);
  @SerializedName("id")
  private final String id;
  @SerializedName("initiatorName")
  private final String initiatorName;
  @SerializedName("initiatorPhoto")
  private final String initiatorPhoto;
  @SerializedName("pending")
  private final boolean pending;
  
  public SplitFareRequest(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    id = paramString1;
    initiatorName = paramString2;
    initiatorPhoto = paramString3;
    pending = paramBoolean;
  }
  
  public static SplitFareRequest empty()
  {
    return EMPTY;
  }
  
  public String getId()
  {
    return Strings.nullToEmpty(id);
  }
  
  public String getInitiatorName()
  {
    return Strings.nullToEmpty(initiatorName);
  }
  
  public String getInitiatorPhoto()
  {
    return Strings.nullToEmpty(initiatorPhoto);
  }
  
  public boolean isPending()
  {
    return pending;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.splitfare.SplitFareRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */