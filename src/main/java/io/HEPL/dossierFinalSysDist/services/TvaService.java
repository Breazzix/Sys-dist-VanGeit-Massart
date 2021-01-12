package io.HEPL.dossierFinalSysDist.services;

import io.HEPL.dossierFinalSysDist.models.Category;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class TvaService {
    public TvaService(){

    }
    public int getTva(Category categorie)
    {
        if (categorie.getId()==1)
            return 6;
        else
            return 21;
    }

    public static float round(float value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (float) tmp / factor;
    }
}
