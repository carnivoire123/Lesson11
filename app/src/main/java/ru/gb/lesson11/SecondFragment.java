package ru.gb.lesson11;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class SecondFragment extends Fragment implements View.OnClickListener {

    private TextView secondText ;
    private EditText secondMessage;
    private Button secondAction;
    private MessagingViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(MessagingViewModel.class);
        viewModel.getFirstInput().observe(this, text -> secondText.setText(text));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        secondText = view.findViewById(R.id.second_text);
        secondMessage = view.findViewById(R.id.second_message);
        secondAction = view.findViewById(R.id.second_action);
        secondAction.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        viewModel.secondSay(
                secondMessage.getText().toString()
        );
    }


















}
