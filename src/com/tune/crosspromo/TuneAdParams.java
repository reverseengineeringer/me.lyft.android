package com.tune.crosspromo;

import android.location.Location;
import com.mobileapptracker.MATGender;
import com.mobileapptracker.MATParameters;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TuneAdParams
{
  public int adHeightLandscape;
  public int adHeightPortrait;
  public int adWidthLandscape;
  public int adWidthPortrait;
  private String advertiserId;
  private String altitude;
  private String androidId;
  private String appName;
  private String appVersion;
  private Date birthDate;
  private String connectionType;
  private String countryCode;
  private String currentOrientation;
  private JSONObject customTargets;
  public boolean debugMode;
  private String deviceBrand;
  private String deviceCarrier;
  private String deviceCpuType;
  private String deviceModel;
  private String facebookUserId;
  private MATGender gender;
  private String googleAdId;
  private boolean googleIsLATEnabled;
  private String googleUserId;
  private String installDate;
  private String installReferrer;
  private String installer;
  private String keyCheck;
  private Set<String> keywords;
  private String language;
  private String lastOpenLogId;
  private String latitude;
  private Location location;
  private String longitude;
  private TuneAdOrientation mOrientation;
  private String mPlacement;
  private String matId;
  private String mcc;
  private String mnc;
  private String osVersion;
  private String packageName;
  private boolean payingUser;
  private String pluginName;
  private String referralSource;
  private String referralUrl;
  private JSONObject refs;
  private float screenDensity;
  private int screenHeight;
  private int screenWidth;
  private String sdkVersion;
  private String timeZone;
  private String twitterUserId;
  private String userAgent;
  private String userEmailMd5;
  private String userEmailSha1;
  private String userEmailSha256;
  private String userId;
  private String userNameMd5;
  private String userNameSha1;
  private String userNameSha256;
  private String userPhoneMd5;
  private String userPhoneSha1;
  private String userPhoneSha256;
  
  public TuneAdParams(String paramString, MATParameters paramMATParameters, TuneAdMetadata paramTuneAdMetadata, TuneAdOrientation paramTuneAdOrientation, int paramInt)
  {
    mPlacement = paramString;
    mOrientation = paramTuneAdOrientation;
    boolean bool;
    if (paramInt == 2)
    {
      currentOrientation = "landscape";
      advertiserId = paramMATParameters.getAdvertiserId();
      androidId = paramMATParameters.getAndroidId();
      appName = paramMATParameters.getAppName();
      appVersion = paramMATParameters.getAppVersion();
      connectionType = paramMATParameters.getConnectionType();
      countryCode = paramMATParameters.getCountryCode();
      debugMode = paramMATParameters.getDebugMode();
      deviceBrand = paramMATParameters.getDeviceBrand();
      deviceCarrier = paramMATParameters.getDeviceCarrier();
      deviceCpuType = paramMATParameters.getDeviceCpuType();
      deviceModel = paramMATParameters.getDeviceModel();
      googleAdId = paramMATParameters.getGoogleAdvertisingId();
      if ((paramMATParameters.getGoogleAdTrackingLimited() == null) || (!paramMATParameters.getGoogleAdTrackingLimited().equals("1"))) {
        break label712;
      }
      bool = true;
      label145:
      googleIsLATEnabled = bool;
      installDate = paramMATParameters.getInstallDate();
      installReferrer = paramMATParameters.getInstallReferrer();
      installer = paramMATParameters.getInstaller();
      paramString = paramMATParameters.getConversionKey();
      keyCheck = paramString.substring(Math.max(0, paramString.length() - 4));
      language = paramMATParameters.getLanguage();
      lastOpenLogId = paramMATParameters.getLastOpenLogId();
      matId = paramMATParameters.getMatId();
      mcc = paramMATParameters.getMCC();
      mnc = paramMATParameters.getMNC();
      osVersion = paramMATParameters.getOsVersion();
      packageName = paramMATParameters.getPackageName();
      pluginName = paramMATParameters.getPluginName();
      referralSource = paramMATParameters.getReferralSource();
      referralUrl = paramMATParameters.getReferralUrl();
      screenDensity = Float.parseFloat(paramMATParameters.getScreenDensity());
      screenHeight = Integer.parseInt(paramMATParameters.getScreenHeight());
      screenWidth = Integer.parseInt(paramMATParameters.getScreenWidth());
      sdkVersion = paramMATParameters.getSdkVersion();
      timeZone = paramMATParameters.getTimeZone();
      userAgent = paramMATParameters.getUserAgent();
      paramString = paramMATParameters.getGender();
      if (!paramString.equals("0")) {
        break label718;
      }
      gender = MATGender.MALE;
      label357:
      facebookUserId = paramMATParameters.getFacebookUserId();
      googleUserId = paramMATParameters.getGoogleUserId();
      twitterUserId = paramMATParameters.getTwitterUserId();
      if (!paramMATParameters.getIsPayingUser().equals("1")) {
        break label747;
      }
      payingUser = true;
      label398:
      userEmailMd5 = paramMATParameters.getUserEmailMd5();
      userEmailSha1 = paramMATParameters.getUserEmailSha1();
      userEmailSha256 = paramMATParameters.getUserEmailSha256();
      userId = paramMATParameters.getUserId();
      userNameMd5 = paramMATParameters.getUserNameMd5();
      userNameSha1 = paramMATParameters.getUserNameSha1();
      userNameSha256 = paramMATParameters.getUserNameSha256();
      userPhoneMd5 = paramMATParameters.getPhoneNumberMd5();
      userPhoneSha1 = paramMATParameters.getPhoneNumberSha1();
      userPhoneSha256 = paramMATParameters.getPhoneNumberSha256();
      if (paramInt != 2) {
        break label755;
      }
      adWidthLandscape = screenWidth;
      adHeightLandscape = screenHeight;
      adWidthPortrait = screenHeight;
      adHeightPortrait = screenWidth;
    }
    for (;;)
    {
      if (paramTuneAdMetadata != null)
      {
        birthDate = paramTuneAdMetadata.getBirthDate();
        gender = paramTuneAdMetadata.getGender();
        keywords = paramTuneAdMetadata.getKeywords();
        location = paramTuneAdMetadata.getLocation();
        if (location != null)
        {
          altitude = String.valueOf(location.getAltitude());
          latitude = String.valueOf(location.getLatitude());
          longitude = String.valueOf(location.getLongitude());
        }
        if ((paramTuneAdMetadata.getLatitude() != 0.0D) && (paramTuneAdMetadata.getLongitude() != 0.0D))
        {
          latitude = String.valueOf(paramTuneAdMetadata.getLatitude());
          longitude = String.valueOf(paramTuneAdMetadata.getLongitude());
        }
        if (paramTuneAdMetadata.getCustomTargets() != null) {
          customTargets = new JSONObject(paramTuneAdMetadata.getCustomTargets());
        }
        if (paramTuneAdMetadata.isInDebugMode()) {
          debugMode = paramTuneAdMetadata.isInDebugMode();
        }
        paramMATParameters.setGender(gender);
        if (location != null) {
          paramMATParameters.setLocation(location);
        }
      }
      return;
      currentOrientation = "portrait";
      break;
      label712:
      bool = false;
      break label145;
      label718:
      if (paramString.equals("1"))
      {
        gender = MATGender.FEMALE;
        break label357;
      }
      gender = MATGender.UNKNOWN;
      break label357;
      label747:
      payingUser = false;
      break label398;
      label755:
      adWidthPortrait = screenWidth;
      adHeightPortrait = screenHeight;
      adWidthLandscape = screenHeight;
      adHeightLandscape = screenWidth;
    }
  }
  
  public void setRefs(JSONObject paramJSONObject)
  {
    refs = paramJSONObject;
  }
  
  public JSONObject toJSON()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject3;
    JSONObject localJSONObject4;
    JSONObject localJSONObject5;
    JSONObject localJSONObject6;
    JSONObject localJSONObject7;
    Object localObject;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject2 = new JSONObject().put("advertiserId", advertiserId).put("keyCheck", keyCheck).put("name", appName).put("version", appVersion).put("installDate", installDate).put("installReferrer", installReferrer).put("installer", installer).put("referralSource", referralSource).put("referralUrl", referralUrl).put("package", packageName);
        localJSONObject3 = new JSONObject().put("altitude", altitude).put("connectionType", connectionType).put("country", countryCode).put("deviceBrand", deviceBrand).put("deviceCarrier", deviceCarrier).put("deviceCpuType", deviceCpuType).put("deviceModel", deviceModel).put("language", language).put("latitude", latitude).put("longitude", longitude).put("mcc", mcc).put("mnc", mnc).put("os", "Android").put("osVersion", osVersion).put("timezone", timeZone).put("userAgent", userAgent);
        localJSONObject4 = new JSONObject();
        localJSONObject4.put("androidId", androidId);
        localJSONObject4.put("gaid", googleAdId);
        localJSONObject4.put("googleAdTrackingDisabled", googleIsLATEnabled);
        localJSONObject4.put("matId", matId);
        localJSONObject5 = new JSONObject().put("density", screenDensity).put("height", screenHeight).put("width", screenWidth);
        localJSONObject6 = new JSONObject();
        if (mOrientation.equals(TuneAdOrientation.ALL))
        {
          localJSONObject7 = new JSONObject().put("width", adWidthPortrait).put("height", adHeightPortrait);
          localObject = new JSONObject().put("width", adWidthLandscape).put("height", adHeightLandscape);
          localJSONObject6.put("portrait", localJSONObject7).put("landscape", localObject);
          localJSONObject7 = new JSONObject();
          if (birthDate != null) {
            localJSONObject7.put("birthDate", Long.toString(birthDate.getTime() / 1000L));
          }
          localJSONObject7.put("facebookUserId", facebookUserId);
          localJSONObject7.put("gender", gender);
          localJSONObject7.put("googleUserId", googleUserId);
          if (keywords == null) {
            break label737;
          }
          localObject = new JSONArray();
          Iterator localIterator = keywords.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          ((JSONArray)localObject).put((String)localIterator.next());
          continue;
        }
        if (!mOrientation.equals(TuneAdOrientation.PORTRAIT_ONLY)) {
          break label675;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return localJSONObject1;
      }
      localJSONObject6.put("portrait", new JSONObject().put("width", adWidthPortrait).put("height", adHeightPortrait));
      continue;
      label675:
      if (mOrientation.equals(TuneAdOrientation.LANDSCAPE_ONLY)) {
        localJSONObject6.put("landscape", new JSONObject().put("width", adWidthLandscape).put("height", adHeightLandscape));
      }
    }
    localJSONObject7.put("keywords", localObject);
    label737:
    localJSONObject7.put("payingUser", payingUser);
    localJSONObject7.put("twitterUserId", twitterUserId);
    localJSONObject7.put("userEmailMd5", userEmailMd5);
    localJSONObject7.put("userEmailSha1", userEmailSha1);
    localJSONObject7.put("userEmailSha256", userEmailSha256);
    if ((userId != null) && (userId.length() != 0)) {
      localJSONObject7.put("userId", userId);
    }
    localJSONObject7.put("userNameMd5", userNameMd5);
    localJSONObject7.put("userNameSha1", userNameSha1);
    localJSONObject7.put("userNameSha256", userNameSha256);
    localJSONObject7.put("userPhoneMd5", userPhoneMd5);
    localJSONObject7.put("userPhoneSha1", userPhoneSha1);
    localJSONObject7.put("userPhoneSha256", userPhoneSha256);
    localJSONObject1.put("currentOrientation", currentOrientation);
    localJSONObject1.put("debugMode", debugMode);
    localJSONObject1.put("sdkVersion", sdkVersion);
    localJSONObject1.put("plugin", pluginName);
    localJSONObject1.put("lastOpenLogId", lastOpenLogId);
    localJSONObject1.put("app", localJSONException);
    localJSONObject1.put("device", localJSONObject3);
    localJSONObject1.put("ids", localJSONObject4);
    localJSONObject1.put("screen", localJSONObject5);
    localJSONObject1.put("sizes", localJSONObject6);
    localJSONObject1.put("user", localJSONObject7);
    localJSONObject1.put("targets", customTargets);
    localJSONObject1.put("refs", refs);
    localJSONObject1.put("placement", mPlacement);
    return localJSONObject1;
  }
}

/* Location:
 * Qualified Name:     com.tune.crosspromo.TuneAdParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */