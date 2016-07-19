package me.lyft.android.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class DialogItemAdapter
  extends ArrayAdapter<String>
{
  public DialogItemAdapter(Context paramContext, List<String> paramList)
  {
    super(paramContext, 2130903159, 2131558937, paramList);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    ((TextView)paramView.findViewById(2131558937)).setText((String)getItem(paramInt));
    return paramView;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.adapters.DialogItemAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */