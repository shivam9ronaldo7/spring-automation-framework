package utility;

import io.cucumber.java.Scenario;
import io.cucumber.spring.ScenarioScope;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@ScenarioScope
@Component
public class ScenarioData {

    @Getter
    @Setter
    private Scenario scenario;

}
