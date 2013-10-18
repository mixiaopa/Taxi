package OO;

import java.math.BigDecimal;

public class Taxi implements TransformTool{

    public double getFee(double distance, int stopTime) {
        double finalFee = TaxiConstants.FLAG_FEE;
        if (distance > TaxiConstants.FAR_DISTANCE_MILES)
            finalFee = TaxiConstants.FLAG_FEE_FOR_FAR_DISTANCE + (distance - TaxiConstants.FAR_DISTANCE_MILES) * TaxiConstants.RATE_FOR_FAR_DISTANCE;
        if (TaxiConstants.FLAG_MILES < distance && distance <= TaxiConstants.FAR_DISTANCE_MILES) {
            finalFee = TaxiConstants.FLAG_FEE + (distance - TaxiConstants.FLAG_MILES) * TaxiConstants.RATE_FOR_SHORT_DISTANCE;
        }
        if (stopTime > 0)
            finalFee += TaxiConstants.STOP_TIME_FEE * stopTime;
        return finalFee;
    }

    public String getFinalCharge(int distance, int stopTime) {
        String finalFee = new BigDecimal(getFee(distance, stopTime)).setScale(0, BigDecimal.ROUND_HALF_UP).toString();
        return finalFee;
    }

    public double convertMilesToInteger(double distanceDecimal) {
        return Math.ceil(distanceDecimal);
    }
}
