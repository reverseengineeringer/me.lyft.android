package com.lyft.widgets;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.widget.MediaController;
import me.lyft.android.logging.L;

class TextureVideoView$5
  implements MediaPlayer.OnErrorListener
{
  TextureVideoView$5(TextureVideoView paramTextureVideoView) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    paramMediaPlayer = "Error: " + paramInt1 + "," + paramInt2;
    L.w(new IllegalStateException(TextureVideoView.access$1000(this$0) + " " + paramMediaPlayer), paramMediaPlayer, new Object[0]);
    TextureVideoView.access$202(this$0, -1);
    TextureVideoView.access$802(this$0, -1);
    if (TextureVideoView.access$500(this$0) != null) {
      TextureVideoView.access$500(this$0).hide();
    }
    if ((TextureVideoView.access$1100(this$0) != null) && (TextureVideoView.access$1100(this$0).onError(TextureVideoView.access$400(this$0), paramInt1, paramInt2))) {}
    while ((this$0.getWindowToken() == null) || (TextureVideoView.access$900(this$0) == null)) {
      return true;
    }
    TextureVideoView.access$900(this$0).onCompletion(TextureVideoView.access$400(this$0));
    return true;
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.TextureVideoView.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */