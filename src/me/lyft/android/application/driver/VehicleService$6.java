package me.lyft.android.application.driver;

import com.lyft.android.api.dto.UpdateVehicleRequestDTO;
import com.lyft.android.api.dto.VehicleDocumentsDTO;
import com.lyft.android.api.dto.VehiclesDTO;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.driverdocuments.DriverDocumentsMapper;
import me.lyft.android.domain.driverdocuments.Insurance;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Func1;

class VehicleService$6
  implements Func1<Unit, Observable<VehiclesDTO>>
{
  VehicleService$6(VehicleService paramVehicleService, Insurance paramInsurance, String paramString) {}
  
  public Observable<VehiclesDTO> call(Unit paramUnit)
  {
    paramUnit = new VehicleDocumentsDTO(DriverDocumentsMapper.fromInsurance(val$insurance), null, null);
    return VehicleService.access$100(this$0).updateDriverVehicleDocuments(val$vehicleId, new UpdateVehicleRequestDTO(paramUnit));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.VehicleService.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */