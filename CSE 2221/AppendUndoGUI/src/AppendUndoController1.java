/**
 * Controller class.
 *
 * @author Bruce W. Weide
 * @author Paolo Bucci
 */
public final class AppendUndoController1 implements AppendUndoController {

    /**
     * Model object.
     */
    private final AppendUndoModel1 model;

    /**
     * View object.
     */
    private final AppendUndoView view;

    /**
     * Constructor; connects {@code this} to the model and view it coordinates.
     *
     * @param model2
     *            model to connect to
     * @param view2
     *            view to connect to
     */
    public AppendUndoController1(AppendUndoModel model2, AppendUndoView view2) {
        this.model = (AppendUndoModel1) model2;
        this.view = view2;
        /*
         * Update view to reflect initial value of model
         */
    }

    /**
     * Processes reset event.
     */
    @Override
    public void processResetEvent() {
        /*
         * Update model in response to this event
         */
        this.model.setInput("");
        this.model.setOutput("");
        /*
         * Update view to reflect changes in model
         */
    }

    /**
     * Processes copy event.
     *
     * @param input
     *            value of input text (provided by view)
     */
    @Override
    public void processAppendEvent(String input) {
        /*
         * Update model in response to this event
         */
        this.model.setInput(input);
        this.model.setOutput(input);
        /*
         * Update view to reflect changes in model
         */
    }

    @Override
    public void processUndoEvent() {
        // TODO Auto-generated method stub

    }

}
