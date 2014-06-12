package com.hao.system;

public class SystemDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.version")); //Java运行环境版本
        System.out.println(System.getProperty("java.vendor")); //Java Runtime Environment vendor
        System.out.println(System.getProperty("java.vendor.url")); //Java vendor URL
        System.out.println(System.getProperty("java.home")); //Java installation directory
        System.out.println(System.getProperty("java.vm.specification.version")); //Java Virtual Machine specification version
        System.out.println(System.getProperty("java.vm.specification.vendor")); //Java Virtual Machine specification vendor
        System.out.println(System.getProperty("java.vm.specification.name")); //Java Virtual Machine specification name
        System.out.println(System.getProperty("java.vm.version")); //Java Virtual Machine implementation version
        System.out.println(System.getProperty("java.vm.vendor")); //Java Virtual Machine implementation vendor
        System.out.println(System.getProperty("java.vm.name")); //Java Virtual Machine implementation name
        System.out.println(System.getProperty("java.specification.version"));//Java Runtime Environment specification version
        System.out.println(System.getProperty("java.specification.vendor")); //Java Runtime Environment specification vendor
        System.out.println(System.getProperty("java.specification.name")); //Java Runtime Environment specification name
        System.out.println(System.getProperty("java.class.version")); //Java class format version number
        System.out.println(System.getProperty("java.class.path")); //Java class path
        System.out.println(System.getProperty("java.library.path")); //List of paths to search when loading libraries
        System.out.println(System.getProperty("java.io.tmpdir")); //Default temp file path
        System.out.println(System.getProperty("java.compiler")); //Name of JIT compiler to use
        System.out.println(System.getProperty("java.ext.dirs")); //Path of extension directory or directories
        System.out.println(System.getProperty("os.name")); //Operating system name
        System.out.println(System.getProperty("os.arch")); //Operating system architecture
        System.out.println(System.getProperty("os.version")); //Operating system version
        System.out.println(System.getProperty("file.separator")); //File separator (System.getProperty("/" on UNIX))
        System.out.println(System.getProperty("path.separator")); //Path separator (System.getProperty(":" on UNIX))
        System.out.println(System.getProperty("line.separator")); //Line separator (System.getProperty("\n" on UNIX))
        System.out.println(System.getProperty("user.name")); //User's account name
        System.out.println(System.getProperty("user.home")); //User's home directory
        System.out.println(System.getProperty("user.dir")); //User's current working directory
    }

}
