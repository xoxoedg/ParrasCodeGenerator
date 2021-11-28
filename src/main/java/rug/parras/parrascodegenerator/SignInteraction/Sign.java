package rug.parras.parrascodegenerator.SignInteraction;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    public static final String SIGNLISTNAMETEMPLATE =
            "SIGN_%s_INTERACTION_%s_DIALOG";

    //

    public static final String SIGNLISTTEXTTEMPLATE =
            "['%s']" ;

    public static final String SIGNIMPORTEMPLATE =
                "from common.dialogs.abstract_interaction_dialog import AbstractInteractionDialog";

    private String signText;
    private String area;
    private String map;
    private String direction;
    private String fileName;



}
