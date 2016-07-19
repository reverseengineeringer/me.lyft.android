package com.squareup.picasso;

public abstract interface Picasso$RequestTransformer
{
  public static final RequestTransformer IDENTITY = new RequestTransformer()
  {
    public Request transformRequest(Request paramAnonymousRequest)
    {
      return paramAnonymousRequest;
    }
  };
  
  public abstract Request transformRequest(Request paramRequest);
}

/* Location:
 * Qualified Name:     com.squareup.picasso.Picasso.RequestTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */