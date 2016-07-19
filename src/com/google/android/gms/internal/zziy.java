package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@zzir
class zziy
{
  private String zzae;
  private final String zzbvu;
  private int zzbym;
  private final List<String> zzcfy;
  private final List<String> zzcfz;
  private final String zzcga;
  private final String zzcgb;
  private final String zzcgc;
  private final String zzcgd;
  private final boolean zzcge;
  private final boolean zzcgf;
  private final String zzcgg;
  
  public zziy(int paramInt, Map<String, String> paramMap)
  {
    zzae = ((String)paramMap.get("url"));
    zzcgb = ((String)paramMap.get("base_uri"));
    zzcgc = ((String)paramMap.get("post_parameters"));
    zzcge = parseBoolean((String)paramMap.get("drt_include"));
    zzcgf = parseBoolean((String)paramMap.get("pan_include"));
    zzcga = ((String)paramMap.get("activation_overlay_url"));
    zzcfz = zzcf((String)paramMap.get("check_packages"));
    zzbvu = ((String)paramMap.get("request_id"));
    zzcgd = ((String)paramMap.get("type"));
    zzcfy = zzcf((String)paramMap.get("errors"));
    zzbym = paramInt;
    zzcgg = ((String)paramMap.get("fetched_ad"));
  }
  
  private static boolean parseBoolean(String paramString)
  {
    return (paramString != null) && ((paramString.equals("1")) || (paramString.equals("true")));
  }
  
  private List<String> zzcf(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Arrays.asList(paramString.split(","));
  }
  
  public int getErrorCode()
  {
    return zzbym;
  }
  
  public String getRequestId()
  {
    return zzbvu;
  }
  
  public String getType()
  {
    return zzcgd;
  }
  
  public String getUrl()
  {
    return zzae;
  }
  
  public void setUrl(String paramString)
  {
    zzae = paramString;
  }
  
  public List<String> zzrk()
  {
    return zzcfy;
  }
  
  public String zzrl()
  {
    return zzcgc;
  }
  
  public boolean zzrm()
  {
    return zzcge;
  }
  
  public String zzrn()
  {
    return zzcgg;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zziy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */