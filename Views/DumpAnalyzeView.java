package Views;

import Utils.Dump;

public class DumpAnalyzeView implements View {
    private Dump dump;

    public DumpAnalyzeView(Dump dump){
        this.dump = dump;
    }

    public void render(){
        StringBuilder sb = new StringBuilder();

        sb.append("Dump Analysis\n");
        sb.append("Power Hardware Components: ");
        sb.append(dump.getDumpedPowerHardware());
        sb.append('\n');

        sb.append("Heavy Hardware Components: ");
        sb.append(dump.getDumpedHeavyHardware());
        sb.append('\n');

        sb.append("Express Software Components: ");
        sb.append(dump.getDumpedExpressSoftware());
        sb.append('\n');

        sb.append("Light Software Components: ");
        sb.append(dump.getDumpedLightSoftware());
        sb.append('\n');

        sb.append("Total Dumped Memory: ");
        sb.append(dump.getDumpedMemory());
        sb.append('\n');

        sb.append("Total Dumped Capacity: ");
        sb.append(dump.getDumpedCapacity());
        sb.append('\n');

        System.out.print(sb.toString());
    }
}