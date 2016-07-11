package Utils;

import Models.ExpressSoftware;
import Models.HeavyHardware;
import Models.Interfaces.HardwareComponent;
import Models.Interfaces.SoftwareComponent;
import Models.LightSoftware;
import Models.PowerHardware;

import java.util.LinkedHashMap;

public class Dump {
    private LinkedHashMap<String, HardwareComponent> hardwareComponents;

    public Dump(){
        this.hardwareComponents = new LinkedHashMap<>();
    }

    public int getDumpedPowerHardware(){
        int count = 0;
        for (HardwareComponent component : hardwareComponents.values()) {
            if(component.getClass().equals(PowerHardware.class)){
                count++;
            }
        }
        return count;
    }

    public int getDumpedHeavyHardware(){
        int count = 0;
        for (HardwareComponent component : hardwareComponents.values()) {
            if(component.getClass().equals(HeavyHardware.class)){
                count++;
            }
        }
        return count;
    }

    public int getDumpedLightSoftware(){
        int count = 0;
        for (HardwareComponent component : hardwareComponents.values()) {
            for (SoftwareComponent softwareComponent : component.getAllSoftwareComponents()) {
                if(softwareComponent.getClass().equals(LightSoftware.class)){
                    count++;
                }
            }
        }
        return count;
    }


    public int getDumpedExpressSoftware(){
        int count = 0;
        for (HardwareComponent component : hardwareComponents.values()) {
            for (SoftwareComponent softwareComponent : component.getAllSoftwareComponents()) {
                if(softwareComponent.getClass().equals(ExpressSoftware.class)){
                    count++;
                }
            }
        }
        return count;
    }

    public void dumpHardwareComponent(HardwareComponent component){
        this.hardwareComponents.put(component.getName(), component);
    }

    public void destroyHardwareComponent(String name){
        this.hardwareComponents.remove(name);
    }

    public HardwareComponent restoreHardwareComponent(String name){
        HardwareComponent componentToReturn = this.hardwareComponents.get(name);
        this.hardwareComponents.remove(name);
        return componentToReturn;
    }

    public int getDumpedMemory(){
        int totalDumpedMemory = 0;
        for (HardwareComponent component : hardwareComponents.values()) {
            for (SoftwareComponent softwareComponent : component.getAllSoftwareComponents()) {
                totalDumpedMemory += softwareComponent.getMemoryUsage();
            }
        }
        return totalDumpedMemory;
    }


    public int getDumpedCapacity(){
        int totalDumpedCapacity = 0;
        for (HardwareComponent component : hardwareComponents.values()) {
            for (SoftwareComponent softwareComponent : component.getAllSoftwareComponents()) {
                totalDumpedCapacity += softwareComponent.getCapacityUsage();
            }
        }
        return totalDumpedCapacity;
    }
}
