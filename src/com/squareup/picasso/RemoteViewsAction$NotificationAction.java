package com.squareup.picasso;

import android.app.Notification;
import android.app.NotificationManager;
import android.widget.RemoteViews;

class RemoteViewsAction$NotificationAction
  extends RemoteViewsAction
{
  private final Notification notification;
  private final int notificationId;
  
  RemoteViewsAction$NotificationAction(Picasso paramPicasso, Request paramRequest, RemoteViews paramRemoteViews, int paramInt1, int paramInt2, Notification paramNotification, int paramInt3, int paramInt4, String paramString, Object paramObject, int paramInt5)
  {
    super(paramPicasso, paramRequest, paramRemoteViews, paramInt1, paramInt5, paramInt3, paramInt4, paramObject, paramString);
    notificationId = paramInt2;
    notification = paramNotification;
  }
  
  void update()
  {
    ((NotificationManager)Utils.getService(picasso.context, "notification")).notify(notificationId, notification);
  }
}

/* Location:
 * Qualified Name:     com.squareup.picasso.RemoteViewsAction.NotificationAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */