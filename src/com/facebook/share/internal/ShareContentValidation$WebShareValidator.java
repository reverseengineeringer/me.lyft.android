package com.facebook.share.internal;

import com.facebook.FacebookException;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;

class ShareContentValidation$WebShareValidator
  extends ShareContentValidation.Validator
{
  private ShareContentValidation$WebShareValidator()
  {
    super(null);
  }
  
  public void validate(ShareMediaContent paramShareMediaContent)
  {
    throw new FacebookException("Cannot share ShareMediaContent via web sharing dialogs");
  }
  
  public void validate(SharePhoto paramSharePhoto)
  {
    ShareContentValidation.access$300(paramSharePhoto, this);
  }
  
  public void validate(SharePhotoContent paramSharePhotoContent)
  {
    throw new FacebookException("Cannot share SharePhotoContent via web sharing dialogs");
  }
  
  public void validate(ShareVideoContent paramShareVideoContent)
  {
    throw new FacebookException("Cannot share ShareVideoContent via web sharing dialogs");
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.ShareContentValidation.WebShareValidator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */