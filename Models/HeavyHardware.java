package Models;

public class HeavyHardware extends AbstractHardwareComponent {
    public HeavyHardware(String name, int capacity, int memory) {
        super(name, capacity, memory);
    }

    @Override
    protected void setCapacity(int capacity) {
        int actualCapacity = capacity * 2;
        super.setCapacity(actualCapacity);
    }

    @Override
    protected void setMemory(int memory) {
        int actualMemory = memory - (memory/4);
        super.setMemory(actualMemory);
    }
}
