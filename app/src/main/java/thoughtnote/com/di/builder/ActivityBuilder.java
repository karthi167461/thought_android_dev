/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package thoughtnote.com.di.builder;

import thoughtnote.com.ui.drawerscreen.DrawerAct;
import thoughtnote.com.ui.drawerscreen.FragmentProvider;
import thoughtnote.com.ui.entry.EntryAct;
import thoughtnote.com.ui.splash.SplashScreen;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Here bind the subcomponent of Activitie's and
 **/

@Module
public abstract class ActivityBuilder {


    @ContributesAndroidInjector()
    abstract SplashScreen bindSplashScreen();

    @ContributesAndroidInjector(modules = FragmentProvider.class)
    abstract DrawerAct bindDrawerActActivity();

    @ContributesAndroidInjector(modules = FragmentProvider.class)
    abstract EntryAct bindEntryActivity();

}
