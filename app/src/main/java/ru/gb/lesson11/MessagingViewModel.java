package ru.gb.lesson11;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MessagingViewModel extends ViewModel {
    // то что выдал первый фрагмент
    private MutableLiveData<String> firstInput = new MutableLiveData<>();
    // MutableLiveData - можем изменить

    // вызывается первым фрагментом
    public void firstSay(String text)
    {
        firstInput.postValue(text);
    }

    // то что выдал второй фрагмент
    private MutableLiveData<String> secondInput = new MutableLiveData<>();

    // вызывается вторым фрагментом
    public void secondSay(String text)
    {
        secondInput.postValue(text);
    }

    // второй фрагмент подписывается на лайфдату первого
    // LiveData - можем подписаться на изменение, но не можем изменить
    public LiveData<String> getFirstInput()
    {
        return firstInput;
    }


    // первый фрагмент подписывается на лайфдату в второго
    public LiveData<String> getSecondInput()
    {
        return secondInput;
    }

}
