package rug.parras.parrascodegenerator.Bootstrap;

import org.springframework.boot.CommandLineRunner;
import rug.parras.parrascodegenerator.Utils.DirectoryOperationUtils;

public class BootstrapApp implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        new DirectoryOperationUtils().createDirectory("src/testPythonDir");
    }
}
