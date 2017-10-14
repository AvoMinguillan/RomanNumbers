package com.example.android.romannumbers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void transform(View view){

        EditText Name = (EditText) findViewById(R.id.RomanNumber);
        String romanNumber = Name.getText().toString();
        int[] numbersArray = createArray(romanNumber);
        int arabicNumber = calculateArabicNumber(numbersArray);
        TextView arabicNumTextView = (TextView) findViewById(R.id.ArabicNumber);
        arabicNumTextView.setText(String.valueOf(arabicNumber));

    }

    public int[] createArray(String mRomanNumber){

        int[] mNumbersArray = new int[mRomanNumber.length()];

        for (int i = 0; i< mRomanNumber.length(); i++){
            switch (mRomanNumber.charAt(i)){

                case 'I': mNumbersArray[i] = 1;break;
                case 'V': mNumbersArray[i] = 5;break;
                case 'X': mNumbersArray[i] = 10;break;
                case 'L': mNumbersArray[i] = 50;break;
                case 'C': mNumbersArray[i] = 100;break;
                case 'D': mNumbersArray[i] = 500;break;
                case 'M': mNumbersArray[i] = 1000;break;

                    default: return null;
            }

        }
        return mNumbersArray;
}

    public int calculateArabicNumber (int [] nNumbersArray){

    int result=0;

    for (int i = 0; i< nNumbersArray.length-1; i++){

        if (nNumbersArray[i]<nNumbersArray[i+1]){
        result = result - nNumbersArray[i];
        }
        else {result = result + nNumbersArray[i];}
    }
    result = result + nNumbersArray[nNumbersArray.length-1];

    return result;

}


}
