/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.ui;

import app.ObserverManager;
import app.SmartMonitors;
import app.connector.*;
import app.observers.*;
import blood_pressure.BloodPressureMonitor;
import blood_pressure.BloodPressureMonitorImpl;
import blood_pressure.BloodPressureObserver;
import data_center.entities.Patient;
import heart_rate.HeartRateMonitor;
import smart_tracker.SmartTrackerMonitor;
import temperature_monitor.TemperatureMonitor;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author wmespindula
 */
public class MonitorRemoveUI extends DisposableJFrame {

    private Patient patient;
    private DisposableJFrame newMonitorUI;

    /**
     * Creates new form MainUI
     */
    public MonitorRemoveUI(Patient patient) {
        initComponents();

        this.patient = patient;
        fillSelector(getPatientMonitors());

    }

    public void fillSelector(List<String> monitors){
        monitorTypeSelector.removeAllItems();
        monitors.forEach(monitor -> monitorTypeSelector.addItem(monitor));
    }

    public List<String> getPatientMonitors() {
        List<String> patientMonitors = new ArrayList<>();
        Long patientId = patient.getPatientId();

        ObserverManager observerManager = ObserverManager.getInstance();
        observerManager.getAlertButtonObserversByPatientId(patientId)
                .ifPresent(alertButtonObserver ->
                        patientMonitors.add(SmartMonitors.EMERGENCY_BUTTON.getName()));

        observerManager.getBloodPressureObserversByPatientId(patientId)
                .ifPresent(bloodPressureObserver ->
                        patientMonitors.add(SmartMonitors.BLOOD_PRESSURE.getName()));

        observerManager.getHeartRateObserversByPatientId(patientId)
                .ifPresent(heartRateObserver ->
                        patientMonitors.add(SmartMonitors.HEART_RATE.getName()));

        observerManager.getTemperatureObserversByPatientId(patientId)
                .ifPresent(temperatureObserver ->
                        patientMonitors.add(SmartMonitors.TEMPERATURE_MONITOR.getName()));

        observerManager.getSmartTrackerObserversByPatientId(patientId)
                .ifPresent(smartTrackerObserver ->
                        patientMonitors.add(SmartMonitors.SMART_TRACKER.getName()));

        return patientMonitors;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        monitorTypeSelector = new javax.swing.JComboBox<>();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(8, 0), new java.awt.Dimension(8, 0), new java.awt.Dimension(8, 32767));
        addMonitorButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Remover Monitor do Paciente");
        jLabel1.setVerifyInputWhenFocusTarget(false);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));
        jPanel1.add(jPanel2);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));
        jPanel1.add(jPanel3);

        jLabel2.setText("Monitor:");

        addMonitorButton.setText("Remover Monitor");
        addMonitorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMonitorButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addMonitorButton)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(monitorTypeSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(monitorTypeSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addMonitorButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addMonitorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMonitorButtonActionPerformed

        SmartMonitors type = Arrays.stream(SmartMonitors.values()).filter(item  -> item.getName().equals(monitorTypeSelector.getSelectedItem()))
                .findFirst().get();
        ObserverManager observerManager = ObserverManager.getInstance();
        Long patientId = patient.getPatientId();

        switch (type){
            case HEART_RATE:
                HeartRateConnector heartRateConnector = HeartRateConnector.getInstance();
                Optional<HeartRateObserverImpl> heartRateObserverOptional = observerManager.getHeartRateObserversByPatientId(patientId);
                if (heartRateObserverOptional.isPresent()){
                    HeartRateObserverImpl heartRateObserver = heartRateObserverOptional.get();
                    heartRateConnector.detachPatientOfMonitor(heartRateObserver.getMonitorCode(), heartRateObserver);
                    observerManager.remove(heartRateObserver);

                    JOptionPane.showMessageDialog(this, "Monitor removido com sucesso!");
                }
                break;


            case BLOOD_PRESSURE:
                BloodPressureConnector bloodPressureConnector = BloodPressureConnector.getInstance();
                Optional<BloodPressureObserverImpl> bloodPressureObserverOptional = observerManager.getBloodPressureObserversByPatientId(patientId);
                if (bloodPressureObserverOptional.isPresent()){
                    BloodPressureObserverImpl bloodPressureObserver = bloodPressureObserverOptional.get();
                    bloodPressureConnector.detachPatientOfMonitor(bloodPressureObserver.getMonitorCode(), bloodPressureObserver);
                    observerManager.remove(bloodPressureObserver);

                    JOptionPane.showMessageDialog(this, "Monitor removido com sucesso!");
                }
                break;


            case SMART_TRACKER:
                SmartTrackerConnector smartTrackerConnector = SmartTrackerConnector.getInstance();
                Optional<SmartTrackerObserverImpl> smartTrackerObserverOptional = observerManager.getSmartTrackerObserversByPatientId(patientId);
                if (smartTrackerObserverOptional.isPresent()){
                    SmartTrackerObserverImpl smartTrackerObserver = smartTrackerObserverOptional.get();
                    smartTrackerConnector.detachPatientOfMonitor(smartTrackerObserver.getMonitorCode(), smartTrackerObserver);
                    observerManager.remove(smartTrackerObserver);

                    JOptionPane.showMessageDialog(this, "Monitor removido com sucesso!");
                }
                break;

            case TEMPERATURE_MONITOR:
                TemperatureConnector temperatureConnector = TemperatureConnector.getInstance();
                Optional<TemperatureObserverImpl> temperatureObserverOptional = observerManager.getTemperatureObserversByPatientId(patientId);
                if (temperatureObserverOptional.isPresent()){
                    TemperatureObserverImpl temperatureObserver = temperatureObserverOptional.get();
                    temperatureConnector.detachPatientOfMonitor(temperatureObserver.getMonitorCode(), temperatureObserver);
                    observerManager.remove(temperatureObserver);

                    JOptionPane.showMessageDialog(this, "Monitor removido com sucesso!");
                }
                break;


            case EMERGENCY_BUTTON:
                AlertButtonConnector alertButtonConnector = AlertButtonConnector.getInstance();
                Optional<AlertButtonObserverImpl> alertButtonObserverOptional = observerManager.getAlertButtonObserversByPatientId(patientId);
                if (alertButtonObserverOptional.isPresent()){
                    AlertButtonObserverImpl alertButtonObserver = alertButtonObserverOptional.get();
                    alertButtonConnector.detachPatientOfMonitor(alertButtonObserver.getMonitorCode(), alertButtonObserver);
                    observerManager.remove(alertButtonObserver);

                    JOptionPane.showMessageDialog(this, "Monitor removido com sucesso!");
                }
                break;

            default:
                JOptionPane.showMessageDialog(this, "Nenhum monitor selecionado!");
                break;

        }
        this.dispose();
    }//GEN-LAST:event_addMonitorButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMonitorButton;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JComboBox<String> monitorTypeSelector;
    // End of variables declaration//GEN-END:variables
}