package com.example.osamak.coffeeorderingapp;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mIncrementCoffeeButton;
    private Button mDecrementCoffeeButton;
    private TextView mQuantityOfCoffeeCupsTextView;
    private EditText mCustomerNameEditText;
    private EditText mCustomerAddressEditText;
    private Button mSubmitOrderButton;

    int quantityOfCoffee = 1;
    final int PRICE_OF_COFFEE = 120;
    final int PRICE_OF_WHIPPEDCREAM = 20;
    final int PRICE_OF_CHOCOLATE = 30;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();

        mIncrementCoffeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementCoffeeCups();
            }
        });

        mDecrementCoffeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementCoffeeCups();
            }
        });

        mSubmitOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitOrder();
            }
        });
    }

    public void initUI(){
        mIncrementCoffeeButton = (Button) findViewById(R.id.increment);
        mDecrementCoffeeButton = (Button) findViewById(R.id.decrement);
        mQuantityOfCoffeeCupsTextView = (TextView) findViewById(R.id.quantity);
        mCustomerNameEditText = (EditText) findViewById(R.id.customer_name);
        mCustomerAddressEditText = (EditText) findViewById(R.id.customer_address);
        mSubmitOrderButton = (Button) findViewById(R.id.submit_order);
    }

    public void submitOrder(){
        String orderSummary;
        if (getCustomerName() == null || getCustomerAddress() == null){
                if (getCustomerName() == null && getCustomerAddress() == null){
                Toast.makeText(MainActivity.this,"Please Enter Your Name",Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,"Please Enter Your Address",Toast.LENGTH_SHORT).show();
            }
            else if(getCustomerAddress() == null) {
                Toast.makeText(MainActivity.this,"Please Enter Your Address",Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(MainActivity.this,"Please Enter Your Name",Toast.LENGTH_SHORT).show();
            }
        }
        else {
            orderSummary = "Customer Name: "+getCustomerName() + "\n"+"Customer Address: " + getCustomerAddress() +"\n"
                    + "Cup of Coffees: " + quantityOfCoffee + "\n" + "Whipped Cream Topping: " + isCheckedWhippedCream() + "\n"
                    + "Chocolate Topping: " +  isCheckedChocolate() + "\n" + "Total Amount: " + calculatePrice() + " PKR";

            Intent sendOrder = new Intent(Intent.ACTION_SENDTO);
            sendOrder.setData(Uri.parse("mailto:"));
            sendOrder.putExtra(Intent.EXTRA_SUBJECT,"For Ordering Coffee");
            sendOrder.putExtra(android.content.Intent.EXTRA_EMAIL,new String[] {"","CoffeeOrding@gmail.com" });
            sendOrder.putExtra(Intent.EXTRA_TEXT,orderSummary);
            if (sendOrder.resolveActivity(getPackageManager()) != null) {
                startActivity(sendOrder);
            }
        }
    }

    public void incrementCoffeeCups(){
        if (quantityOfCoffee < 100)
        {
            quantityOfCoffee++;
            displayQuantity(quantityOfCoffee);
        }
        else {
            Toast.makeText(MainActivity.this,"Not Delivered More Than 100 Cups",Toast.LENGTH_SHORT).show();
        }
    }

    public void decrementCoffeeCups(){
        if (quantityOfCoffee > 1)
        {
            quantityOfCoffee--;
            displayQuantity(quantityOfCoffee);

        }
        else {
            Toast.makeText(MainActivity.this,"Not less than One Cup of Coffee",Toast.LENGTH_SHORT).show();
        }
    }

    @NonNull
    private Boolean isCheckedWhippedCream(){
        CheckBox mwhippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_topping);
       return mwhippedCreamCheckBox.isChecked();
    }

    @NonNull
    private Boolean isCheckedChocolate(){
        CheckBox mChocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_topping);
        return mChocolateCheckBox.isChecked();
    }

    @Nullable
    private String getCustomerName(){
        if (!mCustomerNameEditText.getText().toString().isEmpty())
        {
            String customerName = mCustomerNameEditText.getText().toString();
            return customerName;
        }
        else {
            return null;
        }

    }

    @Nullable
    private String getCustomerAddress(){
        if (!mCustomerAddressEditText.getText().toString().isEmpty())
        {
            String customerAddress = mCustomerAddressEditText.getText().toString();
            return customerAddress;
        }
        else {
            return null;
        }

    }

    public int calculatePrice(){
        int totalPrice;
        if (isCheckedWhippedCream() && isCheckedChocolate()){
            totalPrice = quantityOfCoffee * (PRICE_OF_COFFEE+PRICE_OF_WHIPPEDCREAM+PRICE_OF_CHOCOLATE);
            return totalPrice;
        }
        else if (isCheckedWhippedCream()){
            totalPrice = quantityOfCoffee * (PRICE_OF_COFFEE+PRICE_OF_WHIPPEDCREAM);
            return totalPrice;
        }
        else if (isCheckedChocolate()){
            totalPrice = quantityOfCoffee * (PRICE_OF_COFFEE+PRICE_OF_CHOCOLATE);
            return totalPrice;
        }
        else {
            totalPrice = quantityOfCoffee * PRICE_OF_COFFEE;
            return totalPrice;
        }
    }

    private void displayQuantity(int quantityOfCups){
        mQuantityOfCoffeeCupsTextView.setText("" + quantityOfCups);
    }

}
