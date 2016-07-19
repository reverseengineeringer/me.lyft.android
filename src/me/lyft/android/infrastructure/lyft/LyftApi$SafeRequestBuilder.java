package me.lyft.android.infrastructure.lyft;

import com.squareup.okhttp.Request.Builder;
import me.lyft.android.logging.L;

class LyftApi$SafeRequestBuilder
  extends Request.Builder
{
  public Request.Builder addHeader(String paramString1, String paramString2)
  {
    try
    {
      super.addHeader(paramString1, paramString2);
      return this;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException = localIllegalArgumentException;
      L.e("Unsupported exception in header: %s with value: %s", new Object[] { paramString1, paramString2 });
      super.addHeader(paramString1, "Unsupported");
      return this;
    }
    finally {}
    return this;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.lyft.LyftApi.SafeRequestBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */