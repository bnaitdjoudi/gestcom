package dz.facturation.controller;

import dz.facturation.model.dto.CritereQuery;
import dz.facturation.model.dto.QueryResult;
import dz.facturation.model.entity.RefCompte;
import dz.facturation.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("comptes")
public class CompteRestController {

    @Autowired
    CompteService compteService;

    /**
     * create new RefCompte
     *
     * @param  refCompte RefCompte
     * @return article créé
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RefCompte> create(@RequestBody RefCompte refCompte) {
        return ResponseEntity.ok(compteService.create(refCompte));
    }

    /**
     * find all article by pagination
     *
     * @param critereQuery object of pagination
     * @return page object contents all informations about paging and list of article
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QueryResult<RefCompte>> getAllByPageable(CritereQuery critereQuery) {
        return ResponseEntity.ok(compteService.getQueryByPageable(critereQuery));
    }

    /**
     * update article
     *
     * @param idCompte id article
     * @param values    object of update
     * @return page object contents all informations about paging and list of article
     */
    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> update(@PathVariable("id") Long idCompte, @RequestBody Map<String, Object> values) {
        values.put("id", idCompte);
        if (!compteService.updateCompte(idCompte, values)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    /**
     * @param idCompte ident of Article
     * @return
     */
    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deleteCompte(@PathVariable("id") Long idCompte) {
        compteService.deleteCompteById(idCompte);
        return ResponseEntity.accepted().build();
    }

    /**
     * find all article by pagination
     *
     * @param critereQuery object of pagination
     * @return page object contents all informations about paging and list of article
     */
    @PostMapping(path = "search",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QueryResult<RefCompte>> search(@RequestBody  CritereQuery critereQuery) {

        return ResponseEntity.ok(compteService.getCompteByPageable(critereQuery));
    }

}
