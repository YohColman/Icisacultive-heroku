package icisacultive.devweb.projet.entities;

import java.util.Date;

public class SeanceDistribution {
    private String dateSeance;

    public SeanceDistribution(String date){
        this.dateSeance=date;
    }

    public String getDateSeance() {
        return dateSeance;
    }

    public void setDateSeance(String dateSeance) {
        this.dateSeance = dateSeance;
    }
}
