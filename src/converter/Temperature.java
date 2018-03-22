package converter;

public enum Temperature implements Unit<Temperature> {
    Celsius(0.00, 1.00),
    Farenheit(32.00, 5.00/9.00),
    Kelvin(273.15, 1.00);

    private final double subtract;
    private final double multiplicator;

    Temperature(double subtract, double multiplicator) {
        this.subtract = subtract;
        this.multiplicator = multiplicator;
    }


    @Override
    public double convert(double amount, Temperature unit) {
        double celsius = (amount - subtract) * multiplicator;
        return (celsius / unit.multiplicator) + unit.subtract;
    }

    @Override
    public double getValue() {
        return 0;
    }
}
