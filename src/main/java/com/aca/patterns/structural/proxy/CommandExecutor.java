package com.aca.patterns.structural.proxy;

public interface CommandExecutor {
    void runCommand(String cmd) throws Exception;
}

class CmdExecutorImpl implements CommandExecutor{

    @Override
    public void runCommand(String cmd) throws Exception {
        Runtime.getRuntime().exec(cmd);
        System.out.println("'" + cmd + "' command executed");
    }
}
