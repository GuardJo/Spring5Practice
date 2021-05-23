package com.spring5.chapter03;

public class VersionnPrinter {
    private int majorVersion;
    private int minorVersion;

    public void print() {
        System.out.printf("This prgoram version is %d.%d\n", majorVersion, minorVersion);
    }

    public void setMajorVersion(int majorVersion) {
        this.majorVersion = majorVersion;
    }

    public void setMinorVersion(int minorVersion) {
        this.minorVersion = minorVersion;
    }
}
