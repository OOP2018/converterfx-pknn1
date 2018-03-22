package converter;

public interface Unit <T>{
    double convert(double amount, T unit);
    String toString();
    double getValue();
}
