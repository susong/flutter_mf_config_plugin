import 'package:flutter_test/flutter_test.dart';
import 'package:flutter_mf_config_plugin/flutter_mf_config_plugin.dart';
import 'package:flutter_mf_config_plugin/flutter_mf_config_plugin_platform_interface.dart';
import 'package:flutter_mf_config_plugin/flutter_mf_config_plugin_method_channel.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

class MockFlutterMfConfigPluginPlatform
    with MockPlatformInterfaceMixin
    implements FlutterMfConfigPluginPlatform {

  @override
  Future<String?> getPlatformVersion() => Future.value('42');
}

void main() {
  final FlutterMfConfigPluginPlatform initialPlatform = FlutterMfConfigPluginPlatform.instance;

  test('$MethodChannelFlutterMfConfigPlugin is the default instance', () {
    expect(initialPlatform, isInstanceOf<MethodChannelFlutterMfConfigPlugin>());
  });

  test('getPlatformVersion', () async {
    FlutterMfConfigPlugin flutterMfConfigPlugin = FlutterMfConfigPlugin();
    MockFlutterMfConfigPluginPlatform fakePlatform = MockFlutterMfConfigPluginPlatform();
    FlutterMfConfigPluginPlatform.instance = fakePlatform;

    expect(await flutterMfConfigPlugin.getPlatformVersion(), '42');
  });
}
