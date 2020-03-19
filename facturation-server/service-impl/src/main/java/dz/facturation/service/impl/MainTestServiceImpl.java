package dz.facturation.service.impl;

import dz.facturation.service.MainTestService;
import org.springframework.stereotype.Service;

/**
 * MainTestService implmentation
 */
@Service
public class MainTestServiceImpl implements MainTestService {
    @Override
    public String messageFromService() {
        return "ce message vient du service ";
    }
}
