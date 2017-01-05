package com.emindsoft.appstore.ui.activity.presenter;

import com.emindsoft.appstore.HeavyLibraryWrapper;
import com.emindsoft.appstore.data.api.UserManager;
import com.emindsoft.appstore.data.model.User;
import com.emindsoft.appstore.ui.activity.SplashActivity;
import com.emindsoft.appstore.utils.SimpleObserver;
import com.emindsoft.appstore.utils.Validator;

/**
 * Created by Bob.
 */
public class SplashActivityPresenter {
    public String username;

    private SplashActivity splashActivity;
    private Validator validator;
    private UserManager userManager;
    private HeavyLibraryWrapper heavyLibraryWrapper;

    public SplashActivityPresenter(SplashActivity splashActivity, Validator validator,
                                   UserManager userManager, HeavyLibraryWrapper heavyLibraryWrapper) {
        this.splashActivity = splashActivity;
        this.validator = validator;
        this.userManager = userManager;
        this.heavyLibraryWrapper = heavyLibraryWrapper;

        //This calls should be delivered to ExternalLibrary right after it will be initialized
        this.heavyLibraryWrapper.callMethod();
        this.heavyLibraryWrapper.callMethod();
        this.heavyLibraryWrapper.callMethod();
        this.heavyLibraryWrapper.callMethod();
    }

    public void onShowRepositoriesClick() {
        if (validator.validUsername(username)) {
            splashActivity.showLoading(true);
            userManager.getUser(username).subscribe(new SimpleObserver<User>() {
                @Override
                public void onNext(User user) {
                    splashActivity.showLoading(false);
                    splashActivity.showRepositoriesListForUser(user);
                }

                @Override
                public void onError(Throwable e) {
                    splashActivity.showLoading(false);
                    splashActivity.showValidationError();
                }
            });
        } else {
            splashActivity.showValidationError();
        }
    }
}
