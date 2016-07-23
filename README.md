# raspberry-pi-camera-viewer-embedded-example

Example code to preview gstreamer pipeline from Android application.

## Example

```java
Intent intent = new Intent("pl.effisoft.rpicamviewer2.PREVIEW");
int camera =0;

//--------- Basic settings
intent.putExtra("full_screen", true);

intent.putExtra("name"+camera, "My pipeline name");
intent.putExtra("host"+camera, "192.168.0.1");
intent.putExtra("port"+camera, 5000);
intent.putExtra("description"+camera, "My pipeline description");
intent.putExtra("uuid"+camera, UUID.randomUUID().toString() );
intent.putExtra("aspectRatio"+camera, 1.6);
intent.putExtra("autoplay"+camera, true);

//--------- Enable advanced mode
intent.putExtra("advanced"+camera, true);
intent.putExtra("custom_pipeline"+camera, editText1.getText().toString());

//--------- Enable application extra features
intent.putExtra("extraFeaturesEnabled"+camera, false);

//--------- Add autoaudiosink to featured pipeline
intent.putExtra("extraFeaturesSoundEnabled"+camera, false);

//--------- Scale Video Stream option
intent.putExtra("extraResizeVideoEnabled"+camera, false);
intent.putExtra("width"+camera, 320);
intent.putExtra("height"+camera, 200);
				
//--------- Add plugins
ArrayList<String> plugins = new ArrayList<String>();
intent.putExtra("plugins"+camera, plugins);
				
intent.setPackage("pl.effisoft.rpicamviewer2");
startActivityForResult(intent, 0);
```
