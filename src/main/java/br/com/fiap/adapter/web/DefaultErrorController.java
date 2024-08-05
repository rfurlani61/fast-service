package br.com.fiap.adapter.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultErrorController implements ErrorController {

    @GetMapping(value = "/error")
    public String handleError(HttpServletRequest request) {

        Object status = request.getAttribute("jakarta.servlet.error.status_code");

        if (status != null) {

            Integer statusCode = (Integer) status;

            return switch (statusCode) {
                case 404 -> "error-404";
                case 418 -> "error-418";
                default -> "error-500";
            };
        }

        return "error-500";
    }
}
