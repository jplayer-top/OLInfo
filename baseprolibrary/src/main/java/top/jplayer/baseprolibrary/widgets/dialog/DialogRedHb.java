package top.jplayer.baseprolibrary.widgets.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import com.github.florent37.viewanimator.AnimationBuilder;
import com.github.florent37.viewanimator.ViewAnimator;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import top.jplayer.baseprolibrary.R;
import top.jplayer.baseprolibrary.net.IoMainSchedule;
import top.jplayer.baseprolibrary.utils.LogUtil;


/**
 * Created by vondear on 2016/7/19.
 * Mainly used for confirmation and cancel.
 */
public class DialogRedHb extends BaseCustomDialog {

    public DialogRedHb(Context context) {
        super(context);
    }

    @Override
    protected void initView(View view) {
        view.findViewById(R.id.ivCancel).setOnClickListener(v -> cancel());
    }


    @Override
    public int initLayout() {
        return R.layout.dialog_redhb;
    }

    @Override
    public void show(int ids) {
        super.show(ids, v -> {
            Disposable subscribe = looperAnim(v);
            //模拟网络请求
            Observable.timer(2000, TimeUnit.MILLISECONDS).subscribe(new Observer<Long>() {
                @Override
                public void onSubscribe(Disposable d) {
                    LogUtil.method();

                }

                @Override
                public void onNext(Long aLong) {
                    LogUtil.method();


                }

                @Override
                public void onError(Throwable e) {
                    LogUtil.method();

                }

                @Override
                public void onComplete() {
                    LogUtil.method();
                    if (!subscribe.isDisposed()) {
                        subscribe.dispose();
                    }
                }
            });

        });
    }

    /**
     * 无限循环金币动画
     */
    @NonNull
    private Disposable looperAnim(View v1) {
        AnimationBuilder animationBuilder = ViewAnimator
                .animate(v1)
                .duration(2000)
                .rotationY(0,
                        30, 60, 90, 120,
                        150, 180, 210, 240,
                        270, 300, 330, 360);
        animationBuilder.start();
        return Observable.interval(2000, TimeUnit.MILLISECONDS)
                .compose(new IoMainSchedule<>())
                .subscribe(aLong -> animationBuilder.start());
    }
}
