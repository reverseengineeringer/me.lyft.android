package me.lyft.android.analytics.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.lyft.android.analytics.Analytics;
import me.lyft.android.analytics.core.definitions.Experiment;
import me.lyft.android.analytics.core.events.ExperimentEvent;
import me.lyft.android.analytics.core.events.ExperimentEvent.Type;

public class ExperimentAnalytics
{
  private static ExperimentAnalytics EMPTY = new NullExperimentAnalytics();
  private static final Map<Experiment, String> assignmentFilter;
  private static final Map<Experiment, String> assignments;
  private static final Set<Experiment> autoExposure;
  private static final Map<Long, Experiment> experiments = new HashMap();
  private static final Map<Experiment, String> exposureFilter;
  private static final Object stateLock;
  private static final Map<Long, String> variants = new HashMap();
  private final ExperimentEvent event;
  
  static
  {
    assignments = new HashMap();
    assignmentFilter = new HashMap();
    exposureFilter = new HashMap();
    autoExposure = new HashSet() {};
    stateLock = new Object();
    register(Experiment.AA, "Control", new Long[] { Long.valueOf(6045996644040704L), Long.valueOf(5107385664798720L) });
    register(Experiment.AA, "Treatment", new Long[] { Long.valueOf(5446016589889536L), Long.valueOf(5641149129687040L) });
    register(Experiment.CONFIRM_INACCURATE_PICKUP, "Control", new Long[] { Long.valueOf(5535809021673472L), Long.valueOf(5177409771405312L) });
    register(Experiment.CONFIRM_INACCURATE_PICKUP, "Treatment", new Long[] { Long.valueOf(6143172023943168L), Long.valueOf(4802923318476800L) });
    register(Experiment.AUTO_FILL_RIDE_STEP, "Control", new Long[] { Long.valueOf(6609460366147584L), Long.valueOf(5135804473540608L) });
    register(Experiment.AUTO_FILL_RIDE_STEP, "Treatment", new Long[] { Long.valueOf(6695846737870848L), Long.valueOf(4681262313242624L) });
    register(Experiment.ENVOY_SFO_TERMINATION, "Control", new Long[] { Long.valueOf(4686725662638080L) });
    register(Experiment.ENVOY_SFO_TERMINATION, "Treatment", new Long[] { Long.valueOf(5533998558740480L) });
    register(Experiment.SL_SIGNON_BONUS_DRIVERSTAT_CARD, "Control", new Long[] { Long.valueOf(4558513347493888L), Long.valueOf(5185158739656704L) });
    register(Experiment.SL_SIGNON_BONUS_DRIVERSTAT_CARD, "Treatment", new Long[] { Long.valueOf(4600758914252800L), Long.valueOf(5031801228099584L) });
    register(Experiment.SL_REFEREE_BONUS_DRIVERSTAT_CARD, "Control", new Long[] { Long.valueOf(6655342352531456L), Long.valueOf(5091901779214336L) });
    register(Experiment.SL_REFEREE_BONUS_DRIVERSTAT_CARD, "Treatment", new Long[] { Long.valueOf(6711538845483008L), Long.valueOf(5118585605718016L) });
    register(Experiment.MODE_SELECTOR_POPUP, "Control", new Long[] { Long.valueOf(5761155520266240L), Long.valueOf(6534164271071232L) });
    register(Experiment.MODE_SELECTOR_POPUP, "Treatment", new Long[] { Long.valueOf(5050831146057728L), Long.valueOf(5721971057229824L) });
    register(Experiment.INITIATE_AUTO_FILL_ULU_ON_BOOTSTRAP, "Control", new Long[] { Long.valueOf(4953096489271296L), Long.valueOf(6732940063539200L) });
    register(Experiment.INITIATE_AUTO_FILL_ULU_ON_BOOTSTRAP, "Treatment", new Long[] { Long.valueOf(5855859691749376L), Long.valueOf(4700625695145984L) });
    register(Experiment.RIDE_XP_CLASSIC_ROUTE_LINES, "Control", new Long[] { Long.valueOf(5158536183545856L), Long.valueOf(4874950498844672L) });
    register(Experiment.RIDE_XP_CLASSIC_ROUTE_LINES, "Variant 1", new Long[] { Long.valueOf(4771474401918976L), Long.valueOf(5073479456522240L) });
    register(Experiment.PAYMENT_USE_LOCALE_FOR_ZIP_COUNTRY, "Control", new Long[] { Long.valueOf(6478441608642560L), Long.valueOf(4508726925459456L) });
    register(Experiment.PAYMENT_USE_LOCALE_FOR_ZIP_COUNTRY, "UseLocale", new Long[] { Long.valueOf(5754174012653568L), Long.valueOf(6336601924304896L) });
    register(Experiment.PG_PHONE_FIRST_SIGNUP_V2, "Control", new Long[] { Long.valueOf(5011768644993024L), Long.valueOf(5979484235235328L) });
    register(Experiment.PG_PHONE_FIRST_SIGNUP_V2, "ProfileFirstNoFB", new Long[] { Long.valueOf(5873996348784640L), Long.valueOf(5470092255559680L) });
    register(Experiment.PG_PHONE_FIRST_SIGNUP_V2, "PhoneFirstNoFB", new Long[] { Long.valueOf(5641325625999360L), Long.valueOf(5674242255355904L) });
    register(Experiment.PG_PHONE_FIRST_SIGNUP_V2, "Control2", new Long[] { Long.valueOf(5677002577149952L), Long.valueOf(5111292301934592L) });
    register(Experiment.PY_DRIVER_EARNINGS, "Control", new Long[] { Long.valueOf(6091262034182144L), Long.valueOf(5888488608628736L) });
    register(Experiment.PY_DRIVER_EARNINGS, "DriverEarnings", new Long[] { Long.valueOf(5074705015373824L), Long.valueOf(6366886292357120L) });
    register(Experiment.EN_SHOW_BUSINESS_RIDE_HISTORY, "Control", new Long[] { Long.valueOf(5862351725658112L), Long.valueOf(5477768274378752L) });
    register(Experiment.EN_SHOW_BUSINESS_RIDE_HISTORY, "ShowBusinessRideHistory", new Long[] { Long.valueOf(5648219487338496L), Long.valueOf(4981127045971968L) });
    register(Experiment.PG_INVITE_TEXT_V2, "Control", new Long[] { Long.valueOf(5741100906577920L), Long.valueOf(4785662614568960L) });
    register(Experiment.PG_INVITE_TEXT_V2, "Personal", new Long[] { Long.valueOf(5657124498046976L), Long.valueOf(4873989824970752L) });
    register(Experiment.PG_INVITE_TEXT_V2, "Money", new Long[] { Long.valueOf(5759525743230976L), Long.valueOf(5696748890619904L) });
    register(Experiment.PG_INVITE_TEXT_V2, "Friendly", new Long[] { Long.valueOf(5663935340478464L), Long.valueOf(5749708521734144L) });
    register(Experiment.PG_SPLIT_PAY_HINT, "Control", new Long[] { Long.valueOf(0L), Long.valueOf(6513067584651264L) });
    register(Experiment.PG_SPLIT_PAY_HINT, "Variant 1", new Long[] { Long.valueOf(0L), Long.valueOf(5021889433436160L) });
    register(Experiment.RE_PASSENGER_ETD_IN_PIN, "Control", new Long[] { Long.valueOf(4691872367247360L), Long.valueOf(5107923164856320L) });
    register(Experiment.RE_PASSENGER_ETD_IN_PIN, "Variant 1", new Long[] { Long.valueOf(5625372771614720L), Long.valueOf(5416469253324800L) });
    register(Experiment.DX_MODE_TOGGLE, "Control", new Long[] { Long.valueOf(5434126977466368L), Long.valueOf(5459986036031488L) });
    register(Experiment.DX_MODE_TOGGLE, "Variant 1", new Long[] { Long.valueOf(4562191842279424L), Long.valueOf(5360540229042176L) });
    register(Experiment.RE_RATE_AND_PAY_V2, "Control", new Long[] { Long.valueOf(0L), Long.valueOf(6484683857068032L) });
    register(Experiment.RE_RATE_AND_PAY_V2, "Variant 1", new Long[] { Long.valueOf(0L), Long.valueOf(571699452392243L) });
    register(Experiment.PG_PROMOTE_GIFT_BOX, "Control", new Long[] { Long.valueOf(4662232233803776L), Long.valueOf(5364006804520960L) });
    register(Experiment.PG_PROMOTE_GIFT_BOX, "Variant 1", new Long[] { Long.valueOf(6357283489972224L), Long.valueOf(6155316947845120L) });
    register(Experiment.GR_RIDE_TYPE_HINT, "Control", new Long[] { Long.valueOf(5485736814444544L), Long.valueOf(5813032549089280L) });
    register(Experiment.GR_RIDE_TYPE_HINT, "Variant 1", new Long[] { Long.valueOf(5005988699045888L), Long.valueOf(4859527629897728L) });
    register(Experiment.RE_CLASSIC_ROUTE_LINE, "DropOffLine", new Long[] { Long.valueOf(5656306136383488L), Long.valueOf(5762705898078208L) });
    register(Experiment.RE_CLASSIC_ROUTE_LINE, "Control", new Long[] { Long.valueOf(5977813532803072L), Long.valueOf(4555623629324288L) });
    register(Experiment.RE_CLASSIC_ROUTE_LINE, "ActiveLine", new Long[] { Long.valueOf(6567791446982656L), Long.valueOf(6679952638869504L) });
    register(Experiment.RE_PAX_USE_ANDROID_LOCATION_MANAGER, "Control", new Long[] { Long.valueOf(4895822922121216L), Long.valueOf(5191537527357440L) });
    register(Experiment.RE_PAX_USE_ANDROID_LOCATION_MANAGER, "Variant 1", new Long[] { Long.valueOf(6223451000406016L), Long.valueOf(5363744845070336L) });
    register(Experiment.PG_LADA_GIVE_GET, "Control", new Long[] { Long.valueOf(4842207704514560L), Long.valueOf(6682245648089088L) });
    register(Experiment.PG_LADA_GIVE_GET, "Variant 1", new Long[] { Long.valueOf(5188847267217408L), Long.valueOf(5437154090549248L) });
    register(Experiment.PG_LADA_GIVE_GET, "Variant 2", new Long[] { Long.valueOf(5671845864931328L), Long.valueOf(5640250206453760L) });
    register(Experiment.PG_LADA_GIVE_GET, "Variant 3", new Long[] { Long.valueOf(5108895911510016L), Long.valueOf(5750279215513600L) });
    register(Experiment.PG_LADA_GIVE_GET, "Variant 4", new Long[] { Long.valueOf(6234795818352640L), Long.valueOf(5154000315875328L) });
    register(Experiment.PG_LADA_GIVE_GET, "Variant 5", new Long[] { Long.valueOf(4827420934799360L), Long.valueOf(5670421881946112L) });
    register(Experiment.PG_LADA_GIVE_GET, "Variant 6", new Long[] { Long.valueOf(5953320841641984L), Long.valueOf(5650250232496128L) });
  }
  
  private ExperimentAnalytics(ExperimentEvent.Type paramType, Experiment paramExperiment, String paramString)
  {
    if (paramString != null)
    {
      event = new ExperimentEvent(paramType, paramExperiment.toString(), paramString);
      return;
    }
    event = null;
  }
  
  private static ExperimentAnalytics assignment(Experiment paramExperiment, String paramString)
  {
    if (assignmentFilter.get(paramExperiment) == paramString) {
      return EMPTY;
    }
    assignmentFilter.put(paramExperiment, paramString);
    return new ExperimentAnalytics(ExperimentEvent.Type.ASSIGNMENT, paramExperiment, paramString);
  }
  
  private static ExperimentAnalytics exposure(Experiment paramExperiment)
  {
    synchronized (stateLock)
    {
      String str = (String)assignments.get(paramExperiment);
      if ((str == null) || (exposureFilter.get(paramExperiment) == str))
      {
        paramExperiment = EMPTY;
        return paramExperiment;
      }
      exposureFilter.put(paramExperiment, str);
      paramExperiment = new ExperimentAnalytics(ExperimentEvent.Type.EXPOSURE, paramExperiment, str);
      return paramExperiment;
    }
  }
  
  private static void register(Experiment paramExperiment, String paramString, Long... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Long localLong = paramVarArgs[i];
      experiments.put(localLong, paramExperiment);
      variants.put(localLong, paramString);
      i += 1;
    }
  }
  
  public static void reset()
  {
    synchronized (stateLock)
    {
      assignments.clear();
      assignmentFilter.clear();
      exposureFilter.clear();
      return;
    }
  }
  
  private void track()
  {
    if (event != null) {
      Analytics.track(event);
    }
  }
  
  public static void trackExposure(Experiment paramExperiment)
  {
    exposure(paramExperiment).track();
  }
  
  public static void updateAssignments(List<Long> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (stateLock)
    {
      assignments.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject2 = (Long)paramList.next();
        Experiment localExperiment = (Experiment)experiments.get(localObject2);
        localObject2 = (String)variants.get(localObject2);
        if ((localExperiment != null) && (localObject2 != null))
        {
          assignments.put(localExperiment, localObject2);
          localArrayList.add(assignment(localExperiment, (String)localObject2));
          if (autoExposure.contains(localExperiment)) {
            localArrayList.add(exposure(localExperiment));
          }
        }
      }
    }
    paramList = localArrayList.iterator();
    while (paramList.hasNext()) {
      ((ExperimentAnalytics)paramList.next()).track();
    }
  }
  
  private static class NullExperimentAnalytics
    extends ExperimentAnalytics
  {
    NullExperimentAnalytics()
    {
      super(null, null, null);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.core.ExperimentAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */