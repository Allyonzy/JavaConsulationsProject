package checks;

@FunctionalInterface
public interface CanBeConverted<T> {
    public abstract boolean isConverted(T convertedObj);
}
