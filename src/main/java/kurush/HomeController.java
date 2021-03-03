package kurush;

import static io.micronaut.core.util.CollectionUtils.*;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.View;

@Controller("/")
public class HomeController
{
    @Get
    @View("home")
    public HttpResponse<?> home()
    {
        return HttpResponse.ok(mapOf("title", "Kurush"));
    }
}
