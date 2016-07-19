package com.appboy.ui.inappmessage;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import com.appboy.Constants;
import com.appboy.models.IInAppMessage;
import com.appboy.models.InAppMessageHtmlBase;
import com.appboy.models.InAppMessageHtmlFull;
import com.appboy.support.AppboyImageUtils;
import com.appboy.support.AppboyLogger;
import com.appboy.support.StringUtils;
import com.appboy.support.WebContentUtils;
import com.appboy.ui.support.FrescoLibraryUtils;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;

public class AppboyAsyncInAppMessageDisplayer
  extends AsyncTask<IInAppMessage, Integer, IInAppMessage>
{
  private static final String TAG = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, AppboyAsyncInAppMessageDisplayer.class.getName() });
  
  private Activity getInAppMessageManagerActivity()
  {
    return AppboyInAppMessageManager.getInstance().getActivity();
  }
  
  protected IInAppMessage doInBackground(IInAppMessage... paramVarArgs)
  {
    boolean bool;
    try
    {
      AppboyLogger.d(TAG, "Starting asynchronous in-app message preparation.");
      Activity localActivity = getInAppMessageManagerActivity();
      if (localActivity == null)
      {
        AppboyLogger.e(TAG, "No activity is currently registered to receive in-app messages. Doing nothing.");
        return null;
      }
      paramVarArgs = paramVarArgs[0];
      if ((paramVarArgs instanceof InAppMessageHtmlFull)) {
        bool = prepareInAppMessageWithHtml(paramVarArgs);
      } else if (FrescoLibraryUtils.canUseFresco(localActivity.getApplicationContext())) {
        bool = prepareInAppMessageWithFresco(paramVarArgs);
      } else {
        bool = prepareInAppMessageWithBitmapDownload(paramVarArgs);
      }
    }
    catch (Exception paramVarArgs)
    {
      AppboyLogger.e(TAG, "Error running AsyncInAppMessageDisplayer", paramVarArgs);
      paramVarArgs = null;
    }
    do
    {
      return paramVarArgs;
    } while (bool);
    return null;
  }
  
  protected void onPostExecute(final IInAppMessage paramIInAppMessage)
  {
    try
    {
      Activity localActivity = getInAppMessageManagerActivity();
      if (localActivity == null)
      {
        AppboyLogger.e(TAG, "No activity is currently registered to receive in-app messages. Not displayingin-app message.");
        return;
      }
      AppboyLogger.d(TAG, "Finished asynchronous in-app message preparation. Attempting to display in-app message.");
      if (paramIInAppMessage != null)
      {
        localActivity.runOnUiThread(new Runnable()
        {
          public void run()
          {
            AppboyLogger.d(AppboyAsyncInAppMessageDisplayer.TAG, "Displaying in-app message.");
            AppboyInAppMessageManager.getInstance().displayInAppMessage(paramIInAppMessage);
          }
        });
        return;
      }
    }
    catch (Exception paramIInAppMessage)
    {
      AppboyLogger.e(TAG, "Error running onPostExecute", paramIInAppMessage);
      return;
    }
    AppboyLogger.e(TAG, "Cannot display the in-app message because the in-app message was null.");
  }
  
  boolean prepareInAppMessageWithBitmapDownload(IInAppMessage paramIInAppMessage)
  {
    if (paramIInAppMessage.getBitmap() != null)
    {
      AppboyLogger.i(TAG, "In-app message already contains image bitmap. Not downloading image from URL.");
      paramIInAppMessage.setImageDownloadSuccessful(true);
      return true;
    }
    String str = paramIInAppMessage.getLocalImageUrl();
    if ((!StringUtils.isNullOrBlank(str)) && (new File(str).exists()))
    {
      AppboyLogger.i(TAG, "In-app message has local image url.");
      paramIInAppMessage.setBitmap(AppboyImageUtils.getBitmap(Uri.parse(str)));
    }
    if (paramIInAppMessage.getBitmap() == null)
    {
      str = paramIInAppMessage.getRemoteImageUrl();
      if (!StringUtils.isNullOrBlank(str))
      {
        AppboyLogger.i(TAG, "In-app message has remote image url. Downloading.");
        paramIInAppMessage.setBitmap(AppboyImageUtils.getBitmap(Uri.parse(str)));
      }
    }
    else
    {
      if (paramIInAppMessage.getBitmap() == null) {
        break label151;
      }
      paramIInAppMessage.setImageDownloadSuccessful(true);
      return true;
    }
    AppboyLogger.w(TAG, "In-app message has no remote image url. Not downloading image.");
    return true;
    label151:
    return false;
  }
  
  boolean prepareInAppMessageWithFresco(IInAppMessage paramIInAppMessage)
  {
    String str = paramIInAppMessage.getLocalImageUrl();
    if ((!StringUtils.isNullOrBlank(str)) && (new File(str).exists()))
    {
      AppboyLogger.i(TAG, "In-app message has local image url for Fresco display. Not downloading image.");
      paramIInAppMessage.setImageDownloadSuccessful(true);
      return true;
    }
    paramIInAppMessage.setLocalImageUrl(null);
    str = paramIInAppMessage.getRemoteImageUrl();
    if (StringUtils.isNullOrBlank(str))
    {
      AppboyLogger.w(TAG, "In-app message has no remote image url. Not downloading image.");
      return true;
    }
    DataSource localDataSource = Fresco.getImagePipeline().prefetchToDiskCache(ImageRequest.fromUri(str), new Object());
    while (!localDataSource.isFinished()) {}
    boolean bool;
    if (!localDataSource.hasFailed())
    {
      bool = true;
      if (!bool) {
        break label145;
      }
      paramIInAppMessage.setImageDownloadSuccessful(true);
    }
    for (;;)
    {
      localDataSource.close();
      return bool;
      bool = false;
      break;
      label145:
      if (localDataSource.getFailureCause() == null) {
        AppboyLogger.w(TAG, "Fresco disk prefetch failed with null cause for remote image url:" + str);
      } else {
        AppboyLogger.w(TAG, "Fresco disk prefetch failed with cause: " + localDataSource.getFailureCause().getMessage() + " with remote image url: " + str);
      }
    }
  }
  
  boolean prepareInAppMessageWithHtml(IInAppMessage paramIInAppMessage)
  {
    Object localObject = getInAppMessageManagerActivity();
    if (localObject == null)
    {
      AppboyLogger.e(TAG, "Can't store HTML in-app message assets because activity is null.");
      return false;
    }
    paramIInAppMessage = (InAppMessageHtmlBase)paramIInAppMessage;
    String str = paramIInAppMessage.getLocalAssetsDirectoryUrl();
    if ((!StringUtils.isNullOrBlank(str)) && (new File(str).exists()))
    {
      AppboyLogger.i(TAG, "Local assets for html in-app message are already populated. Not downloading assets.");
      return true;
    }
    if (StringUtils.isNullOrBlank(paramIInAppMessage.getAssetsZipRemoteUrl()))
    {
      AppboyLogger.i(TAG, "Html in-app message has no remote asset zip. Continuing with in-app message preparation.");
      return true;
    }
    localObject = WebContentUtils.getLocalHtmlUrlFromRemoteUrl(WebContentUtils.getHtmlInAppMessageAssetCacheDirectory((Context)localObject), paramIInAppMessage.getAssetsZipRemoteUrl());
    if (!StringUtils.isNullOrBlank((String)localObject))
    {
      AppboyLogger.d(TAG, "Local url for html in-app message assets is " + (String)localObject);
      paramIInAppMessage.setLocalAssetsDirectoryUrl((String)localObject);
      return true;
    }
    AppboyLogger.w(TAG, String.format("Download of html content to local directory failed for remote url: %s . Returned local url is: %s", new Object[] { paramIInAppMessage.getAssetsZipRemoteUrl(), localObject }));
    return false;
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.AppboyAsyncInAppMessageDisplayer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */