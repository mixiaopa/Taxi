package OO;

public interface TransformTool {
    public double convertMilesToInteger(double distanceDecimal);
    public double getFee(double distance, int stopTime);
    public String getFinalCharge(int distance, int stopTime);
}
