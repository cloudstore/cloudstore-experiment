
import org.robovm.apple.coregraphics.*;
import org.robovm.apple.foundation.*;
import org.robovm.apple.uikit.*;

public class IOSClientRoboVM extends UIApplicationDelegateAdapter {

	private UIWindow window = null;
	private int clickCount = 0;

	@Override
	public boolean didFinishLaunching(UIApplication application,
			NSDictionary launchOptions) {

		final UIButton buttonCreate = UIButton.create(UIButtonType.RoundedRect);
		buttonCreate.setFrame(new CGRect(115.0f, 121.0f, 91.0f, 37.0f));
		buttonCreate.setTitle("Create", UIControlState.Normal);
		
		buttonCreate.addOnTouchUpInsideListener(new UIControl.OnTouchUpInsideListener() {
			@Override
			public void onTouchUpInside(UIControl control, UIEvent event) {
				new Test().create();
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
