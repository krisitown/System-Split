package Models;

import Models.Interfaces.HardwareComponent;
import Models.Interfaces.SoftwareComponent;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public abstract class AbstractHardwareComponent implements HardwareComponent{
    private String name;
    private int capacity;
    private int memory;
    private LinkedList<SoftwareComponent> softwareComponents;
    private LinkedHashMap<String, ExpressSoftware> expressSoftwareList;
    private LinkedHashMap<String, LightSoftware> lightSoftwareList;

    public AbstractHardwareComponent(String name, int capacity, int memory) {
        this.setName(name);
        this.setCapacity(capacity);
        this.setMemory(memory);
        softwareComponents = new LinkedList<>();
        expressSoftwareList = new LinkedHashMap<>();
        lightSoftwareList = new LinkedHashMap<>();
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    protected void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int getMemory() {
        return memory;
    }

    protected void setMemory(int memory) {
        this.memory = memory;
    }

    public boolean addSoftwareComponent(SoftwareComponent component){
        if(this.getMemory() - this.getUsedMemory() >= component.getMemoryUsage() &&
                this.getCapacity() - this.getUsedCapacity() >= component.getCapacityUsage()){
            if(component.getClass().equals(LightSoftware.class)){
                this.lightSoftwareList.put(component.getName(), (LightSoftware)component);
            } else {
                this.expressSoftwareList.put(component.getName(), (ExpressSoftware)component);
            }
            this.softwareComponents.add(component);
            return true;
        }
        return false;
    }

    public void releaseSoftwareComponent(String name){
        SoftwareComponent componentToRelease = findSoftwareComponent(name);
        if(componentToRelease.getClass().equals(ExpressSoftware.class)){
            this.expressSoftwareList.remove(name);
        } else {
            this.lightSoftwareList.remove(name);
        }
        this.softwareComponents.remove(componentToRelease);
    }

    private SoftwareComponent findSoftwareComponent(String name){
        for (SoftwareComponent softwareComponent : softwareComponents) {
            if(softwareComponent.getName().equals(name)){
                return softwareComponent;
            }
        }
        return null;
    }

    public int getLightSoftwareAmount(){
        return this.lightSoftwareList.size();
    }

    public int getExpressSoftwareAmount(){
        return this.expressSoftwareList.size();
    }

    @Override
    public int getUsedCapacity(){
        int usedCapacity = 0;
        for (SoftwareComponent softwareComponent : softwareComponents) {
            usedCapacity += softwareComponent.getCapacityUsage();
        }
        return usedCapacity;
    }

    @Override
    public int getUsedMemory(){
        int usedMemory = 0;
        for (SoftwareComponent softwareComponent : softwareComponents) {
            usedMemory += softwareComponent.getMemoryUsage();
        }
        return usedMemory;
    }

    @Override
    public LinkedList<SoftwareComponent> getAllSoftwareComponents() {
        return this.softwareComponents;
    }
}
