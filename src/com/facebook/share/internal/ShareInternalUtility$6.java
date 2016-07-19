package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.internal.NativeAppCallAttachmentStore.Attachment;
import com.facebook.internal.Utility.Mapper;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMedia.Type;
import java.util.List;
import java.util.UUID;

final class ShareInternalUtility$6
  implements Utility.Mapper<ShareMedia, Bundle>
{
  ShareInternalUtility$6(UUID paramUUID, List paramList) {}
  
  public Bundle apply(ShareMedia paramShareMedia)
  {
    NativeAppCallAttachmentStore.Attachment localAttachment = ShareInternalUtility.access$000(val$appCallId, paramShareMedia);
    val$attachments.add(localAttachment);
    Bundle localBundle = new Bundle();
    localBundle.putString("type", paramShareMedia.getMediaType().name());
    localBundle.putString("uri", localAttachment.getAttachmentUrl());
    return localBundle;
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.ShareInternalUtility.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */