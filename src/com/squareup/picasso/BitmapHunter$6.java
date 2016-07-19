package com.squareup.picasso;

final class BitmapHunter$6
  implements Runnable
{
  BitmapHunter$6(Transformation paramTransformation) {}
  
  public void run()
  {
    throw new IllegalStateException("Transformation " + val$transformation.key() + " mutated input Bitmap but failed to recycle the original.");
  }
}

/* Location:
 * Qualified Name:     com.squareup.picasso.BitmapHunter.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */