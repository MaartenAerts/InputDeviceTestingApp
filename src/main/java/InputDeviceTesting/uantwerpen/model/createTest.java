package InputDeviceTesting.uantwerpen.model;

/**
 * Created by Joelg on 22/11/2015.
 */
public class createTest {

    private long Code;
    private long Targets;
    private long ErrorTreshold;
    private long Sequences;
    private long Difficulty;
    private long AmplitudeMin;
    private long AmplitudeMax;
    private long WidthMin;
    private long WidthMax;
    private String ColorMain;
    private String ColorTargets;
    private String ColorNext;
    private String ColorPrevious;

    public createTest() {
    }

    public long getCode() {
        return Code;
    }

    public void setCode(long Code) {
        this.Code = Code;
    }

    public long getTargets() {
        return Targets;
    }

    public void setTargets(long Targets) {
        this.Targets = Targets;
    }

    public long getErrorTreshold() {
        return ErrorTreshold;
    }

    public void setErrorTreshold(long errorTreshold) {
        this.ErrorTreshold = errorTreshold;
    }

    public long getSequences() {
        return Sequences;
    }

    public void setSequences(long sequences) {
        this.Sequences = sequences;
    }

    public long getDifficulty() {
        return Difficulty;
    }

    public void setDifficulty(long difficulty) {
        this.Difficulty = difficulty;
    }

    public long getAmplitudeMin() {
        return AmplitudeMin;
    }

    public void setAmplitudeMin(long amplitudeMin) {
        this.AmplitudeMin = amplitudeMin;
    }

    public long getAmplitudeMax() {
        return AmplitudeMax;
    }

    public void setAmplitudeMax(long amplitudeMax) {
        this.AmplitudeMax = amplitudeMax;
    }

    public long getWidthMin() {
        return WidthMin;
    }

    public void setWidthMin(long widthMin) {
        this.WidthMin = widthMin;
    }

    public long getWidthMax() {
        return WidthMax;
    }

    public void setWidthMax(long widthMax) {
        this.WidthMax = widthMax;
    }

    public String getColorMain() {
        return ColorMain;
    }

    public void setColorMain(String colorMain) {
        this.ColorMain = colorMain;
    }

    public String getColorTargets() {
        return ColorTargets;
    }

    public void setColorTargets(String colorTargets) {
        this.ColorTargets = colorTargets;
    }

    public String getColorNext() {
        return ColorNext;
    }

    public void setColorNext(String colorNext) {
        this.ColorNext = colorNext;
    }

    public String getColorPrevious() {
        return ColorPrevious;
    }

    public void setColorPrevious(String colorPrevious) {
        this.ColorPrevious = colorPrevious;
    }
}
