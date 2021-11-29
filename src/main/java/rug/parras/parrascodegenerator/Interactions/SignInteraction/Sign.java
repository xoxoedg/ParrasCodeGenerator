package rug.parras.parrascodegenerator.Interactions.SignInteraction;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sign {

    public static final String SIGN_INTERACTION_CLASS_TEMPLATE =
            "class Sign%sInteraction%s(AbstractInteractionDialog):\n" +
                    "\n" +
                    "    def __init__(self):\n" +
                    "        super(Sign%sInteraction%s, self).__init__([])\n" +
                    "\n" +
                    "    def define_speech(self):\n" +
                    "        return %s.copy()";

    public static final String SIGN_INTERACTION_LIST_NAME_TEMPLATE =
            "SIGN_%s_INTERACTION_%s_DIALOG";

    public static final String SIGN_INTERACTION_LIST_TEXT_TEMPLATE =
            "['%s']" ;

    public static final String SIGN_INTERACTION_IMPORT_TEMPLATE =
                "from common.dialogs.abstract_interaction_dialog import AbstractInteractionDialog";

    private String signText;
    private String area;
    private String map;
    private String direction;
    private String fileName;
}