package com.google.i18n.phonenumbers;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

final class MultiFileMetadataSourceImpl
  implements MetadataSource
{
  private static final Logger logger = Logger.getLogger(MultiFileMetadataSourceImpl.class.getName());
  private final Map<Integer, Phonemetadata.PhoneMetadata> countryCodeToNonGeographicalMetadataMap = Collections.synchronizedMap(new HashMap());
  private final String filePrefix;
  private final MetadataLoader metadataLoader;
  private final Map<String, Phonemetadata.PhoneMetadata> regionToMetadataMap = Collections.synchronizedMap(new HashMap());
  
  public MultiFileMetadataSourceImpl(MetadataLoader paramMetadataLoader)
  {
    this("/com/google/i18n/phonenumbers/data/PhoneNumberMetadataProto", paramMetadataLoader);
  }
  
  public MultiFileMetadataSourceImpl(String paramString, MetadataLoader paramMetadataLoader)
  {
    filePrefix = paramString;
    metadataLoader = paramMetadataLoader;
  }
  
  private static Phonemetadata.PhoneMetadataCollection loadMetadataAndCloseInput(ObjectInputStream paramObjectInputStream)
  {
    Phonemetadata.PhoneMetadataCollection localPhoneMetadataCollection = new Phonemetadata.PhoneMetadataCollection();
    try
    {
      localPhoneMetadataCollection.readExternal(paramObjectInputStream);
      try
      {
        paramObjectInputStream.close();
        return localPhoneMetadataCollection;
      }
      catch (IOException paramObjectInputStream)
      {
        logger.log(Level.WARNING, "error closing input stream (ignored)", paramObjectInputStream);
        return localPhoneMetadataCollection;
      }
      try
      {
        paramObjectInputStream.close();
        throw ((Throwable)localObject);
      }
      catch (IOException paramObjectInputStream)
      {
        for (;;)
        {
          logger.log(Level.WARNING, "error closing input stream (ignored)", paramObjectInputStream);
        }
      }
    }
    catch (IOException localIOException)
    {
      localIOException = localIOException;
      logger.log(Level.WARNING, "error reading input (ignored)", localIOException);
      try
      {
        paramObjectInputStream.close();
        return localPhoneMetadataCollection;
      }
      catch (IOException paramObjectInputStream)
      {
        logger.log(Level.WARNING, "error closing input stream (ignored)", paramObjectInputStream);
        return localPhoneMetadataCollection;
      }
    }
    finally {}
  }
  
  public Phonemetadata.PhoneMetadata getMetadataForNonGeographicalRegion(int paramInt)
  {
    synchronized (countryCodeToNonGeographicalMetadataMap)
    {
      if (!countryCodeToNonGeographicalMetadataMap.containsKey(Integer.valueOf(paramInt))) {
        loadMetadataFromFile("001", paramInt);
      }
      return (Phonemetadata.PhoneMetadata)countryCodeToNonGeographicalMetadataMap.get(Integer.valueOf(paramInt));
    }
  }
  
  public Phonemetadata.PhoneMetadata getMetadataForRegion(String paramString)
  {
    synchronized (regionToMetadataMap)
    {
      if (!regionToMetadataMap.containsKey(paramString)) {
        loadMetadataFromFile(paramString, 0);
      }
      return (Phonemetadata.PhoneMetadata)regionToMetadataMap.get(paramString);
    }
  }
  
  void loadMetadataFromFile(String paramString, int paramInt)
  {
    boolean bool = "001".equals(paramString);
    String str = String.valueOf(String.valueOf(filePrefix));
    if (bool)
    {
      localObject1 = String.valueOf(paramInt);
      localObject1 = String.valueOf(String.valueOf(localObject1));
      str = str.length() + 1 + ((String)localObject1).length() + str + "_" + (String)localObject1;
      localObject1 = metadataLoader.loadMetadata(str);
      if (localObject1 != null) {
        break label196;
      }
      localObject1 = logger;
      localObject2 = Level.SEVERE;
      paramString = String.valueOf(str);
      if (paramString.length() == 0) {
        break label170;
      }
      paramString = "missing metadata: ".concat(paramString);
      label127:
      ((Logger)localObject1).log((Level)localObject2, paramString);
      paramString = String.valueOf(str);
      if (paramString.length() == 0) {
        break label183;
      }
    }
    label170:
    label183:
    for (paramString = "missing metadata: ".concat(paramString);; paramString = new String("missing metadata: "))
    {
      throw new IllegalStateException(paramString);
      localObject1 = paramString;
      break;
      paramString = new String("missing metadata: ");
      break label127;
    }
    try
    {
      label196:
      localObject1 = new ObjectInputStream((InputStream)localObject1);
      try
      {
        localObject2 = loadMetadataAndCloseInput((ObjectInputStream)localObject1).getMetadataList();
        if (!((List)localObject2).isEmpty()) {
          break label400;
        }
        localObject1 = logger;
        localObject2 = Level.SEVERE;
        paramString = String.valueOf(str);
        if (paramString.length() == 0) {
          break label374;
        }
        paramString = "empty metadata: ".concat(paramString);
        ((Logger)localObject1).log((Level)localObject2, paramString);
        paramString = String.valueOf(str);
        if (paramString.length() == 0) {
          break label387;
        }
        paramString = "empty metadata: ".concat(paramString);
        label285:
        throw new IllegalStateException(paramString);
      }
      catch (IOException paramString) {}
    }
    catch (IOException paramString)
    {
      Object localObject3;
      label329:
      label374:
      label387:
      label400:
      label488:
      label530:
      for (;;) {}
    }
    Object localObject2 = logger;
    localObject3 = Level.SEVERE;
    Object localObject1 = String.valueOf(str);
    if (((String)localObject1).length() != 0)
    {
      localObject1 = "cannot load/parse metadata: ".concat((String)localObject1);
      ((Logger)localObject2).log((Level)localObject3, (String)localObject1, paramString);
      localObject1 = String.valueOf(str);
      if (((String)localObject1).length() == 0) {
        break label530;
      }
    }
    for (localObject1 = "cannot load/parse metadata: ".concat((String)localObject1);; localObject1 = new String("cannot load/parse metadata: "))
    {
      throw new RuntimeException((String)localObject1, paramString);
      paramString = new String("empty metadata: ");
      break;
      paramString = new String("empty metadata: ");
      break label285;
      Level localLevel;
      if (((List)localObject2).size() > 1)
      {
        localObject3 = logger;
        localLevel = Level.WARNING;
        localObject1 = String.valueOf(str);
        if (((String)localObject1).length() == 0) {
          break label488;
        }
      }
      for (localObject1 = "invalid metadata (too many entries): ".concat((String)localObject1);; localObject1 = new String("invalid metadata (too many entries): "))
      {
        ((Logger)localObject3).log(localLevel, (String)localObject1);
        localObject1 = (Phonemetadata.PhoneMetadata)((List)localObject2).get(0);
        if (!bool) {
          break;
        }
        countryCodeToNonGeographicalMetadataMap.put(Integer.valueOf(paramInt), localObject1);
        return;
      }
      regionToMetadataMap.put(paramString, localObject1);
      return;
      localObject1 = new String("cannot load/parse metadata: ");
      break label329;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.i18n.phonenumbers.MultiFileMetadataSourceImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */