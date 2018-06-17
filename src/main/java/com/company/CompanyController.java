package com.company;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.company.dao.CompanyRepository;
import com.company.model.Company;

@RestController
@EnableAutoConfiguration
public class CompanyController {

	@Autowired
	private CompanyRepository companyRepository;


	@GetMapping(value = "/companies")
	public List<Company> retrieveAllCompanies() {
		return companyRepository.findAll();
	}

	@GetMapping(value = "/company/{id}")
	public Company retrieveCompany(@PathVariable long id) throws Exception {
		Optional<Company> company = companyRepository.findById(id);

		if (!company.isPresent())
			return null;

		return company.get();
	}

	@DeleteMapping(value = "/companies/{id}")
	public ResponseEntity<Object> deleteCompany(@PathVariable long id) {
		return companyRepository.findById(id).map(post -> {
			companyRepository.delete(post);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping(value = "/companies")
	public Company createCompany(@Valid @RequestBody Company company) {

		return companyRepository.save(company);

	}

	@PutMapping(value = "/companies/{id}")
	public ResponseEntity<Object> updateCompany(@Valid @RequestBody Company company, @PathVariable long id) {

		Optional<Company> companyOptional = companyRepository.findById(id);

		if (!companyOptional.isPresent())
			return ResponseEntity.notFound().build();

		company.setId(id);

		companyRepository.save(company);

		return ResponseEntity.ok().build();
	}
	
}
