/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.care.app.ui;

import com.care.app.AlreadyHaveMonitorAttachedException;
import com.care.app.ObserverManager;
import com.care.app.connector.TemperatureConnector;
import com.care.app.observers.TemperatureObserverImpl;
import com.care.data_center.entities.Patient;
import com.care.temperature_monitor.TemperatureConfig;
import com.care.temperature_monitor.TemperatureMonitor;
import com.care.temperature_monitor.TemperatureState;

import javax.swing.*;

/**
 * @author wmespindula
 */
public class TemperatureMonitorRegisterUI extends LinkedDisposableJFrame {
    private final Patient patient;
    private final TemperatureMonitor temperatureMonitor;


    /**
     * Creates new form BloodPressureRegister
     */
    public TemperatureMonitorRegisterUI(DisposableJFrame previousJFrame, Patient patient, TemperatureMonitor temperatureMonitor) {
        super(previousJFrame);
        this.patient = patient;
        this.temperatureMonitor = temperatureMonitor;

        initComponents();
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
        minTemperatureTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        maxTemperatureTextField = new javax.swing.JTextField();
        registerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Defina os limites de Temperatura");

        jLabel2.setText("Temperatura Mínima:");

        jLabel3.setText("Temperatura Máxima:");

        registerButton.setText("Registrar");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(maxTemperatureTextField))
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(minTemperatureTextField))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(registerButton)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(minTemperatureTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(maxTemperatureTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                .addComponent(registerButton)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        TemperatureConfig temperatureConfig = getTemperatureConfigFromForm();
        TemperatureObserverImpl temperatureObserver = new TemperatureObserverImpl(patient.getPatientId(), temperatureMonitor.getCode());
        ObserverManager observerManager = ObserverManager.getInstance();

        if (temperatureConfig != null) {
            try {
                observerManager.add(temperatureObserver);

                TemperatureConnector connector = TemperatureConnector.getInstance();
                connector.attachPatientToMonitor(patient, temperatureMonitor.getCode(),
                        temperatureObserver, temperatureConfig);

                JOptionPane.showMessageDialog(this, "Monitor configurado ao paciente com sucesso!",
                        "Configurado!", JOptionPane.INFORMATION_MESSAGE);

            } catch (AlreadyHaveMonitorAttachedException e) {
                JOptionPane.showMessageDialog(this, "Sensor de Pressão Arterial já está registrado ao paciente!");
                e.printStackTrace();
            }
            this.dispose();
        }
    }//GEN-LAST:event_registerButtonActionPerformed


    private TemperatureConfig getTemperatureConfigFromForm() {
        String temperatureMinString = minTemperatureTextField.getText();
        String temperatureMaxString = maxTemperatureTextField.getText();

        try {
            Integer temperatureMin = Integer.parseInt(temperatureMinString);
            Integer temperatureMax = Integer.parseInt(temperatureMaxString);

            TemperatureConfig config = new TemperatureConfig();

            TemperatureState minState = new TemperatureState();
            minState.setTemperature(temperatureMin);

            TemperatureState maxState = new TemperatureState();
            maxState.setTemperature(temperatureMax);

            config.setMinState(minState);
            config.setMaxState(maxState);

            return config;

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Os campos devem conter números inteiros positivos!",
                    "Erro no preenchimento do formulário", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return null;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField maxTemperatureTextField;
    private javax.swing.JTextField minTemperatureTextField;
    private javax.swing.JButton registerButton;
    // End of variables declaration//GEN-END:variables
}
