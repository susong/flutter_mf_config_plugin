import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

import 'flutter_mf_config_plugin_platform_interface.dart';

/// An implementation of [FlutterMfConfigPluginPlatform] that uses method channels.
class MethodChannelFlutterMfConfigPlugin extends FlutterMfConfigPluginPlatform {
  /// The method channel used to interact with the native platform.
  @visibleForTesting
  final methodChannel = const MethodChannel('flutter_mf_config_plugin');

  @override
  Future<String?> getPlatformVersion() async {
    final version = await methodChannel.invokeMethod<String>('getPlatformVersion');
    return version;
  }
}
