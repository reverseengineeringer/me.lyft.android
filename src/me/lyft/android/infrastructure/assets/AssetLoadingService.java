package me.lyft.android.infrastructure.assets;

import android.content.Context;
import android.graphics.Bitmap;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Transformation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import javax.inject.Inject;
import me.lyft.android.infrastructure.device.IDevice;
import me.lyft.android.managers.ImageLoader;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class AssetLoadingService
  implements IAssetLoadingService
{
  final Context context;
  final DensityTransformation densityTransformation;
  final IDevice device;
  final ImageLoader imageLoader;
  final HashMap<String, Bitmap> markerBitmapCache = new HashMap();
  
  @Inject
  public AssetLoadingService(Context paramContext, IDevice paramIDevice, ImageLoader paramImageLoader)
  {
    device = paramIDevice;
    imageLoader = paramImageLoader;
    context = paramContext;
    densityTransformation = new DensityTransformation(paramIDevice.getDensityDpi());
  }
  
  private File getAssetFile(String paramString)
  {
    return new File(getAssetsFolderPath(), paramString);
  }
  
  private String getAssetsFolderPath()
  {
    return AssetsPath.get(context);
  }
  
  private Bitmap loadMarkerBitmapSync(String paramString)
    throws IOException
  {
    if (markerBitmapCache.containsKey(paramString)) {
      return (Bitmap)markerBitmapCache.get(paramString);
    }
    Object localObject = getAssetFile(paramString);
    if ((((File)localObject).isFile()) && (((File)localObject).exists()))
    {
      localObject = loadImage(paramString).get();
      markerBitmapCache.put(paramString, localObject);
      return (Bitmap)localObject;
    }
    throw new FileNotFoundException("Failed to find asset with such name " + paramString);
  }
  
  public RequestCreator loadImage(String paramString)
  {
    return loadImageWithoutDensityTransformation(paramString).transform(densityTransformation);
  }
  
  public RequestCreator loadImageWithoutDensityTransformation(String paramString)
  {
    paramString = getAssetFile(paramString);
    return imageLoader.load(paramString);
  }
  
  public Observable<Bitmap> loadMarkerBitmap(final String paramString)
  {
    Observable.create(new Observable.OnSubscribe()
    {
      public void call(Subscriber<? super Bitmap> paramAnonymousSubscriber)
      {
        try
        {
          paramAnonymousSubscriber.onNext(AssetLoadingService.this.loadMarkerBitmapSync(paramString));
          paramAnonymousSubscriber.onCompleted();
          return;
        }
        catch (Exception localException)
        {
          paramAnonymousSubscriber.onError(localException);
        }
      }
    }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
  }
  
  static class DensityTransformation
    implements Transformation
  {
    final double scaleRation;
    final int screenDensity;
    
    public DensityTransformation(int paramInt)
    {
      screenDensity = paramInt;
      scaleRation = (1.0D * paramInt / 480.0D);
    }
    
    public String key()
    {
      return "square()";
    }
    
    public Bitmap transform(Bitmap paramBitmap)
    {
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(scaleRation * i), (int)(scaleRation * j), false);
      if (localBitmap != paramBitmap) {
        paramBitmap.recycle();
      }
      return localBitmap;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.assets.AssetLoadingService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */