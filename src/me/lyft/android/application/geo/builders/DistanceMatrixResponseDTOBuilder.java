package me.lyft.android.application.geo.builders;

import java.util.ArrayList;
import me.lyft.android.infrastructure.googlegeo.model.DistanceMatrixResponseDTO;
import me.lyft.android.infrastructure.googlegeo.model.DistanceMatrixRowDTO;

public class DistanceMatrixResponseDTOBuilder
{
  private ArrayList<DistanceMatrixRowDTO> rows;
  private String status;
  
  public DistanceMatrixResponseDTO build()
  {
    return new DistanceMatrixResponseDTO(rows, status);
  }
  
  public DistanceMatrixResponseDTOBuilder setRows(ArrayList<DistanceMatrixRowDTO> paramArrayList)
  {
    rows = paramArrayList;
    return this;
  }
  
  public DistanceMatrixResponseDTOBuilder setStatus(String paramString)
  {
    status = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.builders.DistanceMatrixResponseDTOBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */