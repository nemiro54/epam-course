package by.epam.unit_6.task_2.email;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EMail implements Serializable {
    @Serial
    private static final long serialVersionUID = -532778086907537107L;
    private String eMail;
    private final Pattern EMAIL_PATTERN = Pattern.compile("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$");

    public EMail(String eMail) {
        setEMail(eMail);
    }

    private boolean checkEMail(String eMail) {
        Matcher matcher = EMAIL_PATTERN.matcher(eMail);
        return matcher.matches();
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        if (checkEMail(eMail)) {
            this.eMail = eMail;
        } else {
            System.out.printf("E-mail '%s' is incorrect!\nEnter another e-mail: ", eMail);
            Scanner scanner = new Scanner(System.in);

            setEMail(scanner.nextLine());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EMail)) return false;
        EMail eMail1 = (EMail) o;
        return eMail.equals(eMail1.eMail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eMail);
    }

    @Override
    public String toString() {
        return eMail;
    }
}
