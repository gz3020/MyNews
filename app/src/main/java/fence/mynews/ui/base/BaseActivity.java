package fence.mynews.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * @author fence
 * @version 1.0.0
 * @description
 * @date 5/12/16
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        initVariables();

        findViews();

        setViews();

        loadData();
    }

    protected abstract int getLayoutResId();

    protected abstract void initVariables();

    protected abstract void findViews();

    protected abstract void setViews();

    protected abstract void loadData();

}
