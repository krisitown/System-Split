package Models.Interfaces;
import java.util.LinkedList;

public interface HardwareComponent extends Component {
    int getCapacity();
    int getMemory();

    boolean addSoftwareComponent(SoftwareComponent softwareComponent);
    void releaseSoftwareComponent(String name);

    int getLightSoftwareAmount();
    int getExpressSoftwareAmount();

    int getUsedMemory();
    int getUsedCapacity();

    LinkedList<SoftwareComponent> getAllSoftwareComponents();
}
