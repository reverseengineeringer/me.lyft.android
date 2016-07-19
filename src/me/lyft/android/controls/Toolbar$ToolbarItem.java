package me.lyft.android.controls;

public final class Toolbar$ToolbarItem
{
  private final int iconId;
  private final int id;
  private int layoutId = 2130903486;
  private int textColor;
  private final String title;
  private int typefaceStyle;
  
  public Toolbar$ToolbarItem(int paramInt1, int paramInt2)
  {
    this(paramInt1, null, paramInt2, -1);
  }
  
  public Toolbar$ToolbarItem(int paramInt, String paramString)
  {
    this(paramInt, paramString, 0, -1);
  }
  
  public Toolbar$ToolbarItem(int paramInt1, String paramString, int paramInt2)
  {
    this(paramInt1, paramString, paramInt2, -1);
  }
  
  public Toolbar$ToolbarItem(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this(paramInt1, paramString, paramInt2, paramInt3, -1);
  }
  
  public Toolbar$ToolbarItem(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
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

/* Location:
 * Qualified Name:     me.lyft.android.controls.Toolbar.ToolbarItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */