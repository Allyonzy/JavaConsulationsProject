package checks;

public class Sequence implements CanBeConverted<SequenceElement> {

    private int innerLength = 10;
    private final SequenceElement[] sequenceElements = new SequenceElement[innerLength];

    /**
     * @param convertedObj
     * @return
     */
    @Override
    public boolean isConverted(SequenceElement convertedObj) {
        return false;
    }
}
