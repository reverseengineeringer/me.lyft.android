package me.lyft.android.domain.payment;

import com.lyft.android.api.dto.ChargeAccountDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.common.Objects;

public class ChargeAccountMapper
{
  public static final String METHOD_CARD = "card";
  public static final String METHOD_CREDITLINE = "creditLine";
  public static final String METHOD_FACEBOOK = "facebook";
  public static final String METHOD_GOOGLE_WALLET = "googleWallet";
  public static final String METHOD_PAYPAL = "paypal";
  
  public static List<ChargeAccount> fromChargeAccountDTO(List<ChargeAccountDTO> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      paramList = Collections.emptyList();
      return paramList;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      paramList = localArrayList;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = fromChargeAccountDTO((ChargeAccountDTO)localIterator.next());
      if (!paramList.isNull()) {
        localArrayList.add(paramList);
      }
    }
  }
  
  public static ChargeAccount fromChargeAccountDTO(ChargeAccountDTO paramChargeAccountDTO)
  {
    Object localObject = (String)Objects.firstNonNull(clientPaymentMethod, "");
    int i = -1;
    switch (((String)localObject).hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return NullChargeAccount.getInstance();
        if (((String)localObject).equals("card"))
        {
          i = 0;
          continue;
          if (((String)localObject).equals("googleWallet"))
          {
            i = 1;
            continue;
            if (((String)localObject).equals("paypal"))
            {
              i = 2;
              continue;
              if (((String)localObject).equals("creditLine"))
              {
                i = 3;
                continue;
                if (((String)localObject).equals("facebook")) {
                  i = 4;
                }
              }
            }
          }
        }
        break;
      }
    }
    localObject = new CreditCardChargeAccount();
    ((CreditCardChargeAccount)localObject).setLastFour(lastFour);
    ((CreditCardChargeAccount)localObject).setType(type);
    for (;;)
    {
      ((ChargeAccount)localObject).setId(id);
      ((ChargeAccount)localObject).setDefault((Boolean)Objects.firstNonNull(_default, Boolean.FALSE));
      ((ChargeAccount)localObject).setIsDefaultBusiness((Boolean)Objects.firstNonNull(defaultBusiness, Boolean.FALSE));
      ((ChargeAccount)localObject).setFailed((Boolean)Objects.firstNonNull(failed, Boolean.FALSE));
      ((ChargeAccount)localObject).setLabel(label);
      ((ChargeAccount)localObject).setLabelType(labelType);
      return (ChargeAccount)localObject;
      localObject = new WalletChargeAccount();
      ((WalletChargeAccount)localObject).setLastFour(lastFour);
      ((WalletChargeAccount)localObject).setType(type);
      continue;
      localObject = new PayPalChargeAccount();
      ((PayPalChargeAccount)localObject).setEmail((String)Objects.firstNonNull(email, ""));
      continue;
      localObject = new CreditLineChargeAccount();
      ((CreditLineChargeAccount)localObject).setRequestNotes((Boolean)Objects.firstNonNull(requestNotes, Boolean.FALSE));
      continue;
      localObject = new FacebookChargeAccount(lastFour, type);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.payment.ChargeAccountMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */