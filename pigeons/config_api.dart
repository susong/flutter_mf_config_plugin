import 'package:pigeon/pigeon.dart';

/// 配置类型
enum ConfigTypeEnum {
  /// 云端配置
  CLOUD_CONFIG,

  /// 本地配置
  LOCAL_CONFIG,

  /// 其他配置
  OTHER_CONFIG,
  ;
}

/// 配置加密
enum ConfigEncryptEnum {
  /// 不加密
  NO_ENCRYPT,

  /// 整个文档加密
  ENCRYPT_ALL,
  ;
}

class ConfigParam {
  /// 配置文件名
  String? filename;

  /// 配置类型
  /// 现在默认分为云端配置和本地配置，两个配置的key相同时，本地配置会覆盖云端配置，
  /// 多个对象的 configTypeEnum 值为 {ConfigTypeEnum.CLOUD_CONFIG 云端配置} 时，只生效最后一个，其他的当 {ConfigTypeEnum.}OTHER_CONFIG 其他配置} 处理
  /// 多个对象的 configTypeEnum 值为 {ConfigTypeEnum.LOCAL_CONFIG 本地配置} 时，只生效最后一个，其他的当 {ConfigTypeEnum.}OTHER_CONFIG 其他配置} 处理
  /// {ConfigTypeEnum.}OTHER_CONFIG 其他配置} 可以有多个。
  ConfigTypeEnum? configTypeEnum;

  /// 加密枚举
  ConfigEncryptEnum? configEncryptEnum;

  /// 加密秘钥，推荐长度32位
  String? encryptKey;
}

@HostApi()
abstract class ConfigApi {
  List<ConfigParam> getDefaultNoEncryptConfigParam();

  List<ConfigParam> getDefaultEncryptConfigParam(String? encryptKey);

  String getCloudConfigFile();

  String getLocalConfigFile();

  bool init();

  bool initWithEncryptKey(String encryptKey);

  bool initWithConfigParam(List<ConfigParam>? configParams);

  void reloadConfig(bool clearLoadedConfig);

  void putString(String key, String value);

  void putInt(String key, int value);

  void putDouble(String key, double value);

  void putBoolean(String key, bool value);

  void putMap(Map<String, Object> map, bool isReplace);

  void putStringCloud(String key, String value);

  void putIntCloud(String key, int value);

  void putDoubleCloud(String key, double value);

  void putBooleanCloud(String key, bool value);

  void putMapCloud(Map<String, Object> map, bool isReplace);

  void putStringFile(String filename, String key, String value);

  void putIntFile(String filename, String key, int value);

  void putDoubleFile(String filename, String key, double value);

  void putBooleanFile(String filename, String key, bool value);

  void putMapFile(String filename, Map<String, Object> map, bool isReplace);

  String getString(String key, String defaultValue);

  int getInt(String key, int defaultValue);

  double getDouble(String key, double defaultValue);

  bool getBoolean(String key, bool defaultValue);

  Map<String, Object> getMap();

  Map<String, Object> getMapCloud();

  Map<String, Object> getMapFile(String filename);

  Map<String, Object> getAllMap();

  bool contains(String key);

  void save();

  void saveCloud();

  void saveFile(String filename);
}
