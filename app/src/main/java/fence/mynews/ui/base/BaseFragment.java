package fence.mynews.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author fence
 * @version 1.0.0
 * @description
 * @date 5/12/16
 */
public abstract class BaseFragment extends Fragment {

    // Fragment 对用户是否可见
    protected boolean isVisibleToUser;

    // 视图是否已经初始化
    protected boolean isViewInited;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVariables(savedInstanceState);
    }

    protected abstract void initVariables(@Nullable Bundle savedInstanceState);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResId(), container, false);

        findViews(view);

        isViewInited = true;

        setViews();

        loadData();

        return view;
    }

    protected abstract int getLayoutResId();

    protected abstract void findViews(View view);

    protected abstract void setViews();

    protected abstract void loadData();

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        this.isVisibleToUser = isVisibleToUser;

        if (isVisibleToUser) {
            onVisibleToUser();
        } else {
            onInvisibleToUser();
        }

    }

    protected void onVisibleToUser() {
        lazyLoading();
    }

    protected abstract void lazyLoading();

    protected abstract void onInvisibleToUser();
}
