package Controllers;

import Models.ExpressSoftware;
import Models.HeavyHardware;
import Models.LightSoftware;
import Models.PowerHardware;
import Utils.DataLayer;
import Views.AnalyzeView;
import Views.DumpAnalyzeView;
import Views.SystemSplitView;

public class MainController {
    private DataLayer dataLayer;

    public MainController(){
        dataLayer = new DataLayer();
    }

    public void systemSplit(){
        SystemSplitView view = new SystemSplitView(dataLayer.getAllPowerHardware(),
                dataLayer.getAllHeavyHardware());
        view.render();
    }


    //methods named in pascal case to make reflection easier
    public void RegisterPowerHardware(String[] params){
        PowerHardware powerHardware = new PowerHardware(params[0], Integer.parseInt(params[1]),
                Integer.parseInt(params[2]));
        dataLayer.addHardwareComponent(powerHardware);
    }

    public void RegisterHeavyHardware(String[] params){
        HeavyHardware heavyHardware = new HeavyHardware(params[0], Integer.parseInt(params[1]),
                Integer.parseInt(params[2]));
        dataLayer.addHardwareComponent(heavyHardware);
    }

    public void RegisterExpressSoftware(String[] params){
        ExpressSoftware expressSoftware = new ExpressSoftware(params[1], Integer.parseInt(params[2]),
                Integer.parseInt(params[3]));
        if(dataLayer.getHardwareComponent(params[0]).addSoftwareComponent(expressSoftware)){
            dataLayer.addSoftwareComponent(expressSoftware);
        }
    }

    public void RegisterLightSoftware(String[] params){
        LightSoftware lightSoftware = new LightSoftware(params[1], Integer.parseInt(params[2]),
                Integer.parseInt(params[3]));
        if(dataLayer.getHardwareComponent(params[0]).addSoftwareComponent(lightSoftware)){
            dataLayer.addSoftwareComponent(lightSoftware);
        }
    }

    public void ReleaseSoftwareComponent(String[] params){
        dataLayer.removeSoftwareComponent(params[0], params[1]);
    }

    public void Analyze(String[] params){
        AnalyzeView view = new AnalyzeView(dataLayer.getAllHardwareComponents(),
                dataLayer.getAllSoftwareComponents());
        view.render();
    }

    public void Dump(String[] params){
        dataLayer.dumpHardwareComponent(params[0]);
    }

    public void Restore(String[] params){
        dataLayer.restoreHardwareComponent(params[0]);
    }

    public void Destroy(String[] params){
        dataLayer.destroyHardwareComponent(params[0]);
    }

    public void DumpAnalyze(String[] params){
        DumpAnalyzeView view = new DumpAnalyzeView(dataLayer.getDump());
        view.render();
    }
}
