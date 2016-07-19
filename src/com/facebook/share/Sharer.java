package com.facebook.share;

public abstract interface Sharer
{
  public abstract boolean getShouldFailOnDataError();
  
  public abstract void setShouldFailOnDataError(boolean paramBoolean);
  
  public static class Result
  {
    final String postId;
    
    public Result(String paramString)
    {
      postId = paramString;
    }
    
    public String getPostId()
    {
      return postId;
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.Sharer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */