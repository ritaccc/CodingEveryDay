package com.company;

import java.net.URL;
import com.vmware.vim25.*;
import com.vmware.vim25.mo.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.Pipe;

public class Main {
//
    public static void main(String[] args) throws Exception {
        // write your code here
//        if (args == null || args.length != 3) {
//            return;
//        }
        System.out.println("CMPE281 HW2 From Mengxuan Cai");
        ServiceInstance si = new ServiceInstance(new URL("https://130.65.159.14/sdk"), "cmpe281_sec3_student@vsphere.local", "cmpe-LXKN", true);
        Folder rootFolder = si.getRootFolder();
        String name = rootFolder.getName();
        while (true) {
            System.out.print("Mengxuan-444>");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();
            input = input.trim().replaceAll(" +", " ");
            String[] inputArray = input.split(" ");
            //get host
            if (inputArray[0].equals("host")) {
                if(inputArray.length == 1) {
                    ManagedEntity[] mes = new InventoryNavigator(rootFolder).searchManagedEntities("HostSystem");
                    String[] host = new String[mes.length];
                    for(int i = 0; i < mes.length; i++) {
                        ManagedEntity me = mes[i];
                        HostSystem hostsystemobj = (HostSystem) me;
                        System.out.println("host[" + i + "]: name = " + hostsystemobj.getName());
                    }

                }else if (inputArray.length == 3) {
                    //get host info
                    if (inputArray[2].equals("info")) {
                        ManagedEntity[] mes = new InventoryNavigator(rootFolder).searchManagedEntities("HostSystem");
                        String[] host = new String[mes.length];
                        for(int i = 0; i < mes.length; i++) {
                            ManagedEntity me = mes[i];
                            HostSystem hostsystemobj = (HostSystem) me;
                            if(inputArray[1].equals(hostsystemobj.getName())){
                                System.out.println("Host:");
                                String hostName = "name = " + hostsystemobj.getName();
                                System.out.printf("%5s%s\n","", hostName);
                                HostConfigInfo hostConfigInfo = hostsystemobj.getConfig();
                                System.out.println("ProductFullName = " + hostConfigInfo.getProduct().getFullName());
                                HostListSummary hostListSummary = hostsystemobj.getSummary();
                                System.out.println("Cpu core = " + hostListSummary.getHardware().getNumCpuCores());
                                System.out.println("RAM = " + hostListSummary.getHardware().getMemorySize());
                                break;
                            }
                        }
                    } else if(inputArray[2] == "datastore") {
                        //get host data store
                        ManagedEntity[] mes = new InventoryNavigator(rootFolder).searchManagedEntities("HostSystem");
                        String[] host = new String[mes.length];
                        for(int i = 0; i < mes.length; i++) {
                            ManagedEntity me = mes[i];
                            HostSystem hostsystemobj = (HostSystem) me;
                            if (inputArray[1].equals(hostsystemobj.getName())) {
                                System.out.println("name = " + hostsystemobj.getName());
                                Datastore[] dataStores = hostsystemobj.getDatastores();
                                for (int j = 0; j < dataStores.length; j++) {
                                    Datastore datastore = dataStores[i];
                                    System.out.println("Data[" + j + "]: name = " + datastore.getName()
                                            + ", capacity = " + datastore.getSummary().getCapacity()
                                            + "GB, FreeSpace = " + datastore.getSummary().getFreeSpace() + "GB.");
                                }
                                break;
                            }
                        }
                    }else if(inputArray[2] == "network"){
                        ManagedEntity[] mes = new InventoryNavigator(rootFolder).searchManagedEntities("HostSystem");
                        String[] host = new String[mes.length];
                        for(int i = 0; i < mes.length; i++) {
                            ManagedEntity me = mes[i];
                            HostSystem hostsystemobj = (HostSystem) me;
                            if(inputArray[1].equals(hostsystemobj.getName())){
                                System.out.println("name = " + hostsystemobj.getName());
                                Network[] networks = hostsystemobj.getNetworks();
                                for(int j = 0; j < networks.length; j++) {
                                    System.out.println("Network [" + j + "] = " + networks[j]);
                                }
                                break;
                            }
                        }
                    }
                 }
            }else if(inputArray[0].equals("help") && inputArray.length == 1) {


            }else if(inputArray[0].equals("vm")) {
                if(inputArray.length == 1) {
                    ManagedEntity[] mes = new InventoryNavigator(rootFolder).searchManagedEntities("VirtualMachine");
                    if (mes == null || mes.length == 0) {
                        return;
                    }
                    for (int j = 0; j < mes.length; j++) {
                        VirtualMachine vm = (VirtualMachine) mes[j];
                        System.out.println("vm[" + j + "]: name = " + vm.getName());
                    }

                } else if(inputArray.length == 3) {
                    if (inputArray[2].equals("info")) {
                        ManagedEntity[] mes = new InventoryNavigator(rootFolder).searchManagedEntities("VirtualMachine");
                        if (mes == null || mes.length == 0) {
                            return;
                        }
                        for (int j = 0; j < mes.length; j++) {
                            VirtualMachine vm = (VirtualMachine) mes[j];
                            if(inputArray[1].equals(vm.getName())) {
                                System.out.println("vm[" + j + "]: name = " + vm.getName());
                                System.out.println("Guest Full Name = " + vm.getConfig().getGuestFullName());
                                System.out.println("Guest State = " + vm.getGuest().getGuestState());
                                System.out.println("IP Address = " + vm.getGuest().getIpAddress());
                                System.out.println("Tool Running State = " + vm.getGuest().getToolsRunningStatus());
                                System.out.println("Power State = " + vm.getRuntime().getPowerState());
                                break;
                            }
                        }

                    } else if (inputArray[2].equals("on")){
                        ManagedEntity[] mes = new InventoryNavigator(rootFolder).searchManagedEntities("VirtualMachine");
                        if (mes == null || mes.length == 0) {
                            return;
                        }
                        for (int j = 0; j < mes.length; j++) {
                            VirtualMachine vm = (VirtualMachine) mes[j];
                            if (inputArray[1].equals(vm.getName())) {
                                Task task = vm.powerOnVM_Task(null);
                                if(task.waitForTask()==Task.SUCCESS)
                                {
                                    System.out.println("Name = " + vm.getName());
                                    System.out.println("Power On VM: Status = " + task.getTaskInfo().getState()
                                            +", Completion Time = " + task.getTaskInfo().getCompleteTime());
                                }

                            }
                        }

                    } else if (inputArray[2].equals("off")){

                    } else if (inputArray[2].equals("shutdown")) {

                    }
                 }
            }else if (inputArray[0].equals("exit") && inputArray.length == 1){
                return;

            }else {
                System.out.println("No this commnad");
            }
                //do something



        }
    }
    private static void printAllVm() throws Exception {

        ServiceInstance si = new ServiceInstance(new URL("https://130.65.159.14/sdk"), "cmpe281_sec3_student@vsphere.local", "cmpe-LXKN", true);
        Folder rootFolder = si.getRootFolder();
        String name = rootFolder.getName();
        System.out.println("root:" + name);
        ManagedEntity[] mes = new InventoryNavigator(rootFolder).searchManagedEntities("VirtualMachine");
        if (mes == null || mes.length == 0) {
            return;
        }
        for (ManagedEntity me : mes) {
            VirtualMachine vm = (VirtualMachine) me;
            VirtualMachineConfigInfo vminfo = vm.getConfig();
            VirtualMachineCapability vmc = vm.getCapability();
            System.out.println("Hello " + vm.getName());
            System.out.println("GuestOS: " + vminfo.getGuestFullName());
            System.out.println("Multiple snapshot supported: " + vmc.isMultipleSnapshotsSupported());
        }
        si.getServerConnection().logout();

    }


}
