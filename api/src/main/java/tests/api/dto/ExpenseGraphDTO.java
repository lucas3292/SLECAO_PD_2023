package tests.api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExpenseGraphDTO {
    private LocalDate dayExpense;
    private BigDecimal val;
    public LocalDate getDayExpense() {
        return dayExpense;
    }
    public void setDayExpense(LocalDate dayExpense) {
        this.dayExpense = dayExpense;
    }
    public BigDecimal getVal() {
        return val;
    }
    public void setVal(BigDecimal val) {
        this.val = val;
    }
        
}
