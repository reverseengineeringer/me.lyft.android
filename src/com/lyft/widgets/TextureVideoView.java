package com.lyft.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.MediaController;
import android.widget.MediaController.MediaPlayerControl;
import java.util.Map;
import me.lyft.android.logging.L;

public class TextureVideoView
  extends TextureView
  implements MediaController.MediaPlayerControl
{
  private String TAG = "TextureVideoView";
  private MediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener = new MediaPlayer.OnBufferingUpdateListener()
  {
    public void onBufferingUpdate(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
    {
      TextureVideoView.access$1202(TextureVideoView.this, paramAnonymousInt);
    }
  };
  private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener()
  {
    public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
    {
      if (mCurrentState == 5) {}
      do
      {
        return;
        TextureVideoView.access$202(TextureVideoView.this, 5);
        TextureVideoView.access$802(TextureVideoView.this, 5);
        if (mMediaController != null) {
          mMediaController.hide();
        }
      } while (mOnCompletionListener == null);
      mOnCompletionListener.onCompletion(mMediaPlayer);
    }
  };
  private Context mContext;
  private int mCurrentBufferPercentage;
  private int mCurrentState = 0;
  private MediaPlayer.OnErrorListener mErrorListener = new MediaPlayer.OnErrorListener()
  {
    public boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      paramAnonymousMediaPlayer = "Error: " + paramAnonymousInt1 + "," + paramAnonymousInt2;
      L.w(new IllegalStateException(TAG + " " + paramAnonymousMediaPlayer), paramAnonymousMediaPlayer, new Object[0]);
      TextureVideoView.access$202(TextureVideoView.this, -1);
      TextureVideoView.access$802(TextureVideoView.this, -1);
      if (mMediaController != null) {
        mMediaController.hide();
      }
      if ((mOnErrorListener != null) && (mOnErrorListener.onError(mMediaPlayer, paramAnonymousInt1, paramAnonymousInt2))) {}
      while ((getWindowToken() == null) || (mOnCompletionListener == null)) {
        return true;
      }
      mOnCompletionListener.onCompletion(mMediaPlayer);
      return true;
    }
  };
  private MediaPlayer.OnInfoListener mInfoListener = new MediaPlayer.OnInfoListener()
  {
    public boolean onInfo(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      return true;
    }
  };
  private MediaController mMediaController;
  private MediaPlayer mMediaPlayer = null;
  private MediaPlayer.OnCompletionListener mOnCompletionListener;
  private MediaPlayer.OnErrorListener mOnErrorListener;
  private MediaPlayer.OnPreparedListener mOnPreparedListener;
  MediaPlayer.OnPreparedListener mPreparedListener = new MediaPlayer.OnPreparedListener()
  {
    public void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
    {
      TextureVideoView.access$202(TextureVideoView.this, 2);
      if (mOnPreparedListener != null) {
        mOnPreparedListener.onPrepared(mMediaPlayer);
      }
      if (mMediaController != null) {
        mMediaController.setEnabled(true);
      }
      TextureVideoView.access$002(TextureVideoView.this, paramAnonymousMediaPlayer.getVideoWidth());
      TextureVideoView.access$102(TextureVideoView.this, paramAnonymousMediaPlayer.getVideoHeight());
      if ((mVideoWidth != 0) && (mVideoHeight != 0))
      {
        getSurfaceTexture().setDefaultBufferSize(mVideoWidth, mVideoHeight);
        if ((mSurfaceWidth == mVideoWidth) && (mSurfaceHeight == mVideoHeight))
        {
          if (mTargetState != 3) {
            break label200;
          }
          start();
          if (mMediaController != null) {
            mMediaController.show();
          }
        }
      }
      label200:
      while (mTargetState != 3)
      {
        do
        {
          return;
        } while ((isPlaying()) || (getCurrentPosition() <= 0) || (mMediaController == null));
        mMediaController.show(0);
        return;
      }
      start();
    }
  };
  MediaPlayer.OnVideoSizeChangedListener mSizeChangedListener = new MediaPlayer.OnVideoSizeChangedListener()
  {
    public void onVideoSizeChanged(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      TextureVideoView.access$002(TextureVideoView.this, paramAnonymousMediaPlayer.getVideoWidth());
      TextureVideoView.access$102(TextureVideoView.this, paramAnonymousMediaPlayer.getVideoHeight());
      if ((mVideoWidth != 0) && (mVideoHeight != 0))
      {
        getSurfaceTexture().setDefaultBufferSize(mVideoWidth, mVideoHeight);
        requestLayout();
      }
    }
  };
  private Surface mSurface = null;
  private int mSurfaceHeight;
  TextureView.SurfaceTextureListener mSurfaceTextureListener = new TextureView.SurfaceTextureListener()
  {
    public void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      TextureVideoView.access$1302(TextureVideoView.this, new Surface(paramAnonymousSurfaceTexture));
      TextureVideoView.this.openVideo();
    }
    
    public boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
    {
      mSurface.release();
      TextureVideoView.access$1302(TextureVideoView.this, null);
      if (mMediaController != null) {
        mMediaController.hide();
      }
      release(true);
      return true;
    }
    
    public void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      TextureVideoView.access$602(TextureVideoView.this, getWidth());
      TextureVideoView.access$702(TextureVideoView.this, getHeight());
      int i;
      if (mTargetState == 3)
      {
        i = 1;
        if ((mVideoWidth != paramAnonymousInt1) || (mVideoHeight != paramAnonymousInt2)) {
          break label101;
        }
      }
      label101:
      for (paramAnonymousInt1 = 1;; paramAnonymousInt1 = 0)
      {
        if ((mMediaPlayer != null) && (i != 0) && (paramAnonymousInt1 != 0)) {
          start();
        }
        return;
        i = 0;
        break;
      }
    }
    
    public void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture) {}
  };
  private int mSurfaceWidth;
  private int mTargetState = 0;
  private Uri mUri;
  private int mVideoHeight;
  private int mVideoWidth;
  
  public TextureVideoView(Context paramContext)
  {
    super(paramContext);
    initVideoView();
  }
  
  public TextureVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initVideoView();
  }
  
  public TextureVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initVideoView();
  }
  
  @TargetApi(21)
  public TextureVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    initVideoView();
  }
  
  private void attachMediaController()
  {
    if ((mMediaPlayer != null) && (mMediaController != null))
    {
      mMediaController.setMediaPlayer(this);
      if (!(getParent() instanceof View)) {
        break label60;
      }
    }
    label60:
    for (Object localObject = (View)getParent();; localObject = this)
    {
      mMediaController.setAnchorView((View)localObject);
      mMediaController.setEnabled(isInPlaybackState());
      return;
    }
  }
  
  private void initVideoView()
  {
    mContext = getContext();
    mVideoWidth = 0;
    mVideoHeight = 0;
    setSurfaceTextureListener(mSurfaceTextureListener);
    mCurrentState = 0;
    mTargetState = 0;
  }
  
  private boolean isInPlaybackState()
  {
    return (mMediaPlayer != null) && (mCurrentState != -1) && (mCurrentState != 0) && (mCurrentState != 1);
  }
  
  private void openVideo()
  {
    if ((mUri == null) || (mSurface == null)) {
      return;
    }
    release(false);
    try
    {
      mMediaPlayer = new MediaPlayer();
      mMediaPlayer.setOnPreparedListener(mPreparedListener);
      mMediaPlayer.setOnVideoSizeChangedListener(mSizeChangedListener);
      mMediaPlayer.setOnCompletionListener(mCompletionListener);
      mMediaPlayer.setOnErrorListener(mErrorListener);
      mMediaPlayer.setOnInfoListener(mInfoListener);
      mMediaPlayer.setOnBufferingUpdateListener(mBufferingUpdateListener);
      mCurrentBufferPercentage = 0;
      mMediaPlayer.setDataSource(mContext, mUri, null);
      mMediaPlayer.setSurface(mSurface);
      mMediaPlayer.setAudioStreamType(3);
      mMediaPlayer.setScreenOnWhilePlaying(true);
      mMediaPlayer.prepareAsync();
      mCurrentState = 1;
      attachMediaController();
      return;
    }
    catch (Throwable localThrowable)
    {
      L.w(localThrowable, TAG + " Unable to open content: " + mUri, new Object[0]);
      mCurrentState = -1;
      mTargetState = -1;
      mErrorListener.onError(mMediaPlayer, 1, 0);
    }
  }
  
  public boolean canPause()
  {
    return false;
  }
  
  public boolean canSeekBackward()
  {
    return false;
  }
  
  public boolean canSeekForward()
  {
    return false;
  }
  
  public int getAudioSessionId()
  {
    return 0;
  }
  
  public int getBufferPercentage()
  {
    if (mMediaPlayer != null) {
      return mCurrentBufferPercentage;
    }
    return 0;
  }
  
  public int getCurrentPosition()
  {
    if (isInPlaybackState()) {
      return mMediaPlayer.getCurrentPosition();
    }
    return 0;
  }
  
  public int getDuration()
  {
    if (isInPlaybackState()) {
      return mMediaPlayer.getDuration();
    }
    return -1;
  }
  
  public boolean isPlaying()
  {
    return (isInPlaybackState()) && (mMediaPlayer.isPlaying());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = getDefaultSize(mVideoWidth, paramInt1);
    int m = getDefaultSize(mVideoHeight, paramInt2);
    int i = m;
    int j = k;
    int n;
    int i1;
    if (mVideoWidth > 0)
    {
      i = m;
      j = k;
      if (mVideoHeight > 0)
      {
        n = View.MeasureSpec.getMode(paramInt1);
        paramInt1 = View.MeasureSpec.getSize(paramInt1);
        i1 = View.MeasureSpec.getMode(paramInt2);
        paramInt2 = View.MeasureSpec.getSize(paramInt2);
        if ((n != 1073741824) || (i1 != 1073741824)) {
          break label162;
        }
        if (mVideoWidth * paramInt2 >= mVideoHeight * paramInt1) {
          break label124;
        }
        j = mVideoWidth * paramInt2 / mVideoHeight;
        i = paramInt2;
      }
    }
    for (;;)
    {
      setMeasuredDimension(j, i);
      return;
      label124:
      i = paramInt2;
      j = paramInt1;
      if (mVideoWidth * paramInt2 > mVideoHeight * paramInt1)
      {
        i = mVideoHeight * paramInt1 / mVideoWidth;
        j = paramInt1;
        continue;
        label162:
        if (n == 1073741824)
        {
          k = mVideoHeight * paramInt1 / mVideoWidth;
          i = k;
          j = paramInt1;
          if (i1 == Integer.MIN_VALUE)
          {
            i = k;
            j = paramInt1;
            if (k > paramInt2)
            {
              i = paramInt2;
              j = paramInt1;
            }
          }
        }
        else if (i1 == 1073741824)
        {
          k = mVideoWidth * paramInt2 / mVideoHeight;
          i = paramInt2;
          j = k;
          if (n == Integer.MIN_VALUE)
          {
            i = paramInt2;
            j = k;
            if (k > paramInt1)
            {
              i = paramInt2;
              j = paramInt1;
            }
          }
        }
        else
        {
          i = mVideoWidth;
          j = mVideoHeight;
          m = j;
          k = i;
          if (i1 == Integer.MIN_VALUE)
          {
            m = j;
            k = i;
            if (j > paramInt2)
            {
              k = mVideoWidth * paramInt2 / mVideoHeight;
              m = paramInt2;
            }
          }
          i = m;
          j = k;
          if (n == Integer.MIN_VALUE)
          {
            i = m;
            j = k;
            if (k > paramInt1)
            {
              i = mVideoHeight * paramInt1 / mVideoWidth;
              j = paramInt1;
            }
          }
        }
      }
    }
  }
  
  public void pause()
  {
    if ((isInPlaybackState()) && (mMediaPlayer.isPlaying()))
    {
      mMediaPlayer.pause();
      mCurrentState = 4;
    }
    mTargetState = 4;
  }
  
  public void release(boolean paramBoolean)
  {
    if (mMediaPlayer != null)
    {
      mMediaPlayer.reset();
      mMediaPlayer.release();
      mMediaPlayer = null;
      mCurrentState = 0;
      if (paramBoolean) {
        mTargetState = 0;
      }
    }
  }
  
  public void seekTo(int paramInt) {}
  
  public void setMediaController(MediaController paramMediaController)
  {
    if (mMediaController != null) {
      mMediaController.hide();
    }
    mMediaController = paramMediaController;
    attachMediaController();
  }
  
  public void setOnCompletionListener(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    mOnCompletionListener = paramOnCompletionListener;
  }
  
  public void setOnErrorListener(MediaPlayer.OnErrorListener paramOnErrorListener)
  {
    mOnErrorListener = paramOnErrorListener;
  }
  
  public void setOnPreparedListener(MediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    mOnPreparedListener = paramOnPreparedListener;
  }
  
  public void setVideoPath(String paramString)
  {
    setVideoURI(Uri.parse(paramString));
  }
  
  public void setVideoURI(Uri paramUri)
  {
    setVideoURI(paramUri, null);
  }
  
  public void setVideoURI(Uri paramUri, Map<String, String> paramMap)
  {
    mUri = paramUri;
    openVideo();
    requestLayout();
    invalidate();
  }
  
  public void start()
  {
    if (isInPlaybackState())
    {
      mMediaPlayer.start();
      mCurrentState = 3;
    }
    mTargetState = 3;
  }
  
  public void stopPlayback()
  {
    if (mMediaPlayer != null)
    {
      mMediaPlayer.stop();
      mMediaPlayer.release();
      mMediaPlayer = null;
      mCurrentState = 0;
      mTargetState = 0;
    }
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.TextureVideoView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */