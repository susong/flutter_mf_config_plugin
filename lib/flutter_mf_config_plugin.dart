
import 'flutter_mf_config_plugin_platform_interface.dart';

class FlutterMfConfigPlugin {
  Future<String?> getPlatformVersion() {
    return FlutterMfConfigPluginPlatform.instance.getPlatformVersion();
  }
}
