package ggong_ggong.ridingbud.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private int statusCode;
    private String message;
}