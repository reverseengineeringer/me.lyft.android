package me.lyft.android.ui.dialogs;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.rx.MessageBus;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.ArrayList;
import javax.inject.Inject;
import me.lyft.android.adapters.DialogItemAdapter;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Strings;
import me.lyft.android.ui.Dialogs.AlertDialog;
import me.lyft.android.ui.Dialogs.AlertDialog.DialogButtonMeta;
import me.lyft.android.utils.MetricsUtils;
import me.lyft.android.utils.SoundManager;

public class AlertDialogView
  extends DialogContainerView
{
  public static final int DIALOG_IMAGE_WIDTH_DP = 88;
  @Inject
  MessageBus bus;
  View buttonsDivider;
  LinearLayout buttonsPlaceholder;
  @Inject
  DialogFlow dialogFlow;
  ImageView dialogIconImageView;
  TextView dialogTitleTxt;
  View listDivider;
  ListView listView;
  TextView messageTxt;
  private final MetricsUtils metricsUtils;
  Dialogs.AlertDialog params;
  @Inject
  SoundManager soundManager;
  
  public AlertDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    metricsUtils = MetricsUtils.fromView(this);
    params = ((Dialogs.AlertDialog)Screen.fromView(this));
  }
  
  protected void onCancel()
  {
    super.onCancel();
    onResult(-1, -1, true);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
    LayoutInflater localLayoutInflater = LayoutInflater.from(getContext());
    label79:
    Object localObject2;
    label298:
    int i;
    label300:
    Button localButton;
    if (params.getIcon() != null)
    {
      dialogIconImageView.setVisibility(0);
      dialogIconImageView.setImageResource(params.getIcon().intValue());
      if (Strings.isNullOrEmpty(params.getTitle())) {
        break label512;
      }
      dialogTitleTxt.setText(params.getTitle());
      if (params.getTitleColorResource() != null) {
        dialogTitleTxt.setTextColor(getResources().getColor(params.getTitleColorResource().intValue()));
      }
      if (params.getItems() != null)
      {
        listView.setVisibility(0);
        listView.setAdapter(new DialogItemAdapter(getContext(), params.getItems()));
        listView.setOnItemClickListener(new AlertDialogView.1(this));
        listDivider.setVisibility(0);
      }
      if (!Strings.isNullOrEmpty(params.getMessage()))
      {
        messageTxt.setVisibility(0);
        messageTxt.setText(Html.fromHtml(params.getMessage()));
        localObject2 = params.getMessageFontSize();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = Float.valueOf(getResources().getDimension(2131230743));
        }
        messageTxt.setTextSize(0, ((Float)localObject1).floatValue());
      }
      Object localObject1 = params.getButtons();
      buttonsPlaceholder.setOrientation(params.getButtonsOrientation());
      int j = ((ArrayList)localObject1).size();
      if (j <= 0) {
        break label524;
      }
      buttonsDivider.setVisibility(0);
      i = 0;
      if (i >= j) {
        break label586;
      }
      localObject2 = (Dialogs.AlertDialog.DialogButtonMeta)((ArrayList)localObject1).get(i);
      localButton = (Button)localLayoutInflater.inflate(((Dialogs.AlertDialog.DialogButtonMeta)localObject2).getLayoutId(), null);
      localButton.setId(((Dialogs.AlertDialog.DialogButtonMeta)localObject2).getId());
      localButton.setText(((Dialogs.AlertDialog.DialogButtonMeta)localObject2).getText());
      if (params.getButtonsOrientation() != 0) {
        break label536;
      }
      localButton.setLayoutParams(new LinearLayout.LayoutParams(0, metricsUtils.dpToPixels(56.0F), 1.0F));
      label385:
      localButton.setOnClickListener(new AlertDialogView.2(this, localButton));
      buttonsPlaceholder.addView(localButton);
      if (i != j - 1)
      {
        localObject2 = new View(getContext());
        ((View)localObject2).setBackgroundColor(getResources().getColor(2131493013));
        if (params.getButtonsOrientation() != 0) {
          break label562;
        }
        ((View)localObject2).setLayoutParams(new LinearLayout.LayoutParams(metricsUtils.dpToPixels(1.0F), metricsUtils.dpToPixels(56.0F)));
      }
    }
    for (;;)
    {
      buttonsPlaceholder.addView((View)localObject2);
      i += 1;
      break label300;
      dialogIconImageView.setVisibility(8);
      break;
      label512:
      dialogTitleTxt.setVisibility(8);
      break label79;
      label524:
      buttonsDivider.setVisibility(8);
      break label298;
      label536:
      localButton.setLayoutParams(new LinearLayout.LayoutParams(-1, metricsUtils.dpToPixels(56.0F)));
      break label385;
      label562:
      ((View)localObject2).setLayoutParams(new LinearLayout.LayoutParams(-1, metricsUtils.dpToPixels(1.0F)));
    }
    label586:
    if (params.getSound() != null) {
      soundManager.play(params.getSound().intValue());
    }
  }
  
  public void onResult(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Class localClass = params.getDialogEventClass();
    if (localClass != null)
    {
      DialogResult localDialogResult = new DialogResult();
      localDialogResult.setButtonId(paramInt1);
      localDialogResult.setSelectedIndex(paramInt2);
      localDialogResult.setCancelled(paramBoolean);
      bus.post(localClass, localDialogResult);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.dialogs.AlertDialogView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */