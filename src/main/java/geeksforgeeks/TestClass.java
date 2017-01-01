package geeksforgeeks;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by bhavneet.ahuja on 27/11/16.
 */
public class TestClass {
    private static int getIntegerFromString(String numStr) {
        return Integer.parseInt(numStr);
    }

    private static String[] getSplitSpace(String line) {
        return line.split("\\s");
    }

    private static BufferedReader getBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bi = getBufferedReader();
        String line;
        ArrayList<String> requests = new ArrayList<>();
        ArrayList<String> filters = new ArrayList<>();
        String request = "";
        while (true) {
            line = bi.readLine();
            if (line.compareTo("***************###############***************") == 0) {
                requests.add(request);
                for (int i = 0; i < 5; i++) {
                    line = bi.readLine();
                    filters.add(line);
                }
                break;
            } else {
                if (line.startsWith("Started ")) {
                    if (!(request.compareTo("") == 0)) {
                        requests.add(request);
                    }
                    request = "";
                }
                request = request + "\n" + line;
            }
        }
        printResult(requests, filters);
    }

    private static void printResult(ArrayList<String> requests, ArrayList<String> filters) {
        Map<String, Integer> result = new LinkedHashMap<>();
        for (String filter : filters) {
            result.put(filter, 0);
        }
        for (String request : requests) {
            for (String filter : filters) {
                if (filter.compareTo("HTML") == 0 || filter.compareTo("null/blank") == 0  || filter.compareTo("null")==0 || filter.compareTo("blank")==0) {
                    if(!request.contains("Processing by") || request.contains("Processing by my"))result.put(filter, result.get(filter) + 1);
                    else if(request.contains("as "+filter)) result.put(filter, result.get(filter) + 1);
                    
                } else if(filter.compareTo("JS")==0 || filter.compareTo("JSON")==0){
                    if(request.contains("as "+filter)) result.put(filter, result.get(filter) + 1);
                }
//                else if(filter.compareTo("401 Unauthorized")==0 || filter.compareTo("422 Unprocessable Entity")==0){
//                    if(!filter.contains("Completed "))result.put(filter, result.get(filter) + 1);
//                    else if (request.contains(filter))
//                        result.put(filter, result.get(filter) + 1);
//                }
                else if (isStringEqual(filter, "GET") || isStringEqual(filter, "POST") || isStringEqual(filter, "PUT") || isStringEqual(filter, "DELETE")){
                    if (request.contains("Started " +filter))
                        result.put(filter, result.get(filter) + 1);
                }
                else if(filter.contains("/")){
                    if (request.contains("\"" +filter+"\""))
                        result.put(filter, result.get(filter) + 1);
                }
                else if (filter.contains(".")){
                    if (request.contains("for " +filter))
                        result.put(filter, result.get(filter) + 1);
                }
                else if(filter.contains("200 OK") || filter.contains("401 Unauthorized") || filter.contains("422 Unprocessable Entity")){
                    if (request.contains("Completed "+filter))
                        result.put(filter, result.get(filter) + 1);
                }
                else if (request.contains(filter))
                    result.put(filter, result.get(filter) + 1);

            }
        }
        for (Integer integer : result.values()) {
            System.out.println(integer);
        }
    }

    private static boolean isStringEqual(String filter, String get) {
        if(filter.compareTo(get)==0) return true;
        return false;
    }
}