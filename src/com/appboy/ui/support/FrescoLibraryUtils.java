package com.appboy.ui.support;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import com.appboy.Constants;
import com.appboy.support.AppboyLogger;
import com.appboy.support.PackageUtils;
import com.appboy.support.StringUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;

public class FrescoLibraryUtils
{
  private static final String FILE_SCHEME = "file";
  public static final String FRESCO_ENABLED = "com_appboy_enable_fresco_library_use";
  private static final String HTTPS_SCHEME = "https";
  private static final String HTTP_SCHEME = "http";
  private static final String TAG = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, FrescoLibraryUtils.class.getName() });
  private static final String[] USED_FRESCO_CLASSES = { "com.facebook.drawee.backends.pipeline.Fresco", "com.facebook.drawee.interfaces.DraweeController", "com.facebook.drawee.view.SimpleDraweeView", "com.facebook.drawee.backends.pipeline.Fresco", "com.facebook.drawee.controller.BaseControllerListener", "com.facebook.drawee.controller.ControllerListener", "com.facebook.imagepipeline.image.ImageInfo" };
  private static boolean sCanUseFresco = false;
  private static boolean sCanUseFrescoSet = false;
  
  public static boolean canUseFresco(Context paramContext)
  {
    bool1 = true;
    if (sCanUseFrescoSet) {
      return sCanUseFresco;
    }
    paramContext = paramContext.getApplicationContext();
    boolean bool2 = getIsFrescoEnabledFromXml(paramContext.getResources(), PackageUtils.getResourcePackageName(paramContext));
    for (;;)
    {
      try
      {
        paramContext = FrescoLibraryUtils.class.getClassLoader();
        int k = 1;
        String[] arrayOfString = USED_FRESCO_CLASSES;
        int m = arrayOfString.length;
        j = 0;
        i = k;
        if (j < m)
        {
          Class localClass = Class.forName(arrayOfString[j], false, paramContext);
          if (localClass != null) {
            continue;
          }
          i = 0;
        }
      }
      catch (Exception paramContext)
      {
        int j;
        i = 0;
        continue;
      }
      catch (NoClassDefFoundError paramContext)
      {
        i = 0;
        continue;
      }
      catch (Throwable paramContext)
      {
        int i = 0;
        continue;
        bool1 = false;
        continue;
      }
      sCanUseFrescoSet = true;
      if ((i == 0) || (!bool2)) {
        continue;
      }
      sCanUseFresco = bool1;
      return sCanUseFresco;
      j += 1;
    }
  }
  
  static boolean canUseFrescoMock(Context paramContext, Resources paramResources, boolean paramBoolean)
  {
    return (paramBoolean) && (getIsFrescoEnabledFromXml(paramResources, PackageUtils.getResourcePackageName(paramContext.getApplicationContext())));
  }
  
  static Uri getFrescoUri(String paramString)
  {
    Uri localUri2 = Uri.parse(paramString);
    Uri localUri1 = localUri2;
    if (StringUtils.isNullOrBlank(localUri2.getScheme())) {
      localUri1 = Uri.parse("file://" + paramString);
    }
    return localUri1;
  }
  
  private static boolean getIsFrescoEnabledFromXml(Resources paramResources, String paramString)
  {
    int i = paramResources.getIdentifier("com_appboy_enable_fresco_library_use", "bool", paramString);
    if (i != 0) {
      return paramResources.getBoolean(i);
    }
    return false;
  }
  
  public static void setDraweeControllerHelper(final SimpleDraweeView paramSimpleDraweeView, String paramString, final float paramFloat, boolean paramBoolean)
  {
    if (paramString == null)
    {
      AppboyLogger.w(TAG, "The url set for the Drawee controller was null. Controller not set.");
      return;
    }
    if (paramSimpleDraweeView == null)
    {
      AppboyLogger.w(TAG, "The SimpleDraweeView set for the Drawee controller was null. Controller not set.");
      return;
    }
    BaseControllerListener local1 = new BaseControllerListener()
    {
      public void onFinalImageSet(String paramAnonymousString, ImageInfo paramAnonymousImageInfo, Animatable paramAnonymousAnimatable)
      {
        if (paramAnonymousImageInfo == null) {
          return;
        }
        if (val$respectAspectRatio) {}
        for (final float f = paramFloat;; f = paramAnonymousImageInfo.getWidth() / paramAnonymousImageInfo.getHeight())
        {
          paramSimpleDraweeView.post(new Runnable()
          {
            public void run()
            {
              val$simpleDraweeView.setAspectRatio(f);
            }
          });
          return;
        }
      }
    };
    try
    {
      paramString = getFrescoUri(paramString);
      paramSimpleDraweeView.setController(((PipelineDraweeControllerBuilder)((PipelineDraweeControllerBuilder)((PipelineDraweeControllerBuilder)Fresco.newDraweeControllerBuilder().setUri(paramString).setAutoPlayAnimations(true)).setTapToRetryEnabled(true)).setControllerListener(local1)).build());
      return;
    }
    catch (NullPointerException paramSimpleDraweeView)
    {
      AppboyLogger.e(TAG, "Fresco controller builder could not be retrieved. Fresco most likely prematurely shutdown.", paramSimpleDraweeView);
      return;
    }
    catch (Exception paramSimpleDraweeView)
    {
      AppboyLogger.e(TAG, "Fresco controller builder could not be retrieved. Fresco most likely prematurely shutdown.", paramSimpleDraweeView);
    }
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.support.FrescoLibraryUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */