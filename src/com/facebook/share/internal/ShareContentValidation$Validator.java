package com.facebook.share.internal;

import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;

class ShareContentValidation$Validator
{
  private boolean isOpenGraphContent = false;
  
  public boolean isOpenGraphContent()
  {
    return isOpenGraphContent;
  }
  
  public void validate(ShareLinkContent paramShareLinkContent)
  {
    ShareContentValidation.access$500(paramShareLinkContent, this);
  }
  
  public void validate(ShareMedia paramShareMedia)
  {
    ShareContentValidation.validateMedium(paramShareMedia, this);
  }
  
  public void validate(ShareMediaContent paramShareMediaContent)
  {
    ShareContentValidation.access$800(paramShareMediaContent, this);
  }
  
  public void validate(ShareOpenGraphAction paramShareOpenGraphAction)
  {
    ShareContentValidation.access$1000(paramShareOpenGraphAction, this);
  }
  
  public void validate(ShareOpenGraphContent paramShareOpenGraphContent)
  {
    isOpenGraphContent = true;
    ShareContentValidation.access$900(paramShareOpenGraphContent, this);
  }
  
  public void validate(ShareOpenGraphObject paramShareOpenGraphObject)
  {
    ShareContentValidation.access$1100(paramShareOpenGraphObject, this);
  }
  
  public void validate(ShareOpenGraphValueContainer paramShareOpenGraphValueContainer, boolean paramBoolean)
  {
    ShareContentValidation.access$1200(paramShareOpenGraphValueContainer, this, paramBoolean);
  }
  
  public void validate(SharePhoto paramSharePhoto)
  {
    ShareContentValidation.access$1300(paramSharePhoto, this);
  }
  
  public void validate(SharePhotoContent paramSharePhotoContent)
  {
    ShareContentValidation.access$600(paramSharePhotoContent, this);
  }
  
  public void validate(ShareVideo paramShareVideo)
  {
    ShareContentValidation.access$1400(paramShareVideo, this);
  }
  
  public void validate(ShareVideoContent paramShareVideoContent)
  {
    ShareContentValidation.access$700(paramShareVideoContent, this);
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.ShareContentValidation.Validator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */