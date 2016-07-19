package com.facebook.share.model;

import com.facebook.share.ShareBuilder;

public abstract interface ShareModelBuilder<P extends ShareModel, E extends ShareModelBuilder>
  extends ShareBuilder<P, E>
{
  public abstract E readFrom(P paramP);
}

/* Location:
 * Qualified Name:     com.facebook.share.model.ShareModelBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */