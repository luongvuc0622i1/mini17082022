package material;

import java.time.LocalDate;

public class CrispyFlour extends Material implements Discount {
    private double quantity;

    public CrispyFlour(double quantity) {
        this.quantity = quantity;
    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, double quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    @Override
    public double getAmount() {
        return quantity * getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusYears(1);
    }

    @Override
    public double getRealMoney() {
        double calculatorDays = LocalDate.now().compareTo(getManufacturingDate());
        if (calculatorDays > 120) {
            return getAmount()*60/100;
        } else if (calculatorDays > 60) {
            return getAmount()*80/100;
        } else {
            return getAmount()*95/100;
        }
    }

    @Override
    public String toString() {
        return "CrispyFlour{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", manufacturingDate=" + getManufacturingDate() +
                ", cost=" + getCost() +
                ", quantity=" + quantity +
                '}';
    }
}
