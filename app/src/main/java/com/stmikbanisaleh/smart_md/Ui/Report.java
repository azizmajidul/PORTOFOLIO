package com.stmikbanisaleh.smart_md.Ui;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.stmikbanisaleh.smart_md.Login;
import com.stmikbanisaleh.smart_md.MainActivity;
import com.stmikbanisaleh.smart_md.Model_Ok.Report.PostReport;
import com.stmikbanisaleh.smart_md.R;
import com.stmikbanisaleh.smart_md.Ui.History.Coba;
import com.stmikbanisaleh.smart_md.remote_access.API;
import com.stmikbanisaleh.smart_md.remote_access.RetrofitClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Report extends AppCompatActivity {
    private RetrofitClient retrofitClient;
    private PostReport postReport;
    private RadioButton Price_Card, Fifo, Plano, Promosi;
    private ProgressDialog progress;

//    inisialisasi form
    private EditText User ,Toko, Produk, Kategori, Stock, FacingProduk, Normal_Price, Promo_Price, fifo_product, harga, listing, is_promo;
    private Button buttonSave, buttonHome;
    ImageView image_view;
    private Spinner sp_fifo, sp_verify;
    private API api;
    String productId, productName, category_id;
    String store_id, store_name, id_toko, user;
    TextView product_name;
    EditText product_id,txttoko_id,  id_category, user_id;
    TextView textStore_id, textStore_Name ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        id_toko = getIntent().getStringExtra("id_toko");
        txttoko_id = findViewById(R.id.txttoko_id);
        txttoko_id.setText(id_toko);
        //      store id
        store_id = getIntent().getStringExtra("store_id");
        store_name = getIntent().getStringExtra("store_name");
        textStore_id = findViewById(R.id.textStore_id);
        textStore_Name = findViewById(R.id.textStore_Name);
//
//store Name
        textStore_id.setText(store_id);
        textStore_Name.setText(store_name);
//        product name
        productName = getIntent().getStringExtra("product_name");
        product_name = findViewById(R.id.product_name);
        product_name.setText(productName);

//        product id
        productId = getIntent().getStringExtra("product_id");
        product_id = findViewById(R.id.id_product);
        product_id.setText(productId);
//category id

        category_id = getIntent().getStringExtra("category_id");
        id_category = findViewById(R.id.id_category);
        id_category.setText(category_id);
//        user id
        user = getIntent().getStringExtra("id");
        user_id = findViewById(R.id.user_id);
        user_id.setText(user);
//Inisialisasi form
        User = (EditText) findViewById(R.id.user_id);
        Toko = (EditText) findViewById(R.id.txttoko_id);
        Produk = (EditText) findViewById(R.id.id_product);
        Kategori = (EditText) findViewById(R.id.id_category);
        Stock = (EditText) findViewById(R.id.stock);
        FacingProduk = (EditText) findViewById(R.id.facing);
        Normal_Price = (EditText) findViewById(R.id.normal_price);
        Promo_Price = (EditText) findViewById(R.id.promo_price);
//        fifo_product = (EditText) findViewById(R.id.product_fifo);
        harga  = (EditText) findViewById(R.id.price);
        listing =  (EditText) findViewById(R.id.plano);
        is_promo = (EditText) findViewById(R.id.promotion);
        sp_fifo = (Spinner) findViewById(R.id.sp_fifo);
        sp_verify = (Spinner) findViewById(R.id.sp_verify);
        buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonHome = (Button) findViewById(R.id.buttonCancel);
      getSupportActionBar().setTitle(Html.fromHtml("<font color=\"#fffffff\">" + getString(R.string.audit_label) + "</font>"));
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Report.this)
                        .setMessage("Are you sure to send data?")
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {dialog.dismiss();

                            }
                        })
                        .setPositiveButton("Send", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                actionAdd();
                            }
                        });
                AlertDialog dialog= builder.create();
                dialog.show();
            }
        });

        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Report.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void actionAdd(){
        String UserId = User.getText().toString().trim();
        String StoreId = Toko.getText().toString().trim();
        String ProductId = Produk.getText().toString().trim();
        String CategoryId = Kategori.getText().toString().trim();
        String Quantity = Stock.getText().toString().trim();
        String Facing = FacingProduk.getText().toString().trim();
        String NormalPrice = Normal_Price.getText().toString().trim();
        String PromoPrice = Promo_Price.getText().toString().trim();
        String fifo = sp_fifo.getSelectedItem().toString().trim();
        String price = harga.getText().toString().trim();
        String plano = listing.getText().toString().trim();
        String promo = is_promo.getText().toString().trim();
        String verify = sp_verify.getSelectedItem().toString().trim();

//        validasi
        if(Quantity.isEmpty()){
            Stock.setError("Please Enter Stock");
            Stock.requestFocus();
            return;
        }
        if(Facing.isEmpty()){
            FacingProduk.setError("Please Enter Facing");
            FacingProduk.requestFocus();
            return;
        }
        if(NormalPrice.isEmpty()){
            Normal_Price.setError("Please Enter Normal Price");
            Normal_Price.requestFocus();
            return;
        }

        if(fifo.isEmpty()){
            fifo_product.setError("Please Enter Fifo");
            fifo_product.requestFocus();
            return;
        }
        if(plano.isEmpty()){
            listing.setError("Please Enter Plano");
            listing.requestFocus();
            return;
        }
        if(promo.isEmpty()){
            is_promo.setError("Please Enter Promotion");
            is_promo.requestFocus();
            return;
        }

        Call<ResponseBody> call = RetrofitClient.getInstance().getApi().InsertDataReport(
                UserId, StoreId,ProductId,CategoryId, Quantity , Facing,price, fifo, NormalPrice,PromoPrice  , plano, promo,verify);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                Toast.makeText(Report.this, "Add data Success!", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Report.this, ListViewProduct.class);
////                intent.putExtra("id",txttoko_id.getText().toString() );
//                startActivity(intent);
//                finish();
                showDialog();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(Report.this, "Add data Faile Plase Chek Your Connection!", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private  void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setMessage("Suuces Add Data to Database !")

                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                        Intent intent = new Intent(Report.this, ListViewProduct.class);
                        startActivity(intent);
                        finish();
                    }
                });
        AlertDialog dialog= builder.create();
        dialog.show();

    }
}