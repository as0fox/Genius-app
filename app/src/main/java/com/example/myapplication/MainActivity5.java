package com.example.myapplication;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class MainActivity5 extends AppCompatActivity {
    TextView convertFromDropdownTextView, ConvertToDropdownTextView, conversionRateText,show;
    EditText amountToConvert,input;
    ArrayList<String> arrayList;
    Dialog fromDialog;
    Dialog toDialog;
    Button convertButton,search;
    String convertFromValue, ConvertToValue, conversionValue;


    String[] contry = {
            "AED"//: "United Arab Emirates Dirham",
            , "AFN"//: "Afghan Afghani",
            , "ALL"//: "Albanian Lek",
            , "AMD"//: "Armenian Dram",
            , "ANG"//: "Netherlands Antillean Guilder",
            , "AOA"//: "Angolan Kwanza",
            , "ARS"//: "Argentine Peso",
            , "AUD"//: "Australian Dollar",
            , "AWG"//: "Aruban Florin",
            , "AZN"//: "Azerbaijani Manat",
            , "BAM"//: "Bosnia-Herzegovina Convertible Mark",
            , "BBD"//: "Barbadian Dollar",
            , "BDT"//: "Bangladeshi Taka",
            , "BGN"//: "Bulgarian Lev",
            , "BHD"//: "Bahraini Dinar",
            , "BIF"//: "Burundian Franc",
            , "BMD"//: "Bermudan Dollar",
            , "BND"//: "Brunei Dollar",
            , "BOB"//: "Bolivian Boliviano",
            , "BRL"//: "Brazilian Real",
            , "BSD"//: "Bahamian Dollar",
            , "BTC"//: "Bitcoin",
            , "BTN"//: "Bhutanese Ngultrum",
            , "BWP"//: "Botswanan Pula",
            , "BYN"//: "New Belarusian Ruble",
            , "BYR"//: "Belarusian Ruble",
            , "BZD"//: "Belize Dollar",
            , "CAD"//: "Canadian Dollar",
            , "CDF"//: "Congolese Franc",
            , "CHF"//: "Swiss Franc",
            , "CLF"//: "Chilean Unit of Account (UF)",
            , "CLP"//: "Chilean Peso",
            , "CNY"//: "Chinese Yuan",
            , "COP"//: "Colombian Peso",
            , "CRC"//: "Costa Rican Col\u00f3n",
            , "CUC"//: "Cuban Convertible Peso",
            , "CUP"//: "Cuban Peso",
            , "CVE"//: "Cape Verdean Escudo",
            , "CZK"//: "Czech Republic Koruna",
            , "DJF"//: "Djiboutian Franc",
            , "DKK"//: "Danish Krone",
            , "DOP"//: "Dominican Peso",
            , "DZD"//: "Algerian Dinar",
            , "EGP"//: "Egyptian Pound",
            , "ERN"//: "Eritrean Nakfa",
            , "ETB"//: "Ethiopian Birr",
            , "EUR"//: "Euro",
            , "FJD"//: "Fijian Dollar",
            , "FKP"//: "Falkland Islands Pound",
            , "GBP"//: "British Pound Sterling",
            , "GEL"//: "Georgian Lari",
            , "GGP"//: "Guernsey Pound",
            , "GHS"//: "Ghanaian Cedi",
            , "GIP"//: "Gibraltar Pound",
            , "GMD"//: "Gambian Dalasi",
            , "GNF"//: "Guinean Franc",
            , "GTQ"//: "Guatemalan Quetzal",
            , "GYD"//: "Guyanaese Dollar",
            , "HKD"//: "Hong Kong Dollar",
            , "HNL"//: "Honduran Lempira",
            , "HRK"//: "Croatian Kuna",
            , "HTG"//: "Haitian Gourde",
            , "HUF"//: "Hungarian Forint",
            , "IDR"//: "Indonesian Rupiah",
            , "ILS"//: "Israeli New Sheqel",
            , "IMP"//: "Manx pound",
            , "INR"//: "Indian Rupee",
            , "IQD"//: "Iraqi Dinar",
            , "IRR"//: "Iranian Rial",
            , "ISK"//: "Icelandic Kr\u00f3na",
            , "JEP"//: "Jersey Pound",
            , "JMD"//: "Jamaican Dollar",
            , "JOD"//: "Jordanian Dinar",
            , "JPY"//: "Japanese Yen",
            , "KES"//: "Kenyan Shilling",
            , "KGS"//: "Kyrgystani Som",
            , "KHR"//: "Cambodian Riel",
            , "KMF"//: "Comorian Franc",
            , "KPW"//: "North Korean Won",
            , "KRW"//: "South Korean Won",
            , "KWD"//: "Kuwaiti Dinar",
            , "KYD"//: "Cayman Islands Dollar",
            , "KZT"//: "Kazakhstani Tenge",
            , "LAK"//: "Laotian Kip",
            , "LBP"//: "Lebanese Pound",
            , "LKR"//: "Sri Lankan Rupee",
            , "LRD"//: "Liberian Dollar",
            , "LSL"//: "Lesotho Loti",
            , "LTL"//: "Lithuanian Litas",
            , "LVL"//: "Latvian Lats",
            , "LYD"//: "Libyan Dinar",
            , "MAD"//: "Moroccan Dirham",
            , "MDL"//: "Moldovan Leu",
            , "MGA"//: "Malagasy Ariary",
            , "MKD"//: "Macedonian Denar",
            , "MMK"//: "Myanma Kyat",
            , "MNT"//: "Mongolian Tugrik",
            , "MOP"//: "Macanese Pataca",
            , "MRO"//: "Mauritanian Ouguiya",
            , "MUR"//: "Mauritian Rupee",
            , "MVR"//: "Maldivian Rufiyaa",
            , "MWK"//: "Malawian Kwacha",
            , "MXN"//: "Mexican Peso",
            , "MYR"//: "Malaysian Ringgit",
            , "MZN"//: "Mozambican Metical",
            , "NAD"//: "Namibian Dollar",
            , "NGN"//: "Nigerian Naira",
            , "NIO"//: "Nicaraguan C\u00f3rdoba",
            , "NOK"//: "Norwegian Krone",
            , "NPR"//: "Nepalese Rupee",
            , "NZD"//: "New Zealand Dollar",
            , "OMR"//: "Omani Rial",
            , "PAB"//: "Panamanian Balboa",
            , "PEN"//: "Peruvian Nuevo Sol",
            , "PGK"//: "Papua New Guinean Kina",
            , "PHP"//: "Philippine Peso",
            , "PKR"//: "Pakistani Rupee",
            , "PLN"//: "Polish Zloty",
            , "PYG"//: "Paraguayan Guarani",
            , "QAR"//: "Qatari Rial",
            , "RON"//: "Romanian Leu",
            , "RSD"//: "Serbian Dinar",
            , "RUB"//: "Russian Ruble",
            , "RWF"//: "Rwandan Franc",
            , "SAR"//: "Saudi Riyal",
            , "SBD"//: "Solomon Islands Dollar",
            , "SCR"//: "Seychellois Rupee",
            , "SDG"//: "Sudanese Pound",
            , "SEK"//: "Swedish Krona",
            , "SGD"//: "Singapore Dollar",
            , "SHP"//: "Saint Helena Pound",
            , "SLE"//: "Sierra Leonean Leone",
            , "SLL"//: "Sierra Leonean Leone",
            , "SOS"//: "Somali Shilling",
            , "SRD"//: "Surinamese Dollar",
            , "STD"//: "S\u00e3o Tom\u00e9 and Pr\u00edncipe Dobra",
            , "SVC"//: "Salvadoran Col\u00f3n",
            , "SYP"//: "Syrian Pound",
            , "SZL"//: "Swazi Lilangeni",
            , "THB"//: "Thai Baht",
            , "TJS"//: "Tajikistani Somoni",
            , "TMT"//: "Turkmenistani Manat",
            , "TND"//: "Tunisian Dinar",
            , ",TOP"//: "Tongan Pa\u02bbanga",
            , "TRY"//: "Turkish Lira",
            , "TTD"//: "Trinidad and Tobago Dollar",
            , "TWD"//: "New Taiwan Dollar",
            , "TZS"//: "Tanzanian Shilling",
            , "UAH"//: "Ukrainian Hryvnia",
            , "UGX"//: "Ugandan Shilling",
            , "USD"//: "United States Dollar",
            , "UYU"//: "Uruguayan Peso",
            , "UZS"//: "Uzbekistan Som",
            , "VEF"//: "Venezuelan Bol\u00edvar Fuerte",
            , "VES"//: "Sovereign Bolivar",
            , "VND"//: "Vietnamese Dong",
            , "VUV"//: "Vanuatu Vatu",
            , "WST"//: "Samoan Tala",
            , "XAF"//: "CFA Franc BEAC",
            , "XAG"//: "Silver (troy ounce)",
            , "XAU"//: "Gold (troy ounce)",
            , "XCD"//: "East Caribbean Dollar",
            , "XDR"//: "Special Drawing Rights",
            , "XOF"//: "CFA Franc BCEAO",
            , "XPF"//: "CFP Franc",
            , "YER"//: "Yemeni Rial",
            , "ZAR"//: "South African Rand",
            , "ZMK"//: "Zambian Kwacha (pre-2013)",
            , "ZMW"//: "Zambian Kwacha",
            , "ZWL"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        convertFromDropdownTextView = findViewById(R.id.convert_from_dropdown_menu);
        ConvertToDropdownTextView = findViewById(R.id.convert_to_dropdown_menu);
        convertButton = findViewById(R.id.conversionButton);
        conversionRateText = findViewById(R.id.conversionRateText);
        amountToConvert = findViewById(R.id.amountToConvertValueEditText);
        show=findViewById(R.id.show);
        search=findViewById(R.id.search);
        input=findViewById(R.id.input);

        arrayList = new ArrayList<>();
        for (String i : contry) {
            arrayList.add(i);
        }



        Dictionary<String, String> dict = new Hashtable<>();
        dict.put("AED" , "United Arab Emirates Dirham");
        dict.put( "AFN" , "Afghan Afghani");
        dict.put( "ALL" , "Albanian Lek");
        dict.put( "AMD" , "Armenian Dram");
        dict.put( "ANG" , "Netherlands Antillean Guilder");
        dict.put( "AOA" , "Angolan Kwanza");
        dict.put( "ARS" , "Argentine Peso");
        dict.put( "AUD" , "Australian Dollar");
        dict.put( "AWG" , "Aruban Florin");
        dict.put( "AZN" , "Azerbaijani Manat");
        dict.put( "BAM" , "Bosnia-Herzegovina Convertible Mark");
        dict.put( "BBD" , "Barbadian Dollar");
        dict.put( "BDT" , "Bangladeshi Taka");
        dict.put( "BGN" , "Bulgarian Lev");
        dict.put( "BHD" , "Bahraini Dinar");
        dict.put( "BIF" , "Burundian Franc");
        dict.put( "BMD" , "Bermudan Dollar");
        dict.put( "BND" , "Brunei Dollar");
        dict.put( "BOB" , "Bolivian Boliviano");
        dict.put( "BRL" , "Brazilian Real");
        dict.put( "BSD" , "Bahamian Dollar");
        dict.put( "BTC" , "Bitcoin");
        dict.put( "BTN" , "Bhutanese Ngultrum");
        dict.put( "BWP" , "Botswanan Pula");
        dict.put( "BYN" , "New Belarusian Ruble");
        dict.put( "BYR" , "Belarusian Ruble");
        dict.put( "BZD" , "Belize Dollar");
        dict.put( "CAD" , "Canadian Dollar");
        dict.put( "CDF" , "Congolese Franc");
        dict.put( "CHF" , "Swiss Franc");
        dict.put( "CLF" , "Chilean Unit of Account (UF)");
        dict.put( "CLP" , "Chilean Peso");
        dict.put( "CNY" , "Chinese Yuan");
        dict.put( "COP" , "Colombian Peso");
        dict.put( "CRC" , "Costa Rican Colin");
        dict.put( "CUC" , "Cuban Convertible Peso");
        dict.put( "CUP" , "Cuban Peso");
        dict.put( "CVE" , "Cape Verdean Escudo");
        dict.put( "CZK" , "Czech Republic Koruna");
        dict.put( "DJF" , "Djiboutian Franc");
        dict.put( "DKK" , "Danish Krone");
        dict.put( "DOP" , "Dominican Peso");
        dict.put( "DZD" , "Algerian Dinar");
        dict.put( "EGP" , "Egyptian Pound");
        dict.put( "ERN" , "Eritrean Nakfa");
        dict.put( "ETB" , "Ethiopian Birr");
        dict.put( "EUR" , "Euro");
        dict.put( "FJD" , "Fijian Dollar");
        dict.put( "FKP" , "Falkland Islands Pound");
        dict.put( "GBP" , "British Pound Sterling");
        dict.put( "GEL" , "Georgian Lari");
        dict.put( "GGP" , "Guernsey Pound");
        dict.put( "GHS" , "Ghanaian Cedi");
        dict.put( "GIP" , "Gibraltar Pound");
        dict.put( "GMD" , "Gambian Dalasi");
        dict.put( "GNF" , "Guinean Franc");
        dict.put( "GTQ" , "Guatemalan Quetzal");
        dict.put( "GYD" , "Guyanaese Dollar");
        dict.put( "HKD" , "Hong Kong Dollar");
        dict.put( "HNL" , "Honduran Lempira");
        dict.put( "HRK" , "Croatian Kuna");
        dict.put( "HTG" , "Haitian Gourde");
        dict.put( "HUF" , "Hungarian Forint");
        dict.put( "IDR" , "Indonesian Rupiah");
        dict.put( "ILS" , "Israeli New Sheqel");
        dict.put( "IMP" , "Manx pound");
        dict.put( "INR" , "Indian Rupee");
        dict.put( "IQD" , "Iraqi Dinar");
        dict.put( "IRR" , "Iranian Rial");
        dict.put( "ISK" , "Icelandic Krina");
        dict.put( "JEP" , "Jersey Pound");
        dict.put( "JMD" , "Jamaican Dollar");
        dict.put( "JOD" , "Jordanian Dinar");
        dict.put( "JPY" , "Japanese Yen");
        dict.put( "KES" , "Kenyan Shilling");
        dict.put( "KGS" , "Kyrgystani Som");
        dict.put( "KHR" , "Cambodian Riel");
        dict.put( "KMF" , "Comorian Franc");
        dict.put( "KPW" , "North Korean Won");
        dict.put( "KRW" , "South Korean Won");
        dict.put( "KWD" , "Kuwaiti Dinar");
        dict.put( "KYD" , "Cayman Islands Dollar");
        dict.put( "KZT" , "Kazakhstani Tenge");
        dict.put( "LAK" , "Laotian Kip");
        dict.put( "LBP" , "Lebanese Pound");
        dict.put( "LKR" , "Sri Lankan Rupee");
        dict.put( "LRD" , "Liberian Dollar");
        dict.put( "LSL" , "Lesotho Loti");
        dict.put( "LTL" , "Lithuanian Litas");
        dict.put( "LVL" , "Latvian Lats");
        dict.put( "LYD" , "Libyan Dinar");
        dict.put( "MAD" , "Moroccan Dirham");
        dict.put( "MDL" , "Moldovan Leu");
        dict.put( "MGA" , "Malagasy Ariary");
        dict.put( "MKD" , "Macedonian Denar");
        dict.put( "MMK" , "Myanma Kyat");
        dict.put( "MNT" , "Mongolian Tugrik");
        dict.put( "MOP" , "Macanese Pataca");
        dict.put( "MRO" , "Mauritanian Ouguiya");
        dict.put( "MUR" , "Mauritian Rupee");
        dict.put( "MVR" , "Maldivian Rufiyaa");
        dict.put( "MWK" , "Malawian Kwacha");
        dict.put( "MXN" , "Mexican Peso");
        dict.put( "MYR" , "Malaysian Ringgit");
        dict.put( "MZN" , "Mozambican Metical");
        dict.put( "NAD" , "Namibian Dollar");
        dict.put( "NGN" , "Nigerian Naira");
        dict.put( "NIO" , "Nicaraguan Cirdoba");
        dict.put( "NOK" , "Norwegian Krone");
        dict.put( "NPR" , "Nepalese Rupee");
        dict.put( "NZD" , "New Zealand Dollar");
        dict.put( "OMR" , "Omani Rial");
        dict.put( "PAB" , "Panamanian Balboa");
        dict.put( "PEN" , "Peruvian Nuevo Sol");
        dict.put( "PGK" , "Papua New Guinean Kina");
        dict.put( "PHP" , "Philippine Peso");
        dict.put( "PKR" , "Pakistani Rupee");
        dict.put( "PLN" , "Polish Zloty");
        dict.put( "PYG" , "Paraguayan Guarani");
        dict.put( "QAR" , "Qatari Rial");
        dict.put( "RON" , "Romanian Leu");
        dict.put( "RSD" , "Serbian Dinar");
        dict.put( "RUB" , "Russian Ruble");
        dict.put( "RWF" , "Rwandan Franc");
        dict.put( "SAR" , "Saudi Riyal");
        dict.put( "SBD" , "Solomon Islands Dollar");
        dict.put( "SCR" , "Seychellois Rupee");
        dict.put( "SDG" , "Sudanese Pound");
        dict.put( "SEK" , "Swedish Krona");
        dict.put( "SGD" , "Singapore Dollar");
        dict.put( "SHP" , "Saint Helena Pound");
        dict.put( "SLE" , "Sierra Leonean Leone");
        dict.put( "SLL" , "Sierra Leonean Leone");
        dict.put( "SOS" , "Somali Shilling");
        dict.put( "SRD" , "Surinamese Dollar");
        dict.put( "STD" , "Sio Tomi and Principe Dobra");
        dict.put( "SVC" , "Salvadoran Colin");
        dict.put( "SYP" , "Syrian Pound");
        dict.put( "SZL" , "Swazi Lilangeni");
        dict.put( "THB" , "Thai Baht");
        dict.put( "TJS" , "Tajikistani Somoni");
        dict.put( "TMT" , "Turkmenistani Manat");
        dict.put( "TND" , "Tunisian Dinar");
        dict.put( "TOP" , "Tongan Paianga");
        dict.put( "TRY" , "Turkish Lira");
        dict.put( "TTD" , "Trinidad and Tobago Dollar");
        dict.put( "TWD" , "New Taiwan Dollar");
        dict.put( "TZS" , "Tanzanian Shilling");
        dict.put( "UAH" , "Ukrainian Hryvnia");
        dict.put( "UGX" , "Ugandan Shilling");
        dict.put( "USD" , "United States Dollar");
        dict.put( "UYU" , "Uruguayan Peso");
        dict.put( "UZS" , "Uzbekistan Som");
        dict.put( "VEF" , "Venezuelan Bolivar ");
        dict.put( "VES" , "Sovereign Bolivar");
        dict.put( "VND" , "Vietnamese Dong");
        dict.put( "VUV" , "Vanuatu Vatu");
        dict.put( "WST" , "Samoan Tala");
        dict.put( "XAF" , "CFA Franc BEAC");
        dict.put( "XAG" , "Silver (troy ounce)");
        dict.put( "XAU" , "Gold (troy ounce)");
        dict.put( "XCD" , "East Caribbean Dollar");
        dict.put( "XDR" , "Special Drawing Rights");
        dict.put( "XOF" , "CFA Franc BCEAO");
        dict.put( "XPF" , "CFP Franc");
        dict.put( "YER" , "Yemeni Rial");
        dict.put( "ZAR" , "South African Rand");
        dict.put( "ZMK" , "Zambian Kwacha");
        dict.put( "ZMW" , "Zambian Kwacha");
        dict.put( "ZWL","the Zimbabwean Dollar");





              search.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {

                    show.setText(dict.get(input.getText().toString()));


                }

            });







        convertFromDropdownTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fromDialog = new Dialog(MainActivity5.this);
                fromDialog.setContentView(R.layout.frome_spinner);
                fromDialog.getWindow().setLayout(560, 800);
                fromDialog.show();
                EditText editText = fromDialog.findViewById(R.id.edit_twxt);
                ListView listView = fromDialog.findViewById(R.id.list_view);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity5.this, android.R.layout.simple_list_item_1, arrayList);
                listView.setAdapter(adapter);

                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        adapter.getFilter().filter(charSequence);
                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }

                });
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        convertFromDropdownTextView.setText(adapter.getItem(i));
                        fromDialog.dismiss();
                        convertFromValue = adapter.getItem(i);
                    }
                });

            }
        });

        ConvertToDropdownTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toDialog = new Dialog(MainActivity5.this);
                toDialog.setContentView(R.layout.to_spinner);
                toDialog.getWindow().setLayout(650, 800);
                toDialog.show();
                EditText editText = toDialog.findViewById(R.id.edit_twxt);
                ListView listView = toDialog.findViewById(R.id.list_view);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity5.this, android.R.layout.simple_list_item_1, arrayList);
                listView.setAdapter(adapter);


                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        adapter.getFilter().filter(charSequence);
                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }

                });
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        ConvertToDropdownTextView.setText(adapter.getItem(i));
                        toDialog.dismiss();
                        ConvertToValue = adapter.getItem(i);
                    }
                });
            }
        });
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    Double amountToConvert = Double.valueOf(MainActivity5.this.amountToConvert.getText().toString());
                    getConversionRate(convertFromValue, ConvertToValue, amountToConvert);

                } catch (Exception e) {

                }
            }
        });
    }

    public String getConversionRate(String convertFrom, String convertTo, Double amountToConvert) {
        RequestQueue queue = Volley.newRequestQueue(this);
        // String url="https://free.currconv.com/api/v7/convert?q="+convertFrom+"_"+convertTo+"&compact=ultra&apiKey=22e91ab924eb2aa6f9a4";
       // String url = "https://api.freecurrencyapi.com/v1/latest?apikey=uTLksOkuxVf2AeKkgQ28OlYM15jGQgqpoi2hVMWD&currencies=" + convertTo + "&base_currency=" + convertFrom;
        String url="https://api.apilayer.com/exchangerates_data/latest?symbols="+convertTo+"&base="+convertFrom+"&apikey=HA7zcT00eprIM5I7bfOdzlZaFvgoy7cP";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
//                    Log.d("Testssss", response);
//                    String jsonString = "{\"data\":{\"USD\":2}}";
//                    JSONObject jsonObject = new JSONObject(response);
//                    JSONObject data = jsonObject.getJSONObject("data");
//                    Iterator<String> keys = data.keys();
//                    String key = keys.next();
//                        double value = data.getDouble(key);
//                        Double rate = (value);
//                        Double convertedAmount = round((rate * amountToConvert), 2);
//                        conversionRateText.setText(convertedAmount.toString());

                    JSONObject jsonObject = new JSONObject(response);
                    JSONObject rates = jsonObject.getJSONObject("rates");
                    double Value = rates.getDouble(convertTo);
                        Double rate = (Value);
                        Double convertedAmount = round((rate * amountToConvert), 2);
                        conversionRateText.setText(convertedAmount.toString());


//                    JSONObject jsonObject = new JSONObject(response);
//
//
//                    JSONObject data = jsonObject.getJSONObject("data");
//
//
//                    Map<String, JSONObject> map = (Map<String,JSONObject>)data;
//
//                    ArrayList<String> list = new ArrayList<String>(map.keySet());
//
//                   Log.d("Listsss", list.toString());




//                    Map.Entry<Object,Object>  entry = map.entrySet().iterator().next();
//
//                    Log.d("VALUEA", entry.getKey().toString());
//                    Log.d("VALUEB", entry.getValue().toString());


//                    Log.d("VALUEA", data[0]);

//                    Log.d("VALUEA", data[0]);
//                    Log.d("VALUEB", data[1]);

//                    Double conversionRateValue = round(((Double) jsonObject.get(convertTo)), 2);
//                    conversionValue = "" + round((conversionRateValue * amountToConvert), 2);
//                    conversionRateText.setText(conversionValue);

//                    Log.d("Testssss", conversionValue);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(stringRequest);
        return null;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();


    }





}