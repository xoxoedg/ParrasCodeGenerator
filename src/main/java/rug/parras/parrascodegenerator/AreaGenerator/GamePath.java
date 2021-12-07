package rug.parras.parrascodegenerator.AreaGenerator;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public abstract class GamePath {

    @Value("${path.to.parras}")
    private String path;

}
