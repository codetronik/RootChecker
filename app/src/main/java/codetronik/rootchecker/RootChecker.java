package codetronik.rootchecker;

import android.util.Log;
import java.io.File;

public class RootChecker {

    public boolean execute_su() {
        boolean ret = false;
        try {
            Runtime.getRuntime().exec("su");
            ret = true;
        } catch (Exception e) {

        }
        return ret;
    }

    public String check_su_files() {

        String[] su_path =  new String[] {
                "/system/bin/su",
                "/system/xbin/su",
                "/system/xbin/sudo",
                "/system/sbin/su",
                "/temp/fakesu",
                "/system/test/su",
                "/sbin/su"
        };
        for (int i=0; i<su_path.length; i++) {
            boolean ret = check_file(su_path[i]);
            if (ret == true) {
                return su_path[i];
            }
        }
        return null;
    }

    private boolean check_file(String su_path) {
        boolean result = false;
        File su = new File(su_path);
        if(su != null && su.exists() && su.isFile())
        {
            result = true;
            Log.d("codetronikLog", su_path);
        }
        return result;
    }

}
