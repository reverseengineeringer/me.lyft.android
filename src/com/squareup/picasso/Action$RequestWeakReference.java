package com.squareup.picasso;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

class Action$RequestWeakReference<M>
  extends WeakReference<M>
{
  final Action action;
  
  public Action$RequestWeakReference(Action paramAction, M paramM, ReferenceQueue<? super M> paramReferenceQueue)
  {
    super(paramM, paramReferenceQueue);
    action = paramAction;
  }
}

/* Location:
 * Qualified Name:     com.squareup.picasso.Action.RequestWeakReference
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */