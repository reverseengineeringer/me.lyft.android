package android.support.v4.content.res;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;

class ResourcesCompatApi21
{
  public static Drawable getDrawable(Resources paramResources, int paramInt, Resources.Theme paramTheme)
    throws Resources.NotFoundException
  {
    return paramResources.getDrawable(paramInt, paramTheme);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.content.res.ResourcesCompatApi21
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */