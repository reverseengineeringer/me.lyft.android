package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.Utility;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public final class FacebookRequestError
  implements Parcelable
{
  private static final String BODY_KEY = "body";
  private static final String CODE_KEY = "code";
  public static final Parcelable.Creator<FacebookRequestError> CREATOR = new Parcelable.Creator()
  {
    public FacebookRequestError createFromParcel(Parcel paramAnonymousParcel)
    {
      return new FacebookRequestError(paramAnonymousParcel, null);
    }
    
    public FacebookRequestError[] newArray(int paramAnonymousInt)
    {
      return new FacebookRequestError[paramAnonymousInt];
    }
  };
  private static final String ERROR_CODE_FIELD_KEY = "code";
  private static final String ERROR_CODE_KEY = "error_code";
  private static final String ERROR_IS_TRANSIENT_KEY = "is_transient";
  private static final String ERROR_KEY = "error";
  private static final String ERROR_MESSAGE_FIELD_KEY = "message";
  private static final String ERROR_MSG_KEY = "error_msg";
  private static final String ERROR_REASON_KEY = "error_reason";
  private static final String ERROR_SUB_CODE_KEY = "error_subcode";
  private static final String ERROR_TYPE_FIELD_KEY = "type";
  private static final String ERROR_USER_MSG_KEY = "error_user_msg";
  private static final String ERROR_USER_TITLE_KEY = "error_user_title";
  static final Range HTTP_RANGE_SUCCESS = new Range(200, 299, null);
  public static final int INVALID_ERROR_CODE = -1;
  public static final int INVALID_HTTP_STATUS_CODE = -1;
  private final Object batchRequestResult;
  private final Category category;
  private final HttpURLConnection connection;
  private final int errorCode;
  private final String errorMessage;
  private final String errorRecoveryMessage;
  private final String errorType;
  private final String errorUserMessage;
  private final String errorUserTitle;
  private final FacebookException exception;
  private final JSONObject requestResult;
  private final JSONObject requestResultBody;
  private final int requestStatusCode;
  private final int subErrorCode;
  
  private FacebookRequestError(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, JSONObject paramJSONObject1, JSONObject paramJSONObject2, Object paramObject, HttpURLConnection paramHttpURLConnection, FacebookException paramFacebookException)
  {
    requestStatusCode = paramInt1;
    errorCode = paramInt2;
    subErrorCode = paramInt3;
    errorType = paramString1;
    errorMessage = paramString2;
    requestResultBody = paramJSONObject1;
    requestResult = paramJSONObject2;
    batchRequestResult = paramObject;
    connection = paramHttpURLConnection;
    errorUserTitle = paramString3;
    errorUserMessage = paramString4;
    paramInt1 = 0;
    if (paramFacebookException != null)
    {
      exception = paramFacebookException;
      paramInt1 = 1;
      paramString2 = getErrorClassification();
      if (paramInt1 == 0) {
        break label133;
      }
    }
    label133:
    for (paramString1 = Category.OTHER;; paramString1 = paramString2.classify(paramInt2, paramInt3, paramBoolean))
    {
      category = paramString1;
      errorRecoveryMessage = paramString2.getRecoveryMessage(category);
      return;
      exception = new FacebookServiceException(this, paramString2);
      break;
    }
  }
  
  public FacebookRequestError(int paramInt, String paramString1, String paramString2)
  {
    this(-1, paramInt, -1, paramString1, paramString2, null, null, false, null, null, null, null, null);
  }
  
  private FacebookRequestError(Parcel paramParcel)
  {
    this(paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), false, null, null, null, null, null);
  }
  
  FacebookRequestError(HttpURLConnection paramHttpURLConnection, Exception paramException) {}
  
  static FacebookRequestError checkResponseAndCreateError(JSONObject paramJSONObject, Object paramObject, HttpURLConnection paramHttpURLConnection)
  {
    try
    {
      if (paramJSONObject.has("code"))
      {
        int m = paramJSONObject.getInt("code");
        Object localObject1 = Utility.getStringPropertyAsJSON(paramJSONObject, "body", "FACEBOOK_NON_JSON_RESULT");
        if ((localObject1 != null) && ((localObject1 instanceof JSONObject)))
        {
          JSONObject localJSONObject2 = (JSONObject)localObject1;
          localObject1 = null;
          String str = null;
          JSONObject localJSONObject1 = null;
          Object localObject4 = null;
          boolean bool2 = false;
          int i = -1;
          int j = -1;
          int k = 0;
          Object localObject2;
          Object localObject3;
          boolean bool1;
          if (localJSONObject2.has("error"))
          {
            localJSONObject1 = (JSONObject)Utility.getStringPropertyAsJSON(localJSONObject2, "error", null);
            localObject1 = localJSONObject1.optString("type", null);
            str = localJSONObject1.optString("message", null);
            i = localJSONObject1.optInt("code", -1);
            j = localJSONObject1.optInt("error_subcode", -1);
            localObject2 = localJSONObject1.optString("error_user_msg", null);
            localObject3 = localJSONObject1.optString("error_user_title", null);
            bool1 = localJSONObject1.optBoolean("is_transient", false);
            k = 1;
          }
          while (k != 0)
          {
            return new FacebookRequestError(m, i, j, (String)localObject1, str, (String)localObject3, (String)localObject2, bool1, localJSONObject2, paramJSONObject, paramObject, paramHttpURLConnection, null);
            if ((!localJSONObject2.has("error_code")) && (!localJSONObject2.has("error_msg")))
            {
              localObject3 = localObject4;
              localObject2 = localJSONObject1;
              bool1 = bool2;
              if (!localJSONObject2.has("error_reason")) {}
            }
            else
            {
              localObject1 = localJSONObject2.optString("error_reason", null);
              str = localJSONObject2.optString("error_msg", null);
              i = localJSONObject2.optInt("error_code", -1);
              j = localJSONObject2.optInt("error_subcode", -1);
              k = 1;
              localObject3 = localObject4;
              localObject2 = localJSONObject1;
              bool1 = bool2;
            }
          }
        }
        if (!HTTP_RANGE_SUCCESS.contains(m))
        {
          if (paramJSONObject.has("body")) {}
          for (localObject1 = (JSONObject)Utility.getStringPropertyAsJSON(paramJSONObject, "body", "FACEBOOK_NON_JSON_RESULT");; localObject1 = null)
          {
            paramJSONObject = new FacebookRequestError(m, -1, -1, null, null, null, null, false, (JSONObject)localObject1, paramJSONObject, paramObject, paramHttpURLConnection, null);
            return paramJSONObject;
          }
        }
      }
      return null;
    }
    catch (JSONException paramJSONObject) {}
  }
  
  /* Error */
  static FacebookRequestErrorClassification getErrorClassification()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 211	com/facebook/FacebookSdk:getApplicationId	()Ljava/lang/String;
    //   6: invokestatic 215	com/facebook/internal/Utility:getAppSettingsWithoutQuery	(Ljava/lang/String;)Lcom/facebook/internal/Utility$FetchedAppSettings;
    //   9: astore_0
    //   10: aload_0
    //   11: ifnonnull +12 -> 23
    //   14: invokestatic 218	com/facebook/internal/FacebookRequestErrorClassification:getDefaultErrorClassification	()Lcom/facebook/internal/FacebookRequestErrorClassification;
    //   17: astore_0
    //   18: ldc 2
    //   20: monitorexit
    //   21: aload_0
    //   22: areturn
    //   23: aload_0
    //   24: invokevirtual 221	com/facebook/internal/Utility$FetchedAppSettings:getErrorClassification	()Lcom/facebook/internal/FacebookRequestErrorClassification;
    //   27: astore_0
    //   28: goto -10 -> 18
    //   31: astore_0
    //   32: ldc 2
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   9	19	0	localObject1	Object
    //   31	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	10	31	finally
    //   14	18	31	finally
    //   23	28	31	finally
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Object getBatchRequestResult()
  {
    return batchRequestResult;
  }
  
  public Category getCategory()
  {
    return category;
  }
  
  public HttpURLConnection getConnection()
  {
    return connection;
  }
  
  public int getErrorCode()
  {
    return errorCode;
  }
  
  public String getErrorMessage()
  {
    if (errorMessage != null) {
      return errorMessage;
    }
    return exception.getLocalizedMessage();
  }
  
  public String getErrorRecoveryMessage()
  {
    return errorRecoveryMessage;
  }
  
  public String getErrorType()
  {
    return errorType;
  }
  
  public String getErrorUserMessage()
  {
    return errorUserMessage;
  }
  
  public String getErrorUserTitle()
  {
    return errorUserTitle;
  }
  
  public FacebookException getException()
  {
    return exception;
  }
  
  public JSONObject getRequestResult()
  {
    return requestResult;
  }
  
  public JSONObject getRequestResultBody()
  {
    return requestResultBody;
  }
  
  public int getRequestStatusCode()
  {
    return requestStatusCode;
  }
  
  public int getSubErrorCode()
  {
    return subErrorCode;
  }
  
  public String toString()
  {
    return "{HttpStatus: " + requestStatusCode + ", errorCode: " + errorCode + ", errorType: " + errorType + ", errorMessage: " + getErrorMessage() + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(requestStatusCode);
    paramParcel.writeInt(errorCode);
    paramParcel.writeInt(subErrorCode);
    paramParcel.writeString(errorType);
    paramParcel.writeString(errorMessage);
    paramParcel.writeString(errorUserTitle);
    paramParcel.writeString(errorUserMessage);
  }
  
  public static enum Category
  {
    LOGIN_RECOVERABLE,  OTHER,  TRANSIENT;
    
    private Category() {}
  }
  
  private static class Range
  {
    private final int end;
    private final int start;
    
    private Range(int paramInt1, int paramInt2)
    {
      start = paramInt1;
      end = paramInt2;
    }
    
    boolean contains(int paramInt)
    {
      return (start <= paramInt) && (paramInt <= end);
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.FacebookRequestError
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */