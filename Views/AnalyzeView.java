package Views;

import Models.Interfaces.HardwareComponent;
import Models.Interfaces.SoftwareComponent;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class AnalyzeView implements View {
    int countOfHardwareComponents;
    int countOfSoftwareComponents;
    int totalOprataionMemoryInUse;
    int maximumMemory;
    int totalCapacityTaken;
    int maximumCapacity;

    public AnalyzeView(LinkedHashMap<String, HardwareComponent> hardwareComponents,
                       LinkedList<SoftwareComponent> softwareComponents) {
        countOfHardwareComponents = hardwareComponents.size();
        countOfSoftwareComponents = softwareComponents.size();

        totalOprataionMemoryInUse = 0;
        maximumMemory = 0;
        totalCapacityTaken = 0;
        maximumCapacity = 0;

        for (HardwareComponent component : hardwareComponents.values()) {
            maximumMemory += component.getMemory();
            maximumCapacity += component.getCapacity();
        }

        for (SoftwareComponent component : softwareComponents) {
            totalCapacityTaken += component.getCapacityUsage();
            totalOprataionMemoryInUse += component.getMemoryUsage();
        }
    }

    @Override
    public void render(){
        StringBuilder sb = new StringBuilder();
        sb.append("System Analysis\n");

        sb.append("Hardware Components: ");
        sb.append(countOfHardwareComponents);
        sb.append('\n');

        sb.append("Software Components: ");
        sb.append(countOfSoftwareComponents);
        sb.append('\n');

        sb.append("Total Operational Memory: ");
        sb.append(totalOprataionMemoryInUse);
        sb.append(" / ");
        sb.append(maximumMemory);
        sb.append('\n');

        sb.append("Total Capacity Taken: ");
        sb.append(totalCapacityTaken);
        sb.append(" / ");
        sb.append(maximumCapacity);
        sb.append('\n');

        System.out.print(sb.toString());
    }
}
