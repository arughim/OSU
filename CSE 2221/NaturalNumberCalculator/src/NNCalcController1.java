import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * Controller class.
 *
 * @author Arun Ghimire
 */
public final class NNCalcController1 implements NNCalcController {

    /**
     * Model object.
     */
    private final NNCalcModel model;

    /**
     * View object.
     */
    private final NNCalcView view;

    /**
     * Useful constants.
     */
    private static final NaturalNumber TWO = new NaturalNumber2(2),
            INT_LIMIT = new NaturalNumber2(Integer.MAX_VALUE);

    /**
     * Updates this.view to display this.model, and to allow only operations
     * that are legal given this.model.
     *
     * @param model
     *            the model
     * @param view
     *            the view
     * @ensures [view has been updated to be consistent with model]
     */
    private static void updateViewToMatchModel(NNCalcModel model,
            NNCalcView view) {

        NaturalNumber topModel = model.top();
        NaturalNumber botModel = model.bottom();
        view.updateTopDisplay(topModel);
        view.updateBottomDisplay(botModel);
        view.updateSubtractAllowed(botModel.compareTo(topModel) <= 0);
        view.updateDivideAllowed(!botModel.isZero());
        view.updateRootAllowed(botModel.compareTo(TWO) >= 0
                && botModel.compareTo(INT_LIMIT) <= 0);
        view.updatePowerAllowed(botModel.compareTo(TWO) >= 0);

    }

    /**
     * Constructor.
     *
     * @param model
     *            model to connect to
     * @param view
     *            view to connect to
     */
    public NNCalcController1(NNCalcModel model, NNCalcView view) {
        this.model = model;
        this.view = view;
        updateViewToMatchModel(model, view);
    }

    @Override
    public void processClearEvent() {
        /*
         * Get alias to bottom from model
         */
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        bottom.clear();
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processSwapEvent() {
        /*
         * Get aliases to top and bottom from model
         */
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        NaturalNumber temp = top.newInstance();
        temp.transferFrom(top);
        top.transferFrom(bottom);
        bottom.transferFrom(temp);
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processEnterEvent() {
        NaturalNumber topPanel = this.model.top();
        NaturalNumber botPanel = this.model.bottom();
        topPanel.copyFrom(botPanel);
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processAddEvent() {
        NaturalNumber topPanel = this.model.top();
        NaturalNumber botPanel = this.model.bottom();
        topPanel.add(botPanel);
        botPanel.transferFrom(topPanel);
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processSubtractEvent() {
        NaturalNumber topPanel = this.model.top();
        NaturalNumber botPanel = this.model.bottom();
        topPanel.subtract(botPanel);
        botPanel.transferFrom(topPanel);
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processMultiplyEvent() {

        NaturalNumber topPanel = this.model.top();
        NaturalNumber botPanel = this.model.bottom();
        topPanel.multiply(botPanel);
        botPanel.transferFrom(topPanel);
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processDivideEvent() {
        NaturalNumber topPanel = this.model.top();
        NaturalNumber botPanel = this.model.bottom();
        NaturalNumber temp = topPanel.divide(botPanel);
        botPanel.transferFrom(topPanel);
        topPanel.transferFrom(temp);
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processPowerEvent() {
        NaturalNumber topPanel = this.model.top();
        NaturalNumber botPanel = this.model.bottom();
        int temp = botPanel.toInt();
        topPanel.power(temp);
        botPanel.transferFrom(topPanel);
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processRootEvent() {
        NaturalNumber topPanel = this.model.top();
        NaturalNumber botPanel = this.model.bottom();
        int temp = botPanel.toInt();
        topPanel.root(temp);
        botPanel.transferFrom(topPanel);
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processAddNewDigitEvent(int digit) {
        NaturalNumber botPanel = this.model.bottom();
        botPanel.multiplyBy10(digit);
        updateViewToMatchModel(this.model, this.view);

    }

}
