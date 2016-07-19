package com.mobileapptracker;

import android.os.Bundle;
import java.lang.reflect.Method;
import java.util.Locale;

class MATFBBridge
{
  private static boolean justActivated = false;
  private static Object logger;
  
  private static void addBundleValue(Bundle paramBundle, String paramString1, String paramString2)
  {
    if (paramString2 != null) {
      paramBundle.putString(paramString1, paramString2);
    }
  }
  
  public static void logEvent(MATEvent paramMATEvent)
  {
    if (logger != null) {}
    for (;;)
    {
      Object localObject2;
      double d2;
      try
      {
        localObject2 = Double.TYPE;
        localMethod = logger.getClass().getMethod("logEvent", new Class[] { String.class, localObject2, Bundle.class });
        localObject2 = paramMATEvent.getEventName();
        d2 = paramMATEvent.getRevenue();
        localMATParameters = MATParameters.getInstance();
        localObject3 = paramMATEvent.getEventName().toLowerCase(Locale.US);
        if (!((String)localObject3).contains("session")) {
          break label231;
        }
        if (!justActivated) {
          break label506;
        }
        return;
      }
      catch (Exception paramMATEvent)
      {
        Method localMethod;
        MATParameters localMATParameters;
        Object localObject1;
        paramMATEvent.printStackTrace();
        return;
      }
      Object localObject3 = new Bundle();
      addBundleValue((Bundle)localObject3, "fb_currency", paramMATEvent.getCurrencyCode());
      addBundleValue((Bundle)localObject3, "fb_content_id", paramMATEvent.getContentId());
      addBundleValue((Bundle)localObject3, "fb_content_type", paramMATEvent.getContentType());
      addBundleValue((Bundle)localObject3, "fb_search_string", paramMATEvent.getSearchString());
      addBundleValue((Bundle)localObject3, "fb_num_items", Integer.toString(paramMATEvent.getQuantity()));
      addBundleValue((Bundle)localObject3, "fb_level", Integer.toString(paramMATEvent.getLevel()));
      addBundleValue((Bundle)localObject3, "tune_referral_source", localMATParameters.getReferralSource());
      addBundleValue((Bundle)localObject3, "tune_source_sdk", "TUNE-MAT");
      localMethod.invoke(logger, new Object[] { localObject2, Double.valueOf(localObject1), localObject3 });
      justActivated = false;
      return;
      label231:
      double d1;
      if (((String)localObject3).contains("registration"))
      {
        localObject2 = "fb_mobile_complete_registration";
        d1 = d2;
      }
      else if (((String)localObject3).contains("content_view"))
      {
        localObject2 = "fb_mobile_content_view";
        d1 = d2;
      }
      else if (((String)localObject3).contains("search"))
      {
        localObject2 = "fb_mobile_search";
        d1 = d2;
      }
      else
      {
        if (((String)localObject3).contains("rated")) {
          localObject2 = "fb_mobile_rate";
        }
        try
        {
          d1 = paramMATEvent.getRating();
          continue;
          if (((String)localObject3).contains("tutorial_complete"))
          {
            localObject2 = "fb_mobile_tutorial_completion";
            d1 = d2;
            continue;
          }
          if (((String)localObject3).contains("add_to_cart"))
          {
            localObject2 = "fb_mobile_add_to_cart";
            d1 = d2;
            continue;
          }
          if (((String)localObject3).contains("add_to_wishlist"))
          {
            localObject2 = "fb_mobile_add_to_wishlist";
            d1 = d2;
            continue;
          }
          if (((String)localObject3).contains("checkout_initiated"))
          {
            localObject2 = "fb_mobile_initiated_checkout";
            d1 = d2;
            continue;
          }
          if (((String)localObject3).contains("added_payment_info"))
          {
            localObject2 = "fb_mobile_add_payment_info";
            d1 = d2;
            continue;
          }
          if (((String)localObject3).contains("purchase"))
          {
            localObject2 = "fb_mobile_purchase";
            d1 = d2;
            continue;
          }
          if (((String)localObject3).contains("level_achieved"))
          {
            localObject2 = "fb_mobile_level_achieved";
            d1 = d2;
            continue;
          }
          if (((String)localObject3).contains("achievement_unlocked"))
          {
            localObject2 = "fb_mobile_achievement_unlocked";
            d1 = d2;
            continue;
          }
          d1 = d2;
          if (!((String)localObject3).contains("spent_credits")) {
            continue;
          }
          localObject2 = "fb_mobile_spent_credits";
        }
        catch (Exception localException1)
        {
          try
          {
            int i = paramMATEvent.getQuantity();
            d1 = i;
          }
          catch (Exception localException2)
          {
            d1 = d2;
          }
          localException1 = localException1;
          d1 = d2;
        }
        continue;
        continue;
        return;
        label506:
        localObject2 = "fb_mobile_activate_app";
        d1 = d2;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.mobileapptracker.MATFBBridge
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */