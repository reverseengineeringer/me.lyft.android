package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class VehicleDocumentsDTO
{
  @SerializedName("inspection")
  public final DriverDocumentDTO inspection;
  @SerializedName("insurance")
  public final DriverDocumentDTO insurance;
  @SerializedName("registration")
  public final DriverDocumentDTO registration;
  
  public VehicleDocumentsDTO(DriverDocumentDTO paramDriverDocumentDTO1, DriverDocumentDTO paramDriverDocumentDTO2, DriverDocumentDTO paramDriverDocumentDTO3)
  {
    insurance = paramDriverDocumentDTO1;
    inspection = paramDriverDocumentDTO2;
    registration = paramDriverDocumentDTO3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class VehicleDocumentsDTO {\n");
    localStringBuilder.append("  insurance: ").append(insurance).append("\n");
    localStringBuilder.append("  inspection: ").append(inspection).append("\n");
    localStringBuilder.append("  registration: ").append(registration).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.VehicleDocumentsDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */