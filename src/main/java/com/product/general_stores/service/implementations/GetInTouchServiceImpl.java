package com.product.general_stores.service.implementations;

import com.product.general_stores.model.GetInTouch;
import com.product.general_stores.repository.GetInTouchRepository;
import org.springframework.stereotype.Service;

@Service
public class GetInTouchServiceImpl {

    private final GetInTouchRepository repository;

    public GetInTouchServiceImpl(GetInTouchRepository repository) {
        this.repository = repository;
    }

    public GetInTouch submitDetails(GetInTouch getInTouch){
        return repository.save(getInTouch);
//        return "Details saved successfully";
    }
}
