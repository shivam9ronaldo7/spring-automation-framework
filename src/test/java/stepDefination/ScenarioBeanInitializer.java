package stepDefination;

import io.cucumber.spring.ScenarioScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ScenarioScope
@ComponentScan(basePackages = {"annotations","utility"})
@PropertySource(value = {"classpath:application.properties", "classpath:${env:qaEnv}.properties"})
public class ScenarioBeanInitializer {}
