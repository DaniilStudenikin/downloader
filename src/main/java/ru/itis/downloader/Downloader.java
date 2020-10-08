package ru.itis.downloader;
import java.io.*;
import java.net.*;

public class Downloader {
    public static void main(String[] args) {
        downloadFiles("https://sun9-20.userapi.com/impg/tkW5cC9TN9KV9D9dzF73GmVu6TvTNKZ--8ZtSQ/o3AyJbeoy9A.jpg?size=200x0&quality=90&crop=0,143,1620,1620&sign=34f8772aba8d21d3aaf3d86fe1769bba&ava=1", "E:\\Новая папка\\test.jpg ", 2 );
    }

    public static void downloadFiles(String strUrl, String strPath, int buffsize) {
        try {
            URL connection = new URL(strUrl);
            HttpURLConnection urlConn;
            urlConn = (HttpURLConnection) connection.openConnection();
            urlConn.setRequestMethod("GET");
            urlConn.connect();
            InputStream in = null;
            in = urlConn.getInputStream();
            OutputStream writer = new FileOutputStream(strPath);
            byte[] buffer = new byte[buffsize];
            int c = in.read(buffer);
            while (c > 0) {
                writer.write(buffer, 0, c);
                c = in.read(buffer);
            }
            writer.flush();
            writer.close();
            in.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
