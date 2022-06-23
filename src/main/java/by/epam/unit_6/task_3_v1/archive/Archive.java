package by.epam.unit_6.task_3_v1.archive;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "cases")
public class Archive {
    private List<Case> cases;

    public Archive() {
    }

    public Archive(List<Case> cases) {
        this.cases = cases;
    }

    @XmlElement(name = "case")
    public List<Case> getCases() {
        return cases;
    }

    public void setCases(List<Case> cases) {
        this.cases = cases;
    }
}
