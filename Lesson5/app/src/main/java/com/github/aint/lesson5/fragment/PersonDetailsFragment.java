package com.github.aint.lesson5.fragment;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.aint.lesson5.R;
import com.github.aint.lesson5.activity.MainActivity;
import com.github.aint.lesson5.model.Person;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PersonDetailsFragment extends Fragment {

    private Person person;

    @BindView(R.id.firstNameTextView) TextView firstNameTextView;
    @BindView(R.id.lastNameTextView) TextView lastNameTextView;
    @BindView(R.id.ageTextView) TextView ageTextView;
    @BindView(R.id.sexTextView) TextView sexTextView;
    @BindView(R.id.salaryTextView) TextView salaryTextView;
    @BindView(R.id.locationTextView) TextView locationTextView;
    @BindView(R.id.occupationTextView) TextView occupationTextView;

    public static PersonDetailsFragment newInstance(Person person) {
        PersonDetailsFragment fragment = new PersonDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(MainActivity.PERSON_ATTRIBUTE, person);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            person = (Person) getArguments().getSerializable(MainActivity.PERSON_ATTRIBUTE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_person_details, container, false);
        ButterKnife.bind(this, view);
        displayPerson();
        return view;
    }

    private void displayPerson() {
        firstNameTextView.setText(person.getFirstName());
        lastNameTextView.setText(person.getLastName());
        ageTextView.setText(String.valueOf(person.getAge()));
        sexTextView.setText(person.getSex());
        locationTextView.setText(person.getLocation());
        salaryTextView.setText(String.valueOf(person.getSalary()));
        occupationTextView.setText(person.getOccupation());
    }

}
