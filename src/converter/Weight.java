package converter;

public enum Weight implements Unit<Weight> {
    Kilogram(1),
    Gram(0.001),
    Milligram(0.000001),
    Pound(0.454),
    Tonne(1000),
    Baht(0.015),
    Chang(1.2),
    Hap(60);

    private final double value;

    Weight(double value) {
        this.value = value;
    }
    
    @Override
    public double convert(double amount, Weight unit) {
        return amount / this.getValue() * unit.getValue();
    }

    @Override
    public double getValue() {
        return this.value;
    }
}
