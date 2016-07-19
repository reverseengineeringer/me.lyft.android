package me.lyft.android.infrastructure.lyft;

import com.lyft.android.api.dto.AppInfoDTO;
import com.lyft.android.api.dto.CarpoolRideDeclineRequestDTO;
import com.lyft.android.api.dto.CarpoolRidesResponseDTO;
import com.lyft.android.api.dto.ChargeAccountRequestDTO;
import com.lyft.android.api.dto.ChargeAccountsResponseDTO;
import com.lyft.android.api.dto.ClientPermissionsRequestDTO;
import com.lyft.android.api.dto.ContributorUpdateRequestDTO;
import com.lyft.android.api.dto.CostEstimateResponseDTO;
import com.lyft.android.api.dto.CouponTemplateDTO;
import com.lyft.android.api.dto.CreateExpressPayAccountDTO;
import com.lyft.android.api.dto.DriverApplicationDTO;
import com.lyft.android.api.dto.DriverApplicationDataDTO;
import com.lyft.android.api.dto.DriverDestinationRequestDTO;
import com.lyft.android.api.dto.DriverProfileDTO;
import com.lyft.android.api.dto.DriverStatsDTO;
import com.lyft.android.api.dto.EtaEstimateResponseDTO;
import com.lyft.android.api.dto.ExpressPayAccountDTO;
import com.lyft.android.api.dto.ExpressPayDTO;
import com.lyft.android.api.dto.FareSplitInviteRequestDTO;
import com.lyft.android.api.dto.GhostrideRequestDTO;
import com.lyft.android.api.dto.GoogleNowAuthCodeDTO;
import com.lyft.android.api.dto.HeatmapMetaDTO;
import com.lyft.android.api.dto.InviteRequestDTO;
import com.lyft.android.api.dto.LocationDTO;
import com.lyft.android.api.dto.LoginRequestDTO;
import com.lyft.android.api.dto.NearbyDriversResponseDTO;
import com.lyft.android.api.dto.NewsFeedMessagesDTO;
import com.lyft.android.api.dto.NotificationsDTO;
import com.lyft.android.api.dto.OrganizationRequestDTO;
import com.lyft.android.api.dto.PaypalClientTokenDTO;
import com.lyft.android.api.dto.PhoneRequestDTO;
import com.lyft.android.api.dto.PickupGeofenceDTO;
import com.lyft.android.api.dto.PlacesDTO;
import com.lyft.android.api.dto.PresignedPhotoUrlDTO;
import com.lyft.android.api.dto.PresignedPhotoUrlRequestDTO;
import com.lyft.android.api.dto.ReferralInfoDTO;
import com.lyft.android.api.dto.RideHistoryDTO;
import com.lyft.android.api.dto.RideHistoryItemDetailedDTO;
import com.lyft.android.api.dto.RideRequestDTO;
import com.lyft.android.api.dto.RideRequestDetailsDTO;
import com.lyft.android.api.dto.RideTypesResponseDTO;
import com.lyft.android.api.dto.RideUpdateRequestDTO;
import com.lyft.android.api.dto.ScheduledRideAvailableTimesResponseDTO;
import com.lyft.android.api.dto.ScheduledRideDTO;
import com.lyft.android.api.dto.ScheduledRideRequestDTO;
import com.lyft.android.api.dto.ScheduledRideResponseDTO;
import com.lyft.android.api.dto.ShareRouteDTO;
import com.lyft.android.api.dto.ShareRouteRequestDTO;
import com.lyft.android.api.dto.ShortcutDTO;
import com.lyft.android.api.dto.SignedUrlDTO;
import com.lyft.android.api.dto.SignedUrlRequestDTO;
import com.lyft.android.api.dto.UniversalDTO;
import com.lyft.android.api.dto.UpdateLocationRequestDTO;
import com.lyft.android.api.dto.UpdateUserLocationRequestDTO;
import com.lyft.android.api.dto.UpdateUserRequestDTO;
import com.lyft.android.api.dto.UpdateVehicleRequestDTO;
import com.lyft.android.api.dto.UserOrganizationDTO;
import com.lyft.android.api.dto.VehiclesDTO;
import com.lyft.android.api.dto.VenuesDTO;
import com.lyft.android.api.dto.WarmWelcomeDTO;
import com.squareup.okhttp.Request.Builder;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.ridehistory.PassengerRideHistoryType;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Preconditions;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.location.LatLng;
import me.lyft.android.domain.time.TimeRange;
import me.lyft.android.infrastructure.api.IHttpExecutor;
import me.lyft.android.infrastructure.api.IJsonBodySerializer;
import me.lyft.android.infrastructure.api.ILyftApiHeadersProvider;
import me.lyft.android.infrastructure.api.UrlBuilder;
import me.lyft.android.infrastructure.device.IDevice;
import me.lyft.android.infrastructure.googlegeo.model.GoogleDirectionsResponseDTO;
import me.lyft.android.logging.L;
import rx.Observable;
import rx.functions.Action1;

public class LyftApi
  implements ILyftApi
{
  public static final int API_VERSION = 42;
  public static final String UNSUPPORTED_HEADER_ENCONDING = "Unsupported";
  private final ILyftApiHeadersProvider apiHeadersProvider;
  private String apiRoot;
  private final IDevice device;
  private final IAppStateHandler handler;
  private final IHttpExecutor httpExecutor;
  private final IJsonBodySerializer jsonBodySerializer;
  private final ILyftPreferences preferences;
  
  public LyftApi(IHttpExecutor paramIHttpExecutor, IJsonBodySerializer paramIJsonBodySerializer, ILyftPreferences paramILyftPreferences, IDevice paramIDevice, IAppStateHandler paramIAppStateHandler, ILyftApiHeadersProvider paramILyftApiHeadersProvider)
  {
    httpExecutor = paramIHttpExecutor;
    jsonBodySerializer = paramIJsonBodySerializer;
    preferences = paramILyftPreferences;
    device = paramIDevice;
    handler = paramIAppStateHandler;
    apiHeadersProvider = paramILyftApiHeadersProvider;
    apiRoot = paramILyftPreferences.getApiRoot();
  }
  
  private Observable<UniversalDTO> executeAsyncReceiveAppState(Request.Builder paramBuilder)
  {
    httpExecutor.executeAsync(paramBuilder, UniversalDTO.class).doOnNext(new Action1()
    {
      public void call(UniversalDTO paramAnonymousUniversalDTO)
      {
        handler.setAppState(paramAnonymousUniversalDTO);
      }
    });
  }
  
  private UniversalDTO executeReceiveAppState(Request.Builder paramBuilder)
    throws IOException
  {
    paramBuilder = (UniversalDTO)httpExecutor.execute(paramBuilder, UniversalDTO.class);
    handler.setAppState(paramBuilder);
    return paramBuilder;
  }
  
  private String getDefaultApplicationSelf()
  {
    return getApiRoot() + "/api/leads/me";
  }
  
  private Observable<ChargeAccountsResponseDTO> makeDefaultChargeAccount(String paramString, Map<String, Object> paramMap)
  {
    paramMap.put("default", Boolean.valueOf(true));
    return updateChargeAccount(paramString, paramMap);
  }
  
  private Observable<ChargeAccountsResponseDTO> updateChargeAccount(String paramString, Map<String, Object> paramMap)
  {
    Preconditions.checkNotNull(paramMap);
    paramString = createRequest().url(getApiRoot() + "/chargeaccounts/" + paramString).put(jsonBodySerializer.serialize(paramMap));
    return httpExecutor.executeAsync(paramString, ChargeAccountsResponseDTO.class);
  }
  
  public Observable<Unit> acceptDeclineFareSplitRequest(String paramString, ContributorUpdateRequestDTO paramContributorUpdateRequestDTO)
  {
    return executeAsyncReceiveAppState(createRequest().url(getApiRoot() + "/contributors/" + paramString).put(jsonBodySerializer.serialize(paramContributorUpdateRequestDTO))).map(Unit.func1());
  }
  
  public Observable<VehiclesDTO> activateDriverVehicle(String paramString)
  {
    HashMap localHashMap = new HashMap();
    paramString = getApiRoot() + "/vehicles/" + paramString + "/activate";
    paramString = createRequest().url(paramString).post(jsonBodySerializer.serialize(localHashMap));
    return httpExecutor.executeAsync(paramString, VehiclesDTO.class);
  }
  
  public Observable<UniversalDTO> applyCoupon(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("coupon", paramString2);
    paramString2 = createRequest();
    paramString2.url(getApiRoot() + "/users/" + paramString1).put(jsonBodySerializer.serialize(localHashMap));
    return executeAsyncReceiveAppState(paramString2);
  }
  
  public Observable<ScheduledRideResponseDTO> cancelScheduledRide(ScheduledRideDTO paramScheduledRideDTO)
  {
    paramScheduledRideDTO = createRequest().url(getApiRoot() + "/v1/scheduledrides/" + id + "/cancel").post(jsonBodySerializer.emptyBody());
    return httpExecutor.executeAsync(paramScheduledRideDTO, ScheduledRideResponseDTO.class);
  }
  
  public Observable<ChargeAccountsResponseDTO> createChargeAccount(ChargeAccountRequestDTO paramChargeAccountRequestDTO)
  {
    Preconditions.checkNotNull(paramChargeAccountRequestDTO);
    paramChargeAccountRequestDTO = createRequest().url(getApiRoot() + "/chargeaccounts").post(jsonBodySerializer.serialize(paramChargeAccountRequestDTO));
    return httpExecutor.executeAsync(paramChargeAccountRequestDTO, ChargeAccountsResponseDTO.class);
  }
  
  public Observable<ExpressPayAccountDTO> createOrUpdateDebitCard(String paramString, CreateExpressPayAccountDTO paramCreateExpressPayAccountDTO)
  {
    paramString = createRequest().url(getApiRoot() + "/users/" + paramString + "/recipientaccounts").post(jsonBodySerializer.serialize(paramCreateExpressPayAccountDTO));
    return httpExecutor.executeAsync(paramString, ExpressPayAccountDTO.class);
  }
  
  protected Request.Builder createRequest()
  {
    SafeRequestBuilder localSafeRequestBuilder = new SafeRequestBuilder(null);
    Iterator localIterator = apiHeadersProvider.getHeaders().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localSafeRequestBuilder.addHeader((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    return localSafeRequestBuilder;
  }
  
  public Observable<RideRequestDetailsDTO> createRide(RideRequestDTO paramRideRequestDTO)
  {
    String str = new UrlBuilder(getApiRoot() + "/v1/rides").build();
    paramRideRequestDTO = createRequest().url(str).post(jsonBodySerializer.serialize(paramRideRequestDTO));
    return httpExecutor.executeAsync(paramRideRequestDTO, RideRequestDetailsDTO.class);
  }
  
  public Observable<UniversalDTO> createUser(String paramString, LoginRequestDTO paramLoginRequestDTO)
  {
    paramLoginRequestDTO = createRequest().url(getApiRoot() + "/users").post(jsonBodySerializer.serialize(paramLoginRequestDTO));
    if ((Strings.isNullOrEmpty(preferences.getLyftToken())) && (!Strings.isNullOrEmpty(paramString))) {
      paramLoginRequestDTO.addHeader("Authorization", "fbAccessToken " + paramString);
    }
    return executeAsyncReceiveAppState(paramLoginRequestDTO);
  }
  
  public Observable<UserOrganizationDTO> createUserOrganization(OrganizationRequestDTO paramOrganizationRequestDTO)
  {
    paramOrganizationRequestDTO = createRequest().url(getApiRoot() + "/organizations").post(jsonBodySerializer.serialize(paramOrganizationRequestDTO));
    return httpExecutor.executeAsync(paramOrganizationRequestDTO, UserOrganizationDTO.class);
  }
  
  public Observable<UniversalDTO> createUserShortcut(String paramString, ShortcutDTO paramShortcutDTO)
  {
    return executeAsyncReceiveAppState(createRequest().url(getApiRoot() + "/users/" + paramString + "/shortcuts").post(jsonBodySerializer.serialize(paramShortcutDTO)));
  }
  
  public Observable<UniversalDTO> declineCarpoolRides(CarpoolRideDeclineRequestDTO paramCarpoolRideDeclineRequestDTO)
  {
    return executeAsyncReceiveAppState(createRequest().url(getApiRoot() + "/carpoolrides/decline").post(jsonBodySerializer.serialize(paramCarpoolRideDeclineRequestDTO)));
  }
  
  public Observable<ChargeAccountsResponseDTO> deleteChargeAccount(String paramString)
  {
    paramString = createRequest().url(getApiRoot() + "/chargeaccounts/" + paramString).delete();
    return httpExecutor.executeAsync(paramString, ChargeAccountsResponseDTO.class);
  }
  
  public Observable<UniversalDTO> deleteDestinyLocation(String paramString)
  {
    return executeAsyncReceiveAppState(createRequest().url(getApiRoot() + "/users/" + paramString + "/driverdestinations").delete());
  }
  
  public void dropOff(String paramString, RideUpdateRequestDTO paramRideUpdateRequestDTO)
    throws IOException
  {
    Request.Builder localBuilder = createRequest();
    localBuilder.url(getApiRoot() + "/rides/" + paramString).put(jsonBodySerializer.serialize(paramRideUpdateRequestDTO));
    httpExecutor.execute(localBuilder, Unit.class);
  }
  
  public Observable<GoogleDirectionsResponseDTO> fallbackDirections(String paramString)
  {
    paramString = new UrlBuilder(getApiRoot() + "/rides/" + paramString + "/directions").build();
    paramString = createRequest().url(paramString).get();
    return httpExecutor.executeAsync(paramString, GoogleDirectionsResponseDTO.class);
  }
  
  public Observable<SignedUrlDTO> generateSignedUrl(SignedUrlRequestDTO paramSignedUrlRequestDTO)
  {
    paramSignedUrlRequestDTO = createRequest().url(getApiRoot() + "/signedurl").post(jsonBodySerializer.serialize(paramSignedUrlRequestDTO));
    return httpExecutor.executeAsync(paramSignedUrlRequestDTO, SignedUrlDTO.class);
  }
  
  public String getApiRoot()
  {
    return apiRoot;
  }
  
  public Observable<AppInfoDTO> getAppInfo(double paramDouble1, double paramDouble2, String paramString)
  {
    UrlBuilder localUrlBuilder = new UrlBuilder(getApiRoot() + "/appinfo").addQueryParam("matId", preferences.getMatId()).addQueryParam("lat", String.valueOf(paramDouble1)).addQueryParam("lng", String.valueOf(paramDouble2));
    if (!Strings.isNullOrEmpty(paramString)) {
      localUrlBuilder.addQueryParam("deepLink", paramString);
    }
    paramString = localUrlBuilder.build();
    paramString = createRequest().url(paramString).get();
    return httpExecutor.executeAsync(paramString, AppInfoDTO.class);
  }
  
  public Observable<CarpoolRidesResponseDTO> getCarpoolRides()
  {
    Request.Builder localBuilder = createRequest().url(getApiRoot() + "/carpoolrides").get();
    return httpExecutor.executeAsync(localBuilder, CarpoolRidesResponseDTO.class);
  }
  
  public CarpoolRidesResponseDTO getCarpoolRidesSync()
    throws IOException
  {
    Request.Builder localBuilder = createRequest().url(getApiRoot() + "/carpoolrides").get();
    return (CarpoolRidesResponseDTO)httpExecutor.execute(localBuilder, CarpoolRidesResponseDTO.class);
  }
  
  public CostEstimateResponseDTO getCosts(double paramDouble1, double paramDouble2, String paramString1, Double paramDouble3, Double paramDouble4, String paramString2, TimeRange paramTimeRange)
    throws IOException
  {
    UrlBuilder localUrlBuilder = new UrlBuilder(getApiRoot() + "/v1/cost").addQueryParam("start_lat", String.valueOf(paramDouble1)).addQueryParam("start_lng", String.valueOf(paramDouble2)).addQueryParam("show_route_invalid_ridetypes", "true");
    if (!paramTimeRange.isNull())
    {
      localUrlBuilder.addQueryParam("pickup_time_ms", String.valueOf(paramTimeRange.getTimestamp()));
      localUrlBuilder.addQueryParam("pickup_range_ms", String.valueOf(paramTimeRange.getRange()));
    }
    if (!Strings.isNullOrEmpty(paramString1)) {
      localUrlBuilder.addQueryParam("start_address", paramString1);
    }
    if ((paramDouble3 != null) && (paramDouble4 != null)) {
      localUrlBuilder.addQueryParam("end_lat", String.valueOf(paramDouble3)).addQueryParam("end_lng", String.valueOf(paramDouble4));
    }
    if (!Strings.isNullOrEmpty(paramString2)) {
      localUrlBuilder.addQueryParam("end_address", paramString2);
    }
    paramString1 = localUrlBuilder.build();
    paramString1 = createRequest().url(paramString1).get();
    return (CostEstimateResponseDTO)httpExecutor.execute(paramString1, CostEstimateResponseDTO.class);
  }
  
  public Observable<CouponTemplateDTO> getCouponInformation(String paramString)
  {
    paramString = createRequest().url(getApiRoot() + "/v1/coupontemplates/" + paramString).get();
    return httpExecutor.executeAsync(paramString, CouponTemplateDTO.class);
  }
  
  public Observable<DriverApplicationDTO> getDriverApplication()
  {
    Object localObject = getDefaultApplicationSelf();
    localObject = createRequest().url((String)localObject).get();
    return httpExecutor.executeAsync((Request.Builder)localObject, DriverApplicationDTO.class);
  }
  
  public Observable<DriverApplicationDataDTO> getDriverApplicationData()
  {
    Object localObject = getApiRoot() + "/api/application_data/";
    localObject = createRequest().url((String)localObject).get();
    return httpExecutor.executeAsync((Request.Builder)localObject, DriverApplicationDataDTO.class);
  }
  
  public Observable<DriverProfileDTO> getDriverProfile()
  {
    Object localObject = new UrlBuilder(getApiRoot() + "/driverprofile").build();
    localObject = createRequest().url((String)localObject).get();
    return httpExecutor.executeAsync((Request.Builder)localObject, DriverProfileDTO.class);
  }
  
  public Observable<DriverStatsDTO> getDriverStats(String paramString)
  {
    paramString = new UrlBuilder(getApiRoot() + "/users/" + paramString + "/driverstats").build();
    paramString = createRequest().url(paramString).get();
    return httpExecutor.executeAsync(paramString, DriverStatsDTO.class);
  }
  
  public Observable<VehiclesDTO> getDriverVehicles()
  {
    Object localObject = getApiRoot() + "/vehicles";
    localObject = createRequest().url((String)localObject).get();
    return httpExecutor.executeAsync((Request.Builder)localObject, VehiclesDTO.class);
  }
  
  public EtaEstimateResponseDTO getEtaEstimate(double paramDouble1, double paramDouble2)
    throws IOException
  {
    Object localObject = new UrlBuilder(getApiRoot() + "/v1/eta").addQueryParam("lat", String.valueOf(paramDouble1)).addQueryParam("lng", String.valueOf(paramDouble2)).build();
    localObject = createRequest().url((String)localObject).get();
    return (EtaEstimateResponseDTO)httpExecutor.execute((Request.Builder)localObject, EtaEstimateResponseDTO.class);
  }
  
  public Observable<ExpressPayDTO> getExpressPay(String paramString)
  {
    paramString = createRequest().url(getApiRoot() + "/users/" + paramString + "/payout-eligibility").get();
    return httpExecutor.executeAsync(paramString, ExpressPayDTO.class);
  }
  
  public HeatmapMetaDTO getHeatmapPricingSync(double paramDouble1, double paramDouble2)
    throws IOException
  {
    Object localObject = new UrlBuilder(getApiRoot() + "/pricing").addQueryParam("lat", String.valueOf(paramDouble1)).addQueryParam("lng", String.valueOf(paramDouble2)).build();
    localObject = createRequest().url((String)localObject).get();
    return (HeatmapMetaDTO)httpExecutor.execute((Request.Builder)localObject, HeatmapMetaDTO.class);
  }
  
  public Observable<PresignedPhotoUrlDTO> getImageUploadUrl(PresignedPhotoUrlRequestDTO paramPresignedPhotoUrlRequestDTO)
  {
    paramPresignedPhotoUrlRequestDTO = createRequest().url(getApiRoot() + "/images").post(jsonBodySerializer.serialize(paramPresignedPhotoUrlRequestDTO));
    return httpExecutor.executeAsync(paramPresignedPhotoUrlRequestDTO, PresignedPhotoUrlDTO.class);
  }
  
  public NearbyDriversResponseDTO getNearbyDrivers(double paramDouble1, double paramDouble2)
    throws IOException
  {
    Object localObject = new UrlBuilder(getApiRoot() + "/v1/drivers").addQueryParam("lat", String.valueOf(paramDouble1)).addQueryParam("lng", String.valueOf(paramDouble2)).build();
    localObject = createRequest().url((String)localObject).get();
    return (NearbyDriversResponseDTO)httpExecutor.execute((Request.Builder)localObject, NearbyDriversResponseDTO.class);
  }
  
  public Observable<NewsFeedMessagesDTO> getNewsFeedMessages()
  {
    Object localObject = new UrlBuilder(getApiRoot() + "/drivermessages").build();
    localObject = createRequest().url((String)localObject).get();
    return httpExecutor.executeAsync((Request.Builder)localObject, NewsFeedMessagesDTO.class);
  }
  
  public Observable<NotificationsDTO> getNotifications()
  {
    Object localObject = new UrlBuilder(getApiRoot() + "/notifications").addQueryParam("screenWidth", device.getScreenWidth().toString()).addQueryParam("screenHeight", device.getScreenHeight().toString()).addQueryParam("dpi", device.getDensity().toString()).build();
    localObject = createRequest().url((String)localObject).get();
    return httpExecutor.executeAsync((Request.Builder)localObject, NotificationsDTO.class);
  }
  
  public Observable<RideHistoryDTO> getPassengerHistory(int paramInt1, int paramInt2, PassengerRideHistoryType paramPassengerRideHistoryType)
  {
    UrlBuilder localUrlBuilder = new UrlBuilder(getApiRoot() + "/ridehistory").addQueryParam("skip", String.valueOf(paramInt1)).addQueryParam("limit", String.valueOf(paramInt2));
    if (paramPassengerRideHistoryType.equals(PassengerRideHistoryType.BUSINESS)) {
      localUrlBuilder.addQueryParam("isBusinessRide", "true");
    }
    if (paramPassengerRideHistoryType.equals(PassengerRideHistoryType.PERSONAL)) {
      localUrlBuilder.addQueryParam("isBusinessRide", "false");
    }
    paramPassengerRideHistoryType = createRequest().url(localUrlBuilder.build()).get();
    return httpExecutor.executeAsync(paramPassengerRideHistoryType, RideHistoryDTO.class);
  }
  
  public Observable<RideHistoryItemDetailedDTO> getPassengerRideHistoryDetails(String paramString)
  {
    paramString = new UrlBuilder(getApiRoot() + "/ridehistory/" + paramString).build();
    paramString = createRequest().url(paramString).get();
    return httpExecutor.executeAsync(paramString, RideHistoryItemDetailedDTO.class);
  }
  
  public Observable<PaypalClientTokenDTO> getPayPalClientToken(String paramString)
  {
    paramString = createRequest().url(getApiRoot() + "/users/" + paramString + "/paypal").get();
    return httpExecutor.executeAsync(paramString, PaypalClientTokenDTO.class);
  }
  
  public Observable<PickupGeofenceDTO> getPickupGeofence(String paramString)
  {
    return httpExecutor.executeAsync(createRequest().url(getApiRoot() + "/rides/" + paramString + "/pickupgeofence").get(), PickupGeofenceDTO.class);
  }
  
  public Observable<ReferralInfoDTO> getReferral()
  {
    Object localObject = new UrlBuilder(getApiRoot() + "/referral").build();
    localObject = createRequest().url((String)localObject).get();
    return httpExecutor.executeAsync((Request.Builder)localObject, ReferralInfoDTO.class);
  }
  
  public RideTypesResponseDTO getRideTypes(double paramDouble1, double paramDouble2)
    throws IOException
  {
    Object localObject = new UrlBuilder(getApiRoot() + "/v1/ridetypes").addQueryParam("lat", String.valueOf(paramDouble1)).addQueryParam("lng", String.valueOf(paramDouble2)).build();
    localObject = createRequest().url((String)localObject).get();
    return (RideTypesResponseDTO)httpExecutor.execute((Request.Builder)localObject, RideTypesResponseDTO.class);
  }
  
  public Observable<ScheduledRideResponseDTO> getScheduledRides()
  {
    Request.Builder localBuilder = createRequest().url(getApiRoot() + "/v1/scheduledrides").get();
    return httpExecutor.executeAsync(localBuilder, ScheduledRideResponseDTO.class);
  }
  
  public Observable<ScheduledRideAvailableTimesResponseDTO> getScheduledRidesAvailability(String paramString, double paramDouble1, double paramDouble2, Double paramDouble3, Double paramDouble4)
  {
    paramString = new UrlBuilder(getApiRoot() + "/v1/scheduledrideavailability").addQueryParam("start_lat", String.valueOf(paramDouble1)).addQueryParam("start_lng", String.valueOf(paramDouble2)).addQueryParam("ride_type", paramString);
    if ((paramDouble3 != null) && (paramDouble4 != null))
    {
      paramString.addQueryParam("end_lat", String.valueOf(paramDouble3));
      paramString.addQueryParam("end_lng", String.valueOf(paramDouble4));
    }
    paramString = createRequest().url(paramString.build()).get();
    return httpExecutor.executeAsync(paramString, ScheduledRideAvailableTimesResponseDTO.class);
  }
  
  public Observable<ShareRouteDTO> getShareRouteUrl(ShareRouteRequestDTO paramShareRouteRequestDTO)
  {
    paramShareRouteRequestDTO = createRequest().url(getApiRoot() + "/share-route").put(jsonBodySerializer.serialize(paramShareRouteRequestDTO));
    return httpExecutor.executeAsync(paramShareRouteRequestDTO, ShareRouteDTO.class);
  }
  
  public Observable<UserOrganizationDTO> getUserOrganization()
  {
    Request.Builder localBuilder = createRequest().url(getApiRoot() + "/organizations").get();
    return httpExecutor.executeAsync(localBuilder, UserOrganizationDTO.class);
  }
  
  public Observable<VenuesDTO> getVenues(LatLng paramLatLng)
  {
    paramLatLng = new UrlBuilder(getApiRoot() + "/venues").addQueryParam("lat", String.valueOf(paramLatLng.getLat())).addQueryParam("lng", String.valueOf(paramLatLng.getLng())).addQueryParam("type", "pickup").addQueryParam("type", "prohibited").build();
    paramLatLng = createRequest().url(paramLatLng).get();
    return httpExecutor.executeAsync(paramLatLng, VenuesDTO.class);
  }
  
  public Observable<WarmWelcomeDTO> getWarmWelcome(String paramString)
  {
    paramString = new UrlBuilder(getApiRoot() + "/warmwelcome/" + paramString).build();
    paramString = createRequest().url(paramString).get();
    return httpExecutor.executeAsync(paramString, WarmWelcomeDTO.class);
  }
  
  public Observable<ChargeAccountsResponseDTO> loadChargeAccounts()
  {
    Request.Builder localBuilder = createRequest().url(getApiRoot() + "/chargeaccounts").get();
    return httpExecutor.executeAsync(localBuilder, ChargeAccountsResponseDTO.class);
  }
  
  public Observable<Unit> logout(String paramString)
  {
    Request.Builder localBuilder = createRequest();
    localBuilder.url(getApiRoot() + "/users/" + paramString + "/logout").put(jsonBodySerializer.emptyBody());
    return httpExecutor.executeWithoutResultAsync(localBuilder);
  }
  
  public Observable<ChargeAccountsResponseDTO> makeCardDefault(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("clientPaymentMethod", "card");
    return makeDefaultChargeAccount(paramString, localHashMap);
  }
  
  public Observable<ChargeAccountsResponseDTO> makeChargeAccountDefault(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("default", Boolean.valueOf(true));
    return updateChargeAccount(paramString, localHashMap);
  }
  
  public Observable<ChargeAccountsResponseDTO> makeChargeAccountDefaultBusiness(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("defaultBusiness", Boolean.valueOf(true));
    return updateChargeAccount(paramString, localHashMap);
  }
  
  public Observable<ChargeAccountsResponseDTO> makeCreditLineDefault(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("clientPaymentMethod", "creditLine");
    return makeDefaultChargeAccount(paramString, localHashMap);
  }
  
  public Observable<ChargeAccountsResponseDTO> makeFacebookDefault(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("clientPaymentMethod", "facebook");
    return makeDefaultChargeAccount(paramString, localHashMap);
  }
  
  public Observable<ChargeAccountsResponseDTO> makePayPalDefault(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("chargeToken", paramString2);
    return makeDefaultChargeAccount(paramString1, localHashMap);
  }
  
  public Observable<ChargeAccountsResponseDTO> makeWalletDefault(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("clientPaymentMethod", "googleWallet");
    return makeDefaultChargeAccount(paramString, localHashMap);
  }
  
  public Observable<ChargeAccountsResponseDTO> payDebtWithCreditCard(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("clientPaymentMethod", "card");
    return updateChargeAccount(paramString, localHashMap);
  }
  
  public Observable<ChargeAccountsResponseDTO> payDebtWithPayPal(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("chargeToken", paramString2);
    return updateChargeAccount(paramString1, localHashMap);
  }
  
  public Observable<ChargeAccountsResponseDTO> payDebtWithWallet(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("clientPaymentMethod", "googleWallet");
    return updateChargeAccount(paramString, localHashMap);
  }
  
  public Observable<PlacesDTO> placeSearch(String paramString, LocationDTO paramLocationDTO)
  {
    paramString = new UrlBuilder(getApiRoot() + "/places/placesearch").addQueryParam("query", paramString).addQueryParam("lat", String.valueOf(((Double)Objects.firstNonNull(lat, Double.valueOf(0.0D))).doubleValue())).addQueryParam("lng", String.valueOf(((Double)Objects.firstNonNull(lng, Double.valueOf(0.0D))).doubleValue())).build();
    paramString = createRequest().url(paramString).get();
    return httpExecutor.executeAsync(paramString, PlacesDTO.class);
  }
  
  public void ratePassenger(String paramString, RideUpdateRequestDTO paramRideUpdateRequestDTO)
    throws IOException
  {
    Request.Builder localBuilder = createRequest();
    localBuilder.url(getApiRoot() + "/rides/" + paramString).put(jsonBodySerializer.serialize(paramRideUpdateRequestDTO));
    httpExecutor.execute(localBuilder, Unit.class);
  }
  
  public Observable<UniversalDTO> refreshFacebookAuthToken(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("fbToken", paramString2);
    return executeAsyncReceiveAppState(createRequest().url(getApiRoot() + "/users/" + paramString1 + "/facebook").post(jsonBodySerializer.serialize(localHashMap)));
  }
  
  public Observable<Unit> requestPhoneAuthentication(PhoneRequestDTO paramPhoneRequestDTO)
  {
    paramPhoneRequestDTO = createRequest().url(getApiRoot() + "/phoneauth").post(jsonBodySerializer.serialize(paramPhoneRequestDTO));
    return httpExecutor.executeWithoutResultAsync(paramPhoneRequestDTO);
  }
  
  public Observable<ScheduledRideDTO> scheduleRide(ScheduledRideRequestDTO paramScheduledRideRequestDTO)
  {
    paramScheduledRideRequestDTO = createRequest().url(getApiRoot() + "/v1/scheduledrides").post(jsonBodySerializer.serialize(paramScheduledRideRequestDTO));
    return httpExecutor.executeAsync(paramScheduledRideRequestDTO, ScheduledRideDTO.class);
  }
  
  public Observable<Unit> sendEnterpriseInvites(InviteRequestDTO paramInviteRequestDTO)
  {
    paramInviteRequestDTO = createRequest().url(getApiRoot() + "/invites").post(jsonBodySerializer.serialize(paramInviteRequestDTO));
    return httpExecutor.executeWithoutResultAsync(paramInviteRequestDTO);
  }
  
  public Observable<Unit> sendFareSplitInvites(FareSplitInviteRequestDTO paramFareSplitInviteRequestDTO)
  {
    return executeAsyncReceiveAppState(createRequest().url(getApiRoot() + "/contributors").post(jsonBodySerializer.serialize(paramFareSplitInviteRequestDTO))).map(Unit.func1());
  }
  
  public Observable<Unit> sendInvites(InviteRequestDTO paramInviteRequestDTO)
  {
    paramInviteRequestDTO = createRequest().url(getApiRoot() + "/invites").post(jsonBodySerializer.serialize(paramInviteRequestDTO));
    return httpExecutor.executeWithoutResultAsync(paramInviteRequestDTO);
  }
  
  public void setApiRoot(String paramString)
  {
    apiRoot = paramString;
  }
  
  public Observable<UniversalDTO> startCouchRide(GhostrideRequestDTO paramGhostrideRequestDTO)
  {
    return executeAsyncReceiveAppState(createRequest().url(getApiRoot() + "/ghostride").post(jsonBodySerializer.serialize(paramGhostrideRequestDTO)));
  }
  
  public Observable<Unit> submitPayout(String paramString)
  {
    HashMap localHashMap = new HashMap();
    paramString = createRequest().url(getApiRoot() + "/users/" + paramString + "/payout").post(jsonBodySerializer.serialize(localHashMap));
    return httpExecutor.executeWithoutResultAsync(paramString);
  }
  
  public Observable<PlacesDTO> topDestinations(LocationDTO paramLocationDTO)
  {
    UrlBuilder localUrlBuilder = new UrlBuilder(getApiRoot() + "/destinations");
    if (paramLocationDTO != null) {
      localUrlBuilder.addQueryParam("lat", lat.toString()).addQueryParam("lng", lng.toString());
    }
    paramLocationDTO = localUrlBuilder.build();
    paramLocationDTO = createRequest().url(paramLocationDTO).get();
    return httpExecutor.executeAsync(paramLocationDTO, PlacesDTO.class);
  }
  
  public Observable<UniversalDTO> unlinkConcur(String paramString)
  {
    HashMap localHashMap = new HashMap();
    return executeAsyncReceiveAppState(createRequest().url(getApiRoot() + "/users/" + paramString + "/concur/unlink").put(jsonBodySerializer.serialize(localHashMap)));
  }
  
  public Observable<ChargeAccountsResponseDTO> updateChargeAccount(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", paramString2);
    return updateChargeAccount(paramString1, localHashMap);
  }
  
  public Observable<Unit> updateCoarseLocation(UpdateLocationRequestDTO paramUpdateLocationRequestDTO)
  {
    Request.Builder localBuilder = createRequest();
    localBuilder.url(getApiRoot() + "/locations/").post(jsonBodySerializer.serialize(paramUpdateLocationRequestDTO));
    return httpExecutor.executeWithoutResultAsync(localBuilder);
  }
  
  public Observable<UniversalDTO> updateConcurSendRideReceipts(String paramString, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("concurEnabled", Boolean.valueOf(paramBoolean));
    return executeAsyncReceiveAppState(createRequest().url(getApiRoot() + "/users/" + paramString).post(jsonBodySerializer.serialize(localHashMap)));
  }
  
  public Observable<UniversalDTO> updateDestinyLocation(String paramString, DriverDestinationRequestDTO paramDriverDestinationRequestDTO)
  {
    return executeAsyncReceiveAppState(createRequest().url(getApiRoot() + "/users/" + paramString + "/driverdestinations").put(jsonBodySerializer.serialize(paramDriverDestinationRequestDTO)));
  }
  
  public Observable<DriverApplicationDTO> updateDriverApplication(DriverApplicationDTO paramDriverApplicationDTO)
  {
    if (self != null) {}
    for (String str = self;; str = getDefaultApplicationSelf())
    {
      paramDriverApplicationDTO = createRequest().url(str).put(jsonBodySerializer.serialize(paramDriverApplicationDTO));
      return httpExecutor.executeAsync(paramDriverApplicationDTO, DriverApplicationDTO.class);
    }
  }
  
  public Observable<Unit> updateDriverProfile(DriverProfileDTO paramDriverProfileDTO)
  {
    paramDriverProfileDTO = createRequest().url(getApiRoot() + "/driverprofile/").put(jsonBodySerializer.serialize(paramDriverProfileDTO));
    return httpExecutor.executeWithoutResultAsync(paramDriverProfileDTO);
  }
  
  public Observable<VehiclesDTO> updateDriverVehicleDocuments(String paramString, UpdateVehicleRequestDTO paramUpdateVehicleRequestDTO)
  {
    paramString = createRequest().url(getApiRoot() + "/vehicles/" + paramString).put(jsonBodySerializer.serialize(paramUpdateVehicleRequestDTO));
    return httpExecutor.executeAsync(paramString, VehiclesDTO.class);
  }
  
  public Observable<Unit> updateGoogleAuthToken(String paramString, GoogleNowAuthCodeDTO paramGoogleNowAuthCodeDTO)
  {
    paramString = createRequest().url(getApiRoot() + "/users/" + paramString + "/now").put(jsonBodySerializer.serialize(paramGoogleNowAuthCodeDTO));
    return httpExecutor.executeWithoutResultAsync(paramString);
  }
  
  public Observable<Unit> updateLocationPermissions(ClientPermissionsRequestDTO paramClientPermissionsRequestDTO)
  {
    paramClientPermissionsRequestDTO = createRequest().url(getApiRoot() + "/clientpermissions/").put(jsonBodySerializer.serialize(paramClientPermissionsRequestDTO));
    return httpExecutor.executeWithoutResultAsync(paramClientPermissionsRequestDTO);
  }
  
  public UniversalDTO updateLocationSync(String paramString, UpdateUserLocationRequestDTO paramUpdateUserLocationRequestDTO)
    throws Throwable
  {
    if (Strings.isNullOrEmpty(paramString)) {
      throw new NullPointerException("userId cannot be null");
    }
    return executeReceiveAppState(createRequest().url(getApiRoot() + "/users/" + paramString + "/location").put(jsonBodySerializer.serialize(paramUpdateUserLocationRequestDTO)));
  }
  
  public Observable<UniversalDTO> updateRide(String paramString, RideUpdateRequestDTO paramRideUpdateRequestDTO)
  {
    Request.Builder localBuilder = createRequest();
    localBuilder.url(getApiRoot() + "/rides/" + paramString).put(jsonBodySerializer.serialize(paramRideUpdateRequestDTO));
    return executeAsyncReceiveAppState(localBuilder);
  }
  
  public Observable<UniversalDTO> updateUser(String paramString, UpdateUserRequestDTO paramUpdateUserRequestDTO)
  {
    Request.Builder localBuilder = createRequest();
    localBuilder.url(getApiRoot() + "/users/" + paramString).put(jsonBodySerializer.serialize(paramUpdateUserRequestDTO));
    return executeAsyncReceiveAppState(localBuilder);
  }
  
  public UniversalDTO updateUserSync(String paramString, UpdateUserRequestDTO paramUpdateUserRequestDTO)
    throws Throwable
  {
    return executeReceiveAppState(createRequest().url(getApiRoot() + "/users/" + paramString).put(jsonBodySerializer.serialize(paramUpdateUserRequestDTO)));
  }
  
  private static class SafeRequestBuilder
    extends Request.Builder
  {
    public Request.Builder addHeader(String paramString1, String paramString2)
    {
      try
      {
        super.addHeader(paramString1, paramString2);
        return this;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException = localIllegalArgumentException;
        L.e("Unsupported exception in header: %s with value: %s", new Object[] { paramString1, paramString2 });
        super.addHeader(paramString1, "Unsupported");
        return this;
      }
      finally {}
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.lyft.LyftApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */