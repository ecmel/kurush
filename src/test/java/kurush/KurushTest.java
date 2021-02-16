package kurush;

import static org.junit.jupiter.api.Assertions.*;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;

@MicronautTest
class KurushTest
{
    @Inject
    EmbeddedApplication<?> application;

    @Test
    void testItWorks()
    {
        assertTrue(application.isRunning());
    }
}
