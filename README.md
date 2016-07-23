# raspberry-pi-camera-viewer-embedded-example

Example code to preview gstreamer pipeline from Android application.

## Example for single preview

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
intent.putExtra("advanced"+camera, true);	//when advanced=true, then custom_pipeline will be played
											//when advanced=false, then pipeline will be generated from host, port (use only for backward compatibility with previous versions)
intent.putExtra("custom_pipeline"+camera, "videotestsrc ! warptv ! autovideosink");

//--------- Enable application extra features
intent.putExtra("extraFeaturesEnabled"+camera, false);

//--------- Add autoaudiosink to featured pipeline
intent.putExtra("extraFeaturesSoundEnabled"+camera, false);

//--------- Scale Video Stream option
intent.putExtra("extraResizeVideoEnabled"+camera, false);
intent.putExtra("width"+camera, 320);		//used only when extraResizeVideoEnabled=true
intent.putExtra("height"+camera, 200);		//used only when extraResizeVideoEnabled=true
				
//--------- Add plugins
ArrayList<String> plugins = new ArrayList<String>();
intent.putExtra("plugins"+camera, plugins);
				
intent.setPackage("pl.effisoft.rpicamviewer2");
startActivityForResult(intent, 0);
```

## Preview 4 pipelines on single Activity
```java
Intent intent = new Intent("pl.effisoft.rpicamviewer2.PREVIEW");
intent.putExtra("full_screen", true);

for(int camera = 0;camera < 4; camera++)
{
	//--------- Basic settings
	intent.putExtra("name"+camera, "My pipeline name for cam "+camera);
	intent.putExtra("host"+camera, "192.168.0.1");
	intent.putExtra("port"+camera, 5000);
	intent.putExtra("description"+camera, "My pipeline description for cam "+camera);
	intent.putExtra("uuid"+camera, UUID.randomUUID().toString() );
	intent.putExtra("aspectRatio"+camera, 1.6);
	intent.putExtra("autoplay"+camera, true);

	//--------- Enable advanced mode
	intent.putExtra("advanced"+camera, true);	//when advanced=true, then custom_pipeline will be played
												//when advanced=false, then pipeline will be generated from host, port (use only for backward compatibility with previous versions)
	intent.putExtra("custom_pipeline"+camera, "videotestsrc ! warptv ! autovideosink");

	//--------- Enable application extra features
	intent.putExtra("extraFeaturesEnabled"+camera, false);

	//--------- Add autoaudiosink to featured pipeline
	intent.putExtra("extraFeaturesSoundEnabled"+camera, false);

	//--------- Scale Video Stream option
	intent.putExtra("extraResizeVideoEnabled"+camera, false);
	intent.putExtra("width"+camera, 320);		//used only when extraResizeVideoEnabled=true
	intent.putExtra("height"+camera, 200);		//used only when extraResizeVideoEnabled=true
					
	//--------- Add plugins
	ArrayList<String> plugins = new ArrayList<String>();
	intent.putExtra("plugins"+camera, plugins);
}
intent.setPackage("pl.effisoft.rpicamviewer2");
startActivityForResult(intent, 0);
```