package com.sugar.bakers.company.usecase;

import com.sugar.bakers.company.adapter.in.CakeReaderInportPort;
import com.sugar.bakers.company.adapter.out.CakeOutputPort;
import com.sugar.bakers.company.domain.Cake;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


// Golden Hammer

@Getter
@Setter
@RequiredArgsConstructor
@Service
public class ReadCakeUseCase implements CakeReaderInportPort {

    @NonNull
    private CakeOutputPort cakeOutputPort;

    @Override
    public List<Cake> findAll() {
        return cakeOutputPort.findAll();
    }

    @Override
    public Optional<Cake> finById(Cake.CakeId cakeId) {
        return cakeOutputPort.finById(cakeId);
    }
}
