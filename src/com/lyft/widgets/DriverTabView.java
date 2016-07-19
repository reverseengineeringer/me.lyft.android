package com.lyft.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class DriverTabView
  extends FrameLayout
{
  private final LayoutInflater inflater = LayoutInflater.from(getContext());
  private int selectedResId;
  private final ImageView tabImageView;
  private final TextView tabTextView;
  private int unselectedResId;
  
  public DriverTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    inflater.inflate(R.layout.driver_tab, this, true);
    tabImageView = ((ImageView)findViewById(R.id.tab_image_view));
    tabTextView = ((TextView)findViewById(R.id.tab_text_view));
  }
  
  public void initialize(int paramInt1, int paramInt2, String paramString)
  {
    selectedResId = paramInt1;
    unselectedResId = paramInt2;
    tabTextView.setText(paramString);
    unselect();
  }
  
  public void select()
  {
    tabImageView.setBackgroundResource(selectedResId);
    tabTextView.setTextColor(getResources().getColor(R.color.purple));
  }
  
  public void unselect()
  {
    tabImageView.setBackgroundResource(unselectedResId);
    tabTextView.setTextColor(getResources().getColor(R.color.dove));
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.DriverTabView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */