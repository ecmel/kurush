package kurush.entity;

import io.micronaut.data.annotation.AutoPopulated;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import io.micronaut.data.annotation.Relation.Kind;
import java.math.BigDecimal;
import java.util.UUID;
import javax.validation.constraints.NotNull;

@MappedEntity
public class Entry
{
    private UUID id;
    private Transfer transfer;
    private Account account;
    private BigDecimal amount;
    private BigDecimal debit;
    private BigDecimal credit;

    @Id
    @AutoPopulated
    public UUID getId()
    {
        return id;
    }

    public void setId(UUID id)
    {
        this.id = id;
    }

    @NotNull
    @Relation(value = Kind.MANY_TO_ONE)
    public Transfer getTransfer()
    {
        return transfer;
    }

    public void setTransfer(Transfer transfer)
    {
        this.transfer = transfer;
    }

    @NotNull
    @Relation(value = Kind.MANY_TO_ONE)
    public Account getAccount()
    {
        return account;
    }

    public void setAccount(Account account)
    {
        this.account = account;
    }

    @NotNull
    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    @NotNull
    public BigDecimal getDebit()
    {
        return debit;
    }

    public void setDebit(BigDecimal debit)
    {
        this.debit = debit;
    }

    @NotNull
    public BigDecimal getCredit()
    {
        return credit;
    }

    public void setCredit(BigDecimal credit)
    {
        this.credit = credit;
    }

    @Override
    public String toString()
    {
        return "Entry [account=" + account + ", credit=" + credit + ", debit=" + debit + ", id=" + id + ", transfer="
            + transfer + "]";
    }
}
