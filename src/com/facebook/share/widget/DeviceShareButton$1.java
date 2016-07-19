package com.facebook.share.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.share.DeviceShareDialog;

class DeviceShareButton$1
  implements View.OnClickListener
{
  DeviceShareButton$1(DeviceShareButton paramDeviceShareButton) {}
  
  public void onClick(View paramView)
  {
    DeviceShareButton.access$000(this$0, paramView);
    DeviceShareButton.access$100(this$0).show(this$0.getShareContent());
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.widget.DeviceShareButton.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */