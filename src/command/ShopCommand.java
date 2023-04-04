package command;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * shopCommand
 */
public interface ShopCommand {
    public abstract void excute(HttpRequest request, HttpResponse<String> response);
}
