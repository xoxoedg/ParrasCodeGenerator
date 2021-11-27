package rug.parras.parrascodegenerator.SignInteraction;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Sign {
    public static final String SIGNTEMPLATE =
            "class Sign%sInteraction%s(AbstractInteractionDialog):\n" +
                    "\n" +
                    "    def __init__(self):\n" +
                    "        super(Sign%sInteraction%s, self).__init__([])\n" +
                    "\n" +
                    "    def define_speech(self):\n" +
                    "        return %s.copy()";

    public String signText;
    public String area;
    public String map;
    public String direction;

}
