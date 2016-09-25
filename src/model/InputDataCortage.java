package model;

/**
 * Created by Yuriy on 23.09.2016.
 * Класс для передачи информации между модулями
 */
public class InputDataCortage {
    public final double RADIATION_KOEF_WEIGHTING = 1.2;
    public final double RADIATION_KOEF_SUPPLY = 1.1;
    double MANEVER_PAYMENT = 292.6;
    double WEIGHTING_RATE = 75.2;
    double AGENT_PART_RATE = 66.2;
    int STORAGE_PAYMENT = 4;

    public final double mainKoef;
    public final int vagonCount;

    public final double distance1;
    public final double distance2;
    public final boolean oneDaySupply;

    public final double manevringTime;
    public final int usageTime;
    public final int storageTime;
    public final int goodsWeight;
    public final boolean radIncreace;
    public final boolean supplyDiscount;

    public final boolean weighting;
    public final boolean agentPart;

    public InputDataCortage(double mainKoef, int vagonCount, double distance1, double distance2, double manevringTime, int usageTime, int storageTime, int goodsWeight, boolean radiationKoef, boolean supplyDiscount, boolean oneDaySupply, boolean weighting, boolean agentPart) {
        this.mainKoef = mainKoef;
        this.vagonCount = vagonCount;
        this.distance1 = distance1;
        this.distance2 = distance2;
        this.manevringTime = manevringTime;
        this.usageTime = usageTime;
        this.storageTime = storageTime;
        this.goodsWeight = goodsWeight;
        this.radIncreace = radiationKoef;
        this.supplyDiscount = supplyDiscount;
        this.oneDaySupply = oneDaySupply;
        this.weighting = weighting;
        this.agentPart = agentPart;
    }
}
