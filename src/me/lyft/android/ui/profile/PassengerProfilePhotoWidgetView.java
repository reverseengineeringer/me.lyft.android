package me.lyft.android.ui.profile;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import com.squareup.picasso.RequestCreator;
import javax.inject.Inject;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.Unit;
import me.lyft.android.infrastructure.profile.IProfilePhotoLoader;
import me.lyft.android.managers.ImageLoader;
import rx.Observable;

public class PassengerProfilePhotoWidgetView
  extends LinearLayout
{
  @Inject
  AppFlow appFlow;
  @Inject
  ImageLoader imageLoader;
  TextView nameTextView;
  ImageView photoImageView;
  @Inject
  IProfilePhotoLoader profilePhotoLoader;
  @Inject
  IUserProvider userProvider;
  
  public PassengerProfilePhotoWidgetView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    setOrientation(1);
    Scoop.fromView(this).inflater(paramContext).inflate(2130903412, this, true);
  }
  
  private static Observable<Unit> observeViewLaidOut(View paramView)
  {
    if ((paramView.getWidth() > 0) || (paramView.getHeight() > 0)) {
      return Unit.just();
    }
    return Observable.create(new PassengerProfilePhotoWidgetView.3(paramView));
  }
  
  private RequestCreator requestProfilePhoto(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return profilePhotoLoader.load();
    }
    return imageLoader.load(paramString);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
  }
  
  public void setUserInfo(String paramString1, String paramString2, boolean paramBoolean)
  {
    nameTextView.setText(paramString1);
    observeViewLaidOut(photoImageView).subscribe(new PassengerProfilePhotoWidgetView.1(this, paramString2, paramBoolean));
    photoImageView.setOnClickListener(new PassengerProfilePhotoWidgetView.2(this, paramBoolean, paramString2));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.profile.PassengerProfilePhotoWidgetView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */