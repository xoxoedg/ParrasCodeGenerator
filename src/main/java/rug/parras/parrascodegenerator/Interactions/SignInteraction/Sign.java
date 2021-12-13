package rug.parras.parrascodegenerator.Interactions.SignInteraction;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sign {

    private String signText;
    private String area;
    private String map;
    private String direction;
    private String fileName;

}