package thanos.skoulopoulos.feedme.common;

public class ApiResponse<T> {

    private boolean success;
    private T result;
    private String message;

    public ApiResponse(String message) {
        this.success = false;
        this.message = message;
    }

    public ApiResponse( T result) {
        this.success = true;
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
