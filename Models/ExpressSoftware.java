package Models;

public class ExpressSoftware extends AbstractSoftwareComponent {
    public ExpressSoftware(String name, int capacityUsage, int memoryUsage) {
        super(name, capacityUsage, memoryUsage);
    }

    @Override
    protected void setMemoryUsage(int memoryUsage) {
        int actualMemoryUsage = memoryUsage * 2;
        super.setMemoryUsage(actualMemoryUsage);
    }
}
