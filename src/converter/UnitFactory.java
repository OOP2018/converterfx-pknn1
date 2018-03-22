package converter;

public class UnitFactory {
    private static UnitFactory ourInstance = new UnitFactory();

    public UnitType[] getUnitType() {
        return UnitType.values();
    }

    public Unit[] getUnit(UnitType unitType) {
        if (unitType.equals(UnitType.Length)) return Length.values();
        else if (unitType.equals(UnitType.Weight)) return Weight.values();
        else if (unitType.equals(UnitType.Area)) return Area.values();
        else throw new IllegalArgumentException("UnitType is invalid.");
    }

    public static UnitFactory getInstance() {
        return ourInstance;
    }
}
