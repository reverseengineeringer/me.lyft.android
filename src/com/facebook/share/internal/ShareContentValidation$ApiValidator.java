package com.facebook.share.internal;

import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.ShareVideoContent;

class ShareContentValidation$ApiValidator
  extends ShareContentValidation.Validator
{
  private ShareContentValidation$ApiValidator()
  {
    super(null);
  }
  
  public void validate(ShareLinkContent paramShareLinkContent)
  {
    if (!Utility.isNullOrEmpty(paramShareLinkContent.getQuote())) {
      throw new FacebookException("Cannot share link content with quote using the share api");
    }
  }
  
  public void validate(ShareMediaContent paramShareMediaContent)
  {
    throw new FacebookException("Cannot share ShareMediaContent using the share api");
  }
  
  public void validate(SharePhoto paramSharePhoto)
  {
    ShareContentValidation.access$400(paramSharePhoto, this);
  }
  
  public void validate(ShareVideoContent paramShareVideoContent)
  {
    if (!Utility.isNullOrEmpty(paramShareVideoContent.getPlaceId())) {
      throw new FacebookException("Cannot share video content with place IDs using the share api");
    }
    if (!Utility.isNullOrEmpty(paramShareVideoContent.getPeopleIds())) {
      throw new FacebookException("Cannot share video content with people IDs using the share api");
    }
    if (!Utility.isNullOrEmpty(paramShareVideoContent.getRef())) {
      throw new FacebookException("Cannot share video content with referrer URL using the share api");
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.ShareContentValidation.ApiValidator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */