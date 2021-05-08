package blood_pressure;

public enum AlertType {
    MAX_DIASTOLIC(1),
    MIN_DIASTOLIC(2),
    MAX_SYSTOLIC(3),
    MIN_SYSTOLIC(4);

    private int value;

    AlertType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
