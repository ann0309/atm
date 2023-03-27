package com.example.atm;


//用來存放從json中拿到的資料
public class Guardspec {

    public String getGuard() {
        return Guard;
    }

    public void setGuard(String guard) {
        this.Guard = guard;
    }

    String Guard;

    public String getDisable() {
        return this.disable;
    }

    public String setDisable(String disable) {
        this.disable = disable;
        return this.disable;
    }

    String disable;

    public String getInvocation() {
        return invocation;
    }

    public void setInvocation(String invocation) {
        this.invocation = invocation;
    }

    String invocation;

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    String instanceName;

    public String getGuardConfiguration() {
        return guardConfiguration;
    }

    public void setGuardConfiguration(String guardConfiguration) {
        this.guardConfiguration = guardConfiguration;
    }

    String guardConfiguration;

}
