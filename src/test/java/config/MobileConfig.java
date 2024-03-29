package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:mobile.properties"
})
public interface MobileConfig extends Config{
   @Key("accUser")
   String getUser();
   @Key("accKey")
   String getKey();
   @Key("appUrl")
   String getApp();
   @Key("device")
   String getDevice();
   @Key("os_version")
   String getOsVersion();
   @Key("otherProject")
   String getProject();
   @Key("otherBuild")
   String getBuild();
   @Key("otherName")
   String getName();
   @Key("remoteUrl")
   String getUrl();

}
