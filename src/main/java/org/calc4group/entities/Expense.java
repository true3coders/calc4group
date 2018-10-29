package org.calc4group.entities;

import lombok.Data;
import org.calc4group.entities.splitTypes.AbstractSplitType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.Map;

@Entity
@Data
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String description;

    private Long totalAmount;

    // TODO: 29.10.2018 Should be changet to Map<User, Long> to define all users who pay
    private User whoPaid;

    // TODO: 29.10.2018 should be th Map <User Amount(equally, amount, %)>
    // TODO: 29.10.2018 think about
    private List<User> paidFor;


    public void setWhoPaid(User whoPaid) {
        this.whoPaid = whoPaid;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setPaidFor(List<User> paidFor) {
        this.paidFor = paidFor;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", totalAmount=" + totalAmount +
                ", whoPaid=" + whoPaid +
                ", paidFor=" + paidFor +
                '}';
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
