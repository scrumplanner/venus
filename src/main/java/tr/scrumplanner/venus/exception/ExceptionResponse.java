package tr.scrumplanner.venus.exception;

import lombok.Data;

@Data
public class ExceptionResponse {
    private String message;
    private Object data;
}
