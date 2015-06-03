package ec.com.mobileinc.demo.view.fragment;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

import ec.com.mobileinc.demo.R;


public abstract class CoreFragment extends Fragment implements View.OnClickListener {

    protected View fragmentView;
    boolean running = false;

    public void setFragmentView(View fragmentView) {
        this.fragmentView = fragmentView;
    }

    public View findViewById(int id) {
        if (fragmentView != null)
            return fragmentView.findViewById(id);
        else
            return null;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    protected abstract void Load();

    protected abstract void Fill();

    protected abstract void Add();

    protected abstract void Search();

    protected abstract void Empty(boolean information);

    protected abstract void Error();

    protected void Run(boolean process) {
        Run(process, R.id.placeholder_image);
    }

    protected void Run(boolean process, int id) {

        final View runningView = findViewById(id);

        if (runningView != null) {
            if (process) {
                runningView.setVisibility(View.VISIBLE);
                int previousDegrees = 0;
                int degrees = 360;
                final RotateAnimation animation = new RotateAnimation(previousDegrees, degrees,
                        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                animation.setFillEnabled(true);
                animation.setFillAfter(true);
                animation.setDuration(1500);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        if (running) {
                            runningView.startAnimation(animation);
                        } else
                            runningView.animate().alpha(0).start();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                runningView.startAnimation(animation);
            } else {
                running = false;
            }
        }
    }
}
