package me.lyft.android.infrastructure.profile;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.RequestCreator;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;
import javax.inject.Singleton;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.profile.IProfilePhotoFileRecipient;
import me.lyft.android.domain.User;
import me.lyft.android.managers.ImageLoader;

@Singleton
public class ProfilePhotoLoader
  implements IProfilePhotoFileRecipient, IProfilePhotoLoader
{
  private AtomicReference<File> cachedFileReference = new AtomicReference();
  private ImageLoader imageLoader;
  private String lastUsedPhoto;
  private AtomicReference<File> previewFileReference = new AtomicReference();
  private IUserProvider userProvider;
  
  @Inject
  public ProfilePhotoLoader(ImageLoader paramImageLoader, IUserProvider paramIUserProvider)
  {
    imageLoader = paramImageLoader;
    userProvider = paramIUserProvider;
  }
  
  private void invalidateFileReferencesIfChanged(String paramString)
  {
    String str = lastUsedPhoto;
    lastUsedPhoto = paramString;
    if ((str != null) && (!str.equals(paramString)))
    {
      cachedFileReference.set(null);
      previewFileReference.set(null);
    }
  }
  
  private RequestCreator performLoad(File paramFile)
  {
    String str = userProvider.getUser().getPhotoUrl();
    invalidateFileReferencesIfChanged(str);
    if (paramFile != null) {
      return imageLoader.load(paramFile).memoryPolicy(MemoryPolicy.NO_CACHE, new MemoryPolicy[] { MemoryPolicy.NO_STORE });
    }
    return imageLoader.load(str);
  }
  
  public boolean hasCacheFile()
  {
    return cachedFileReference.get() != null;
  }
  
  public RequestCreator load()
  {
    return performLoad((File)cachedFileReference.get());
  }
  
  public RequestCreator loadPreview()
  {
    return performLoad((File)previewFileReference.get());
  }
  
  public void usePhotoFile(File paramFile)
  {
    cachedFileReference.set(paramFile);
    previewFileReference.set(paramFile);
  }
  
  public void usePhotoFilePreview(File paramFile)
  {
    File localFile = paramFile;
    if (paramFile == null) {
      localFile = (File)cachedFileReference.get();
    }
    previewFileReference.set(localFile);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.profile.ProfilePhotoLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */