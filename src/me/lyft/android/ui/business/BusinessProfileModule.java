package me.lyft.android.ui.business;

import dagger.Module;
import me.lyft.android.ui.business.onboard.EditEmailController;
import me.lyft.android.ui.business.onboard.EmailConfirmationController;
import me.lyft.android.ui.business.onboard.EmailInputController;
import me.lyft.android.ui.business.onboard.NewUserDescriptionController;
import me.lyft.android.ui.business.onboard.OnboardCompletionController;
import me.lyft.android.ui.business.onboard.PaymentSelectionController;
import me.lyft.android.ui.business.profile.BusinessProfileEditEmailView;
import me.lyft.android.ui.business.profile.BusinessProfileView;

@Module(complete=false, injects={BusinessProfileView.class, BusinessProfileEditEmailView.class, NewUserDescriptionController.class, EmailInputController.class, EditEmailController.class, PaymentSelectionController.class, EmailConfirmationController.class, OnboardCompletionController.class})
public class BusinessProfileModule {}

/* Location:
 * Qualified Name:     me.lyft.android.ui.business.BusinessProfileModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */