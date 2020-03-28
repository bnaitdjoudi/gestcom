import axios from 'axios'
import {CATEGORIE_PRODUCT,CATEGORIE_SEARCH} from '../constents/ApiLinks'
export default class CategProdService {

	getCategorieByCriteria(page,size,psort) {
		return axios.post(CATEGORIE_SEARCH,{pageNumber:page,size:size,sorts:psort},
			{
                headers: {
                    'Content-Type': 'application/json',
                }
              }
			).then(res => res.data);
	}

	newRefCategorie(libellie) {
        return axios.post(CATEGORIE_PRODUCT,{libelle:libellie},
            {
                headers: {
                    'Content-Type': 'application/json',
                }
              }
            );
	}
    updateRefCategorie(id,libellie) {
        return axios.put(CATEGORIE_PRODUCT+"/"+id,{libelle:libellie},
            {
                headers: {
                    'Content-Type': 'application/json',
                }
              }
            );
	}

	deleteCategorie(id) {
		return axios.delete(CATEGORIE_PRODUCT+"/"+id,
            {
                headers: {
                    'Content-Type': 'application/json',
                }
              }
            );
	}
}