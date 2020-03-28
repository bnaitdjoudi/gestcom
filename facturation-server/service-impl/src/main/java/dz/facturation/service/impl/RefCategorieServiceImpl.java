package dz.facturation.service.impl;

import dz.facturation.model.dto.CritereQuery;
import dz.facturation.model.dto.QueryResult;
import dz.facturation.model.dto.SortDir;
import dz.facturation.model.entity.Article;
import dz.facturation.model.entity.RefCategorie;
import dz.facturation.model.entity.view.RefCategorieView;
import dz.facturation.repository.IRefCategorieViewDao;
import dz.facturation.repository.RefCategorieDao;
import dz.facturation.service.RefCategorieService;
import dz.facturation.tools.EntityTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;


@Service
public class RefCategorieServiceImpl implements RefCategorieService {

    @Autowired private RefCategorieDao refCategorieDao;
    @Autowired private IRefCategorieViewDao refCategorieViewDao;

    @Override
    @Transactional
    public RefCategorie create(RefCategorie refCategorie) {
        return refCategorieDao.create(refCategorie);
    }

    @Override
    @Transactional(readOnly = true)
    public QueryResult<RefCategorie> searchByCriteria(CritereQuery critereQuery) {
        return refCategorieDao.processCriteriaQuery(critereQuery);
    }

    @Override
    @Transactional(readOnly = true)
    public QueryResult<RefCategorieView> searchRefCategorieViewByCriteria(CritereQuery critereQuery) {
        if(!critereQuery.getSorts().containsKey("id")){
            critereQuery.getSorts().put("id", SortDir.DESC);
        }
        return refCategorieViewDao.processCriteriaQuery(critereQuery);
    }

    @Transactional
    @Override
    public boolean updateRefCategorie(Long id, Map<String, Object> values) {
        Optional<RefCategorie> refCategorieOptional = refCategorieDao.findById(id);
        if (refCategorieOptional.isEmpty()) {
            return false;
        } else {
            RefCategorie refCategorie = refCategorieOptional.get();
            refCategorie = EntityTools.updateObjectFromMap(values, refCategorie);
            refCategorieDao.update(refCategorie);
        }
        return true;
    }

    @Transactional
    @Override
    public boolean deleteCategorie(Long id) {
        Optional<RefCategorie> optionalRefCategorie = refCategorieDao.findById(id);
        if(optionalRefCategorie.isEmpty()){
            return false;
        }else{
            refCategorieDao.deleteBy(id);
            return true;
        }
    }


}
