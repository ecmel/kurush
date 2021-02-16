package kurush.repository;

import io.micronaut.data.annotation.Join;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.Sort;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.PageableRepository;
import java.util.UUID;
import kurush.entity.Account;
import kurush.entity.Entry;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface EntryRepository extends PageableRepository<Entry, UUID>
{
   @Join("transfer")
   @Join("account")
   @Override
   Iterable<Entry> findAll(Sort sort);

   @Join("transfer")
   @Join("account")
   Iterable<Entry> findByAccount(Account account, Sort sort);
}
