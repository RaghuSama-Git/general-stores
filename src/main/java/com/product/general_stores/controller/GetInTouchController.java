package com.product.general_stores.controller;

import com.product.general_stores.model.GetInTouch;
import com.product.general_stores.service.implementations.GetInTouchServiceImpl;
import com.product.general_stores.util.ResponseDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/getintouch")
@CrossOrigin("*")
public class GetInTouchController {
    private final GetInTouchServiceImpl service;

    public GetInTouchController(GetInTouchServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/submit-details")
    public ResponseDTO<GetInTouch> submitDetails(@RequestBody GetInTouch getInTouch){
        ResponseDTO<GetInTouch> responseDTO;

        if(getInTouch == null){
            responseDTO = new ResponseDTO<>("FAIL", null, "Details cannot be null");
            return responseDTO;
        }
        GetInTouch submittedDetails = service.submitDetails(getInTouch);
        System.out.println("Server Response : " + getInTouch);
        responseDTO = new ResponseDTO<>("Success", submittedDetails, "Details have been saved successfully");
        return responseDTO;
    }
}
