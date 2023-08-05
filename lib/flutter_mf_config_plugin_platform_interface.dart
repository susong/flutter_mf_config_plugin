import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'flutter_mf_config_plugin_method_channel.dart';

abstract class FlutterMfConfigPluginPlatform extends PlatformInterface {
  /// Constructs a FlutterMfConfigPluginPlatform.
  FlutterMfConfigPluginPlatform() : super(token: _token);

  static final Object _token = Object();

  static FlutterMfConfigPluginPlatform _instance = MethodChannelFlutterMfConfigPlugin();

  /// The default instance of [FlutterMfConfigPluginPlatform] to use.
  ///
  /// Defaults to [MethodChannelFlutterMfConfigPlugin].
  static FlutterMfConfigPluginPlatform get instance => _instance;

  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [FlutterMfConfigPluginPlatform] when
  /// they register themselves.
  static set instance(FlutterMfConfigPluginPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<String?> getPlatformVersion() {
    throw UnimplementedError('platformVersion() has not been implemented.');
  }
}
