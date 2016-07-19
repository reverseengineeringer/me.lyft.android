package me.lyft.android.infrastructure.googlegeo;

import java.io.IOException;
import java.util.List;
import me.lyft.android.infrastructure.googlegeo.model.DistanceMatrixResponseDTO;
import me.lyft.android.infrastructure.googlegeo.model.GoogleDirectionsResponseDTO;
import me.lyft.android.infrastructure.googlegeo.model.GoogleGeocodeResponseDTO;
import rx.Observable;

public abstract interface IGoogleGeoApi
{
  public abstract Observable<GoogleGeocodeResponseDTO> addressLookupFromZip(String paramString1, String paramString2);
  
  public abstract Observable<GoogleDirectionsResponseDTO> directions(String paramString1, String paramString2, List<String> paramList);
  
  public abstract DistanceMatrixResponseDTO distancematrixSync(String paramString1, String paramString2)
    throws IOException;
  
  public abstract Observable<Long> getTotalEta(String paramString, List<String> paramList);
  
  public abstract Observable<GoogleGeocodeResponseDTO> reverseGeocode(String paramString);
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.googlegeo.IGoogleGeoApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */