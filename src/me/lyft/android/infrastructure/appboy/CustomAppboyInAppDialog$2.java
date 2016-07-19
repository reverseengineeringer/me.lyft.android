package me.lyft.android.infrastructure.appboy;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.appboy.enums.inappmessage.ClickAction;
import com.appboy.models.MessageButton;
import me.lyft.android.analytics.core.UxAnalytics;
import me.lyft.android.analytics.definitions.Category;
import me.lyft.android.analytics.definitions.UiElement;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.deeplinks.DeepLink;
import me.lyft.android.deeplinks.DeepLinkManager;
import me.lyft.android.logging.L;

class CustomAppboyInAppDialog$2
  implements View.OnClickListener
{
  CustomAppboyInAppDialog$2(CustomAppboyInAppDialog paramCustomAppboyInAppDialog, boolean paramBoolean, MessageButton paramMessageButton) {}
  
  public void onClick(View paramView)
  {
    if (val$isPrimary) {}
    for (paramView = UiElement.APPBOY_INAPP_PRIMARY;; paramView = UiElement.APPBOY_INAPP_SECONDARY)
    {
      UxAnalytics.tapped(paramView).setParameter(CustomAppboyInAppDialog.access$000(this$0)).setTag(Category.APPBOY.toString()).track();
      this$0.dialogFlow.dismiss();
      if (val$messageButton.getClickAction().equals(ClickAction.URI))
      {
        paramView = val$messageButton.getUri();
        if (!paramView.getScheme().equals("lyft")) {
          break;
        }
        this$0.deepLinkManager.tryHandleDeepLink(new DeepLink(paramView));
      }
      return;
    }
    try
    {
      this$0.getContext().startActivity(new Intent("android.intent.action.VIEW", paramView));
      return;
    }
    catch (ActivityNotFoundException paramView)
    {
      L.e(paramView, "AppBoy Dialog click", new Object[0]);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.appboy.CustomAppboyInAppDialog.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */