package com.mobileapptracker;

class MATDeferredDplinkr$1
  implements Runnable
{
  MATDeferredDplinkr$1(MATDeferredDplinkr paramMATDeferredDplinkr, MATUrlRequester paramMATUrlRequester) {}
  
  public void run()
  {
    if (((MATDeferredDplinkr.access$100(MATDeferredDplinkr.access$000()) == null) || (MATDeferredDplinkr.access$200(MATDeferredDplinkr.access$000()) == null) || (MATDeferredDplinkr.access$300(MATDeferredDplinkr.access$000()) == null)) && (MATDeferredDplinkr.access$400(this$0) != null)) {
      MATDeferredDplinkr.access$400(this$0).didFailDeeplink("Advertiser ID, conversion key, or package name not set");
    }
    if ((MATDeferredDplinkr.access$500(MATDeferredDplinkr.access$000()) == null) && (MATDeferredDplinkr.access$600(MATDeferredDplinkr.access$000()) == null) && (MATDeferredDplinkr.access$400(this$0) != null)) {
      MATDeferredDplinkr.access$400(this$0).didFailDeeplink("No device identifiers collected");
    }
    val$urlRequester.requestDeeplink(MATDeferredDplinkr.access$000());
  }
}

/* Location:
 * Qualified Name:     com.mobileapptracker.MATDeferredDplinkr.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */