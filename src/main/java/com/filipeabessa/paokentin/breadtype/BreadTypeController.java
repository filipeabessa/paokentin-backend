package com.filipeabessa.paokentin.breadtype;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/breadtype")
public class BreadTypeController {

    @PostMapping()
    public void createBreadType(@RequestBody BreadTypeEntity breadTypeEntity) {


    }
}
