package com.lyft.widgets;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.widget.MediaController;

class TextureVideoView$2
  implements MediaPlayer.OnPreparedListener
{
  TextureVideoView$2(TextureVideoView paramTextureVideoView) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    TextureVideoView.access$202(this$0, 2);
    if (TextureVideoView.access$300(this$0) != null) {
      TextureVideoView.access$300(this$0).onPrepared(TextureVideoView.access$400(this$0));
    }
    if (TextureVideoView.access$500(this$0) != null) {
      TextureVideoView.access$500(this$0).setEnabled(true);
    }
    TextureVideoView.access$002(this$0, paramMediaPlayer.getVideoWidth());
    TextureVideoView.access$102(this$0, paramMediaPlayer.getVideoHeight());
    if ((TextureVideoView.access$000(this$0) != 0) && (TextureVideoView.access$100(this$0) != 0))
    {
      this$0.getSurfaceTexture().setDefaultBufferSize(TextureVideoView.access$000(this$0), TextureVideoView.access$100(this$0));
      if ((TextureVideoView.access$600(this$0) == TextureVideoView.access$000(this$0)) && (TextureVideoView.access$700(this$0) == TextureVideoView.access$100(this$0)))
      {
        if (TextureVideoView.access$800(this$0) != 3) {
          break label200;
        }
        this$0.start();
        if (TextureVideoView.access$500(this$0) != null) {
          TextureVideoView.access$500(this$0).show();
        }
      }
    }
    label200:
    while (TextureVideoView.access$800(this$0) != 3)
    {
      do
      {
        return;
      } while ((this$0.isPlaying()) || (this$0.getCurrentPosition() <= 0) || (TextureVideoView.access$500(this$0) == null));
      TextureVideoView.access$500(this$0).show(0);
      return;
    }
    this$0.start();
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.TextureVideoView.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */