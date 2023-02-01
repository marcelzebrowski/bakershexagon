package com.sugar.bakers.company.primary.driving;

import com.sugar.bakers.company.adapter.out.CakeOutputPort;
import com.sugar.bakers.company.domain.Cake;
import com.sugar.bakers.company.primary.driving.exception.CakeNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CakeRestController {

    // Homework: Marcel war faul und hat gar nicht eingesehen hier den Golden Hammer zu implementieren.
    //           Marcel hat aber vergessen, dass die Id noch validiert werden soll und das noch geprüft werden
    //           muss ob der Kuchen überhaupt lieferbar ist.
    //           Bade Marcels Faulheit aus!
    private CakeOutputPort cakeOutputPort; // !!! GEHEN NICHT ÜBER USE CASE !!!

    @GetMapping("/cake/{id}")
    public Cake readCake(@PathVariable Long id){
        Cake.CakeId cakeId = new Cake.CakeId(id);
        return cakeOutputPort.finById(cakeId).orElseThrow(()->new CakeNotFoundException(cakeId));
    }

    @GetMapping("/cakes")
    public List<Cake> readAllCakes(){
        return cakeOutputPort.findAll();
    }
}
