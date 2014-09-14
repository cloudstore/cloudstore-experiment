package org.robovm.sample.ios;

import org.robovm.apple.coregraphics.*;
import org.robovm.apple.foundation.*;
import org.robovm.apple.uikit.*;

import test.PersistenceTest;

public class RoboVMSampleIOSApp extends UIApplicationDelegateAdapter {

    private UIWindow window = null;

    @Override
    public boolean didFinishLaunching(UIApplication application,
            NSDictionary<NSString, ?> launchOptions) {
  
    	final UIButton buttonCreate = UIButton.create(UIButtonType.RoundedRect);
		buttonCreate.setFrame(new CGRect(115.0f, 121.0f, 91.0f, 37.0f));
		buttonCreate.setTitle("Test", UIControlState.Normal);
		
		buttonCreate.addOnTouchUpInsideListener(new UIControl.OnTouchUpInsideListener() {
		
			public void onTouchUpInside(UIControl control, UIEvent event) {
				try {
					System.out.println("path" + this.getClass().getClassLoader().getResource("cloudstore.properties"));
					new PersistenceTest().getModifications();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.err.println("trial");
				System.err.println("*********");
				System.err.println(System.getProperty("user.dir"));
				System.err.println(this.getClass().getProtectionDomain().getCodeSource().getLocation());
			}
		});

        window = new UIWindow(UIScreen.getMainScreen().getBounds());
        window.setBackgroundColor(UIColor.colorLightGray());
        window.addSubview(buttonCreate);
        window.makeKeyAndVisible();
        
        return true;
    }

    public static void main(String[] args) {
        NSAutoreleasePool pool = new NSAutoreleasePool();
        UIApplication.main(args, null, RoboVMSampleIOSApp.class);
        pool.close();
    }
}