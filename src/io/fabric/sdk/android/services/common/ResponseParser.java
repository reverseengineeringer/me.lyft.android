package io.fabric.sdk.android.services.common;

public class ResponseParser
{
  public static int parse(int paramInt)
  {
    if ((paramInt >= 200) && (paramInt <= 299)) {}
    do
    {
      return 0;
      if ((paramInt >= 300) && (paramInt <= 399)) {
        return 1;
      }
    } while ((paramInt >= 400) && (paramInt <= 499));
    if (paramInt >= 500) {
      return 1;
    }
    return 1;
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.common.ResponseParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */