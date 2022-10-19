package thashort.gamer.warehouse.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import thashort.gamer.warehouse.entity.dao.Company;
import thashort.gamer.warehouse.entity.dto.CompanyDto;
import thashort.gamer.warehouse.repository.CompanyRepo;
import thashort.gamer.warehouse.service.CompanyService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepo companyRepo;

    @Override
    public ResponseEntity<List<CompanyDto>> getAllCompanies() {
        List<CompanyDto> data = new ArrayList<>();
        List<Company> result = companyRepo.findAll();
        //BeanUtils.copyProperties(result,data);
        for (Company company :
                result) {
            CompanyDto companyDto = new CompanyDto();
            BeanUtils.copyProperties(company,companyDto);
            data.add(companyDto);
        }
        return ResponseEntity.ok(data);
    }

    @Override
    public ResponseEntity<CompanyDto> getCompanyById(String id) {
        CompanyDto data = new CompanyDto();
        Company result = companyRepo.findByCompanyID(id);
        BeanUtils.copyProperties(result,data);
        return ResponseEntity.ok(data);
    }

    @Override
    public ResponseEntity<String> getSubscription(String id) {
        Company result = companyRepo.findByCompanyID(id);
        return ResponseEntity.ok(result.getSubscription());
    }

    @Override
    public ResponseEntity<CompanyDto> addCompany(CompanyDto companyDto) {
        Company company = new Company();
        BeanUtils.copyProperties(companyDto,company);
        String uniqueID = UUID.randomUUID().toString();
        company.setCompanyID(uniqueID);

        Company result = companyRepo.save(company);
        CompanyDto data = new CompanyDto();
        BeanUtils.copyProperties(result,data);
        return ResponseEntity.ok(data);
    }

    @Override
    public ResponseEntity<CompanyDto> updateCompany(String id, CompanyDto company) {
        Company data = companyRepo.findByCompanyID(id);
        data.setCompany(company.getCompany());
        data.setSubscription(company.getSubscription());
        final Company result = companyRepo.save(data);

        CompanyDto companyDto = new CompanyDto();
        BeanUtils.copyProperties(result,companyDto);
        return ResponseEntity.ok(companyDto);
    }


}
