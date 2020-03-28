package dz.facturation.controller;

import dz.facturation.model.dto.CritereQuery;
import dz.facturation.model.dto.QueryResult;
import dz.facturation.model.entity.RefCategorie;
import dz.facturation.model.entity.view.RefCategorieView;
import dz.facturation.service.RefCategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("categories")
public class RefCategorieRestController {



    @Autowired
    private RefCategorieService refCategorieService;
    /**
     * find all ref-categorie by pagination
     *
     * @param critereQuery object of pagination
     * @return page object contents all informations about paging and list of article
     */
    @PostMapping(path = "search",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QueryResult<RefCategorieView>> search(@RequestBody CritereQuery critereQuery) {
        return ResponseEntity.ok(refCategorieService.searchRefCategorieViewByCriteria(critereQuery));
    }

    /**
     * create new RefCategorie
     *
     * @param refCategorie object RefCategorie
     * @return  créated object
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RefCategorie> create(@RequestBody RefCategorie refCategorie) {
        return ResponseEntity.status(HttpStatus.CREATED).body(refCategorieService.create(refCategorie));
    }

    /**
     * update article
     *
     * @param id refCategorie id
     * @param values    object of update
     * @return page object contents all informations about paging and list of article
     */
    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> update(@PathVariable("id") Long id, @RequestBody Map<String, Object> values) {
        values.put("id", id);
        if (!refCategorieService.updateRefCategorie(id, values)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    /**
     * delete refCategorie
     * @param id of refCategorie
     * @return Response with status
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteRefCategorie(@PathVariable("id") Long id){
        if(!refCategorieService.deleteCategorie(id)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }


}
