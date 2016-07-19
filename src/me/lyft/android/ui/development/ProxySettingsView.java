package me.lyft.android.ui.development;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import com.squareup.okhttp.OkHttpClient;
import java.net.Proxy;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.common.Strings;
import me.lyft.android.controls.Toolbar;

public class ProxySettingsView
  extends LinearLayout
{
  Button enableProxyButton;
  EditText ipAddress1TextView;
  EditText ipAddress2TextView;
  EditText ipAddress3TextView;
  EditText ipAddress4TextView;
  @Inject
  ILyftPreferences lyftPreferences;
  @Inject
  OkHttpClient okHttpClient;
  Toolbar toolbar;
  
  public ProxySettingsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private String getIpAddress()
  {
    return Strings.joinWithDelimiter(".", new String[] { ipAddress1TextView.getText().toString(), ipAddress2TextView.getText().toString(), ipAddress3TextView.getText().toString(), ipAddress4TextView.getText().toString() });
  }
  
  private boolean isProxyEnabled()
  {
    Proxy localProxy = okHttpClient.getProxy();
    return (localProxy != null) && (!localProxy.equals(Proxy.NO_PROXY));
  }
  
  private void setIpAddress(String paramString)
  {
    paramString = paramString.split("\\.");
    if (paramString.length > 0) {
      ipAddress1TextView.setText(paramString[0]);
    }
    if (paramString.length > 1) {
      ipAddress2TextView.setText(paramString[1]);
    }
    if (paramString.length > 2) {
      ipAddress3TextView.setText(paramString[2]);
    }
    if (paramString.length > 3) {
      ipAddress4TextView.setText(paramString[3]);
    }
  }
  
  private void updateProxyButtonText()
  {
    if (isProxyEnabled())
    {
      enableProxyButton.setText(2131165560);
      return;
    }
    enableProxyButton.setText(2131165675);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    toolbar.setTitle(getResources().getString(2131166193));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
    updateProxyButtonText();
    setIpAddress(lyftPreferences.getProxyIpAddress());
    enableProxyButton.setOnClickListener(new ProxySettingsView.1(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.development.ProxySettingsView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */