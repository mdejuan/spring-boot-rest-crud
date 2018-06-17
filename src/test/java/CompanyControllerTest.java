import static org.junit.Assert.assertTrue;
import java.util.HashSet;
import java.util.List;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import com.company.CompanyController;
import com.company.model.Company;
import com.company.model.Owner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CompanyController.class)
public class CompanyControllerTest {

	@Autowired
	private CompanyController controller;

	private Company company;

	@Before
	public void setUp() {

		company = new Company("Company3", "Address1", "City1", "Country1", "Email1", "1234567");
		company.setOwner(new HashSet<Owner>() {
			{
				add(new Owner("Owner A1", company));
				add(new Owner("Owner A2", company));
				add(new Owner("Owner A3", company));
			}
		});

	}

	@Test
	public void testAddCompany() {

		Company c = controller.createCompany(company);
		assertTrue(!c.getId().equals(null));
		assertTrue(c.getName().equals("Company3"));
		assertTrue(c.getOwner().size() > 0);
	}

	@Test
	public void testRetrieveCompany() throws Exception {
		List<Company> companies = controller.retrieveAllCompanies();
		Company comp = null;
		Long id = null;
		for (Company c : companies) {
			comp = controller.retrieveCompany(c.getId());
			id = c.getId();
			break;
		}
		assertTrue(comp.getId().equals(id));
	}

	@Test
	public void testUpdateCompany() throws Exception {

		List<Company> companies = controller.retrieveAllCompanies();
		Company comp = null;
		Long id = null;
		for (Company c : companies) {
			comp = controller.retrieveCompany(c.getId());
			comp.setCity("New City");

			break;
		}
		ResponseEntity<Object> response = controller.updateCompany(company, comp.getId());
		assertTrue(response.getStatusCode().equals(HttpStatus.OK));
	}

	@Test
	public void testRetrieveCompanies() throws JSONException {

		List<Company> companies = controller.retrieveAllCompanies();

		assertTrue(companies.size() >= 0);

	}

	@Test
	public void testDeleteCompany() throws Exception {
		List<Company> companies = controller.retrieveAllCompanies();
		Company comp = null;
		Long id = null;
		for (Company c : companies) {
			comp = controller.retrieveCompany(c.getId());

			break;
		}
		ResponseEntity<Object> response = controller.deleteCompany(comp.getId());

		assertTrue(response.getStatusCode().equals(HttpStatus.OK));
	}

}
