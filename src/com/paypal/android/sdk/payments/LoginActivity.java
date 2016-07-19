package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.method.PasswordTransformationMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import com.paypal.android.sdk.bE;
import com.paypal.android.sdk.bM;
import com.paypal.android.sdk.bQ;
import com.paypal.android.sdk.bS;
import com.paypal.android.sdk.bk;
import com.paypal.android.sdk.bn;
import com.paypal.android.sdk.bq;
import com.paypal.android.sdk.cp;
import com.paypal.android.sdk.cq;
import com.paypal.android.sdk.cs;
import com.paypal.android.sdk.cu;
import com.paypal.android.sdk.cv;
import com.paypal.android.sdk.cw;
import com.paypal.android.sdk.cx;
import com.paypal.android.sdk.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class LoginActivity
  extends Activity
{
  private final String a = LoginActivity.class.getSimpleName();
  private af b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private bM i;
  private String j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private int o;
  private cv p;
  private boolean q;
  private PayPalService r;
  private final ServiceConnection s = new O(this);
  
  private bM a(af paramaf)
  {
    g();
    if (paramaf == af.b)
    {
      paramaf = bk.a();
      if (f == null) {}
      for (paramaf = new bS(paramaf, e);; paramaf = new bS(paramaf, new f(f), e)) {
        return new bM(paramaf, g);
      }
    }
    if (paramaf == af.a) {
      return new bM(c, d);
    }
    return i;
  }
  
  static void a(Activity paramActivity, int paramInt, bq parambq, boolean paramBoolean1, boolean paramBoolean2, String paramString, PayPalConfiguration paramPayPalConfiguration)
  {
    parambq = new Intent(paramActivity, LoginActivity.class);
    parambq.putExtras(paramActivity.getIntent());
    parambq.putExtra("com.paypal.android.sdk.payments.persistedLogin", null);
    parambq.putExtra("com.paypal.android.sdk.payments.useResponseTypeCode", true);
    parambq.putExtra("com.paypal.android.sdk.payments.forceLogin", false);
    parambq.putExtra("com.paypal.android.sdk.payments.requestedScopes", paramString);
    parambq.putExtra("com.paypal.android.sdk.paypalConfiguration", paramPayPalConfiguration);
    paramActivity.startActivityForResult(parambq, 1);
  }
  
  private String b()
  {
    if (c()) {
      return "code";
    }
    return "token";
  }
  
  private void b(af paramaf)
  {
    new StringBuilder("changeLoginState:").append(paramaf);
    if (paramaf != null) {
      b = paramaf;
    }
    try
    {
      label24:
      dismissDialog(20);
      dismissDialog(21);
      switch (X.a[b.ordinal()])
      {
      }
      for (;;)
      {
        switch (X.a[b.ordinal()])
        {
        default: 
          return;
          new StringBuilder("null loginState, refreshing:").append(b);
          break label24;
          j();
          m();
          p.b.setEnabled(true);
          p.d.setEnabled(true);
          h();
          continue;
          j();
          n();
          p.b.setEnabled(true);
          p.d.setEnabled(true);
          h();
          continue;
          showDialog(20);
          j();
          m();
          p.b.setEnabled(false);
          p.d.setEnabled(false);
          p.h.setEnabled(false);
          continue;
          showDialog(20);
          j();
          n();
          p.h.setEnabled(false);
          continue;
          l();
          k();
          p.o.c.setText(cq.a(cs.aX));
          p.l.setEnabled(false);
          p.l.setVisibility(8);
          p.m.setEnabled(false);
          p.m.setVisibility(8);
          continue;
          showDialog(21);
          l();
          k();
          p.o.c.setText(cq.a(cs.aY));
          p.l.setEnabled(false);
          p.l.setVisibility(8);
          p.m.setEnabled(false);
          p.m.setVisibility(8);
          continue;
          showDialog(21);
          l();
          k();
          p.o.c.setText(cq.a(cs.aY));
          p.l.setEnabled(false);
          p.l.setVisibility(0);
          p.m.setEnabled(false);
          p.m.setVisibility(0);
          continue;
          l();
          k();
          p.o.c.setText(cq.a(cs.aY));
          p.l.setEnabled(true);
          p.l.setVisibility(0);
          paramaf = p.l;
          paramaf.requestFocus();
          new Handler().postDelayed(new L(this, paramaf), 200L);
          p.m.setVisibility(0);
          i();
          continue;
          showDialog(20);
          l();
          k();
          p.o.c.setText(cq.a(cs.aY));
          p.l.setEnabled(false);
          p.l.setVisibility(0);
          p.m.setEnabled(false);
          p.m.setVisibility(0);
        }
      }
      r.a(new ae(this));
      return;
      r.a(new J(this));
      return;
      r.a(new K(this));
      return;
    }
    catch (IllegalArgumentException paramaf)
    {
      for (;;) {}
    }
  }
  
  private boolean c()
  {
    return getIntent().getBooleanExtra("com.paypal.android.sdk.payments.useResponseTypeCode", false);
  }
  
  private void d()
  {
    if (r.d().g.a.isEmpty())
    {
      o();
      d.a(this, cq.a(cs.aZ), 10);
      return;
    }
    b(af.g);
  }
  
  private void e()
  {
    setResult(-1);
    finish();
  }
  
  private void f()
  {
    d.a(p.c.b, r.f());
    b(null);
  }
  
  private void g()
  {
    if (b == af.b)
    {
      e = p.b.getText().toString();
      g = p.d.getText().toString();
      return;
    }
    c = p.b.getText().toString();
    d = p.d.getText().toString();
  }
  
  private void h()
  {
    boolean bool = true;
    String str1 = p.b.getText().toString();
    String str2 = p.d.getText().toString();
    if (b == af.b) {
      if ((!bQ.d(str1)) || (!bQ.b(str2))) {}
    }
    for (;;)
    {
      p.h.setEnabled(bool);
      p.h.setFocusable(bool);
      return;
      bool = false;
      continue;
      if ((!bQ.a(str1)) || (!bQ.c(str2))) {
        bool = false;
      }
    }
  }
  
  private void i()
  {
    if (6 == p.l.getText().toString().length()) {}
    for (boolean bool = true;; bool = false)
    {
      p.m.setEnabled(bool);
      return;
    }
  }
  
  private void j()
  {
    p.o.a.setVisibility(8);
    p.k.setEnabled(false);
    p.k.setVisibility(8);
    p.o.c.setVisibility(8);
    p.m.setEnabled(false);
    p.m.setVisibility(8);
    p.l.setEnabled(false);
    p.l.setVisibility(8);
  }
  
  private void k()
  {
    d.a(this, null, cs.aS);
    p.k.setEnabled(true);
    p.k.setVisibility(0);
    new StringBuilder("phone numbers: ").append(r.d().g.a);
    ArrayList localArrayList = new ArrayList(r.d().g.a.values());
    p.o.a((String)localArrayList.get(o));
    p.o.a.setVisibility(0);
    if (localArrayList.size() > 1)
    {
      p.o.a(true);
      cw localcw = new cw(this, localArrayList, o);
      new ListView(this).setAdapter(localcw);
      p.o.b.setOnClickListener(new M(this, localcw, localArrayList));
    }
    for (;;)
    {
      p.o.c.setVisibility(0);
      return;
      p.o.a(false);
    }
  }
  
  private void l()
  {
    p.h.setEnabled(false);
    p.h.setVisibility(8);
    p.b.setEnabled(false);
    p.b.setVisibility(8);
    p.d.setEnabled(false);
    p.d.setVisibility(8);
    p.e.setEnabled(false);
    p.e.setVisibility(8);
  }
  
  private void m()
  {
    d.a(this, null, cs.ap);
    p.b.setVisibility(0);
    p.b.setText(c);
    p.b.setHint(cq.a(cs.ad));
    p.b.setInputType(33);
    p.d.setVisibility(0);
    p.d.setText(d);
    p.d.setHint(cq.a(cs.at));
    p.d.setInputType(129);
    if ((p.b.getText().length() > 0) && (p.d.getText().length() == 0)) {
      p.d.requestFocus();
    }
    p.h.setVisibility(0);
    p.e.setVisibility(0);
    p.f.setVisibility(0);
    p.g.setVisibility(0);
    p.j.setText(cq.a(cs.bn));
  }
  
  private void n()
  {
    d.a(this, null, cs.ap);
    p.b.setVisibility(0);
    p.b.setText(e);
    p.b.setHint(cq.a(cs.az));
    p.b.setInputType(3);
    p.d.setVisibility(0);
    p.d.setText(g);
    p.d.setHint(cq.a(cs.aA));
    EditText localEditText = p.d;
    if (Build.VERSION.SDK_INT < 11) {}
    for (int i1 = 2;; i1 = 18)
    {
      localEditText.setInputType(i1);
      if (Build.VERSION.SDK_INT < 11) {
        localEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
      }
      if ((p.b.getText().length() > 0) && (p.d.getText().length() == 0)) {
        p.d.requestFocus();
      }
      p.h.setVisibility(0);
      p.e.setVisibility(0);
      p.f.setVisibility(0);
      p.g.setVisibility(4);
      p.j.setText(cq.a(cs.bm));
      return;
    }
  }
  
  private void o()
  {
    switch (X.a[b.ordinal()])
    {
    default: 
      new StringBuilder().append(b).append(" case not handled");
      return;
    case 1: 
      b(af.e);
      return;
    case 2: 
      b(af.f);
      return;
    case 5: 
      b(af.m);
      return;
    }
    b(af.l);
  }
  
  final void a()
  {
    int i1 = 1;
    Object localObject = r.e();
    if (cq.a)
    {
      p.d.setGravity(5);
      p.b.setGravity(5);
      p.l.setGravity(5);
    }
    if ((!bQ.f(Locale.getDefault().getCountry().toLowerCase(Locale.US))) || (!r.d().i)) {
      p.j.setVisibility(4);
    }
    if (m)
    {
      m = false;
      c = ((PayPalConfiguration)localObject).c();
      String str = ((PayPalConfiguration)localObject).d();
      if (str != null) {
        e = str;
      }
      str = ((PayPalConfiguration)localObject).e();
      if (str != null) {
        f = str;
      }
      if ((((PayPalConfiguration)localObject).f()) && (!((PayPalConfiguration)localObject).b().equals("live")))
      {
        d = ((PayPalConfiguration)localObject).g();
        g = ((PayPalConfiguration)localObject).h();
      }
    }
    if ((getIntent().getBooleanExtra("com.paypal.android.sdk.payments.forceLogin", false)) && (!n))
    {
      n = true;
      r.i();
    }
    if (!r.k())
    {
      if (!k)
      {
        k = true;
        r.a(cp.e, Boolean.valueOf(l));
      }
      if (b == null)
      {
        localObject = (bq)getIntent().getParcelableExtra("com.paypal.android.sdk.payments.persistedLogin");
        if (localObject == null) {
          break label398;
        }
        l = true;
        if (com.paypal.android.sdk.R.a(c))
        {
          if (com.paypal.android.sdk.R.a(((bq)localObject).b())) {
            break label373;
          }
          if (i1 != 0) {
            c = ((bq)localObject).b();
          }
        }
        if ((e == null) && (((bq)localObject).a() != null)) {
          e = ((bq)localObject).a().a(bk.a());
        }
        switch (X.b[localObject.c().ordinal()])
        {
        }
      }
      for (;;)
      {
        f();
        return;
        label373:
        i1 = 0;
        break;
        b(af.a);
        continue;
        b(af.b);
        continue;
        label398:
        b(af.a);
      }
    }
    e();
  }
  
  public final void onBackPressed()
  {
    r.a(cp.j, Boolean.valueOf(l));
    super.onBackPressed();
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    new StringBuilder().append(getClass().getSimpleName()).append(".onCreate");
    j = getIntent().getExtras().getString("com.paypal.android.sdk.payments.requestedScopes");
    q = bindService(d.a(this), s, 1);
    com.paypal.android.sdk.R.b(this);
    com.paypal.android.sdk.R.a(this);
    p = new cv(this);
    setContentView(p.a);
    p.f.setText(cq.a(cs.aN));
    p.g.setText(cq.a(cs.ai));
    p.i.setText(cq.a(cs.ao));
    p.i.setHint(cq.a(cs.ao));
    p.k.setText(cq.a(cs.aT));
    p.l.setHint(cq.a(cs.aV));
    p.n.setText(cq.a(cs.ao));
    p.o.b(cq.a(cs.aW));
    I localI = new I(this);
    p.b.addTextChangedListener(localI);
    p.d.addTextChangedListener(localI);
    p.h.setOnClickListener(new V(this));
    p.g.setOnClickListener(new Y(this));
    p.j.setOnClickListener(new Z(this));
    p.f.setOnClickListener(new aa(this));
    p.o.c.setOnClickListener(new ab(this));
    p.l.addTextChangedListener(new ac(this));
    p.m.setOnClickListener(new ad(this));
    if (paramBundle == null)
    {
      k = false;
      m = true;
    }
    for (;;)
    {
      p.l.setText(h);
      return;
      m = false;
      k = paramBundle.getBoolean("PP_PageTrackingSent");
      b = ((af)paramBundle.getParcelable("PP_LoginType"));
      c = paramBundle.getString("PP_SavedEmail");
      e = paramBundle.getString("PP_SavedPhone");
      f = paramBundle.getString("PP_savedPhoneCountryCode");
      d = paramBundle.getString("PP_SavedPassword");
      g = paramBundle.getString("PP_SavedPIN");
      l = paramBundle.getBoolean("PP_IsReturningUser");
      n = paramBundle.getBoolean("PP_IsClearedLogin");
      j = paramBundle.getString("PP_RequestedScopes");
      h = paramBundle.getString("PP_SavedOTP");
      i = ((bM)paramBundle.getParcelable("PP_OriginalLoginData"));
      o = paramBundle.getInt("PP_TwoFaSelectedPhoneNumberIndex");
    }
  }
  
  protected final Dialog onCreateDialog(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return d.a(this, cs.bl, paramBundle, new Q(this));
    case 2: 
      return d.a(this, cs.bg, paramBundle, new R(this));
    case 3: 
      return d.a(this, cs.bl, paramBundle, new S(this));
    case 4: 
      return d.a(this, cs.bl, paramBundle, new T(this));
    case 5: 
      return d.a(this, cs.aL, paramBundle, new U(this));
    case 10: 
      return d.a(this, cs.bl, paramBundle, new W(this));
    case 20: 
      return d.a(this, cs.c, cs.bo);
    }
    return d.a(this, cs.aU, cs.bo);
  }
  
  protected final void onDestroy()
  {
    new StringBuilder().append(getClass().getSimpleName()).append(".onDestroy");
    if (r != null) {
      r.n();
    }
    if (q)
    {
      unbindService(s);
      q = false;
    }
    super.onDestroy();
  }
  
  protected final void onResume()
  {
    super.onResume();
    new StringBuilder().append(getClass().getSimpleName()).append(".onResume");
    if (r != null) {
      f();
    }
  }
  
  protected final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    g();
    paramBundle.putParcelable("PP_LoginType", b);
    paramBundle.putString("PP_SavedEmail", c);
    paramBundle.putString("PP_SavedPhone", e);
    paramBundle.putString("PP_savedPhoneCountryCode", f);
    paramBundle.putString("PP_SavedPassword", d);
    paramBundle.putString("PP_SavedPIN", g);
    paramBundle.putBoolean("PP_IsReturningUser", l);
    paramBundle.putBoolean("PP_PageTrackingSent", k);
    paramBundle.putBoolean("PP_IsClearedLogin", n);
    paramBundle.putString("PP_RequestedScopes", j);
    paramBundle.putString("PP_SavedOTP", h);
    paramBundle.putParcelable("PP_OriginalLoginData", i);
    paramBundle.putInt("PP_TwoFaSelectedPhoneNumberIndex", o);
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.payments.LoginActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */