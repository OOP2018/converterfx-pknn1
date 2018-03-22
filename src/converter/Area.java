package converter;

public enum Area implements Unit<Area> {
    SquareMeter(1),
    SquareKilometer(0.000001),
    SquareCentimeter(10000),
    Acre(0.000247),
    SquareFeet(10.759325),
    SquareInch(1549.342799),
    TarangWa(1.195481),
    Rai(0.000625),
    Ngan(0.0025);

    private final double value;

    Area(double value) {
        this.value = value;
    }
    
    @Override
    public double convert(double amount, Area unit) {
        return amount / this.getValue() * unit.getValue();
    }

    @Override
    public double getValue() {
        return this.value;
    }
}
