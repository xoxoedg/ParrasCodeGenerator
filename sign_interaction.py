class SignUpInteractionCityMarket(AbstractInteractionDialog):

    def __init__(self):
        super(SignUpInteractionCityMarket, self).__init__([])

    def define_speech(self):
        return SIGN_UP_INTERACTION_CITYMARKET_DIALOG.copy()