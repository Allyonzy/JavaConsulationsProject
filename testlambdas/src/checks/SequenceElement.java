package checks;

import java.util.Objects;
import java.util.StringJoiner;

public class SequenceElement {
    private String numberFromScanner;

    public SequenceElement() {
    }

    public SequenceElement(String numberFromScanner) {
        this.numberFromScanner = numberFromScanner;
    }

    public String getNumberFromScanner() {
        return numberFromScanner;
    }

    public void setNumberFromScanner(String numberFromScanner) {
        this.numberFromScanner = numberFromScanner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SequenceElement that = (SequenceElement) o;
        return Objects.equals(getNumberFromScanner(), that.getNumberFromScanner());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumberFromScanner());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SequenceElement.class.getSimpleName() + "[", "]")
                .add("numberFromScanner='" + numberFromScanner + "'")
                .toString();
    }
}
