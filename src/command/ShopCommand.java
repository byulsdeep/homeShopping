package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * shopCommand
 */
public interface ShopCommand {
    public abstract void execute(HttpServletRequest request, HttpServletResponse response);
}
