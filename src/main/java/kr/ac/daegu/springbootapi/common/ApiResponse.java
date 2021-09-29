package kr.ac.daegu.springbootapi.common;

import lombok.Getter;

@Getter
public class ApiResponse<T> { // wild card : 어떤 클래스던 받을 수 있다! 를 선언
    private final boolean success;
    private String errorMessage = null;
    private T data;

    public ApiResponse(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public ApiResponse(boolean success, String errorMessage) {
        this.success = success;
        this.errorMessage = errorMessage;
    }

    public ApiResponse(boolean success, String errorMessage, T data) {
        this.success = success;
        this.errorMessage = errorMessage;
        this.data = data;
    }
}
