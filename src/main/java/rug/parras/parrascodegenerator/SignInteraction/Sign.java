package rug.parras.parrascodegenerator.SignInteraction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sign {

    @Getter
    public static final String SIGNCODETEMPLATE =
            "class Sign%sInteraction%s(AbstractInteractionDialog):\n" +
                    "\n" +
                    "    def __init__(self):\n" +
                    "        super(Sign%sInteraction%s, self).__init__([])\n" +
                    "\n" +
                    "    def define_speech(self):\n" +
                    "        return %s.copy()";

    @Getter
    public static final String SIGNMAPNAMETEMPLATE =
            "SIGN_%s_INTERACTION_%s_DIALOG";

    @Getter
    public static final String SIGNMAPTEXTTEMPLATE =
            "['%s']" ;

    private String signText;
    private String area;
    private String map;
    private String direction;
    private String fileName;



}
