package com.sugar.bakers.company.primary.driving;

import com.sugar.bakers.company.adapter.in.CakeReaderInportPort;
import com.sugar.bakers.company.domain.Cake;
import com.sugar.bakers.company.domain.CakeId;
import com.sugar.bakers.company.primary.driving.exception.CakeNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CakeRestController {

    private CakeReaderInportPort cakeReaderInportPort;

    @GetMapping("/cake/{id}")
    public Cake readCake(@PathVariable Long id){
        CakeId cakeId = new CakeId(id);
        return cakeReaderInportPort.finById(cakeId).orElseThrow(()->new CakeNotFoundException(cakeId));
    }

    @GetMapping("/cakes")
    public List<Cake> readAllCakes(){
        return cakeReaderInportPort.findAll();
    }
}
