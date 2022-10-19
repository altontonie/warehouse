package thashort.gamer.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thashort.gamer.warehouse.entity.dto.CompanyDto;
import thashort.gamer.warehouse.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping(path = "/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<CompanyDto>> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CompanyDto> getCompanyById(@PathVariable String id){
        return companyService.getCompanyById(id);
    }

    @GetMapping(path = "/subscription/{id}")
    public ResponseEntity<String> getSubscription(@PathVariable String id){
        return companyService.getSubscription(id);
    }


    @PostMapping()
    public ResponseEntity<CompanyDto> addCompany(@RequestBody CompanyDto companyDto){
        return companyService.addCompany(companyDto);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<CompanyDto> updateCompany(@PathVariable String id,@RequestBody CompanyDto company){
        return companyService.updateCompany(id,company);
    }
}
