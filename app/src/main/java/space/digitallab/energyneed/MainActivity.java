package space.digitallab.energyneed;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView result;
    private Spinner spinner;
    private CheckBox women;
    private EditText weight, height, age;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        result = findViewById(R.id.Result);
        spinner = findViewById(R.id.load);
        women = (CheckBox) findViewById(R.id.women);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        age = findViewById(R.id.age);

        Button mRach = (Button) findViewById(R.id.calculate);
        mRach.setOnClickListener(new View.OnClickListener() {

            double load, p, a, w, h, energy;

            @Override
            public void onClick(View v) {

                if (age.getText().toString().equals( "" ) || weight.getText().toString().equals( "" ) || height.getText().toString().equals( "" ) ) {

                    result.setText( "данные введены некорректно" );

                } else {

                    String Age = age.getText().toString();
                    String Weight = weight.getText().toString();
                    String Height = height.getText().toString();
                    load = spinner.getSelectedItemPosition();

                    a = Double.parseDouble(Age);
                    w = Double.parseDouble(Weight);
                    h = Double.parseDouble(Height);

                    if (h < 5) {
                        h = h*100;
                    }else{
                        h = h*1;
                    }

                    if (load == 0) {
                        p = 1.2;
                    } else if (load == 1) {
                        p = 1.375;
                    } else if (load == 2) {
                        p = 1.55;
                    } else if (load == 3) {
                        p = 1.72;
                    } else {
                        p = 1.9;
                    }

                    if (women.isChecked()) {

                        energy = ((10 * w) + (6.25 * h) - (5 * a) + 5) * p;
                    } else {

                        energy = ((10 * w) + (6.25 * h) - (5 * a) - 161) * p;
                    }

                    energy = Math.ceil(energy);

                        result.setText("Суточная потребность - " + energy + "ккалл");

                }
            }
        });
    }

    public void Cline(View view) {
        age.setText("");
        weight.setText("");
        height.setText("");
        result.setText("");
    }
}
