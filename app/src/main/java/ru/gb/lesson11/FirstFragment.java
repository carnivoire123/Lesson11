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

public class FirstFragment  extends Fragment implements View.OnClickListener {

    private TextView firstText ;
    private EditText firstMessage;
    private Button firstAction;
    private MessagingViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(MessagingViewModel.class);
        viewModel.getSecondInput().observe(this, text -> firstText.setText(text));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        firstText = view.findViewById(R.id.first_text);
        firstMessage = view.findViewById(R.id.first_message);

        firstAction = view.findViewById(R.id.first_action);

        firstAction.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        viewModel.firstSay(
                firstMessage.getText().toString()
        );
    }
}
