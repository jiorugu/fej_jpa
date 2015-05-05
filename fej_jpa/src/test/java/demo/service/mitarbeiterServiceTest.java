package demo.service;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import demo.Config;
import demo.model.Filiale;
import demo.model.Mitarbeiter;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Config.class)
public class mitarbeiterServiceTest
{
  @Autowired
  private MitarbeiterService mitarbeiter;
  @Autowired
  private FilialeService filiale;
  
  @Before
  public void setUp() throws Exception
  {
  }
  
  @Test
  public void findOneTest1()
  {
    Mitarbeiter a = mitarbeiter.findOne(1);
    assertThat(a.getIdMitarbeiter(), equalTo(1));
    assertThat(a.getName(), equalTo("Bauer"));
  }
  @Test
  public void findOneTest2()
  {
    Mitarbeiter a = mitarbeiter.findOne(2);
    assertThat(a.getIdMitarbeiter(), equalTo(2));
    assertThat(a.getName(), equalTo("Laitner"));
  }
  @Test
  public void findByFilialeTest()
	{
		Filiale a = filiale.findByNameLike("Heiligenstaedterstrasse").get(0);
		List<Mitarbeiter> m = mitarbeiter.findByFiliale(a);
		assertThat(m.get(0).getIdMitarbeiter(), equalTo(3));
		assertThat(m.get(0).getName(), equalTo("Swoboda"));
	}
  
}

 