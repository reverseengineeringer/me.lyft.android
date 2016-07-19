package me.lyft.android;

import com.lyft.android.api.dto.RideDTO;
import com.lyft.android.api.dto.UniversalDTO;
import com.lyft.android.api.dto.UserDTO;
import me.lyft.android.common.Objects;
import me.lyft.android.infrastructure.servertimestamp.IServerTimestampService;
import me.lyft.android.jobs.AppInfoUpdateJob;
import me.lyft.android.jobs.AutoFillLocationJob;
import me.lyft.android.jobs.CourierDriverRideUpdatedJob;
import me.lyft.android.jobs.DriverCloseToCurrentStopJob;
import me.lyft.android.jobs.DriverDailyTotalsJob;
import me.lyft.android.jobs.DriverDestinationJob;
import me.lyft.android.jobs.DriverRideUpdateJob;
import me.lyft.android.jobs.EtaUpdateJob;
import me.lyft.android.jobs.GoogleNowAuthorizationJob;
import me.lyft.android.jobs.JobManager;
import me.lyft.android.jobs.LyftTokenUpdateJob;
import me.lyft.android.jobs.PassengerRideUpdateJob;
import me.lyft.android.jobs.PollingRateChangedJob;
import me.lyft.android.jobs.RideAssignedJob;
import me.lyft.android.jobs.RideProfilesUpdateJob;
import me.lyft.android.jobs.RideStatusChangedJob;
import me.lyft.android.jobs.RideTypesMetaChangedJob;
import me.lyft.android.jobs.ThreatMetrixJob;
import me.lyft.android.jobs.UpdateCarpoolRideRequestsJob;
import me.lyft.android.jobs.UpdateGcmIdentifierJob;
import me.lyft.android.jobs.UpdatePassengerRideReceiptJob;
import me.lyft.android.jobs.UpdateShortcutsJob;
import me.lyft.android.jobs.UpdateSplitFareJob;
import me.lyft.android.jobs.UpdateSplitFareStateJob;
import me.lyft.android.jobs.UserModeChangeJob;
import me.lyft.android.jobs.UserUpdateJob;
import me.lyft.android.logging.L;
import me.lyft.android.threading.IMainThreadChecker;

class UserSession
  implements IUserSession
{
  private final Object appStateChangeLock = new Object();
  private UniversalDTO currentAppState;
  private final JobManager jobManager;
  private final IMainThreadChecker mainThreadChecker;
  private final ILyftPreferences preferences;
  private final IServerTimestampService serverTimestampService;
  
  public UserSession(ILyftPreferences paramILyftPreferences, JobManager paramJobManager, IMainThreadChecker paramIMainThreadChecker, IServerTimestampService paramIServerTimestampService)
  {
    preferences = paramILyftPreferences;
    jobManager = paramJobManager;
    mainThreadChecker = paramIMainThreadChecker;
    serverTimestampService = paramIServerTimestampService;
  }
  
  private boolean shouldRejectAppState(UniversalDTO paramUniversalDTO)
  {
    long l1 = ((Long)Objects.firstNonNull(preDispatchTimestamp, Objects.firstNonNull(timestamp, Long.valueOf(0L)))).longValue();
    long l2 = serverTimestampService.getLastKnownServerTimestampMs();
    if (l1 <= l2) {}
    for (boolean bool = true; bool; bool = false)
    {
      L.w(new IllegalStateException("AppState was rejected due stale timestamp."), "AppState was rejected (pre=%s|ts=%s) <= current=%s", new Object[] { preDispatchTimestamp, Objects.firstNonNull(timestamp, Long.valueOf(0L)), Long.valueOf(l2) });
      return bool;
    }
    serverTimestampService.setLastKnownServerTimestampMs(((Long)Objects.firstNonNull(timestamp, Long.valueOf(0L))).longValue());
    return bool;
  }
  
  UniversalDTO getAppState()
  {
    return currentAppState;
  }
  
  public RideDTO getRide()
  {
    if (currentAppState != null) {
      return currentAppState.ride;
    }
    return null;
  }
  
  public void resetAppState()
  {
    currentAppState = null;
    preferences.setLastCachedAppState(null);
  }
  
  public void restoreAppState()
  {
    UniversalDTO localUniversalDTO = preferences.getLastCachedAppState();
    if (localUniversalDTO != null) {
      setAppState(localUniversalDTO);
    }
  }
  
  boolean setAppState(UniversalDTO paramUniversalDTO)
  {
    mainThreadChecker.checkMainThread();
    if (paramUniversalDTO == null)
    {
      L.w(new IllegalStateException("setAppState cannot have a null app state"), "AppState cannot be null", new Object[0]);
      return false;
    }
    synchronized (appStateChangeLock)
    {
      if (shouldRejectAppState(paramUniversalDTO)) {
        return false;
      }
    }
    UniversalDTO localUniversalDTO = currentAppState;
    currentAppState = paramUniversalDTO;
    if (currentAppState.user != null)
    {
      jobManager.queueImmediateJob(new LyftTokenUpdateJob(currentAppState.user.lyftToken));
      jobManager.queueImmediateJob(new PollingRateChangedJob(currentAppState.user.pollingRate));
      jobManager.queueImmediateJob(new GoogleNowAuthorizationJob(currentAppState.user));
    }
    jobManager.queueImmediateJob(new UserUpdateJob(currentAppState));
    jobManager.queueImmediateJob(new UpdateShortcutsJob(currentAppState));
    if (localUniversalDTO == null) {
      jobManager.queueImmediateJob(new ThreatMetrixJob(currentAppState.user));
    }
    if ((localUniversalDTO != null) && (currentAppState.user != null)) {
      jobManager.queueImmediateJob(new UserModeChangeJob(localUniversalDTO, currentAppState));
    }
    jobManager.queueImmediateJob(new DriverRideUpdateJob(currentAppState));
    if (localUniversalDTO != null)
    {
      jobManager.queueImmediateJob(new RideAssignedJob(ride, currentAppState.ride));
      jobManager.queueImmediateJob(new RideStatusChangedJob(localUniversalDTO, currentAppState));
      jobManager.queueImmediateJob(new CourierDriverRideUpdatedJob(localUniversalDTO, currentAppState));
    }
    if ((currentAppState.user != null) && ("driver".equalsIgnoreCase(currentAppState.user.mode))) {
      jobManager.queueImmediateJob(new DriverCloseToCurrentStopJob());
    }
    jobManager.queueImmediateJob(new DriverDestinationJob(currentAppState));
    jobManager.queueImmediateJob(new EtaUpdateJob(currentAppState));
    jobManager.queueImmediateJob(new PassengerRideUpdateJob(paramUniversalDTO));
    jobManager.queueImmediateJob(new UpdatePassengerRideReceiptJob(currentAppState.ride));
    jobManager.queueBackgroundJob(new UpdateCarpoolRideRequestsJob(localUniversalDTO, currentAppState));
    jobManager.queueImmediateJob(new UpdateSplitFareJob(currentAppState));
    jobManager.queueImmediateJob(new UpdateSplitFareStateJob(currentAppState.ride));
    jobManager.queueImmediateJob(new UpdateGcmIdentifierJob());
    jobManager.queueImmediateJob(new AppInfoUpdateJob(currentAppState.appInfo));
    jobManager.queueImmediateJob(new RideTypesMetaChangedJob(currentAppState));
    jobManager.queueImmediateJob(new AutoFillLocationJob(currentAppState.prefillLocations));
    jobManager.queueImmediateJob(new DriverDailyTotalsJob(currentAppState));
    jobManager.queueImmediateJob(new RideProfilesUpdateJob(currentAppState.ride, currentAppState.user));
    preferences.setLastCachedAppState(currentAppState);
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.UserSession
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */