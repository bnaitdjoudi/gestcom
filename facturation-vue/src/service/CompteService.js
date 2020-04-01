import axios from 'axios';
import {COMPTE,COMPTE_SEARCH} from '../constents/ApiLinks.js';
export default class CategProdService {

    getCompteByCriteria(page,size,filters,sort){
        return axios.post(COMPTE_SEARCH,{pageNumber:page,size:size,criteria:filters,sorts:sort},
			{
                headers: {
                    'Content-Type': 'application/json',
                }
              }
			).then(res => res.data);
    }

    newCompte(codecompte,libellie) {
        return axios.post(COMPTE,{code:codecompte,libelle:libellie},
            {
                headers: {
                    'Content-Type': 'application/json',
                }
              }
            );
    }
    
    updateCompte(id,codecompte,libellie) {
        return axios.put(COMPTE+"/"+id,{code:codecompte,libelle:libellie},
            {
                headers: {
                    'Content-Type': 'application/json',
                }
              }
            );
    }
    
    
	deleteCompte(id) {
		return axios.delete(COMPTE+"/"+id,
            {
                headers: {
                    'Content-Type': 'application/json',
                }
              }
            );
	}

}