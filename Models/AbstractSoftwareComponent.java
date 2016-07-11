package Models;

import Models.Interfaces.SoftwareComponent;

public abstract class AbstractSoftwareComponent implements SoftwareComponent {
    private String name;
    private int capacityUsage;
    private int memoryUsage;

    public AbstractSoftwareComponent(String name, int capacityUsage, int memoryUsage) {
        this.setName(name);
        this.setCapacityUsage(capacityUsage);
        this.setMemoryUsage(memoryUsage);
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getCapacityUsage() {
        return capacityUsage;
    }

    protected void setCapacityUsage(int capacityUsage) {
        this.capacityUsage = capacityUsage;
    }

    public int getMemoryUsage() {
        return memoryUsage;
    }

    protected void setMemoryUsage(int memoryUsage) {
        this.memoryUsage = memoryUsage;
    }
}
