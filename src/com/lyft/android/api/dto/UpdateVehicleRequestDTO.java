package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class UpdateVehicleRequestDTO
{
  @SerializedName("documents")
  public final VehicleDocumentsDTO documents;
  
  public UpdateVehicleRequestDTO(VehicleDocumentsDTO paramVehicleDocumentsDTO)
  {
    documents = paramVehicleDocumentsDTO;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class UpdateVehicleRequestDTO {\n");
    localStringBuilder.append("  documents: ").append(documents).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.UpdateVehicleRequestDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */