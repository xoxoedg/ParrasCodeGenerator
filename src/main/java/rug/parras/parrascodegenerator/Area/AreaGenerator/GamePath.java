package rug.parras.parrascodegenerator.Area.AreaGenerator;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Setter
@Configuration
public abstract class GamePath {

    @Value("${path.to.parras}")
    protected String path;

//    public String generateFilename(String areaName) {
//        return String.format(defineTemplate(), path, areaName.toLowerCase());
//    }
//
//    public abstract  String defineTemplate();

}
