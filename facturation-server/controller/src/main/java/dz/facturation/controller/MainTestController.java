package dz.facturation.controller;

import dz.facturation.service.MainTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * test controller
 */
@RestController
@RequestMapping("/mainrest")
public class MainTestController {

    @Autowired
    private MainTestService mainTestService;

    @GetMapping("/")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("Le serveur est bien présent:"+mainTestService.messageFromService());
    }
}
