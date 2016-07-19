package com.squareup.picasso;

import android.widget.RemoteViews;

class RemoteViewsAction$RemoteViewsTarget
{
  final RemoteViews remoteViews;
  final int viewId;
  
  RemoteViewsAction$RemoteViewsTarget(RemoteViews paramRemoteViews, int paramInt)
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

/* Location:
 * Qualified Name:     com.squareup.picasso.RemoteViewsAction.RemoteViewsTarget
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */