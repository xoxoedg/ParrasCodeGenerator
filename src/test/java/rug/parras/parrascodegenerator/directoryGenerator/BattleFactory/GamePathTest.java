package rug.parras.parrascodegenerator.directoryGenerator.BattleFactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rug.parras.parrascodegenerator.AreaGenerator.GamePath;

@SpringBootTest
class GamePathTest {

    @Autowired
    GamePath properTietest;

    @Test
    void p() {

    System.out.println(properTietest.getPath());
    }
}