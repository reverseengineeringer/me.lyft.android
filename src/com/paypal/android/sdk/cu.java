package com.paypal.android.sdk;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class cu
{
  public LinearLayout a;
  public TextView b;
  private LinearLayout c;
  
  public cu(Context paramContext)
  {
    c = new LinearLayout(paramContext);
    c.setOrientation(0);
    b = new TextView(paramContext);
    b.setText("server");
    b.setTextColor(-1);
    b.setBackgroundColor(bi.e);
    b.setGravity(17);
    c.addView(b);
    bj.a(b, "8dip", "8dip", "8dip", "8dip");
    bj.a(b, -2, -2);
    bj.b(b, null, "15dip", null, "15dip");
    bj.a(b, 1, 1.0F);
    a = c;
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.cu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */