

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;
import org.robovm.apple.uikit.UIButton;
import org.robovm.apple.uikit.UIButtonType;
import org.robovm.apple.uikit.UIColor;
import org.robovm.apple.uikit.UIControl;
import org.robovm.apple.uikit.UIControlState;
import org.robovm.apple.uikit.UIEvent;
import org.robovm.apple.uikit.UIScreen;
import org.robovm.apple.uikit.UIWindow;

import test.PersistenceTest;

public class IOSClientRoboVM extends UIApplicationDelegateAdapter {

	private UIWindow window = null;

	@Override
	public boolean didFinishLaunching(UIApplication application,
			NSDictionary launchOptions) {

		final UIButton buttonCreate = UIButton.create(UIButtonType.RoundedRect);
		buttonCreate.setFrame(new CGRect(115.0f, 121.0f, 91.0f, 37.0f));
		buttonCreate.setTitle("Create", UIControlState.Normal);
		
		buttonCreate.addOnTouchUpInsideListener(new UIControl.OnTouchUpInsideListener() {
			@Override
			public void onTouchUpInside(UIControl control, UIEvent event) {
				try {
					new PersistenceTest().getModifications();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException(e);
				}
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
		UIApplication.main(args, null, IOSClientRoboVM.class);
		pool.close();
	}
}
