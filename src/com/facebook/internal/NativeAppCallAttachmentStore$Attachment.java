package com.facebook.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.FacebookContentProvider;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import java.util.UUID;

public final class NativeAppCallAttachmentStore$Attachment
{
  private final String attachmentName;
  private final String attachmentUrl;
  private Bitmap bitmap;
  private final UUID callId;
  private boolean isContentUri;
  private Uri originalUri;
  private boolean shouldCreateFile;
  
  private NativeAppCallAttachmentStore$Attachment(UUID paramUUID, Bitmap paramBitmap, Uri paramUri)
  {
    callId = paramUUID;
    bitmap = paramBitmap;
    originalUri = paramUri;
    if (paramUri != null)
    {
      paramBitmap = paramUri.getScheme();
      if ("content".equalsIgnoreCase(paramBitmap))
      {
        isContentUri = true;
        if ((paramUri.getAuthority() != null) && (!paramUri.getAuthority().startsWith("media")))
        {
          shouldCreateFile = bool;
          label70:
          if (shouldCreateFile) {
            break label187;
          }
          paramBitmap = null;
          label79:
          attachmentName = paramBitmap;
          if (shouldCreateFile) {
            break label197;
          }
        }
      }
    }
    label187:
    label197:
    for (paramUUID = originalUri.toString();; paramUUID = FacebookContentProvider.getAttachmentUrl(FacebookSdk.getApplicationId(), paramUUID, attachmentName))
    {
      attachmentUrl = paramUUID;
      return;
      bool = false;
      break;
      if ("file".equalsIgnoreCase(paramUri.getScheme()))
      {
        shouldCreateFile = true;
        break label70;
      }
      if (Utility.isWebUri(paramUri)) {
        break label70;
      }
      throw new FacebookException("Unsupported scheme for media Uri : " + paramBitmap);
      if (paramBitmap != null)
      {
        shouldCreateFile = true;
        break label70;
      }
      throw new FacebookException("Cannot share media without a bitmap or Uri set");
      paramBitmap = UUID.randomUUID().toString();
      break label79;
    }
  }
  
  public String getAttachmentUrl()
  {
    return attachmentUrl;
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.NativeAppCallAttachmentStore.Attachment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */