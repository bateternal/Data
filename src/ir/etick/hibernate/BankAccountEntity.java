package ir.etick.hibernate;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by abolfazl on 9/6/2017.
 */
@Entity
@Table(name = "bank_account" , catalog = "etick")
public class BankAccountEntity {
    private int id;
    private String numberAccount;
    private CardEntity cardEntity;
    private TransactionEntity transactionEntity;
    private ContactEntity contactEntity;

    @ManyToOne
    public ContactEntity getContactEntity() {
        return contactEntity;
    }


    public void setContactEntity(ContactEntity contactEntity) {
        this.contactEntity = contactEntity;
    }

    @OneToMany(mappedBy = "bankAccountEntity", cascade = CascadeType.ALL)
    public Set<CardEntity> getCardEntity() {
        return (Set<CardEntity>) cardEntity;
    }

    @OneToMany(mappedBy = "bankAccountEntity", cascade = CascadeType.ALL)
    public Set<TransactionEntity> getTransactionEntity() {
        return (Set<TransactionEntity>) transactionEntity;
    }

    public void setCardEntity(Set<CardEntity> cardEntity) {
        this.cardEntity = (CardEntity) cardEntity;
    }

    public void setTransactionEntity(Set<TransactionEntity> transactionEntity) {
        this.transactionEntity = (TransactionEntity) transactionEntity;
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
    @Column(name = "Number_Account", nullable = true, length = 8)
    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankAccountEntity that = (BankAccountEntity) o;

        if (id != that.id) return false;
        if (numberAccount != null ? !numberAccount.equals(that.numberAccount) : that.numberAccount != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (numberAccount != null ? numberAccount.hashCode() : 0);
        return result;
    }
}
