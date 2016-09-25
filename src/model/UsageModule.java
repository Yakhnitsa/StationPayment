package model;

/**
 * Created by Yuriy on 23.09.2016.
 */
public class UsageModule implements CalculationModule {
    private final double[] paymentChart;
    private double tarifKoef;
    private int vagonCount;
    private int usageTime;

    UsageModule(double[] paymentChart) {
        this.paymentChart = paymentChart;
    }

    @Override
    public void setInputData(InputDataCortage inputData) {
        tarifKoef = inputData.mainKoef;
        vagonCount = inputData.vagonCount;
        usageTime = inputData.usageTime;
    }

    @Override
    public double getCalculation() {
        return MainModel.round(getDataFromChart(usageTime) * tarifKoef, 10) * vagonCount;
    }

    @Override
    public String getFormula() {
        int overTime = usageTime - paymentChart.length + 1;
        if (overTime <= 0) {
            return String.format("(%.2f * %.3f) * %d ваг = %.2f грн без НДС", getDataFromChart(usageTime), tarifKoef, vagonCount, getCalculation());
        } else {
            return String.format("(%.2f + %.0f * %d час) * %.3f * %d ваг = %.2f грн без НДС",
                    getDataFromChart(usageTime - overTime), paymentChart[paymentChart.length - 1], overTime, tarifKoef, vagonCount, getCalculation());
        }
    }

    private double getDataFromChart(int time) {
        int overTime = time - paymentChart.length + 1;
        if (overTime <= 0) {
            return paymentChart[time - 1];
        } else {
            return getDataFromChart(time - overTime) + getPaymentOvertime(overTime);
        }

    }

    private double getPaymentOvertime(int overTime) {
        return overTime * paymentChart[paymentChart.length - 1];
    }
}
