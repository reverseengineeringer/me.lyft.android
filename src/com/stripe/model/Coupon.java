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

public class Coupon
  extends APIResource
  implements MetadataStore<Coupon>
{
  Integer amountOff;
  String currency;
  String duration;
  Integer durationInMonths;
  String id;
  Boolean livemode;
  Long maxRedemptions;
  Map<String, String> metadata;
  Integer percentOff;
  Long redeemBy;
  Integer timesRedeemed;
  Boolean valid;
  
  public static CouponCollection all(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, (RequestOptions)null);
  }
  
  public static CouponCollection all(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (CouponCollection)request(APIResource.RequestMethod.GET, classURL(Coupon.class), paramMap, CouponCollection.class, paramRequestOptions);
  }
  
  @Deprecated
  public static CouponCollection all(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public static Coupon create(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return create(paramMap, (RequestOptions)null);
  }
  
  public static Coupon create(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Coupon)request(APIResource.RequestMethod.POST, classURL(Coupon.class), paramMap, Coupon.class, paramRequestOptions);
  }
  
  @Deprecated
  public static Coupon create(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return create(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public static Coupon retrieve(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(paramString, (RequestOptions)null);
  }
  
  public static Coupon retrieve(String paramString, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Coupon)request(APIResource.RequestMethod.GET, instanceURL(Coupon.class, paramString), null, Coupon.class, paramRequestOptions);
  }
  
  @Deprecated
  public static Coupon retrieve(String paramString1, String paramString2)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(paramString1, RequestOptions.builder().setApiKey(paramString2).build());
  }
  
  public DeletedCoupon delete()
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return delete((RequestOptions)null);
  }
  
  public DeletedCoupon delete(RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (DeletedCoupon)request(APIResource.RequestMethod.DELETE, instanceURL(Coupon.class, id), null, DeletedCoupon.class, paramRequestOptions);
  }
  
  @Deprecated
  public DeletedCoupon delete(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return delete(RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public Integer getAmountOff()
  {
    return amountOff;
  }
  
  public String getCurrency()
  {
    return currency;
  }
  
  public String getDuration()
  {
    return duration;
  }
  
  public Integer getDurationInMonths()
  {
    return durationInMonths;
  }
  
  public String getId()
  {
    return id;
  }
  
  public Boolean getLivemode()
  {
    return livemode;
  }
  
  public Long getMaxRedemptions()
  {
    return maxRedemptions;
  }
  
  public Map<String, String> getMetadata()
  {
    return metadata;
  }
  
  public Integer getPercentOff()
  {
    return percentOff;
  }
  
  public Long getRedeemBy()
  {
    return redeemBy;
  }
  
  public Integer getTimesRedeemed()
  {
    return timesRedeemed;
  }
  
  public Boolean getValid()
  {
    return valid;
  }
  
  public void setAmountOff(Integer paramInteger)
  {
    amountOff = paramInteger;
  }
  
  public void setCurrency(String paramString)
  {
    currency = paramString;
  }
  
  public void setDuration(String paramString)
  {
    duration = paramString;
  }
  
  public void setDurationInMonths(Integer paramInteger)
  {
    durationInMonths = paramInteger;
  }
  
  public void setId(String paramString)
  {
    id = paramString;
  }
  
  public void setLivemode(Boolean paramBoolean)
  {
    livemode = paramBoolean;
  }
  
  public void setMaxRedemptions(Long paramLong)
  {
    maxRedemptions = paramLong;
  }
  
  public void setMetadata(Map<String, String> paramMap)
  {
    metadata = paramMap;
  }
  
  public void setPercentOff(Integer paramInteger)
  {
    percentOff = paramInteger;
  }
  
  public void setRedeemBy(Long paramLong)
  {
    redeemBy = paramLong;
  }
  
  public void setTimesRedeemed(Integer paramInteger)
  {
    timesRedeemed = paramInteger;
  }
  
  public void setValid(Boolean paramBoolean)
  {
    valid = paramBoolean;
  }
  
  public Coupon update(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return update(paramMap, (RequestOptions)null);
  }
  
  public Coupon update(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Coupon)request(APIResource.RequestMethod.POST, instanceURL(Coupon.class, id), paramMap, Coupon.class, paramRequestOptions);
  }
  
  @Deprecated
  public Coupon update(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return update(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.Coupon
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */