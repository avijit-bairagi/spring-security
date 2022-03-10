package com.ovi.app.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBody {

    private boolean isSuccess;

    private String message;

    private Object data;

    public ResponseBody(String message) {
        this.message = message;
    }
}
