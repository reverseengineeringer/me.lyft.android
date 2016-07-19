package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

public class AppInfoDTO
{
  @SerializedName("assetsUrl")
  public final String assetsUrl;
  @SerializedName("constants")
  public final Map<String, Object> constants;
  @SerializedName("hints")
  public final List<HintDTO> hints;
  @SerializedName("revision")
  public final String revision;
  @SerializedName("rideTypes")
  public final List<RideTypeMetaDTO> rideTypes;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class AppInfoDTO {\n");
    localStringBuilder.append("  revision: ").append(revision).append("\n");
    localStringBuilder.append("  assetsUrl: ").append(assetsUrl).append("\n");
    localStringBuilder.append("  rideTypes: ").append(rideTypes).append("\n");
    localStringBuilder.append("  hints: ").append(hints).append("\n");
    localStringBuilder.append("  constants: ").append(constants).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.AppInfoDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */