package model;

/**
 * Created by Yuriy on 23.09.2016.
 * Модуль расчета подачи-уборки вагонов
 */
public class SupplyModule implements CalculationModule {
    private final double[][] dataChart1;
    private final double[][] dataChart2;
    private final double[][] discountChart;
    protected double distance2;
    private double koef;
    private double distance1;
    private int vagonCount;
    private boolean supplyDiscount;
    private boolean oneDaySupply;
    private boolean radIncreace;

    SupplyModule(double[][] dataChart1, double[][] dataChart2, double[][] discountChart) {
        this.dataChart1 = dataChart1;
        this.dataChart2 = dataChart2;
        this.discountChart = discountChart;
    }

    public void setInputData(InputDataCortage data) {
        koef = data.mainKoef;
        distance1 = data.distance1;
        distance2 = data.distance2;
        vagonCount = data.vagonCount;
        supplyDiscount = data.supplyDiscount;
        oneDaySupply = data.oneDaySupply;
        radIncreace = data.radIncreace;

    }

    public double getCalculation() {
        return 0;
    }

    public String getFormula() {
        return "";
    }

    private double getDataFromChart(double distance, int vagonCount, double[][] chart) {
        if(distance == 0)
            return 0;
        double[] row = null;
        //Определение рядка
        for(double[] d: chart){
            if(d[0] <=vagonCount)
                row = d;
        }
        return 0;
    }
    /*
     * Получение скидки за подачу-уборку
     */
    private double getDiscount(int vagonCount){
        if(vagonCount == 0)
            return 0;
        for(double[] line: discountChart){
            if(line[0] <= vagonCount)
                return line[1];
        }
        //Возврат значения последней строки
        return discountChart[discountChart.length-1][1];
    }
}
