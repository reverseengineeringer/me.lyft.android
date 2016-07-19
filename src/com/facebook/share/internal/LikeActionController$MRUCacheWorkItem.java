package com.facebook.share.internal;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

class LikeActionController$MRUCacheWorkItem
  implements Runnable
{
  private static ArrayList<String> mruCachedItems = new ArrayList();
  private String cacheItem;
  private boolean shouldTrim;
  
  LikeActionController$MRUCacheWorkItem(String paramString, boolean paramBoolean)
  {
    cacheItem = paramString;
    shouldTrim = paramBoolean;
  }
  
  public void run()
  {
    if (cacheItem != null)
    {
      mruCachedItems.remove(cacheItem);
      mruCachedItems.add(0, cacheItem);
    }
    if ((shouldTrim) && (mruCachedItems.size() >= 128)) {
      while (64 < mruCachedItems.size())
      {
        String str = (String)mruCachedItems.remove(mruCachedItems.size() - 1);
        LikeActionController.access$400().remove(str);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.LikeActionController.MRUCacheWorkItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */