package com.example.aqifkhattak.googlemap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class recycleView extends AppCompatActivity {
RecyclerView recyclerView;
List<model> main_list;
RecyclerView.Adapter adapter;
Button order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        main_list = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        main_list.add(new model(R.drawable.ice,"Price 5$","Ice cream is a sweetened frozen food typically eaten as a snack or dessert. It may be made from dairy milk or cream, or soy, cashew..., "));
        main_list.add(new model(R.drawable.faloda,"Price 5$","mango falooda recipe with step by step photos. quick, easy and delicious mango falooda recipe with fresh mango puree, chopped mangoes and mango ice cream..., "));
        main_list.add(new model(R.drawable.chips,"Price 5$","Fries are a brand of par-fried frozen French fries that are made from 100% natural potato! Opa! can be found in the freezer section at most major grocery stores..., "));
        main_list.add(new model(R.drawable.fish,"Price 5$","This Lahori Tawa Tali Machchli recipe is Excellent and find more Great recipes, ... About Lahori Tawa Tali Machchli: Fish fillet pieces dipped in creamy mixture of ..., "));
        main_list.add(new model(R.drawable.fri,"Price 5$","  I always serve this amazing fried rice with all of my chinese dishes. It is easy and goes perfectly as a side. You can add whatever you would like! online"));
        main_list.add(new model(R.drawable.neww,"Price 5$","Chicken Biryani is a delicious savory rice dish that is loaded with spicy marinated chicken, caramelized onions, and flavorful saffron rice. For my Biryani, "));
        main_list.add(new model(R.drawable.chi,"Price 5$","Pakistan is known for many famous recipes that are eaten all over the country with great delight, and the chicken karahi recipe by sooperchef, the largest online"));
        adapter= new customAdpter(main_list,getApplicationContext());
        recyclerView.setAdapter(adapter);

    }
}
