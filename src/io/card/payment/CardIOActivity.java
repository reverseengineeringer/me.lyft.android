package io.card.payment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import io.card.payment.i18n.LocalizedStrings;
import io.card.payment.i18n.StringKey;
import io.card.payment.ui.ActivityHelper;
import io.card.payment.ui.ViewUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.util.Date;

public final class CardIOActivity
  extends Activity
{
  public static final String EXTRA_CAPTURED_CARD_IMAGE = "io.card.payment.capturedCardImage";
  public static final String EXTRA_GUIDE_COLOR = "io.card.payment.guideColor";
  public static final String EXTRA_HIDE_CARDIO_LOGO = "io.card.payment.hideLogo";
  public static final String EXTRA_KEEP_APPLICATION_THEME = "io.card.payment.keepApplicationTheme";
  public static final String EXTRA_LANGUAGE_OR_LOCALE = "io.card.payment.languageOrLocale";
  public static final String EXTRA_NO_CAMERA = "io.card.payment.noCamera";
  public static final String EXTRA_REQUIRE_CVV = "io.card.payment.requireCVV";
  public static final String EXTRA_REQUIRE_EXPIRY = "io.card.payment.requireExpiry";
  public static final String EXTRA_REQUIRE_POSTAL_CODE = "io.card.payment.requirePostalCode";
  public static final String EXTRA_RETURN_CARD_IMAGE = "io.card.payment.returnCardImage";
  public static final String EXTRA_SCAN_EXPIRY = "io.card.payment.scanExpiry";
  public static final String EXTRA_SCAN_INSTRUCTIONS = "io.card.payment.scanInstructions";
  public static final String EXTRA_SCAN_OVERLAY_LAYOUT_ID = "io.card.payment.scanOverlayLayoutId";
  public static final String EXTRA_SCAN_RESULT = "io.card.payment.scanResult";
  public static final String EXTRA_SUPPRESS_CONFIRMATION = "io.card.payment.suppressConfirmation";
  public static final String EXTRA_SUPPRESS_MANUAL_ENTRY = "io.card.payment.suppressManual";
  public static final String EXTRA_SUPPRESS_SCAN = "io.card.payment.suppressScan";
  public static final String EXTRA_USE_CARDIO_LOGO = "io.card.payment.useCardIOLogo";
  public static final String EXTRA_USE_PAYPAL_ACTIONBAR_ICON = "io.card.payment.intentSenderIsPayPal";
  private static final int REQUEST_DATA_ENTRY;
  public static final int RESULT_CARD_INFO;
  public static final int RESULT_CONFIRMATION_SUPPRESSED;
  public static final int RESULT_ENTRY_CANCELED;
  public static final int RESULT_SCAN_NOT_AVAILABLE;
  public static final int RESULT_SCAN_SUPPRESSED;
  private static final String TAG;
  private static final long[] VIBRATE_PATTERN;
  private static int lastResult;
  static Bitmap markedCardImage;
  private static int numActivityAllocations;
  private static int uniqueOMatic;
  private LinearLayout customOverlayLayout;
  private CardScanner mCardScanner;
  private boolean mDetectOnly = false;
  private CreditCard mDetectedCard;
  private int mFrameOrientation;
  private Rect mGuideFrame;
  private int mLastDegrees;
  private FrameLayout mMainLayout;
  private OverlayView mOverlay;
  Preview mPreview;
  private RelativeLayout mUIBar;
  private boolean manualEntryFallbackOrForced = false;
  private OrientationEventListener orientationListener;
  private boolean suppressManualEntry = false;
  private boolean useApplicationTheme;
  
  static
  {
    if (!CardIOActivity.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      lastResult = 13274384;
      int i = lastResult;
      lastResult = i + 1;
      RESULT_CARD_INFO = i;
      i = lastResult;
      lastResult = i + 1;
      RESULT_ENTRY_CANCELED = i;
      i = lastResult;
      lastResult = i + 1;
      RESULT_SCAN_NOT_AVAILABLE = i;
      i = lastResult;
      lastResult = i + 1;
      RESULT_SCAN_SUPPRESSED = i;
      i = lastResult;
      lastResult = i + 1;
      RESULT_CONFIRMATION_SUPPRESSED = i;
      TAG = CardIOActivity.class.getSimpleName();
      VIBRATE_PATTERN = new long[] { 0L, 70L, 10L, 40L };
      uniqueOMatic = 10;
      i = uniqueOMatic;
      uniqueOMatic = i + 1;
      REQUEST_DATA_ENTRY = i;
      numActivityAllocations = 0;
      markedCardImage = null;
      return;
    }
  }
  
  public static boolean canReadCardWithCamera()
  {
    try
    {
      boolean bool = Util.hardwareSupported();
      return bool;
    }
    catch (CameraUnavailableException localCameraUnavailableException)
    {
      return false;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.w(TAG, "RuntimeException accessing Util.hardwareSupported()");
    }
    return false;
  }
  
  private void doOrientationChange(int paramInt)
  {
    if ((paramInt < 0) || (mCardScanner == null)) {}
    for (;;)
    {
      return;
      paramInt += getRotationalOffset();
      int i = paramInt;
      if (paramInt > 360) {
        i = paramInt - 360;
      }
      int j = -1;
      if ((i < 15) || (i > 345))
      {
        paramInt = 0;
        mFrameOrientation = 1;
      }
      while ((paramInt >= 0) && (paramInt != mLastDegrees))
      {
        Log.d(TAG, "onOrientationChanged(" + paramInt + ") calling setDeviceOrientation(" + mFrameOrientation + ")");
        mCardScanner.setDeviceOrientation(mFrameOrientation);
        setDeviceDegrees(paramInt);
        if (paramInt != 90) {
          break label219;
        }
        rotateCustomOverlay(270.0F);
        return;
        if ((i > 75) && (i < 105))
        {
          paramInt = 90;
          mFrameOrientation = 4;
        }
        else if ((i > 165) && (i < 195))
        {
          paramInt = 180;
          mFrameOrientation = 2;
        }
        else
        {
          paramInt = j;
          if (i > 255)
          {
            paramInt = j;
            if (i < 285)
            {
              paramInt = 270;
              mFrameOrientation = 3;
            }
          }
        }
      }
    }
    label219:
    if (paramInt == 270)
    {
      rotateCustomOverlay(90.0F);
      return;
    }
    rotateCustomOverlay(paramInt);
  }
  
  public static Bitmap getCapturedCardImage(Intent paramIntent)
  {
    if ((paramIntent == null) || (!paramIntent.hasExtra("io.card.payment.capturedCardImage"))) {
      return null;
    }
    return BitmapFactory.decodeStream(new ByteArrayInputStream(paramIntent.getByteArrayExtra("io.card.payment.capturedCardImage")), null, new BitmapFactory.Options());
  }
  
  private int getRotationalOffset()
  {
    int i = ((WindowManager)getSystemService("window")).getDefaultDisplay().getRotation();
    if (i == 0) {
      return 0;
    }
    if (i == 1) {
      return 90;
    }
    if (i == 2) {
      return 180;
    }
    if (i == 3) {
      return 270;
    }
    return 0;
  }
  
  private void handleGeneralExceptionError(Exception paramException)
  {
    String str = LocalizedStrings.getString(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL);
    Log.e("card.io", "Unkown exception - please send the stack trace to support@card.io", paramException);
    paramException = Toast.makeText(this, str, 1);
    paramException.setGravity(17, 0, -75);
    paramException.show();
    manualEntryFallbackOrForced = true;
  }
  
  private void nextActivity()
  {
    Log.d(TAG, "CardIOActivity.nextActivity()");
    Object localObject = getIntent();
    if ((localObject != null) && (((Intent)localObject).getBooleanExtra("io.card.payment.suppressConfirmation", false)))
    {
      Intent localIntent = new Intent(this, DataEntryActivity.class);
      localIntent.putExtra("io.card.payment.scanResult", mDetectedCard);
      mDetectedCard = null;
      if ((((Intent)localObject).getBooleanExtra("io.card.payment.returnCardImage", false)) && (mOverlay != null) && (mOverlay.getBitmap() != null))
      {
        localObject = new ByteArrayOutputStream();
        mOverlay.getBitmap().compress(Bitmap.CompressFormat.JPEG, 80, (OutputStream)localObject);
        localIntent.putExtra("io.card.payment.capturedCardImage", ((ByteArrayOutputStream)localObject).toByteArray());
      }
      setResultAndFinish(RESULT_CONFIRMATION_SUPPRESSED, localIntent);
      return;
    }
    new Handler().post(new Runnable()
    {
      public void run()
      {
        Log.d(CardIOActivity.TAG, "CardIOActivity.nextActivity().post(Runnable)");
        getWindow().clearFlags(1024);
        getWindow().addFlags(512);
        Intent localIntent = new Intent(CardIOActivity.this, DataEntryActivity.class);
        if (mOverlay != null)
        {
          mOverlay.markupCard();
          if ((CardIOActivity.markedCardImage != null) && (!CardIOActivity.markedCardImage.isRecycled())) {
            CardIOActivity.markedCardImage.recycle();
          }
          CardIOActivity.markedCardImage = mOverlay.getCardImage();
        }
        if (mDetectedCard != null)
        {
          localIntent.putExtra("io.card.payment.scanResult", mDetectedCard);
          CardIOActivity.access$302(CardIOActivity.this, null);
        }
        for (;;)
        {
          localIntent.putExtras(getIntent());
          localIntent.addFlags(1082195968);
          startActivityForResult(localIntent, CardIOActivity.REQUEST_DATA_ENTRY);
          return;
          localIntent.putExtra("io.card.payment.manualEntryScanResult", true);
        }
      }
    });
  }
  
  private boolean restartPreview()
  {
    Log.d(TAG, "restartPreview()");
    mDetectedCard = null;
    assert (mPreview != null);
    boolean bool = mCardScanner.resumeScanning(mPreview.getSurfaceHolder());
    if (bool) {
      mUIBar.setVisibility(0);
    }
    return bool;
  }
  
  private void rotateCustomOverlay(float paramFloat)
  {
    if (customOverlayLayout != null)
    {
      RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, paramFloat, customOverlayLayout.getWidth() / 2, customOverlayLayout.getHeight() / 2);
      localRotateAnimation.setDuration(0L);
      localRotateAnimation.setRepeatCount(0);
      localRotateAnimation.setFillAfter(true);
      customOverlayLayout.setAnimation(localRotateAnimation);
    }
  }
  
  public static Date sdkBuildDate()
  {
    return new Date("06/04/2015 17:39:33 -0500");
  }
  
  public static String sdkVersion()
  {
    return "5.0.1";
  }
  
  private void setDeviceDegrees(int paramInt)
  {
    SurfaceView localSurfaceView = mPreview.getSurfaceView();
    if (localSurfaceView == null)
    {
      Log.wtf("card.io", "surface view is null.. recovering... rotation might be weird.");
      return;
    }
    mGuideFrame = mCardScanner.getGuideFrame(localSurfaceView.getWidth(), localSurfaceView.getHeight());
    Rect localRect = mGuideFrame;
    top += localSurfaceView.getTop();
    localRect = mGuideFrame;
    bottom += localSurfaceView.getTop();
    mOverlay.setGuideAndRotation(mGuideFrame, paramInt);
    mLastDegrees = paramInt;
  }
  
  private void setPreviewLayout()
  {
    mMainLayout = new FrameLayout(this);
    mMainLayout.setBackgroundColor(-16777216);
    mMainLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    Object localObject1 = new FrameLayout(this);
    ((FrameLayout)localObject1).setId(1);
    mCardScanner.getClass();
    mCardScanner.getClass();
    mPreview = new Preview(this, null, 640, 480);
    mPreview.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 48));
    ((FrameLayout)localObject1).addView(mPreview);
    mOverlay = new OverlayView(this, null, Util.deviceSupportsTorch(this));
    mOverlay.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    boolean bool;
    int i;
    if (getIntent() != null)
    {
      bool = getIntent().getBooleanExtra("io.card.payment.useCardIOLogo", false);
      mOverlay.setUseCardIOLogo(bool);
      i = getIntent().getIntExtra("io.card.payment.guideColor", 0);
      if (i == 0) {
        break label694;
      }
      int j = i | 0xFF000000;
      if (i != j) {
        Log.w("card.io", "Removing transparency from provided guide color.");
      }
      mOverlay.setGuideColor(j);
    }
    for (;;)
    {
      bool = getIntent().getBooleanExtra("io.card.payment.hideLogo", false);
      mOverlay.setHideCardIOLogo(bool);
      Object localObject2 = getIntent().getStringExtra("io.card.payment.scanInstructions");
      if (localObject2 != null) {
        mOverlay.setScanInstructions((String)localObject2);
      }
      ((FrameLayout)localObject1).addView(mOverlay);
      localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject2).addRule(10);
      ((RelativeLayout.LayoutParams)localObject2).addRule(2, 2);
      mMainLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      mUIBar = new RelativeLayout(this);
      mUIBar.setGravity(80);
      localObject1 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      mUIBar.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      mUIBar.setId(2);
      mUIBar.setGravity(85);
      if (!suppressManualEntry)
      {
        localObject1 = new Button(this);
        ((Button)localObject1).setId(3);
        ((Button)localObject1).setText(LocalizedStrings.getString(StringKey.KEYBOARD));
        ((Button)localObject1).setTextSize(12.0F);
        ((Button)localObject1).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            CardIOActivity.this.nextActivity();
          }
        });
        mUIBar.addView((View)localObject1);
        ViewUtil.styleAsButton((View)localObject1, false, this);
        ((Button)localObject1).setTextSize(14.0F);
        ((Button)localObject1).setMinimumHeight(ViewUtil.typedDimensionValueToPixelsInt("42dip", this));
        localObject2 = (RelativeLayout.LayoutParams)((Button)localObject1).getLayoutParams();
        width = -2;
        height = -2;
        ((RelativeLayout.LayoutParams)localObject2).addRule(12);
        ViewUtil.setPadding((View)localObject1, "16dip", null, "16dip", null);
        ViewUtil.setMargins((View)localObject1, "4dip", "4dip", "4dip", "4dip");
      }
      localObject1 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(12);
      i = (int)(15.0F * getResourcesgetDisplayMetricsdensity + 0.5F);
      ((RelativeLayout.LayoutParams)localObject1).setMargins(0, i, 0, i);
      mMainLayout.addView(mUIBar, (ViewGroup.LayoutParams)localObject1);
      if (getIntent() != null)
      {
        if (customOverlayLayout != null)
        {
          mMainLayout.removeView(customOverlayLayout);
          customOverlayLayout = null;
        }
        i = getIntent().getIntExtra("io.card.payment.scanOverlayLayoutId", -1);
        if (i != -1)
        {
          customOverlayLayout = new LinearLayout(this);
          customOverlayLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
          getLayoutInflater().inflate(i, customOverlayLayout);
          mMainLayout.addView(customOverlayLayout);
        }
      }
      setContentView(mMainLayout);
      return;
      label694:
      mOverlay.setGuideColor(-16711936);
    }
  }
  
  private void setResultAndFinish(int paramInt, Intent paramIntent)
  {
    setResult(paramInt, paramIntent);
    markedCardImage = null;
    finish();
  }
  
  private void showErrorMessage(String paramString)
  {
    Log.e("card.io", "error display: " + paramString);
    Toast.makeText(this, paramString, 1).show();
  }
  
  public Rect getTorchRect()
  {
    if (mOverlay == null) {
      return null;
    }
    return mOverlay.getTorchRect();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.d(TAG, String.format("onActivityResult(requestCode:%d, resultCode:%d, ...", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    if ((paramInt2 == RESULT_CARD_INFO) || (paramInt2 == RESULT_ENTRY_CANCELED) || (manualEntryFallbackOrForced))
    {
      if ((paramIntent != null) && (paramIntent.hasExtra("io.card.payment.scanResult"))) {
        Log.v(TAG, "data entry result: " + paramIntent.getParcelableExtra("io.card.payment.scanResult"));
      }
      setResultAndFinish(paramInt2, paramIntent);
    }
    while (mUIBar == null) {
      return;
    }
    mUIBar.setVisibility(0);
  }
  
  public void onBackPressed()
  {
    Log.d(TAG, "CardIOActivity.onBackPressed()");
    if ((!manualEntryFallbackOrForced) && (mOverlay.isAnimating())) {}
    while (mCardScanner == null) {
      try
      {
        restartPreview();
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        Log.w(TAG, "*** could not return to preview: " + localRuntimeException);
        return;
      }
    }
    super.onBackPressed();
  }
  
  void onCardDetected(Bitmap paramBitmap, DetectionInfo paramDetectionInfo)
  {
    Log.d(TAG, "processDetections");
    try
    {
      ((Vibrator)getSystemService("vibrator")).vibrate(VIBRATE_PATTERN, -1);
      mCardScanner.pauseScanning();
      mUIBar.setVisibility(4);
      if (paramDetectionInfo.predicted())
      {
        mDetectedCard = paramDetectionInfo.creditCard();
        mOverlay.setDetectedCard(mDetectedCard);
      }
      if ((mFrameOrientation == 1) || (mFrameOrientation == 2))
      {
        f = mGuideFrame.right / 428.0F * 0.95F;
        paramDetectionInfo = new Matrix();
        Log.d(TAG, "Scale factor: " + f);
        paramDetectionInfo.postScale(f, f);
        paramDetectionInfo = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramDetectionInfo, false);
        mOverlay.setBitmap(paramDetectionInfo);
        if (!mDetectOnly) {
          break label294;
        }
        paramBitmap = new ByteArrayOutputStream();
        paramDetectionInfo.compress(Bitmap.CompressFormat.JPEG, 80, paramBitmap);
        paramDetectionInfo = new Intent();
        if ((getIntent() != null) && (getIntent().getBooleanExtra("io.card.payment.returnCardImage", false))) {
          paramDetectionInfo.putExtra("io.card.payment.capturedCardImage", paramBitmap.toByteArray());
        }
        setResultAndFinish(RESULT_SCAN_SUPPRESSED, paramDetectionInfo);
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        Log.e("card.io", "Could not activate vibration feedback. Please add <uses-permission android:name=\"android.permission.VIBRATE\" /> to your application's manifest.");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("card.io", "Exception while attempting to vibrate: ", localException);
        continue;
        float f = mGuideFrame.right / 428.0F * 1.15F;
      }
      label294:
      nextActivity();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Log.i(TAG, "onCreate() ================================================================");
    numActivityAllocations += 1;
    if (numActivityAllocations != 1) {
      Log.i(TAG, String.format("INTERNAL WARNING: There are %d (not 1) CardIOActivity allocations!", new Object[] { Integer.valueOf(numActivityAllocations) }));
    }
    paramBundle = getIntent();
    useApplicationTheme = paramBundle.getBooleanExtra("io.card.payment.keepApplicationTheme", false);
    LocalizedStrings.setLanguage(paramBundle);
    mDetectOnly = paramBundle.getBooleanExtra("io.card.payment.suppressScan", false);
    Object localObject1 = Util.manifestHasConfigChange(getPackageManager().resolveActivity(paramBundle, 65536), CardIOActivity.class);
    if (localObject1 != null) {
      throw new RuntimeException((String)localObject1);
    }
    suppressManualEntry = paramBundle.getBooleanExtra("io.card.payment.suppressManual", false);
    if (paramBundle.getBooleanExtra("io.card.payment.noCamera", false))
    {
      Log.i("card.io", "EXTRA_NO_CAMERA set to true. Skipping camera.");
      manualEntryFallbackOrForced = true;
    }
    for (;;)
    {
      if (!manualEntryFallbackOrForced) {
        try
        {
          requestWindowFeature(1);
          mGuideFrame = new Rect();
          mFrameOrientation = 1;
          if (!paramBundle.getBooleanExtra("io.card.payment.cameraBypassTestMode", false)) {
            break label500;
          }
          if (getPackageName().contentEquals("io.card.development")) {
            break;
          }
          Log.e(TAG, getPackageName() + " is not correct");
          throw new IllegalStateException("illegal access of private extra");
        }
        catch (Exception paramBundle)
        {
          handleGeneralExceptionError(paramBundle);
        }
      }
      if ((manualEntryFallbackOrForced) && (suppressManualEntry))
      {
        Log.i("card.io", "Camera not available and manual entry suppressed.");
        setResultAndFinish(RESULT_SCAN_NOT_AVAILABLE, null);
      }
      return;
      try
      {
        if (!Util.hardwareSupported())
        {
          localObject1 = StringKey.ERROR_NO_DEVICE_SUPPORT;
          str = LocalizedStrings.getString((StringKey)localObject1);
          Log.w("card.io", localObject1 + ": " + str);
          manualEntryFallbackOrForced = true;
        }
      }
      catch (CameraUnavailableException localCameraUnavailableException)
      {
        Object localObject2 = StringKey.ERROR_CAMERA_CONNECT_FAIL;
        String str = LocalizedStrings.getString((StringKey)localObject2);
        Log.e("card.io", localObject2 + ": " + str);
        localObject2 = Toast.makeText(this, str, 1);
        ((Toast)localObject2).setGravity(17, 0, -75);
        ((Toast)localObject2).show();
        manualEntryFallbackOrForced = true;
      }
      catch (Exception localException)
      {
        handleGeneralExceptionError(localException);
      }
    }
    label500:
    for (mCardScanner = ((CardScanner)Class.forName("io.card.payment.CardScannerTester").getConstructor(new Class[] { getClass(), Integer.TYPE }).newInstance(new Object[] { this, Integer.valueOf(mFrameOrientation) }));; mCardScanner = new CardScanner(this, mFrameOrientation))
    {
      mCardScanner.prepareScanner();
      setPreviewLayout();
      orientationListener = new OrientationEventListener(this, 2)
      {
        public void onOrientationChanged(int paramAnonymousInt)
        {
          CardIOActivity.this.doOrientationChange(paramAnonymousInt);
        }
      };
      break;
    }
  }
  
  protected void onDestroy()
  {
    Log.d(TAG, "onDestroy()");
    mOverlay = null;
    numActivityAllocations -= 1;
    if (mCardScanner != null)
    {
      mCardScanner.endScanning();
      mCardScanner = null;
    }
    super.onDestroy();
  }
  
  void onEdgeUpdate(DetectionInfo paramDetectionInfo)
  {
    mOverlay.setDetectionInfo(paramDetectionInfo);
  }
  
  void onFirstFrame(int paramInt)
  {
    Log.d(TAG, "mFirstPreviewFrame");
    SurfaceView localSurfaceView = mPreview.getSurfaceView();
    if (mOverlay != null) {
      mOverlay.setCameraPreviewRect(new Rect(localSurfaceView.getLeft(), localSurfaceView.getTop(), localSurfaceView.getRight(), localSurfaceView.getBottom()));
    }
    mFrameOrientation = 1;
    setDeviceDegrees(0);
    if (paramInt != mFrameOrientation) {
      Log.wtf("card.io", "the orientation of the scanner doesn't match the orientation of the activity");
    }
    onEdgeUpdate(new DetectionInfo());
  }
  
  protected void onPause()
  {
    super.onPause();
    Log.i(TAG, "onPause() xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    if (orientationListener != null) {
      orientationListener.disable();
    }
    setFlashOn(false);
    if (mCardScanner != null) {
      mCardScanner.pauseScanning();
    }
    while (manualEntryFallbackOrForced) {
      return;
    }
    Log.wtf("card.io", "cardScanner is null in onPause()");
  }
  
  protected void onResume()
  {
    super.onResume();
    Log.i(TAG, "onResume() ----------------------------------------------------------");
    if (manualEntryFallbackOrForced)
    {
      nextActivity();
      return;
    }
    Util.logNativeMemoryStats();
    getWindow().addFlags(1024);
    getWindow().addFlags(128);
    ActivityHelper.setFlagSecure(this);
    setRequestedOrientation(1);
    orientationListener.enable();
    if (!restartPreview())
    {
      Log.e(TAG, "Could not connect to camera.");
      showErrorMessage(LocalizedStrings.getString(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL));
      nextActivity();
    }
    for (;;)
    {
      doOrientationChange(mLastDegrees);
      return;
      setFlashOn(false);
    }
  }
  
  void setFlashOn(boolean paramBoolean)
  {
    if ((mPreview != null) && (mOverlay != null) && (mCardScanner.setFlashOn(paramBoolean))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        mOverlay.setTorchOn(paramBoolean);
      }
      return;
    }
  }
  
  void toggleFlash()
  {
    if (!mCardScanner.isFlashOn()) {}
    for (boolean bool = true;; bool = false)
    {
      setFlashOn(bool);
      return;
    }
  }
  
  void triggerAutoFocus()
  {
    mCardScanner.triggerAutoFocus(true);
  }
}

/* Location:
 * Qualified Name:     io.card.payment.CardIOActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */