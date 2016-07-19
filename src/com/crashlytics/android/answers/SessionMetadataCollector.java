package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType;
import java.util.Map;
import java.util.UUID;

class SessionMetadataCollector
{
  private final Context context;
  private final IdManager idManager;
  private final String versionCode;
  private final String versionName;
  
  public SessionMetadataCollector(Context paramContext, IdManager paramIdManager, String paramString1, String paramString2)
  {
    context = paramContext;
    idManager = paramIdManager;
    versionCode = paramString1;
    versionName = paramString2;
  }
  
  public SessionEventMetadata getMetadata()
  {
    Object localObject = idManager.getDeviceIdentifiers();
    String str1 = idManager.getAppIdentifier();
    String str2 = idManager.getAppInstallIdentifier();
    String str3 = (String)((Map)localObject).get(IdManager.DeviceIdentifierType.ANDROID_ID);
    String str4 = (String)((Map)localObject).get(IdManager.DeviceIdentifierType.ANDROID_ADVERTISING_ID);
    Boolean localBoolean = idManager.isLimitAdTrackingEnabled();
    localObject = (String)((Map)localObject).get(IdManager.DeviceIdentifierType.FONT_TOKEN);
    String str5 = CommonUtils.resolveBuildId(context);
    String str6 = idManager.getOsVersionString();
    String str7 = idManager.getModelName();
    return new SessionEventMetadata(str1, UUID.randomUUID().toString(), str2, str3, str4, localBoolean, (String)localObject, str5, str6, str7, versionCode, versionName);
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.SessionMetadataCollector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */