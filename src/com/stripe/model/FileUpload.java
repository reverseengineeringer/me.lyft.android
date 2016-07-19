package com.stripe.model;

import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.net.APIResource;
import com.stripe.net.APIResource.RequestMethod;
import com.stripe.net.RequestOptions;
import com.stripe.net.RequestOptions.RequestOptionsBuilder;
import java.util.Map;

public class FileUpload
  extends APIResource
{
  Long created;
  String id;
  String purpose;
  Long size;
  String type;
  String url;
  
  public static FileUploadCollection all(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, (RequestOptions)null);
  }
  
  public static FileUploadCollection all(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (FileUploadCollection)request(APIResource.RequestMethod.GET, classURL(FileUpload.class, "https://uploads.stripe.com"), paramMap, FileUploadCollection.class, paramRequestOptions);
  }
  
  @Deprecated
  public static FileUploadCollection all(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public static FileUpload create(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return create(paramMap, (RequestOptions)null);
  }
  
  public static FileUpload create(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (FileUpload)multipartRequest(APIResource.RequestMethod.POST, classURL(FileUpload.class, "https://uploads.stripe.com"), paramMap, FileUpload.class, paramRequestOptions);
  }
  
  @Deprecated
  public static FileUpload create(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return create(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public static FileUpload retrieve(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(paramString, (RequestOptions)null);
  }
  
  public static FileUpload retrieve(String paramString, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (FileUpload)request(APIResource.RequestMethod.GET, instanceURL(FileUpload.class, paramString, "https://uploads.stripe.com"), null, FileUpload.class, paramRequestOptions);
  }
  
  @Deprecated
  public static FileUpload retrieve(String paramString1, String paramString2)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(paramString1, RequestOptions.builder().setApiKey(paramString2).build());
  }
  
  public Long getCreated()
  {
    return created;
  }
  
  public String getId()
  {
    return id;
  }
  
  public String getPurpose()
  {
    return purpose;
  }
  
  public Long getSize()
  {
    return size;
  }
  
  public String getType()
  {
    return type;
  }
  
  public String getURL()
  {
    return url;
  }
  
  public void setCreated(Long paramLong)
  {
    created = paramLong;
  }
  
  public void setId(String paramString)
  {
    id = paramString;
  }
  
  public void setPurpose(String paramString)
  {
    purpose = paramString;
  }
  
  public void setSize(Long paramLong)
  {
    size = paramLong;
  }
  
  public void setType(String paramString)
  {
    type = paramString;
  }
  
  public void setURL(String paramString)
  {
    url = paramString;
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.FileUpload
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */