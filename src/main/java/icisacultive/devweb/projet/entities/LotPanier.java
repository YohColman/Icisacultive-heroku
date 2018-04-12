package icisacultive.devweb.projet.entities;

public class LotPanier {

    private Integer idLot;
    private Integer prix;
    private Integer nombrePanier;
    private Integer idPanier;
    private String typePanier;

    public LotPanier(Integer idLot, Integer prix, Integer nombrePanier, Integer idPanier) {
        this.idLot = idLot;
        this.prix = prix;
        this.nombrePanier = nombrePanier;
        this.idPanier = idPanier;
    }

    public LotPanier(Integer idLot, Integer prix, Integer nombrePanier, Integer idPanier, String typePanier) {
        this.idLot = idLot;
        this.prix = prix;
        this.nombrePanier = nombrePanier;
        this.idPanier = idPanier;
        this.typePanier = typePanier;
    }

    public Integer getIdLot() {
        return idLot;
    }

    public void setIdLot(Integer idLot) {
        this.idLot = idLot;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public Integer getNombrePanier() {
        return nombrePanier;
    }

    public void setNombrePanier(Integer nombrePanier) {
        this.nombrePanier = nombrePanier;
    }

    public Integer getIdPanier() {
        return idPanier;
    }

    public void setIdPanier(Integer idPanier) {
        this.idPanier = idPanier;
    }

    public String getTypePanier() {
        return typePanier;
    }

    public void setTypePanier(String typePanier) {
        this.typePanier = typePanier;
    }
}
