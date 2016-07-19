package me.lyft.android.controls;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.lyft.widgets.ISwitcherItem;
import java.util.Iterator;
import java.util.List;

class MultiSwitcher$4
  implements Runnable
{
  MultiSwitcher$4(MultiSwitcher paramMultiSwitcher) {}
  
  public void run()
  {
    if (!MultiSwitcher.access$800(this$0))
    {
      MultiSwitcher.access$1400(this$0);
      this$0.updateThumb();
    }
    this$0.itemsPlaceHolder.removeAllViews();
    final int i = 0;
    Iterator localIterator = MultiSwitcher.access$1500(this$0).iterator();
    while (localIterator.hasNext())
    {
      ISwitcherItem localISwitcherItem = (ISwitcherItem)localIterator.next();
      View localView = this$0.createSwitcherItem(MultiSwitcher.access$1600(this$0), localISwitcherItem);
      this$0.bindSwitcherItem(localView, localISwitcherItem);
      localView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          MultiSwitcher.access$1002(this$0, true);
          this$0.animateToItemIndex(i);
        }
      });
      this$0.itemsPlaceHolder.addView(localView, new LinearLayout.LayoutParams(MultiSwitcher.access$1700(this$0), -1));
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.MultiSwitcher.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */