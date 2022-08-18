package material;

import java.time.LocalDate;

public class Meat extends Material implements Discount {
    private double weight;

    public Meat(double weight) {
        this.weight = weight;
    }

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    @Override
    public double getAmount() {
        return this.weight * getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusDays(7);
    }

    @Override
    public double getRealMoney() {
        double calculatorDays = LocalDate.now().compareTo(getManufacturingDate());
        if (calculatorDays < 5) {
            return getAmount()*90/100;
        } else {
            return getAmount()*70/100;
        }
    }

    @Override
    public String toString() {
        return "Meat{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", manufacturingDate=" + getManufacturingDate() +
                ", cost=" + getCost() +
                ", weight=" + weight +
                '}';
    }
}
