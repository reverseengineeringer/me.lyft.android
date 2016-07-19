package io.fabric.sdk.android.services.events;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class EventsFilesManager<T>
{
  protected final Context context;
  protected final CurrentTimeProvider currentTimeProvider;
  private final int defaultMaxFilesToKeep;
  protected final EventsStorage eventStorage;
  protected volatile long lastRollOverTime;
  protected final List<EventsStorageListener> rollOverListeners = new CopyOnWriteArrayList();
  protected final EventTransform<T> transform;
  
  public EventsFilesManager(Context paramContext, EventTransform<T> paramEventTransform, CurrentTimeProvider paramCurrentTimeProvider, EventsStorage paramEventsStorage, int paramInt)
    throws IOException
  {
    context = paramContext.getApplicationContext();
    transform = paramEventTransform;
    eventStorage = paramEventsStorage;
    currentTimeProvider = paramCurrentTimeProvider;
    lastRollOverTime = currentTimeProvider.getCurrentTimeMillis();
    defaultMaxFilesToKeep = paramInt;
  }
  
  private void rollFileOverIfNeeded(int paramInt)
    throws IOException
  {
    if (!eventStorage.canWorkingFileStore(paramInt, getMaxByteSizePerFile()))
    {
      String str = String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", new Object[] { Integer.valueOf(eventStorage.getWorkingFileUsedSizeInBytes()), Integer.valueOf(paramInt), Integer.valueOf(getMaxByteSizePerFile()) });
      CommonUtils.logControlled(context, 4, "Fabric", str);
      rollFileOver();
    }
  }
  
  private void triggerRollOverOnListeners(String paramString)
  {
    Iterator localIterator = rollOverListeners.iterator();
    while (localIterator.hasNext())
    {
      EventsStorageListener localEventsStorageListener = (EventsStorageListener)localIterator.next();
      try
      {
        localEventsStorageListener.onRollOver(paramString);
      }
      catch (Exception localException)
      {
        CommonUtils.logControlledError(context, "One of the roll over listeners threw an exception", localException);
      }
    }
  }
  
  public void deleteAllEventsFiles()
  {
    eventStorage.deleteFilesInRollOverDirectory(eventStorage.getAllFilesInRollOverDirectory());
    eventStorage.deleteWorkingFile();
  }
  
  public void deleteOldestInRollOverIfOverMax()
  {
    Object localObject2 = eventStorage.getAllFilesInRollOverDirectory();
    int i = getMaxFilesToKeep();
    if (((List)localObject2).size() <= i) {
      return;
    }
    int j = ((List)localObject2).size() - i;
    CommonUtils.logControlled(context, String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", new Object[] { Integer.valueOf(((List)localObject2).size()), Integer.valueOf(i), Integer.valueOf(j) }));
    Object localObject1 = new TreeSet(new Comparator()
    {
      public int compare(EventsFilesManager.FileWithTimestamp paramAnonymousFileWithTimestamp1, EventsFilesManager.FileWithTimestamp paramAnonymousFileWithTimestamp2)
      {
        return (int)(timestamp - timestamp);
      }
    });
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      File localFile = (File)((Iterator)localObject2).next();
      ((TreeSet)localObject1).add(new FileWithTimestamp(localFile, parseCreationTimestampFromFileName(localFile.getName())));
    }
    localObject2 = new ArrayList();
    localObject1 = ((TreeSet)localObject1).iterator();
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      ((ArrayList)localObject2).add(nextfile);
    } while (((ArrayList)localObject2).size() != j);
    eventStorage.deleteFilesInRollOverDirectory((List)localObject2);
  }
  
  public void deleteSentFiles(List<File> paramList)
  {
    eventStorage.deleteFilesInRollOverDirectory(paramList);
  }
  
  protected abstract String generateUniqueRollOverFileName();
  
  public List<File> getBatchOfFilesToSend()
  {
    return eventStorage.getBatchOfFilesToSend(1);
  }
  
  protected int getMaxByteSizePerFile()
  {
    return 8000;
  }
  
  protected int getMaxFilesToKeep()
  {
    return defaultMaxFilesToKeep;
  }
  
  public long parseCreationTimestampFromFileName(String paramString)
  {
    paramString = paramString.split("_");
    if (paramString.length != 3) {
      return 0L;
    }
    try
    {
      long l = Long.valueOf(paramString[2]).longValue();
      return l;
    }
    catch (NumberFormatException paramString) {}
    return 0L;
  }
  
  public void registerRollOverListener(EventsStorageListener paramEventsStorageListener)
  {
    if (paramEventsStorageListener != null) {
      rollOverListeners.add(paramEventsStorageListener);
    }
  }
  
  public boolean rollFileOver()
    throws IOException
  {
    boolean bool = false;
    String str = null;
    if (!eventStorage.isWorkingFileEmpty())
    {
      str = generateUniqueRollOverFileName();
      eventStorage.rollOver(str);
      CommonUtils.logControlled(context, 4, "Fabric", String.format(Locale.US, "generated new file %s", new Object[] { str }));
      lastRollOverTime = currentTimeProvider.getCurrentTimeMillis();
      bool = true;
    }
    triggerRollOverOnListeners(str);
    return bool;
  }
  
  public void writeEvent(T paramT)
    throws IOException
  {
    paramT = transform.toBytes(paramT);
    rollFileOverIfNeeded(paramT.length);
    eventStorage.add(paramT);
  }
  
  static class FileWithTimestamp
  {
    final File file;
    final long timestamp;
    
    public FileWithTimestamp(File paramFile, long paramLong)
    {
      file = paramFile;
      timestamp = paramLong;
    }
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.events.EventsFilesManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */