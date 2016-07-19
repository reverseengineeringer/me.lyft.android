package me.lyft.android.infrastructure.lyft;

import com.lyft.android.api.dto.UniversalDTO;
import rx.functions.Action1;

class LyftApi$1
  implements Action1<UniversalDTO>
{
  LyftApi$1(LyftApi paramLyftApi) {}
  
  public void call(UniversalDTO paramUniversalDTO)
  {
    LyftApi.access$100(this$0).setAppState(paramUniversalDTO);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.lyft.LyftApi.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */