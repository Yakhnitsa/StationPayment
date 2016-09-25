package model;

/**
 * Created by Yuriy on 24.09.2016.
 */
public interface CalculationModule {
    void setInputData(InputDataCortage cortage);
    double getCalculation();
    String getFormula();
}
