package stepDefination;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = {ScenarioBeanInitializer.class})
public class CucumberSpringConfiguration { }
