package com.lyft.widgets;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;

class TextureVideoView$1
  implements MediaPlayer.OnVideoSizeChangedListener
{
  TextureVideoView$1(TextureVideoView paramTextureVideoView) {}
  
  public void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    TextureVideoView.access$002(this$0, paramMediaPlayer.getVideoWidth());
    TextureVideoView.access$102(this$0, paramMediaPlayer.getVideoHeight());
    if ((TextureVideoView.access$000(this$0) != 0) && (TextureVideoView.access$100(this$0) != 0))
    {
      this$0.getSurfaceTexture().setDefaultBufferSize(TextureVideoView.access$000(this$0), TextureVideoView.access$100(this$0));
      this$0.requestLayout();
    }
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.TextureVideoView.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */