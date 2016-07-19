package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.internal.PlatformServiceClient.CompletedListener;

class LikeActionController$10
  implements PlatformServiceClient.CompletedListener
{
  LikeActionController$10(LikeActionController paramLikeActionController) {}
  
  public void completed(Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("com.facebook.platform.extra.OBJECT_IS_LIKED"))) {
      return;
    }
    boolean bool = paramBundle.getBoolean("com.facebook.platform.extra.OBJECT_IS_LIKED");
    String str1;
    String str2;
    label54:
    String str3;
    label71:
    String str4;
    if (paramBundle.containsKey("com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE"))
    {
      str1 = paramBundle.getString("com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE");
      if (!paramBundle.containsKey("com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE")) {
        break label132;
      }
      str2 = paramBundle.getString("com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE");
      if (!paramBundle.containsKey("com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE")) {
        break label144;
      }
      str3 = paramBundle.getString("com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE");
      if (!paramBundle.containsKey("com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE")) {
        break label156;
      }
      str4 = paramBundle.getString("com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE");
      label88:
      if (!paramBundle.containsKey("com.facebook.platform.extra.UNLIKE_TOKEN")) {
        break label168;
      }
    }
    label132:
    label144:
    label156:
    label168:
    for (paramBundle = paramBundle.getString("com.facebook.platform.extra.UNLIKE_TOKEN");; paramBundle = LikeActionController.access$1100(this$0))
    {
      LikeActionController.access$1300(this$0, bool, str1, str2, str3, str4, paramBundle);
      return;
      str1 = LikeActionController.access$700(this$0);
      break;
      str2 = LikeActionController.access$800(this$0);
      break label54;
      str3 = LikeActionController.access$900(this$0);
      break label71;
      str4 = LikeActionController.access$1000(this$0);
      break label88;
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.LikeActionController.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */