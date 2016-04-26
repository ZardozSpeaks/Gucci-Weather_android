//package com.example.guest.gucciweather.adapters;
//
//
//import android.os.Bundle;
//import android.widget.ArrayAdapter;
//import android.widget.Spinner;
//
//import com.example.guest.gucciweather.MainActivity;
//import com.example.guest.gucciweather.R;
//
//public class SpinnerAdapter extends MainActivity {
//    @Override
//    public void onCreate(Bundle countrySpinner) {
//        super.onCreate(countrySpinner);
//        setContentView(R.layout.main);
//         = (Spinner)findViewById(R.id.week_spinner);
//
//        final Spinner spinner = (Spinner) findViewById(R.id.countrySpinner);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item, R.array.countryCodes);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//
//        final Button changeButton = (Button) findViewById(R.id.enableButton);
//        changeButton.setOnClickListener(new Button.OnClickListener() {
//            public void onClick(View v) {
//                changeOption(spinner);
//            }
//        });
//        final Button changeButton2 = (Button) findViewById(R.id.backgroundColorButton);
//        changeButton2.setOnClickListener(new Button.OnClickListener() {
//            public void onClick(View v) {
//                changeOption2(spinner);
//
//            }
//        });
//    }
//
//    static final String[] Countries = new String[] @strings
//    public void changeOption(Spinner spinner) {
//        if (spinner.isEnabled()) {
//            spinner.setEnabled(false);
//        } else {
//            spinner.setEnabled(true);
//
//        }
//    }
//
//    public void changeOption2(Spinner spinner) {
//        spinner.setBackgroundColor(Color.RED);
//    }
//}
//
//}
