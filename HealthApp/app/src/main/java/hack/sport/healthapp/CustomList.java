package hack.sport.healthapp;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class CustomList extends ArrayAdapter<String> {

    private final Activity context;
    public static final List<String> userName = new ArrayList<>();
    public static final List<String> profilePic = new ArrayList<>();

    public CustomList(Activity context, String user, String profile) {
        super(context, R.layout.activity_custom_list);
        this.context = context;
        userName.add(user);
        profilePic.add(profile);
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.activity_custom_list, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtTitle.setText(userName.get(position));

        imageView.setImageURI(Uri.parse(profilePic.get(position)));
        return rowView;
    }
}
