package com.braintreepayments.api.threedsecure;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import com.braintreepayments.api.annotations.Beta;
import com.braintreepayments.api.models.ThreeDSecureAuthenticationResponse;
import com.braintreepayments.api.models.ThreeDSecureLookup;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

@Beta
public class ThreeDSecureWebViewActivity
  extends Activity
{
  public static final String EXTRA_THREE_D_SECURE_LOOKUP = "com.braintreepayments.api.EXTRA_THREE_D_SECURE_LOOKUP";
  public static final String EXTRA_THREE_D_SECURE_RESULT = "com.braintreepayments.api.EXTRA_THREE_D_SECURE_RESULT";
  private ActionBar mActionBar;
  private FrameLayout mRootView;
  private Stack<ThreeDSecureWebView> mThreeDSecureWebViews;
  
  @TargetApi(11)
  private void setupActionBar()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      mActionBar = getActionBar();
      if (mActionBar != null)
      {
        setActionBarTitle("");
        mActionBar.setDisplayHomeAsUpEnabled(true);
      }
    }
  }
  
  protected void finishWithResult(ThreeDSecureAuthenticationResponse paramThreeDSecureAuthenticationResponse)
  {
    setResult(-1, new Intent().putExtra("com.braintreepayments.api.EXTRA_THREE_D_SECURE_RESULT", paramThreeDSecureAuthenticationResponse));
    finish();
  }
  
  public void onBackPressed()
  {
    if (((ThreeDSecureWebView)mThreeDSecureWebViews.peek()).canGoBack())
    {
      ((ThreeDSecureWebView)mThreeDSecureWebViews.peek()).goBack();
      return;
    }
    if (mThreeDSecureWebViews.size() > 1)
    {
      popCurrentWebView();
      return;
    }
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(2);
    paramBundle = (ThreeDSecureLookup)getIntent().getParcelableExtra("com.braintreepayments.api.EXTRA_THREE_D_SECURE_LOOKUP");
    if (paramBundle == null) {
      throw new IllegalArgumentException("A ThreeDSecureLookup must be specified with " + ThreeDSecureLookup.class.getSimpleName() + ".EXTRA_THREE_D_SECURE_LOOKUP extra");
    }
    setupActionBar();
    mThreeDSecureWebViews = new Stack();
    mRootView = ((FrameLayout)findViewById(16908290));
    Object localObject = new LinkedList();
    ((List)localObject).add(new BasicNameValuePair("PaReq", paramBundle.getPareq()));
    ((List)localObject).add(new BasicNameValuePair("MD", paramBundle.getMd()));
    ((List)localObject).add(new BasicNameValuePair("TermUrl", paramBundle.getTermUrl()));
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      new UrlEncodedFormEntity((List)localObject, "UTF-8").writeTo(localByteArrayOutputStream);
      localObject = new ThreeDSecureWebView(this);
      ((ThreeDSecureWebView)localObject).init(this);
      ((ThreeDSecureWebView)localObject).postUrl(paramBundle.getAcsUrl(), localByteArrayOutputStream.toByteArray());
      pushNewWebView((ThreeDSecureWebView)localObject);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        finish();
      }
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      setResult(0);
      finish();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void popCurrentWebView()
  {
    mThreeDSecureWebViews.pop();
    pushNewWebView((ThreeDSecureWebView)mThreeDSecureWebViews.pop());
  }
  
  protected void pushNewWebView(ThreeDSecureWebView paramThreeDSecureWebView)
  {
    mThreeDSecureWebViews.push(paramThreeDSecureWebView);
    mRootView.removeAllViews();
    mRootView.addView(paramThreeDSecureWebView);
  }
  
  @TargetApi(11)
  protected void setActionBarTitle(String paramString)
  {
    if (mActionBar != null) {
      mActionBar.setTitle(paramString);
    }
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.threedsecure.ThreeDSecureWebViewActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */