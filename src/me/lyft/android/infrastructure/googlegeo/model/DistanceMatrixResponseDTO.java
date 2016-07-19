package me.lyft.android.infrastructure.googlegeo.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class DistanceMatrixResponseDTO
  extends GoogleGeoResponseDTO
{
  public static final String OK = "OK";
  public static final String OVER_QUERY_LIMIT = "OVER_QUERY_LIMIT";
  @SerializedName("rows")
  public final ArrayList<DistanceMatrixRowDTO> rows;
  @SerializedName("status")
  public final String status;
  
  public DistanceMatrixResponseDTO(ArrayList<DistanceMatrixRowDTO> paramArrayList, String paramString)
  {
    rows = paramArrayList;
    status = paramString;
  }
  
  public String getStatus()
  {
    return status;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.googlegeo.model.DistanceMatrixResponseDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */