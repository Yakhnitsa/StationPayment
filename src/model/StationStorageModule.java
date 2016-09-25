package model;

/**
 * Created by Yuriy on 23.09.2016.
 * Модуль расчета платы за хранение груза в вагонах
 */
public class StationStorageModule implements CalculationModule {
    private int storPaym;
    private double koef;
    private int vagCount;
    private int storageTime;
    private int goodsWeight;

    @Override
    public void setInputData(InputDataCortage data){
        storPaym = data.STORAGE_PAYMENT;
        koef = data.mainKoef;
        vagCount = data.vagonCount;
        storageTime = data.storageTime;
        goodsWeight = data.goodsWeight;
    }

    @Override
    public double getCalculation() {
        return MainModel.round(storPaym * koef * goodsWeight,10) * storageTime* vagCount;
    }

    @Override
    public String getFormula() {
        if(vagCount <=0) return "0";

        else{
            return String.format("(%d * %.3f * %d тонн) * %d сут * %d ваг = %.2f грн без НДС",storPaym,koef,goodsWeight,storageTime, vagCount,getCalculation());
        }
    }

}
