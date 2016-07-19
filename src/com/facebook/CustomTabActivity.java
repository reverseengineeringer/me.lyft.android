package com.facebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class CustomTabActivity
  extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new Intent(this, FacebookActivity.class);
    paramBundle.putExtra("url", getIntent().getDataString());
    paramBundle.addFlags(603979776);
    startActivity(paramBundle);
  }
}

/* Location:
 * Qualified Name:     com.facebook.CustomTabActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */