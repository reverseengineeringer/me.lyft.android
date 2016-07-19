package me.lyft.android.ui.camera;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.Size;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.FrameLayout;
import butterknife.ButterKnife;
import com.lyft.rx.MessageBus;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import com.lyft.widgets.FlashButton;
import com.lyft.widgets.PreviewFrameLayout;
import com.lyft.widgets.PreviewSurfaceView;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.R.styleable;
import me.lyft.android.common.ActivityController;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.controls.CameraToolbar;
import me.lyft.android.infrastructure.camera.ICaptureImageSession;
import me.lyft.android.infrastructure.device.IDevice;
import me.lyft.android.infrastructure.foreground.IAppForegroundDetector;
import me.lyft.android.logging.L;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.Dialogs.AlertDialog;
import me.lyft.android.ui.dialogs.DialogResult;
import me.lyft.android.utils.CameraExtensions;
import me.lyft.android.utils.ViewCompat;
import rx.Observable;
import rx.functions.Action1;

public class CaptureView
  extends FrameLayout
  implements SurfaceHolder.Callback
{
  public static final int ATTRIBUTE_CAMERA_BACK = 0;
  public static final int ATTRIBUTE_CAMERA_FRONT = 1;
  public static final int ATTRIBUTE_ORIENTATION_LANDSCAPE = 1;
  public static final int ATTRIBUTE_ORIENTATION_PORTRAIT = 0;
  private static final int CAMERA_NOT_FOUND = -1;
  public static final String FOCUS_MODE_CONTINUOUS_PICTURE = "continuous-picture";
  private static final int FOCUS_STATE_COMPLETE = 3;
  private static final int FOCUS_STATE_FOCUSING = 1;
  private static final int FOCUS_STATE_FOCUSING_SNAP_ON_FINISH = 2;
  private static final int FOCUS_STATE_IDLE = 0;
  public static final int ORIENTATION_HYSTERESIS = 5;
  public static final String TEMP_FILE_NAME = "camera_capture.jpg";
  @Inject
  ActivityController activityController;
  @Inject
  IAppForegroundDetector appForegroundDetector;
  private Camera.AutoFocusCallback autoFocusCallback = new CaptureView.9(this);
  private Binder binder;
  @Inject
  MessageBus bus;
  protected Camera camera;
  View captureButton;
  @Inject
  ICaptureImageSession captureImageSession;
  @Inject
  IDevice device;
  @Inject
  DialogFlow dialogFlow;
  private int displayRotation;
  FlashButton flashButton;
  View flashButtonFrame;
  protected String flashMode = "auto";
  private int focusState = 0;
  private Action1<DialogResult> onCameraLockedDialogResult = new CaptureView.6(this);
  private View.OnTouchListener onCaptureButtonTouched = new CaptureView.8(this);
  private final int orientation;
  private CaptureView.ScreenOrientationEventListener orientationListener;
  PreviewFrameLayout previewFrame;
  protected Camera.Size previewSize;
  protected SurfaceHolder previewSurfaceHolder;
  PreviewSurfaceView previewSurfaceView;
  protected boolean previewing;
  private int screenOrientation;
  protected int selectedCamera;
  View switchCameraButton;
  private Camera.PictureCallback takePictureCallback = new CaptureView.10(this);
  private boolean takePictureInProgress;
  CameraToolbar toolbar;
  
  public CaptureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CaptureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    DaggerInjector.fromView(this).inject(this);
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.CaptureView, paramInt, 0);
    int j = paramContext.getInt(0, 0);
    orientation = paramContext.getInt(1, 0);
    paramContext.recycle();
    paramInt = i;
    if (j == 1)
    {
      paramInt = i;
      if (hasFrontCamera()) {
        paramInt = 1;
      }
    }
    selectedCamera = paramInt;
    if (orientation == 0) {}
    for (paramInt = 2130903082;; paramInt = 2130903081)
    {
      Scoop.fromView(this).inflater(getContext()).inflate(paramInt, this, true);
      orientationListener = new CaptureView.ScreenOrientationEventListener(this, getContext());
      return;
    }
  }
  
  private void checkFlashButtonAvailability()
  {
    if ((selectedCamera == 1) || (!device.hasCameraFlash()))
    {
      flashButton.setEnabled(false);
      flashButtonFrame.setEnabled(false);
      return;
    }
    flashButton.setEnabled(true);
    flashButtonFrame.setEnabled(true);
  }
  
  private void disableKeepScreenOn()
  {
    activityController.getActivity().getWindow().clearFlags(6292608);
  }
  
  private void disableViewState()
  {
    stopPreview();
    previewSurfaceView.getHolder().removeCallback(this);
    disableKeepScreenOn();
    orientationListener.disable();
    releaseCamera();
  }
  
  private void enableKeepScreenOn()
  {
    activityController.getActivity().getWindow().addFlags(6292608);
  }
  
  private int getCameraInfoOrientation(int paramInt)
  {
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    Camera.getCameraInfo(paramInt, localCameraInfo);
    return orientation;
  }
  
  private int getDisplayOrientation(int paramInt1, int paramInt2)
  {
    paramInt2 = getCameraInfoOrientation(paramInt2);
    if (isFrontCamera()) {
      return (360 - (paramInt2 + paramInt1) % 360) % 360;
    }
    return (paramInt2 - paramInt1 + 360) % 360;
  }
  
  private Camera.Size getOptimalPreviewSize(List<Camera.Size> paramList, int paramInt1, int paramInt2)
  {
    double d2 = paramInt1 / paramInt2;
    Object localObject2;
    if (paramList == null) {
      localObject2 = null;
    }
    Object localObject1;
    do
    {
      return (Camera.Size)localObject2;
      localObject1 = null;
      d1 = Double.MAX_VALUE;
      localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (Camera.Size)localIterator.next();
        if ((Math.abs(width / height - d2) <= 0.1D) && (Math.abs(height - paramInt2) < d1))
        {
          localObject1 = localObject2;
          d1 = Math.abs(height - paramInt2);
        }
      }
      localObject2 = localObject1;
    } while (localObject1 != null);
    double d1 = Double.MAX_VALUE;
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      localObject2 = localObject1;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (Camera.Size)localIterator.next();
      if (Math.abs(height - paramInt2) < d1)
      {
        localObject1 = paramList;
        d1 = Math.abs(height - paramInt2);
      }
    }
  }
  
  private int getOutputPhotoRotation(int paramInt)
  {
    int i = getCameraInfoOrientation(selectedCamera);
    if (isFrontCamera()) {
      return (i - paramInt + 360) % 360;
    }
    return (i + paramInt) % 360;
  }
  
  private boolean hasAutoFocus()
  {
    return (!isFrontCamera()) && (getContext().getPackageManager().hasSystemFeature("android.hardware.camera.autofocus"));
  }
  
  private boolean hasFrontCamera()
  {
    return Camera.getNumberOfCameras() > 1;
  }
  
  private void initCameraIfNeeded()
  {
    if (camera == null) {}
    try
    {
      camera = openCamera();
      setFlashMode();
      setCameraPreviewSize();
      setFocusMode();
      setDisplayOrientation();
      updateOutputRotation();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      L.e(localRuntimeException, "Error initializing camera.", new Object[0]);
      if (localRuntimeException.getMessage().equalsIgnoreCase("Fail to connect to camera service"))
      {
        showCameraLockedError();
        return;
      }
      throw localRuntimeException;
    }
  }
  
  private boolean isFrontCamera()
  {
    return selectedCamera == 1;
  }
  
  private boolean isOrientationChanged(int paramInt1, int paramInt2)
  {
    if (paramInt2 == -1) {}
    do
    {
      return true;
      paramInt1 = Math.abs(paramInt1 - paramInt2);
    } while (Math.min(paramInt1, 360 - paramInt1) >= 50);
    return false;
  }
  
  private boolean isPortrait()
  {
    return orientation == 0;
  }
  
  private void onCaptureButtonClicked()
  {
    if (!takePictureInProgress)
    {
      if ((hasAutoFocus()) && (focusState != 3)) {
        break label27;
      }
      takePicture();
    }
    label27:
    do
    {
      return;
      if (focusState == 1)
      {
        focusState = 2;
        return;
      }
    } while (focusState != 0);
    safeAutoFocus();
    focusState = 2;
  }
  
  private void onPause()
  {
    disableViewState();
  }
  
  private void onResume()
  {
    takePictureInProgress = false;
    focusState = 0;
    orientationListener.enable();
    enableKeepScreenOn();
    previewSurfaceView.getHolder().addCallback(this);
    startPreview();
  }
  
  private Camera openCamera()
  {
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    int j = -1;
    int i = 0;
    while (i < Camera.getNumberOfCameras())
    {
      Camera.getCameraInfo(i, localCameraInfo);
      if (facing == selectedCamera) {
        j = i;
      }
      i += 1;
    }
    openCamera(j);
    return camera;
  }
  
  private void openCamera(int paramInt)
  {
    if (paramInt > -1)
    {
      camera = Camera.open(paramInt);
      return;
    }
    camera = Camera.open();
    selectedCamera = 0;
  }
  
  private Observable<File> processImage(byte[] paramArrayOfByte)
  {
    return Observable.create(new CaptureView.7(this, paramArrayOfByte));
  }
  
  private void releaseCamera()
  {
    if (camera != null)
    {
      camera.release();
      camera = null;
      previewing = false;
    }
  }
  
  private static int roundOrientation(int paramInt)
  {
    return (paramInt + 45) / 90 * 90 % 360;
  }
  
  private void safeAutoFocus()
  {
    try
    {
      camera.autoFocus(autoFocusCallback);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      takePicture();
      L.e(localRuntimeException, "safeAutoFocus exception caught", new Object[0]);
    }
  }
  
  private void setCameraPreviewSize()
  {
    Camera.Parameters localParameters = camera.getParameters();
    Camera.Size localSize = CameraExtensions.getBestPictureSize(localParameters);
    localParameters.setPictureSize(width, height);
    if (isPortrait()) {
      previewFrame.setAspectRatio(height / width);
    }
    for (;;)
    {
      previewSize = getOptimalPreviewSize(localParameters.getSupportedPreviewSizes(), width, height);
      localParameters.setPreviewSize(previewSize.width, previewSize.height);
      camera.setParameters(localParameters);
      return;
      previewFrame.setAspectRatio(width / height);
    }
  }
  
  private void setControlsEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {
      toolbar.enableHomeButton();
    }
    for (;;)
    {
      if (flashButton != null)
      {
        flashButton.setEnabled(paramBoolean);
        flashButtonFrame.setEnabled(paramBoolean);
      }
      if (switchCameraButton != null) {
        switchCameraButton.setEnabled(paramBoolean);
      }
      return;
      toolbar.disableHomeButton();
    }
  }
  
  private void setDisplayOrientation()
  {
    displayRotation = device.getDisplayRotation();
    int i = getDisplayOrientation(displayRotation, selectedCamera);
    if (camera != null) {
      camera.setDisplayOrientation(i);
    }
  }
  
  private void setFlashMode()
  {
    if ((!isFrontCamera()) && (device.hasCameraFlash()))
    {
      Camera.Parameters localParameters = camera.getParameters();
      localParameters.setFlashMode(flashMode);
      camera.setParameters(localParameters);
    }
  }
  
  private void setFlashModeButtonBackground(String paramString)
  {
    flashButton.setFlashMode(paramString);
  }
  
  private void setFocusMode()
  {
    Camera.Parameters localParameters = camera.getParameters();
    if ((localParameters.getSupportedFocusModes().contains("continuous-picture")) && (!device.isModel("GT-I9500"))) {
      localParameters.setFocusMode("continuous-picture");
    }
    for (;;)
    {
      camera.setParameters(localParameters);
      return;
      if (localParameters.getSupportedFocusModes().contains("auto")) {
        localParameters.setFocusMode("auto");
      }
    }
  }
  
  private void setOutputRotation(int paramInt)
  {
    if (camera != null)
    {
      Camera.Parameters localParameters = camera.getParameters();
      localParameters.setRotation(paramInt);
      camera.setParameters(localParameters);
    }
  }
  
  private void setPreviewDisplay(SurfaceHolder paramSurfaceHolder)
  {
    if (paramSurfaceHolder != null) {}
    try
    {
      camera.setPreviewDisplay(paramSurfaceHolder);
      return;
    }
    catch (Throwable paramSurfaceHolder)
    {
      releaseCamera();
      throw new RuntimeException("setPreviewDisplay failed", paramSurfaceHolder);
    }
  }
  
  private void showCameraLockedError()
  {
    Dialogs.AlertDialog localAlertDialog = new Dialogs.AlertDialog("camera_locked_dialog");
    localAlertDialog.setMessage(getResources().getString(2131165356)).addPositiveButton(getResources().getString(2131165939)).setDialogEventClass(CaptureView.CameraLockedErrorDialogResult.class);
    dialogFlow.show(localAlertDialog);
  }
  
  private void showPhotoCaptureFailedDialog()
  {
    Dialogs.AlertDialog localAlertDialog = new Dialogs.AlertDialog("image_capture_failed").setTitle(getContext().getString(2131165439)).setTitleColorResource(2131493111).setMessage(getContext().getString(2131165440)).addPositiveButton(getContext().getString(2131165939));
    dialogFlow.show(localAlertDialog);
  }
  
  private void stopPreview()
  {
    if ((camera != null) && (previewing))
    {
      L.d("stopPreview", new Object[0]);
      camera.stopPreview();
    }
    previewing = false;
    focusState = 0;
  }
  
  private void switchCamera()
  {
    stopPreview();
    releaseCamera();
    if (selectedCamera == 0) {}
    for (selectedCamera = 1;; selectedCamera = 0)
    {
      checkFlashButtonAvailability();
      startPreview();
      return;
    }
  }
  
  private void switchFlashMode()
  {
    if (flashMode.equals("auto")) {
      flashMode = "off";
    }
    for (;;)
    {
      Camera.Parameters localParameters = camera.getParameters();
      localParameters.setFlashMode(flashMode);
      setFlashModeButtonBackground(flashMode);
      camera.setParameters(localParameters);
      return;
      if (flashMode.equals("off")) {
        flashMode = "on";
      } else {
        flashMode = "auto";
      }
    }
  }
  
  private void takePicture()
  {
    if (!takePictureInProgress)
    {
      takePictureInProgress = true;
      setControlsEnabled(false);
      camera.takePicture(null, null, takePictureCallback);
    }
  }
  
  private void updateOutputRotation()
  {
    screenOrientation = device.getDisplayRotation();
    setOutputRotation(getOutputPhotoRotation(screenOrientation));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder = Binder.attach(this);
    binder.bind(appForegroundDetector.observeAppForegrounded(), new CaptureView.5(this));
    binder.bind(bus.observe(CaptureView.CameraLockedErrorDialogResult.class), onCameraLockedDialogResult);
    if (orientation == 1) {
      activityController.setLandscapeOrientation();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    activityController.restoreDefaultOrientation();
    disableViewState();
    super.onDetachedFromWindow();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
    ViewCompat.setSystemUiVisibility(this, 1);
    setFlashModeButtonBackground(flashMode);
    checkFlashButtonAvailability();
    flashButtonFrame.setOnClickListener(new CaptureView.1(this));
    flashButton.setOnClickListener(new CaptureView.2(this));
    captureButton.setOnTouchListener(onCaptureButtonTouched);
    captureButton.setOnClickListener(new CaptureView.3(this));
    if (!hasFrontCamera()) {
      switchCameraButton.setVisibility(8);
    }
    for (;;)
    {
      toolbar.setTitle(getResources().getString(2131165363));
      return;
      switchCameraButton.setOnClickListener(new CaptureView.4(this));
    }
  }
  
  public void setSwitchCameraButtonVisibility(int paramInt)
  {
    if (!hasFrontCamera())
    {
      switchCameraButton.setVisibility(8);
      return;
    }
    switchCameraButton.setVisibility(paramInt);
  }
  
  public void startPreview()
  {
    initCameraIfNeeded();
    if (camera == null) {
      return;
    }
    if (previewing) {
      stopPreview();
    }
    setPreviewDisplay(previewSurfaceHolder);
    try
    {
      L.d("startPreview", new Object[0]);
      camera.startPreview();
      previewing = true;
      focusState = 0;
      return;
    }
    catch (Throwable localThrowable)
    {
      releaseCamera();
      throw new RuntimeException("startPreview failed", localThrowable);
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    previewSurfaceHolder = paramSurfaceHolder;
    if (camera == null) {
      return;
    }
    if ((previewing) && (paramSurfaceHolder.isCreating()))
    {
      setPreviewDisplay(paramSurfaceHolder);
      return;
    }
    startPreview();
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder) {}
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (camera != null) {
      camera.stopPreview();
    }
    previewSurfaceHolder = null;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.camera.CaptureView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */