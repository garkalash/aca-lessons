package com.aca.patterns.structural.proxy;

/**
 * @author: garik
 * @created" 9/3/2020, 10:24 PM
 */
public class Demo {
    public static void main(String[] args) {
        CommandExecutor commandExecutor = new CmdExecutorProxy("aca", "aca_pwd");
        try {
            commandExecutor.runCommand("dir");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
