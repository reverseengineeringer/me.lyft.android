package me.lyft.android.managers;

import android.net.Uri;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Target;
import java.io.File;
import javax.inject.Inject;
import javax.inject.Singleton;
import me.lyft.android.common.Strings;

@Singleton
public class ImageLoader
{
  private Picasso picasso;
  
  @Inject
  public ImageLoader(Picasso paramPicasso)
  {
    picasso = paramPicasso;
  }
  
  private static RequestCreator addCommonOptions(RequestCreator paramRequestCreator)
  {
    return paramRequestCreator.noFade();
  }
  
  public void cancelRequest(ImageView paramImageView)
  {
    picasso.cancelRequest(paramImageView);
  }
  
  public void cancelRequest(Target paramTarget)
  {
    picasso.cancelRequest(paramTarget);
  }
  
  public RequestCreator load(int paramInt)
  {
    return addCommonOptions(picasso.load(paramInt));
  }
  
  public RequestCreator load(Uri paramUri)
  {
    return addCommonOptions(picasso.load(paramUri));
  }
  
  public RequestCreator load(File paramFile)
  {
    return addCommonOptions(picasso.load(paramFile));
  }
  
  public RequestCreator load(String paramString)
  {
    String str = paramString;
    if (Strings.isNullOrBlank(paramString)) {
      str = null;
    }
    return addCommonOptions(picasso.load(str));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.managers.ImageLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */