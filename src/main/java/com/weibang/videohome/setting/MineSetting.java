package com.weibang.videohome.setting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "mine.setting")
public class MineSetting {


    @Value("image-path")
    private String imagePath;
    @Value("image-domain")
    private String imageDomain;
    @Value("host-address")
    private String hotsIp;
    @Value("log-path")
    private String logPath;
    @Value("qr-path")
    private String qrPath;
    @Value("pay-callback-url")
    private String payCallbackUrl;
    @Value("voice-path")
    private String voicePath;
    @Value("voice-domain")
    private String voiceDomain;
    @Value("base-work-space")
    private String baseWorkSpace;
    @Value("base-file-path")
    private String baseFilePath;

    @Value("log_stash_host")
    private String logStashHost;


    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImageDomain() {
        return imageDomain;
    }

    public void setImageDomain(String imageDomain) {
        this.imageDomain = imageDomain;
    }

    public String getHotsIp() {
        return hotsIp;
    }

    public void setHotsIp(String hotsIp) {
        this.hotsIp = hotsIp;
    }

    public String getLogPath() {
        return logPath;
    }

    public void setLogPath(String logPath) {
        this.logPath = logPath;
    }

    public String getQrPath() {
        return qrPath;
    }

    public void setQrPath(String qrPath) {
        this.qrPath = qrPath;
    }

    public String getPayCallbackUrl() {
        return payCallbackUrl;
    }

    public void setPayCallbackUrl(String payCallbackUrl) {
        this.payCallbackUrl = payCallbackUrl;
    }

    public String getVoicePath() {
        return voicePath;
    }

    public void setVoicePath(String voicePath) {
        this.voicePath = voicePath;
    }

    public String getVoiceDomain() {
        return voiceDomain;
    }

    public void setVoiceDomain(String voiceDomain) {
        this.voiceDomain = voiceDomain;
    }

    public String getBaseWorkSpace() {
        return baseWorkSpace;
    }

    public void setBaseWorkSpace(String baseWorkSpace) {
        this.baseWorkSpace = baseWorkSpace;
    }

    public String getBaseFilePath() {
        return baseFilePath;
    }

    public void setBaseFilePath(String baseFilePath) {
        this.baseFilePath = baseFilePath;
    }


    public String getLogStashHost() {
        return logStashHost;
    }

    public void setLogStashHost(String logStashHost) {
        this.logStashHost = logStashHost;
    }
}
