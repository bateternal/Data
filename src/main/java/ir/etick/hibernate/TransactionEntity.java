package ir.etick.hibernate;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by abolfazl on 9/6/2017.
 */
@Entity
@Table(name = "transaction",catalog = "etick")
public class TransactionEntity {
    private int id;
    private Integer numberAmount;
    private String destination_numberaccount;
    private BankAccountEntity bankAccountEntity;

    @Basic
    @Column(name = "destination_numberaccount", nullable = true, length = 8)
    public String getDestination_numberaccount() {
        return destination_numberaccount;
    }

    public void setDestination_numberaccount(String destination_numberaccount) {
        this.destination_numberaccount = destination_numberaccount;
    }

    @ManyToOne
    public BankAccountEntity getBankAccountEntity() {
        return bankAccountEntity;
    }

    public void setBankAccountEntity(BankAccountEntity bankAccountEntity) {
        this.bankAccountEntity = bankAccountEntity;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "number_amount", nullable = true)
    public Integer getNumberAmount() {
        return numberAmount;
    }

    public void setNumberAmount(Integer numberAmount) {
        this.numberAmount = numberAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionEntity that = (TransactionEntity) o;

        if (id != that.id) return false;
        if (numberAmount != null ? !numberAmount.equals(that.numberAmount) : that.numberAmount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (numberAmount != null ? numberAmount.hashCode() : 0);
        return result;
    }
}
