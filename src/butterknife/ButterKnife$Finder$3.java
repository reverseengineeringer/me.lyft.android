package butterknife;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

 enum ButterKnife$Finder$3
{
  ButterKnife$Finder$3()
  {
    super(paramString, paramInt, null);
  }
  
  protected View findView(Object paramObject, int paramInt)
  {
    return ((Dialog)paramObject).findViewById(paramInt);
  }
  
  public Context getContext(Object paramObject)
  {
    return ((Dialog)paramObject).getContext();
  }
}

/* Location:
 * Qualified Name:     butterknife.ButterKnife.Finder.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */