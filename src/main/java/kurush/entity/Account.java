package kurush.entity;

import io.micronaut.data.annotation.AutoPopulated;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import io.micronaut.data.annotation.Relation.Kind;
import io.micronaut.data.jdbc.annotation.ColumnTransformer;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedEntity
public class Account
{
    private UUID id;
    private Journal journal;
    private String code;
    private String name;

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
    public Journal getJournal()
    {
        return journal;
    }

    public void setJournal(Journal journal)
    {
        this.journal = journal;
    }

    @NotNull
    @Size(min = 1, max = 255)
    @ColumnTransformer(read = "ltree2text(code)", write = "text2ltree(?)")
    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    @NotNull
    @Size(min = 3, max = 255)
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Account [code=" + code + ", id=" + id + ", journal=" + journal + ", name=" + name + "]";
    }
}
