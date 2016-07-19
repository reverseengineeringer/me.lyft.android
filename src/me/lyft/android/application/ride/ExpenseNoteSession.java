package me.lyft.android.application.ride;

import me.lyft.android.application.IUserProvider;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.User;
import me.lyft.android.persistence.expensenotes.IExpenseNoteStorage;

public class ExpenseNoteSession
  implements IExpenseNoteSession
{
  private boolean concurEnabled;
  private boolean concurFlagEditedByUser = false;
  private String expenseCode;
  private String expenseNote;
  private final IExpenseNoteStorage expenseNoteStorage;
  private String rideId;
  private final IUserProvider userProvider;
  
  public ExpenseNoteSession(IExpenseNoteStorage paramIExpenseNoteStorage, IUserProvider paramIUserProvider)
  {
    expenseNoteStorage = paramIExpenseNoteStorage;
    userProvider = paramIUserProvider;
    rideId = ((String)Objects.firstNonNull(paramIExpenseNoteStorage.getRideId(), ""));
    concurEnabled = paramIExpenseNoteStorage.isConcurEnabled();
    expenseNote = ((String)Objects.firstNonNull(paramIExpenseNoteStorage.getExpenseNote(), ""));
    expenseCode = ((String)Objects.firstNonNull(paramIExpenseNoteStorage.getExpenseCode(), ""));
  }
  
  public String getExpenseCode()
  {
    return expenseCode;
  }
  
  public String getExpenseNote()
  {
    return expenseNote;
  }
  
  public String getRideId()
  {
    return rideId;
  }
  
  public boolean isConcurEnabled()
  {
    if (wasConcurEdited()) {
      return concurEnabled;
    }
    return userProvider.getUser().sendConcurRideReceipts();
  }
  
  public boolean isConcurEnabledForNonBusinessProfileUser()
  {
    return (isConcurEnabled()) && (!userProvider.getUser().hasBusinessProfile());
  }
  
  public void reset()
  {
    rideId = "";
    concurEnabled = false;
    concurFlagEditedByUser = false;
    expenseNote = "";
    expenseCode = "";
    expenseNoteStorage.reset();
  }
  
  public void setConcurEnabled(boolean paramBoolean)
  {
    concurFlagEditedByUser = true;
    concurEnabled = paramBoolean;
    expenseNoteStorage.setConcurEnabled(paramBoolean);
  }
  
  public void setExpenseCode(String paramString)
  {
    paramString = Strings.nullToEmpty(paramString);
    expenseCode = paramString;
    expenseNoteStorage.setExpenseCode(paramString);
  }
  
  public void setExpenseNote(String paramString)
  {
    paramString = Strings.nullToEmpty(paramString);
    expenseNote = paramString;
    expenseNoteStorage.setExpenseNote(paramString);
  }
  
  public void setRideId(String paramString)
  {
    paramString = Strings.nullToEmpty(paramString);
    rideId = paramString;
    expenseNoteStorage.setRideId(paramString);
  }
  
  boolean wasConcurEdited()
  {
    return concurFlagEditedByUser;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.ExpenseNoteSession
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */