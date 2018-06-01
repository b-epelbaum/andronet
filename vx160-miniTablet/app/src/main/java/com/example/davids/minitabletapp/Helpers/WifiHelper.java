package com.example.davids.minitabletapp.Helpers;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.net.LinkAddress;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.format.Formatter;
import android.util.Log;


import com.example.davids.minitabletapp.activities.MainActivity;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Davids on 06/11/2017.
 */



    public class WifiHelper {


        static WifiManager wifiManager;

        private static WifiConfiguration wifiConfig;
        private static WifiInfo connectionInfo;
    Activity context;

        public WifiHelper(Activity context) {
            this.context = context;
            wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            connectionInfo = wifiManager.getConnectionInfo();

             wifiConfig = new WifiConfiguration();
        }

        public String getIpAddress() {


            List<WifiConfiguration> configuredNetworks = wifiManager.getConfiguredNetworks();
            for (WifiConfiguration conf : configuredNetworks) {
                if (conf.networkId == connectionInfo.getNetworkId()) {
                    wifiConfig = conf;

                    break;
                }
            }
            return Formatter.formatIpAddress(connectionInfo.getIpAddress());

        }

        public boolean isWifiEnabled() {
            if (wifiManager == null) {
                wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            }
            return wifiManager.isWifiEnabled();
        }

        public boolean isConnectToWifi(String wifiName) throws IllegalAccessException, InvocationTargetException, UnknownHostException, InstantiationException, ClassNotFoundException, NoSuchMethodException, NoSuchFieldException {


                if (connectionInfo.getSSID().equals("\"" + wifiName + "\"")) {
                    Log.w("WifiHelper getSSID()",connectionInfo.getSSID());
                    Log.w("WifiHelper getIpAddress",""+Formatter.formatIpAddress(connectionInfo.getIpAddress()));
                    if (!Formatter.formatIpAddress(connectionInfo.getIpAddress()).equals("192.168.42.7")) {
                        setStaticIp("192.168.42.7","192.168.42.1","8.8.8.8","8.8.4.4");
                    }
                        return true;


                  //
                }


            return false;
        }


        public boolean connectToWifi(String wifiName) {
            Log.w("WifiHelper","connectToWifi :"+wifiName);
            forgetAllNetwork();
            wifiConfig.SSID = String.format("\""+wifiName+"\"" );
            wifiConfig.preSharedKey = String.format("\"%s\"", "vsxlanbox");
            int netId = wifiManager.addNetwork(wifiConfig);
//            wifiManager.disconnect();
//            wifiManager.reconnect();
            for (ScanResult scanResult :wifiManager.getScanResults()){
                if (scanResult.SSID.contains(  wifiName )) {
                    List<WifiConfiguration> list = wifiManager.getConfiguredNetworks();
                    for (WifiConfiguration i : list) {


                            Log.w("WifiHelper","list :"+i.SSID);
                            wifiManager.disconnect();
                            wifiManager.enableNetwork(i.networkId, true);
                            wifiManager.reconnect();
                           // forgetAllNetworkExceptOne("\"" + wifiName + "\"");
                            try {
                                setStaticIp("192.168.42.7","192.168.42.1","8.8.8.8","8.8.4.4");
                                ((MainActivity)context).restartApp();
                            } catch (NoSuchFieldException e) {
                                e.printStackTrace();
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (NoSuchMethodException e) {
                                e.printStackTrace();
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            } catch (InstantiationException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            } catch (UnknownHostException e) {
                                e.printStackTrace();
                            }
                            return true;


                    }
                }
            }



            return false;
        }


        public void setStaticIp(String ip, String gateway, String DNS1, String DNS2) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InstantiationException, InvocationTargetException, UnknownHostException {

            List<WifiConfiguration> configuredNetworks = wifiManager.getConfiguredNetworks();
            for (WifiConfiguration conf : configuredNetworks) {
                if (conf.networkId == wifiManager.getConnectionInfo().getNetworkId()) {
                    wifiConfig = conf;
                    break;
                }
            }

            connectionInfo = wifiManager.getConnectionInfo();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                changeWifiConfiguration(false, ip, 24, DNS1, DNS2, ip);//192.168.42.1;
                Log.w("WifiHelper","STATIC :"+ip);
            } else {
                setIpAssignment("STATIC", wifiConfig); //or "DHCP" for dynamic setting
                setIpAddress(InetAddress.getByName(ip), 24, wifiConfig);
                setGateway(InetAddress.getByName(gateway), wifiConfig);//192.168.42.1;
                setDNS(InetAddress.getByName(DNS1), InetAddress.getByName(DNS2), wifiConfig);//"8.8.8.8" google DNS
                Log.w("WifiHelper","STATIC :"+ip);
                wifiManager.updateNetwork(wifiConfig); //apply the setting
                wifiManager.saveConfiguration(); //Save it

            }
            wifiManager.disconnect();
            wifiManager.reconnect();

        }

        public void forgetAllNetworkExceptOne(String wifiName) {

            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            List<WifiConfiguration> list = wifiManager.getConfiguredNetworks();
            int numOfWifi = 0;
            for (WifiConfiguration i : list) {
                if (!(i.SSID.equals(wifiName))) {

                    wifiManager.removeNetwork(i.networkId);
                    wifiManager.saveConfiguration();
                } else {
                    if (numOfWifi > 0) {
                        wifiManager.removeNetwork(i.networkId);
                        wifiManager.saveConfiguration();
                    } else {
                        numOfWifi++;
                    }
                }

            }
        }

        public void forgetAllNetwork() {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            List<WifiConfiguration> list = wifiManager.getConfiguredNetworks();

            for (WifiConfiguration i : list) {
                wifiManager.removeNetwork(i.networkId);

                wifiManager.saveConfiguration();
            }
        }


        private void setIpAssignment(String assign, WifiConfiguration wifiConf)
                throws SecurityException, IllegalArgumentException, NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Object ipConfiguration = wifiConf.getClass().getMethod("getIpConfiguration").invoke(wifiConf);
                setEnumField(ipConfiguration, assign, "ipAssignment");
            } else {
                setEnumField(wifiConf, assign, "ipAssignment");
            }
        }

        private void setIpAddress(InetAddress addr, int prefixLength, WifiConfiguration wifiConf)
                throws SecurityException, IllegalArgumentException, NoSuchFieldException, IllegalAccessException,
                NoSuchMethodException, ClassNotFoundException, InstantiationException, InvocationTargetException {
            Object linkProperties = getField(wifiConf, "linkProperties");
            if (linkProperties == null) return;
            Class laClass = Class.forName("android.net.LinkAddress");
            Constructor laConstructor = laClass.getConstructor(new Class[]{InetAddress.class, int.class});
            Object linkAddress = laConstructor.newInstance(addr, prefixLength);

            ArrayList mLinkAddresses = (ArrayList) getDeclaredField(linkProperties, "mLinkAddresses");
            mLinkAddresses.clear();
            mLinkAddresses.add(linkAddress);
        }

        private void setGateway(InetAddress gateway, WifiConfiguration wifiConf)
                throws SecurityException, IllegalArgumentException, NoSuchFieldException, IllegalAccessException,
                ClassNotFoundException, NoSuchMethodException, InstantiationException, InvocationTargetException {
            Object linkProperties = getField(wifiConf, "linkProperties");
            if (linkProperties == null) return;
            Class routeInfoClass = Class.forName("android.net.RouteInfo");
            Constructor routeInfoConstructor = routeInfoClass.getConstructor(new Class[]{InetAddress.class});
            Object routeInfo = routeInfoConstructor.newInstance(gateway);

            ArrayList mRoutes = (ArrayList) getDeclaredField(linkProperties, "mRoutes");
            mRoutes.clear();
            mRoutes.add(routeInfo);
        }

        private void setDNS(InetAddress dns1, InetAddress dns2, WifiConfiguration wifiConf)
                throws SecurityException, IllegalArgumentException, NoSuchFieldException, IllegalAccessException {
            Object linkProperties = getField(wifiConf, "linkProperties");
            if (linkProperties == null) return;
            ArrayList<InetAddress> mDnses = (ArrayList<InetAddress>) getDeclaredField(linkProperties, "mDnses");
            mDnses.clear(); //or add a new dns address , here I just want to replace DNS1
            mDnses.add(dns1);
            mDnses.add(dns2);
        }

        private Object getField(Object obj, String name)
                throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
            Field f = obj.getClass().getField(name);
            Object out = f.get(obj);
            return out;
        }

        private Object getDeclaredField(Object obj, String name)
                throws SecurityException, NoSuchFieldException,
                IllegalArgumentException, IllegalAccessException {
            Field f = obj.getClass().getDeclaredField(name);
            f.setAccessible(true);
            Object out = f.get(obj);
            return out;
        }

        private void setEnumField(Object obj, String value, String name)
                throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
            Field f = obj.getClass().getField(name);
            f.set(obj, Enum.valueOf((Class<Enum>) f.getType(), value));
        }

        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        public void changeWifiConfiguration(boolean dhcp, String ip, int prefix, String dns1, String dns2, String gateway) {

            if (!wifiManager.isWifiEnabled()) {
                // wifi is disabled
                return;
            }
            // get the current wifi configuration

            connectionInfo = wifiManager.getConnectionInfo();
            List<WifiConfiguration> configuredNetworks = wifiManager.getConfiguredNetworks();
            if (configuredNetworks != null) {
                for (WifiConfiguration conf : configuredNetworks) {
                    if (conf.networkId == connectionInfo.getNetworkId()) {
                        wifiConfig = conf;
                        break;
                    }
                }
            }
            if (wifiConfig == null) {
                // wifi is not connected
                return;
            }
            try {
                Class<?> ipAssignment = wifiConfig.getClass().getMethod("getIpAssignment").invoke(wifiConfig).getClass();
                Object staticConf = wifiConfig.getClass().getMethod("getStaticIpConfiguration").invoke(wifiConfig);
                if (dhcp) {
                    wifiConfig.getClass().getMethod("setIpAssignment", ipAssignment).invoke(wifiConfig, Enum.valueOf((Class<Enum>) ipAssignment, "DHCP"));
                    if (staticConf != null) {
                        staticConf.getClass().getMethod("clear").invoke(staticConf);
                    }
                } else {
                    wifiConfig.getClass().getMethod("setIpAssignment", ipAssignment).invoke(wifiConfig, Enum.valueOf((Class<Enum>) ipAssignment, "STATIC"));
                    if (staticConf == null) {
                        Class<?> staticConfigClass = Class.forName("android.net.StaticIpConfiguration");
                        staticConf = staticConfigClass.newInstance();
                    }
                    // STATIC IP AND MASK PREFIX
                    Constructor<?> laConstructor = LinkAddress.class.getConstructor(InetAddress.class, int.class);
                    LinkAddress linkAddress = (LinkAddress) laConstructor.newInstance(
                            InetAddress.getByName(ip),
                            prefix);
                    staticConf.getClass().getField("ipAddress").set(staticConf, linkAddress);
                    // GATEWAY
                    staticConf.getClass().getField("gateway").set(staticConf, InetAddress.getByName(gateway));
                    // DNS
                    List<InetAddress> dnsServers = (List<InetAddress>) staticConf.getClass().getField("dnsServers").get(staticConf);
                    dnsServers.clear();
                    dnsServers.add(InetAddress.getByName(dns1));
                    dnsServers.add(InetAddress.getByName(dns2)); // Google DNS as DNS2 for safety
                    // apply the new static configuration
                    wifiConfig.getClass().getMethod("setStaticIpConfiguration", staticConf.getClass()).invoke(wifiConfig, staticConf);
                }
                // apply the configuration change
                boolean result = wifiManager.updateNetwork(wifiConfig) != -1; //apply the setting
                if (result) result = wifiManager.saveConfiguration(); //Save it
                if (result) wifiManager.reassociate(); // reconnect with the new static IP
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

