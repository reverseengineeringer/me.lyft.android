package com.appboy.models;

public abstract interface IInAppMessageHtml
  extends IInAppMessage
{
  public abstract String getAssetsZipRemoteUrl();
  
  public abstract String getLocalAssetsDirectoryUrl();
  
  public abstract boolean logButtonClick(String paramString);
  
  public abstract void setAssetsZipRemoteUrl(String paramString);
  
  public abstract void setLocalAssetsDirectoryUrl(String paramString);
}

/* Location:
 * Qualified Name:     com.appboy.models.IInAppMessageHtml
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */