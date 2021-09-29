package kr.ac.daegu.springbootapi.common;

import lombok.Getter;

@Getter
public class ApiResponse<T> { // wild card : 어떤 클래스던 받을 수 있다! 를 선언
    private final String status;
    private final T data;

    public ApiResponse(String status, T data) {
        this.status = status;
        this.data = data;
    }
}
