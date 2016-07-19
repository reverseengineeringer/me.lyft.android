package me.lyft.android.ui.development;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.deeplinks.DeepLink;
import me.lyft.android.deeplinks.DeepLinkManager;
import me.lyft.android.utils.Keyboard;

public class DeepLinksView
  extends LinearLayout
{
  private static final String[] DEEP_LINKS = { "help", "drive", "drivemode", "editprofile", "settings", "payment", "payment?credits=CATFISH", "concur", "referral", "workperks", "note", "ridetype?id=lyft_line&pickup[latitude]=37.778434&pickup[longitude]=-122.397103&destination[latitude]=37.791474&destination[longitude]=-122.417205", "app-walkthrough", "carpooldriveronboarding", "carpooldriveronboarding?step=enableLocations" };
  private static String DEEP_LINK_BASE = "lyft://";
  EditText deepLinkEditText;
  ListView deepLinkList;
  @Inject
  DeepLinkManager deepLinkManager;
  Toolbar toolbar;
  
  public DeepLinksView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    toolbar.setTitle(getContext().getString(2131165538));
    deepLinkEditText.setOnEditorActionListener(new DeepLinksView.1(this));
    Object localObject = new ArrayList();
    String[] arrayOfString = DEEP_LINKS;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      ((ArrayList)localObject).add(DEEP_LINK_BASE + str);
      i += 1;
    }
    localObject = new ArrayAdapter(getContext(), 17367049, (List)localObject);
    deepLinkList.setAdapter((ListAdapter)localObject);
    deepLinkList.setOnItemClickListener(new DeepLinksView.2(this, (ArrayAdapter)localObject));
    Keyboard.showKeyboard(deepLinkEditText);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
  }
  
  void performRoute()
  {
    deepLinkManager.tryHandleDeepLink(new DeepLink(deepLinkEditText.getText().toString()));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.development.DeepLinksView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */