package com.wanz.product.view.validator;

import com.wanz.product.view.CreateProductRequest;
import org.springframework.stereotype.Component;

@Component
public class CreateProductRequestValidator {

    public boolean validate(CreateProductRequest createProductRequest) {
        if (createProductRequest.getPrice()<0)
            return false;
        if (createProductRequest.getName().length()<=0)
            return false;
        return true;
    }
}
