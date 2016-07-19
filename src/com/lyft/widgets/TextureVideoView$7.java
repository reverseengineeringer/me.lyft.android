package com.lyft.widgets;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.MediaController;

class TextureVideoView$7
  implements TextureView.SurfaceTextureListener
{
  TextureVideoView$7(TextureVideoView paramTextureVideoView) {}
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    TextureVideoView.access$1302(this$0, new Surface(paramSurfaceTexture));
    TextureVideoView.access$1400(this$0);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    TextureVideoView.access$1300(this$0).release();
    TextureVideoView.access$1302(this$0, null);
    if (TextureVideoView.access$500(this$0) != null) {
      TextureVideoView.access$500(this$0).hide();
    }
    this$0.release(true);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    TextureVideoView.access$602(this$0, this$0.getWidth());
    TextureVideoView.access$702(this$0, this$0.getHeight());
    int i;
    if (TextureVideoView.access$800(this$0) == 3)
    {
      i = 1;
      if ((TextureVideoView.access$000(this$0) != paramInt1) || (TextureVideoView.access$100(this$0) != paramInt2)) {
        break label101;
      }
    }
    label101:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if ((TextureVideoView.access$400(this$0) != null) && (i != 0) && (paramInt1 != 0)) {
        this$0.start();
      }
      return;
      i = 0;
      break;
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}

/* Location:
 * Qualified Name:     com.lyft.widgets.TextureVideoView.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */