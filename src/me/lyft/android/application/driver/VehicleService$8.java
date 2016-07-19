package me.lyft.android.application.driver;

import com.lyft.android.api.dto.UpdateVehicleRequestDTO;
import com.lyft.android.api.dto.VehicleDocumentsDTO;
import com.lyft.android.api.dto.VehiclesDTO;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.driverdocuments.DriverDocumentsMapper;
import me.lyft.android.domain.driverdocuments.Inspection;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Func1;

class VehicleService$8
  implements Func1<Unit, Observable<VehiclesDTO>>
{
  VehicleService$8(VehicleService paramVehicleService, Inspection paramInspection, String paramString) {}
  
  public Observable<VehiclesDTO> call(Unit paramUnit)
  {
    paramUnit = new VehicleDocumentsDTO(null, DriverDocumentsMapper.fromInspection(val$inspection), null);
    return VehicleService.access$100(this$0).updateDriverVehicleDocuments(val$vehicleId, new UpdateVehicleRequestDTO(paramUnit));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.VehicleService.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */