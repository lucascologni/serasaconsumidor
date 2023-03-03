package br.com.serasaconsumidor.utils;

public class Constants {

    public final static int SECONDS_TIMEOUT = 20;

    public final static String[] CHROME_ARGUMENTS = new String[]{
            "--incognito",
            "--disable-features=EnableEphemeralFlashPermission",
            "--disable-infobars",
            "--disable-gpu",
            "--allow-running-insecure-content",
            "--window-size=1920,1080"
    };

    public static final String[] FIREFOX_ARGUMENTS = new String[]{
            "-private",
            "-disable-features=EnableEphemeralFlashPermission",
            "-disable-infobars"
    };

    public static final String[] EDGE_ARGUMENTS = new String[]{
            "--incognito",
            "--disable-features=EnableEphemeralFlashPermission",
            "--disable-infobars",
            "--disable-gpu",
            "--allow-running-insecure-content",
            "--window-size=1920,1080"
    };
}