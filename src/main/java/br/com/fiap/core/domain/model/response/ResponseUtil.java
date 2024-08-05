package br.com.fiap.core.domain.model.response;

import java.util.Collections;
import java.util.List;

public class ResponseUtil {

    private ResponseUtil() {}

    public static <T> AppResponse<T> success(T data, String message, String path) {
        AppResponse<T> response = new AppResponse<>();
        response.setSuccess(true);
        response.setMessage(message);
        response.setData(data);
        response.setErrors(null);
        response.setErrorCode(0);
        response.setTimestamp(System.currentTimeMillis());
        response.setPath(path);
        return response;
    }

    public static <T> AppResponse<T> error(List<String> errors, String message, int errorCode, String path) {
        AppResponse<T> response = new AppResponse<>();
        response.setSuccess(false);
        response.setMessage(message);
        response.setData(null);
        response.setErrors(errors);
        response.setErrorCode(errorCode);
        response.setTimestamp(System.currentTimeMillis());
        response.setPath(path);
        return response;
    }

    public static <T> AppResponse<T> error(String error, String message, int errorCode, String path) {
        return error(Collections.singletonList(error), message, errorCode, path);
    }
}