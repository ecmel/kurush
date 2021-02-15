package kurush;

import static io.micronaut.core.util.CollectionUtils.*;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Error;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
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

    @View("error")
    @Error(global = true)
    @Produces(MediaType.TEXT_HTML)
    public HttpResponse<?> serverError(HttpRequest<?> request, Throwable e)
    {
        return HttpResponse.serverError(mapOf("status", 500, "message", e.getMessage()));
    }

    @View("error")
    @Error(global = true, status = HttpStatus.NOT_FOUND)
    @Produces(MediaType.TEXT_HTML)
    public HttpResponse<?> notFound(HttpRequest<?> request)
    {
        return HttpResponse.notFound(mapOf("status", 404));
    }

    @View("error")
    @Error(global = true, status = HttpStatus.UNAUTHORIZED)
    @Produces(MediaType.TEXT_HTML)
    public HttpResponse<?> unauthorized(HttpRequest<?> request)
    {
        return HttpResponse.unauthorized().body(mapOf("status", 401));
    }
}
