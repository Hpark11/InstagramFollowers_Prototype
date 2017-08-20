package hpark.instagramfollowers_prototype.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import hpark.instagramfollowers_prototype.R;
import hpark.instagramfollowers_prototype.model.ShareGroupItem;

/**
 * Created by hpark_ipl on 2017. 8. 12..
 */

public class ShareGroupAdapter extends BaseAdapter {
    private ArrayList<ShareGroupItem> shareGroups;
    private LayoutInflater inflater;
    private Context context;

    public ShareGroupAdapter(Context context, ArrayList<ShareGroupItem> shareGroups) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.shareGroups = shareGroups;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.inflator_share_group, null);

        final Holder holder = new Holder();

        holder.shareGroupNameTextView = (TextView) view.findViewById(R.id.shareGroupNameTextView);
        holder.shareGroupUsersInfoTextView = (TextView) view.findViewById(R.id.shareGroupUsersInfoTextView);
        holder.shareGroupDetailButton = (Button) view.findViewById(R.id.shareGroupDetailButton);
        holder.shareGroupDetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        String shareGroupUsersInfo = "";
        ArrayList<String> infoList = shareGroups.get(position).getShareGroupUsersInfoList();
        for (int i = 0; i < infoList.size(); i++) {
            String[] sep = infoList.get(i).split("|");
            shareGroupUsersInfo += sep[1];

            if (i != infoList.size() - 1) {
                shareGroupUsersInfo += ", ";
            }
        }

        holder.shareGroupNameTextView.setText(shareGroups.get(position).getShareGroupName());
        holder.shareGroupUsersInfoTextView.setText(shareGroupUsersInfo);
        return view;
    }

    private class Holder {
        private TextView shareGroupNameTextView;
        private TextView shareGroupUsersInfoTextView;
        private Button shareGroupDetailButton;
    }
}
