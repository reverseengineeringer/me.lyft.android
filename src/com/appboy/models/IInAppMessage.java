package com.appboy.models;

import android.graphics.Bitmap;
import android.net.Uri;
import com.appboy.enums.inappmessage.ClickAction;
import com.appboy.enums.inappmessage.DismissType;
import java.util.Map;
import org.json.JSONObject;

public abstract interface IInAppMessage
  extends IPutIntoJson<JSONObject>
{
  public abstract boolean getAnimateIn();
  
  public abstract boolean getAnimateOut();
  
  public abstract int getBackgroundColor();
  
  public abstract Bitmap getBitmap();
  
  public abstract ClickAction getClickAction();
  
  public abstract DismissType getDismissType();
  
  public abstract int getDurationInMilliseconds();
  
  public abstract Map<String, String> getExtras();
  
  public abstract String getIcon();
  
  public abstract int getIconBackgroundColor();
  
  public abstract int getIconColor();
  
  public abstract boolean getImageDownloadSuccessful();
  
  public abstract String getImageUrl();
  
  public abstract String getLocalImageUrl();
  
  public abstract String getMessage();
  
  public abstract int getMessageTextColor();
  
  public abstract String getRemoteAssetPathForPrefetch();
  
  public abstract String getRemoteImageUrl();
  
  public abstract Uri getUri();
  
  public abstract boolean logClick();
  
  public abstract boolean logImpression();
  
  public abstract void setAnimateIn(boolean paramBoolean);
  
  public abstract void setAnimateOut(boolean paramBoolean);
  
  public abstract void setBackgroundColor(int paramInt);
  
  public abstract void setBitmap(Bitmap paramBitmap);
  
  public abstract boolean setClickAction(ClickAction paramClickAction);
  
  public abstract boolean setClickAction(ClickAction paramClickAction, Uri paramUri);
  
  public abstract void setDismissType(DismissType paramDismissType);
  
  public abstract void setDurationInMilliseconds(int paramInt);
  
  public abstract void setIcon(String paramString);
  
  public abstract void setIconBackgroundColor(int paramInt);
  
  public abstract void setIconColor(int paramInt);
  
  public abstract void setImageDownloadSuccessful(boolean paramBoolean);
  
  public abstract void setImageUrl(String paramString);
  
  public abstract void setLocalAssetPathForPrefetch(String paramString);
  
  public abstract void setLocalImageUrl(String paramString);
  
  public abstract void setMessage(String paramString);
  
  public abstract void setMessageTextColor(int paramInt);
  
  public abstract void setRemoteImageUrl(String paramString);
}

/* Location:
 * Qualified Name:     com.appboy.models.IInAppMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */