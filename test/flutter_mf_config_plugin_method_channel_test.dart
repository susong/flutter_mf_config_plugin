import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:flutter_mf_config_plugin/flutter_mf_config_plugin_method_channel.dart';

void main() {
  MethodChannelFlutterMfConfigPlugin platform = MethodChannelFlutterMfConfigPlugin();
  const MethodChannel channel = MethodChannel('flutter_mf_config_plugin');

  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    expect(await platform.getPlatformVersion(), '42');
  });
}
