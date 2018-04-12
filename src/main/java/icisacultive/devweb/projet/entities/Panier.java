package icisacultive.devweb.projet.entities;

public class Panier {

    private Integer id;
    private String typepanier;
    private String image;

    public Panier(Integer id, String type){
        this.id=id;
        this.typepanier=type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypepanier() {
        return typepanier;
    }

    public void setTypepanier(String typepanier) {
        this.typepanier = typepanier;
    }



}
