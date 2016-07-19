package butterknife;

import android.content.Context;
import android.view.View;

 enum ButterKnife$Finder$1
{
  ButterKnife$Finder$1()
  {
    super(paramString, paramInt, null);
  }
  
  protected View findView(Object paramObject, int paramInt)
  {
    return ((View)paramObject).findViewById(paramInt);
  }
  
  public Context getContext(Object paramObject)
  {
    return ((View)paramObject).getContext();
  }
}

/* Location:
 * Qualified Name:     butterknife.ButterKnife.Finder.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */