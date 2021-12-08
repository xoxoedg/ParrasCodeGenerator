package rug.parras.parrascodegenerator.Area.AreaGenerator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("it")
class CodeWriterServiceTest {

    @Autowired
    CodeWriterService codeWriterService;

    @Test
    void writeCodeToFile() {
        Area area = new Area();
        area.setAreaName("Rionnagen");
        codeWriterService.writeCodeToFile(area.getAreaName());
    }
}