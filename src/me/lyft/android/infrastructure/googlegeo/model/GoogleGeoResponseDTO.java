package me.lyft.android.infrastructure.googlegeo.model;

import me.lyft.android.common.Objects;

public abstract class GoogleGeoResponseDTO
{
  public static final String INVALID_REQUEST = "INVALID_REQUEST";
  public static final String OK = "OK";
  public static final String OVER_QUERY_LIMIT = "OVER_QUERY_LIMIT";
  public static final String ZERO_RESULTS = "ZERO_RESULTS";
  
  public abstract String getStatus();
  
  public boolean hasResults()
  {
    return !Objects.equals(getStatus(), "ZERO_RESULTS");
  }
  
  public boolean isOK()
  {
    return Objects.equals(getStatus(), "OK");
  }
  
  public boolean isOverQueryLimit()
  {
    return Objects.equals(getStatus(), "OVER_QUERY_LIMIT");
  }
  
  public boolean isValidRequest()
  {
    return !Objects.equals(getStatus(), "INVALID_REQUEST");
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.googlegeo.model.GoogleGeoResponseDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */