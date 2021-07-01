package com.olayg.navigationapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavArgs;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.olayg.navigationapp.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    public SecondFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String firstName = SecondFragmentArgs.fromBundle(getArguments()).getFirstName();
        Toast.makeText(getContext(), firstName, Toast.LENGTH_SHORT).show();

        binding.btnNext.setOnClickListener(v -> {
            String lastName = "";
            if (binding.etLastName.getText() != null)
                lastName = binding.etLastName.getText().toString();

            NavDirections action =
                    SecondFragmentDirections.actionSecondFragmentToThirdFragment(firstName, lastName);
            Navigation.findNavController(v).navigate(action);
        });
    }
}
