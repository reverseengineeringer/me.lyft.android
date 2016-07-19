package com.appboy.models;

import bo.app.fl;
import com.appboy.enums.ErrorType;
import org.json.JSONObject;

public final class ResponseError
{
  private final ErrorType a;
  private final String b;
  
  public ResponseError(ErrorType paramErrorType, String paramString)
  {
    a = paramErrorType;
    b = paramString;
  }
  
  public ResponseError(JSONObject paramJSONObject)
  {
    a = ((ErrorType)fl.a(paramJSONObject, "type", ErrorType.class));
    b = paramJSONObject.getString("message");
  }
  
  public final String getMessage()
  {
    return b;
  }
  
  public final ErrorType getType()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     com.appboy.models.ResponseError
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */