package com.facebook.share.internal;

import com.facebook.internal.NativeAppCallAttachmentStore.Attachment;
import com.facebook.internal.Utility.Mapper;
import com.facebook.share.model.SharePhoto;
import java.util.UUID;

final class ShareInternalUtility$4
  implements Utility.Mapper<SharePhoto, NativeAppCallAttachmentStore.Attachment>
{
  ShareInternalUtility$4(UUID paramUUID) {}
  
  public NativeAppCallAttachmentStore.Attachment apply(SharePhoto paramSharePhoto)
  {
    return ShareInternalUtility.access$000(val$appCallId, paramSharePhoto);
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.ShareInternalUtility.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */