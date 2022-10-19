package thashort.gamer.warehouse.service;

import org.springframework.http.ResponseEntity;
import thashort.gamer.warehouse.entity.dto.CompanyDto;

import java.util.List;

public interface CompanyService {
    ResponseEntity<List<CompanyDto>> getAllCompanies();

    ResponseEntity<CompanyDto> getCompanyById(String id);

    ResponseEntity<String> getSubscription(String id);

    ResponseEntity<CompanyDto> addCompany(CompanyDto companyDto);

    ResponseEntity<CompanyDto> updateCompany(String id, CompanyDto company);
}
