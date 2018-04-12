package icisacultive.devweb.projet.dao;

import icisacultive.devweb.projet.entities.LotPanier;

import java.util.List;

public interface LotPanierDao {

    public List<LotPanier> listLotPanierByIdPanier(Integer id);

    public LotPanier getLotPanierById(Integer id);

    public Integer getMontantLotById(Integer id);
}
