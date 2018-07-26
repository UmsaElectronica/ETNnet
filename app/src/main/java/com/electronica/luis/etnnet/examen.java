package com.electronica.luis.etnnet;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.electronica.luis.etnnet.R;
import com.github.snowdream.android.widget.SmartImageView;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by LUIS on 15/01/2018.
 */
public class examen extends Fragment  {
    private ListView listview;

    ArrayList materia=new ArrayList();
    ArrayList sigla=new ArrayList();
    ArrayList tipo=new ArrayList();
    ArrayList fecha=new ArrayList();
    ArrayList autor=new ArrayList();
    ArrayList imagen=new ArrayList();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.examen,container,false);
        listview=(ListView)v.findViewById(R.id.examenlist);
        descargarimagen();
        return v;
    }
    private void descargarimagen(){
        materia.clear();
        sigla.clear();
        tipo.clear();
        fecha.clear();
        autor.clear();
        imagen.clear();

        final ProgressDialog progressDialog=new ProgressDialog(getActivity());
        progressDialog.setMessage("Cargando Datos...");
        progressDialog.show();

        AsyncHttpClient cliente=new AsyncHttpClient();
        final String sem=getArguments().getString("semestre");
        cliente.get("http://www.electronica.umsa.bo/sistcomunicados/webservices/examenes.php?x="+sem, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200) {
                    progressDialog.dismiss();
                    try {
                        JSONArray jsonArray=new JSONArray(new String(responseBody));
                        for(int i=0;i<jsonArray.length();i++){
                            materia.add(jsonArray.getJSONObject(i).getString("materia"));
                            sigla.add(jsonArray.getJSONObject(i).getString("sigla"));
                            tipo.add(jsonArray.getJSONObject(i).getString("tipo"));
                            fecha.add(jsonArray.getJSONObject(i).getString("fecha"));
                            autor.add(jsonArray.getJSONObject(i).getString("autor"));
                            imagen.add(jsonArray.getJSONObject(i).getString("imagen"));
                        }

                        listview.setAdapter(new ImagenAdapter(getContext()));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

    }
    private class ImagenAdapter extends BaseAdapter {
        Context ctx;
        LayoutInflater layoutInflater;
        SmartImageView smartImageView;
        TextView tv1,tv2,tv3,tv4,tv5;


        public ImagenAdapter(Context context) {
            this.ctx=context;
            layoutInflater=(LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        @Override
        public int getCount() {
            return imagen.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewGroup viewGroup=(ViewGroup)layoutInflater.inflate(R.layout.vista,null);
            smartImageView=(SmartImageView)viewGroup.findViewById(R.id.imagenclase);
            tv1=(TextView)viewGroup.findViewById(R.id.tv1);
            tv2=(TextView)viewGroup.findViewById(R.id.tv2);

            final String Urlfinal="http://www.electronica.umsa.bo/sistcomunicados/comunicados/"+imagen.get(position).toString();
            Rect rect=new Rect(smartImageView.getLeft(),smartImageView.getTop(),smartImageView.getRight(),smartImageView.getBottom());
            smartImageView.setImageUrl(Urlfinal,rect);
            smartImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(getContext(),ImagenActivity.class);
                    i.putExtra("url",Urlfinal);
                    startActivity(i);
                }
            });
            tv1.setText(sigla.get(position).toString());
            tv2.setText("Fecha final de Publicación:"+fecha.get(position).toString());

            return viewGroup;
        }
    }
}
