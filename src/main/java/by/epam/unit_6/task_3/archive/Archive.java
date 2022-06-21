package by.epam.unit_6.task_3.archive;

import by.epam.unit_6.task_3.student.StudentStatus;

import java.util.ArrayList;
import java.util.List;

public class Archive {
    private List<Case> archive = new ArrayList<>();

    public Archive(List<Case> archive) {
        this.archive = archive;
    }

    public void addDeed(Case aCase) {
        archive.add(aCase);
    }

    public void addCase(String name, String faculty, int course, int yearOfEnrolling) {
        archive.add(new Case(name, faculty, course, yearOfEnrolling));
    }

    public void removeCase(Case aCase) {
        archive.remove(aCase);
    }

    public void removeCase(int numOfCase) {
        Case aCase;
        for (int i = 0; i < archive.size(); i++) {
            aCase = archive.get(i);
            if (aCase.getNumOfCase() == numOfCase) {
                archive.remove(aCase);
            }
        }
    }

    public void removeIfNotEnrolled() {
        Case aCase;
        for (int i = 0; i < archive.size(); i++) {
            aCase = archive.get(i);
            if (aCase.getStudentStatus() != StudentStatus.ENROLLED) {
                archive.remove(aCase);
            }
        }
    }

    public boolean chooseCase(int numOfCase) {
        int id = -1;
        for (int i = 0; i < archive.size(); i++) {
            if (archive.get(i).getNumOfCase() == numOfCase) {
                id = i;
                break;
            }
        }
        if (id != -1) {
            archive.add(archive.size(), archive.get(id));
            archive.remove(id);
            return true;
        } else {
            return false;
        }
    }

    public void changeFaculty(String faculty) {
        if (archive.size() > 0) {
            archive.get(archive.size() - 1).changeFaculty(faculty);
        }
    }

    public boolean incrementCourse() {
        if (archive.size() > 0) {
            return archive.get(archive.size() - 1).incrementCourse();
        } else {
            return false;
        }
    }

    public void changeCourse(int course) {
        if (archive.size() > 0) {
            archive.get(archive.size() - 1).changeCourse(course);
        }
    }

    public List<Case> findCaseByFaculty(String faculty) {
        List<Case> founded = new ArrayList<>();
        if (faculty != null && !faculty.isEmpty() && archive.size() > 0) {
            for (Case aCase : archive) {
                if (aCase.getFaculty().equals(faculty)) {
                    founded.add(aCase);
                }
            }
        }
        return founded;
    }

    public List<Case> findCaseByCourse(int course) {
        List<Case> founded = new ArrayList<>();
        if (archive.size() > 0) {
            for (Case aCase : archive) {
                if (aCase.getCourse() == course) {
                    founded.add(aCase);
                }
            }
        }
        return founded;
    }

    public List<Case> findCaseByYear(int year) {
        List<Case> founded = new ArrayList<>();
        if (archive.size() > 0) {
            for (Case aCase : archive) {
                if (aCase.getYearOfEnrolling() == year) {
                    founded.add(aCase);
                }
            }
        }
        return founded;
    }

    public Case get(int number) {
        if (number >= 0 && number < archive.size()) {
            return archive.get(number);
        } else {
            return null;
        }
    }

    public void print() {
        System.out.println(this);
    }

    public List<Case> getArchive() {
        return archive;
    }

    public void setArchive(List<Case> archive) {
        this.archive = archive;
    }

    @Override
    public String toString() {
        if (archive.size() > 0) {
            StringBuilder string = new StringBuilder();
            for (Case aCase : archive) {
                string.append(aCase.toString()).append("\n");
            }
            return string.toString();
        } else {
            return "Archive is empty!";
        }
    }
}
