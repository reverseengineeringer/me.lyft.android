package com.facebook;

class AccessTokenCache$SharedPreferencesTokenCachingStrategyFactory
{
  public LegacyTokenHelper create()
  {
    return new LegacyTokenHelper(FacebookSdk.getApplicationContext());
  }
}

/* Location:
 * Qualified Name:     com.facebook.AccessTokenCache.SharedPreferencesTokenCachingStrategyFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */