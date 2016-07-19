package me.lyft.android.infrastructure.lyft.features;

import me.lyft.android.infrastructure.lyft.constants.BooleanConstant;

public class FeatureFlag
  extends BooleanConstant
{
  private final String createdDate;
  private final String description;
  private Boolean override;
  private final String storyUrl;
  
  public FeatureFlag(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    super(paramString1, Boolean.valueOf(paramBoolean));
    storyUrl = paramString2;
    createdDate = paramString3;
    description = paramString4;
  }
  
  public String getDate()
  {
    return createdDate;
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public Boolean getOverride()
  {
    return override;
  }
  
  public String getStoryUrl()
  {
    return storyUrl;
  }
  
  public boolean hasManualOverride()
  {
    return override != null;
  }
  
  void override(boolean paramBoolean)
  {
    override = Boolean.valueOf(paramBoolean);
  }
  
  void resetOverride()
  {
    override = null;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.lyft.features.FeatureFlag
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */