package me.lyft.android.controls;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import me.lyft.android.common.Unit;
import me.lyft.android.utils.MetricsUtils;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Actions;
import rx.functions.Func1;
import rx.subjects.PublishSubject;

public class Toolbar
  extends LinearLayout
{
  private static final int NO_HOME_ICON_LEFT_MARGIN_DP = 12;
  View dividerView;
  View driverModeToggleView;
  final PublishSubject<Unit> homeClick = PublishSubject.create();
  ImageView homeImageView;
  View homeView;
  final LayoutInflater inflater = Scoop.fromView(this).inflater(getContext());
  final PublishSubject<ToolbarItem> itemClick = PublishSubject.create();
  private Action1<Integer> itemClickAction = Actions.empty();
  LinearLayout itemsContainerView;
  ImageView logoImageView;
  final MetricsUtils metricsUtils;
  TextView titleTextView;
  private final Func1<ToolbarItem, Integer> toolbarItemAsId = new Func1()
  {
    public Integer call(Toolbar.ToolbarItem paramAnonymousToolbarItem)
    {
      return Integer.valueOf(Toolbar.ToolbarItem.access$000(paramAnonymousToolbarItem));
    }
  };
  
  public Toolbar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    inflater.inflate(2130903485, this, true);
    metricsUtils = MetricsUtils.fromView(this);
    ButterKnife.bind(this, this);
    homeImageView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        onHomeClick();
      }
    });
  }
  
  private Toolbar setItemViewEnabled(int paramInt, boolean paramBoolean)
  {
    View localView = ButterKnife.findById(itemsContainerView, paramInt);
    if (localView != null) {
      localView.setEnabled(paramBoolean);
    }
    return this;
  }
  
  private Toolbar show(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      return this;
    }
  }
  
  private Toolbar showLogo(boolean paramBoolean)
  {
    show(logoImageView, paramBoolean);
    return this;
  }
  
  private Toolbar showTitle(boolean paramBoolean)
  {
    show(titleTextView, paramBoolean);
    return this;
  }
  
  public Toolbar addItem(int paramInt1, int paramInt2)
  {
    return addItem(new ToolbarItem(paramInt1, paramInt2));
  }
  
  public Toolbar addItem(int paramInt, String paramString)
  {
    return addItem(new ToolbarItem(paramInt, paramString));
  }
  
  public Toolbar addItem(int paramInt1, String paramString, int paramInt2)
  {
    return addItem(new ToolbarItem(paramInt1, paramString, paramInt2));
  }
  
  public Toolbar addItem(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    return addItem(new ToolbarItem(paramInt1, paramString, paramInt2, paramInt3));
  }
  
  public Toolbar addItem(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    return addItem(new ToolbarItem(paramInt1, paramString, paramInt2, paramInt3, paramInt4));
  }
  
  public Toolbar addItem(final ToolbarItem paramToolbarItem)
  {
    View localView = inflater.inflate(paramToolbarItem.getLayoutId(), itemsContainerView, false);
    localView.setId(paramToolbarItem.getId());
    TextView localTextView = (TextView)ButterKnife.findById(localView, 2131558558);
    ImageView localImageView = (ImageView)ButterKnife.findById(localView, 2131558647);
    if (localTextView != null)
    {
      if (TextUtils.isEmpty(paramToolbarItem.getTitle())) {
        localTextView.setVisibility(8);
      }
    }
    else
    {
      if (paramToolbarItem.getTextColor() != -1) {
        localTextView.setTextColor(paramToolbarItem.getTextColor());
      }
      if (paramToolbarItem.getTypefaceStyle() != -1) {
        localTextView.setTypeface(null, paramToolbarItem.getTypefaceStyle());
      }
      if (localImageView != null)
      {
        if (paramToolbarItem.getIconId() != 0) {
          break label152;
        }
        localImageView.setVisibility(8);
      }
    }
    for (;;)
    {
      localView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          itemClick.onNext(paramToolbarItem);
          itemClickAction.call(Integer.valueOf(Toolbar.ToolbarItem.access$000(paramToolbarItem)));
        }
      });
      itemsContainerView.addView(localView);
      return this;
      localTextView.setText(paramToolbarItem.getTitle());
      break;
      label152:
      localImageView.setImageResource(paramToolbarItem.getIconId());
    }
  }
  
  public Toolbar clearItems()
  {
    itemsContainerView.removeAllViews();
    return this;
  }
  
  public Toolbar disableHomeButton()
  {
    setHomeButtonEnabled(false);
    return this;
  }
  
  public Toolbar disableItem(int paramInt)
  {
    setItemViewEnabled(paramInt, false);
    return this;
  }
  
  public Toolbar displayBackButton()
  {
    setHomeIcon(2130838372);
    return this;
  }
  
  public Toolbar displayMenuButton()
  {
    setHomeIcon(2130838117);
    return this;
  }
  
  public Toolbar enableHomeButton()
  {
    setHomeButtonEnabled(true);
    return this;
  }
  
  public Toolbar enableItem(int paramInt)
  {
    setItemViewEnabled(paramInt, true);
    return this;
  }
  
  public <T extends View> T getToolbarItemView(int paramInt)
  {
    return ButterKnife.findById(itemsContainerView, paramInt);
  }
  
  public Toolbar hideDivider()
  {
    dividerView.setVisibility(8);
    return this;
  }
  
  public Toolbar hideDriverModeToggle()
  {
    driverModeToggleView.setVisibility(8);
    return this;
  }
  
  public Toolbar hideHomeIcon()
  {
    setHomeIconVisible(false);
    return this;
  }
  
  public Toolbar hideItem(int paramInt)
  {
    setItemVisible(paramInt, false);
    return this;
  }
  
  public Observable<Unit> observeHomeClick()
  {
    return homeClick.asObservable();
  }
  
  public Observable<Integer> observeItemClick()
  {
    return itemClick.map(toolbarItemAsId).asObservable();
  }
  
  protected void onHomeClick()
  {
    homeClick.onNext(Unit.create());
  }
  
  public Toolbar removeItem(int paramInt)
  {
    View localView = ButterKnife.findById(itemsContainerView, paramInt);
    if (localView != null) {
      itemsContainerView.removeView(localView);
    }
    return this;
  }
  
  public Toolbar setHomeButtonEnabled(boolean paramBoolean)
  {
    homeView.setEnabled(paramBoolean);
    return this;
  }
  
  public void setHomeIcon(int paramInt)
  {
    homeImageView.setImageResource(paramInt);
  }
  
  public Toolbar setHomeIconVisible(boolean paramBoolean)
  {
    ImageView localImageView = homeImageView;
    if (paramBoolean)
    {
      i = 0;
      localImageView.setVisibility(i);
      if (!paramBoolean) {
        break label52;
      }
    }
    label52:
    for (int i = 0;; i = metricsUtils.dpToPixels(12.0F))
    {
      logoImageView.setPadding(i, 0, 0, 0);
      titleTextView.setPadding(i, 0, 0, 0);
      return this;
      i = 8;
      break;
    }
  }
  
  public Toolbar setItemVisible(int paramInt, boolean paramBoolean)
  {
    View localView = ButterKnife.findById(itemsContainerView, paramInt);
    if (localView != null) {
      if (!paramBoolean) {
        break label26;
      }
    }
    label26:
    for (paramInt = 0;; paramInt = 8)
    {
      localView.setVisibility(paramInt);
      return this;
    }
  }
  
  public Toolbar setLogo(int paramInt)
  {
    logoImageView.setImageResource(paramInt);
    showLogo();
    return this;
  }
  
  public void setOnItemClickAction(Action1<Integer> paramAction1)
  {
    itemClickAction = paramAction1;
  }
  
  public Toolbar setTitle(String paramString)
  {
    titleTextView.setText(paramString);
    showTitle();
    return this;
  }
  
  public Toolbar showDivider()
  {
    dividerView.setVisibility(0);
    return this;
  }
  
  public Toolbar showDriverModeToggle()
  {
    driverModeToggleView.setVisibility(0);
    return this;
  }
  
  public Toolbar showHomeIcon()
  {
    setHomeIconVisible(true);
    return this;
  }
  
  public Toolbar showItem(int paramInt)
  {
    setItemVisible(paramInt, true);
    return this;
  }
  
  public Toolbar showLogo()
  {
    showTitle(false);
    showLogo(true);
    return this;
  }
  
  public Toolbar showTitle()
  {
    showTitle(true);
    showLogo(false);
    return this;
  }
  
  public static final class ToolbarItem
  {
    private final int iconId;
    private final int id;
    private int layoutId = 2130903486;
    private int textColor;
    private final String title;
    private int typefaceStyle;
    
    public ToolbarItem(int paramInt1, int paramInt2)
    {
      this(paramInt1, null, paramInt2, -1);
    }
    
    public ToolbarItem(int paramInt, String paramString)
    {
      this(paramInt, paramString, 0, -1);
    }
    
    public ToolbarItem(int paramInt1, String paramString, int paramInt2)
    {
      this(paramInt1, paramString, paramInt2, -1);
    }
    
    public ToolbarItem(int paramInt1, String paramString, int paramInt2, int paramInt3)
    {
      this(paramInt1, paramString, paramInt2, paramInt3, -1);
    }
    
    public ToolbarItem(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
    {
      id = paramInt1;
      title = paramString;
      iconId = paramInt2;
      textColor = paramInt3;
      typefaceStyle = paramInt4;
    }
    
    public int getIconId()
    {
      return iconId;
    }
    
    public int getId()
    {
      return id;
    }
    
    public int getLayoutId()
    {
      return layoutId;
    }
    
    public int getTextColor()
    {
      return textColor;
    }
    
    public String getTitle()
    {
      return title;
    }
    
    public int getTypefaceStyle()
    {
      return typefaceStyle;
    }
    
    public ToolbarItem setLayoutId(int paramInt)
    {
      layoutId = paramInt;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.Toolbar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */