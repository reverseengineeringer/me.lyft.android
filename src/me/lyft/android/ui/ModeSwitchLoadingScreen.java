package me.lyft.android.ui;

import com.lyft.scoop.Controller;
import com.lyft.scoop.EnterTransition;
import com.lyft.scoop.ExitTransition;
import com.lyft.scoop.Screen;
import com.lyft.scoop.transitions.FadeTransition;
import me.lyft.android.scoop.transition.LongFadeTransition;

@Controller(ModeSwitchLoadingController.class)
@EnterTransition(LongFadeTransition.class)
@ExitTransition(FadeTransition.class)
public class ModeSwitchLoadingScreen
  extends Screen
{}

/* Location:
 * Qualified Name:     me.lyft.android.ui.ModeSwitchLoadingScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */