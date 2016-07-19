package android.support.v4.media.session;

public final class MediaControllerCompat
{
  private final MediaControllerImpl mImpl;
  
  public Object getMediaController()
  {
    return mImpl.getMediaController();
  }
  
  static abstract interface MediaControllerImpl
  {
    public abstract Object getMediaController();
  }
}

/* Location:
 * Qualified Name:     android.support.v4.media.session.MediaControllerCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */