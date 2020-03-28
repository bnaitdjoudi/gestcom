package dz.facturation.service;


import dz.facturation.model.dto.CritereQuery;
import dz.facturation.model.dto.QueryResult;
import dz.facturation.model.entity.RefCategorie;
import dz.facturation.model.entity.view.RefCategorieView;

import java.util.Map;

public interface RefCategorieService {

    /**
     * create RefCategorie
     * @param refCategorie to create
     * @return created refCategorie
     */
     RefCategorie create(RefCategorie refCategorie) ;

    /**
     * search by criteria and paging
     * @param critereQuery criteria object
     * @return Result of query
     */
    QueryResult<RefCategorie> searchByCriteria(CritereQuery critereQuery);

    /**
     * search refCategorieView by criteria and paging
     * @param critereQuery criteria object
     * @return Result of query
     */
    QueryResult<RefCategorieView> searchRefCategorieViewByCriteria(CritereQuery critereQuery);

    /**
     * update ref category
     * @param id ref category id
     * @param values properties to update
     * @return true if succes
     */
    boolean updateRefCategorie(Long id, Map<String, Object> values);

    /**
     * delete refCategorie
     * @param id of refCategorie
     * @return true if delete else if not found
     */
    boolean deleteCategorie(Long id);
}
