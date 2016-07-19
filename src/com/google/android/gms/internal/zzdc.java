package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzu;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@zzir
public final class zzdc
{
  public static final zzcy<String> zzaxv = zzcy.zza(0, "gads:sdk_core_experiment_id");
  public static final zzcy<String> zzaxw = zzcy.zza(0, "gads:sdk_core_location", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html");
  public static final zzcy<Boolean> zzaxx = zzcy.zza(0, "gads:request_builder:singleton_webview", Boolean.valueOf(false));
  public static final zzcy<String> zzaxy = zzcy.zza(0, "gads:request_builder:singleton_webview_experiment_id");
  public static final zzcy<Boolean> zzaxz = zzcy.zza(0, "gads:sdk_use_dynamic_module", Boolean.valueOf(true));
  public static final zzcy<String> zzaya = zzcy.zza(0, "gads:sdk_use_dynamic_module_experiment_id");
  public static final zzcy<Boolean> zzayb = zzcy.zza(0, "gads:sdk_crash_report_enabled", Boolean.valueOf(false));
  public static final zzcy<Boolean> zzayc = zzcy.zza(0, "gads:sdk_crash_report_full_stacktrace", Boolean.valueOf(false));
  public static final zzcy<String> zzayd = zzcy.zza(0, "gads:sdk_crash_report_class_prefix", "com.google.");
  public static final zzcy<Boolean> zzaye = zzcy.zza(0, "gads:block_autoclicks", Boolean.valueOf(false));
  public static final zzcy<String> zzayf = zzcy.zza(0, "gads:block_autoclicks_experiment_id");
  public static final zzcy<String> zzayg = zzcy.zzb(0, "gads:prefetch:experiment_id");
  public static final zzcy<String> zzayh = zzcy.zza(0, "gads:spam_app_context:experiment_id");
  public static final zzcy<Boolean> zzayi = zzcy.zza(0, "gads:spam_app_context:enabled", Boolean.valueOf(false));
  public static final zzcy<String> zzayj = zzcy.zza(0, "gads:video_stream_cache:experiment_id");
  public static final zzcy<Integer> zzayk = zzcy.zza(0, "gads:video_stream_cache:limit_count", 5);
  public static final zzcy<Integer> zzayl = zzcy.zza(0, "gads:video_stream_cache:limit_space", 8388608);
  public static final zzcy<Integer> zzaym = zzcy.zza(0, "gads:video_stream_exo_cache:buffer_size", 8388608);
  public static final zzcy<Long> zzayn = zzcy.zza(0, "gads:video_stream_cache:limit_time_sec", 300L);
  public static final zzcy<Long> zzayo = zzcy.zza(0, "gads:video_stream_cache:notify_interval_millis", 1000L);
  public static final zzcy<Integer> zzayp = zzcy.zza(0, "gads:video_stream_cache:connect_timeout_millis", 10000);
  public static final zzcy<Boolean> zzayq = zzcy.zza(0, "gads:video:metric_reporting_enabled", Boolean.valueOf(false));
  public static final zzcy<String> zzayr = zzcy.zza(0, "gads:video:metric_frame_hash_times", "");
  public static final zzcy<Long> zzays = zzcy.zza(0, "gads:video:metric_frame_hash_time_leniency", 500L);
  public static final zzcy<String> zzayt = zzcy.zzb(0, "gads:spam_ad_id_decorator:experiment_id");
  public static final zzcy<Boolean> zzayu = zzcy.zza(0, "gads:spam_ad_id_decorator:enabled", Boolean.valueOf(false));
  public static final zzcy<String> zzayv = zzcy.zzb(0, "gads:looper_for_gms_client:experiment_id");
  public static final zzcy<Boolean> zzayw = zzcy.zza(0, "gads:looper_for_gms_client:enabled", Boolean.valueOf(true));
  public static final zzcy<Boolean> zzayx = zzcy.zza(0, "gads:sw_ad_request_service:enabled", Boolean.valueOf(true));
  public static final zzcy<Boolean> zzayy = zzcy.zza(0, "gads:sw_dynamite:enabled", Boolean.valueOf(true));
  public static final zzcy<String> zzayz = zzcy.zza(0, "gad:mraid:url_banner", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_banner.js");
  public static final zzcy<String> zzaza = zzcy.zza(0, "gad:mraid:url_expanded_banner", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_expanded_banner.js");
  public static final zzcy<String> zzazb = zzcy.zza(0, "gad:mraid:url_interstitial", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_interstitial.js");
  public static final zzcy<Boolean> zzazc = zzcy.zza(0, "gads:enabled_sdk_csi", Boolean.valueOf(false));
  public static final zzcy<String> zzazd = zzcy.zza(0, "gads:sdk_csi_server", "https://csi.gstatic.com/csi");
  public static final zzcy<Boolean> zzaze = zzcy.zza(0, "gads:sdk_csi_write_to_file", Boolean.valueOf(false));
  public static final zzcy<Boolean> zzazf = zzcy.zza(0, "gads:enable_content_fetching", Boolean.valueOf(true));
  public static final zzcy<Integer> zzazg = zzcy.zza(0, "gads:content_length_weight", 1);
  public static final zzcy<Integer> zzazh = zzcy.zza(0, "gads:content_age_weight", 1);
  public static final zzcy<Integer> zzazi = zzcy.zza(0, "gads:min_content_len", 11);
  public static final zzcy<Integer> zzazj = zzcy.zza(0, "gads:fingerprint_number", 10);
  public static final zzcy<Integer> zzazk = zzcy.zza(0, "gads:sleep_sec", 10);
  public static final zzcy<Boolean> zzazl = zzcy.zza(0, "gad:app_index_enabled", Boolean.valueOf(true));
  public static final zzcy<Boolean> zzazm = zzcy.zza(0, "gads:app_index:without_content_info_present:enabled", Boolean.valueOf(true));
  public static final zzcy<Long> zzazn = zzcy.zza(0, "gads:app_index:timeout_ms", 1000L);
  public static final zzcy<String> zzazo = zzcy.zza(0, "gads:app_index:experiment_id");
  public static final zzcy<String> zzazp = zzcy.zza(0, "gads:kitkat_interstitial_workaround:experiment_id");
  public static final zzcy<Boolean> zzazq = zzcy.zza(0, "gads:kitkat_interstitial_workaround:enabled", Boolean.valueOf(true));
  public static final zzcy<Boolean> zzazr = zzcy.zza(0, "gads:interstitial_follow_url", Boolean.valueOf(true));
  public static final zzcy<Boolean> zzazs = zzcy.zza(0, "gads:interstitial_follow_url:register_click", Boolean.valueOf(true));
  public static final zzcy<String> zzazt = zzcy.zza(0, "gads:interstitial_follow_url:experiment_id");
  public static final zzcy<Boolean> zzazu = zzcy.zza(0, "gads:analytics_enabled", Boolean.valueOf(true));
  public static final zzcy<Boolean> zzazv = zzcy.zza(0, "gads:ad_key_enabled", Boolean.valueOf(false));
  public static final zzcy<Integer> zzazw = zzcy.zza(0, "gads:webview_cache_version", 0);
  public static final zzcy<Boolean> zzazx = zzcy.zza(1, "gads:webview_recycle:enabled", Boolean.valueOf(false));
  public static final zzcy<String> zzazy = zzcy.zza(1, "gads:webview_recycle:experiment_id");
  public static final zzcy<String> zzazz = zzcy.zzb(0, "gads:pan:experiment_id");
  public static final zzcy<String> zzbaa = zzcy.zza(0, "gads:native:engine_url", "//googleads.g.doubleclick.net/mads/static/mad/sdk/native/native_ads.html");
  public static final zzcy<Boolean> zzbab = zzcy.zza(0, "gads:ad_manager_creator:enabled", Boolean.valueOf(true));
  public static final zzcy<Boolean> zzbac = zzcy.zza(1, "gads:interstitial_ad_pool:enabled", Boolean.valueOf(false));
  public static final zzcy<Boolean> zzbad = zzcy.zza(1, "gads:interstitial_ad_pool:enabled_for_rewarded", Boolean.valueOf(false));
  public static final zzcy<String> zzbae = zzcy.zza(1, "gads:interstitial_ad_pool:schema", "customTargeting");
  public static final zzcy<String> zzbaf = zzcy.zza(1, "gads:interstitial_ad_pool:request_exclusions", "com.google.ads.mediation.admob.AdMobAdapter/_ad");
  public static final zzcy<Integer> zzbag = zzcy.zza(1, "gads:interstitial_ad_pool:max_pools", 3);
  public static final zzcy<Integer> zzbah = zzcy.zza(1, "gads:interstitial_ad_pool:max_pool_depth", 2);
  public static final zzcy<Integer> zzbai = zzcy.zza(1, "gads:interstitial_ad_pool:time_limit_sec", 1200);
  public static final zzcy<String> zzbaj = zzcy.zza(1, "gads:interstitial_ad_pool:ad_unit_exclusions", "(?!)");
  public static final zzcy<String> zzbak = zzcy.zza(1, "gads:spherical_video:vertex_shader", "");
  public static final zzcy<String> zzbal = zzcy.zza(1, "gads:spherical_video:fragment_shader", "");
  public static final zzcy<String> zzbam = zzcy.zza(1, "gads:spherical_video:experiment_id");
  public static final zzcy<Boolean> zzban = zzcy.zza(0, "gads:log:verbose_enabled", Boolean.valueOf(false));
  public static final zzcy<Boolean> zzbao = zzcy.zza(1, "gads:include_local_global_rectangles", Boolean.valueOf(false));
  public static final zzcy<String> zzbap = zzcy.zza(1, "gads:include_local_global_rectangles:experiment_id");
  public static final zzcy<Boolean> zzbaq = zzcy.zza(0, "gads:device_info_caching:enabled", Boolean.valueOf(true));
  public static final zzcy<Long> zzbar = zzcy.zza(0, "gads:device_info_caching_expiry_ms:expiry", 300000L);
  public static final zzcy<Boolean> zzbas = zzcy.zza(0, "gads:gen204_signals:enabled", Boolean.valueOf(false));
  public static final zzcy<Boolean> zzbat = zzcy.zza(0, "gads:webview:error_reporting_enabled", Boolean.valueOf(false));
  public static final zzcy<Boolean> zzbau = zzcy.zza(0, "gads:adid_reporting:enabled", Boolean.valueOf(false));
  public static final zzcy<Boolean> zzbav = zzcy.zza(0, "gads:ad_settings_page_reporting:enabled", Boolean.valueOf(false));
  public static final zzcy<Boolean> zzbaw = zzcy.zza(0, "gads:adid_info_gmscore_upgrade_reporting:enabled", Boolean.valueOf(false));
  public static final zzcy<Boolean> zzbax = zzcy.zza(0, "gads:request_pkg:enabled", Boolean.valueOf(true));
  public static final zzcy<Boolean> zzbay = zzcy.zza(0, "gads:gmsg:disable_back_button:enabled", Boolean.valueOf(false));
  public static final zzcy<Boolean> zzbaz = zzcy.zza(0, "gads:gmsg:video_meta:enabled", Boolean.valueOf(true));
  public static final zzcy<String> zzbba = zzcy.zza(0, "gads:gmsg:video_meta:experiment_id");
  public static final zzcy<Long> zzbbb = zzcy.zza(0, "gads:network:cache_prediction_duration_s", 300L);
  public static final zzcy<Boolean> zzbbc = zzcy.zza(0, "gads:mediation:dynamite_first:admobadapter", Boolean.valueOf(true));
  public static final zzcy<Boolean> zzbbd = zzcy.zza(0, "gads:mediation:dynamite_first:adurladapter", Boolean.valueOf(true));
  public static final zzcy<Long> zzbbe = zzcy.zza(0, "gads:ad_loader:timeout_ms", 60000L);
  public static final zzcy<Long> zzbbf = zzcy.zza(0, "gads:rendering:timeout_ms", 60000L);
  public static final zzcy<Boolean> zzbbg = zzcy.zza(0, "gads:adshield:enable_adshield_instrumentation", Boolean.valueOf(false));
  public static final zzcy<Long> zzbbh = zzcy.zza(1, "gads:gestures:task_timeout", 2000L);
  public static final zzcy<String> zzbbi = zzcy.zza(1, "gads:gestures:encrypt_size_limit:experiment_id");
  public static final zzcy<Boolean> zzbbj = zzcy.zza(1, "gads:gestures:encrypt_size_limit:enabled", Boolean.valueOf(true));
  public static final zzcy<String> zzbbk = zzcy.zza(1, "gads:gestures:cpu:experiment_id");
  public static final zzcy<Boolean> zzbbl = zzcy.zza(1, "gads:gestures:cpu_query:enabled", Boolean.valueOf(false));
  public static final zzcy<Boolean> zzbbm = zzcy.zza(1, "gads:gestures:cpu_click:enabled", Boolean.valueOf(false));
  public static final zzcy<String> zzbbn = zzcy.zza(1, "gads:gestures:jbk:experiment_id");
  public static final zzcy<Boolean> zzbbo = zzcy.zza(1, "gads:gestures:jbk_query:enabled", Boolean.valueOf(false));
  public static final zzcy<Boolean> zzbbp = zzcy.zza(1, "gads:gestures:jbk_click:enabled", Boolean.valueOf(false));
  public static final zzcy<String> zzbbq = zzcy.zza(1, "gads:gestures:stk:experiment_id");
  public static final zzcy<Boolean> zzbbr = zzcy.zza(1, "gads:gestures:stk:enabled", Boolean.valueOf(false));
  public static final zzcy<Boolean> zzbbs = zzcy.zza(0, "gass:client:enabled", Boolean.valueOf(false));
  public static final zzcy<String> zzbbt = zzcy.zza(0, "gass:client:experiment_id");
  public static final zzcy<Boolean> zzbbu = zzcy.zza(0, "gass:enabled", Boolean.valueOf(false));
  public static final zzcy<Boolean> zzbbv = zzcy.zza(0, "gass:enable_int_signal", Boolean.valueOf(true));
  public static final zzcy<Boolean> zzbbw = zzcy.zza(0, "gads:adid_notification:first_party_check:enabled", Boolean.valueOf(true));
  public static final zzcy<Boolean> zzbbx = zzcy.zza(0, "gads:edu_device_helper:enabled", Boolean.valueOf(true));
  public static final zzcy<Boolean> zzbby = zzcy.zza(0, "gads:support_screen_shot", Boolean.valueOf(true));
  public static final zzcy<Boolean> zzbbz = zzcy.zza(0, "gads:use_get_drawing_cache_for_screenshot:enabled", Boolean.valueOf(true));
  public static final zzcy<String> zzbca = zzcy.zza(0, "gads:use_get_drawing_cache_for_screenshot:experiment_id");
  public static final zzcy<Long> zzbcb = zzcy.zza(0, "gads:js_flags:update_interval", TimeUnit.HOURS.toMillis(12L));
  public static final zzcy<Boolean> zzbcc = zzcy.zza(0, "gads:custom_render:ping_on_ad_rendered", Boolean.valueOf(false));
  public static final zzcy<Boolean> zzbcd = zzcy.zza(1, "gads:singleton_webview_native", Boolean.valueOf(false));
  public static final zzcy<String> zzbce = zzcy.zza(1, "gads:singleton_webview_native:experiment_id");
  public static final zzcy<Boolean> zzbcf = zzcy.zza(1, "gads:enable_untrack_view_native", Boolean.valueOf(true));
  public static final zzcy<Boolean> zzbcg = zzcy.zza(1, "gads:reset_listeners_preparead_native", Boolean.valueOf(true));
  public static final zzcy<Boolean> zzbch = zzcy.zza(0, "gads:method_tracing:enabled", Boolean.valueOf(false));
  public static final zzcy<Long> zzbci = zzcy.zza(0, "gads:method_tracing:duration_ms", 30000L);
  public static final zzcy<Integer> zzbcj = zzcy.zza(0, "gads:method_tracing:count", 5);
  public static final zzcy<Integer> zzbck = zzcy.zza(0, "gads:method_tracing:filesize", 134217728);
  public static final zzcy<Boolean> zzbcl = zzcy.zza(1, "gads:auto_location_for_coarse_permission", Boolean.valueOf(false));
  public static final zzcy<String> zzbcm = zzcy.zzb(1, "gads:auto_location_for_coarse_permission:experiment_id");
  public static final zzcy<Long> zzbcn = zzcy.zza(1, "gads:auto_location_timeout", 2000L);
  public static final zzcy<String> zzbco = zzcy.zzb(1, "gads:auto_location_timeout:experiment_id");
  public static final zzcy<Long> zzbcp = zzcy.zza(1, "gads:auto_location_interval", -1L);
  public static final zzcy<String> zzbcq = zzcy.zzb(1, "gads:auto_location_interval:experiment_id");
  public static final zzcy<Boolean> zzbcr = zzcy.zza(1, "gads:fetch_app_settings_using_cld:enabled", Boolean.valueOf(false));
  public static final zzcy<String> zzbcs = zzcy.zza(1, "gads:fetch_app_settings_using_cld:enabled:experiment_id");
  public static final zzcy<Long> zzbct = zzcy.zza(1, "gads:fetch_app_settings_using_cld:refresh_interval_ms", 7200000L);
  public static final zzcy<String> zzbcu = zzcy.zza(1, "gads:fetch_app_settings_using_cld:refresh_interval_ms:experiment_id");
  public static final zzcy<String> zzbcv = zzcy.zza(0, "gads:afs:csa:experiment_id");
  public static final zzcy<String> zzbcw = zzcy.zza(0, "gads:afs:csa_webview_gmsg_ad_failed", "gmsg://noAdLoaded");
  public static final zzcy<String> zzbcx = zzcy.zza(0, "gads:afs:csa_webview_gmsg_script_load_failed", "gmsg://scriptLoadFailed");
  public static final zzcy<String> zzbcy = zzcy.zza(0, "gads:afs:csa_webview_gmsg_ad_loaded", "gmsg://adResized");
  public static final zzcy<String> zzbcz = zzcy.zza(0, "gads:afs:csa_webview_static_file_path", "/afs/ads/i/webview.html");
  public static final zzcy<String> zzbda = zzcy.zza(0, "gads:afs:csa_webview_custom_domain_param_key", "csa_customDomain");
  public static final zzcy<Long> zzbdb = zzcy.zza(0, "gads:afs:csa_webview_adshield_timeout_ms", 1000L);
  public static final zzcy<Boolean> zzbdc = zzcy.zza(0, "gads:afs:csa_ad_manager_enabled", Boolean.valueOf(true));
  public static final zzcy<Boolean> zzbdd = zzcy.zza(0, "gads:safe_browsing:reporting:malicious:enabled", Boolean.valueOf(false));
  public static final zzcy<Boolean> zzbde = zzcy.zza(0, "gads:safe_browsing:reporting:full:enabled", Boolean.valueOf(false));
  public static final zzcy<Boolean> zzbdf = zzcy.zza(0, "gads:safe_browsing:screenshot:enabled", Boolean.valueOf(false));
  public static final zzcy<String> zzbdg = zzcy.zza(0, "gads:safe_browsing:reporting:url", "https://sb-ssl.google.com/safebrowsing/clientreport/malware");
  public static final zzcy<String> zzbdh = zzcy.zza(0, "gads:safe_browsing:api_key", "AIzaSyDRKQ9d6kfsoZT2lUnZcZnBYvH69HExNPE");
  public static final zzcy<Long> zzbdi = zzcy.zza(0, "gads:safe_browsing:safety_net:delay_ms", 2000L);
  public static final zzcy<String> zzbdj = zzcy.zza(0, "gads:safe_browsing:experiment_id");
  public static final zzcy<Boolean> zzbdk = zzcy.zza(0, "gads:safe_browsing:debug", Boolean.valueOf(false));
  public static final zzcy<Boolean> zzbdl = zzcy.zza(0, "gads:webview_cookie:enabled", Boolean.valueOf(true));
  
  public static void initialize(Context paramContext)
  {
    zzkx.zzb(new Callable()
    {
      public Void zzcy()
      {
        zzu.zzfz().initialize(zzdc.this);
        return null;
      }
    });
  }
  
  public static List<String> zzjx()
  {
    return zzu.zzfy().zzjx();
  }
  
  public static List<String> zzjy()
  {
    return zzu.zzfy().zzjy();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */