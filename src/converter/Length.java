package converter;

/**
 * Length unit with value in meters for easily converting to another unit.
 *
 * @author Pakanon Pantisawat
 */
public enum Length implements Unit<Length> {
    Meter(1.00),
    Centimeter(0.0100),
    Kilometer(1_000),
    Mile(1_609.344),
    Foot(0.30480),
    Wa(2.00000),
    AU(149_597_870_700D);

    /**
     * Constant value of each unit in meters.
     */
    private final double value;

    /**
     * Initializing Length with specific value.
     * @param value value of the unit length in meters.
     */
    Length (double value) {
        this.value = value;
    }


    @Override
    public double convert(double amount, Length unit) {
        return amount / this.getValue() * unit.getValue();
    }

    @Override
    public double getValue() {
        return this.value;
    }
}
