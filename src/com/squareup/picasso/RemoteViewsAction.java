package com.squareup.picasso;

import android.app.Notification;
import android.app.NotificationManager;
import android.appwidget.AppWidgetManager;
import android.graphics.Bitmap;
import android.widget.RemoteViews;

abstract class RemoteViewsAction
  extends Action<RemoteViewsTarget>
{
  final RemoteViews remoteViews;
  private RemoteViewsTarget target;
  final int viewId;
  
  RemoteViewsAction(Picasso paramPicasso, Request paramRequest, RemoteViews paramRemoteViews, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject, String paramString)
  {
    super(paramPicasso, null, paramRequest, paramInt3, paramInt4, paramInt2, null, paramString, paramObject, false);
    remoteViews = paramRemoteViews;
    viewId = paramInt1;
  }
  
  void complete(Bitmap paramBitmap, Picasso.LoadedFrom paramLoadedFrom)
  {
    remoteViews.setImageViewBitmap(viewId, paramBitmap);
    update();
  }
  
  public void error()
  {
    if (errorResId != 0) {
      setImageResource(errorResId);
    }
  }
  
  RemoteViewsTarget getTarget()
  {
    if (target == null) {
      target = new RemoteViewsTarget(remoteViews, viewId);
    }
    return target;
  }
  
  void setImageResource(int paramInt)
  {
    remoteViews.setImageViewResource(viewId, paramInt);
    update();
  }
  
  abstract void update();
  
  static class AppWidgetAction
    extends RemoteViewsAction
  {
    private final int[] appWidgetIds;
    
    AppWidgetAction(Picasso paramPicasso, Request paramRequest, RemoteViews paramRemoteViews, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, String paramString, Object paramObject, int paramInt4)
    {
      super(paramRequest, paramRemoteViews, paramInt1, paramInt4, paramInt2, paramInt3, paramObject, paramString);
      appWidgetIds = paramArrayOfInt;
    }
    
    void update()
    {
      AppWidgetManager.getInstance(picasso.context).updateAppWidget(appWidgetIds, remoteViews);
    }
  }
  
  static class NotificationAction
    extends RemoteViewsAction
  {
    private final Notification notification;
    private final int notificationId;
    
    NotificationAction(Picasso paramPicasso, Request paramRequest, RemoteViews paramRemoteViews, int paramInt1, int paramInt2, Notification paramNotification, int paramInt3, int paramInt4, String paramString, Object paramObject, int paramInt5)
    {
      super(paramRequest, paramRemoteViews, paramInt1, paramInt5, paramInt3, paramInt4, paramObject, paramString);
      notificationId = paramInt2;
      notification = paramNotification;
    }
    
    void update()
    {
      ((NotificationManager)Utils.getService(picasso.context, "notification")).notify(notificationId, notification);
    }
  }
  
  static class RemoteViewsTarget
  {
    final RemoteViews remoteViews;
    final int viewId;
    
    RemoteViewsTarget(RemoteViews paramRemoteViews, int paramInt)
    {
      remoteViews = paramRemoteViews;
      viewId = paramInt;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (RemoteViewsTarget)paramObject;
      } while ((viewId == viewId) && (remoteViews.equals(remoteViews)));
      return false;
    }
    
    public int hashCode()
    {
      return remoteViews.hashCode() * 31 + viewId;
    }
  }
}

/* Location:
 * Qualified Name:     com.squareup.picasso.RemoteViewsAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */