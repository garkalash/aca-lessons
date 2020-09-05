package com.aca.patterns.structural.proxy;

/**
 * @author: garik
 * @created: 9/3/2020, 10:20 PM
 */
public class CmdExecutorProxy implements CommandExecutor{
    private boolean isAdmin;
    private CmdExecutorImpl cmdExecutor;

    public CmdExecutorProxy(String name, String pwd){
        isAdmin = name.equalsIgnoreCase("aca") && pwd.equalsIgnoreCase("aca_pwd");
        cmdExecutor = new CmdExecutorImpl();
    }

    @Override
    public void runCommand(String cmd) throws Exception {
        if(isAdmin){
            cmdExecutor.runCommand(cmd);
        } else {
            if(cmd.startsWith("sudo")){
                throw  new Exception("sudo is not permitted for you");
            } else {
                cmdExecutor.runCommand(cmd);
            }
        }
    }
}
