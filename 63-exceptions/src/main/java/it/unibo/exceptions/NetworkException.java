package it.unibo.exceptions;

import java.io.IOException;

public class NetworkException extends IOException {

    @SuppressWarnings("unused")
    private Exception exception;

    public NetworkException(){
        exception = new Exception("Network error: no response");
    }

    public NetworkException(String input){
        exception = new Exception("Network error while sending message:"+input);
    }


}
