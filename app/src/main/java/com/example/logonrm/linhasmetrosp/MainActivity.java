package com.example.logonrm.linhasmetrosp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.logonrm.linhasmetrosp.adapter.LinhasAdapter;
import com.example.logonrm.linhasmetrosp.api.APIUtils;
import com.example.logonrm.linhasmetrosp.api.MetroAPI;
import com.example.logonrm.linhasmetrosp.model.LinhasMetro;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinhasAdapter linhasAdapter;
    private MetroAPI metroAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        linhasAdapter = new LinhasAdapter(new ArrayList<LinhasMetro>());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(linhasAdapter);
        recyclerView.setHasFixedSize(true);

//        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
//        recyclerView.addItemDecoration(itemDecoration);

        carregarDados();
    }

    private void carregarDados() {

        metroAPI = APIUtils.getAndroidApiService();

        metroAPI.getLinhas().enqueue(new Callback<List<LinhasMetro>>() {
            @Override
            public void onResponse(Call<List<LinhasMetro>> call, Response<List<LinhasMetro>> response) {
                if (response.isSuccessful()){
                    linhasAdapter.update(response.body());
                    recyclerView.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<LinhasMetro>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Deu ruim",Toast.LENGTH_LONG).show();
                recyclerView.setVisibility(View.VISIBLE);
            }
        });

    }

}
