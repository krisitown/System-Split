package Models;

public class LightSoftware extends  AbstractSoftwareComponent{
    public LightSoftware(String name, int capacityUsage, int memoryUsage) {
        super(name, capacityUsage, memoryUsage);
    }

    @Override
    protected void setCapacityUsage(int capacityUsage) {
        int actualCapacityUsage = capacityUsage + (capacityUsage/2);
        super.setCapacityUsage(actualCapacityUsage);
    }

    @Override
    protected void setMemoryUsage(int memoryUsage) {
        int actualMemoryUsage = memoryUsage - (memoryUsage/2);
        super.setMemoryUsage(actualMemoryUsage);
    }
}
