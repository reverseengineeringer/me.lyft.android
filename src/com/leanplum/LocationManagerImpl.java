package com.leanplum;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.Geofence.Builder;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationClient.OnAddGeofencesResultListener;
import com.google.android.gms.location.LocationClient.OnRemoveGeofencesResultListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class LocationManagerImpl
  implements GooglePlayServicesClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationClient.OnAddGeofencesResultListener, LocationClient.OnRemoveGeofencesResultListener, ag
{
  static final String METADATA = "com.google.android.gms.version";
  static final String PERMISSION = "android.permission.ACCESS_FINE_LOCATION";
  private static LocationManagerImpl instance;
  private List<Geofence> allGeofences;
  private List<Geofence> backgroundGeofences;
  private boolean isInBackground;
  private Map<String, Object> lastKnownState;
  private LocationClient locationClient;
  private Map<String, Object> stateBeforeBackground;
  private List<String> trackedGeofenceIds = new ArrayList();
  
  private LocationManagerImpl()
  {
    loadLastKnownRegionState();
    isInBackground = Util.j();
  }
  
  private Geofence geofenceFromMap(Map<String, Object> paramMap, String paramString)
  {
    Number localNumber1 = (Number)paramMap.get("lat");
    Number localNumber2 = (Number)paramMap.get("lon");
    Number localNumber3 = (Number)paramMap.get("radius");
    paramMap = (Number)paramMap.get("version");
    if (localNumber1 == null) {
      return null;
    }
    Geofence.Builder localBuilder = new Geofence.Builder();
    localBuilder.setCircularRegion(localNumber1.floatValue(), localNumber2.floatValue(), localNumber3.floatValue());
    localBuilder.setRequestId(geofenceID(paramString, Integer.valueOf(paramMap.intValue())));
    localBuilder.setTransitionTypes(3);
    localBuilder.setExpirationDuration(-1L);
    return localBuilder.build();
  }
  
  private String geofenceID(String paramString, Integer paramInteger)
  {
    return "__leanplum" + paramString + "_" + paramInteger.toString();
  }
  
  private String getRegionName(String paramString)
  {
    if (paramString.startsWith("__leanplum")) {
      return paramString.substring(10, paramString.lastIndexOf("_"));
    }
    return null;
  }
  
  private int getStatusForTransitionType(int paramInt)
  {
    int i = 4;
    if ((paramInt == 1) || (paramInt == 4)) {
      i = 2;
    }
    return i;
  }
  
  private List<Geofence> getToBeTrackedGeofences()
  {
    if (Util.j()) {
      return backgroundGeofences;
    }
    return allGeofences;
  }
  
  private PendingIntent getTransitionPendingIntent()
  {
    Context localContext = Leanplum.a();
    return PendingIntent.getService(localContext, 0, new Intent(localContext, ReceiveTransitionsIntentService.class), 134217728);
  }
  
  public static ag instance()
  {
    try
    {
      if (instance == null) {
        instance = new LocationManagerImpl();
      }
      LocationManagerImpl localLocationManagerImpl = instance;
      return localLocationManagerImpl;
    }
    finally {}
  }
  
  private boolean isMetaDataSet()
  {
    boolean bool2 = false;
    Object localObject = Leanplum.a();
    try
    {
      localObject = ((Context)localObject).getPackageManager().getApplicationInfo(((Context)localObject).getPackageName(), 128);
      boolean bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (metaData != null)
        {
          localObject = metaData.get("com.google.android.gms.version");
          bool1 = bool2;
          if (localObject != null) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return false;
  }
  
  private boolean isPermissionGranted()
  {
    return Leanplum.a().checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
  }
  
  private void loadLastKnownRegionState()
  {
    if (lastKnownState != null) {
      return;
    }
    String str = Leanplum.a().getSharedPreferences("__leanplum__location", 0).getString("regionState", null);
    if (str == null)
    {
      lastKnownState = new HashMap();
      return;
    }
    lastKnownState = a.a(str);
  }
  
  private void maybePerformActions(Geofence paramGeofence, String paramString)
  {
    paramGeofence = getRegionName(paramGeofence.getRequestId());
    if (paramGeofence != null) {
      if (!Util.j()) {
        break label32;
      }
    }
    label32:
    for (int i = 2;; i = 3)
    {
      Leanplum.a(paramString, paramGeofence, i, null, null);
      return;
    }
  }
  
  private void saveLastKnownRegionState()
  {
    if (lastKnownState == null) {
      return;
    }
    SharedPreferences.Editor localEditor = Leanplum.a().getSharedPreferences("__leanplum__location", 0).edit();
    localEditor.putString("regionState", a.a(lastKnownState));
    try
    {
      localEditor.apply();
      return;
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      localEditor.commit();
    }
  }
  
  private void startLocationClient()
  {
    if ((!isPermissionGranted()) || (!isMetaDataSet())) {
      Log.d("Leanplum", "You have to set the application meta data and location permission to use geofencing.");
    }
    do
    {
      return;
      Context localContext = Leanplum.a();
      if (locationClient == null) {
        locationClient = new LocationClient(localContext, this, this);
      }
      if ((!locationClient.isConnected()) && (!locationClient.isConnecting()))
      {
        locationClient.connect();
        return;
      }
    } while (!locationClient.isConnected());
    updateTrackedGeofences();
  }
  
  private void updateTrackedGeofences()
  {
    if (allGeofences == null) {
      return;
    }
    Object localObject1;
    if ((!isInBackground) && (Util.j()))
    {
      stateBeforeBackground = new HashMap();
      localObject1 = lastKnownState.keySet().iterator();
      if (((Iterator)localObject1).hasNext()) {}
    }
    else
    {
      localObject1 = getToBeTrackedGeofences();
      if (trackedGeofenceIds.size() > 0) {
        locationClient.removeGeofences(trackedGeofenceIds, this);
      }
      trackedGeofenceIds = new ArrayList();
      if (((List)localObject1).size() > 0)
      {
        locationClient.addGeofences((List)localObject1, getTransitionPendingIntent(), this);
        localObject1 = ((List)localObject1).iterator();
      }
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext())
      {
        if ((isInBackground) && (!Util.j())) {
          stateBeforeBackground = null;
        }
        isInBackground = Util.j();
        return;
        localObject2 = (String)((Iterator)localObject1).next();
        stateBeforeBackground.put(localObject2, lastKnownState.get(localObject2));
        break;
      }
      Object localObject2 = (Geofence)((Iterator)localObject1).next();
      trackedGeofenceIds.add(((Geofence)localObject2).getRequestId());
      if ((isInBackground) && (!Util.j()) && (stateBeforeBackground != null))
      {
        Number localNumber1 = (Number)stateBeforeBackground.get(((Geofence)localObject2).getRequestId());
        Number localNumber2 = (Number)lastKnownState.get(((Geofence)localObject2).getRequestId());
        if ((localNumber2 != null) && (localNumber1 != null))
        {
          if (a.a(localNumber1, localNumber2)) {
            maybePerformActions((Geofence)localObject2, "enterRegion");
          }
          if (a.b(localNumber1, localNumber2)) {
            maybePerformActions((Geofence)localObject2, "exitRegion");
          }
        }
      }
    }
  }
  
  public void onAddGeofencesResult(int paramInt, String[] paramArrayOfString) {}
  
  public void onConnected(Bundle paramBundle)
  {
    updateTrackedGeofences();
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    paramConnectionResult.hasResolution();
  }
  
  public void onDisconnected()
  {
    locationClient = null;
    locationClient = new LocationClient(Leanplum.a(), this, this);
    if ((!locationClient.isConnected()) && (!locationClient.isConnecting())) {
      locationClient.connect();
    }
  }
  
  public void onRemoveGeofencesByPendingIntentResult(int paramInt, PendingIntent paramPendingIntent) {}
  
  public void onRemoveGeofencesByRequestIdsResult(int paramInt, String[] paramArrayOfString) {}
  
  public void setRegionsData(Map<String, Object> paramMap, Set<String> paramSet1, Set<String> paramSet2)
  {
    if (!Util.i()) {
      return;
    }
    allGeofences = new ArrayList();
    backgroundGeofences = new ArrayList();
    Iterator localIterator = paramMap.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        startLocationClient();
        return;
      }
      Object localObject = (String)localIterator.next();
      boolean bool1 = paramSet1.contains(localObject);
      boolean bool2 = paramSet2.contains(localObject);
      if ((bool1) || (bool2))
      {
        localObject = geofenceFromMap((Map)paramMap.get(localObject), (String)localObject);
        if (localObject != null)
        {
          if (bool2) {
            backgroundGeofences.add(localObject);
          }
          allGeofences.add(localObject);
          if (lastKnownState.get(((Geofence)localObject).getRequestId()) == null) {
            lastKnownState.put(((Geofence)localObject).getRequestId(), Integer.valueOf(1));
          }
        }
      }
    }
  }
  
  public void updateGeofencing()
  {
    if ((allGeofences != null) && (backgroundGeofences != null)) {
      startLocationClient();
    }
  }
  
  public void updateStatusForGeofences(List<Geofence> paramList, int paramInt)
  {
    paramList = paramList.iterator();
    for (;;)
    {
      if (!paramList.hasNext())
      {
        saveLastKnownRegionState();
        return;
      }
      Geofence localGeofence = (Geofence)paramList.next();
      Object localObject;
      if ((!trackedGeofenceIds.contains(localGeofence.getRequestId())) && (localGeofence.getRequestId().startsWith("__leanplum")))
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add(localGeofence.getRequestId());
        if ((locationClient != null) && (locationClient.isConnected())) {
          locationClient.removeGeofences((List)localObject, this);
        }
      }
      else
      {
        localObject = (Number)lastKnownState.get(localGeofence.getRequestId());
        if (localObject != null)
        {
          if (a.a((Number)localObject, Integer.valueOf(getStatusForTransitionType(paramInt)))) {
            maybePerformActions(localGeofence, "enterRegion");
          }
          if (a.b((Number)localObject, Integer.valueOf(getStatusForTransitionType(paramInt)))) {
            maybePerformActions(localGeofence, "exitRegion");
          }
        }
        lastKnownState.put(localGeofence.getRequestId(), Integer.valueOf(getStatusForTransitionType(paramInt)));
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.leanplum.LocationManagerImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */