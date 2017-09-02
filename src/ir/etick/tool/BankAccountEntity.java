package ir.etick.tool;

import javax.persistence.*;

/**
 * Created by abolfazl on 9/2/2017.
 */
@Entity
@Table(name = "bank_account", schema = "etick")
public class BankAccountEntity {
    private int id;
    private String numberAccount;

    @Id
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
