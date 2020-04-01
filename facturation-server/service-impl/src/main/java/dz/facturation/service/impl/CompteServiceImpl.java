package dz.facturation.service.impl;


import dz.facturation.model.dto.CritereQuery;
import dz.facturation.model.dto.QueryResult;
import dz.facturation.model.entity.RefCategorie;
import dz.facturation.model.entity.RefCompte;
import dz.facturation.repository.RefCompteDao;
import dz.facturation.service.CompteService;
import dz.facturation.tools.EntityTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

@Service
public class CompteServiceImpl implements CompteService {

    @Autowired
    private RefCompteDao refCompteDao;

    @Transactional
    @Override
    public RefCompte create(RefCompte refCompte) {
        return refCompteDao.create(refCompte);
    }
    @Transactional(readOnly = true)
    @Override
    public QueryResult<RefCompte> getQueryByPageable(CritereQuery critereQuery) {
        return refCompteDao.processCriteriaQuery(critereQuery);
    }

    @Transactional
    @Override
    public boolean updateCompte(Long idCompte, Map<String, Object> values) {
        Optional<RefCompte> refCompteOptional = refCompteDao.findById(idCompte);
        if (refCompteOptional.isEmpty()) {
            return false;
        } else {
            RefCompte refCompte = refCompteOptional.get();
            refCompte = EntityTools.updateObjectFromMap(values, refCompte);
            refCompteDao.update(refCompte);
        }
        return true;
    }

    @Transactional(readOnly = true)
    @Override
    public QueryResult<RefCompte> getCompteByPageable(CritereQuery critereQuery) {
        return refCompteDao.processCriteriaQuery(critereQuery);
    }

    @Transactional
    @Override
    public boolean deleteCompteById(Long idCompte) {
        Optional<RefCompte> optionalRefCompte = refCompteDao.findById(idCompte);
        if(optionalRefCompte.isEmpty()){
            return false;
        }else{
            refCompteDao.deleteBy(idCompte);
            return true;
        }
    }
}
