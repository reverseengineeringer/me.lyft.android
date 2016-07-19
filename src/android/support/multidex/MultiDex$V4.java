package android.support.multidex;

import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.ListIterator;
import java.util.zip.ZipFile;

final class MultiDex$V4
{
  private static void install(ClassLoader paramClassLoader, List<File> paramList)
    throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException
  {
    int i = paramList.size();
    Field localField = MultiDex.access$300(paramClassLoader, "path");
    StringBuilder localStringBuilder = new StringBuilder((String)localField.get(paramClassLoader));
    String[] arrayOfString = new String[i];
    File[] arrayOfFile = new File[i];
    ZipFile[] arrayOfZipFile = new ZipFile[i];
    DexFile[] arrayOfDexFile = new DexFile[i];
    paramList = paramList.listIterator();
    while (paramList.hasNext())
    {
      File localFile = (File)paramList.next();
      String str = localFile.getAbsolutePath();
      localStringBuilder.append(':').append(str);
      i = paramList.previousIndex();
      arrayOfString[i] = str;
      arrayOfFile[i] = localFile;
      arrayOfZipFile[i] = new ZipFile(localFile);
      arrayOfDexFile[i] = DexFile.loadDex(str, str + ".dex", 0);
    }
    localField.set(paramClassLoader, localStringBuilder.toString());
    MultiDex.access$400(paramClassLoader, "mPaths", arrayOfString);
    MultiDex.access$400(paramClassLoader, "mFiles", arrayOfFile);
    MultiDex.access$400(paramClassLoader, "mZips", arrayOfZipFile);
    MultiDex.access$400(paramClassLoader, "mDexs", arrayOfDexFile);
  }
}

/* Location:
 * Qualified Name:     android.support.multidex.MultiDex.V4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */