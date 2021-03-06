/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.daydream.jumper;


import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class Jumper2 extends FrameLayout {
    public static final int MOVE = 1;

    Runnable mRunnable = new Runnable() {
        public void run() {
            final View parent = (View) getParent();
            if (parent == null) return;

            // reposition in parent using setX() and setY()
            final float width = getMeasuredWidth();
            final float height = getMeasuredHeight();
            final float parentw = parent.getMeasuredWidth();
            final float parenth = parent.getMeasuredHeight();
            animate().x((float) Math.random() * (parentw - width))
                     .y((float) Math.random() * (parenth - height))
                     .rotationBy(360)
                     .setDuration(500);

            postDelayed(this, 2000); // let’s do this again, soon
        }
    };

    public Jumper2(Context context) {
        super(context);
    }

    public Jumper2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Jumper2(Context context, AttributeSet attrs, int flags) {
        super(context, attrs, flags);
    }

    @Override
    public void onAttachedToWindow() {
        getHandler().post(mRunnable);
    }

}

