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
public class filialeServiceTest
{
  @Autowired
  private FilialeService filiale;
  @Autowired
  private MitarbeiterService mitarbeiter;
  
  
  @Before
  public void setUp() throws Exception
  {
  }
  
  @Test
  public void findOneTest1()
  {
    Filiale a = filiale.findOne(1);
    assertThat(a.getIdFiliale(), equalTo(1));
    assertThat(a.getName(), equalTo("Schanzstrasse"));
  }
  
  @Test
  public void findByLeiterTest()
	{
		Mitarbeiter a = mitarbeiter.findByNameLike("Bauer").get(0);
		List<Filiale> m = filiale.findByChef(a);
		assertThat(m.get(0).getIdFiliale(), equalTo(1));
		assertThat(m.get(0).getName(), equalTo("Schanzstrasse"));
	}
  
  
}

 