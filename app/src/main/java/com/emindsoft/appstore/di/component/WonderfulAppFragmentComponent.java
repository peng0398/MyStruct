package com.emindsoft.appstore.di.component;

import com.emindsoft.appstore.di.module.WonderfulAppFragmentModule;
import com.emindsoft.appstore.di.scope.FragmentScope;
import com.emindsoft.appstore.ui.fragment.WonderfulAPPFragment;

import dagger.Subcomponent;

/**
 * Created by Bob.
 */
@FragmentScope
@Subcomponent(
        modules = WonderfulAppFragmentModule.class
)
public interface WonderfulAppFragmentComponent {

    void inject(WonderfulAPPFragment wonderfulAPPFragment);

}