package temperature_monitor;

public interface TemperatureMonitor {
    /**
     * Inicia o monitoramento
     */
    void start();

    /**
     * Para o monitoramento
     */
    void stop();

    /**
     * Configura o monitor
     * @param config objeto de configuração
     */
    void configure(TemperatureConfig config);

    /**
     * Adicionar um observer para callback em caso de alertas configurados
     * @param observer objeto para callback
     */
    void addObserver(TemperatureObserver observer);

    /**
     * remove um observer
     * @param observer objeto para callback
     */
    void removeObserver(TemperatureObserver observer);

    /**
     * Retorna o estado atual
     * @return estado atual
     */
    TemperatureState getCurrentState();
}