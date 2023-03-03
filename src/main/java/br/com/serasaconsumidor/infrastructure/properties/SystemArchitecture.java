package br.com.serasaconsumidor.infrastructure.properties;

import org.apache.commons.lang3.SystemUtils;

public class SystemArchitecture {

    public enum OSType {
        WINDOWS, MAC, LINUX
    }

    public static OSType getOperatingSystemType() {

        OSType osType = OSType.LINUX;

        if (SystemUtils.IS_OS_WINDOWS)
            osType = OSType.WINDOWS;

        if (SystemUtils.IS_OS_MAC)
            osType = OSType.MAC;

        return osType;
    }

    public static boolean is64bits() {

        boolean is64bit;

        if (System.getProperty("os.name").contains("Windows"))
            is64bit = System.getenv("ProgramFiles(x86)") != null;
        else
            is64bit = System.getProperty("os.arch").contains("64");

        return is64bit;
    }
}