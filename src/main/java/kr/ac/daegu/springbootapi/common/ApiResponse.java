package kr.ac.daegu.springbootapi.common;

import lombok.Getter;

@Getter
public class ApiResponse<T> { // wild card : 어떤 클래스던 받을 수 있다! 를 선언
    private final boolean success;
    private String Message = null;
    private T data;

    public ApiResponse(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public ApiResponse(boolean success, String Message) {
        this.success = success;
        this.Message = Message;
    }

    public ApiResponse(boolean success, String Message, T data) {
        this.success = success;
        this.Message = Message;
        this.data = data;
    }
}
