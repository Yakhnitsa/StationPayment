package model;

/**
 * Created by Yuriy on 23.09.2016.
 * Модуль расчета платы за взвешивание и участие представителя при взвешивании:
 */
public class WeightingModule implements CalculationModule{
    private double tarifKoef;
    private int vagCount;
    private boolean weighting;
    private boolean agentPart;
    private boolean radIncreace;

    private double weightRate;
    private double agentPartRate;
    private double radKoef;

    @Override
    public void setInputData(InputDataCortage inputData) {
        tarifKoef = inputData.mainKoef;
        vagCount = inputData.vagonCount;
        weighting = inputData.weighting;
        agentPart = inputData.agentPart;
        radIncreace = inputData.radIncreace;
        weightRate = inputData.WEIGHTING_RATE;
        agentPartRate = inputData.AGENT_PART_RATE;
        radKoef = radIncreace ? inputData.RADIATION_KOEF_WEIGHTING : 1;
    }

    @Override
    public double getCalculation() {
        double weightingPayment=0;
        if(weighting){
            weightingPayment = MainModel.round(weightRate*2* tarifKoef * radKoef,10)* vagCount ;
        }

        double agentPayment = 0;
        if(agentPart)
            agentPayment = MainModel.round(agentPartRate * tarifKoef * radKoef,10);
        return weightingPayment + agentPayment;
    }

    @Override
    public String getFormula() {
        if(!weighting)
            return " 0 ";
        else if(!agentPart){
            return String.format("(%.2f * 2 * %.3f * %.2f) * %d ваг = %.2f без НДС",weightRate,tarifKoef,radKoef,vagCount,getCalculation());
        }
        else{
            return String.format("(%1$.2f * 2 * %2$.3f * %3$.2f) * %4$d ваг + (%5$.2f * 2 * %2$.3f * %3$.2f) = %6$.2f без НДС",
                    weightRate,tarifKoef,radKoef,vagCount,agentPartRate,getCalculation());
        }
    }
}
