package kurush.entity;

import io.micronaut.data.annotation.AutoPopulated;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import io.micronaut.data.annotation.Relation.Kind;
import java.util.Date;
import java.util.UUID;
import javax.validation.constraints.NotNull;

@MappedEntity
public class Transfer
{
    private UUID id;
    private Journal journal;
    private Date date;

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
    @Relation(value = Kind.MANY_TO_ONE, mappedBy = "journal")
    public Journal getJournal()
    {
        return journal;
    }

    public void setJournal(Journal journal)
    {
        this.journal = journal;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    @Override
    public String toString()
    {
        return "Transfer [date=" + date + ", id=" + id + ", journal=" + journal + "]";
    }
}
