package Visitor;
// Variables will reference the data that was returned by the program

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Variable {
    private String text, url, name, fileName;
    private boolean alert;
    private List<String> steps;
    private static AtomicInteger number = new AtomicInteger(0);

    public Variable(String url, String text) {
        this.name = newName();
        this.url = url;
        this.text = text;
        this.steps = new ArrayList<String>();
    }

    private String newName() { return String.valueOf(number.getAndIncrement()); }

    public final String getText() {
        return this.text;
    }
    public final void setText(String text) {
        this.text = text;
    }

    public final void addStep(String step) {
        this.steps.add(step);
    }
    public final List<String> getSteps() {
        return this.steps;
    }

    public static final Variable variableFactory(String url, String text) {
        return new Variable(url, text);
    }

    public final String getURL() { return this.url; }

    /**
     *
     * @return
     */
    public final String getName() { return this.name; }

    // only used by /update
    public String getFileName() {
        return fileName;
    }

    // only used by /extract
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean getAlert() {
        return alert;
    }

    public void setAlert(boolean alert) {
        this.alert = alert;
    }
}
