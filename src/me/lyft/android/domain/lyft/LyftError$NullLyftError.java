package me.lyft.android.domain.lyft;

import java.util.Collections;

final class LyftError$NullLyftError
  extends LyftError
{
  private static final NullLyftError INSTANCE = new NullLyftError();
  
  public LyftError$NullLyftError()
  {
    super("", Collections.emptyList(), "", Double.valueOf(0.0D), "", Collections.emptyMap());
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.lyft.LyftError.NullLyftError
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */