package com.sugar.bakers.company.usecase;

import com.sugar.bakers.company.adapter.in.CustomerReaderPort;
import com.sugar.bakers.company.adapter.out.CustomerOutputPort;
import com.sugar.bakers.company.domain.Customer;
import com.sugar.bakers.company.domain.CustomerId;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Golden Hammer

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class ReadCustomerUseCase implements CustomerReaderPort {

    @NonNull
    private CustomerOutputPort customerOutputPort;

    @Override
    public List<Customer> findAll() {
        return customerOutputPort.findAll();
    }

    @Override
    public Optional<Customer> findById(CustomerId customerId) {
        return customerOutputPort.findById(customerId);
    }

    @Override
    public Optional<Customer> findByUsername(String username) {
        return customerOutputPort.findByName(username);
    }
}
