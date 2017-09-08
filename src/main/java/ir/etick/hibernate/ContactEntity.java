package ir.etick.hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by abolfazl on 9/6/2017.
 */
@Entity
@Table(name = "contact",catalog = "etick")
public class ContactEntity {
    private int id;
    private String mellicode;
    private String firstName;
    private String lastName;
    private Set<BankAccountEntity> bankAccountEntity = new HashSet<BankAccountEntity>(
            0);


    @OneToMany(mappedBy = "contactEntity", cascade = CascadeType.ALL)
    public Set<BankAccountEntity> getBankAccountEntity() {
        return  this.bankAccountEntity;
    }

    public void setBankAccountEntity(Set<BankAccountEntity> bankAccountEntity) {
        this.bankAccountEntity =  bankAccountEntity;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column( name = "id",nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "mellicode", nullable = true, length = 12)
    public String getMellicode() {
        return mellicode;
    }

    public void setMellicode(String mellicode) {
        this.mellicode = mellicode;
    }

    @Basic
    @Column(name = "first_name", nullable = true, length = 30)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = 30)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactEntity that = (ContactEntity) o;

        if (id != that.id) return false;
        if (mellicode != null ? !mellicode.equals(that.mellicode) : that.mellicode != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (mellicode != null ? mellicode.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
