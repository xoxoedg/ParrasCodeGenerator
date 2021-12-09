package rug.parras.parrascodegenerator.Area;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import rug.parras.parrascodegenerator.Area.AreaGenerator.Area;
import rug.parras.parrascodegenerator.Area.Validation.ValidationAreaResult;
import rug.parras.parrascodegenerator.Area.Validation.ValidationAreaStatus;

@SpringBootTest
@ActiveProfiles("it")
class AreaGenerationServiceTest {



    @Autowired
    AreaGenerationService areaGenerationService;

    @Test
    void createArea() {
        ValidationAreaResult areaResult = new ValidationAreaResult();
        areaResult.setValidationStatus(ValidationAreaStatus.SUCCESS);
        Area area = new Area();
        area.setAreaName("Rionnagen");

        areaGenerationService.createArea(area);

    }
}