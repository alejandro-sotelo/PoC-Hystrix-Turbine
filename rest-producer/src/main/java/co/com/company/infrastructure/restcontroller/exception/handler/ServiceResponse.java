package co.com.company.infrastructure.restcontroller.exception.handler;

public class ServiceResponse {
    private int code;
    private String event;
    private String message;

    public ServiceResponse(int code, String event, String message) {
        this.code = code;
        this.event = event;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getEvent() {
        return event;
    }

    public String getMessage() {
        return message;
    }
}
