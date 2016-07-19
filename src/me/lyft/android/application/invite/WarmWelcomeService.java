package me.lyft.android.application.invite;

import com.lyft.android.api.dto.WarmWelcomeDTO;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
import me.lyft.android.common.Strings;
import me.lyft.android.common.UriParser;
import me.lyft.android.domain.invite.WarmWelcome;
import me.lyft.android.domain.invite.WarmWelcomeMapper;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.logging.L;
import me.lyft.android.persistence.ISimpleRepository;
import rx.Observable;
import rx.functions.Func1;

public class WarmWelcomeService
  implements IWarmWelcomeService
{
  private final ILyftApi lyftApi;
  private final ISimpleRepository<String> warmWelcomeRepository;
  
  public WarmWelcomeService(ILyftApi paramILyftApi, ISimpleRepository<String> paramISimpleRepository)
  {
    lyftApi = paramILyftApi;
    warmWelcomeRepository = paramISimpleRepository;
  }
  
  private Observable<WarmWelcome> getWarmWelcome(String paramString)
  {
    lyftApi.getWarmWelcome(paramString).map(new Func1()
    {
      public WarmWelcome call(WarmWelcomeDTO paramAnonymousWarmWelcomeDTO)
      {
        return WarmWelcomeMapper.fromWarmWelcomeDTO(paramAnonymousWarmWelcomeDTO);
      }
    });
  }
  
  private static String parseReferrerString(String paramString)
  {
    if (Strings.isNullOrEmpty(paramString)) {
      return null;
    }
    try
    {
      String str = URLDecoder.decode(paramString, "UTF-8");
      paramString = str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        L.e("Referrer - referrer parsing error:" + paramString, new Object[0]);
      }
    }
    return (String)UriParser.parseParams(paramString).get("browser_id");
  }
  
  public void checkForWarmWelcomeAssignment(String paramString)
  {
    paramString = parseReferrerString(paramString);
    if (!Strings.isNullOrEmpty(paramString)) {
      warmWelcomeRepository.update(paramString);
    }
  }
  
  public Observable<WarmWelcome> observeWarmWelcome()
  {
    warmWelcomeRepository.observe().filter(new Func1()
    {
      public Boolean call(String paramAnonymousString)
      {
        if (!Strings.isNullOrEmpty(paramAnonymousString)) {}
        for (boolean bool = true;; bool = false) {
          return Boolean.valueOf(bool);
        }
      }
    }).first().flatMap(new Func1()
    {
      public Observable<WarmWelcome> call(String paramAnonymousString)
      {
        return WarmWelcomeService.this.getWarmWelcome(paramAnonymousString);
      }
    });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.invite.WarmWelcomeService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */