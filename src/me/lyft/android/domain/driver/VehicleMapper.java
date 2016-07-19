package me.lyft.android.domain.driver;

import com.lyft.android.api.dto.VehicleDTO;
import com.lyft.android.api.dto.VehicleDocumentsDTO;
import me.lyft.android.common.Objects;
import me.lyft.android.domain.driverdocuments.DriverDocumentsMapper;
import me.lyft.android.domain.driverdocuments.Inspection;
import me.lyft.android.domain.driverdocuments.Insurance;
import me.lyft.android.domain.driverdocuments.Registration;

public class VehicleMapper
{
  public static Vehicle fromVehicleDTO(VehicleDTO paramVehicleDTO)
  {
    if (paramVehicleDTO == null) {
      return Vehicle.empty();
    }
    return new Vehicle((String)Objects.firstNonNull(id, Vehicle.empty().getId()), (String)Objects.firstNonNull(photo, Vehicle.empty().getPhoto()), (String)Objects.firstNonNull(color, Vehicle.empty().getColor()), (String)Objects.firstNonNull(make, Vehicle.empty().getMake()), (String)Objects.firstNonNull(model, Vehicle.empty().getModel()), (Integer)Objects.firstNonNull(year, Vehicle.empty().getYear()), (String)Objects.firstNonNull(state, Vehicle.empty().getState()), (String)Objects.firstNonNull(licensePlate, Vehicle.empty().getLicensePlate()), (String)Objects.firstNonNull(displayName, Vehicle.empty().getDisplayName()), fromVehicleDtoStatus(status), (String)Objects.firstNonNull(statusText, Vehicle.empty().getStatusText()), (Insurance)Objects.firstNonNull(DriverDocumentsMapper.fromInsuranceDTO(documents.insurance), Vehicle.empty().getInsurance()), (Inspection)Objects.firstNonNull(DriverDocumentsMapper.fromInspectionDTO(documents.inspection), Vehicle.empty().getInspection()), (Registration)Objects.firstNonNull(DriverDocumentsMapper.fromRegistrationDTO(documents.registration), Vehicle.empty().getRegistration()), "");
  }
  
  private static Vehicle.Status fromVehicleDtoStatus(String paramString)
  {
    if (paramString == null) {
      return Vehicle.Status.NONE;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return Vehicle.Status.NONE;
        if (paramString.equals("selected"))
        {
          i = 0;
          continue;
          if (paramString.equals("approved"))
          {
            i = 1;
            continue;
            if (paramString.equals("pending"))
            {
              i = 2;
              continue;
              if (paramString.equals("update")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    return Vehicle.Status.SELECTED;
    return Vehicle.Status.APPROVED;
    return Vehicle.Status.PENDING;
    return Vehicle.Status.UPDATE;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.VehicleMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */