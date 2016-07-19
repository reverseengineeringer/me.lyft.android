package com.lyft.widgets;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.widget.MediaController;

class TextureVideoView$3
  implements MediaPlayer.OnCompletionListener
{
  TextureVideoView$3(TextureVideoView paramTextureVideoView) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (TextureVideoView.access$200(this$0) == 5) {}
    do
    {
      return;
      TextureVideoView.access$202(this$0, 5);
      TextureVideoView.access$802(this$0, 5);
      if (TextureVideoView.access$500(this$0) != null) {
        TextureVideoView.access$500(this$0).hide();
      }
    } while (TextureVideoView.access$900(this$0) == null);
    TextureVideoView.access$900(this$0).onCompletion(TextureVideoView.access$400(this$0));
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.TextureVideoView.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */