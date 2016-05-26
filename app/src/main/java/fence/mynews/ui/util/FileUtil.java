package fence.mynews.ui.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import fence.mynews.ui.NewsApplication;

public class FileUtil {

	public static String getAssetsBy(String file) {
		String result = "";

		try {
			InputStream in = NewsApplication.getInstance().getAssets().open(file);
			InputStreamReader inputReader = new InputStreamReader(in);
			BufferedReader reader = new BufferedReader(inputReader);

			String line = "";
			while ((line = reader.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public static String getRawBy(int resId) {
		String result = "";

		try {
			InputStream in = NewsApplication.getInstance().getResources()
					.openRawResource(resId);
			InputStreamReader inputReader = new InputStreamReader(in);
			BufferedReader reader = new BufferedReader(inputReader);

			String line = "";
			while ((line = reader.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}