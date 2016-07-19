package me.lyft.android.infrastructure.appboy;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.appboy.enums.inappmessage.ClickAction;
import com.appboy.models.IInAppMessage;
import com.appboy.models.MessageButton;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import com.squareup.picasso.RequestCreator;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.analytics.core.UxAnalytics;
import me.lyft.android.analytics.definitions.Category;
import me.lyft.android.analytics.definitions.UiElement;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Strings;
import me.lyft.android.deeplinks.DeepLink;
import me.lyft.android.deeplinks.DeepLinkManager;
import me.lyft.android.logging.L;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.ui.AppboyScreens.AppBoyInappDialog;
import me.lyft.android.ui.dialogs.DialogContainerView;
import org.json.JSONObject;

public class CustomAppboyInAppDialog
  extends DialogContainerView
{
  private static final String CAMPAIGN_ID = "campaign_id";
  View background;
  LinearLayout buttonLayout;
  ImageView cancelView;
  @Inject
  DeepLinkManager deepLinkManager;
  @Inject
  DialogFlow dialogFlow;
  @Inject
  ImageLoader imageLoader;
  ImageView imageView;
  private final IInAppMessage inAppMessage;
  TextView messageTextView;
  private final AppboyScreens.AppBoyInappDialog params;
  TextView titleTextView;
  
  public CustomAppboyInAppDialog(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    params = ((AppboyScreens.AppBoyInappDialog)Screen.fromView(this));
    inAppMessage = params.getAppboyMessage();
  }
  
  private String getCampaignId()
  {
    JSONObject localJSONObject = (JSONObject)inAppMessage.forJsonPut();
    if (localJSONObject != null) {
      return localJSONObject.optString("campaign_id");
    }
    return "no_id";
  }
  
  private View inflateButton(final MessageButton paramMessageButton, final boolean paramBoolean)
  {
    Button localButton1 = (Button)inflate(getContext(), 2130903046, null);
    localButton1.setTextColor(paramMessageButton.getTextColor());
    if (paramBoolean) {
      localButton1.setTypeface(null, 1);
    }
    Button localButton2 = (Button)localButton1.findViewById(2131558541);
    localButton2.setBackgroundColor(paramMessageButton.getBackgroundColor());
    localButton2.setText(paramMessageButton.getText());
    localButton2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (paramBoolean) {}
        for (paramAnonymousView = UiElement.APPBOY_INAPP_PRIMARY;; paramAnonymousView = UiElement.APPBOY_INAPP_SECONDARY)
        {
          UxAnalytics.tapped(paramAnonymousView).setParameter(CustomAppboyInAppDialog.this.getCampaignId()).setTag(Category.APPBOY.toString()).track();
          dialogFlow.dismiss();
          if (paramMessageButton.getClickAction().equals(ClickAction.URI))
          {
            paramAnonymousView = paramMessageButton.getUri();
            if (!paramAnonymousView.getScheme().equals("lyft")) {
              break;
            }
            deepLinkManager.tryHandleDeepLink(new DeepLink(paramAnonymousView));
          }
          return;
        }
        try
        {
          getContext().startActivity(new Intent("android.intent.action.VIEW", paramAnonymousView));
          return;
        }
        catch (ActivityNotFoundException paramAnonymousView)
        {
          L.e(paramAnonymousView, "AppBoy Dialog click", new Object[0]);
        }
      }
    });
    return localButton1;
  }
  
  private void inflateButtonLayout(List<MessageButton> paramList)
  {
    boolean bool = true;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageButton localMessageButton = (MessageButton)paramList.next();
      buttonLayout.addView(inflateButton(localMessageButton, bool), buttonLayout.getChildCount());
      bool = false;
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    UxAnalytics.displayed(UiElement.APPBOY_INAPP_NOTE).setTag(Category.APPBOY.toString()).setParameter(getCampaignId()).track();
    titleTextView.setText(params.getHeader());
    titleTextView.setTextColor(params.getTitleColor());
    String str = inAppMessage.getImageUrl();
    if (!Strings.isNullOrEmpty(str))
    {
      imageLoader.load(str).fit().centerInside().into(imageView);
      imageView.setVisibility(0);
    }
    for (;;)
    {
      background.setBackgroundColor(inAppMessage.getBackgroundColor());
      messageTextView.setText(inAppMessage.getMessage());
      messageTextView.setTextColor(inAppMessage.getMessageTextColor());
      inflateButtonLayout(params.getButtons());
      cancelView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          dialogFlow.dismiss();
        }
      });
      return;
      imageView.setVisibility(8);
    }
  }
  
  void onCancelClicked()
  {
    UxAnalytics.dismissed(UiElement.APPBOY_INAPP_NOTE).setTag(Category.APPBOY.toString()).setParameter(getCampaignId()).track();
    dialogFlow.dismiss();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.appboy.CustomAppboyInAppDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */