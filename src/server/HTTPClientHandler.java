package server;

import calculator.Q3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class HTTPClientHandler implements ClientHandler{
    BufferedReader in;
    PrintWriter out;

    @Override
    public void handle(InputStream inFromClient, OutputStream outToClient) {
        try{
            in = new BufferedReader(new InputStreamReader(inFromClient));
            out = new PrintWriter(outToClient);

            out.println("HTTP/1.1 200"); //  version and status code
           // out.println("connect-Type: text/plain"); // the type of data we send
            out.println("connect-Type: text/html");
            out.println("Connection: close"); // will close stream
            out.println(""); // End of headers

            String request = null;
            String line;
            while ((line = in.readLine()).length()>0) { // ככה נדע שסיים לכתוב את הבקשה שלו - יש שורה ריקה
                System.out.println(line);
                if(line.startsWith("GET /test")){
                    request = line.split("=")[1].split(" ")[0];
                }

            }
          //  out.println("hello from server");
            if (request==null) {
                Stream<String> s = Files.lines(Paths.get("web/index.html"));
                s.forEach(out::println);
                s.close();
            }
            else{
                if(request.contains("%2F"))
                    request = request.replace("%2F","/");
                    if(request.contains("%2B"))
                        request = request.replace("%2B","+");
                        if(request.contains("%28"))
                            request = request.replace("%28","(");
                            if(request.contains("%29"))
                                request = request.replace("%29",")");

                out.println("your request is: " + request);
                double result = Q3.calc(request);
                if (String.valueOf(request).contains("/0") && !String.valueOf(request).contains("/0."))
                    out.println("EROOR! you can't divide by zero ");
                else if (String.valueOf(result).endsWith("0")) {
                    out.println("The result is: " + (int) result);
                }
                else if(String.valueOf(result).contains(".000"))
                    out.println("The result is: " + (int) result);
                else
                        out.println("The result is: " + Q3.calc(request));
            }

        }catch (Exception e){ }
    }

    @Override
    public void close() {
        try{
            out.close();
            in.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
