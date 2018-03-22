package converter;

public class UnitFactory {
    private static UnitFactory ourInstance = new UnitFactory();

    public UnitType[] getUnitType() {
        return UnitType.values();
    }

    public Unit[] getUnit(UnitType unitType) {
        switch (unitType) {
            case Length:
                return Length.values();
            case Weight:
                return Weight.values();
            case Area:
                return Area.values();
            case Temperature:
                return Temperature.values();
        }
        throw new IllegalArgumentException();
    }

    public static UnitFactory getInstance() {
        return ourInstance;
    }
}
