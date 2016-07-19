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
import java.io.IOException;
import me.lyft.android.application.ridehistory.PassengerRideHistoryType;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.location.LatLng;
import me.lyft.android.domain.time.TimeRange;
import me.lyft.android.infrastructure.googlegeo.model.GoogleDirectionsResponseDTO;
import rx.Observable;

public abstract interface ILyftApi
{
  public abstract Observable<Unit> acceptDeclineFareSplitRequest(String paramString, ContributorUpdateRequestDTO paramContributorUpdateRequestDTO);
  
  public abstract Observable<VehiclesDTO> activateDriverVehicle(String paramString);
  
  public abstract Observable<UniversalDTO> applyCoupon(String paramString1, String paramString2);
  
  public abstract Observable<ScheduledRideResponseDTO> cancelScheduledRide(ScheduledRideDTO paramScheduledRideDTO);
  
  public abstract Observable<ChargeAccountsResponseDTO> createChargeAccount(ChargeAccountRequestDTO paramChargeAccountRequestDTO);
  
  public abstract Observable<ExpressPayAccountDTO> createOrUpdateDebitCard(String paramString, CreateExpressPayAccountDTO paramCreateExpressPayAccountDTO);
  
  public abstract Observable<RideRequestDetailsDTO> createRide(RideRequestDTO paramRideRequestDTO);
  
  public abstract Observable<UniversalDTO> createUser(String paramString, LoginRequestDTO paramLoginRequestDTO);
  
  public abstract Observable<UserOrganizationDTO> createUserOrganization(OrganizationRequestDTO paramOrganizationRequestDTO);
  
  public abstract Observable<UniversalDTO> createUserShortcut(String paramString, ShortcutDTO paramShortcutDTO);
  
  public abstract Observable<UniversalDTO> declineCarpoolRides(CarpoolRideDeclineRequestDTO paramCarpoolRideDeclineRequestDTO);
  
  public abstract Observable<ChargeAccountsResponseDTO> deleteChargeAccount(String paramString);
  
  public abstract Observable<UniversalDTO> deleteDestinyLocation(String paramString);
  
  public abstract void dropOff(String paramString, RideUpdateRequestDTO paramRideUpdateRequestDTO)
    throws IOException;
  
  public abstract Observable<GoogleDirectionsResponseDTO> fallbackDirections(String paramString);
  
  public abstract Observable<SignedUrlDTO> generateSignedUrl(SignedUrlRequestDTO paramSignedUrlRequestDTO);
  
  public abstract String getApiRoot();
  
  public abstract Observable<AppInfoDTO> getAppInfo(double paramDouble1, double paramDouble2, String paramString);
  
  public abstract Observable<CarpoolRidesResponseDTO> getCarpoolRides();
  
  public abstract CarpoolRidesResponseDTO getCarpoolRidesSync()
    throws IOException;
  
  public abstract CostEstimateResponseDTO getCosts(double paramDouble1, double paramDouble2, String paramString1, Double paramDouble3, Double paramDouble4, String paramString2, TimeRange paramTimeRange)
    throws IOException;
  
  public abstract Observable<CouponTemplateDTO> getCouponInformation(String paramString);
  
  public abstract Observable<DriverApplicationDTO> getDriverApplication();
  
  public abstract Observable<DriverApplicationDataDTO> getDriverApplicationData();
  
  public abstract Observable<DriverProfileDTO> getDriverProfile();
  
  public abstract Observable<DriverStatsDTO> getDriverStats(String paramString);
  
  public abstract Observable<VehiclesDTO> getDriverVehicles();
  
  public abstract EtaEstimateResponseDTO getEtaEstimate(double paramDouble1, double paramDouble2)
    throws IOException;
  
  public abstract Observable<ExpressPayDTO> getExpressPay(String paramString);
  
  public abstract HeatmapMetaDTO getHeatmapPricingSync(double paramDouble1, double paramDouble2)
    throws IOException;
  
  public abstract Observable<PresignedPhotoUrlDTO> getImageUploadUrl(PresignedPhotoUrlRequestDTO paramPresignedPhotoUrlRequestDTO);
  
  public abstract NearbyDriversResponseDTO getNearbyDrivers(double paramDouble1, double paramDouble2)
    throws IOException;
  
  public abstract Observable<NewsFeedMessagesDTO> getNewsFeedMessages();
  
  public abstract Observable<NotificationsDTO> getNotifications();
  
  public abstract Observable<RideHistoryDTO> getPassengerHistory(int paramInt1, int paramInt2, PassengerRideHistoryType paramPassengerRideHistoryType);
  
  public abstract Observable<RideHistoryItemDetailedDTO> getPassengerRideHistoryDetails(String paramString);
  
  public abstract Observable<PaypalClientTokenDTO> getPayPalClientToken(String paramString);
  
  public abstract Observable<PickupGeofenceDTO> getPickupGeofence(String paramString);
  
  public abstract Observable<ReferralInfoDTO> getReferral();
  
  public abstract RideTypesResponseDTO getRideTypes(double paramDouble1, double paramDouble2)
    throws IOException;
  
  public abstract Observable<ScheduledRideResponseDTO> getScheduledRides();
  
  public abstract Observable<ScheduledRideAvailableTimesResponseDTO> getScheduledRidesAvailability(String paramString, double paramDouble1, double paramDouble2, Double paramDouble3, Double paramDouble4);
  
  public abstract Observable<ShareRouteDTO> getShareRouteUrl(ShareRouteRequestDTO paramShareRouteRequestDTO);
  
  public abstract Observable<UserOrganizationDTO> getUserOrganization();
  
  public abstract Observable<VenuesDTO> getVenues(LatLng paramLatLng);
  
  public abstract Observable<WarmWelcomeDTO> getWarmWelcome(String paramString);
  
  public abstract Observable<ChargeAccountsResponseDTO> loadChargeAccounts();
  
  public abstract Observable<Unit> logout(String paramString);
  
  public abstract Observable<ChargeAccountsResponseDTO> makeCardDefault(String paramString);
  
  public abstract Observable<ChargeAccountsResponseDTO> makeChargeAccountDefault(String paramString);
  
  public abstract Observable<ChargeAccountsResponseDTO> makeChargeAccountDefaultBusiness(String paramString);
  
  public abstract Observable<ChargeAccountsResponseDTO> makeCreditLineDefault(String paramString);
  
  public abstract Observable<ChargeAccountsResponseDTO> makeFacebookDefault(String paramString);
  
  public abstract Observable<ChargeAccountsResponseDTO> makePayPalDefault(String paramString1, String paramString2);
  
  public abstract Observable<ChargeAccountsResponseDTO> makeWalletDefault(String paramString);
  
  public abstract Observable<ChargeAccountsResponseDTO> payDebtWithCreditCard(String paramString);
  
  public abstract Observable<ChargeAccountsResponseDTO> payDebtWithPayPal(String paramString1, String paramString2);
  
  public abstract Observable<ChargeAccountsResponseDTO> payDebtWithWallet(String paramString);
  
  public abstract Observable<PlacesDTO> placeSearch(String paramString, LocationDTO paramLocationDTO);
  
  public abstract void ratePassenger(String paramString, RideUpdateRequestDTO paramRideUpdateRequestDTO)
    throws IOException;
  
  public abstract Observable<UniversalDTO> refreshFacebookAuthToken(String paramString1, String paramString2);
  
  public abstract Observable<Unit> requestPhoneAuthentication(PhoneRequestDTO paramPhoneRequestDTO);
  
  public abstract Observable<ScheduledRideDTO> scheduleRide(ScheduledRideRequestDTO paramScheduledRideRequestDTO);
  
  public abstract Observable<Unit> sendEnterpriseInvites(InviteRequestDTO paramInviteRequestDTO);
  
  public abstract Observable<Unit> sendFareSplitInvites(FareSplitInviteRequestDTO paramFareSplitInviteRequestDTO);
  
  public abstract Observable<Unit> sendInvites(InviteRequestDTO paramInviteRequestDTO);
  
  public abstract void setApiRoot(String paramString);
  
  public abstract Observable<UniversalDTO> startCouchRide(GhostrideRequestDTO paramGhostrideRequestDTO);
  
  public abstract Observable<Unit> submitPayout(String paramString);
  
  public abstract Observable<PlacesDTO> topDestinations(LocationDTO paramLocationDTO);
  
  public abstract Observable<UniversalDTO> unlinkConcur(String paramString);
  
  public abstract Observable<ChargeAccountsResponseDTO> updateChargeAccount(String paramString1, String paramString2);
  
  public abstract Observable<Unit> updateCoarseLocation(UpdateLocationRequestDTO paramUpdateLocationRequestDTO);
  
  public abstract Observable<UniversalDTO> updateConcurSendRideReceipts(String paramString, boolean paramBoolean);
  
  public abstract Observable<UniversalDTO> updateDestinyLocation(String paramString, DriverDestinationRequestDTO paramDriverDestinationRequestDTO);
  
  public abstract Observable<DriverApplicationDTO> updateDriverApplication(DriverApplicationDTO paramDriverApplicationDTO);
  
  public abstract Observable<Unit> updateDriverProfile(DriverProfileDTO paramDriverProfileDTO);
  
  public abstract Observable<VehiclesDTO> updateDriverVehicleDocuments(String paramString, UpdateVehicleRequestDTO paramUpdateVehicleRequestDTO);
  
  public abstract Observable<Unit> updateGoogleAuthToken(String paramString, GoogleNowAuthCodeDTO paramGoogleNowAuthCodeDTO);
  
  public abstract Observable<Unit> updateLocationPermissions(ClientPermissionsRequestDTO paramClientPermissionsRequestDTO);
  
  public abstract UniversalDTO updateLocationSync(String paramString, UpdateUserLocationRequestDTO paramUpdateUserLocationRequestDTO)
    throws Throwable;
  
  public abstract Observable<UniversalDTO> updateRide(String paramString, RideUpdateRequestDTO paramRideUpdateRequestDTO);
  
  public abstract Observable<UniversalDTO> updateUser(String paramString, UpdateUserRequestDTO paramUpdateUserRequestDTO);
  
  public abstract UniversalDTO updateUserSync(String paramString, UpdateUserRequestDTO paramUpdateUserRequestDTO)
    throws Throwable;
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.lyft.ILyftApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */