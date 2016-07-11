package Views;

import Models.HeavyHardware;
import Models.Interfaces.HardwareComponent;
import Models.Interfaces.SoftwareComponent;
import Models.PowerHardware;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class SystemSplitView implements View {
    private LinkedHashMap<String, PowerHardware> powerHardwareList;
    private LinkedHashMap<String, HeavyHardware> heavyHardwareList;
    private StringBuilder sb;

    public SystemSplitView(LinkedHashMap<String, PowerHardware> powerHardwareList,
                           LinkedHashMap<String, HeavyHardware> heavyHardwareList){

        this.heavyHardwareList = heavyHardwareList;
        this.powerHardwareList = powerHardwareList;
        this.sb = new StringBuilder();
    }

    @Override
    public void render(){
        powerHardwareList.values().forEach(this::renderComponent);

        heavyHardwareList.values().forEach(this::renderComponent);
        System.out.print(sb.toString());
    }

    private void renderComponent(HardwareComponent powerHardware){
        sb.append("Hardware Component - ");
        sb.append(powerHardware.getName());
        sb.append('\n');

        sb.append("Express Software Components - ");
        sb.append(powerHardware.getExpressSoftwareAmount());
        sb.append('\n');

        sb.append("Light Software Components - ");
        sb.append(powerHardware.getLightSoftwareAmount());
        sb.append('\n');

        sb.append("Memory Usage: ");
        sb.append(powerHardware.getUsedMemory());
        sb.append(" / ");
        sb.append(powerHardware.getMemory());
        sb.append('\n');

        sb.append("Capacity Usage: ");
        sb.append(powerHardware.getUsedCapacity());
        sb.append(" / ");
        sb.append(powerHardware.getCapacity());
        sb.append('\n');

        sb.append(powerHardware.getClass().equals(PowerHardware.class) ? "Type: Power\n"
                : "Type: Heavy\n");

        sb.append("Software Components: ");

        String softwareComponents = join(", ", powerHardware.getAllSoftwareComponents());
        sb.append(softwareComponents);
        sb.append('\n');
    }

    private String join(String delimiter, LinkedList<SoftwareComponent> components){
        if(components.size() == 0){
            return "None";
        }
        StringBuilder tempBuilder = new StringBuilder();
        for (int i = 0; i < components.size(); i++) {
            tempBuilder.append(components.get(i).getName());
            if(i != components.size() - 1){
                tempBuilder.append(delimiter);
            }
        }
        return tempBuilder.toString();
    }
}