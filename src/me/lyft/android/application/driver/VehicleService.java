package me.lyft.android.application.driver;

import com.lyft.android.api.dto.UpdateVehicleRequestDTO;
import com.lyft.android.api.dto.VehicleDocumentsDTO;
import com.lyft.android.api.dto.VehiclesDTO;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.common.Iterables;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.driver.Vehicle;
import me.lyft.android.domain.driver.Vehicle.Status;
import me.lyft.android.domain.driver.VehiclesMapper;
import me.lyft.android.domain.driverdocuments.DriverDocumentsMapper;
import me.lyft.android.domain.driverdocuments.Inspection;
import me.lyft.android.domain.driverdocuments.Insurance;
import me.lyft.android.domain.driverdocuments.Registration;
import me.lyft.android.infrastructure.environment.IS3Api;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Func1;

public class VehicleService
  implements IVehicleService
{
  private IS3Api IS3Api;
  private ILyftApi lyftApi;
  private Vehicle updatedVehicle;
  
  public VehicleService(ILyftApi paramILyftApi, IS3Api paramIS3Api)
  {
    lyftApi = paramILyftApi;
    IS3Api = paramIS3Api;
  }
  
  public Observable<Vehicle> activateDriverVehicle(final String paramString)
  {
    lyftApi.activateDriverVehicle(paramString).map(new Func1()
    {
      public Vehicle call(VehiclesDTO paramAnonymousVehiclesDTO)
      {
        paramAnonymousVehiclesDTO = VehiclesMapper.fromDriverVehiclesDto(paramAnonymousVehiclesDTO).iterator();
        while (paramAnonymousVehiclesDTO.hasNext())
        {
          Vehicle localVehicle = (Vehicle)paramAnonymousVehiclesDTO.next();
          if (paramString.equals(localVehicle.getId())) {
            return localVehicle;
          }
        }
        return Vehicle.empty();
      }
    });
  }
  
  public Observable<List<Vehicle>> getDriverVehicles()
  {
    lyftApi.getDriverVehicles().map(new Func1()
    {
      public List<Vehicle> call(VehiclesDTO paramAnonymousVehiclesDTO)
      {
        VehicleService.access$002(VehicleService.this, Vehicle.empty());
        return VehiclesMapper.fromDriverVehiclesDto(paramAnonymousVehiclesDTO);
      }
    });
  }
  
  public Observable<Vehicle> getInUseOrFirstVehicle()
  {
    getDriverVehicles().map(new Func1()
    {
      public Vehicle call(List<Vehicle> paramAnonymousList)
      {
        Iterator localIterator = paramAnonymousList.iterator();
        while (localIterator.hasNext())
        {
          Vehicle localVehicle = (Vehicle)localIterator.next();
          if (Vehicle.Status.SELECTED.equals(localVehicle.getStatus())) {
            return localVehicle;
          }
        }
        return (Vehicle)Iterables.firstOrDefault(paramAnonymousList, Vehicle.empty());
      }
    });
  }
  
  public Vehicle getUpdatedVehicle()
  {
    return (Vehicle)Objects.firstNonNull(updatedVehicle, Vehicle.empty());
  }
  
  public Observable<Vehicle> getVehicleById(String paramString)
  {
    getDriverVehicles().map(new Func1()
    {
      public Vehicle call(List<Vehicle> paramAnonymousList)
      {
        Iterator localIterator = paramAnonymousList.iterator();
        while (localIterator.hasNext())
        {
          Vehicle localVehicle = (Vehicle)localIterator.next();
          if (localVehicle.getId().equals(localVehicle.getId())) {
            return localVehicle;
          }
        }
        return (Vehicle)Iterables.firstOrDefault(paramAnonymousList, Vehicle.empty());
      }
    });
  }
  
  public Observable<Vehicle> updateInspection(final String paramString, final Inspection paramInspection, final File paramFile)
  {
    IS3Api.uploadFile(paramInspection.getPhotoUploadUrl(), paramFile).flatMap(new Func1()
    {
      public Observable<VehiclesDTO> call(Unit paramAnonymousUnit)
      {
        paramAnonymousUnit = new VehicleDocumentsDTO(null, DriverDocumentsMapper.fromInspection(paramInspection), null);
        return lyftApi.updateDriverVehicleDocuments(paramString, new UpdateVehicleRequestDTO(paramAnonymousUnit));
      }
    }).map(new Func1()
    {
      public Vehicle call(VehiclesDTO paramAnonymousVehiclesDTO)
      {
        paramAnonymousVehiclesDTO = VehiclesMapper.fromDriverVehiclesDto(paramAnonymousVehiclesDTO).iterator();
        while (paramAnonymousVehiclesDTO.hasNext())
        {
          Vehicle localVehicle = (Vehicle)paramAnonymousVehiclesDTO.next();
          if (localVehicle.getId().equals(paramString))
          {
            VehicleService.access$002(VehicleService.this, localVehicle);
            updatedVehicle.getInspection().setPhotoFile(paramFile);
            return localVehicle;
          }
        }
        return Vehicle.empty();
      }
    });
  }
  
  public Observable<Vehicle> updateInsurance(final String paramString, final Insurance paramInsurance, final File paramFile)
  {
    IS3Api.uploadFile(paramInsurance.getPhotoUploadUrl(), paramFile).flatMap(new Func1()
    {
      public Observable<VehiclesDTO> call(Unit paramAnonymousUnit)
      {
        paramAnonymousUnit = new VehicleDocumentsDTO(DriverDocumentsMapper.fromInsurance(paramInsurance), null, null);
        return lyftApi.updateDriverVehicleDocuments(paramString, new UpdateVehicleRequestDTO(paramAnonymousUnit));
      }
    }).map(new Func1()
    {
      public Vehicle call(VehiclesDTO paramAnonymousVehiclesDTO)
      {
        paramAnonymousVehiclesDTO = VehiclesMapper.fromDriverVehiclesDto(paramAnonymousVehiclesDTO).iterator();
        while (paramAnonymousVehiclesDTO.hasNext())
        {
          Vehicle localVehicle = (Vehicle)paramAnonymousVehiclesDTO.next();
          if (localVehicle.getId().equals(paramString))
          {
            VehicleService.access$002(VehicleService.this, localVehicle);
            updatedVehicle.getInsurance().setPhotoFile(paramFile);
            return localVehicle;
          }
        }
        return Vehicle.empty();
      }
    });
  }
  
  public Observable<Vehicle> updateRegistration(final String paramString, final Registration paramRegistration, final File paramFile)
  {
    IS3Api.uploadFile(paramRegistration.getPhotoUploadUrl(), paramFile).flatMap(new Func1()
    {
      public Observable<VehiclesDTO> call(Unit paramAnonymousUnit)
      {
        paramAnonymousUnit = new VehicleDocumentsDTO(null, null, DriverDocumentsMapper.fromRegistration(paramRegistration));
        return lyftApi.updateDriverVehicleDocuments(paramString, new UpdateVehicleRequestDTO(paramAnonymousUnit));
      }
    }).map(new Func1()
    {
      public Vehicle call(VehiclesDTO paramAnonymousVehiclesDTO)
      {
        paramAnonymousVehiclesDTO = VehiclesMapper.fromDriverVehiclesDto(paramAnonymousVehiclesDTO).iterator();
        while (paramAnonymousVehiclesDTO.hasNext())
        {
          Vehicle localVehicle = (Vehicle)paramAnonymousVehiclesDTO.next();
          if (localVehicle.getId().equals(paramString))
          {
            VehicleService.access$002(VehicleService.this, localVehicle);
            updatedVehicle.getRegistration().setPhotoFile(paramFile);
            return localVehicle;
          }
        }
        return Vehicle.empty();
      }
    });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.VehicleService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */