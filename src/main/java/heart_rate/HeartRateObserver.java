package heart_rate;

public interface HeartRateObserver {
    void alert(HeartRateAlertType alertType);
}