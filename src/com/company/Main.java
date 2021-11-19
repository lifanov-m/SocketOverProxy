package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {




        try ( Socket socket = new Socket( "ya.ru" , 80)) {
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write ( "GET / HTTP/1.0\r\n\r\n".getBytes());
            outputStream.flush();
            InputStream inputStream = socket.getInputStream();
            int read = inputStream.read ();
            while ( read >= 0) {
                System.out.print (( char ) read );
                read = inputStream.read ();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
