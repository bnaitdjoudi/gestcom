package dz.facturation.service;

import dz.facturation.model.dto.CritereQuery;
import dz.facturation.model.dto.QueryResult;
import dz.facturation.model.entity.RefCompte;

import java.util.Map;

/**
 * service ref_compte
 */
public interface CompteService {
    /**
     * crete refCompte
     * @param refCompte entity
     * @return refCompte
     */
    RefCompte create(RefCompte refCompte);

    /**
     * search by criteria
     * @param critereQuery
     * @return object with all information pagination
     */
    QueryResult<RefCompte> getQueryByPageable(CritereQuery critereQuery);

    /**
     * update by idCompte
     * @param idCompte id of ref_compte
     * @param values all value to update
     * @return true if succes or false if niit exist
     */
    boolean updateCompte(Long idCompte, Map<String, Object> values);

    /**
     * get by paging and criteria
     * @param critereQuery
     * @return queryResult of result
     */
    QueryResult<RefCompte> getCompteByPageable(CritereQuery critereQuery);

    /**
     * delete compte by id
     * @param idCompte id of ref_compte
     * @return true is deleted
     */
    boolean deleteCompteById(Long idCompte);
}
