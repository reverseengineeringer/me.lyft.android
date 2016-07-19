package com.squareup.picasso;

import android.appwidget.AppWidgetManager;
import android.widget.RemoteViews;

class RemoteViewsAction$AppWidgetAction
  extends RemoteViewsAction
{
  private final int[] appWidgetIds;
  
  RemoteViewsAction$AppWidgetAction(Picasso paramPicasso, Request paramRequest, RemoteViews paramRemoteViews, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, String paramString, Object paramObject, int paramInt4)
  {
    super(paramPicasso, paramRequest, paramRemoteViews, paramInt1, paramInt4, paramInt2, paramInt3, paramObject, paramString);
    appWidgetIds = paramArrayOfInt;
  }
  
  void update()
  {
    AppWidgetManager.getInstance(picasso.context).updateAppWidget(appWidgetIds, remoteViews);
  }
}

/* Location:
 * Qualified Name:     com.squareup.picasso.RemoteViewsAction.AppWidgetAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */