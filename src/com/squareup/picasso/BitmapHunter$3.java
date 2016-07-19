package com.squareup.picasso;

final class BitmapHunter$3
  implements Runnable
{
  BitmapHunter$3(Transformation paramTransformation, RuntimeException paramRuntimeException) {}
  
  public void run()
  {
    throw new RuntimeException("Transformation " + val$transformation.key() + " crashed with exception.", val$e);
  }
}

/* Location:
 * Qualified Name:     com.squareup.picasso.BitmapHunter.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */