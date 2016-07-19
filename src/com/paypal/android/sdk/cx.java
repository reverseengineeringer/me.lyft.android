package com.paypal.android.sdk;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public final class cx
{
  public LinearLayout a;
  public RelativeLayout b;
  public final Button c;
  private final TableLayout d;
  private ImageView e;
  private TextView f;
  private TextView g;
  
  public cx(Context paramContext)
  {
    a = new LinearLayout(paramContext);
    a.setLayoutParams(bj.a());
    a.setOrientation(1);
    bj.a(a);
    d = new TableLayout(paramContext);
    d.setColumnShrinkable(0, false);
    d.setColumnStretchable(0, false);
    d.setColumnStretchable(1, false);
    d.setColumnShrinkable(1, false);
    TableRow localTableRow = new TableRow(paramContext);
    d.addView(localTableRow);
    a.addView(d);
    b = new RelativeLayout(paramContext);
    localTableRow.addView(b);
    bj.a(b, 19, 1.0F);
    bj.b(b, null, null, "10dip", null);
    g = new TextView(paramContext);
    bj.c(g, 0);
    g.setId(2301);
    b.addView(g);
    bj.b(g, "6dip", null, null, null);
    f = new TextView(paramContext);
    bj.b(f, 0);
    f.setId(2302);
    RelativeLayout.LayoutParams localLayoutParams = bj.a(-2, -2, 3, 2301);
    b.addView(f, localLayoutParams);
    bj.b(f, "6dip", null, null, null);
    e = bj.a(paramContext, "iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAATZJREFUeNrsmMENgkAQRVnPUoAWQB0WoAVoAViA3tW7FEADUIDebUAaoAELwDv+TcaEkFUOsDhj5ieTTdgQ5jHLZ3aDQKVSqVSqAVTX9Q4RSUw8RKSIO+KGmI/5fNMzeZvsGdF88yVia4ypxgCY9Lx/ipi1rkUExb8CVIXFh4SvqMKRPQBBrDAcHFMJIHL2AG8XwrB2TJ0AcWEPQBB2ySwdUxtAlBIAQgxpy5WsKnKmkjVAAyJzuJMXezU+ykp/ZFuJsA0BgA17gAZE5ttevQF02GsOiIQ9AEHEGGJf9uodoMNe7UddsAcgiMyHvU4C4dIl9NcfsWgbFf0jE91KiG7mxLfTojc0oreUojf1oo9VvthlgeS3Y7QpfZu5J+LhsMu9mG7w14e7Q4LIPF5XqVQqlWi9BBgAacm2vqgEoPIAAAAASUVORK5CYII=", "go to selection");
    e.setId(2307);
    e.setColorFilter(bi.g);
    localLayoutParams = bj.a(paramContext, "20dip", "20dip", 15);
    localLayoutParams.addRule(1, 2302);
    localLayoutParams.addRule(1, 2301);
    b.addView(e, localLayoutParams);
    c = new Button(paramContext);
    c.setId(2305);
    bj.a(c, 21);
    c.setTextSize(18.0F);
    localTableRow.addView(c);
    bj.b(c, null, null, "6dip", null);
    bj.a(c, 21, 1.0F);
    bj.a(a);
    a.setVisibility(0);
  }
  
  public final void a(String paramString)
  {
    f.setText(paramString);
    bj.a(f, -2, -1);
    f.setEllipsize(TextUtils.TruncateAt.START);
  }
  
  public final void a(boolean paramBoolean)
  {
    b.setClickable(paramBoolean);
    ImageView localImageView = e;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public final void b(String paramString)
  {
    g.setText(paramString);
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.cx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */