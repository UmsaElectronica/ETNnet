package com.electronica.luis.etnnet;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.electronica.luis.etnnet.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by LUIS on 26/02/2018.
 */
public class documentos extends Fragment {
    private ListView listview;

    ArrayList materia=new ArrayList();
    ArrayList titulo=new ArrayList();
    ArrayList fecha=new ArrayList();
    ArrayList imagen=new ArrayList();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.documentos,container,false);
        listview=(ListView)v.findViewById(R.id.documentoslist);
        descargarimagen();
        return v;
    }
    private void descargarimagen(){
        materia.clear();
        titulo.clear();
        fecha.clear();
        imagen.clear();

        final ProgressDialog progressDialog=new ProgressDialog(getActivity());
        progressDialog.setMessage("Cargando Datos...");
        progressDialog.show();

        AsyncHttpClient cliente=new AsyncHttpClient();
        final String sem=getArguments().getString("semestre");
        cliente.get("http://www.electronica.umsa.bo/sistcomunicados/webservices/documentos.php?x="+sem, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200) {
                    progressDialog.dismiss();
                    try {
                        JSONArray jsonArray=new JSONArray(new String(responseBody));
                        for(int i=0;i<jsonArray.length();i++){
                            materia.add(jsonArray.getJSONObject(i).getString("sigla"));
                            titulo.add(jsonArray.getJSONObject(i).getString("titulo"));
                            fecha.add(jsonArray.getJSONObject(i).getString("fecha"));
                            imagen.add(jsonArray.getJSONObject(i).getString("archivo"));
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
        TextView tvmateria,tvtitulo,tvarchivo,tvfecha;
        ImageButton btndescarga;
        DownloadManager downloadManager;


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

            final ViewGroup viewGroup=(ViewGroup)layoutInflater.inflate(R.layout.vista1,null);
            btndescarga=(ImageButton)viewGroup.findViewById(R.id.imageButton13);
            tvmateria=(TextView)viewGroup.findViewById(R.id.tvdmateria);
            tvtitulo=(TextView)viewGroup.findViewById(R.id.tvdtitulo);
            tvarchivo=(TextView)viewGroup.findViewById(R.id.tvdarchivo);
            tvfecha=(TextView)viewGroup.findViewById(R.id.tvdfecha);


            final String Urlfinal="http://www.electronica.umsa.bo/sistcomunicados/comunicados/"+imagen.get(position).toString();
            final String arq=imagen.get(position).toString();

            tvmateria.setText(materia.get(position).toString());
            tvtitulo.setText(titulo.get(position).toString());
            tvarchivo.setText("Archivo:"+imagen.get(position).toString());
            tvfecha.setText("Fecha Final de Publicaion:"+fecha.get(position).toString());
            btndescarga.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    downloadManager = (DownloadManager)ctx.getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri = Uri.parse(Urlfinal);
                    DownloadManager.Request request= new DownloadManager.Request(uri);
                    request.setDestinationInExternalPublicDir("/ETNnet",arq);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference=downloadManager.enqueue(request);
                }
            });
            return viewGroup;
        }

    }
}
