package me.lyft.android.infrastructure.googlegeo.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class DistanceMatrixRowDTO
{
  @SerializedName("elements")
  public final ArrayList<DistanceMatrixElementDTO> elements;
  
  public DistanceMatrixRowDTO(ArrayList<DistanceMatrixElementDTO> paramArrayList)
  {
    elements = paramArrayList;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.googlegeo.model.DistanceMatrixRowDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */