package com.stripe.model;

import java.util.List;

public abstract class StripeCollection<T>
  extends StripeObject
{
  Integer count;
  List<T> data;
  Boolean hasMore;
  Integer totalCount;
  String url;
  
  public Integer getCount()
  {
    return count;
  }
  
  public List<T> getData()
  {
    return data;
  }
  
  public Boolean getHasMore()
  {
    return hasMore;
  }
  
  public Integer getTotalCount()
  {
    return totalCount;
  }
  
  public String getUrl()
  {
    return url;
  }
  
  public void setCount(Integer paramInteger)
  {
    count = paramInteger;
  }
  
  public void setData(List<T> paramList)
  {
    data = paramList;
  }
  
  public void setHasMore(Boolean paramBoolean)
  {
    hasMore = paramBoolean;
  }
  
  public void setTotalCount(Integer paramInteger)
  {
    totalCount = paramInteger;
  }
  
  public void setUrl(String paramString)
  {
    url = paramString;
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.StripeCollection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */