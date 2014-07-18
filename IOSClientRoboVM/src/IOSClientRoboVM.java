

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.apache.xpath.axes.PathComponent;
import org.robovm.apple.coredata.CoreData;
import org.robovm.apple.coregraphics.*;
import org.robovm.apple.foundation.*;
import org.robovm.apple.uikit.*;

public class IOSClientRoboVM extends UIApplicationDelegateAdapter {

    private UIWindow window = null;
    private int clickCount = 0;

    @Override
    public boolean didFinishLaunching(UIApplication application,
            NSDictionary launchOptions) {
  
    	
        final UIButton button = UIButton.create(UIButtonType.RoundedRect);
        button.setFrame(new CGRect(115.0f, 121.0f, 91.0f, 37.0f));
        button.setTitle("Click me!", UIControlState.Normal);

        button.addOnTouchUpInsideListener(new UIControl.OnTouchUpInsideListener() {
            @Override
            public void onTouchUpInside(UIControl control, UIEvent event) {
                button.setTitle("Click #" + (++clickCount), UIControlState.Normal);
            }
        });
        String path = new File("").getAbsolutePath();
        System.out.println(path);
        File file = new File("test.txt");
        try {
			PrintWriter writer = new PrintWriter(file);
			writer.append("test");
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        Scanner scanner;
		try {
			scanner = new Scanner(file);
			System.out.println(scanner.next());
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        // tries if the classes from bcpg and bcprov are detected,
		// if throws IllegalArgumentException then it is correct == classes are loaded
        try{
            byte[] testKey = new byte[256];
            for(int i=0;i<256;i++){
                testKey[i] = (byte) i; 
            }
            byte[] testData = new byte[]{(byte)10,(byte)20, (byte)30};
            byte[] result = null;
            result = new BCTest().encryptAES256(testData, testKey); // should throw exception
        } catch(Throwable ex){
            throw new RuntimeException(ex);
        }
        
        window = new UIWindow(UIScreen.getMainScreen().getBounds());
        window.setBackgroundColor(UIColor.colorLightGray());
        window.addSubview(button);
        window.makeKeyAndVisible();
        
        return true;
    }

    public static void main(String[] args) {
        NSAutoreleasePool pool = new NSAutoreleasePool();
        UIApplication.main(args, null, IOSClientRoboVM.class);
        pool.close();
    }
}
