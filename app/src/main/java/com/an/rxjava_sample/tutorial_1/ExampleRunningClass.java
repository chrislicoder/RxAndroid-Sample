package com.an.rxjava_sample.tutorial_1;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ExampleRunningClass {
    private static void testCreateObservable() {
        final List<String> testList = new ArrayList<String>();
        testList.add("A");
        testList.add("B");
        testList.add("C");

        Observable<String> observable = Observable.create(emitter -> {
            try {
                for (String string : testList) {
                    emitter.onNext(string);
                }
                emitter.onComplete();
            } catch (Exception ex) {
                emitter.onError(ex);
            }

        });


        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        observable.subscribe(observer);
    }
}
