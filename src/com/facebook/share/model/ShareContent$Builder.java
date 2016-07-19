package com.facebook.share.model;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

public abstract class ShareContent$Builder<P extends ShareContent, E extends Builder>
  implements ShareModelBuilder<P, E>
{
  private Uri contentUrl;
  private ShareHashtag hashtag;
  private List<String> peopleIds;
  private String placeId;
  private String ref;
  
  public E readFrom(P paramP)
  {
    if (paramP == null) {
      return this;
    }
    return setContentUrl(paramP.getContentUrl()).setPeopleIds(paramP.getPeopleIds()).setPlaceId(paramP.getPlaceId()).setRef(paramP.getRef());
  }
  
  public E setContentUrl(Uri paramUri)
  {
    contentUrl = paramUri;
    return this;
  }
  
  public E setPeopleIds(List<String> paramList)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      peopleIds = paramList;
      return this;
    }
  }
  
  public E setPlaceId(String paramString)
  {
    placeId = paramString;
    return this;
  }
  
  public E setRef(String paramString)
  {
    ref = paramString;
    return this;
  }
  
  public E setShareHashtag(ShareHashtag paramShareHashtag)
  {
    hashtag = paramShareHashtag;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.model.ShareContent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */