package android.support.v4.app;

import android.view.View;

class Fragment$1
  extends FragmentContainer
{
  Fragment$1(Fragment paramFragment) {}
  
  public View onFindViewById(int paramInt)
  {
    if (this$0.mView == null) {
      throw new IllegalStateException("Fragment does not have a view");
    }
    return this$0.mView.findViewById(paramInt);
  }
  
  public boolean onHasView()
  {
    return this$0.mView != null;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.Fragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */