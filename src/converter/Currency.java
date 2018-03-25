package converter;

/**
 * Currency unit with value in USD based for conversion.
 *
 * @author Pakanon Pantisawat.
 */
public enum Currency implements Unit<Currency> {
    USD,
    THB,
    JPY,
    CNY,
    CAD,
    SGD;

    private final double rates;

    Currency() {
        this.rates = CurrencyGetter.convertUSDTo(this.toString());
    }

    @Override
    public double convert(double amount, Currency unit) {
        return amount / this.getValue() * unit.getValue();
    }

    @Override
    public double getValue() {
        return this.rates;
    }
}
