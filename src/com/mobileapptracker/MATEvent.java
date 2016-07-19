package com.mobileapptracker;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class MATEvent
  implements Serializable
{
  private static final long serialVersionUID = -7616393848331704848L;
  private String attribute1;
  private String attribute2;
  private String attribute3;
  private String attribute4;
  private String attribute5;
  private String contentId;
  private String contentType;
  private String currencyCode;
  private Date date1;
  private Date date2;
  private String deviceForm;
  private int eventId;
  private List<MATEventItem> eventItems;
  private String eventName;
  private int level;
  private int quantity;
  private double rating;
  private String receiptData;
  private String receiptSignature;
  private String refId;
  private double revenue;
  private String searchString;
  
  public MATEvent(String paramString)
  {
    eventName = paramString;
  }
  
  public String getAttribute1()
  {
    return attribute1;
  }
  
  public String getAttribute2()
  {
    return attribute2;
  }
  
  public String getAttribute3()
  {
    return attribute3;
  }
  
  public String getAttribute4()
  {
    return attribute4;
  }
  
  public String getAttribute5()
  {
    return attribute5;
  }
  
  public String getContentId()
  {
    return contentId;
  }
  
  public String getContentType()
  {
    return contentType;
  }
  
  public String getCurrencyCode()
  {
    return currencyCode;
  }
  
  public Date getDate1()
  {
    return date1;
  }
  
  public Date getDate2()
  {
    return date2;
  }
  
  public String getDeviceForm()
  {
    return deviceForm;
  }
  
  public int getEventId()
  {
    return eventId;
  }
  
  public List<MATEventItem> getEventItems()
  {
    return eventItems;
  }
  
  public String getEventName()
  {
    return eventName;
  }
  
  public int getLevel()
  {
    return level;
  }
  
  public int getQuantity()
  {
    return quantity;
  }
  
  public double getRating()
  {
    return rating;
  }
  
  public String getReceiptData()
  {
    return receiptData;
  }
  
  public String getReceiptSignature()
  {
    return receiptSignature;
  }
  
  public String getRefId()
  {
    return refId;
  }
  
  public double getRevenue()
  {
    return revenue;
  }
  
  public String getSearchString()
  {
    return searchString;
  }
}

/* Location:
 * Qualified Name:     com.mobileapptracker.MATEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */