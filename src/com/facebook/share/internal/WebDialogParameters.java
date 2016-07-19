package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.share.model.AppGroupCreationContent;
import com.facebook.share.model.AppGroupCreationContent.AppGroupPrivacy;
import com.facebook.share.model.GameRequestContent;
import com.facebook.share.model.GameRequestContent.ActionType;
import com.facebook.share.model.GameRequestContent.Filters;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class WebDialogParameters
{
  public static Bundle create(AppGroupCreationContent paramAppGroupCreationContent)
  {
    Bundle localBundle = new Bundle();
    Utility.putNonEmptyString(localBundle, "name", paramAppGroupCreationContent.getName());
    Utility.putNonEmptyString(localBundle, "description", paramAppGroupCreationContent.getDescription());
    paramAppGroupCreationContent = paramAppGroupCreationContent.getAppGroupPrivacy();
    if (paramAppGroupCreationContent != null) {
      Utility.putNonEmptyString(localBundle, "privacy", paramAppGroupCreationContent.toString().toLowerCase(Locale.ENGLISH));
    }
    return localBundle;
  }
  
  public static Bundle create(GameRequestContent paramGameRequestContent)
  {
    Bundle localBundle = new Bundle();
    Utility.putNonEmptyString(localBundle, "message", paramGameRequestContent.getMessage());
    Utility.putCommaSeparatedStringList(localBundle, "to", paramGameRequestContent.getRecipients());
    Utility.putNonEmptyString(localBundle, "title", paramGameRequestContent.getTitle());
    Utility.putNonEmptyString(localBundle, "data", paramGameRequestContent.getData());
    if (paramGameRequestContent.getActionType() != null) {
      Utility.putNonEmptyString(localBundle, "action_type", paramGameRequestContent.getActionType().toString().toLowerCase(Locale.ENGLISH));
    }
    Utility.putNonEmptyString(localBundle, "object_id", paramGameRequestContent.getObjectId());
    if (paramGameRequestContent.getFilters() != null) {
      Utility.putNonEmptyString(localBundle, "filters", paramGameRequestContent.getFilters().toString().toLowerCase(Locale.ENGLISH));
    }
    Utility.putCommaSeparatedStringList(localBundle, "suggestions", paramGameRequestContent.getSuggestions());
    return localBundle;
  }
  
  public static Bundle create(ShareLinkContent paramShareLinkContent)
  {
    Bundle localBundle = createBaseParameters(paramShareLinkContent);
    Utility.putUri(localBundle, "href", paramShareLinkContent.getContentUrl());
    Utility.putNonEmptyString(localBundle, "quote", paramShareLinkContent.getQuote());
    return localBundle;
  }
  
  public static Bundle create(ShareOpenGraphContent paramShareOpenGraphContent)
  {
    Bundle localBundle = createBaseParameters(paramShareOpenGraphContent);
    Utility.putNonEmptyString(localBundle, "action_type", paramShareOpenGraphContent.getAction().getActionType());
    try
    {
      paramShareOpenGraphContent = ShareInternalUtility.removeNamespacesFromOGJsonObject(ShareInternalUtility.toJSONObjectForWeb(paramShareOpenGraphContent), false);
      if (paramShareOpenGraphContent != null) {
        Utility.putNonEmptyString(localBundle, "action_properties", paramShareOpenGraphContent.toString());
      }
      return localBundle;
    }
    catch (JSONException paramShareOpenGraphContent)
    {
      throw new FacebookException("Unable to serialize the ShareOpenGraphContent to JSON", paramShareOpenGraphContent);
    }
  }
  
  public static Bundle createBaseParameters(ShareContent paramShareContent)
  {
    Bundle localBundle = new Bundle();
    paramShareContent = paramShareContent.getShareHashtag();
    if (paramShareContent != null) {
      Utility.putNonEmptyString(localBundle, "hashtag", paramShareContent.getHashtag());
    }
    return localBundle;
  }
  
  public static Bundle createForFeed(ShareFeedContent paramShareFeedContent)
  {
    Bundle localBundle = new Bundle();
    Utility.putNonEmptyString(localBundle, "to", paramShareFeedContent.getToId());
    Utility.putNonEmptyString(localBundle, "link", paramShareFeedContent.getLink());
    Utility.putNonEmptyString(localBundle, "picture", paramShareFeedContent.getPicture());
    Utility.putNonEmptyString(localBundle, "source", paramShareFeedContent.getMediaSource());
    Utility.putNonEmptyString(localBundle, "name", paramShareFeedContent.getLinkName());
    Utility.putNonEmptyString(localBundle, "caption", paramShareFeedContent.getLinkCaption());
    Utility.putNonEmptyString(localBundle, "description", paramShareFeedContent.getLinkDescription());
    return localBundle;
  }
  
  public static Bundle createForFeed(ShareLinkContent paramShareLinkContent)
  {
    Bundle localBundle = new Bundle();
    Utility.putNonEmptyString(localBundle, "name", paramShareLinkContent.getContentTitle());
    Utility.putNonEmptyString(localBundle, "description", paramShareLinkContent.getContentDescription());
    Utility.putNonEmptyString(localBundle, "link", Utility.getUriString(paramShareLinkContent.getContentUrl()));
    Utility.putNonEmptyString(localBundle, "picture", Utility.getUriString(paramShareLinkContent.getImageUrl()));
    Utility.putNonEmptyString(localBundle, "quote", paramShareLinkContent.getQuote());
    if (paramShareLinkContent.getShareHashtag() != null) {
      Utility.putNonEmptyString(localBundle, "hashtag", paramShareLinkContent.getShareHashtag().getHashtag());
    }
    return localBundle;
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.WebDialogParameters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */