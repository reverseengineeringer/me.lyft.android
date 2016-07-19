package me.lyft.android.ui.profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import com.squareup.picasso.RequestCreator;
import javax.inject.Inject;
import me.lyft.android.managers.ImageLoader;

public class ProfileFriendsItemWidgetView
  extends LinearLayout
{
  TextView friendNameTextView;
  ImageView friendPhotoImageView;
  @Inject
  ImageLoader imageLoader;
  
  public ProfileFriendsItemWidgetView(Context paramContext)
  {
    super(paramContext);
    setOrientation(1);
    DaggerInjector.fromView(this).inject(this);
    Scoop.fromView(this).inflater(paramContext).inflate(2130903409, this, true);
    ButterKnife.bind(this);
  }
  
  public void setUserInfo(String paramString1, String paramString2)
  {
    friendNameTextView.setText(paramString1);
    imageLoader.load(paramString2).fit().centerInside().error(2130838346).placeholder(2130838346).into(friendPhotoImageView);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.profile.ProfileFriendsItemWidgetView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */