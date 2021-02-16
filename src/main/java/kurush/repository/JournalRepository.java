package kurush.repository;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.PageableRepository;
import java.util.UUID;
import kurush.entity.Journal;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface JournalRepository extends PageableRepository<Journal, UUID>
{
}
