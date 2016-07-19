package com.facebook.internal;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.AccessToken;
import com.facebook.FacebookDialogException;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.R.drawable;
import com.facebook.R.string;
import java.util.Locale;

public class WebDialog
  extends Dialog
{
  private static final int API_EC_DIALOG_CANCEL = 4201;
  private static final int BACKGROUND_GRAY = -872415232;
  static final String CANCEL_URI = "fbconnect://cancel";
  public static final int DEFAULT_THEME = 16973840;
  static final boolean DISABLE_SSL_CHECK_FOR_TESTING = false;
  private static final String DISPLAY_TOUCH = "touch";
  private static final String LOG_TAG = "FacebookSDK.WebDialog";
  private static final int MAX_PADDING_SCREEN_HEIGHT = 1280;
  private static final int MAX_PADDING_SCREEN_WIDTH = 800;
  private static final double MIN_SCALE_FACTOR = 0.5D;
  private static final int NO_PADDING_SCREEN_HEIGHT = 800;
  private static final int NO_PADDING_SCREEN_WIDTH = 480;
  static final String REDIRECT_URI = "fbconnect://success";
  private FrameLayout contentFrameLayout;
  private ImageView crossImageView;
  private String expectedRedirectUrl = "fbconnect://success";
  private boolean isDetached = false;
  private boolean isPageFinished = false;
  private boolean listenerCalled = false;
  private OnCompleteListener onCompleteListener;
  private ProgressDialog spinner;
  private String url;
  private WebView webView;
  
  public WebDialog(Context paramContext, String paramString)
  {
    this(paramContext, paramString, FacebookSdk.getWebDialogTheme());
  }
  
  public WebDialog(Context paramContext, String paramString, int paramInt)
  {
    super(paramContext, i);
    url = paramString;
  }
  
  public WebDialog(Context paramContext, String paramString, Bundle paramBundle, int paramInt, OnCompleteListener paramOnCompleteListener)
  {
    super(paramContext, i);
    paramContext = paramBundle;
    if (paramBundle == null) {
      paramContext = new Bundle();
    }
    paramContext.putString("redirect_uri", "fbconnect://success");
    paramContext.putString("display", "touch");
    paramContext.putString("sdk", String.format(Locale.ROOT, "android-%s", new Object[] { FacebookSdk.getSdkVersion() }));
    url = Utility.buildUri(ServerProtocol.getDialogAuthority(), ServerProtocol.getAPIVersion() + "/" + "dialog/" + paramString, paramContext).toString();
    onCompleteListener = paramOnCompleteListener;
  }
  
  private void createCrossImage()
  {
    crossImageView = new ImageView(getContext());
    crossImageView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        cancel();
      }
    });
    Drawable localDrawable = getContext().getResources().getDrawable(R.drawable.com_facebook_close);
    crossImageView.setImageDrawable(localDrawable);
    crossImageView.setVisibility(4);
  }
  
  private int getScaledSize(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    int i = (int)(paramInt1 / paramFloat);
    double d;
    if (i <= paramInt2) {
      d = 1.0D;
    }
    for (;;)
    {
      return (int)(paramInt1 * d);
      if (i >= paramInt3) {
        d = 0.5D;
      } else {
        d = 0.5D + (paramInt3 - i) / (paramInt3 - paramInt2) * 0.5D;
      }
    }
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  private void setUpWebView(int paramInt)
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    webView = new WebView(getContext().getApplicationContext())
    {
      public void onWindowFocusChanged(boolean paramAnonymousBoolean)
      {
        try
        {
          super.onWindowFocusChanged(paramAnonymousBoolean);
          return;
        }
        catch (NullPointerException localNullPointerException) {}
      }
    };
    webView.setVerticalScrollBarEnabled(false);
    webView.setHorizontalScrollBarEnabled(false);
    webView.setWebViewClient(new DialogWebViewClient(null));
    webView.getSettings().setJavaScriptEnabled(true);
    webView.loadUrl(url);
    webView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    webView.setVisibility(4);
    webView.getSettings().setSavePassword(false);
    webView.getSettings().setSaveFormData(false);
    webView.setFocusable(true);
    webView.setFocusableInTouchMode(true);
    webView.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (!paramAnonymousView.hasFocus()) {
          paramAnonymousView.requestFocus();
        }
        return false;
      }
    });
    localLinearLayout.setPadding(paramInt, paramInt, paramInt, paramInt);
    localLinearLayout.addView(webView);
    localLinearLayout.setBackgroundColor(-872415232);
    contentFrameLayout.addView(localLinearLayout);
  }
  
  public void cancel()
  {
    if ((onCompleteListener != null) && (!listenerCalled)) {
      sendErrorToListener(new FacebookOperationCanceledException());
    }
  }
  
  public void dismiss()
  {
    if (webView != null) {
      webView.stopLoading();
    }
    if ((!isDetached) && (spinner != null) && (spinner.isShowing())) {
      spinner.dismiss();
    }
    super.dismiss();
  }
  
  public OnCompleteListener getOnCompleteListener()
  {
    return onCompleteListener;
  }
  
  protected WebView getWebView()
  {
    return webView;
  }
  
  protected boolean isListenerCalled()
  {
    return listenerCalled;
  }
  
  protected boolean isPageFinished()
  {
    return isPageFinished;
  }
  
  public void onAttachedToWindow()
  {
    isDetached = false;
    super.onAttachedToWindow();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    spinner = new ProgressDialog(getContext());
    spinner.requestWindowFeature(1);
    spinner.setMessage(getContext().getString(R.string.com_facebook_loading));
    spinner.setCanceledOnTouchOutside(false);
    spinner.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        cancel();
      }
    });
    requestWindowFeature(1);
    contentFrameLayout = new FrameLayout(getContext());
    resize();
    getWindow().setGravity(17);
    getWindow().setSoftInputMode(16);
    createCrossImage();
    setUpWebView(crossImageView.getDrawable().getIntrinsicWidth() / 2 + 1);
    contentFrameLayout.addView(crossImageView, new ViewGroup.LayoutParams(-2, -2));
    setContentView(contentFrameLayout);
  }
  
  public void onDetachedFromWindow()
  {
    isDetached = true;
    super.onDetachedFromWindow();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      cancel();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onStart()
  {
    super.onStart();
    resize();
  }
  
  protected Bundle parseResponseUri(String paramString)
  {
    paramString = Uri.parse(paramString);
    Bundle localBundle = Utility.parseUrlQueryString(paramString.getQuery());
    localBundle.putAll(Utility.parseUrlQueryString(paramString.getFragment()));
    return localBundle;
  }
  
  public void resize()
  {
    Display localDisplay = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplay.getMetrics(localDisplayMetrics);
    int i;
    if (widthPixels < heightPixels)
    {
      i = widthPixels;
      if (widthPixels >= heightPixels) {
        break label141;
      }
    }
    label141:
    for (int j = heightPixels;; j = widthPixels)
    {
      i = Math.min(getScaledSize(i, density, 480, 800), widthPixels);
      j = Math.min(getScaledSize(j, density, 800, 1280), heightPixels);
      getWindow().setLayout(i, j);
      return;
      i = heightPixels;
      break;
    }
  }
  
  protected void sendErrorToListener(Throwable paramThrowable)
  {
    if ((onCompleteListener != null) && (!listenerCalled))
    {
      listenerCalled = true;
      if (!(paramThrowable instanceof FacebookException)) {
        break label47;
      }
    }
    label47:
    for (paramThrowable = (FacebookException)paramThrowable;; paramThrowable = new FacebookException(paramThrowable))
    {
      onCompleteListener.onComplete(null, paramThrowable);
      dismiss();
      return;
    }
  }
  
  protected void sendSuccessToListener(Bundle paramBundle)
  {
    if ((onCompleteListener != null) && (!listenerCalled))
    {
      listenerCalled = true;
      onCompleteListener.onComplete(paramBundle, null);
      dismiss();
    }
  }
  
  protected void setExpectedRedirectUrl(String paramString)
  {
    expectedRedirectUrl = paramString;
  }
  
  public void setOnCompleteListener(OnCompleteListener paramOnCompleteListener)
  {
    onCompleteListener = paramOnCompleteListener;
  }
  
  public static class Builder
  {
    private AccessToken accessToken;
    private String action;
    private String applicationId;
    private Context context;
    private WebDialog.OnCompleteListener listener;
    private Bundle parameters;
    private int theme;
    
    public Builder(Context paramContext, String paramString, Bundle paramBundle)
    {
      accessToken = AccessToken.getCurrentAccessToken();
      if (accessToken == null)
      {
        String str = Utility.getMetadataApplicationId(paramContext);
        if (str != null) {
          applicationId = str;
        }
      }
      else
      {
        finishInit(paramContext, paramString, paramBundle);
        return;
      }
      throw new FacebookException("Attempted to create a builder without a valid access token or a valid default Application ID.");
    }
    
    public Builder(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
    {
      String str = paramString1;
      if (paramString1 == null) {
        str = Utility.getMetadataApplicationId(paramContext);
      }
      Validate.notNullOrEmpty(str, "applicationId");
      applicationId = str;
      finishInit(paramContext, paramString2, paramBundle);
    }
    
    private void finishInit(Context paramContext, String paramString, Bundle paramBundle)
    {
      context = paramContext;
      action = paramString;
      if (paramBundle != null)
      {
        parameters = paramBundle;
        return;
      }
      parameters = new Bundle();
    }
    
    public WebDialog build()
    {
      if (accessToken != null)
      {
        parameters.putString("app_id", accessToken.getApplicationId());
        parameters.putString("access_token", accessToken.getToken());
      }
      for (;;)
      {
        return new WebDialog(context, action, parameters, theme, listener);
        parameters.putString("app_id", applicationId);
      }
    }
    
    public String getApplicationId()
    {
      return applicationId;
    }
    
    public Context getContext()
    {
      return context;
    }
    
    public WebDialog.OnCompleteListener getListener()
    {
      return listener;
    }
    
    public Bundle getParameters()
    {
      return parameters;
    }
    
    public int getTheme()
    {
      return theme;
    }
    
    public Builder setOnCompleteListener(WebDialog.OnCompleteListener paramOnCompleteListener)
    {
      listener = paramOnCompleteListener;
      return this;
    }
    
    public Builder setTheme(int paramInt)
    {
      theme = paramInt;
      return this;
    }
  }
  
  private class DialogWebViewClient
    extends WebViewClient
  {
    private DialogWebViewClient() {}
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      if (!isDetached) {
        spinner.dismiss();
      }
      contentFrameLayout.setBackgroundColor(0);
      webView.setVisibility(0);
      crossImageView.setVisibility(0);
      WebDialog.access$702(WebDialog.this, true);
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      Utility.logd("FacebookSDK.WebDialog", "Webview loading URL: " + paramString);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      if (!isDetached) {
        spinner.show();
      }
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      sendErrorToListener(new FacebookDialogException(paramString1, paramInt, paramString2));
    }
    
    public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
    {
      super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
      paramSslErrorHandler.cancel();
      sendErrorToListener(new FacebookDialogException(null, -11, null));
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      Utility.logd("FacebookSDK.WebDialog", "Redirect URL: " + paramString);
      if (paramString.startsWith(expectedRedirectUrl))
      {
        Bundle localBundle = parseResponseUri(paramString);
        paramWebView = localBundle.getString("error");
        paramString = paramWebView;
        if (paramWebView == null) {
          paramString = localBundle.getString("error_type");
        }
        Object localObject = localBundle.getString("error_msg");
        paramWebView = (WebView)localObject;
        if (localObject == null) {
          paramWebView = localBundle.getString("error_message");
        }
        localObject = paramWebView;
        if (paramWebView == null) {
          localObject = localBundle.getString("error_description");
        }
        paramWebView = localBundle.getString("error_code");
        int i = -1;
        if (!Utility.isNullOrEmpty(paramWebView)) {}
        try
        {
          i = Integer.parseInt(paramWebView);
          if ((Utility.isNullOrEmpty(paramString)) && (Utility.isNullOrEmpty((String)localObject)) && (i == -1))
          {
            sendSuccessToListener(localBundle);
            return true;
          }
        }
        catch (NumberFormatException paramWebView)
        {
          for (;;)
          {
            i = -1;
            continue;
            if ((paramString != null) && ((paramString.equals("access_denied")) || (paramString.equals("OAuthAccessDeniedException"))))
            {
              cancel();
            }
            else if (i == 4201)
            {
              cancel();
            }
            else
            {
              paramWebView = new FacebookRequestError(i, paramString, (String)localObject);
              sendErrorToListener(new FacebookServiceException(paramWebView, (String)localObject));
            }
          }
        }
      }
      if (paramString.startsWith("fbconnect://cancel"))
      {
        cancel();
        return true;
      }
      if (paramString.contains("touch")) {
        return false;
      }
      try
      {
        getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
        return true;
      }
      catch (ActivityNotFoundException paramWebView) {}
      return false;
    }
  }
  
  public static abstract interface OnCompleteListener
  {
    public abstract void onComplete(Bundle paramBundle, FacebookException paramFacebookException);
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.WebDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */