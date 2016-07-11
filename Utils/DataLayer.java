package Utils;

import Models.HeavyHardware;
import Models.Interfaces.HardwareComponent;
import Models.Interfaces.SoftwareComponent;
import Models.PowerHardware;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class DataLayer {
    private LinkedHashMap<String, HardwareComponent> hardwareComponents;
    private LinkedHashMap<String, PowerHardware> powerHardwareComponents;
    private LinkedHashMap<String, HeavyHardware> heavyHardwareComponents;
    private Dump dump;

    private LinkedList<SoftwareComponent> softwareComponents;

    public DataLayer(){
        hardwareComponents = new LinkedHashMap<>();
        softwareComponents = new LinkedList<>();

        heavyHardwareComponents = new LinkedHashMap<>();
        powerHardwareComponents = new LinkedHashMap<>();

        dump = new Dump();
    }

    public void addHardwareComponent(HardwareComponent hardwareComponent){
        if(hardwareComponent == null){
            throw new IllegalArgumentException("Invalid hardware component tried to be added in the database");
        }
        this.hardwareComponents.put(hardwareComponent.getName(), hardwareComponent);
        if(hardwareComponent.getClass().equals(PowerHardware.class)){
            this.powerHardwareComponents.put(hardwareComponent.getName(),
                    (PowerHardware)hardwareComponent);
        } else {
            this.heavyHardwareComponents.put(hardwareComponent.getName(),
                    (HeavyHardware)hardwareComponent);
        }

    }

    public HardwareComponent getHardwareComponent(String name){

        return this.hardwareComponents.get(name);
    }

    public LinkedHashMap<String, HardwareComponent> getAllHardwareComponents(){
        return this.hardwareComponents;
    }

    public void addSoftwareComponent(SoftwareComponent softwareComponent){
        this.softwareComponents.add(softwareComponent);
    }

    public void removeSoftwareComponent(String hardwareName, String softwareName){
        SoftwareComponent componentToRemove = findSoftwareComponent(softwareName);
        if(this.hardwareComponents.get(hardwareName).getClass().equals(HeavyHardware.class)){
            this.heavyHardwareComponents.get(hardwareName).releaseSoftwareComponent(softwareName);
        } else {
            this.powerHardwareComponents.get(hardwareName).releaseSoftwareComponent(softwareName);
        }
        this.hardwareComponents.get(hardwareName).releaseSoftwareComponent(softwareName);
        this.softwareComponents.remove(componentToRemove);
    }

    private SoftwareComponent findSoftwareComponent(String name){
        for (SoftwareComponent component : softwareComponents) {
            if(component.getName().equals(name)){
                return component;
            }
        }
        return null;
    }

    public LinkedList<SoftwareComponent> getAllSoftwareComponents(){
        return this.softwareComponents;
    }

    public LinkedHashMap<String, PowerHardware> getAllPowerHardware(){
        return this.powerHardwareComponents;
    }

    public LinkedHashMap<String, HeavyHardware> getAllHeavyHardware(){
        return this.heavyHardwareComponents;
    }

    public void dumpHardwareComponent(String name){
        HardwareComponent componentToDump = this.hardwareComponents.get(name);
        this.hardwareComponents.remove(name);
        if(componentToDump.getClass().equals(PowerHardware.class)){
            this.powerHardwareComponents.remove(componentToDump.getName());
        } else {
            this.heavyHardwareComponents.remove(componentToDump.getName());
        }
        for (SoftwareComponent softwareComponent : componentToDump.getAllSoftwareComponents()) {
            this.softwareComponents.remove(softwareComponent);
        }
        this.dump.dumpHardwareComponent(componentToDump);
    }

    public void destroyHardwareComponent(String name){
        this.dump.destroyHardwareComponent(name);
    }

    public void restoreHardwareComponent(String name){
        HardwareComponent componentToRestore = dump.restoreHardwareComponent(name);
        this.hardwareComponents.put(componentToRestore.getName(), componentToRestore);
        this.softwareComponents.addAll(componentToRestore.getAllSoftwareComponents().stream().collect(Collectors.toList()));
    }

    public Dump getDump(){
        return dump;
    }


}
