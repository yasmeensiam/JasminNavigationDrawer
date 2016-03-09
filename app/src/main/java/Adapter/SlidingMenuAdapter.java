package Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yasmeen.jasminnavigationdrawer.R;

import java.util.ArrayList;

import Model.ItemSlideMenu;

/**
 * Created by yasmeen on 3/8/2016.
 */
public class SlidingMenuAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ItemSlideMenu> itemSlideMenuListView;


    public SlidingMenuAdapter(Context context, ArrayList<ItemSlideMenu> itemSlideMenuListView) {
        this.context = context;
        this.itemSlideMenuListView = itemSlideMenuListView;
    }

    @Override
    public int getCount() {
        return itemSlideMenuListView.size();
    }

    @Override
    public Object getItem(int position) {
        return itemSlideMenuListView.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(context, R.layout.item_sliding_menu, null);
        ImageView imageView_item = (ImageView) view.findViewById(R.id.item_imageView);
        TextView textView_item = (TextView) view.findViewById(R.id.item_title);
        ItemSlideMenu itemSlideMenu = itemSlideMenuListView.get(position);
        imageView_item.setImageResource(itemSlideMenu.getId_image());
        textView_item.setText(itemSlideMenu.getTitle());
        return view;
    }
}
