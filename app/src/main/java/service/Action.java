package service;

import android.os.AsyncTask;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by gutte on 11/27/2016.
 */

public class Action extends AsyncTask<String, Void, String> {
    String header ;
    String data ;
    DataOutputStream dataOutput = null;
    DataInputStream dataInput = null ;
    Action(String header, String data){
        this.header = header ;
        this.data = data ;
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            Socket socket = new Socket("192.168.137.1", 7789);
//                connect = true ;
            dataOutput = new DataOutputStream(socket.getOutputStream());
            dataInput = new DataInputStream(socket.getInputStream());

            dataOutput.writeUTF("hello");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ex";

    }

    @Override
    protected void onPostExecute(String result) {
    }

    @Override
    protected void onPreExecute() {}

    @Override
    protected void onProgressUpdate(Void... values) {}
}