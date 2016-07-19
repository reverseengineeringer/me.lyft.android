package com.facebook.share.internal;

import com.facebook.internal.NativeAppCallAttachmentStore.Attachment;
import com.facebook.internal.Utility.Mapper;

final class ShareInternalUtility$5
  implements Utility.Mapper<NativeAppCallAttachmentStore.Attachment, String>
{
  public String apply(NativeAppCallAttachmentStore.Attachment paramAttachment)
  {
    return paramAttachment.getAttachmentUrl();
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.ShareInternalUtility.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */