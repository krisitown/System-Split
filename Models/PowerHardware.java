package Models;

public class PowerHardware extends AbstractHardwareComponent{
    public PowerHardware(String name, int capacity, int memory) {
        super(name, capacity, memory);
    }

    @Override
    protected void setCapacity(int capacity) {
        int actualCapacity = capacity - ((capacity*3)/4);
        super.setCapacity(actualCapacity);
    }

    @Override
    protected void setMemory(int memory) {
        int actualMemory =  memory + ((memory*3)/4);
        super.setMemory(actualMemory);
    }
}
