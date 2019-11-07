package updater;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AutomaticUpdater {

    private static Map<Double, FileUpdateInformation> timesForUpdate;    // key is in terms of hours

    private static List<File> getMDFiles() {
        List<File> files = new ArrayList<File>();
        File folder = new File(".");
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().contains("_MD.txt"))
                files.add(file);
        }
        return files;
    }

    public static Long matchTime(String text) {
        Long time = null;
        Pattern intPattern = Pattern.compile("([0-9]+)");
        Matcher matcher = intPattern.matcher(text);

        for (int i = 0; i < matcher.groupCount(); i++) {
            if (!matcher.find()) {
                return null;
            }
            time = Long.valueOf(matcher.group());
        }
        return time;
    }

    private static String matchType(String text, String prior) {
        Pattern strPattern = Pattern.compile("([a-zA-Z]+)");
        Matcher matcher = strPattern.matcher(text);
        for (int i = 0; i < matcher.groupCount(); i++) {
            do {
                if (!matcher.find()) {
                    return null;
                }
            } while (matcher.group().equals(prior));
            return matcher.group();
        }
        return null;
    }

    private static void extractAndRunUpdates(List<File> files, ScheduledExecutorService es) {
        for (File file : files) {
            Long time = null;
            String updateType = null;
            String strTimeType = null;
            TimeUnit timeType = null;
            String text = null;
            boolean alert = false;
            long hash = 0L;
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                while ((text = br.readLine()) != null) {
                    if (!(text.startsWith("update:")) && (!(text.startsWith("alert:"))) && (!(text.startsWith("hash:"))) ) {
                        continue;
                    }
                    if (text.startsWith("update:")) {
                        text = text.substring(7);
                        time = matchTime(text);
                        updateType = matchType(text, null);
                        strTimeType = matchType(text, updateType);
                        timeType = getTimeType(strTimeType);
                    } else if (text.startsWith("alert:")) {
                        alert = getAlert(text.substring(6));
                    } else if (text.startsWith("hash:")){
                        hash = getHash(text);
                    }
                }
                if (time == null || strTimeType == null || timeType == null || updateType == null) continue;
                addFileToExecutor(file, time, timeType, updateType, alert, hash, es);
                System.out.println(text);
            } catch (Exception e) {
                System.out.println(text);
                e.printStackTrace();
            }
        }
    }

    static long getHash(String hashString) {
        try {
            return Long.valueOf(hashString.substring(6).replace("\"", "").trim());
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    private static boolean getAlert(String alert) {
        return alert.contains("true") || alert.contains("yes");
    }

    private static void addFileToExecutor(File file, Long time, TimeUnit timeType, String updateType, boolean alert, long hash, ScheduledExecutorService es) {
        es.scheduleWithFixedDelay(new FileUpdateInformation(file, time, timeType, updateType, alert, hash), time, time, timeType);
    }

    private static TimeUnit getTimeType(String numStr) {
        if (numStr == null) return null;
        try {
            switch(numStr){
                case "sec":
                    return TimeUnit.SECONDS;
                case "min":
                    return TimeUnit.MINUTES;
                case "hrs":
                    return TimeUnit.HOURS;
                case "day":
                    return TimeUnit.DAYS;
                default:
                    return TimeUnit.valueOf(numStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void main (String[] arg) {
        List<File> files = getMDFiles();
        int numCores = Runtime.getRuntime().availableProcessors();
        ScheduledExecutorService es = Executors.newScheduledThreadPool(3*numCores);
        extractAndRunUpdates(files, es);
    }
}
