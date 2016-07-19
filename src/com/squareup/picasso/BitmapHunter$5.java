package com.squareup.picasso;

final class BitmapHunter$5
  implements Runnable
{
  BitmapHunter$5(Transformation paramTransformation) {}
  
  public void run()
  {
    throw new IllegalStateException("Transformation " + val$transformation.key() + " returned input Bitmap but recycled it.");
  }
}

/* Location:
 * Qualified Name:     com.squareup.picasso.BitmapHunter.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */