package com.example.bilmeetimagemap.ui.middle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MiddleViewModel extends ViewModel {



    private MutableLiveData<String> mText;

    public MiddleViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}