package InputDeviceTesting.uantwerpen.model;

import javax.persistence.*;

/**
 * Created by Joelg on 22/11/2015.
 */
@Entity
public class createTest {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
  //  private long Code;
  private String Title;
    private String Device;
    private long Targets;
    private long errorThreshold;
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
    private String ColorMissed;
   // private String email;

    public createTest() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public long getCode() {
//        return Code;
//    }
//
//    public void setCode(long Code) {
//        this.Code = Code;
//    }

    public long getTargets() {
        return Targets;
    }

    public void setTargets(long Targets) {
        this.Targets = Targets;
    }

    public long getErrorThreshold() {
        return errorThreshold;
    }

    public void setErrorThreshold(long errorThreshold) {
        this.errorThreshold = errorThreshold;
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

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
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

    public String getDevice() {
        return Device;
    }

    public void setDevice(String Device) {
        this.Device = Device;
    }

    public String getColorPrevious() {
        return ColorPrevious;
    }

    public void setColorPrevious(String colorPrevious) {
        this.ColorPrevious = colorPrevious;
    }

    public String getColorMissed() {
        return ColorMissed;
    }

    public void setColorMissed(String colorMissed) {
        this.ColorMissed = colorMissed;
    }

//    public String getemail() {
//        return email;
//    }
//
//    public void setemail(String email) {
//        this.email = email;
//    }
}


