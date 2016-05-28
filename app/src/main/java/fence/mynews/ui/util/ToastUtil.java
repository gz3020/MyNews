package fence.mynews.ui.util;

import android.view.Gravity;
import android.widget.Toast;

import fence.mynews.ui.NewsApplication;

/**
 * @author fence
 * @version 1.0.0
 * @description
 * @date 5/28/16
 */
public class ToastUtil {

    private static Toast mToast;

    /**
     * 使连续显示Toast时不会重复堆叠显示，不会延迟显示
     *
     * @param msg
     */
    public static void show(String msg) {
        if (null == mToast) {
            mToast = Toast.makeText(NewsApplication.getInstance(), msg, Toast.LENGTH_LONG);
        } else {
            mToast.setText(msg);
            mToast.setDuration(Toast.LENGTH_LONG);
        }
        mToast.show();
    }

    /**
     * 使连续显示Toast时不会重复堆叠显示，不会延迟显示
     *
     * @param resId
     */
    public static void show(int resId) {
        show(NewsApplication.getInstance().getString(resId));
    }

    /**
     * 停止显示Toast
     */
    public static void cancel() {
        if (mToast != null) {
            mToast.cancel();
        }
    }

    /**
     * 使连续显示Toast时不会重复堆叠显示，不会延迟显示，显示在屏幕中央
     *
     * @param msg
     */
    public static void showInCenter(String msg) {
        if (null == mToast) {
            mToast = Toast.makeText(NewsApplication.getInstance(), msg,
                    Toast.LENGTH_LONG);
        } else {
            mToast.setText(msg);
            mToast.setDuration(Toast.LENGTH_LONG);
        }
        mToast.setGravity(Gravity.CENTER, 0, 0);
        mToast.show();
    }
}
