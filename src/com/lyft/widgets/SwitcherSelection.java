package com.lyft.widgets;

public class SwitcherSelection<E extends ISwitcherItem>
{
  final boolean isUserAction;
  final E switcherItem;
  
  public SwitcherSelection(E paramE, boolean paramBoolean)
  {
    switcherItem = paramE;
    isUserAction = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.SwitcherSelection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */