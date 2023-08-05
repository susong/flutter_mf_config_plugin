package com.mf.flutter_mf_config_plugin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mf.config.GlobalConfig;
import com.mf.config.domain.ConfigEncryptEnum;
import com.mf.config.domain.ConfigParam;
import com.mf.config.domain.ConfigTypeEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConfigLibraryApiImpl implements ConfigLibraryApi.ConfigApi {

    @NonNull
    private static List<ConfigLibraryApi.ConfigParam> toConfigLibraryParam(List<ConfigParam> configParams) {
        if (configParams == null || configParams.isEmpty()) {
            return new ArrayList<>();
        }
        return configParams.stream().map(V -> {
            ConfigLibraryApi.ConfigParam configParam = new ConfigLibraryApi.ConfigParam();
            configParam.setFilename(V.getFilename());
            if (V.getConfigTypeEnum() != null) {
                configParam.setConfigTypeEnum(ConfigLibraryApi.ConfigTypeEnum
                        .valueOf(V.getConfigTypeEnum().name()));
            }

            if (V.getConfigEncryptEnum() != null) {
                configParam.setConfigEncryptEnum(ConfigLibraryApi.ConfigEncryptEnum
                        .valueOf(V.getConfigEncryptEnum().name()));
            }
            configParam.setEncryptKey(V.getEncryptKey());
            return configParam;
        }).collect(Collectors.toList());
    }

    @NonNull
    private static List<ConfigParam> toConfigParam(List<ConfigLibraryApi.ConfigParam> configParams) {
        if (configParams == null || configParams.isEmpty()) {
            return new ArrayList<>();
        }
        return configParams.stream().map(
                        V -> {
                            ConfigParam configParam = new ConfigParam();
                            configParam.setFilename(V.getFilename());
                            if (V.getConfigTypeEnum() != null) {
                                configParam.setConfigTypeEnum(ConfigTypeEnum
                                        .valueOf(V.getConfigTypeEnum().name()));
                            }
                            if (V.getConfigEncryptEnum() != null) {
                                configParam.setConfigEncryptEnum(ConfigEncryptEnum
                                        .valueOf(V.getConfigEncryptEnum().name()));
                            }
                            configParam.setEncryptKey(V.getEncryptKey());
                            return configParam;
                        })
                .collect(Collectors.toList());
    }

    @NonNull
    @Override
    public List<ConfigLibraryApi.ConfigParam> getDefaultNoEncryptConfigParam() {
        List<ConfigParam> configParams = GlobalConfig.getDefaultNoEncryptConfigParam();
        return toConfigLibraryParam(configParams);
    }

    @NonNull
    @Override
    public List<ConfigLibraryApi.ConfigParam> getDefaultEncryptConfigParam(@Nullable String encryptKey) {
        List<ConfigParam> configParams = GlobalConfig.getDefaultEncryptConfigParam(encryptKey);
        return toConfigLibraryParam(configParams);
    }

    @NonNull
    @Override
    public String getCloudConfigFile() {
        return GlobalConfig.getInstance().getCloudConfigFile();
    }

    @NonNull
    @Override
    public String getLocalConfigFile() {
        return GlobalConfig.getInstance().getCloudConfigFile();
    }

    @NonNull
    @Override
    public Boolean init() {
        return GlobalConfig.getInstance().init();
    }

    @NonNull
    @Override
    public Boolean initWithEncryptKey(@NonNull String encryptKey) {
        return GlobalConfig.getInstance().init(encryptKey);
    }

    @NonNull
    @Override
    public Boolean initWithConfigParam(@Nullable List<ConfigLibraryApi.ConfigParam> configParams) {
        return GlobalConfig.getInstance().init(toConfigParam(configParams));
    }

    @Override
    public void reloadConfig(@NonNull Boolean clearLoadedConfig) {
        GlobalConfig.getInstance().reloadConfig(clearLoadedConfig);
    }

    @Override
    public void putString(@NonNull String key, @NonNull String value) {
        GlobalConfig.getInstance().putString(key, value);
    }

    @Override
    public void putInt(@NonNull String key, @NonNull Long value) {
        GlobalConfig.getInstance().putLong(key, value);
    }

    @Override
    public void putDouble(@NonNull String key, @NonNull Double value) {
        GlobalConfig.getInstance().putDouble(key, value);
    }

    @Override
    public void putBoolean(@NonNull String key, @NonNull Boolean value) {
        GlobalConfig.getInstance().putBoolean(key, value);
    }

    @Override
    public void putMap(@NonNull Map<String, Object> map, @NonNull Boolean isReplace) {
        GlobalConfig.getInstance().putMap(map, isReplace);
    }

    @Override
    public void putStringCloud(@NonNull String key, @NonNull String value) {
        GlobalConfig.getInstance().putStringCloud(key, value);
    }

    @Override
    public void putIntCloud(@NonNull String key, @NonNull Long value) {
        GlobalConfig.getInstance().putLongCloud(key, value);
    }

    @Override
    public void putDoubleCloud(@NonNull String key, @NonNull Double value) {
        GlobalConfig.getInstance().putDoubleCloud(key, value);
    }

    @Override
    public void putBooleanCloud(@NonNull String key, @NonNull Boolean value) {
        GlobalConfig.getInstance().putBooleanCloud(key, value);
    }

    @Override
    public void putMapCloud(@NonNull Map<String, Object> map, @NonNull Boolean isReplace) {
        GlobalConfig.getInstance().putMapCloud(map, isReplace);
    }

    @Override
    public void putStringFile(@NonNull String file, @NonNull String key, @NonNull String value) {
        GlobalConfig.getInstance().putString(file, key, value);
    }

    @Override
    public void putIntFile(@NonNull String file, @NonNull String key, @NonNull Long value) {
        GlobalConfig.getInstance().putLong(file, key, value);
    }

    @Override
    public void putDoubleFile(@NonNull String file, @NonNull String key, @NonNull Double value) {
        GlobalConfig.getInstance().putDouble(file, key, value);
    }

    @Override
    public void putBooleanFile(@NonNull String file, @NonNull String key, @NonNull Boolean value) {
        GlobalConfig.getInstance().putBoolean(file, key, value);
    }

    @Override
    public void putMapFile(@NonNull String filename, @NonNull Map<String, Object> map, @NonNull Boolean isReplace) {
        GlobalConfig.getInstance().putMap(filename, map, isReplace);
    }

    @NonNull
    @Override
    public String getString(@NonNull String key, @NonNull String defaultValue) {
        return GlobalConfig.getInstance().getString(key, defaultValue);
    }

    @NonNull
    @Override
    public Long getInt(@NonNull String key, @NonNull Long defaultValue) {
        return GlobalConfig.getInstance().getLong(key, defaultValue);
    }

    @NonNull
    @Override
    public Double getDouble(@NonNull String key, @NonNull Double defaultValue) {
        return GlobalConfig.getInstance().getDouble(key, defaultValue);
    }

    @NonNull
    @Override
    public Boolean getBoolean(@NonNull String key, @NonNull Boolean defaultValue) {
        return GlobalConfig.getInstance().getBoolean(key, defaultValue);
    }

    @NonNull
    @Override
    public Map<String, Object> getMap() {
        return GlobalConfig.getInstance().getMap();
    }


    @NonNull
    @Override
    public Map<String, Object> getMapCloud() {
        return GlobalConfig.getInstance().getMapCloud();
    }

    @NonNull
    @Override
    public Map<String, Object> getMapFile(@NonNull String filename) {
        return GlobalConfig.getInstance().getMap(filename);
    }

    @NonNull
    @Override
    public Map<String, Object> getAllMap() {
        return GlobalConfig.getInstance().getAllMap();
    }

    @NonNull
    @Override
    public Boolean contains(@NonNull String key) {
        return GlobalConfig.getInstance().contains(key);
    }

    @Override
    public void save() {
        GlobalConfig.getInstance().save();
    }

    @Override
    public void saveCloud() {
        GlobalConfig.getInstance().saveCloud();
    }

    @Override
    public void saveFile(@NonNull String file) {
        GlobalConfig.getInstance().save(file);
    }

}
