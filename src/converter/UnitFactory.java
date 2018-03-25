package converter;

public class UnitFactory {
    private static UnitFactory ourInstance = new UnitFactory();

    public UnitType[] getUnitType() {
        return UnitType.values();
    }

    public Unit[] getUnit(UnitType unitType) {
        switch (unitType) {
            case Length: return Length.values();
            case Area: return Area.values();
            case Weight: return Weight.values();
            case Temperature: return Temperature.values();
            case Currency: return Currency.values();
            default: throw new IllegalArgumentException();
        }
    }

    public static UnitFactory getInstance() {
        return ourInstance;
    }
}
