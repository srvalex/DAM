package ro.ase.seminar03;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class AddFoodDeliveryActivity extends AppCompatActivity {

    EditText tbDenumire,tbCantitate,tbPret,tbDate,tbAdresa;
    Spinner cbItems;

    RadioGroup radioValuta;

    RadioButton radioRON;
    RadioGroup radioEUR;

    Button butonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_food_delivery);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tbDenumire = findViewById(R.id.etNume);
        tbCantitate = findViewById(R.id.etCantitate);
        tbPret = findViewById(R.id.etPret);
        tbDate = findViewById(R.id.etDataLivrare);
        cbItems = findViewById(R.id.spnProduse);
        radioValuta = findViewById(R.id.rgValuta);

        radioRON=findViewById(R.id.rbRon);

        tbAdresa = findViewById(R.id.etAdresa);

        butonAdd = findViewById(R.id.btnSalveaza);


        List<String> listaProduse = Arrays.stream(Produse.values()).map(prod -> prod.toString()).toList();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,listaProduse);
        cbItems.setAdapter(arrayAdapter);

        butonAdd.setOnClickListener(view -> {
            Log.i("Click buton","Am dat click pe buton");
            String name = tbDenumire.getText().toString();
            String adresa = tbAdresa.getText().toString();
            int cantitate = Integer.parseInt(tbCantitate.getText().toString());
            int pret = Integer.parseInt(tbPret.getText().toString());
            String date = tbDate.getText().toString();
            date = date.replace(".","-");
            Date localDate = new Date(Integer.parseInt(date.split("-")[0]),Integer.parseInt(date.split("-")[1]),Integer.parseInt(date.split("-")[2]));
            Produse prod= Produse.valueOf(cbItems.getSelectedItem().toString());
            Valuta value;
            if(radioRON.isChecked())
                value = Valuta.valueOf(radioRON.getText().toString());
            else
                value = Valuta.valueOf("EUR");
            Food obiect_1 = new Food(name,pret,0,adresa, localDate ,prod,value);

            Toast.makeText(this,obiect_1.toString(),Toast.LENGTH_LONG).show();
            Log.i("AFisare obiect","Am afisat obiectul");
            finish();
        });

    }
}