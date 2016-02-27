package hack.sport.healthapp.hack.sport.healthapp.models;

public class MetricsModel {

    private String unit;
    private double metricValue;
    private String metricValueType;

    public MetricsModel(String unit, double metricValue, String metricValueType) {
        this.unit = unit;
        this.metricValue = metricValue;
        this.metricValueType = metricValueType;
    }

    public MetricsModel() {
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getMetricValue() {
        return metricValue;
    }

    public void setMetricValue(double metricValue) {
        this.metricValue = metricValue;
    }

    public String getMetricValueType() {
        return metricValueType;
    }

    public void setMetricValueType(String metricValueType) {
        this.metricValueType = metricValueType;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MetricsModel{");
        sb.append("unit='").append(unit).append('\'');
        sb.append(", metricValue=").append(metricValue);
        sb.append(", metricValueType='").append(metricValueType).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
