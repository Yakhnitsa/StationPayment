package model;

/**
 * Created by Yuriy on 24.09.2016.
 */
public class Test {
    public static void main(String[] args){
        InputDataCortage data = new InputDataCortage(2.302,5, 1.2, 1.1, 2,48,12,65,false,true,false,true,false);

        StationStorageModule storageModule = new StationStorageModule();
        storageModule.setInputData(data);
        System.out.println(storageModule.getFormula());

        WeightingModule weightingModule = new WeightingModule();
        weightingModule.setInputData(data);
        System.out.println(weightingModule.getFormula());

        double[] vagUsageChart = {0.8,1.6, 2.4,3.2,4.5,5.8,7.1,8.4,9.7,11,12.3,13.6,14.9,16.2,17.5,18.8,20.1,21.4,22.7,24,25.3,26.6,27.9,
                29.2, 32.7, 36.2,39.7,43.2,46.7,50.2,53.7,57.2,60.7,64.2,67.7,71.2,82.7,95.7,110.2,126.2,142.2,158.2,174.2,190.2,206.2,16};
//        System.out.println(vagUsageChart.length);
        UsageModule usageModule = new UsageModule(vagUsageChart);
        usageModule.setInputData(data);
        System.out.println(usageModule.getFormula());
    }
}
