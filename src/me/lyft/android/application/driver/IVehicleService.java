package me.lyft.android.application.driver;

import java.io.File;
import java.util.List;
import me.lyft.android.domain.driver.Vehicle;
import me.lyft.android.domain.driverdocuments.Inspection;
import me.lyft.android.domain.driverdocuments.Insurance;
import me.lyft.android.domain.driverdocuments.Registration;
import rx.Observable;

public abstract interface IVehicleService
{
  public abstract Observable<Vehicle> activateDriverVehicle(String paramString);
  
  public abstract Observable<List<Vehicle>> getDriverVehicles();
  
  public abstract Observable<Vehicle> getInUseOrFirstVehicle();
  
  public abstract Vehicle getUpdatedVehicle();
  
  public abstract Observable<Vehicle> getVehicleById(String paramString);
  
  public abstract Observable<Vehicle> updateInspection(String paramString, Inspection paramInspection, File paramFile);
  
  public abstract Observable<Vehicle> updateInsurance(String paramString, Insurance paramInsurance, File paramFile);
  
  public abstract Observable<Vehicle> updateRegistration(String paramString, Registration paramRegistration, File paramFile);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.IVehicleService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */