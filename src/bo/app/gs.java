package bo.app;

import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Process;
import com.appboy.support.AppboyFileUtils;
import com.appboy.support.AppboyLogger;
import com.appboy.support.IntentUtils;
import com.appboy.support.StringUtils;
import com.appboy.support.WebContentUtils;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class gs
  implements Runnable
{
  gs(gr paramgr, Set paramSet, SharedPreferences.Editor paramEditor) {}
  
  public final void run()
  {
    Process.setThreadPriority(10);
    Iterator localIterator = a.iterator();
    String str1;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      str1 = (String)localIterator.next();
    } while (gr.a(c).containsKey(str1));
    for (;;)
    {
      try
      {
        Object localObject1 = c.a();
        str2 = AppboyFileUtils.getMimeType(str1);
        if ((str2 == null) || (!str2.equals("application/zip"))) {
          break label218;
        }
        localObject1 = WebContentUtils.getLocalHtmlUrlFromRemoteUrl((File)localObject1, str1);
        if (StringUtils.isNullOrBlank((String)localObject1)) {
          break label197;
        }
        AppboyLogger.i(gr.a, String.format("Storing local triggered action html zip asset at local path %s for remote path %s.", new Object[] { localObject1, str1 }));
        if (StringUtils.isNullOrBlank((String)localObject1)) {
          break;
        }
        gr.b();
        String.format("Adding new local path %s for remote path %s to cache.", new Object[] { localObject1, str1 });
        gr.a(c).put(str1, localObject1);
        b.putString(str1, (String)localObject1);
      }
      catch (Exception localException)
      {
        gr.b();
        String.format("Failed to add new local path for remote path %s.", new Object[] { str1 });
      }
      break;
      label197:
      Object localObject2 = gr.a;
      String.format("Failed to store html zip asset for remote path %s. Not storing local asset", new Object[] { str1 });
      break label317;
      label218:
      String str2 = Integer.toString(IntentUtils.getRequestCode());
      localObject2 = AppboyFileUtils.downloadFileToPath(((File)localObject2).toString(), str1, str2, null);
      if (localObject2 != null)
      {
        localObject2 = Uri.fromFile((File)localObject2);
        if (localObject2 != null)
        {
          AppboyLogger.i(gr.a, String.format("Storing local triggered action image asset at local path %s for remote path %s.", new Object[] { ((Uri)localObject2).getPath(), str1 }));
          localObject2 = ((Uri)localObject2).getPath();
          continue;
        }
        localObject2 = gr.a;
        String.format("Failed to store image asset for remote path %s. Not storing local asset", new Object[] { str1 });
        break label317;
        b.apply();
        return;
      }
      label317:
      localObject2 = null;
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.gs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */