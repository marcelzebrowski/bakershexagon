package com.sugar.bakers.company.secondary.driven.database;


import com.sugar.bakers.company.adapter.out.CakeOutputPort;
import com.sugar.bakers.company.domain.Cake;
import com.sugar.bakers.company.domain.CakeId;
import com.sugar.bakers.company.secondary.driven.database.entity.CakeEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class CakeService implements CakeOutputPort {

    private CakeRepository cakeRepository;

    @Override
    public List<Cake> findAll() {
        List<CakeEntity> results = cakeRepository.findAll();
        return mapToDomain(results);
    }

    @Override
    public Optional<Cake> finById(CakeId cakeId) {
        Optional<CakeEntity> cakeEntity = cakeRepository.findById(cakeId.getId());

        Cake cake = null;
        if(cakeEntity.isPresent()){
            cake = mapToDomain(cakeEntity.get());
        }

        return Optional.ofNullable(cake);

    }

    private Cake mapToDomain(CakeEntity result){
        Cake cake = new Cake(new CakeId(result.getId()),result.getName(),result.getPicture(), result.getDescription());
        return cake;
    }

    // You can use something else like ...
    // Dozer
    // Orika
    // MapStruct
    // ModelMapper
    // JMapper
    private List<Cake> mapToDomain(List<CakeEntity> results) {
        List<Cake> cakeList = new ArrayList<>();
        for(CakeEntity ce : results){
            String name = ce.getName();
            String picture = ce.getPicture();
            String description = ce.getDescription();
            Long id = ce.getId();
            Cake cake = new Cake(new CakeId(id),name,picture, description);
            cakeList.add(cake);
        }
        return cakeList;
    }
}
